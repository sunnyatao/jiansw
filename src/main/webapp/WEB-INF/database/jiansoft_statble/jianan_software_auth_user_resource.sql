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
-- Table structure for table `auth_user_resource`
--

DROP TABLE IF EXISTS `auth_user_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_user_resource` (
  `user_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1451 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user_resource`
--

LOCK TABLES `auth_user_resource` WRITE;
/*!40000 ALTER TABLE `auth_user_resource` DISABLE KEYS */;
INSERT INTO `auth_user_resource` VALUES (1034,2,24,'2017-04-08 08:24:30','superAdmin'),(1035,2,25,'2017-04-08 08:24:30','superAdmin'),(1036,2,26,'2017-04-08 08:24:30','superAdmin'),(1037,2,27,'2017-04-08 08:24:30','superAdmin'),(1038,2,28,'2017-04-08 08:24:30','superAdmin'),(1039,2,29,'2017-04-08 08:24:30','superAdmin'),(1040,2,30,'2017-04-08 08:24:30','superAdmin'),(1041,2,31,'2017-04-08 08:24:30','superAdmin'),(1042,2,32,'2017-04-08 08:24:30','superAdmin'),(1043,2,33,'2017-04-08 08:24:30','superAdmin'),(1044,2,34,'2017-04-08 08:24:30','superAdmin'),(1045,2,35,'2017-04-08 08:24:30','superAdmin'),(1046,2,36,'2017-04-08 08:24:30','superAdmin'),(1047,2,37,'2017-04-08 08:24:30','superAdmin'),(1048,2,38,'2017-04-08 08:24:30','superAdmin'),(1049,2,39,'2017-04-08 08:24:30','superAdmin'),(1050,2,40,'2017-04-08 08:24:30','superAdmin'),(1051,2,41,'2017-04-08 08:24:30','superAdmin'),(1052,2,42,'2017-04-08 08:24:30','superAdmin'),(1053,2,43,'2017-04-08 08:24:30','superAdmin'),(1054,2,44,'2017-04-08 08:24:30','superAdmin'),(1055,2,45,'2017-04-08 08:24:30','superAdmin'),(1056,2,46,'2017-04-08 08:24:30','superAdmin'),(1057,2,47,'2017-04-08 08:24:30','superAdmin'),(1058,2,49,'2017-04-08 08:24:30','superAdmin'),(1059,2,50,'2017-04-08 08:24:30','superAdmin'),(1060,2,51,'2017-04-08 08:24:30','superAdmin'),(1061,2,52,'2017-04-08 08:24:30','superAdmin'),(1062,2,53,'2017-04-08 08:24:30','superAdmin'),(1063,2,54,'2017-04-08 08:24:30','superAdmin'),(1064,2,55,'2017-04-08 08:24:30','superAdmin'),(1065,2,56,'2017-04-08 08:24:30','superAdmin'),(1066,2,57,'2017-04-08 08:24:30','superAdmin'),(1067,2,58,'2017-04-08 08:24:30','superAdmin'),(1068,2,59,'2017-04-08 08:24:30','superAdmin'),(1069,3,24,'2017-04-08 08:24:46','superAdmin'),(1070,3,25,'2017-04-08 08:24:46','superAdmin'),(1071,3,26,'2017-04-08 08:24:46','superAdmin'),(1072,3,27,'2017-04-08 08:24:46','superAdmin'),(1073,3,28,'2017-04-08 08:24:46','superAdmin'),(1074,3,29,'2017-04-08 08:24:46','superAdmin'),(1075,3,30,'2017-04-08 08:24:46','superAdmin'),(1076,3,31,'2017-04-08 08:24:46','superAdmin'),(1077,3,32,'2017-04-08 08:24:46','superAdmin'),(1078,3,33,'2017-04-08 08:24:46','superAdmin'),(1079,3,34,'2017-04-08 08:24:46','superAdmin'),(1080,3,35,'2017-04-08 08:24:46','superAdmin'),(1081,3,36,'2017-04-08 08:24:46','superAdmin'),(1082,3,37,'2017-04-08 08:24:46','superAdmin'),(1083,3,38,'2017-04-08 08:24:46','superAdmin'),(1084,3,39,'2017-04-08 08:24:46','superAdmin'),(1085,3,40,'2017-04-08 08:24:46','superAdmin'),(1086,3,41,'2017-04-08 08:24:46','superAdmin'),(1087,3,42,'2017-04-08 08:24:46','superAdmin'),(1088,3,43,'2017-04-08 08:24:46','superAdmin'),(1089,3,44,'2017-04-08 08:24:46','superAdmin'),(1090,3,45,'2017-04-08 08:24:46','superAdmin'),(1091,3,46,'2017-04-08 08:24:46','superAdmin'),(1092,3,47,'2017-04-08 08:24:46','superAdmin'),(1093,3,49,'2017-04-08 08:24:46','superAdmin'),(1094,3,50,'2017-04-08 08:24:46','superAdmin'),(1095,3,51,'2017-04-08 08:24:46','superAdmin'),(1096,3,52,'2017-04-08 08:24:46','superAdmin'),(1097,3,53,'2017-04-08 08:24:46','superAdmin'),(1098,3,54,'2017-04-08 08:24:46','superAdmin'),(1099,3,59,'2017-04-08 08:24:46','superAdmin'),(1131,5,24,'2017-04-14 22:50:45','superAdmin'),(1132,5,25,'2017-04-14 22:50:45','superAdmin'),(1133,5,26,'2017-04-14 22:50:45','superAdmin'),(1134,5,27,'2017-04-14 22:50:45','superAdmin'),(1135,5,28,'2017-04-14 22:50:45','superAdmin'),(1136,5,29,'2017-04-14 22:50:45','superAdmin'),(1137,5,30,'2017-04-14 22:50:45','superAdmin'),(1138,5,31,'2017-04-14 22:50:45','superAdmin'),(1139,5,32,'2017-04-14 22:50:45','superAdmin'),(1140,5,33,'2017-04-14 22:50:45','superAdmin'),(1141,5,34,'2017-04-14 22:50:45','superAdmin'),(1142,5,35,'2017-04-14 22:50:45','superAdmin'),(1143,5,36,'2017-04-14 22:50:45','superAdmin'),(1144,5,37,'2017-04-14 22:50:45','superAdmin'),(1145,5,38,'2017-04-14 22:50:45','superAdmin'),(1146,5,39,'2017-04-14 22:50:45','superAdmin'),(1147,5,40,'2017-04-14 22:50:45','superAdmin'),(1148,5,41,'2017-04-14 22:50:45','superAdmin'),(1149,5,42,'2017-04-14 22:50:45','superAdmin'),(1150,5,43,'2017-04-14 22:50:45','superAdmin'),(1151,5,44,'2017-04-14 22:50:45','superAdmin'),(1152,5,45,'2017-04-14 22:50:45','superAdmin'),(1153,5,46,'2017-04-14 22:50:45','superAdmin'),(1154,5,47,'2017-04-14 22:50:45','superAdmin'),(1155,5,49,'2017-04-14 22:50:45','superAdmin'),(1156,5,50,'2017-04-14 22:50:45','superAdmin'),(1157,5,51,'2017-04-14 22:50:45','superAdmin'),(1158,5,52,'2017-04-14 22:50:45','superAdmin'),(1159,5,53,'2017-04-14 22:50:45','superAdmin'),(1160,5,54,'2017-04-14 22:50:45','superAdmin'),(1161,5,59,'2017-04-14 22:50:45','superAdmin'),(1162,6,24,'2017-04-14 22:51:02','superAdmin'),(1163,6,25,'2017-04-14 22:51:02','superAdmin'),(1164,6,26,'2017-04-14 22:51:02','superAdmin'),(1165,6,27,'2017-04-14 22:51:02','superAdmin'),(1166,6,28,'2017-04-14 22:51:02','superAdmin'),(1167,6,29,'2017-04-14 22:51:02','superAdmin'),(1168,6,30,'2017-04-14 22:51:02','superAdmin'),(1169,6,31,'2017-04-14 22:51:02','superAdmin'),(1170,6,32,'2017-04-14 22:51:02','superAdmin'),(1171,6,33,'2017-04-14 22:51:02','superAdmin'),(1172,6,34,'2017-04-14 22:51:02','superAdmin'),(1173,6,35,'2017-04-14 22:51:02','superAdmin'),(1174,6,36,'2017-04-14 22:51:02','superAdmin'),(1175,6,37,'2017-04-14 22:51:02','superAdmin'),(1176,6,38,'2017-04-14 22:51:02','superAdmin'),(1177,6,39,'2017-04-14 22:51:02','superAdmin'),(1178,6,40,'2017-04-14 22:51:02','superAdmin'),(1179,6,41,'2017-04-14 22:51:02','superAdmin'),(1180,6,42,'2017-04-14 22:51:02','superAdmin'),(1181,6,43,'2017-04-14 22:51:02','superAdmin'),(1182,6,44,'2017-04-14 22:51:02','superAdmin'),(1183,6,45,'2017-04-14 22:51:02','superAdmin'),(1184,6,46,'2017-04-14 22:51:02','superAdmin'),(1185,6,47,'2017-04-14 22:51:02','superAdmin'),(1186,6,49,'2017-04-14 22:51:02','superAdmin'),(1187,6,50,'2017-04-14 22:51:02','superAdmin'),(1188,6,51,'2017-04-14 22:51:02','superAdmin'),(1189,6,52,'2017-04-14 22:51:02','superAdmin'),(1190,6,53,'2017-04-14 22:51:02','superAdmin'),(1191,6,54,'2017-04-14 22:51:02','superAdmin'),(1192,6,59,'2017-04-14 22:51:02','superAdmin'),(1193,7,24,'2017-04-14 22:51:18','superAdmin'),(1194,7,25,'2017-04-14 22:51:18','superAdmin'),(1195,7,26,'2017-04-14 22:51:18','superAdmin'),(1196,7,27,'2017-04-14 22:51:18','superAdmin'),(1197,7,28,'2017-04-14 22:51:18','superAdmin'),(1198,7,29,'2017-04-14 22:51:18','superAdmin'),(1199,7,30,'2017-04-14 22:51:18','superAdmin'),(1200,7,31,'2017-04-14 22:51:18','superAdmin'),(1201,7,32,'2017-04-14 22:51:18','superAdmin'),(1202,7,33,'2017-04-14 22:51:18','superAdmin'),(1203,7,34,'2017-04-14 22:51:18','superAdmin'),(1204,7,35,'2017-04-14 22:51:18','superAdmin'),(1205,7,36,'2017-04-14 22:51:18','superAdmin'),(1206,7,37,'2017-04-14 22:51:18','superAdmin'),(1207,7,38,'2017-04-14 22:51:18','superAdmin'),(1208,7,39,'2017-04-14 22:51:18','superAdmin'),(1209,7,40,'2017-04-14 22:51:18','superAdmin'),(1210,7,41,'2017-04-14 22:51:18','superAdmin'),(1211,7,42,'2017-04-14 22:51:18','superAdmin'),(1212,7,43,'2017-04-14 22:51:18','superAdmin'),(1213,7,44,'2017-04-14 22:51:18','superAdmin'),(1214,7,45,'2017-04-14 22:51:18','superAdmin'),(1215,7,46,'2017-04-14 22:51:18','superAdmin'),(1216,7,47,'2017-04-14 22:51:18','superAdmin'),(1217,7,49,'2017-04-14 22:51:18','superAdmin'),(1218,7,50,'2017-04-14 22:51:18','superAdmin'),(1219,7,51,'2017-04-14 22:51:18','superAdmin'),(1220,7,52,'2017-04-14 22:51:18','superAdmin'),(1221,7,53,'2017-04-14 22:51:18','superAdmin'),(1222,7,54,'2017-04-14 22:51:18','superAdmin'),(1223,7,59,'2017-04-14 22:51:18','superAdmin'),(1224,8,24,'2017-04-14 22:51:32','superAdmin'),(1225,8,25,'2017-04-14 22:51:32','superAdmin'),(1226,8,26,'2017-04-14 22:51:32','superAdmin'),(1227,8,27,'2017-04-14 22:51:32','superAdmin'),(1228,8,28,'2017-04-14 22:51:32','superAdmin'),(1229,8,29,'2017-04-14 22:51:32','superAdmin'),(1230,8,30,'2017-04-14 22:51:32','superAdmin'),(1231,8,31,'2017-04-14 22:51:32','superAdmin'),(1232,8,32,'2017-04-14 22:51:32','superAdmin'),(1233,8,33,'2017-04-14 22:51:32','superAdmin'),(1234,8,34,'2017-04-14 22:51:32','superAdmin'),(1235,8,35,'2017-04-14 22:51:32','superAdmin'),(1236,8,36,'2017-04-14 22:51:32','superAdmin'),(1237,8,37,'2017-04-14 22:51:32','superAdmin'),(1238,8,38,'2017-04-14 22:51:32','superAdmin'),(1239,8,39,'2017-04-14 22:51:32','superAdmin'),(1240,8,40,'2017-04-14 22:51:32','superAdmin'),(1241,8,41,'2017-04-14 22:51:32','superAdmin'),(1242,8,42,'2017-04-14 22:51:32','superAdmin'),(1243,8,43,'2017-04-14 22:51:32','superAdmin'),(1244,8,44,'2017-04-14 22:51:32','superAdmin'),(1245,8,45,'2017-04-14 22:51:32','superAdmin'),(1246,8,46,'2017-04-14 22:51:32','superAdmin'),(1247,8,47,'2017-04-14 22:51:32','superAdmin'),(1248,8,49,'2017-04-14 22:51:32','superAdmin'),(1249,8,50,'2017-04-14 22:51:32','superAdmin'),(1250,8,51,'2017-04-14 22:51:32','superAdmin'),(1251,8,52,'2017-04-14 22:51:32','superAdmin'),(1252,8,53,'2017-04-14 22:51:32','superAdmin'),(1253,8,54,'2017-04-14 22:51:32','superAdmin'),(1254,8,59,'2017-04-14 22:51:32','superAdmin'),(1255,9,24,'2017-04-16 21:51:24','superAdmin'),(1256,9,25,'2017-04-16 21:51:24','superAdmin'),(1257,9,26,'2017-04-16 21:51:24','superAdmin'),(1258,9,27,'2017-04-16 21:51:24','superAdmin'),(1259,9,28,'2017-04-16 21:51:24','superAdmin'),(1260,9,29,'2017-04-16 21:51:24','superAdmin'),(1261,9,30,'2017-04-16 21:51:24','superAdmin'),(1262,9,31,'2017-04-16 21:51:24','superAdmin'),(1263,9,32,'2017-04-16 21:51:24','superAdmin'),(1264,9,33,'2017-04-16 21:51:24','superAdmin'),(1265,9,34,'2017-04-16 21:51:24','superAdmin'),(1266,9,35,'2017-04-16 21:51:24','superAdmin'),(1267,9,36,'2017-04-16 21:51:24','superAdmin'),(1268,9,37,'2017-04-16 21:51:24','superAdmin'),(1269,9,38,'2017-04-16 21:51:24','superAdmin'),(1270,9,39,'2017-04-16 21:51:24','superAdmin'),(1271,9,40,'2017-04-16 21:51:24','superAdmin'),(1272,9,41,'2017-04-16 21:51:24','superAdmin'),(1273,9,42,'2017-04-16 21:51:24','superAdmin'),(1274,9,43,'2017-04-16 21:51:24','superAdmin'),(1275,9,44,'2017-04-16 21:51:24','superAdmin'),(1276,9,45,'2017-04-16 21:51:24','superAdmin'),(1277,9,46,'2017-04-16 21:51:24','superAdmin'),(1278,9,47,'2017-04-16 21:51:24','superAdmin'),(1279,9,49,'2017-04-16 21:51:24','superAdmin'),(1280,9,50,'2017-04-16 21:51:24','superAdmin'),(1281,9,51,'2017-04-16 21:51:24','superAdmin'),(1282,9,52,'2017-04-16 21:51:24','superAdmin'),(1283,9,53,'2017-04-16 21:51:24','superAdmin'),(1284,9,54,'2017-04-16 21:51:24','superAdmin'),(1285,9,55,'2017-04-16 21:51:24','superAdmin'),(1286,9,56,'2017-04-16 21:51:24','superAdmin'),(1287,9,57,'2017-04-16 21:51:24','superAdmin'),(1288,9,58,'2017-04-16 21:51:24','superAdmin'),(1289,9,59,'2017-04-16 21:51:24','superAdmin'),(1290,10,24,'2017-04-16 21:51:51','superAdmin'),(1291,10,25,'2017-04-16 21:51:51','superAdmin'),(1292,10,26,'2017-04-16 21:51:51','superAdmin'),(1293,10,27,'2017-04-16 21:51:51','superAdmin'),(1294,10,28,'2017-04-16 21:51:51','superAdmin'),(1295,10,29,'2017-04-16 21:51:51','superAdmin'),(1296,10,30,'2017-04-16 21:51:51','superAdmin'),(1297,10,31,'2017-04-16 21:51:51','superAdmin'),(1298,10,32,'2017-04-16 21:51:51','superAdmin'),(1299,10,33,'2017-04-16 21:51:51','superAdmin'),(1300,10,34,'2017-04-16 21:51:51','superAdmin'),(1301,10,35,'2017-04-16 21:51:51','superAdmin'),(1302,10,36,'2017-04-16 21:51:51','superAdmin'),(1303,10,37,'2017-04-16 21:51:51','superAdmin'),(1304,10,38,'2017-04-16 21:51:51','superAdmin'),(1305,10,39,'2017-04-16 21:51:51','superAdmin'),(1306,10,40,'2017-04-16 21:51:51','superAdmin'),(1307,10,41,'2017-04-16 21:51:51','superAdmin'),(1308,10,42,'2017-04-16 21:51:51','superAdmin'),(1309,10,43,'2017-04-16 21:51:51','superAdmin'),(1310,10,44,'2017-04-16 21:51:51','superAdmin'),(1311,10,45,'2017-04-16 21:51:51','superAdmin'),(1312,10,46,'2017-04-16 21:51:51','superAdmin'),(1313,10,47,'2017-04-16 21:51:51','superAdmin'),(1314,10,49,'2017-04-16 21:51:51','superAdmin'),(1315,10,50,'2017-04-16 21:51:51','superAdmin'),(1316,10,51,'2017-04-16 21:51:51','superAdmin'),(1317,10,52,'2017-04-16 21:51:51','superAdmin'),(1318,10,53,'2017-04-16 21:51:51','superAdmin'),(1319,10,54,'2017-04-16 21:51:51','superAdmin'),(1320,10,55,'2017-04-16 21:51:51','superAdmin'),(1321,10,56,'2017-04-16 21:51:51','superAdmin'),(1322,10,57,'2017-04-16 21:51:51','superAdmin'),(1323,10,58,'2017-04-16 21:51:51','superAdmin'),(1324,10,59,'2017-04-16 21:51:51','superAdmin'),(1325,11,24,'2017-04-16 21:52:27','superAdmin'),(1326,11,25,'2017-04-16 21:52:27','superAdmin'),(1327,11,26,'2017-04-16 21:52:27','superAdmin'),(1328,11,27,'2017-04-16 21:52:27','superAdmin'),(1329,11,28,'2017-04-16 21:52:27','superAdmin'),(1330,11,29,'2017-04-16 21:52:27','superAdmin'),(1331,11,30,'2017-04-16 21:52:27','superAdmin'),(1332,11,31,'2017-04-16 21:52:27','superAdmin'),(1333,11,32,'2017-04-16 21:52:27','superAdmin'),(1334,11,33,'2017-04-16 21:52:27','superAdmin'),(1335,11,34,'2017-04-16 21:52:27','superAdmin'),(1336,11,35,'2017-04-16 21:52:27','superAdmin'),(1337,11,36,'2017-04-16 21:52:27','superAdmin'),(1338,11,37,'2017-04-16 21:52:27','superAdmin'),(1339,11,38,'2017-04-16 21:52:27','superAdmin'),(1340,11,39,'2017-04-16 21:52:27','superAdmin'),(1341,11,40,'2017-04-16 21:52:27','superAdmin'),(1342,11,41,'2017-04-16 21:52:27','superAdmin'),(1343,11,42,'2017-04-16 21:52:27','superAdmin'),(1344,11,43,'2017-04-16 21:52:27','superAdmin'),(1345,11,44,'2017-04-16 21:52:27','superAdmin'),(1346,11,45,'2017-04-16 21:52:27','superAdmin'),(1347,11,46,'2017-04-16 21:52:27','superAdmin'),(1348,11,47,'2017-04-16 21:52:27','superAdmin'),(1349,11,49,'2017-04-16 21:52:27','superAdmin'),(1350,11,50,'2017-04-16 21:52:27','superAdmin'),(1351,11,51,'2017-04-16 21:52:27','superAdmin'),(1352,11,52,'2017-04-16 21:52:27','superAdmin'),(1353,11,53,'2017-04-16 21:52:27','superAdmin'),(1354,11,54,'2017-04-16 21:52:27','superAdmin'),(1355,11,59,'2017-04-16 21:52:27','superAdmin'),(1356,4,24,'2017-04-17 15:09:16','superAdmin'),(1357,4,25,'2017-04-17 15:09:16','superAdmin'),(1358,4,26,'2017-04-17 15:09:16','superAdmin'),(1359,4,27,'2017-04-17 15:09:16','superAdmin'),(1360,4,28,'2017-04-17 15:09:16','superAdmin'),(1361,4,29,'2017-04-17 15:09:16','superAdmin'),(1362,4,30,'2017-04-17 15:09:16','superAdmin'),(1363,4,31,'2017-04-17 15:09:16','superAdmin'),(1364,4,32,'2017-04-17 15:09:16','superAdmin'),(1365,4,33,'2017-04-17 15:09:16','superAdmin'),(1366,4,34,'2017-04-17 15:09:16','superAdmin'),(1367,4,35,'2017-04-17 15:09:16','superAdmin'),(1368,4,36,'2017-04-17 15:09:16','superAdmin'),(1369,4,37,'2017-04-17 15:09:16','superAdmin'),(1370,4,38,'2017-04-17 15:09:16','superAdmin'),(1371,4,39,'2017-04-17 15:09:16','superAdmin'),(1372,4,40,'2017-04-17 15:09:16','superAdmin'),(1373,4,41,'2017-04-17 15:09:16','superAdmin'),(1374,4,42,'2017-04-17 15:09:16','superAdmin'),(1375,4,43,'2017-04-17 15:09:16','superAdmin'),(1376,4,44,'2017-04-17 15:09:16','superAdmin'),(1377,4,45,'2017-04-17 15:09:16','superAdmin'),(1378,4,46,'2017-04-17 15:09:16','superAdmin'),(1379,4,47,'2017-04-17 15:09:16','superAdmin'),(1380,4,49,'2017-04-17 15:09:16','superAdmin'),(1381,4,50,'2017-04-17 15:09:16','superAdmin'),(1382,4,51,'2017-04-17 15:09:16','superAdmin'),(1383,4,52,'2017-04-17 15:09:16','superAdmin'),(1384,4,53,'2017-04-17 15:09:16','superAdmin'),(1385,4,54,'2017-04-17 15:09:16','superAdmin'),(1386,4,59,'2017-04-17 15:09:16','superAdmin'),(1387,4,8,'2017-04-17 15:09:16','superAdmin'),(1388,4,9,'2017-04-17 15:09:16','superAdmin'),(1389,1,24,'2017-07-23 16:50:36','superAdmin'),(1390,1,25,'2017-07-23 16:50:36','superAdmin'),(1391,1,26,'2017-07-23 16:50:36','superAdmin'),(1392,1,27,'2017-07-23 16:50:36','superAdmin'),(1393,1,28,'2017-07-23 16:50:36','superAdmin'),(1394,1,29,'2017-07-23 16:50:36','superAdmin'),(1395,1,30,'2017-07-23 16:50:36','superAdmin'),(1396,1,31,'2017-07-23 16:50:36','superAdmin'),(1397,1,32,'2017-07-23 16:50:36','superAdmin'),(1398,1,33,'2017-07-23 16:50:36','superAdmin'),(1399,1,34,'2017-07-23 16:50:36','superAdmin'),(1400,1,35,'2017-07-23 16:50:36','superAdmin'),(1401,1,36,'2017-07-23 16:50:36','superAdmin'),(1402,1,37,'2017-07-23 16:50:36','superAdmin'),(1403,1,38,'2017-07-23 16:50:36','superAdmin'),(1404,1,39,'2017-07-23 16:50:36','superAdmin'),(1405,1,40,'2017-07-23 16:50:36','superAdmin'),(1406,1,41,'2017-07-23 16:50:36','superAdmin'),(1407,1,42,'2017-07-23 16:50:36','superAdmin'),(1408,1,43,'2017-07-23 16:50:36','superAdmin'),(1409,1,44,'2017-07-23 16:50:36','superAdmin'),(1410,1,45,'2017-07-23 16:50:36','superAdmin'),(1411,1,46,'2017-07-23 16:50:36','superAdmin'),(1412,1,47,'2017-07-23 16:50:36','superAdmin'),(1413,1,49,'2017-07-23 16:50:36','superAdmin'),(1414,1,50,'2017-07-23 16:50:36','superAdmin'),(1415,1,51,'2017-07-23 16:50:36','superAdmin'),(1416,1,52,'2017-07-23 16:50:36','superAdmin'),(1417,1,53,'2017-07-23 16:50:36','superAdmin'),(1418,1,54,'2017-07-23 16:50:36','superAdmin'),(1419,1,55,'2017-07-23 16:50:36','superAdmin'),(1420,1,56,'2017-07-23 16:50:36','superAdmin'),(1421,1,57,'2017-07-23 16:50:36','superAdmin'),(1422,1,58,'2017-07-23 16:50:36','superAdmin'),(1423,1,59,'2017-07-23 16:50:36','superAdmin'),(1424,1,1,'2017-07-23 16:50:36','superAdmin'),(1425,1,2,'2017-07-23 16:50:36','superAdmin'),(1426,1,3,'2017-07-23 16:50:36','superAdmin'),(1427,1,4,'2017-07-23 16:50:36','superAdmin'),(1428,1,5,'2017-07-23 16:50:36','superAdmin'),(1429,1,6,'2017-07-23 16:50:36','superAdmin'),(1430,1,7,'2017-07-23 16:50:36','superAdmin'),(1431,1,8,'2017-07-23 16:50:36','superAdmin'),(1432,1,9,'2017-07-23 16:50:36','superAdmin'),(1433,1,10,'2017-07-23 16:50:36','superAdmin'),(1434,1,11,'2017-07-23 16:50:36','superAdmin'),(1435,1,12,'2017-07-23 16:50:36','superAdmin'),(1436,1,13,'2017-07-23 16:50:36','superAdmin'),(1437,1,14,'2017-07-23 16:50:36','superAdmin'),(1438,1,15,'2017-07-23 16:50:36','superAdmin'),(1439,1,16,'2017-07-23 16:50:36','superAdmin'),(1440,1,17,'2017-07-23 16:50:36','superAdmin'),(1441,1,18,'2017-07-23 16:50:36','superAdmin'),(1442,1,19,'2017-07-23 16:50:36','superAdmin'),(1443,1,20,'2017-07-23 16:50:36','superAdmin'),(1444,1,21,'2017-07-23 16:50:36','superAdmin'),(1445,1,22,'2017-07-23 16:50:36','superAdmin'),(1446,1,23,'2017-07-23 16:50:36','superAdmin'),(1447,1,60,'2017-07-23 16:50:36','superAdmin'),(1448,1,61,'2017-07-23 16:50:36','superAdmin'),(1449,1,62,'2017-07-23 16:50:36','superAdmin'),(1450,1,63,'2017-09-16 16:11:43',NULL);
/*!40000 ALTER TABLE `auth_user_resource` ENABLE KEYS */;
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