drop database if exists communityteam6;

create database if not exists communityTeam6;

use communityTeam6;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
    `me_id` VARCHAR(15) PRIMARY KEY,
    `me_name` VARCHAR(15) NOT NULL,
    `me_pw` VARCHAR(20) NOT NULL,
    `me_email` VARCHAR(30) NOT NULL,
    `me_address` VARCHAR(30) NOT NULL,
    `me_phoneNum` VARCHAR(11) NOT NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
    `bo_num` INT PRIMARY KEY AUTO_INCREMENT,
    `bo_name` VARCHAR(10) NOT NULL,
    `cm_num` INT NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
    `po_num` INT PRIMARY KEY AUTO_INCREMENT,
    `po_title` VARCHAR(20) NOT NULL,
    `po_content` TEXT NOT NULL,
    `po_me_id` VARCHAR(30) NOT NULL,
    `po_bo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
    `co_num` INT PRIMARY KEY AUTO_INCREMENT,
    `co_content` TEXT NOT NULL,
    `co_me_id` VARCHAR(30) NOT NULL,
    `co_po_num` INT NOT NULL
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
    `cm_num` INT PRIMARY KEY AUTO_INCREMENT,
    `cm_name` VARCHAR(10) NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bo_num`
);

ALTER TABLE `post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
	`po_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

ALTER TABLE `community` ADD CONSTRAINT `PK_COMMUNITY` PRIMARY KEY (
	`cm_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (
	`cm_num`
)
REFERENCES `community` (
	`cm_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_board_TO_post_1` FOREIGN KEY (
	`po_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`co_po_num`
)
REFERENCES `post` (
	`po_num`
);

