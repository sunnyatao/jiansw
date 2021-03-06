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
-- Table structure for table `t_project_check_invoice_info`
--

DROP TABLE IF EXISTS `t_project_check_invoice_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project_check_invoice_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_check_id` int(11) NOT NULL,
  `national_invoice_date` datetime DEFAULT NULL COMMENT '国税开票日期',
  `national_invoice_no` varchar(500) DEFAULT NULL COMMENT '国税发票号码，多个发票用'',''隔开',
  `national_invoice_tax_no` varchar(500) DEFAULT NULL COMMENT '国税税票号码',
  `national_invoice_type` varchar(50) DEFAULT NULL COMMENT '国税发票类型: 增值税、企业所得税',
  `local_invoice_date` datetime DEFAULT NULL COMMENT '地税开票日期',
  `local_invoice_no` varchar(500) DEFAULT NULL COMMENT '地税发票号码',
  `local_invoice_tax_no` varchar(500) DEFAULT NULL,
  `attachment_path` varchar(1000) DEFAULT NULL,
  `national_invoice_amount` decimal(10,2) DEFAULT '0.00' COMMENT '国税税额',
  `local_invoice_amount` decimal(10,2) DEFAULT '0.00' COMMENT '地税额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_check_id` (`project_check_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project_check_invoice_info`
--

LOCK TABLES `t_project_check_invoice_info` WRITE;
/*!40000 ALTER TABLE `t_project_check_invoice_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_project_check_invoice_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:10
