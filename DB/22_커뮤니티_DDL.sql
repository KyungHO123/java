drop database if exists `community`;

create database if not exists `community`;

use `community`;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
    `me_id` VARCHAR(13) PRIMARY KEY,
    `me_ms_state` VARCHAR(10) NOT NULL,
    `me_pw` VARCHAR(15) NOT NULL,
    `me_email` VARCHAR(30) NOT NULL,
    `me_authority` VARCHAR(5) NOT NULL DEFAULT 'user',
    `me_stop` DATETIME NULL,
    `me_fail` INT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_state`	varchar(10)	primary key
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_num`	int	primary key auto_increment,
	`co_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
    `bo_num` INT PRIMARY KEY AUTO_INCREMENT,
    `bo_co_num` INT NOT NULL,
    `bo_me_id` VARCHAR(13) NOT NULL,
    `bo_title` VARCHAR(50) NOT NULL,
    `bo_content` TEXT NOT NULL,
    `bo_view` INT NOT NULL DEFAULT 0,
    `bo_report_count` INT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
    `fi_num` INT PRIMARY KEY AUTO_INCREMENT,
    `fi_bo_num` INT NOT NULL,
    `fi_name` VARCHAR(150) NOT NULL,
    `fi_ori_name` VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
    `cm_num` INT PRIMARY KEY AUTO_INCREMENT,
    `cm_bo_num` INT NOT NULL,
    `cm_me_id` VARCHAR(13) NOT NULL,
    `cm_content` TEXT NOT NULL
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
    `re_num` INT PRIMARY KEY AUTO_INCREMENT,
    `re_me_id` VARCHAR(13) NOT NULL,
    `re_bo_num` INT NOT NULL,
    `re_state` INT NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
    `rp_num` INT PRIMARY KEY AUTO_INCREMENT,
    `re_rt_name` VARCHAR(15) NOT NULL,
    `re_me_id` VARCHAR(13) NOT NULL,
    `rp_table` VARCHAR(10) NOT NULL,
    `rp_content` TEXT NOT NULL,
    `rp_state` VARCHAR(5) NOT NULL DEFAULT '신고접수',
    rp_target INT NOT NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
    `rt_name` VARCHAR(15) PRIMARY KEY
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_state`
)
REFERENCES `member_state` (
	`ms_state`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (
	`bo_co_num`
)
REFERENCES `community` (
	`co_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`cm_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_board_TO_recommend_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`re_rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

