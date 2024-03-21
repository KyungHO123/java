CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;
 

DROP TABLE IF EXISTS `report_type`;
 
CREATE TABLE `report_type` (
  `rt_name` varchar(15) NOT NULL,
  PRIMARY KEY (`rt_name`)
)  