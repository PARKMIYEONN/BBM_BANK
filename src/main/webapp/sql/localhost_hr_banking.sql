DROP TABLE   B_USER_INFO  ;

CREATE TABLE   B_USER_INFO   (
	  USER_ID  	VARCHAR2(20)		NOT NULL,
	  USER_PASSWORD  	VARCHAR2(16)		NOT NULL,
	  USER_NAME  	VARCHAR2(100)		NOT NULL,
	  USER_EMAIL  	VARCHAR2(100)		NOT NULL,
	  USER_BIRTHDAY  	VARCHAR2(8)		NOT NULL,
	  GENDER  	NUMBER		NOT NULL,
	  USER_TEL  	VARCHAR2(13)		NOT NULL,
	  USER_POST  	VARCHAR2(15)		NOT NULL,
	  USER_ADDRESS  	CLOB		NOT NULL
);

DROP TABLE   B_POSTS  ;

CREATE TABLE   B_POSTS   (
	  POST_NO  	NUMBER		NOT NULL,
	  USER_ID  	VARCHAR2(20)		NOT NULL,
	  CONTENT  	CLOB		NOT NULL,
	  POST_REG_DATE  	DATE	DEFAULT SYSDATE	NOT NULL,
	  POST_TITLE  	VARCHAR2(100)		NOT NULL,
	  POST_PERMISSION  	NUMBER		NOT NULL,
	  POST_HIT  	NUMBER		NOT NULL
);

DROP TABLE   B_PRODUCTS  ;

CREATE TABLE   B_PRODUCTS   (
	  PRODUCT_NAME  	VARCHAR2(100)		NOT NULL,
	  PRODUCT_TYPE  	VARCHAR2(10)		NOT NULL,
	  RELEASE_DATE  	DATE	DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD')	NOT NULL,
	  END_DATE  	DATE		NOT NULL,
	  PRODUCT_RATE  	NUMBER		NOT NULL
);

DROP TABLE   B_ACCOUNT  ;

CREATE TABLE   B_ACCOUNT   (
	  ACC_NO  	VARCHAR2(50)		NOT NULL,
	  USER_ID  	VARCHAR2(20)		NOT NULL,
	  PRODUCT_NAME  	VARCHAR2(100)		NOT NULL,
	  BANK_CD  	VARCHAR2(20)		NOT NULL,
	  ACC_TYPE  	VARCHAR2(100)		NOT NULL,
	  DORMANT_ACC  	NUMBER(1)	DEFAULT 0	NOT NULL,
	  BALANCE  	NUMBER		NOT NULL,
	  ACC_CREATED_DATE  	DATE	DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD')	NOT NULL,
	  ACC_PASSWORD  	VARCHAR2(6)		NOT NULL
);

DROP TABLE   B_COMMENTS  ;

CREATE TABLE   B_COMMENTS   (
	  COMMENT_NO  	VARCHAR(255)		NOT NULL,
	  POST_NO  	NUMBER		NOT NULL,
	  USER_ID  	VARCHAR2(20)		NOT NULL,
	  COMMENTS  	VARCHAR(255)		NOT NULL,
	  CMT_REG_DATE  	DATE	DEFAULT SYSDATE	NOT NULL
);

DROP TABLE   B_kakao_USER  ;

CREATE TABLE   B_kakao_USER   (
	  kakao_TOKEN  	VARCHAR2(200)		NOT NULL,
	  USER_ID  	VARCHAR2(20)		NOT NULL
);

DROP TABLE   B_TRANSACTION  ;

CREATE TABLE   B_TRANSACTION   (
	  T_CD  	NUMBER		NOT NULL,
	  ACC_NO  	VARCHAR2(50)		NOT NULL,
	  T_DATE  	timestamp	DEFAULT current_timestamp	NOT NULL,
	  T_TYPE  	VARCHAR2(10)		NOT NULL,
	  T_AMOUNT  	NUMBER		NOT NULL,
	  T_INFO  	CLOB		NOT NULL,
	  BANK_CD  	VARCHAR2(20)		NOT NULL,
         deposit_bank_cd varchar2(20) not null
);

DROP TABLE   BANK_INFO  ;

CREATE TABLE   BANK_INFO   (
	  BANK_CD  	VARCHAR2(20)		NOT NULL,
	  BANK_NM  	VARCHAR2(100)		NOT NULL
);

ALTER TABLE   B_USER_INFO   ADD CONSTRAINT   PK_B_USER_INFO   PRIMARY KEY (
	  USER_ID  
);

ALTER TABLE   B_POSTS   ADD CONSTRAINT   PK_B_POSTS   PRIMARY KEY (
	  POST_NO  
);

ALTER TABLE   B_PRODUCTS   ADD CONSTRAINT   PK_B_PRODUCTS   PRIMARY KEY (
	  PRODUCT_NAME  
);

ALTER TABLE   B_ACCOUNT   ADD CONSTRAINT   PK_B_ACCOUNT   PRIMARY KEY (
	  ACC_NO  
);

ALTER TABLE   B_COMMENTS   ADD CONSTRAINT   PK_B_COMMENTS   PRIMARY KEY (
	  COMMENT_NO  
);

ALTER TABLE   B_kakao_USER   ADD CONSTRAINT   PK_B_KAKAO_USER   PRIMARY KEY (
	  kakao_TOKEN  
);

ALTER TABLE   B_TRANSACTION   ADD CONSTRAINT   PK_B_TRANSACTION   PRIMARY KEY (
	  T_CD  
);

ALTER TABLE   BANK_INFO   ADD CONSTRAINT   PK_BANK_INFO   PRIMARY KEY (
	  BANK_CD  
);

ALTER TABLE   B_POSTS   ADD CONSTRAINT   FK_B_USER_INFO_TO_B_POSTS_1   FOREIGN KEY (
	  USER_ID  
)
REFERENCES   B_USER_INFO   (
	  USER_ID  
);

ALTER TABLE   B_ACCOUNT   ADD CONSTRAINT   FK_B_USER_INFO_TO_B_ACCOUNT_1   FOREIGN KEY (
	  USER_ID  
)
REFERENCES   B_USER_INFO   (
	  USER_ID  
);

ALTER TABLE   B_ACCOUNT   ADD CONSTRAINT   FK_B_PRODUCTS_TO_B_ACCOUNT_1   FOREIGN KEY (
	  PRODUCT_NAME  
)
REFERENCES   B_PRODUCTS   (
	  PRODUCT_NAME  
);

ALTER TABLE   B_ACCOUNT   ADD CONSTRAINT   FK_BANK_INFO_TO_B_ACCOUNT_1   FOREIGN KEY (
	  BANK_CD  
)
REFERENCES   BANK_INFO   (
	  BANK_CD  
);

ALTER TABLE   B_COMMENTS   ADD CONSTRAINT   FK_B_POSTS_TO_B_COMMENTS_1   FOREIGN KEY (
	  POST_NO  
)
REFERENCES   B_POSTS   (
	  POST_NO  
);

ALTER TABLE   B_COMMENTS   ADD CONSTRAINT   FK_B_USER_INFO_TO_B_COMMENTS_1   FOREIGN KEY (
	  USER_ID  
)
REFERENCES   B_USER_INFO   (
	  USER_ID  
);

ALTER TABLE   B_kakao_USER   ADD CONSTRAINT   FK_B_USER_INFO_TO_B_kakao_USER_1   FOREIGN KEY (
	  USER_ID  
)
REFERENCES   B_USER_INFO   (
	  USER_ID  
);

ALTER TABLE   B_TRANSACTION   ADD CONSTRAINT   FK_B_ACCOUNT_TO_B_TRANSACTION_1   FOREIGN KEY (
	  ACC_NO  
)
REFERENCES   B_ACCOUNT   (
	  ACC_NO  
);

ALTER TABLE   B_TRANSACTION   ADD CONSTRAINT   FK_BANK_INFO_TO_B_TRANSACTION_1   FOREIGN KEY (
	  BANK_CD  
)
REFERENCES   BANK_INFO   (
	  BANK_CD  
);

select * from b_user_info;

select * from b_posts;

DROP SEQUENCE sequence_postNo;

CREATE SEQUENCE sequence_postNo nocache;

DROP SEQUENCE sequence_TransNO;

CREATE SEQUENCE sequence_TransNO nocache;

alter table b_products modify (end_date null);



select * from b_products;

select * from b_account;
select * from b_transaction;

ALTER TABLE b_transaction
ADD deposit_account VARCHAR(50);

select * from b_transaction where acc_no = '18752936' or deposit_account = '18752936';


insert into bank_info (bank_cd, bank_nm) values('0504', 'eziÀºÇà');
insert into bank_info (bank_cd, bank_nm) values('1003', 'BBMÀºÇà');
insert into bank_info (bank_cd, bank_nm) values('0413', 'BjBank');
insert into bank_info (bank_cd, bank_nm) values('9999', 'KKPÀºÇà');

update bank_info set bank_cd = '0413' where bank_nm = 'BjBank';

CREATE OR REPLACE PROCEDURE transfer (
  sender_account_number IN b_account.acc_no%TYPE, 
  receiver_account_number IN b_account.acc_no%TYPE, 
  transfer_amount IN NUMBER) AS
  sender_balance NUMBER;
  receiver_balance NUMBER;
BEGIN
  -- º¸³»´Â °èÁÂÀÇ ÀÜ¾× È®ÀÎ
  SELECT balance INTO sender_balance 
  FROM b_account 
  WHERE acc_no = sender_account_number;
  
  -- ¹Þ´Â °èÁÂÀÇ ÀÜ¾× È®ÀÎ
  SELECT balance INTO receiver_balance 
  FROM b_account 
  WHERE acc_no = receiver_account_number;
  
  -- º¸³»´Â °èÁÂÀÇ ÀÜ¾×ÀÌ ÃæºÐÇÑÁö È®ÀÎ
  IF sender_balance >= transfer_amount THEN
    -- º¸³»´Â °èÁÂ¿¡¼­ µ·À» »©°í
    UPDATE b_account
    SET balance = balance - transfer_amount
    WHERE acc_no = sender_account_number;
    
    -- ¹Þ´Â °èÁÂ¿¡ µ·À» Ãß°¡
    UPDATE b_account
    SET balance = balance + transfer_amount
    WHERE acc_no = receiver_account_number;
  ELSE
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END;
/





select * from bank_info;


CREATE OR REPLACE PROCEDURE transfer_BJ (
  sender_account_number IN b_account.acc_no%TYPE, 
  receiver_account_number IN account.account_id @BjBank%TYPE, 
  transfer_amount IN NUMBER) AS
  sender_balance NUMBER;
  receiver_balance NUMBER;
BEGIN
  -- º¸³»´Â °èÁÂÀÇ ÀÜ¾× È®ÀÎ
  SELECT balance INTO sender_balance 
  FROM b_account 
  WHERE acc_no = sender_account_number;
  
  -- ¹Þ´Â °èÁÂÀÇ ÀÜ¾× È®ÀÎ
  SELECT account_bl INTO receiver_balance 
  FROM account@BjBank 
  WHERE account_id = receiver_account_number;
  
  -- º¸³»´Â °èÁÂÀÇ ÀÜ¾×ÀÌ ÃæºÐÇÑÁö È®ÀÎ
  IF sender_balance >= transfer_amount THEN
    -- º¸³»´Â °èÁÂ¿¡¼­ µ·À» »©°í
    UPDATE b_account
    SET balance = balance - transfer_amount
    WHERE acc_no = sender_account_number;
    
    -- ¹Þ´Â °èÁÂ¿¡ µ·À» Ãß°¡
    UPDATE account@BjBank
    SET account_bl = account_bl + transfer_amount
    WHERE account_id = receiver_account_number;
  ELSE
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END;
/

BEGIN
  transfer_otherBank('85913260', '202306280018', 1000);
  COMMIT;
END;





CREATE DATABASE LINK BjBank
 CONNECT TO hr
 IDENTIFIED BY hr
 USING
'(DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 172.31.9.168)(PORT = 1521))
      (CONNECT_DATA =
        (SERVER = DEDICATED)
        (SERVICE_NAME = xe))
)';

CREATE DATABASE LINK eziBank
 CONNECT TO hr
 IDENTIFIED BY hr
 USING
'(DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 172.31.9.171)(PORT = 1521))
      (CONNECT_DATA =
        (SERVER = DEDICATED)
        (SERVICE_NAME = xe))
)';

CREATE DATABASE LINK KKPBank
 CONNECT TO hr
 IDENTIFIED BY hr
 USING
'(DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 172.31.9.180)(PORT = 1521))
      (CONNECT_DATA =
        (SERVER = DEDICATED)
        (SERVICE_NAME = xe))
)';
select * from b_user_info;

select * from member @BjBank;
select * from product @BjBank;
select * from account @BjBank;
select * from account @KKPBank;
select * from account @eziBank;

select * from history @BjBank;

select ui.user_name, a.acc_no from b_account a join b_user_info ui on a.user_id = ui.user_id where acc_no = ?

ALTER TABLE b_user_info
ADD is_open_banking NUMBER(1) DEFAULT 0 NOT NULL;

SELECT ui.USER_NAME, t.T_CD, t.ACC_NO, t.t_date,t.T_AMOUNT, t.T_INFO,
       TO_CHAR(t.t_date, 'YYYY-MM-DD HH24:MI:SS') AS t_date
FROM B_USER_INFO ui
JOIN B_ACCOUNT a ON ui.USER_ID = a.USER_ID
JOIN B_TRANSACTION t ON a.ACC_NO = t.ACC_NO
where t.DEPOSIT_ACCOUNT = '18653972' or t.acc_no = '18653972';

select * from b_transaction where acc_no = '28195704';

SELECT ui.USER_NAME
FROM B_USER_INFO ui
JOIN B_ACCOUNT a ON ui.USER_ID = a.USER_ID
where a.acc_no = '18653972';

ALTER TABLE b_transaction
modify t_pre_balance default 0; 

select ui.user_name, ui.user_email, replace(ui.user_birthday, '/', '') as birthday, ui.user_tel, a.acc_password
from b_user_info ui
join b_account a on ui.user_id = a.user_id
where a.acc_no = '18653972';

select * from b_account;

update b_account set dormant_acc = '1' where acc_no = '28195704';




commit;







