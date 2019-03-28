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
-- Table structure for table `auth_resource`
--

DROP TABLE IF EXISTS `auth_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) NOT NULL,
  `resource_type` int(11) DEFAULT NULL,
  `resource_path` varchar(200) NOT NULL,
  `resource_desc` varchar(200) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_resource`
--

LOCK TABLES `auth_resource` WRITE;
/*!40000 ALTER TABLE `auth_resource` DISABLE KEYS */;
INSERT INTO `auth_resource` VALUES (1,'资源-资源列表',2,'/crm/v1/auth/resource/list','资源-资源列表','2017-02-24 23:32:29',NULL),(2,'资源-保存资源',2,'/crm/v1/auth/resource/ajax/save','资源-保存资源','2017-02-24 23:33:35',NULL),(3,'资源-资源列表ajax',2,'/crm/v1/auth/resource/ajax/list','资源-资源列表ajax','2017-02-24 23:33:31',NULL),(4,'资源-删除资源',2,'/crm/v1/auth/resource/ajax/delete','资源-删除资源','2017-02-24 23:34:16',NULL),(5,'管理员-管理员列表',2,'/crm/v1/admin/user/list','管理员-管理员列表','2017-02-24 23:35:32',NULL),(6,'管理员-角色列表',2,'/crm/v1/admin/getRoles','管理员-角色列表','2017-02-24 23:37:04',NULL),(7,'管理员-创建保存管理员',2,'/crm/v1/admin/ajax/save','管理员-创建保存管理员','2017-02-24 23:37:37',NULL),(8,'管理员-编辑密码',2,'/crm/v1/admin/ajax/editPassword','管理员-编辑密码','2017-02-24 23:38:39',NULL),(9,'管理员-保存密码',2,'/crm/v1/admin/ajax/updatePassword','管理员-保存密码','2017-02-24 23:39:29',NULL),(10,'管理员-修改用户状态',2,'/crm/v1/admin/ajax/changeUserStatus','管理员-修改用户状态','2017-02-24 23:47:02',NULL),(11,'管理员-分配导航',2,'/crm/v1/admin/ajax/dispatchNavigation','管理员-分配导航','2017-02-25 08:14:08',NULL),(12,'管理员-用户资源列表',2,'/crm/v1/admin/user/resource/list','管理员-用户资源列表','2017-02-24 23:40:59',NULL),(13,'管理员-设置用户资源',2,'/crm/v1/admin/ajax/user_resource/set','管理员-设置用户资源','2017-02-24 23:41:38',NULL),(14,'管理员-修改用户信息',2,'/crm/v1/admin/updateUserInfo','管理员-修改用户信息','2017-02-24 23:42:15',NULL),(15,'角色-列表',2,'/crm/v1/role/admin/toRoleRoute','角色-列表','2017-02-24 23:43:20',NULL),(16,'角色-删除角色',2,'/crm/v1/role/ajax/deleteRole','删除角色','2017-02-24 23:43:43',NULL),(17,'角色-获取角色资源',2,'/crm/v1/role/ajax/getRoles','角色-获取角色资源','2017-02-24 23:44:33',NULL),(18,'角色-创建修改角色',2,'/crm/v1/role/ajax/updateOrInsert','角色-创建修改角色','2017-02-24 23:45:41',NULL),(19,'导航-异步列表',2,'/crm/v1/navigation/ajax/navigation/list','导航-异步列表','2017-02-25 09:29:39',NULL),(20,'导航-列表',2,'/crm/v1/navigation/list','导航-列表','2017-02-25 09:30:11',NULL),(21,'导航-异步保存',2,'/crm/v1/navigation/ajax/save','导航-异步保存','2017-02-25 09:30:52',NULL),(22,'导航-获取子列表',2,'/crm/v1/navigation/ajax/getNavListByParentId','导航-获取子列表','2017-02-25 09:33:03',NULL),(23,'导航-删除导航',2,'/ajax/deleteNav','导航-删除导航','2017-02-25 09:33:29',NULL),(24,'工程审核-异步根据纳税唯一号获取信息',1,'/projectcheck/api/get_by/identifynum','工程审核-异步根据纳税唯一号获取信息','2017-02-25 16:45:09',NULL),(25,'工程审核-异步根据工程名称获取信息',1,'/projectcheck/api/get_by/projectname','工程审核-异步根据工程名称获取信息','2017-02-25 16:45:49',NULL),(26,'工程审核-添加工程审核信息',1,'/projectcheck/toadd','工程审核-添加工程审核信息','2017-02-25 16:49:01',NULL),(27,'工程审核-创建审核信息',1,'/projectcheck/submit','工程审核-创建审核信息','2017-02-25 16:50:31',NULL),(28,'工程审核-查看审核工程信息详情',1,'/projectcheck/toview','工程信息-查看审核工程信息详情','2017-02-25 16:52:00',NULL),(29,'工程审核-列表',1,'/projectcheck/list','工程审核-列表','2017-02-25 16:51:53',NULL),(30,'工程审核-添加税票信息',1,'/projectcheck/taxinfo/toadd','工程审核-添加税票信息','2017-02-25 16:52:31',NULL),(31,'工程审核-提交税票信息',1,'/projectcheck/taxinfo/submit','工程审核-提交税票信息','2017-02-25 16:53:44',NULL),(32,'工程结算-异步根据纳税唯一号获取信息',1,'/projectsettlement/api/get_by/identifynum','工程结算-异步根据纳税唯一号获取信息','2017-02-25 16:57:25',NULL),(33,'工程结算-异步根据工程名称获取信息',1,'/projectsettlement/api/get_by/projectname','工程结算-异步根据工程名称获取信息','2017-02-25 16:57:48',NULL),(34,'工程结算-添加工程审核信息',1,'/projectsettlement/toadd','工程结算-添加工程审核信息','2017-02-25 16:58:24',NULL),(35,'工程结算-创建结算信息',1,'/projectsettlement/submit','工程结算-创建结算信息','2017-02-26 19:59:16',NULL),(36,'工程结算-查看工程结算信息详情',1,'/projectsettlement/toview','工程结算-查看工程结算信息详情','2017-02-26 19:58:53',NULL),(37,'工程结算-列表',1,'/projectsettlement/list','工程结算-列表','2017-02-25 17:03:56',NULL),(38,'工程结算-添加税票信息',1,'/projectsettlement/taxinfo/toadd','工程结算-提交税票信息','2017-02-25 17:04:25',NULL),(39,'外管工程-异步根据纳税唯一号获取信息',1,'/projectouterube/api/get_by/identifynum','外管工程-异步根据纳税唯一号获取信息','2017-02-25 21:12:13',NULL),(40,'外管工程-异步根据工程名称获取信息',1,'/projectouterube/api/get_by/projectname','外管工程-异步根据工程名称获取信息','2017-02-25 21:12:57',NULL),(41,'外管工程-添加工程审核信息',1,'/projectouterube/toadd','外管工程-添加工程审核信息','2017-02-25 21:13:25',NULL),(42,'外管工程-创建审核信息',1,'/projectouterube/submit','工程结算-创建审核信息','2017-02-25 21:14:06',NULL),(43,'外管工程-查看审核工程信息详情',1,'/projectouterube/toview','外管工程-查看审核工程信息详情','2017-02-25 21:14:32',NULL),(44,'外管工程-列表',1,'/projectouterube/list','外管工程-列表','2017-02-25 21:15:03',NULL),(45,'外管工程-添加税票信息',1,'/projectouterube/taxinfo/toadd','外管工程-添加税票信息','2017-02-25 21:15:28',NULL),(46,'外管工程-提交税票信息',1,'/projectouterube/taxinfo/submit','外管工程-提交税票信息','2017-02-25 21:16:32',NULL),(47,'工程结算-提交税票信息',1,'/projectsettlement/taxinfo/submit','工程结算-提交税票信息','2017-02-25 21:17:34',NULL),(49,'房屋契税-列表',1,'/housecontract/list','房屋契税-列表','2017-02-26 19:19:25',NULL),(50,'房屋契税-添加',1,'/housecontract/toadd','房屋契税-添加','2017-02-26 19:19:57',NULL),(51,'房屋契税-详情',1,'/housecontract/toview','房屋契税-详情','2017-02-26 19:52:37',NULL),(52,'数据查询-跳转页面',1,'/summary/search','数据查询-跳转页面','2017-02-26 20:21:26',NULL),(53,'独立打印列表',1,'/summary/prints/list','独立打印列表','2017-03-11 11:47:23',NULL),(54,'独立打印-添加',1,'/summary/prints/toadd','独立打印-添加','2017-03-11 13:18:58',NULL),(55,'工程审核-删除记录',1,'/projectcheck/api/delete','工程审核-删除记录','2017-03-11 14:19:27',NULL),(56,'工程结算-删除记录',1,'/projectsettlement/api/delete','工程结算-删除记录','2017-03-11 14:20:53',NULL),(57,'外管工程-删除记录',1,'/projectouterube/api/delete','外管工程-删除记录','2017-03-11 14:21:39',NULL),(58,'房屋契税-删除记录',1,'/housecontract/api/delete','房屋契税-删除记录','2017-03-11 14:22:21',NULL),(59,'房屋契税-税票添加',1,'/housecontract/taxinfo/toadd','房屋契税-税票添加','2017-03-18 10:11:43',NULL),(60,'局领导负责人',2,'/duty/list/','局领导负责人','2017-07-23 16:48:11',NULL),(61,'添加局领导负责人',2,'/duty/api/submit','添加局领导负责人','2017-07-23 16:48:49',NULL),(62,'删除局领导负责人',2,'/duty/api/delete','删除局领导负责人','2017-07-23 16:49:22',NULL),(63,'房产完税证明-删除',1,'/summary/api/prints/delete','房产完税证明-删除','2017-09-16 16:11:43',NULL);
/*!40000 ALTER TABLE `auth_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:06
