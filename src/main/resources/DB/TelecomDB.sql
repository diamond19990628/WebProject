CREATE DATABASE IF NOT EXISTS telecomDB DEFAULT CHARACTER SET utf8mb4;
USE telecomDB;

CREATE TABLE useradmini (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    leve VARCHAR(30) NOT NULL,
    telep VARCHAR(20) NOT NULL,
    status VARCHAR(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 初始管理员账号：admin / 123456（密码为 MD5+Base64，与 PasswordMd5.java 保持一致）
INSERT INTO useradmini (username, password, leve, telep, status)
VALUES ('admin', '4QrcOUm6Wau+VuBX8g+IPg==', 'admin', '00000000000', '0');

CREATE TABLE phone (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pnumber VARCHAR(20),
    status VARCHAR(20),
    lastoperation VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Userinfo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    account VARCHAR(30),
    idcard VARCHAR(30),
    age VARCHAR(10),
    sex VARCHAR(10),
    telep VARCHAR(20),
    address VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Usertable (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    age VARCHAR(10),
    sex VARCHAR(10),
    idcard VARCHAR(30),
    telep VARCHAR(20),
    address VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE PreductInfo (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    idcard VARCHAR(30),
    phone VARCHAR(20),
    amount VARCHAR(30),
    basic VARCHAR(30),
    handletime VARCHAR(30),
    status VARCHAR(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE KDPreduct (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    KDName VARCHAR(30),
    KDspeed VARCHAR(30),
    amount VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE KDINFO (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    idcard VARCHAR(30),
    phonenumber VARCHAR(20),
    kdspeed VARCHAR(30),
    kdfy VARCHAR(30),
    address VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
