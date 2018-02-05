/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - cafe_management
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cafe_management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cafe_management`;

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `amount` int(10) unsigned DEFAULT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `orderproduct_reserv` */

DROP TABLE IF EXISTS `orderproduct_reserv`;

CREATE TABLE `orderproduct_reserv` (
  `reserv_id` int(10) unsigned NOT NULL,
  `order_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`reserv_id`,`order_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `orderproduct_reserv_ibfk_1` FOREIGN KEY (`reserv_id`) REFERENCES `reserv` (`id`),
  CONSTRAINT `orderproduct_reserv_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderproduct_reserv` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `product_in_order` */

DROP TABLE IF EXISTS `product_in_order`;

CREATE TABLE `product_in_order` (
  `order_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_in_order_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `product_in_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_in_order` */

/*Table structure for table `reserv` */

DROP TABLE IF EXISTS `reserv`;

CREATE TABLE `reserv` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `statuss` enum('OPEN','CLOSED') NOT NULL,
  `reserv_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reserv` */

/*Table structure for table `table_cafe` */

DROP TABLE IF EXISTS `table_cafe`;

CREATE TABLE `table_cafe` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `reserve_id` int(10) unsigned DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  `statuss` enum('FREE','RESERVED') NOT NULL DEFAULT 'FREE',
  PRIMARY KEY (`id`),
  KEY `reserve_id` (`reserve_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `table_cafe_ibfk_1` FOREIGN KEY (`reserve_id`) REFERENCES `reserv` (`id`),
  CONSTRAINT `table_cafe_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `table_cafe` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` text NOT NULL,
  `role` enum('MANAGER','WAITER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */
INSERT  INTO `user`(`id`,`username`,`password`,`role`) VALUES (1,'a','$2a$10$ajZFXAiFrPFK0HCIMvNnkOfQ6RTjW9mCLAHmwUlNg1FYuSr33aEim','MANAGER'),(2,'s','$2a$10$M0zLHFLpuZL/76o9W/b70uqvrzG9z8cv/TfropTsMDnjGMChUgAyO','WAITER'),(3,'d','$2a$10$9kzDE3rGborMj8HFOyJsmOTacx3O/UnKnetapJ.VSTmiAM.WTr/lG','WAITER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
