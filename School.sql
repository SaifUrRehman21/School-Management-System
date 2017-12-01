/*
SQLyog Community v11.51 (64 bit)
MySQL - 10.1.13-MariaDB : Database - School
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`School` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `School`;

/*Table structure for table `fee` */

DROP TABLE IF EXISTS `fee`;

CREATE TABLE `fee` (
  `ID` int(10) NOT NULL,
  `Fee` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fee` */

insert  into `fee`(`ID`,`Fee`) values (1,5000);

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `RollNo` varchar(10) NOT NULL,
  `English` float NOT NULL,
  `Urdu` float NOT NULL,
  `Math` float NOT NULL,
  `Islamiat` float NOT NULL,
  `Physics` float NOT NULL,
  `Chemistry` float NOT NULL,
  `Obtain` float NOT NULL,
  `Percentage` float NOT NULL,
  PRIMARY KEY (`RollNo`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `result` */

/*Table structure for table `signup` */

DROP TABLE IF EXISTS `signup`;

CREATE TABLE `signup` (
  `Name` char(30) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Gender` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `signup` */

insert  into `signup`(`Name`,`Username`,`Email`,`Password`,`Gender`) values ('Saif Ur Re','saif21','saifurrehmankhan21@gmail.com','03074554223','Male');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admissiondate` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `father` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `cnic` varchar(20) NOT NULL,
  `fees` int(20) NOT NULL,
  `rollno` varchar(20) NOT NULL,
  `address` varchar(40) NOT NULL,
  `gender` char(20) NOT NULL,
  `birthday` varchar(20) NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`id`,`admissiondate`,`name`,`father`,`email`,`cnic`,`fees`,`rollno`,`address`,`gender`,`birthday`) values (1,'10-21-3333','Saif','fname','email','cnic',5000,'3520174826559','address','Male','54545'),(2,'10-21-3333','Saif','fname','email','cnic',5000,'3520174826559','address','Male','54545');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(5) DEFAULT NULL,
  `admissiondate` varchar(20) NOT NULL,
  `name` char(20) NOT NULL,
  `father` char(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `cnic` varchar(20) NOT NULL,
  `salary` int(10) NOT NULL,
  `qualification` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `gender` char(10) NOT NULL,
  `birthday` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `teacher` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
