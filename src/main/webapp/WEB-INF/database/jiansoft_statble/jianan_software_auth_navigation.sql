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
-- Table structure for table `auth_navigation`
--

DROP TABLE IF EXISTS `auth_navigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_navigation` (
  `nav_id` int(11) NOT NULL AUTO_INCREMENT,
  `nav_name` varchar(100) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `sort_value` int(11) DEFAULT NULL,
  `resource_id` int(11) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `nav_level` int(11) DEFAULT NULL,
  `relate_resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_navigation`
--

LOCK TABLES `auth_navigation` WRITE;
/*!40000 ALTER TABLE `auth_navigation` DISABLE KEYS */;
INSERT INTO `auth_navigation` VALUES (5,'权限管理',0,1,5,NULL,'2017-02-01 08:24:32',1,0),(6,'资源管理',5,3,1,NULL,'2017-02-25 09:41:42',2,0),(7,'用户管理',5,2,5,NULL,'2017-02-25 09:42:18',2,0),(9,'导航管理',5,4,20,NULL,'2017-02-25 09:44:10',2,0),(11,'角色管理',5,5,15,NULL,'2017-02-25 09:44:53',2,0),(12,'业务管理',0,6,29,NULL,'2017-02-25 16:54:40',1,0),(13,'工程审核管理',12,7,29,NULL,'2017-02-25 16:55:19',2,29),(16,'工程结算管理',12,8,37,NULL,'2017-02-25 17:24:39',2,37),(18,'外管工程管理',12,10,44,NULL,'2017-02-25 21:18:23',2,44),(20,'房屋契税管理',12,24,49,NULL,'2017-02-26 19:20:30',2,49),(21,'房屋契税添加',12,13,50,NULL,'2017-02-26 19:50:09',3,49),(22,'房屋契税详情',12,14,51,NULL,'2017-02-26 19:53:13',3,49),(23,'工程审核-添加',12,15,26,NULL,'2017-02-26 19:53:48',3,29),(24,'工程审核-详情',12,16,28,NULL,'2017-02-26 19:55:07',3,29),(25,'工程审核-添加税票信息',12,17,30,NULL,'2017-02-26 19:56:27',3,29),(26,'工程结算-添加',12,18,34,NULL,'2017-02-26 19:56:59',3,37),(27,'工程结算-详情',12,19,36,NULL,'2017-02-26 19:58:16',3,37),(28,'工程结算-添加税票信息',12,20,38,NULL,'2017-02-26 20:00:07',3,37),(29,'外管工程-添加',12,21,41,NULL,'2017-02-26 20:01:32',3,44),(30,'外管工程-详情',12,22,43,NULL,'2017-02-26 20:01:48',3,44),(31,'外管工程-添加税票信息',12,23,45,NULL,'2017-02-26 20:02:13',3,44),(32,'数据查询管理',12,25,52,NULL,'2017-02-26 20:22:00',2,52),(34,'房产完税证明',12,12,53,NULL,'2017-03-11 11:47:46',2,53),(35,'添加独立打印',12,NULL,54,NULL,'2017-03-11 13:19:20',3,53),(36,'房屋契税-税票添加',12,NULL,59,NULL,'2017-03-18 10:10:49',3,49),(37,'局领导负责人',5,NULL,60,NULL,'2017-07-23 16:49:50',2,NULL);
/*!40000 ALTER TABLE `auth_navigation` ENABLE KEYS */;
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
