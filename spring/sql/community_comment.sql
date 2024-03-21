CREATE DATABASE  IF NOT EXISTS `community` ;
USE `community`;
DROP TABLE IF EXISTS `comment`;
 
CREATE TABLE `comment` (
  `cm_num` int NOT NULL AUTO_INCREMENT,
  `cm_content` text,
  `cm_bo_num` int NOT NULL,
  `cm_me_id` varchar(13) NOT NULL,
  PRIMARY KEY (`cm_num`),
  KEY `FK_board_TO_comment_1` (`cm_bo_num`),
  KEY `FK_member_TO_comment_1` (`cm_me_id`),
  CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (`cm_bo_num`) REFERENCES `board` (`bo_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (`cm_me_id`) REFERENCES `member` (`me_id`) ON DELETE CASCADE ON UPDATE CASCADE
)  