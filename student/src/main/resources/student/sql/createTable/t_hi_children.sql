/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : mysql
Target Host     : localhost:3306
Target Database : mysql
Date: 2013-03-19 22:08:26
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_hi_children
-- ----------------------------
DROP TABLE IF EXISTS `t_hi_children`;
CREATE TABLE `t_hi_children` (
  `fid` varchar(80) NOT NULL,
  `fnumber` varchar(20) NOT NULL,
  `fchildName` varchar(20) DEFAULT NULL,
  `fcreatetime` date DEFAULT NULL,
  `flastUpdateTime` date DEFAULT NULL,
  `fdescribe` varchar(200) DEFAULT NULL,
  `fchildGender` int(1) DEFAULT NULL,
  `fchildAge` int(2) DEFAULT NULL,
  `fbelongClass` varchar(80) DEFAULT NULL,
  `fbeginTime` date DEFAULT NULL,
  `fparentName` varchar(20) DEFAULT NULL,
  `fcellphone` varchar(11) DEFAULT NULL,
  `ftelphone` varchar(8) DEFAULT NULL,
  `faddress` varchar(200) DEFAULT NULL,
  `fleaved` int(1) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hi_children
-- ----------------------------
