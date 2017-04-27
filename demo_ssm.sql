/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : demo_ssm

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-06 14:37:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `_id` bigint(20) NOT NULL,
  `_name` varchar(255) DEFAULT NULL,
  `_headTeacherId` bigint(20) DEFAULT NULL,
  `_classDirectorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1488518040817', 'c2', null, '1488518042517');
INSERT INTO `t_class` VALUES ('1488518041111', 'c4', '1488518036767', '1488518036767');
INSERT INTO `t_class` VALUES ('1488518042151', 'c1', '1488518042517', '1488518042517');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `_id` bigint(20) NOT NULL,
  `_name` varchar(255) DEFAULT NULL,
  `_birthDay` date DEFAULT NULL,
  `_superviseClassId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1488518036767', 't2', '1992-01-01', '1488518041111');
INSERT INTO `t_teacher` VALUES ('1488518042517', 't1', '1991-01-01', '1488518042151');

-- ----------------------------
-- Table structure for `t_teacher_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_class`;
CREATE TABLE `t_teacher_class` (
  `_classId` bigint(20) NOT NULL,
  `_teacherId` bigint(20) NOT NULL,
  PRIMARY KEY (`_classId`,`_teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher_class
-- ----------------------------
INSERT INTO `t_teacher_class` VALUES ('1488518040817', '1488518042517');
INSERT INTO `t_teacher_class` VALUES ('1488518041111', '1488518036767');
INSERT INTO `t_teacher_class` VALUES ('1488518042151', '1488518042517');

-- ----------------------------
-- Table structure for `t_test1`
-- ----------------------------
DROP TABLE IF EXISTS `t_test1`;
CREATE TABLE `t_test1` (
  `_boholoId` bigint(20) NOT NULL COMMENT 'ID',
  `_name` varchar(255) DEFAULT NULL COMMENT '名字',
  `_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `_test1` varchar(255) DEFAULT NULL COMMENT '测试1',
  `_test2` varchar(255) DEFAULT NULL COMMENT '测试2',
  PRIMARY KEY (`_boholoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试类';

-- ----------------------------
-- Records of t_test1
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test2`
-- ----------------------------
DROP TABLE IF EXISTS `t_test2`;
CREATE TABLE `t_test2` (
  `_bbcareId` bigint(20) NOT NULL COMMENT 'ID',
  `_name` varchar(255) DEFAULT NULL COMMENT '名字',
  `_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `_test1` varchar(255) DEFAULT NULL COMMENT '测试1',
  `_test2` varchar(255) DEFAULT NULL COMMENT '测试2',
  PRIMARY KEY (`_bbcareId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试2';

-- ----------------------------
-- Records of t_test2
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `_userId` bigint(20) NOT NULL COMMENT '用户ID',
  `_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `_phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `_birthday` datetime DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`_userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1491397384098', 'hq1', '安庆', null, '2017-04-05 21:03:04');
INSERT INTO `t_user` VALUES ('1491397384198', 'hq2', '安庆', null, '2017-04-05 21:03:04');
INSERT INTO `t_user` VALUES ('1491441972480', 'hq1', '安庆', null, '2017-04-06 09:26:12');
INSERT INTO `t_user` VALUES ('1491441972580', 'hq2', '安庆', null, '2017-04-06 09:26:12');
INSERT INTO `t_user` VALUES ('1491441994710', 'hq1', '安庆', null, '2017-04-06 09:26:35');
INSERT INTO `t_user` VALUES ('1491441994810', 'hq2', '安庆', null, '2017-04-06 09:26:35');
