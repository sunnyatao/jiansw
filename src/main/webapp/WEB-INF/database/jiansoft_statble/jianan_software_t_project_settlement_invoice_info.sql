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
-- Table structure for table `t_project_settlement_invoice_info`
--

DROP TABLE IF EXISTS `t_project_settlement_invoice_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project_settlement_invoice_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_settlement_id` int(11) NOT NULL,
  `national_invoice_date` datetime DEFAULT NULL COMMENT '国税开票日期',
  `national_invoice_no` varchar(500) DEFAULT NULL COMMENT '国税发票号码，多个发票用'',''隔开',
  `national_invoice_tax_no` varchar(500) DEFAULT NULL COMMENT '国税税票号码',
  `national_invoice_appreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '增值税额\r\n            ',
  `national_invoice_type` varchar(50) DEFAULT NULL COMMENT '国税发票类型: 增值税、企业所得税',
  `local_invoice_date` datetime DEFAULT NULL COMMENT '地税开票日期',
  `local_invoice_no` varchar(500) DEFAULT NULL COMMENT '地税发票号码',
  `local_invoice_tax_no` varchar(500) DEFAULT NULL,
  `local_invoice_addtional` decimal(10,2) DEFAULT NULL,
  `attachment_path` varchar(1000) DEFAULT NULL,
  `nationnal_settlement` double DEFAULT NULL COMMENT '国税结算',
  `national_invoice_amount` decimal(10,2) DEFAULT '0.00' COMMENT '国税税额',
  `local_invoice_amount` decimal(10,2) DEFAULT '0.00' COMMENT '地税税额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_settlement_id` (`project_settlement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project_settlement_invoice_info`
--

LOCK TABLES `t_project_settlement_invoice_info` WRITE;
/*!40000 ALTER TABLE `t_project_settlement_invoice_info` DISABLE KEYS */;
INSERT INTO `t_project_settlement_invoice_info` VALUES (1,1,'2017-09-26 00:00:00','1232321','123213',NULL,NULL,'2017-09-26 00:00:00',NULL,'123213',NULL,NULL,0,0.00,0.00),(2,2,'2017-09-26 00:00:00','1232','232',NULL,NULL,'2017-09-26 00:00:00',NULL,'123',NULL,NULL,0,0.00,0.00),(3,3,'2017-09-26 00:00:00','wsqewqewq','llspxx1100002',NULL,NULL,'2017-09-26 00:00:00',NULL,'12321waew',NULL,NULL,0,0.00,0.00),(4,5,'2017-12-07 00:00:00','wqwqw','wqwq',NULL,NULL,'2017-12-07 00:00:00',NULL,'wqwq',NULL,NULL,0,0.00,0.00),(5,6,'2018-01-15 00:00:00','123','123',NULL,NULL,'2018-01-15 00:00:00',NULL,'123',NULL,NULL,0,0.00,0.00),(6,7,'2018-09-02 00:00:00','12321321','32132132',NULL,NULL,'2018-09-02 00:00:00',NULL,'321321',NULL,NULL,0,0.00,0.00),(7,8,'2018-09-03 00:00:00','qwewqewq','qewewqe',NULL,NULL,'2018-09-03 00:00:00',NULL,'qwewqewq',NULL,NULL,0,0.00,0.00);
/*!40000 ALTER TABLE `t_project_settlement_invoice_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:09
