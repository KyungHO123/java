/* 여러줄 주석
*/
# 데이터 베이스 추가(없으면)
 create database if not exists TEST;
#create schema if not exists `TEST`;

# 데이터베이스 삭제(있으면)
#boardboardmembermember drop  database if exists TEST;
# drop schema if exists `TEST`;

USE TEST;

#테이블 삭제
DROP TABLE IF EXISTS MEMBER;

INSERT INTO `MEMBER`(ID, PW, EMAIL, REG_DATE) VALUES("ID1", "비번123", "ID1@naver.com", NOW());
 
# 테이블 생성
CREATE TABLE IF NOT EXISTS MEMBER(
	ID VARCHAR(13) PRIMARY KEY,
	W VARCHAR(15) NOT NULL,
	EMAIL VARCHAR(30) NOT NULL UNIQUE
);
DESC MEMBER;
DROP TABLE IF EXISTS BOARD;

CREATE TABLE IF NOT EXISTS BOARD(
	NUM INT AUTO_INCREMENT,
	TITLE VARCHAR(50) NOT NULL,
	CONTENT LONGTEXT NOT NULL,
	VIEW INT NOT NULL DEFAULT 0,
    ID VARCHAR(13) NOT NULL,
	PRIMARY KEY(NUM),
	FOREIGN KEY(ID) REFERENCES MEMBER(ID)
);
DESC BOARD;