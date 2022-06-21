/*
MySQL Server Name: RenMySQLServer
Port: 3310
Management User: root
password: 1qaz@WSXRen9527

Classic MySQL protocol connections to InnoDB cluster:
Read/Write: 6446
Read Only : 6447

MySQL X protocol connections to InnoDB cluster:
Read/Write: 6448
Read Only : 6449
*/

-- 刪除 database
Drop database IF EXISTS renwebsite;
-- 刪除 Table 
Drop TABLE IF EXISTS MEMBER;
-- 顯示現有database
show databases;


-- Create a New DataBase, "IF NOT EXISTS" is Check DataBase Exists, if false MySQL Throw Exception.	
Create DATABASE IF NOT EXISTS RenWebsite
-- UTF8MB4 代表一個字元 4 Byte.
CHARACTER SET utf8mb4
-- 使用最新的UTF8編碼
COLLATE utf8mb4_unicode_520_ci;


-- 建立 會員(MEMBER) TABLE
Create table IF NOT EXISTS MEMBER (
	UUID bigint auto_increment not null PRIMARY KEY COMMENT "唯一自增鍵,尚未考慮主鍵問題.",
	id varchar(16) not null UNIQUE COMMENT "User Accoud or login Account, Not Null & Only(UNIQUE)",
    pwd varchar(30) not null COMMENT "User Password, Not Null",
    permission int not null COMMENT "User Permission, 0: NON-MEMBER; 1: NORMAL MEMBER; 99: Admin; etc... ",
    email varchar(50) null DEFAULT null COMMENT "USER EMAIL, Use for Permission, And send some Messages for User OR Administrator.",
    failedCNT int not null DEFAULT 0 COMMENT "User login Faild Count, If Maxing Count More than '5', Pause the User login permission.",
    remark varchar(50) null COMMENT "Write Somthing there."
);
-- Insert MEMBER Data, The First Is Administrator Account, Other Is Visitor.
insert into MEMBER (ID, PWD, PERMISSION, EMAIL, REMARK)
	values ("administrator", "1qaz@WSX", "99", "test@gmail.com", "This Is Administrator Account");
insert into MEMBER(ID, PWD, PERMISSION, EMAIL, REMARK)
	values ("user1", "user1", "1", "user1@gmail.com", "This test user account, permission is one(1).");
insert into MEMBER(ID, PWD, PERMISSION, EMAIL, REMARK)
	values ("user0", "user0", "0", "", "This test user account, permission is zero(0)");
    
select * from MEMBER;


