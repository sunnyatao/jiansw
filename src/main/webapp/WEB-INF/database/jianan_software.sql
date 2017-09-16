/*
Navicat MySQL Data Transfer

Source Server         : root-localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : jianan_software

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-03-04 12:37:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `auth_navigation`;
CREATE TABLE `auth_navigation` (
  `nav_id` int(11) NOT NULL AUTO_INCREMENT,
  `nav_name` varchar(100) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `sort_value` int(11) DEFAULT NULL,
  `resource_id` int(11) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `nav_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_navigation
-- ----------------------------
INSERT INTO `auth_navigation` VALUES ('5', '权限管理', '0', '1', '5', null, '2017-02-01 08:24:32', '1');
INSERT INTO `auth_navigation` VALUES ('6', '资源管理', '5', '3', '1', null, '2017-02-25 09:41:42', '2');
INSERT INTO `auth_navigation` VALUES ('7', '用户管理', '5', '2', '5', null, '2017-02-25 09:42:18', '2');
INSERT INTO `auth_navigation` VALUES ('9', '导航管理', '5', '4', '20', null, '2017-02-25 09:44:10', '2');
INSERT INTO `auth_navigation` VALUES ('11', '角色管理', '5', '5', '15', null, '2017-02-25 09:44:53', '2');
INSERT INTO `auth_navigation` VALUES ('12', '业务管理', '0', '6', '29', null, '2017-02-25 16:54:40', '1');
INSERT INTO `auth_navigation` VALUES ('13', '工程审核管理', '12', '7', '29', null, '2017-02-25 16:55:19', '2');
INSERT INTO `auth_navigation` VALUES ('16', '工程结算管理', '12', '8', '37', null, '2017-02-25 17:24:39', '2');
INSERT INTO `auth_navigation` VALUES ('18', '外管工程管理', '12', '10', '44', null, '2017-02-25 21:18:23', '2');
INSERT INTO `auth_navigation` VALUES ('20', '房屋契税管理', '12', '12', '49', null, '2017-02-26 19:20:30', '2');
INSERT INTO `auth_navigation` VALUES ('21', '房屋契税添加', '12', '13', '50', null, '2017-02-26 19:50:09', '3');
INSERT INTO `auth_navigation` VALUES ('22', '房屋契税详情', '12', '14', '51', null, '2017-02-26 19:53:13', '3');
INSERT INTO `auth_navigation` VALUES ('23', '工程审核-添加', '12', '15', '26', null, '2017-02-26 19:53:48', '3');
INSERT INTO `auth_navigation` VALUES ('24', '工程审核-详情', '12', '16', '28', null, '2017-02-26 19:55:07', '3');
INSERT INTO `auth_navigation` VALUES ('25', '工程审核-添加税票信息', '12', '17', '30', null, '2017-02-26 19:56:27', '3');
INSERT INTO `auth_navigation` VALUES ('26', '工程结算-添加', '12', '18', '34', null, '2017-02-26 19:56:59', '3');
INSERT INTO `auth_navigation` VALUES ('27', '工程结算-详情', '12', '19', '36', null, '2017-02-26 19:58:16', '3');
INSERT INTO `auth_navigation` VALUES ('28', '工程结算-添加税票信息', '12', '20', '38', null, '2017-02-26 20:00:07', '3');
INSERT INTO `auth_navigation` VALUES ('29', '外管工程-添加', '12', '21', '41', null, '2017-02-26 20:01:32', '3');
INSERT INTO `auth_navigation` VALUES ('30', '外管工程-详情', '12', '22', '43', null, '2017-02-26 20:01:48', '3');
INSERT INTO `auth_navigation` VALUES ('31', '外管工程-添加税票信息', '12', '23', '45', null, '2017-02-26 20:02:13', '3');
INSERT INTO `auth_navigation` VALUES ('32', '数据查询管理', '12', '24', '52', null, '2017-02-26 20:22:00', '2');

-- ----------------------------
-- Table structure for `auth_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) NOT NULL,
  `resource_type` int(11) DEFAULT NULL,
  `resource_path` varchar(200) NOT NULL,
  `resource_desc` varchar(200) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource` VALUES ('1', '资源-资源列表', '2', '/crm/v1/auth/resource/list', '资源-资源列表', '2017-02-24 23:32:29', null);
INSERT INTO `auth_resource` VALUES ('2', '资源-保存资源', '2', '/crm/v1/auth/resource/ajax/save', '资源-保存资源', '2017-02-24 23:33:35', null);
INSERT INTO `auth_resource` VALUES ('3', '资源-资源列表ajax', '2', '/crm/v1/auth/resource/ajax/list', '资源-资源列表ajax', '2017-02-24 23:33:31', null);
INSERT INTO `auth_resource` VALUES ('4', '资源-删除资源', '2', '/crm/v1/auth/resource/ajax/delete', '资源-删除资源', '2017-02-24 23:34:16', null);
INSERT INTO `auth_resource` VALUES ('5', '管理员-管理员列表', '2', '/crm/v1/admin/user/list', '管理员-管理员列表', '2017-02-24 23:35:32', null);
INSERT INTO `auth_resource` VALUES ('6', '管理员-角色列表', '2', '/crm/v1/admin/getRoles', '管理员-角色列表', '2017-02-24 23:37:04', null);
INSERT INTO `auth_resource` VALUES ('7', '管理员-创建保存管理员', '2', '/crm/v1/admin/ajax/save', '管理员-创建保存管理员', '2017-02-24 23:37:37', null);
INSERT INTO `auth_resource` VALUES ('8', '管理员-编辑密码', '2', '/crm/v1/admin/ajax/editPassword', '管理员-编辑密码', '2017-02-24 23:38:39', null);
INSERT INTO `auth_resource` VALUES ('9', '管理员-保存密码', '2', '/crm/v1/admin/ajax/updatePassword', '管理员-保存密码', '2017-02-24 23:39:29', null);
INSERT INTO `auth_resource` VALUES ('10', '管理员-修改用户状态', '2', '/crm/v1/admin/ajax/changeUserStatus', '管理员-修改用户状态', '2017-02-24 23:47:02', null);
INSERT INTO `auth_resource` VALUES ('11', '管理员-分配导航', '2', '/crm/v1/admin/ajax/dispatchNavigation', '管理员-分配导航', '2017-02-25 08:14:08', null);
INSERT INTO `auth_resource` VALUES ('12', '管理员-用户资源列表', '2', '/crm/v1/admin/user/resource/list', '管理员-用户资源列表', '2017-02-24 23:40:59', null);
INSERT INTO `auth_resource` VALUES ('13', '管理员-设置用户资源', '2', '/crm/v1/admin/ajax/user_resource/set', '管理员-设置用户资源', '2017-02-24 23:41:38', null);
INSERT INTO `auth_resource` VALUES ('14', '管理员-修改用户信息', '2', '/crm/v1/admin/updateUserInfo', '管理员-修改用户信息', '2017-02-24 23:42:15', null);
INSERT INTO `auth_resource` VALUES ('15', '角色-列表', '2', '/crm/v1/role/admin/toRoleRoute', '角色-列表', '2017-02-24 23:43:20', null);
INSERT INTO `auth_resource` VALUES ('16', '角色-删除角色', '2', '/crm/v1/role/ajax/deleteRole', '删除角色', '2017-02-24 23:43:43', null);
INSERT INTO `auth_resource` VALUES ('17', '角色-获取角色资源', '2', '/crm/v1/role/ajax/getRoles', '角色-获取角色资源', '2017-02-24 23:44:33', null);
INSERT INTO `auth_resource` VALUES ('18', '角色-创建修改角色', '2', '/crm/v1/role/ajax/updateOrInsert', '角色-创建修改角色', '2017-02-24 23:45:41', null);
INSERT INTO `auth_resource` VALUES ('19', '导航-异步列表', '2', '/crm/v1/navigation/ajax/navigation/list', '导航-异步列表', '2017-02-25 09:29:39', null);
INSERT INTO `auth_resource` VALUES ('20', '导航-列表', '2', '/crm/v1/navigation/list', '导航-列表', '2017-02-25 09:30:11', null);
INSERT INTO `auth_resource` VALUES ('21', '导航-异步保存', '2', '/crm/v1/navigation/ajax/save', '导航-异步保存', '2017-02-25 09:30:52', null);
INSERT INTO `auth_resource` VALUES ('22', '导航-获取子列表', '2', '/crm/v1/navigation/ajax/getNavListByParentId', '导航-获取子列表', '2017-02-25 09:33:03', null);
INSERT INTO `auth_resource` VALUES ('23', '导航-删除导航', '2', '/ajax/deleteNav', '导航-删除导航', '2017-02-25 09:33:29', null);
INSERT INTO `auth_resource` VALUES ('24', '工程审核-异步根据纳税唯一号获取信息', '1', '/projectcheck/api/get_by/identifynum', '工程审核-异步根据纳税唯一号获取信息', '2017-02-25 16:45:09', null);
INSERT INTO `auth_resource` VALUES ('25', '工程审核-异步根据工程名称获取信息', '1', '/projectcheck/api/get_by/projectname', '工程审核-异步根据工程名称获取信息', '2017-02-25 16:45:49', null);
INSERT INTO `auth_resource` VALUES ('26', '工程审核-添加工程审核信息', '1', '/projectcheck/toadd', '工程审核-添加工程审核信息', '2017-02-25 16:49:01', null);
INSERT INTO `auth_resource` VALUES ('27', '工程审核-创建审核信息', '1', '/projectcheck/submit', '工程审核-创建审核信息', '2017-02-25 16:50:31', null);
INSERT INTO `auth_resource` VALUES ('28', '工程审核-查看审核工程信息详情', '1', '/projectcheck/toview', '工程信息-查看审核工程信息详情', '2017-02-25 16:52:00', null);
INSERT INTO `auth_resource` VALUES ('29', '工程审核-列表', '1', '/projectcheck/list', '工程审核-列表', '2017-02-25 16:51:53', null);
INSERT INTO `auth_resource` VALUES ('30', '工程审核-添加税票信息', '1', '/projectcheck/taxinfo/toadd', '工程审核-添加税票信息', '2017-02-25 16:52:31', null);
INSERT INTO `auth_resource` VALUES ('31', '工程审核-提交税票信息', '1', '/projectcheck/taxinfo/submit', '工程审核-提交税票信息', '2017-02-25 16:53:44', null);
INSERT INTO `auth_resource` VALUES ('32', '工程结算-异步根据纳税唯一号获取信息', '1', '/projectsettlement/api/get_by/identifynum', '工程结算-异步根据纳税唯一号获取信息', '2017-02-25 16:57:25', null);
INSERT INTO `auth_resource` VALUES ('33', '工程结算-异步根据工程名称获取信息', '1', '/projectsettlement/api/get_by/projectname', '工程结算-异步根据工程名称获取信息', '2017-02-25 16:57:48', null);
INSERT INTO `auth_resource` VALUES ('34', '工程结算-添加工程审核信息', '1', '/projectsettlement/toadd', '工程结算-添加工程审核信息', '2017-02-25 16:58:24', null);
INSERT INTO `auth_resource` VALUES ('35', '工程结算-创建结算信息', '1', '/projectsettlement/submit', '工程结算-创建结算信息', '2017-02-26 19:59:16', null);
INSERT INTO `auth_resource` VALUES ('36', '工程结算-查看工程结算信息详情', '1', '/projectsettlement/toview', '工程结算-查看工程结算信息详情', '2017-02-26 19:58:53', null);
INSERT INTO `auth_resource` VALUES ('37', '工程结算-列表', '1', '/projectsettlement/list', '工程结算-列表', '2017-02-25 17:03:56', null);
INSERT INTO `auth_resource` VALUES ('38', '工程结算-添加税票信息', '1', '/projectsettlement/taxinfo/toadd', '工程结算-提交税票信息', '2017-02-25 17:04:25', null);
INSERT INTO `auth_resource` VALUES ('39', '外管工程-异步根据纳税唯一号获取信息', '1', '/projectouterube/api/get_by/identifynum', '外管工程-异步根据纳税唯一号获取信息', '2017-02-25 21:12:13', null);
INSERT INTO `auth_resource` VALUES ('40', '外管工程-异步根据工程名称获取信息', '1', '/projectouterube/api/get_by/projectname', '外管工程-异步根据工程名称获取信息', '2017-02-25 21:12:57', null);
INSERT INTO `auth_resource` VALUES ('41', '外管工程-添加工程审核信息', '1', '/projectouterube/toadd', '外管工程-添加工程审核信息', '2017-02-25 21:13:25', null);
INSERT INTO `auth_resource` VALUES ('42', '外管工程-创建审核信息', '1', '/projectouterube/submit', '工程结算-创建审核信息', '2017-02-25 21:14:06', null);
INSERT INTO `auth_resource` VALUES ('43', '外管工程-查看审核工程信息详情', '1', '/projectouterube/toview', '外管工程-查看审核工程信息详情', '2017-02-25 21:14:32', null);
INSERT INTO `auth_resource` VALUES ('44', '外管工程-列表', '1', '/projectouterube/list', '外管工程-列表', '2017-02-25 21:15:03', null);
INSERT INTO `auth_resource` VALUES ('45', '外管工程-添加税票信息', '1', '/projectouterube/taxinfo/toadd', '外管工程-添加税票信息', '2017-02-25 21:15:28', null);
INSERT INTO `auth_resource` VALUES ('46', '外管工程-提交税票信息', '1', '/projectouterube/taxinfo/submit', '外管工程-提交税票信息', '2017-02-25 21:16:32', null);
INSERT INTO `auth_resource` VALUES ('47', '工程结算-提交税票信息', '1', '/projectsettlement/taxinfo/submit', '工程结算-提交税票信息', '2017-02-25 21:17:34', null);
INSERT INTO `auth_resource` VALUES ('49', '房屋契税-列表', '1', '/housecontract/list', '房屋契税-列表', '2017-02-26 19:19:25', null);
INSERT INTO `auth_resource` VALUES ('50', '房屋契税-添加', '1', '/housecontract/toadd', '房屋契税-添加', '2017-02-26 19:19:57', null);
INSERT INTO `auth_resource` VALUES ('51', '房屋契税-详情', '1', '/housecontract/toview', '房屋契税-详情', '2017-02-26 19:52:37', null);
INSERT INTO `auth_resource` VALUES ('52', '数据查询-跳转页面', '1', '/summary/search', '数据查询-跳转页面', '2017-02-26 20:21:26', null);

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('1', 'superadmin', 'superadmin', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role` VALUES ('3', '业务管理员', '所有业务相关操作', '2017-02-26 20:09:11', 'superAdmin');

-- ----------------------------
-- Table structure for `auth_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_resource`;
CREATE TABLE `auth_role_resource` (
  `role_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_resource
-- ----------------------------
INSERT INTO `auth_role_resource` VALUES ('1', '1', '1', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('2', '1', '2', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('3', '1', '3', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('4', '1', '4', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('5', '1', '5', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('6', '1', '6', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('7', '1', '7', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('8', '1', '8', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('9', '1', '9', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('10', '1', '10', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('11', '1', '11', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('12', '1', '12', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('13', '1', '13', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('14', '1', '14', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('15', '1', '15', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('16', '1', '16', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('17', '1', '17', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('18', '1', '18', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('19', '1', '19', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('20', '1', '20', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('21', '1', '21', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('22', '1', '22', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('23', '1', '23', '2017-02-25 09:46:42', 'superadmin');
INSERT INTO `auth_role_resource` VALUES ('48', '3', '24', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('49', '3', '25', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('50', '3', '26', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('51', '3', '27', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('52', '3', '28', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('53', '3', '29', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('54', '3', '30', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('55', '3', '31', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('56', '3', '32', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('57', '3', '33', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('58', '3', '34', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('59', '3', '35', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('60', '3', '36', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('61', '3', '37', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('62', '3', '38', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('63', '3', '39', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('64', '3', '40', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('65', '3', '41', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('66', '3', '42', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('67', '3', '43', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('68', '3', '44', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('69', '3', '45', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('70', '3', '46', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('71', '3', '47', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('72', '3', '49', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('73', '3', '50', '2017-02-26 20:09:11', 'superAdmin');
INSERT INTO `auth_role_resource` VALUES ('74', '3', '51', '2017-02-26 20:09:11', 'superAdmin');

-- ----------------------------
-- Table structure for `auth_user_nav`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_nav`;
CREATE TABLE `auth_user_nav` (
  `unav_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `nav_id` int(11) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`unav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_nav
-- ----------------------------
INSERT INTO `auth_user_nav` VALUES ('4', '1', '12', '2017-02-25 17:13:48', null);
INSERT INTO `auth_user_nav` VALUES ('5', '1', '5', '2017-02-25 17:13:48', null);

-- ----------------------------
-- Table structure for `auth_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_resource`;
CREATE TABLE `auth_user_resource` (
  `user_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=484 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_resource
-- ----------------------------
INSERT INTO `auth_user_resource` VALUES ('303', '2', '24', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('304', '2', '25', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('305', '2', '26', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('306', '2', '27', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('307', '2', '28', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('308', '2', '29', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('309', '2', '30', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('310', '2', '31', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('311', '2', '32', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('312', '2', '33', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('313', '2', '34', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('314', '2', '35', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('315', '2', '36', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('316', '2', '37', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('317', '2', '38', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('318', '2', '39', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('319', '2', '40', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('320', '2', '41', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('321', '2', '42', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('322', '2', '43', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('323', '2', '44', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('324', '2', '45', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('325', '2', '46', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('326', '2', '47', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('327', '2', '49', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('328', '2', '50', '2017-02-26 19:22:21', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('356', '3', '24', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('357', '3', '25', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('358', '3', '26', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('359', '3', '27', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('360', '3', '28', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('361', '3', '29', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('362', '3', '30', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('363', '3', '31', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('364', '3', '32', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('365', '3', '33', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('366', '3', '34', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('367', '3', '35', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('368', '3', '36', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('369', '3', '37', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('370', '3', '38', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('371', '3', '39', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('372', '3', '40', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('373', '3', '41', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('374', '3', '42', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('375', '3', '43', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('376', '3', '44', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('377', '3', '45', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('378', '3', '46', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('379', '3', '47', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('380', '3', '49', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('381', '3', '50', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('382', '3', '51', '2017-02-26 20:11:18', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('433', '1', '24', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('434', '1', '25', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('435', '1', '26', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('436', '1', '27', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('437', '1', '28', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('438', '1', '29', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('439', '1', '30', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('440', '1', '31', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('441', '1', '32', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('442', '1', '33', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('443', '1', '34', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('444', '1', '35', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('445', '1', '36', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('446', '1', '37', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('447', '1', '38', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('448', '1', '39', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('449', '1', '40', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('450', '1', '41', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('451', '1', '42', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('452', '1', '43', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('453', '1', '44', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('454', '1', '45', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('455', '1', '46', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('456', '1', '47', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('457', '1', '49', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('458', '1', '50', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('459', '1', '51', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('460', '1', '52', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('461', '1', '1', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('462', '1', '2', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('463', '1', '3', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('464', '1', '4', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('465', '1', '5', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('466', '1', '6', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('467', '1', '7', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('468', '1', '8', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('469', '1', '9', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('470', '1', '10', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('471', '1', '11', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('472', '1', '12', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('473', '1', '13', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('474', '1', '14', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('475', '1', '15', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('476', '1', '16', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('477', '1', '17', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('478', '1', '18', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('479', '1', '19', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('480', '1', '20', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('481', '1', '21', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('482', '1', '22', '2017-02-26 20:23:25', 'superAdmin');
INSERT INTO `auth_user_resource` VALUES ('483', '1', '23', '2017-02-26 20:23:25', 'superAdmin');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES ('2', '3', '3', '2017-02-26 20:09:51', 'superAdmin');

-- ----------------------------
-- Table structure for `crm_admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `crm_admin_user`;
CREATE TABLE `crm_admin_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_admin_user
-- ----------------------------
INSERT INTO `crm_admin_user` VALUES ('1', 'superAdmin', 'f0df7414507bcb57e07e18555821228a', '1', '2017-03-04 10:23:50', '2017-02-24 23:13:23', null, '1');
INSERT INTO `crm_admin_user` VALUES ('2', '业务员1', 'fc73078b8fd3e52fca482a2c2c0d622a', '3139', '2017-02-26 20:28:02', '2017-02-26 11:07:40', null, '1');
INSERT INTO `crm_admin_user` VALUES ('3', '业务员2', '38e5a6ea454c91ee7a9672f942da8a59', '3872', '2017-02-26 20:11:37', '2017-02-26 20:09:51', null, '1');

-- ----------------------------
-- Table structure for `t_duty_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_duty_user`;
CREATE TABLE `t_duty_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_duty_user
-- ----------------------------
INSERT INTO `t_duty_user` VALUES ('1', '王珊', '0');
INSERT INTO `t_duty_user` VALUES ('2', '李明', '0');
INSERT INTO `t_duty_user` VALUES ('3', '邹玉', '0');

-- ----------------------------
-- Table structure for `t_house_contract`
-- ----------------------------
DROP TABLE IF EXISTS `t_house_contract`;
CREATE TABLE `t_house_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `floor_name` varchar(100) DEFAULT NULL COMMENT '楼栋',
  `serial_no` varchar(100) DEFAULT NULL,
  `area` decimal(10,2) DEFAULT NULL COMMENT '面积',
  `unit_price` decimal(10,2) DEFAULT '0.00' COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT '0.00' COMMENT '房屋总价',
  `contract_tax_rate` decimal(10,4) DEFAULT '0.0000' COMMENT '契税税率',
  `contract_tax` decimal(10,2) DEFAULT '0.00' COMMENT '契税税额',
  `card_no` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `contract_date` datetime DEFAULT NULL COMMENT '合同签订日期',
  `contract_down` varchar(10) DEFAULT NULL,
  `first_payment_amount` decimal(10,2) DEFAULT NULL,
  `mortgage_amount` decimal(10,2) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house_contract
-- ----------------------------
INSERT INTO `t_house_contract` VALUES ('1', '廖明生', '辉煌国际25栋', '6-1001', '120.00', '6100.00', '720000.00', '0.0200', '6000.00', '430181190008129087', '2017-01-26 16:14:31', '是', '2500000.00', '4000.00', '1', 'superAdmin', '2017-02-26 16:15:00');
INSERT INTO `t_house_contract` VALUES ('2', '戴德利', '辉煌国际25栋', '6-1002', '91.00', '6300.00', '600000.00', '0.0300', '18000.00', '120189198801037862', '2016-10-10 00:00:00', '是', '120000.00', '4000.00', '1', 'superAdmin', '2017-02-26 19:30:33');

-- ----------------------------
-- Table structure for `t_project_check`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_check`;
CREATE TABLE `t_project_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(20) NOT NULL COMMENT '编号：长度10位、字段类型：字符型字（例S20170001）、要求自动编号，后四位取原有记录最大编号+1，年度四位取系统时间年度，每年重新编号，校验长度10位，不能为空，不能重复（唯一字段）',
  `taxpayer_identify_num` varchar(19) NOT NULL COMMENT '纳税人识别号：长度19位、字段类型：字符型（全角）、要求可以调用原有记录最新信息（纳税人名称、经办人姓名、电话），校验不能低于18位，不能大于19位，不能为空',
  `taxpayer_name` varchar(80) NOT NULL COMMENT '校验不能为空',
  `project_name` varchar(80) NOT NULL COMMENT '要求可以调用原有记录最新信息（纳税人识别号、纳税人名称、建设单位、工程总造价、企业所得税归属、是否完工信、联系电话），校验不能为空',
  `project_address` varchar(30) NOT NULL COMMENT '工程项目所在地: 要求默认新为新晃侗族自治县，校验不能为空',
  `project_constructor` varchar(80) NOT NULL COMMENT '工程发包方（建设方）:校验不能为空',
  `project_total_cost` decimal(10,0) NOT NULL COMMENT '工程总造价:数值型，校验不能为空',
  `is_down` tinyint(4) NOT NULL COMMENT '是否完工',
  `invoice_amount` decimal(10,2) NOT NULL COMMENT '本次开票金额: 字段类型：数值型，要求默认为工程总造价，校验不能为空',
  `appreciation_rate` decimal(10,4) NOT NULL COMMENT '增值税率：选择项 ，3%，5%（默认3%），后面直接显示税额（（本次开票金额/1+税率）*税率）',
  `appreciation_tax_amount` decimal(10,2) NOT NULL COMMENT '税额（（本次开票金额/1+税率）*税率）',
  `income_rate` decimal(10,4) NOT NULL COMMENT '所得税率：选择项 ，1.5%，2%（默认1.5%），后面直接显示税额（（本次开票金额/1+税率）*税率）',
  `income_tax_amount` decimal(10,2) NOT NULL,
  `income_affiliation` varchar(10) NOT NULL COMMENT '所得税归属：选择项 ，国税、地税（默认地税）',
  `urban_tax_rate` decimal(10,4) NOT NULL COMMENT '城建费附加:\r\n            选择项 ，10%，5%（默认5%）',
  `urban_tax_amount` decimal(10,2) DEFAULT NULL COMMENT '城建税额',
  `education_addition_amount` decimal(10,2) NOT NULL COMMENT '教育费附加：后面直接显示税额（增值税额*3%）',
  `local_education_addition_amount` decimal(10,2) NOT NULL COMMENT '地方教育费附加：后面直接显示税额（增值税额*2%）',
  `stamp_duty_rate` decimal(10,4) DEFAULT NULL COMMENT '印花税率:\r\n            选择项 ，3%%，（默认3%%）',
  `stamp_duty_amount` decimal(10,2) DEFAULT NULL COMMENT '本次开票金额*税率',
  `labor_union_amount` decimal(10,2) DEFAULT NULL COMMENT '工会经费：后面直接显示税额（（本次开票金额/1+税率）*0.12%）',
  `water_construct_amount` decimal(10,2) DEFAULT NULL COMMENT '水利建设专项收入：后面直接显示税额（（本次开票金额/1+税率）*0.06%）',
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_project_check_serial_num` (`serial_num`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='建安发票代开审核';

-- ----------------------------
-- Records of t_project_check
-- ----------------------------
INSERT INTO `t_project_check` VALUES ('3', 'S20170001', '1234567890981716543', '刘涛', '新晃侗族自治县大马路', '新晃侗族自治县', '新晃侗族自治县委', '1900201', '1', '1900201.00', '0.0300', '57006.03', '0.0150', '28503.02', '地税', '0.0500', '2850.30', '1710.18', '1140.12', '0.0030', '5700.60', '2213.83', '1106.91', '刘涛', '15210475409', '0', '0', null, '0', '2017-02-21 22:24:12', null, null, null);
INSERT INTO `t_project_check` VALUES ('4', 'S20170002', '1234567890981716543', '吴斌', '新晃侗族自治县大马路', '新晃侗族自治县', '新晃侗族自治县政府', '890200', '1', '890200.00', '0.0300', '26706.00', '0.0150', '13353.00', '地税', '0.0500', '1335.30', '801.18', '534.12', '0.0030', '2670.60', '1037.13', '518.56', '吴斌', '15210475409', '0', '0', null, '0', '2017-02-21 23:30:33', null, null, null);
INSERT INTO `t_project_check` VALUES ('5', 'S20170003', '1234567890981716543', 'tanker', '新晃侗族自治县征收1期', '新晃侗族自治县', '新晃侗族自治县清', '2890200', '1', '2890200.00', '0.0500', '86706.00', '0.0150', '43353.00', '国税', '0.0500', '4335.30', '2601.18', '1734.12', '0.0030', '8670.60', '3367.22', '1683.61', '沈天明', '15678727782', '0', '0', null, '0', '2017-02-22 11:41:14', null, null, null);
INSERT INTO `t_project_check` VALUES ('6', 'S20170004', '123456789098171654L', '李明利', '新晃侗族自治县征收4期', '新晃侗族自治县', 'xxxx', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0030', '600.00', '233.01', '116.50', '韩德军', '18910876786', '0', '0', null, '0', '2017-02-26 10:44:06', '刘简单', 'superAdmin', '李斯里');
INSERT INTO `t_project_check` VALUES ('7', 'S20170005', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:04:35', null, 'superAdmin', '请问');
INSERT INTO `t_project_check` VALUES ('8', 'S20170006', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:29:12', null, 'superAdmin', '邹玉');
INSERT INTO `t_project_check` VALUES ('9', 'S20170007', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:30:46', null, 'superAdmin', '邹玉');
INSERT INTO `t_project_check` VALUES ('10', 'S20170008', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:30:58', null, 'superAdmin', '邹玉');
INSERT INTO `t_project_check` VALUES ('11', 'S20170009', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:31:16', null, 'superAdmin', '邹玉');
INSERT INTO `t_project_check` VALUES ('12', 'S20170010', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:31:56', null, 'superAdmin', '邹玉');
INSERT INTO `t_project_check` VALUES ('13', 'S20170011', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:35:32', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('14', 'S20170012', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:35:51', null, 'superAdmin', '李明');
INSERT INTO `t_project_check` VALUES ('15', 'S20170013', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:39:11', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('16', 'S20170014', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:41:23', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('19', 'S20170015', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:41:41', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('20', 'S20170016', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:41:56', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('21', 'S20170017', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:44:00', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('22', 'S20170018', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:44:18', null, 'superAdmin', '王珊');
INSERT INTO `t_project_check` VALUES ('23', 'S20170019', '123456789098171654L', '李明去', '新晃侗族自治县征收4期', '新晃侗族自治县', '铃铃铃', '200000', '0', '200000.00', '0.0300', '6000.00', '0.0150', '3000.00', '地税', '0.0500', '300.00', '180.00', '120.00', '0.0300', '6000.00', '233.01', '116.50', '李明去', '18910876786', '0', '0', null, '0', '2017-03-04 10:47:17', null, 'superAdmin', '王珊');

-- ----------------------------
-- Table structure for `t_project_check_invoice_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_check_invoice_info`;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project_check_invoice_info
-- ----------------------------
INSERT INTO `t_project_check_invoice_info` VALUES ('1', '5', '2015-12-13 00:00:00', '1232131', '4983989430', null, '2015-12-15 00:00:00', null, '439248938243728L', null);
INSERT INTO `t_project_check_invoice_info` VALUES ('2', '4', '2015-01-01 00:00:00', 'fkdsjfk898', '3249832984kk', null, '2015-01-21 00:00:00', null, '432493243', null);

-- ----------------------------
-- Table structure for `t_project_outertube`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_outertube`;
CREATE TABLE `t_project_outertube` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(20) NOT NULL COMMENT '编号：长度10位、字段类型：字符型字（例S20170001）、要求自动编号，后四位取原有记录最大编号+1，年度四位取系统时间年度，每年重新编号，校验长度10位，不能为空，不能重复（唯一字段）',
  `taxpayer_identify_num` varchar(19) NOT NULL COMMENT '纳税人识别号：长度19位、字段类型：字符型（全角）、要求可以调用原有记录最新信息（纳税人名称、经办人姓名、电话），校验不能低于18位，不能大于19位，不能为空',
  `taxpayer_name` varchar(80) NOT NULL COMMENT '校验不能为空',
  `project_name` varchar(80) NOT NULL COMMENT '要求可以调用原有记录最新信息（纳税人识别号、纳税人名称、建设单位、工程总造价、企业所得税归属、是否完工信、联系电话），校验不能为空',
  `project_address` varchar(30) NOT NULL COMMENT '工程项目所在地: 要求默认新为新晃侗族自治县，校验不能为空',
  `project_constructor` varchar(80) NOT NULL COMMENT '工程发包方（建设方）:校验不能为空',
  `project_total_cost` decimal(10,0) NOT NULL COMMENT '工程总造价:数值型，校验不能为空',
  `is_down` tinyint(4) NOT NULL COMMENT '是否完工',
  `settlement_amount` decimal(10,2) NOT NULL COMMENT '本次结算金额：长度12位，小数点2位、字段类型：数值型，要求默认为工程总造价，校验不能为空\r\n            ',
  `pre_appreciation_rate` decimal(10,4) NOT NULL COMMENT '预缴增值税比率：选择项 ，2%，3%（默认2%），后面直接显示税额，如为2%（（本次开票金额/1+11%）*2%），如为3%（（本次开票金额/1+3%）*3%）',
  `pre_appreciation_tax_amount` decimal(10,2) NOT NULL COMMENT '预缴增值税金额',
  `pre_corporate_income_tax_rate` decimal(10,4) DEFAULT NULL COMMENT '预缴企业所得比率：0.2%，后面直接显示税额，如为2%（（本次开票金额/1+11%）*0.2%），如为3%（（本次开票金额/1+3%）*0.2%）\r\n            ',
  `pre_corporate_income_tax_amount` decimal(10,2) DEFAULT NULL,
  `urban_tax_rate` decimal(10,4) NOT NULL COMMENT '城建费附加:\r\n            选择项 ，10%，5%（默认5%）',
  `urban_tax_amount` decimal(10,2) DEFAULT NULL COMMENT '城建税额',
  `education_addition_amount` decimal(10,2) NOT NULL COMMENT '教育费附加：后面直接显示税额（增值税额*3%）',
  `local_education_addition_amount` decimal(10,2) NOT NULL COMMENT '地方教育费附加：后面直接显示税额（增值税额*2%）',
  `stamp_duty_rate` decimal(10,4) DEFAULT NULL COMMENT '印花税率:\r\n            选择项 ，3%%，（默认3%%）',
  `stamp_duty_amount` decimal(10,2) DEFAULT NULL COMMENT '本次开票金额*税率',
  `labor_union_amount` decimal(10,2) DEFAULT NULL COMMENT '工会经费：后面直接显示税额（（本次开票金额/1+税率）*0.12%）',
  `water_construct_amount` decimal(10,2) DEFAULT NULL COMMENT '水利建设专项收入：后面直接显示税额（（本次开票金额/1+税率）*0.06%）',
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='外管工程管理';

-- ----------------------------
-- Records of t_project_outertube
-- ----------------------------
INSERT INTO `t_project_outertube` VALUES ('2', 'W20170001', '1234567890981716543', '陈加宽', '新晃侗族自治县征收3期', '新晃侗族自治县', '怀化市委建委', '100000', '1', '100000.00', '0.0300', '2912.62', '0.0020', '199.60', '0.0500', '145.63', '87.38', '58.25', '0.0030', '300.00', '116.50', '58.25', '0', '李明浩', '18790785642', '0', '0', null, '0', '2017-02-25 21:58:24', '蔡子健', 'superAdmin', '刘文丽', '小规纳税人', '老项目工程', '地税');

-- ----------------------------
-- Table structure for `t_project_outertube_invoice_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_outertube_invoice_info`;
CREATE TABLE `t_project_outertube_invoice_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_outerube_id` int(11) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project_outertube_invoice_info
-- ----------------------------
INSERT INTO `t_project_outertube_invoice_info` VALUES ('2', '2', '2017-02-15 00:00:00', 'ewqdsadsadsa', '3wedsadsaxx', null, null, '2017-02-22 00:00:00', null, 'dsaxzxxxx', null, null);

-- ----------------------------
-- Table structure for `t_project_settlement`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_settlement`;
CREATE TABLE `t_project_settlement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(20) NOT NULL COMMENT '编号：长度10位、字段类型：字符型字（例S20170001）、要求自动编号，后四位取原有记录最大编号+1，年度四位取系统时间年度，每年重新编号，校验长度10位，不能为空，不能重复（唯一字段）',
  `taxpayer_identify_num` varchar(19) NOT NULL COMMENT '纳税人识别号：长度19位、字段类型：字符型（全角）、要求可以调用原有记录最新信息（纳税人名称、经办人姓名、电话），校验不能低于18位，不能大于19位，不能为空',
  `taxpayer_name` varchar(80) NOT NULL COMMENT '校验不能为空',
  `project_name` varchar(80) NOT NULL COMMENT '要求可以调用原有记录最新信息（纳税人识别号、纳税人名称、建设单位、工程总造价、企业所得税归属、是否完工信、联系电话），校验不能为空',
  `project_address` varchar(30) NOT NULL COMMENT '工程项目所在地: 要求默认新为新晃侗族自治县，校验不能为空',
  `project_constructor` varchar(80) NOT NULL COMMENT '工程发包方（建设方）:校验不能为空',
  `project_total_cost` decimal(10,0) NOT NULL COMMENT '工程总造价:数值型，校验不能为空',
  `is_down` tinyint(4) NOT NULL COMMENT '是否完工',
  `settlement_amount` decimal(10,2) DEFAULT NULL COMMENT '本次结算金额：长度12位，小数点2位、字段类型：数值型，要求默认为工程总造价，校验不能为空',
  `service_producer_card_no` varchar(30) DEFAULT NULL COMMENT '供货方（服务提供方）身份证号码：',
  `service_producer_name` varchar(30) DEFAULT NULL COMMENT '供货方（服务提供方）姓名：',
  `cost_invoice_rate` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '成本发票比例：录入项65%（默认65%）存入记录为0.65',
  `obtain_invoice_num` int(11) DEFAULT NULL COMMENT '已取得发票分数',
  `obtain_invoice_amount` decimal(10,2) DEFAULT NULL COMMENT '已取得发票金额：',
  `withhold_department` varchar(50) DEFAULT NULL COMMENT '代扣单位：默认为空，选择项，财政支付局、经建投、工建投',
  `withhold_tax_amount` decimal(10,2) DEFAULT NULL COMMENT '已代扣税额：增值税及地税附征税款，录入项，数值型',
  `appreciation_local_tax_amount` decimal(10,2) DEFAULT NULL COMMENT '增值税额及地税附征税款：4.8%，后面直接显示税额（（本次结算金额*成本发票比例-已取得发票金额/1+税率）*4.8%）-已代扣税款',
  `refund_tax_amount` decimal(10,2) DEFAULT NULL COMMENT '本次结算应补应退税额：增值税额+地税附征税款',
  `impose_department` varchar(50) DEFAULT NULL COMMENT '征收单位：默认为办税大厅，选择项，办税大厅、房产局',
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
  PRIMARY KEY (`id`,`cost_invoice_rate`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='建安工程结算';

-- ----------------------------
-- Records of t_project_settlement
-- ----------------------------
INSERT INTO `t_project_settlement` VALUES ('1', 'J20170001', '1234567890981716543', '吕超细', '新晃侗族自治县征收2期', '新晃侗族自治县', '新晃侗族自治县县政府', '1200000', '0', '800000.00', '430181190210980022', '吕梁深', '0.6500', '1', '200000.00', '工建投', '500.00', '14955.05', '10000.00', '办税大厅', '斌少', '13823463216', '0', '0', '李三', null, '0', '2017-02-25 12:15:36', '王凤', '单亚楠');
INSERT INTO `t_project_settlement` VALUES ('2', 'J20170002', '123456789098171654L', '李明利', '新晃侗族自治县征收4期', '新晃侗族自治县', '怀化市第一建工集团', '100000000', '1', '100000.00', '430181190210980022', '吕梁深', '0.6500', '1', '200.00', '财政支付局', '50.00', '3060.50', '123.00', '办税大厅', '李星星', '13212324567', '0', '0', '李健', null, '0', '2017-02-26 11:23:58', '业务员1', '王媛');

-- ----------------------------
-- Table structure for `t_project_settlement_invoice_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_project_settlement_invoice_info`;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project_settlement_invoice_info
-- ----------------------------
INSERT INTO `t_project_settlement_invoice_info` VALUES ('1', '1', '2014-10-21 00:00:00', '329874983207184l', 'jfkldsjlkf03403kalk9weorkj3', null, null, '2014-09-12 00:00:00', null, '643298749832984o', null, null);
