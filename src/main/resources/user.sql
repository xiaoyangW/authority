/*
Navicat MySQL Data Transfer

Source Server         : mango-aaron
Source Server Version : 50717
Source Host           : 192.168.137.3:3306
Source Database       : mango

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-02 17:20:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `modifyTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
