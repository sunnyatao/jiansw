-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: jianan_software
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_house_contract_tax_info`
--

DROP TABLE IF EXISTS `t_house_contract_tax_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_house_contract_tax_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_contract_id` int(11) NOT NULL,
  `contact_tax_no` varchar(100) DEFAULT NULL COMMENT '契税税票号码',
  `stamp_tax_no` varchar(100) DEFAULT NULL COMMENT '印花税税票号码',
  `contact_tax_date` datetime DEFAULT NULL,
  `stamp_tax_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `operator_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_house_contract_tax_info`
--

LOCK TABLES `t_house_contract_tax_info` WRITE;
/*!40000 ALTER TABLE `t_house_contract_tax_info` DISABLE KEYS */;
INSERT INTO `t_house_contract_tax_info` VALUES (1,2,'123.1','2132','2017-09-01 00:00:00','2017-09-02 00:00:00','2017-09-26 22:54:19',1,'admin'),(2,1,'123','23323','2017-09-06 00:00:00','2017-09-08 00:00:00','2017-09-26 23:03:04',1,'admin');
/*!40000 ALTER TABLE `t_house_contract_tax_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:07
