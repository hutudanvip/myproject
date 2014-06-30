# MySQL-Front 5.1  (Build 1.20)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: student
# ------------------------------------------------------
# Server version 5.1.34-community

#
# Source for table t_hi_grades
#

CREATE TABLE `t_hi_grades` (
  `fid` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `fname` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `fdescribe` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flastupdateTime` date DEFAULT NULL,
  `fnumber` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fcreatetime` date DEFAULT NULL,
  `fiseffective` int(11) DEFAULT 1,
  PRIMARY KEY (`fid`),
  KEY `fid` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
