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
-- Table structure for table `t_project_settlement`
--

DROP TABLE IF EXISTS `t_project_settlement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project_settlement` (
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
  `service_producer_card_no` varchar(30) DEFAULT NULL COMMENT '供货方（服务提供方）身份证号码：',
  `service_producer_name` varchar(30) DEFAULT NULL COMMENT '供货方（服务提供方）姓名：',
  `cost_invoice_rate` decimal(16,2) DEFAULT NULL,
  `obtain_invoice_num` int(11) DEFAULT NULL COMMENT '已取得发票分数',
  `obtain_invoice_amount` decimal(16,2) DEFAULT NULL,
  `withhold_department` varchar(50) DEFAULT NULL COMMENT '代扣单位：默认为空，选择项，财政支付局、经建投、工建投',
  `withhold_tax_amount` decimal(16,2) DEFAULT NULL,
  `appreciation_local_tax_amount` decimal(16,2) DEFAULT NULL,
  `withhold_appreciation_local_tax_amount` decimal(16,2) DEFAULT NULL,
  `refund_tax_amount` decimal(16,2) DEFAULT NULL,
  `impose_department` varchar(200) DEFAULT NULL COMMENT '征收单位：默认为办税大厅，选择项，办税大厅、房产局',
  `pay_tax_user` varchar(50) DEFAULT NULL COMMENT '纳税经办人：默认纳税人名称',
  `contacts_phone` varchar(50) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL COMMENT '经办人：登录人员姓名（单做表）',
  `duty_user_id` int(11) DEFAULT NULL COMMENT '负责人',
  `bureau_leader` varchar(50) DEFAULT NULL,
  `attachment_path` varchar(1000) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `duty_user_name` varchar(50) DEFAULT NULL,
  `tax_serial_no` int(11) DEFAULT '0',
  `over_time` datetime DEFAULT NULL,
  `c_dkje` decimal(16,2) DEFAULT NULL,
  `c_zsje` decimal(16,2) DEFAULT NULL,
  `economic_nature` varchar(100) DEFAULT NULL,
  `old_serial_num` varchar(50) DEFAULT NULL,
  `memo` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='建安工程结算';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project_settlement`
--

LOCK TABLES `t_project_settlement` WRITE;
/*!40000 ALTER TABLE `t_project_settlement` DISABLE KEYS */;
INSERT INTO `t_project_settlement` VALUES (1,'J20170001','430181198801025970','1111','1111','新晃侗族自治县','1111',100001.23,'完工',100001.23,'1111','1111',0.65,1,1000.00,'财政支付局',1000.00,2982.56,NULL,1982.56,'办税大厅','1111','15210475409',0,0,'甘功勋',NULL,0,'2017-09-26 21:23:15','admin','邓根林',1,'2017-09-26 00:00:00',1000.00,1983.00,'个人',NULL,NULL),(2,'J20170002','430181198801025970','1111','1111','新晃侗族自治县','1111',20001.00,'完工',20001.00,'430181198801025970','2231',0.12,1,222.00,'财政支付局',31.00,101.50,NULL,70.50,'办税大厅','2231','15210475409',0,0,'甘功勋',NULL,0,'2017-09-26 22:30:19','admin','邓根林',0,'2017-09-19 00:00:00',31.00,71.00,'个人',NULL,NULL),(3,'J20170003','430181198','1111','11111','新晃侗族自治县','1111',200012.00,'完工',200012.00,'430181198801025970','1121',0.65,1,23.00,'请选择',23.00,6057.54,NULL,6034.54,'办税大厅','1121','15210475409',0,0,'甘功勋',NULL,0,'2017-09-26 22:38:59','admin','邓根林',0,'2017-09-21 00:00:00',23.00,6035.00,'个人',NULL,NULL),(5,'J20170004','430181198','1111','221121','新晃侗族自治县','1111',200012.00,'完工',200012.00,'2222222222','222',0.65,1,122.00,'财政支付局',1222.00,6052.93,NULL,4830.93,'办税大厅','222','15210475409',0,0,'甘功勋',NULL,0,'2017-11-29 20:42:56','admin','邓根林',0,'2017-11-23 00:00:00',1222.00,4831.00,'个人',NULL,NULL),(6,'J20180001','430181198','1111','221121','新晃侗族自治县','1111',20001212.00,'完工',20001212.00,'1222222222222222222','123',0.65,1,213.40,'请选择',123.10,605852.00,NULL,605728.94,'办税大厅','123','15210475409',0,0,'甘功勋',NULL,0,'2018-01-03 09:22:29','admin','邓根林',0,'2018-01-26 00:00:00',123.00,605729.00,'个人',NULL,NULL),(7,'J20180002','430181198801025979','新晃侗族自治县开发公司','新晃侗族自治县222','新晃侗族自治县','新晃侗族自治县111',892819191.00,'完工',892819191.00,'430181198801025979','王琳琳',0.65,2,17891927.00,'财政支付局',23.00,26210821.61,NULL,26210798.61,'办税大厅','王琳琳','13211111111',0,0,'甘功勋',NULL,0,'2018-07-23 18:22:09','admin','邓根林',0,'2018-07-17 00:00:00',23.00,26210799.00,'个人',NULL,NULL),(8,'J20180003','121212121212121','121212','12121','新晃侗族自治县12','222',112212121212.00,'完工',112212121212.00,'430181198891019282','123213',0.65,12,22.00,'财政支付局',123.00,3399046777.44,NULL,3399046654.44,'办税大厅','123213','',0,0,'甘功勋',NULL,0,'2018-09-03 22:02:43','admin','邓根林',0,'2018-09-03 00:00:00',123.00,3399046654.44,'个人',NULL,NULL);
/*!40000 ALTER TABLE `t_project_settlement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-28 10:46:08
