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
-- Table structure for table `t_project_outertube`
--

DROP TABLE IF EXISTS `t_project_outertube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project_outertube` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(20) NOT NULL COMMENT '编号：长度10位、字段类型：字符型字（例S20170001）、要求自动编号，后四位取原有记录最大编号+1，年度四位取系统时间年度，每年重新编号，校验长度10位，不能为空，不能重复（唯一字段）',
  `taxpayer_identify_num` varchar(19) NOT NULL COMMENT '纳税人识别号：长度19位、字段类型：字符型（全角）、要求可以调用原有记录最新信息（纳税人名称、经办人姓名、电话），校验不能低于18位，不能大于19位，不能为空',
  `taxpayer_name` varchar(80) NOT NULL COMMENT '校验不能为空',
  `project_name` varchar(80) NOT NULL COMMENT '要求可以调用原有记录最新信息（纳税人识别号、纳税人名称、建设单位、工程总造价、企业所得税归属、是否完工信、联系电话），校验不能为空',
  `project_address` varchar(30) NOT NULL COMMENT '工程项目所在地: 要求默认新为新晃侗族自治县，校验不能为空',
  `project_constructor` varchar(80) NOT NULL COMMENT '工程发包方（建设方）:校验不能为空',
  `project_total_cost` decimal(16,2) DEFAULT NULL,
  `is_down` varchar(100) NOT NULL COMMENT '是否完工',
  `settlement_amount` decimal(16,2) DEFAULT NULL,
  `pre_appreciation_rate` decimal(16,2) DEFAULT NULL,
  `pre_appreciation_tax_amount` decimal(16,2) DEFAULT NULL,
  `pre_corporate_income_tax_rate` decimal(16,2) DEFAULT NULL,
  `pre_corporate_income_tax_amount` decimal(16,2) DEFAULT NULL,
  `urban_tax_rate` decimal(16,2) DEFAULT NULL,
  `urban_tax_amount` decimal(16,2) DEFAULT NULL,
  `education_addition_amount` decimal(16,2) DEFAULT NULL,
  `local_education_addition_amount` decimal(16,2) DEFAULT NULL,
  `stamp_duty_rate` decimal(16,2) DEFAULT NULL,
  `stamp_duty_amount` decimal(16,2) DEFAULT NULL,
  `labor_union_amount` decimal(16,2) DEFAULT NULL,
  `water_construct_amount` decimal(16,2) DEFAULT NULL,
  `is_invoiced` tinyint(4) DEFAULT NULL COMMENT '选择项，默认是否，是、否（判断纳税人类型，如为小规纳人可以代开发票，否不能选是）',
  `pay_tax_user` varchar(10) DEFAULT NULL COMMENT '纳税经办人：默认纳税人名称',
  `contacts_phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `operator_id` int(11) DEFAULT NULL COMMENT '经办人：登录人员姓名（单做表）',
  `duty_user_id` int(11) DEFAULT NULL COMMENT '负责人',
  `attachment_path` varchar(1000) DEFAULT NULL COMMENT '附件地址',
  `is_deleted` tinyint(4) DEFAULT NULL,
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `bureau_leader` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `duty_user_name` varchar(50) DEFAULT NULL,
  `pay_tax_user_type` varchar(50) DEFAULT NULL,
  `tax_type` varchar(50) DEFAULT NULL,
  `income_affiliation` varchar(20) DEFAULT NULL,
  `old_serial_num` varchar(50) DEFAULT NULL,
  `identify_no` varchar(100) DEFAULT NULL COMMENT '身份证',
  `memo` varchar(500) DEFAULT NULL,
  `constructor_identify_num` varchar(80) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='外管工程管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project_outertube`
--

LOCK TABLES `t_project_outertube` WRITE;
/*!40000 ALTER TABLE `t_project_outertube` DISABLE KEYS */;
INSERT INTO `t_project_outertube` VALUES (1,'W20170001','1232132112321','12321','321321','新晃侗族自治县','321321',3213213.00,'完工',123213.00,0.02,2220.05,0.00,222.01,0.05,222.01,66.60,44.40,0.00,369.64,133.20,66.60,0,'12321','',0,0,'',0,'2017-11-02 20:49:14',NULL,'admin','邓根林','一般纳税人','一般计税方法',NULL,NULL,NULL,NULL,'12321321234'),(2,'W20170002','1232132112321','12321','0129878','新晃侗族自治县','321321',3213213.00,'完工',1200.00,0.02,21.62,0.00,2.16,0.05,2.16,0.65,0.43,0.00,3.60,1.30,0.65,0,'12321','15210356782',0,0,'',0,'2017-11-29 20:45:32',NULL,'admin','邓根林','小规纳税人','老项目工程',NULL,NULL,NULL,NULL,'12321321234'),(3,'W20170003','1232132112321','12321','0129878','新晃侗族自治县','321321',3213213.00,'完工',1200.00,0.02,21.62,0.00,2.16,0.05,2.16,0.65,0.43,0.00,0.36,1.30,0.65,0,'12321','15210356782',0,0,'',0,'2017-12-07 20:21:17',NULL,'admin','邓根林','小规纳税人','一般计税方法','地税',NULL,NULL,NULL,'12321321234'),(4,'W20170004','1232132112321','12321','0129878','新晃侗族自治县','321321',3213213.00,'完工',12000.00,0.02,216.22,0.00,21.62,0.05,10.81,6.49,4.32,0.00,3.60,12.97,6.49,0,'12321','15210356782',0,0,'',0,'2017-12-07 20:23:43',NULL,'admin','邓根林','小规纳税人','一般计税方法',NULL,NULL,NULL,NULL,'12321321234'),(5,'W20170005','1232132112321','12321','0129878','新晃侗族自治县','321321',321312128.00,'完工',12000.00,0.02,216.22,0.00,21.62,0.05,21.62,6.49,4.32,0.00,3.60,12.97,6.49,0,'12321','15210356782',0,0,'',0,'2017-12-07 20:25:48',NULL,'admin','邓根林','小规纳税人','一般计税方法','国税',NULL,NULL,NULL,'12321321234'),(6,'W20180001','1232132112321','12321','01298781231','新晃侗族自治县','321321',932131212.00,'完工',212112432.00,0.02,20020.02,0.00,2002.00,0.05,2002.00,600.60,400.40,0.00,333.33,1201.20,600.60,0,'12321','15210356782',0,0,'',0,'2018-01-03 09:22:54',NULL,'admin','邓根林','小规纳税人','一般计税方法','地税',NULL,NULL,NULL,'12321321234');
/*!40000 ALTER TABLE `t_project_outertube` ENABLE KEYS */;
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
