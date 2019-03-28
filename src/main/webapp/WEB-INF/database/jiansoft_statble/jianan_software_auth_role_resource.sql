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
-- Table structure for table `auth_role_resource`
--

DROP TABLE IF EXISTS `auth_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_role_resource` (
  `role_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_role_resource`
--

LOCK TABLES `auth_role_resource` WRITE;
/*!40000 ALTER TABLE `auth_role_resource` DISABLE KEYS */;
INSERT INTO `auth_role_resource` VALUES (1,1,1,'2017-02-25 09:46:42','superadmin'),(2,1,2,'2017-02-25 09:46:42','superadmin'),(3,1,3,'2017-02-25 09:46:42','superadmin'),(4,1,4,'2017-02-25 09:46:42','superadmin'),(5,1,5,'2017-02-25 09:46:42','superadmin'),(6,1,6,'2017-02-25 09:46:42','superadmin'),(7,1,7,'2017-02-25 09:46:42','superadmin'),(8,1,8,'2017-02-25 09:46:42','superadmin'),(9,1,9,'2017-02-25 09:46:42','superadmin'),(10,1,10,'2017-02-25 09:46:42','superadmin'),(11,1,11,'2017-02-25 09:46:42','superadmin'),(12,1,12,'2017-02-25 09:46:42','superadmin'),(13,1,13,'2017-02-25 09:46:42','superadmin'),(14,1,14,'2017-02-25 09:46:42','superadmin'),(15,1,15,'2017-02-25 09:46:42','superadmin'),(16,1,16,'2017-02-25 09:46:42','superadmin'),(17,1,17,'2017-02-25 09:46:42','superadmin'),(18,1,18,'2017-02-25 09:46:42','superadmin'),(19,1,19,'2017-02-25 09:46:42','superadmin'),(20,1,20,'2017-02-25 09:46:42','superadmin'),(21,1,21,'2017-02-25 09:46:42','superadmin'),(22,1,22,'2017-02-25 09:46:42','superadmin'),(23,1,23,'2017-02-25 09:46:42','superadmin'),(110,5,24,'2017-04-14 22:49:11','superAdmin'),(111,5,25,'2017-04-14 22:49:11','superAdmin'),(112,5,26,'2017-04-14 22:49:11','superAdmin'),(113,5,27,'2017-04-14 22:49:11','superAdmin'),(114,5,28,'2017-04-14 22:49:11','superAdmin'),(115,5,29,'2017-04-14 22:49:11','superAdmin'),(116,5,30,'2017-04-14 22:49:11','superAdmin'),(117,5,31,'2017-04-14 22:49:11','superAdmin'),(118,5,32,'2017-04-14 22:49:11','superAdmin'),(119,5,33,'2017-04-14 22:49:11','superAdmin'),(120,5,34,'2017-04-14 22:49:11','superAdmin'),(121,5,35,'2017-04-14 22:49:11','superAdmin'),(122,5,36,'2017-04-14 22:49:11','superAdmin'),(123,5,37,'2017-04-14 22:49:11','superAdmin'),(124,5,38,'2017-04-14 22:49:11','superAdmin'),(125,5,39,'2017-04-14 22:49:11','superAdmin'),(126,5,40,'2017-04-14 22:49:11','superAdmin'),(127,5,41,'2017-04-14 22:49:11','superAdmin'),(128,5,42,'2017-04-14 22:49:11','superAdmin'),(129,5,43,'2017-04-14 22:49:11','superAdmin'),(130,5,44,'2017-04-14 22:49:11','superAdmin'),(131,5,45,'2017-04-14 22:49:11','superAdmin'),(132,5,46,'2017-04-14 22:49:11','superAdmin'),(133,5,47,'2017-04-14 22:49:11','superAdmin'),(134,5,49,'2017-04-14 22:49:11','superAdmin'),(135,5,50,'2017-04-14 22:49:11','superAdmin'),(136,5,51,'2017-04-14 22:49:11','superAdmin'),(137,5,52,'2017-04-14 22:49:11','superAdmin'),(138,5,53,'2017-04-14 22:49:11','superAdmin'),(139,5,54,'2017-04-14 22:49:11','superAdmin'),(140,5,59,'2017-04-14 22:49:11','superAdmin'),(141,7,24,'2017-04-14 22:49:40','superAdmin'),(142,7,25,'2017-04-14 22:49:40','superAdmin'),(143,7,26,'2017-04-14 22:49:40','superAdmin'),(144,7,27,'2017-04-14 22:49:40','superAdmin'),(145,7,28,'2017-04-14 22:49:40','superAdmin'),(146,7,29,'2017-04-14 22:49:40','superAdmin'),(147,7,30,'2017-04-14 22:49:40','superAdmin'),(148,7,31,'2017-04-14 22:49:40','superAdmin'),(149,7,32,'2017-04-14 22:49:40','superAdmin'),(150,7,33,'2017-04-14 22:49:40','superAdmin'),(151,7,34,'2017-04-14 22:49:40','superAdmin'),(152,7,35,'2017-04-14 22:49:40','superAdmin'),(153,7,36,'2017-04-14 22:49:40','superAdmin'),(154,7,37,'2017-04-14 22:49:40','superAdmin'),(155,7,38,'2017-04-14 22:49:40','superAdmin'),(156,7,39,'2017-04-14 22:49:40','superAdmin'),(157,7,40,'2017-04-14 22:49:40','superAdmin'),(158,7,41,'2017-04-14 22:49:40','superAdmin'),(159,7,42,'2017-04-14 22:49:40','superAdmin'),(160,7,43,'2017-04-14 22:49:40','superAdmin'),(161,7,44,'2017-04-14 22:49:40','superAdmin'),(162,7,45,'2017-04-14 22:49:40','superAdmin'),(163,7,46,'2017-04-14 22:49:40','superAdmin'),(164,7,47,'2017-04-14 22:49:40','superAdmin'),(165,7,49,'2017-04-14 22:49:40','superAdmin'),(166,7,50,'2017-04-14 22:49:40','superAdmin'),(167,7,51,'2017-04-14 22:49:40','superAdmin'),(168,7,52,'2017-04-14 22:49:40','superAdmin'),(169,7,53,'2017-04-14 22:49:40','superAdmin'),(170,7,54,'2017-04-14 22:49:40','superAdmin'),(171,7,55,'2017-04-14 22:49:40','superAdmin'),(172,7,56,'2017-04-14 22:49:40','superAdmin'),(173,7,57,'2017-04-14 22:49:40','superAdmin'),(174,7,58,'2017-04-14 22:49:40','superAdmin'),(175,7,59,'2017-04-14 22:49:40','superAdmin');
/*!40000 ALTER TABLE `auth_role_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:04
