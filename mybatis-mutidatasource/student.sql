/*
Navicat MySQL Data Transfer

Source Server         : connectionone
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : test03

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-07-23 20:11:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('33', '3333333');
