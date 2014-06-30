/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : mysql
Target Host     : localhost:3306
Target Database : mysql
Date: 2013-03-19 22:11:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_hi_expense
-- ----------------------------
DROP TABLE IF EXISTS `t_hi_expense`;
CREATE TABLE `t_hi_expense` (
  `fid` varchar(80) NOT NULL,
  `fnumber` varchar(20) DEFAULT NULL,
  `fcreataTime` date DEFAULT NULL,
  `flastUpdateTime` date DEFAULT NULL,
  `fdescribe` varchar(200) DEFAULT NULL,
  `ftuition` int(4) DEFAULT NULL,
  `flivingCost` int(4) DEFAULT NULL,
  `fotherCost` int(4) DEFAULT NULL,
  `ftranChange` int(4) DEFAULT NULL,
  `fbookCost` int(4) DEFAULT NULL,
  `feffected` int(1) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hi_expense
-- ----------------------------
