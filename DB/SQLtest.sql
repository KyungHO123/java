


/* 여러줄 주석
*/

# 데이터베이스 삭제(있으면)

# drop schema if exists `TEST`;

# 데이터베이스 추가(없으면)
create database if not exists TEST;
# create schema if not exists `TEST`;

USE TEST;

# 테이블 삭제
DROP TABLE IF EXISTS MEMBER;

# 테이블 생성
CREATE TABLE IF NOT EXISTS MEMBER(
	ID VARCHAR(13) PRIMARY KEY,
    PW VARCHAR(15) NOT NULL,
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

USE test;

INSERT INTO `MEMBER`(ID, PW, EMAIL, REG_DATE) VALUES("ID1", "비번123", "ID1@naver.com", NOW());
# MEMBER 테이블에 가입일 컬럼을 추가 
ALTER TABLE `MEMBER` ADD `DATE` DATETIME NOT NULL;
# MEMEBER 테이블에 가입일을 의미한S DATE를 REG_DATE로 변경
ALTER TABLE `MEMBER` CHANGE `DATE` `REG_DATE` DATETIME NOT NULL;
# MEMBER 테이블에 불필요한 컬럼 COUNT를 추가
ALTER TABLE `MEMBER` ADD `COUNT` INT NOT NULL;
# MEMBER TABLE에서 COUNT 컬럼을 삭제
ALTER TABLE `MEMBER` DROP `COUNT`;


		SELECT * FROM category where ca_num = category.ca_num and ca_title = category.ca_title;
        
        select * from 
			comment 
		join 
			post 
		on 
			po_num = co_po_num 
		join
			board 
		on 
			bo_num = po_bo_num 
		where 
			co_num=co_num
