CREATE DATABASE  IF NOT EXISTS `community`;  
USE `community`;
 
DROP TABLE IF EXISTS `member_state`;
 
CREATE TABLE `member_state` (
  `ms_state` varchar(10) NOT NULL,
  PRIMARY KEY (`ms_state`)
)  