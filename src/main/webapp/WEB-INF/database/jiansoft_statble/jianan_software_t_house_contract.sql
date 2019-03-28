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
-- Table structure for table `t_house_contract`
--

DROP TABLE IF EXISTS `t_house_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_house_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `floor_name` varchar(100) DEFAULT NULL COMMENT '楼栋',
  `serial_no` varchar(100) DEFAULT NULL,
  `area` decimal(10,2) DEFAULT NULL COMMENT '面积',
  `unit_price` decimal(16,2) DEFAULT NULL,
  `total_price` decimal(16,2) DEFAULT NULL,
  `contract_tax_rate` decimal(16,2) DEFAULT NULL,
  `contract_tax` decimal(16,2) DEFAULT NULL,
  `card_no` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `contract_date` datetime DEFAULT NULL COMMENT '合同签订日期',
  `contract_down` varchar(10) DEFAULT NULL,
  `first_payment_amount` decimal(16,2) DEFAULT NULL,
  `mortgage_amount` decimal(16,2) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `appreciation_rate` decimal(16,2) DEFAULT NULL,
  `appreciation_amount` decimal(10,2) DEFAULT NULL,
  `stamp_duty_rate` decimal(16,2) DEFAULT NULL,
  `stamp_duty_amount` decimal(16,2) DEFAULT NULL,
  `house_type` varchar(100) DEFAULT NULL COMMENT '选择项：住房、门面、土地、其它',
  PRIMARY KEY (`id`,`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_house_contract`
--

LOCK TABLES `t_house_contract` WRITE;
/*!40000 ALTER TABLE `t_house_contract` DISABLE KEYS */;
INSERT INTO `t_house_contract` VALUES (1,'123','12','123',123.00,11111.00,1366653.00,0.01,13015.74,'222222222222222222','2017-09-05 00:00:00','123',1222222.00,12222222.00,1,'admin',0,'2017-09-26 21:26:30','123',0.05,0.00,0.00,683.33,'住房'),(2,'123','1232','1231',123.00,2232.00,274536.00,0.02,4991.56,'2321321321321321','2017-09-01 00:00:00','32312',321321.00,12321.00,1,'admin',0,'2017-09-26 22:47:08','12322',0.10,0.00,0.00,137.27,'住房');
/*!40000 ALTER TABLE `t_house_contract` ENABLE KEYS */;
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
