CREATE DATABASE  IF NOT EXISTS `community` ;
USE `community`;
 
DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_bo_num` int NOT NULL,
  `fi_name` varchar(150) NOT NULL,
  `fi_ori_name` varchar(50) NOT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bo_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bo_num`) REFERENCES `board` (`bo_num`)
)  