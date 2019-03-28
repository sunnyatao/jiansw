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
-- Table structure for table `t_project_check`
--

DROP TABLE IF EXISTS `t_project_check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(20) NOT NULL COMMENT '编号：长度10位、字段类型：字符型字（例S20170001）、要求自动编号，后四位取原有记录最大编号+1，年度四位取系统时间年度，每年重新编号，校验长度10位，不能为空，不能重复（唯一字段）',
  `taxpayer_identify_num` varchar(50) NOT NULL COMMENT '纳税人识别号：长度19位、字段类型：字符型（全角）、要求可以调用原有记录最新信息（纳税人名称、经办人姓名、电话），校验不能低于18位，不能大于19位，不能为空',
  `taxpayer_name` varchar(80) NOT NULL COMMENT '校验不能为空',
  `project_name` varchar(80) NOT NULL COMMENT '要求可以调用原有记录最新信息（纳税人识别号、纳税人名称、建设单位、工程总造价、企业所得税归属、是否完工信、联系电话），校验不能为空',
  `project_address` varchar(30) NOT NULL COMMENT '工程项目所在地: 要求默认新为新晃侗族自治县，校验不能为空',
  `project_constructor` varchar(80) NOT NULL COMMENT '工程发包方（建设方）:校验不能为空',
  `project_total_cost` decimal(16,2) DEFAULT NULL,
  `is_down` varchar(20) NOT NULL COMMENT '是否完工',
  `invoice_amount` decimal(16,2) DEFAULT NULL,
  `appreciation_rate` decimal(16,2) DEFAULT NULL,
  `appreciation_tax_amount` decimal(16,2) DEFAULT NULL,
  `income_rate` decimal(16,2) DEFAULT NULL,
  `income_tax_amount` decimal(16,2) DEFAULT NULL,
  `income_affiliation` varchar(10) NOT NULL COMMENT '所得税归属：选择项 ，国税、地税（默认地税）',
  `urban_tax_rate` decimal(16,2) DEFAULT NULL,
  `urban_tax_amount` decimal(16,2) DEFAULT NULL,
  `education_addition_amount` decimal(16,2) DEFAULT NULL,
  `local_education_addition_amount` decimal(16,2) DEFAULT NULL,
  `stamp_duty_rate` decimal(16,2) DEFAULT NULL,
  `stamp_duty_amount` decimal(16,2) DEFAULT NULL,
  `labor_union_amount` decimal(16,2) DEFAULT NULL,
  `water_construct_amount` decimal(16,2) DEFAULT NULL,
  `pay_tax_user` varchar(10) DEFAULT NULL COMMENT '纳税经办人：默认纳税人名称',
  `contacts_phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `operator_id` int(11) DEFAULT NULL COMMENT '经办人：登录人员姓名（单做表）',
  `duty_user_id` int(11) DEFAULT NULL COMMENT '负责人',
  `attachment_path` varchar(1000) DEFAULT NULL COMMENT '附件地址',
  `is_deleted` tinyint(4) DEFAULT '0',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `bureau_leader` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `duty_user_name` varchar(50) DEFAULT NULL,
  `tax_serial_no` int(11) DEFAULT '0',
  `old_serial_num` varchar(50) DEFAULT NULL,
  `constructor_identify_num` varchar(80) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_project_check_serial_num` (`serial_num`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='建安发票代开审核';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project_check`
--

LOCK TABLES `t_project_check` WRITE;
/*!40000 ALTER TABLE `t_project_check` DISABLE KEYS */;
INSERT INTO `t_project_check` VALUES (1,'S20170001','430181198901045987','lolo','ioio','新晃侗族自治县','430181198901010020',1000000.00,'清包工工程',1000000.00,0.03,29126.21,0.02,14778.33,'地税',0.05,1456.31,873.79,582.52,0.00,300.00,1165.05,582.52,'lolo','13123239089',0,0,NULL,0,'2017-10-10 21:08:00',NULL,'admin','邓根林',2,NULL,'12qpoop1'),(2,'S20170002','4301811988010239802','豆豆','王大炮33','新晃侗族自治县','看看',19000.00,'完工',19000.00,0.03,553.40,0.02,280.79,'地税',0.05,27.67,16.60,11.07,0.00,5.70,22.14,11.07,'豆豆','1232323231',0,0,NULL,0,'2017-11-02 20:26:27',NULL,'admin','邓根林',0,NULL,'23434'),(7,'S20170003','4301811988010239802','豆豆','王大炮3','新晃侗族自治县','看看',19000.00,'完工',19000.00,0.03,553.40,0.02,280.79,'地税',0.05,27.67,16.60,11.07,0.00,5.70,22.14,11.07,'豆豆','1232323231',0,0,NULL,0,'2017-11-29 20:28:33',NULL,'admin','邓根林',0,NULL,'23434'),(9,'S20170004','4301811988010239802','豆豆','王大炮3123','新晃侗族自治县','看看',19000.00,'完工',19000.00,0.03,553.40,0.02,280.79,'地税',0.05,27.67,16.60,11.07,0.00,5.70,22.14,11.07,'豆豆','1232323231',0,0,NULL,1,'2018-01-03 09:18:43',NULL,'admin','邓根林',0,NULL,'23434'),(10,'S20170005','4301811988010239802','豆豆','王大炮3123123','新晃侗族自治县','看看',19000.00,'完工',19000.00,0.03,553.40,0.02,280.79,'地税',0.05,27.67,16.60,11.07,0.00,5.70,22.14,11.07,'豆豆','1232323231',0,0,NULL,1,'2018-01-03 09:21:25',NULL,'admin','邓根林',0,NULL,'23434'),(11,'S20180001','4301811988010239802','豆豆','王大炮3123','新晃侗族自治县','看看',222222222.00,'完工',222222222.00,0.03,6472491.90,0.02,3284072.25,'地税',0.05,323624.60,194174.76,129449.84,0.00,66666.67,258899.68,129449.84,'豆豆','1232323231',0,0,NULL,0,'2018-01-03 09:21:59',NULL,'admin','邓根林',1,NULL,'23434'),(12,'S20180002','4301811988010239809','李明明','新晃侗族自治县改造老屋','新晃侗族自治县','新晃侗族自治县',989829192.00,'完工',989829192.00,0.03,28829976.47,0.02,14628017.62,'地税',0.05,1441498.82,864899.29,576599.53,0.00,296948.76,1153199.06,576599.53,'李明明','18909871892',0,0,NULL,0,'2018-07-23 18:16:47',NULL,'admin','邓根林',0,NULL,'4301811988010239800'),(13,'S20180003','新晃侗族自治县123','新晃侗族自治县123','新晃侗族自治县123','新晃侗族自治县123','新晃侗族自治县123',12121122221.00,'完工',12121122221.00,0.03,353042394.79,0.02,179129885.04,'地税',0.05,17652119.74,10591271.84,7060847.90,0.00,3636336.67,14121695.79,7060847.90,'新晃侗族自治县123','',0,0,NULL,0,'2018-09-03 22:14:55',NULL,'admin','邓根林',0,NULL,'新晃侗族自治县123');
/*!40000 ALTER TABLE `t_project_check` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:05
