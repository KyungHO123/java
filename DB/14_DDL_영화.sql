
DROP DATABASE IF EXISTS `movie`;
CREATE DATABASE IF NOT EXISTS `movie`;

USE `movie`;

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
    `ch_num` INT PRIMARY KEY AUTO_INCREMENT,
    `ch_name` VARCHAR(30) NOT NULL,
    `ch_birthday` DATE NOT NULL,
    `ch_detail` TEXT NOT NULL,
    `ch_na_name` VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS `nation`;

CREATE TABLE `nation` (
    `na_name` VARCHAR(30) PRIMARY KEY
);

DROP TABLE IF EXISTS `movie_person`;

CREATE TABLE `movie_person` (
    `mp_num` INT PRIMARY KEY AUTO_INCREMENT,
    `mp_role` CHAR(2) NOT NULL,
    `mp_pic` VARCHAR(50) NULL,
    `mp_ch_num` INT NOT NULL
);

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
    `mo_num` INT PRIMARY KEY AUTO_INCREMENT,
    `mo_title` VARCHAR(50) NOT NULL,
    `mo_date` DATE NOT NULL,
    `mo_content` TEXT NOT NULL,
    `mo_running` INT NOT NULL,
    `mo_ag_name` VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS `movie_file`;

CREATE TABLE `movie_file` (
    `mf_num` INT PRIMARY KEY AUTO_INCREMENT,
    `mf_filename` VARCHAR(50) NOT NULL,
    `mf_type` VARCHAR(10) NOT NULL,
    `mf_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `age`;

CREATE TABLE `age` (
    `ag_name` VARCHAR(10) PRIMARY KEY
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
    `ge_name` VARCHAR(10) PRIMARY KEY
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
    `re_name` VARCHAR(10) PRIMARY KEY
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
    `th_num` INT PRIMARY KEY AUTO_INCREMENT,
    `th_name` VARCHAR(10) NOT NULL,
    `th_addr` VARCHAR(100) NOT NULL,
    `th_seat` INT NOT NULL DEFAULT 0,
    `th_screen` INT NOT NULL,
    `th_re_name` VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
    `sc_num` INT PRIMARY KEY AUTO_INCREMENT,
    `sc_name` INT NOT NULL,
    `sc_seat` INT NOT NULL DEFAULT 0,
    `sc_th_num` INT NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
    `se_num` INT PRIMARY KEY AUTO_INCREMENT,
    `se_name` VARCHAR(3) NOT NULL,
    `se_sc_num` INT NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
    `me_id` VARCHAR(20) PRIMARY KEY,
    `me_pw` VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
    `sh_num` INT PRIMARY KEY AUTO_INCREMENT,
    `sh_date` DATE NOT NULL,
    `sh_time` TIME NOT NULL,
    `sh_morning` INT NOT NULL DEFAULT 0,
    `sh_sc_num` INT NOT NULL,
    `sh_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `join`;

CREATE TABLE `join` (
    `jo_num` INT PRIMARY KEY AUTO_INCREMENT,
    `jo_casting` VARCHAR(20) NOT NULL,
    `jo_mo_num` INT NOT NULL,
    `jo_mp_num` INT NOT NULL
);

DROP TABLE IF EXISTS `production_nation`;

CREATE TABLE `production_nation` (
    `pn_num` INT PRIMARY KEY AUTO_INCREMENT,
    `pn_na_name` VARCHAR(30) NOT NULL,
    `pn_mo_num` INT NOT NULL
);

DROP TABLE IF EXISTS `genre_include`;

CREATE TABLE `genre_include` (
    `gi_num` INT PRIMARY KEY AUTO_INCREMENT,
    `gi_mo_num` INT NOT NULL,
    `gi_ge_name` VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
    `ti_num` INT PRIMARY KEY AUTO_INCREMENT,
    `ti_adult` INT NOT NULL,
    `ti_teenager` INT NOT NULL,
    `ti_total_price` INT NOT NULL,
    `ti_sh_num` INT NOT NULL,
    `ti_me_id` VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
    `tl_num` INT PRIMARY KEY AUTO_INCREMENT,
    `tl_ti_num2` INT NOT NULL,
    `tl_se_num` INT NOT NULL
);

ALTER TABLE `character` ADD CONSTRAINT `FK_nation_TO_character_1` FOREIGN KEY (
	`ch_na_name`
)
REFERENCES `nation` (
	`na_name`
);

ALTER TABLE `movie_person` ADD CONSTRAINT `FK_character_TO_movie_person_1` FOREIGN KEY (
	`mp_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `movie` ADD CONSTRAINT `FK_age_TO_movie_1` FOREIGN KEY (
	`mo_ag_name`
)
REFERENCES `age` (
	`ag_name`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_movie_TO_movie_file_1` FOREIGN KEY (
	`mf_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `FK_region_TO_theater_1` FOREIGN KEY (
	`th_re_name`
)
REFERENCES `region` (
	`re_name`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_screen_TO_schedule_1` FOREIGN KEY (
	`sh_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sh_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `join` ADD CONSTRAINT `FK_movie_TO_join_1` FOREIGN KEY (
	`jo_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `join` ADD CONSTRAINT `FK_movie_person_TO_join_1` FOREIGN KEY (
	`jo_mp_num`
)
REFERENCES `movie_person` (
	`mp_num`
);

ALTER TABLE `production_nation` ADD CONSTRAINT `FK_nation_TO_production_nation_1` FOREIGN KEY (
	`pn_na_name`
)
REFERENCES `nation` (
	`na_name`
);

ALTER TABLE `production_nation` ADD CONSTRAINT `FK_movie_TO_production_nation_1` FOREIGN KEY (
	`pn_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `genre_include` ADD CONSTRAINT `FK_movie_TO_genre_include_1` FOREIGN KEY (
	`gi_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `genre_include` ADD CONSTRAINT `FK_genre_TO_genre_include_1` FOREIGN KEY (
	`gi_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`ti_sh_num`
)
REFERENCES `schedule` (
	`sh_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_ti_num2`
)
REFERENCES `ticketing` (
	`ti_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_se_num`
)
REFERENCES `seat` (
	`se_num`
);