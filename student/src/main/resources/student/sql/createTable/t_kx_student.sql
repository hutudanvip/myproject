/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : mysql
Target Host     : localhost:3306
Target Database : mysql
Date: 2013-03-19 22:13:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_kx_student
-- ----------------------------
DROP TABLE IF EXISTS `t_kx_student`;
CREATE TABLE `t_kx_student` (
  `fid` varchar(44) NOT NULL ,
  `fname` varchar(20) DEFAULT NULL,
  `fnum` int(8)  not null,  
  fcreateTime timestamp(6),  
flastUpdateTime timestamp(6) DEFAULT NULL,
fdescribe varchar(200),
fiseffective int,
faddress varchar(200),
fgradeid varchar(80),
fcellphone varchar(20),
fgenearchName varchar(20),
frelation varchar(20),
fage int,
fgender int,
fintime timestamp(6) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kx_student
-- ----------------------------
INSERT INTO `t_kx_student` VALUES ('0001', 'zhangsan', '0001');
