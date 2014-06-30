/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : mysql
Target Host     : localhost:3306
Target Database : mysql
Date: 2013-03-19 22:13:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_test_student
-- ----------------------------
DROP TABLE IF EXISTS `t_test_student`;
CREATE TABLE `t_test_student` (
  `fid` varchar(44) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `fnum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_test_student
-- ----------------------------
INSERT INTO `t_test_student` VALUES ('552fb57f-9a7a-11e0-bfa2-883a87f6405a', 'lisi', '0001');
