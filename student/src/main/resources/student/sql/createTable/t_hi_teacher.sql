/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : mysql
Target Host     : localhost:3306
Target Database : mysql
Date: 2013-03-19 22:12:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_hi_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_hi_teacher`;
CREATE TABLE `t_hi_teacher` (
  `fid` varchar(80) NOT NULL,
  `fnumber` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `fcreatetime` date DEFAULT NULL,
  `flastUpdateTime` date DEFAULT NULL,
  `fdescribe` varchar(200) DEFAULT NULL,
  `fmagClass` varchar(80) DEFAULT NULL,
  `finTime` date DEFAULT NULL,
  `fsalary` int(10) DEFAULT NULL,
  `fonTheJob` int(1) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hi_teacher
-- ----------------------------
