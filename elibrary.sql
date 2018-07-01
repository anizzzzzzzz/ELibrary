-- MySQL dump 10.16  Distrib 10.1.32-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: elibrary
-- ------------------------------------------------------
-- Server version	10.1.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `e_book`
--

DROP TABLE IF EXISTS `e_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `callno` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `issued` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_book`
--

LOCK TABLES `e_book` WRITE;
/*!40000 ALTER TABLE `e_book` DISABLE KEYS */;
INSERT INTO `e_book` VALUES (8,'CallNo1','Maha ko Ma','Madan Krishna Shrestha','Elibrary Pvt Ltd',20,0),(9,'CallNo2','Cheena Harako Manchey','Hari Banksa Acharya','Elibrary Pvt Ltd',20,1),(10,'CallNo3','Half Girlfriend','Chetan Bhagat','Elibrary Pvt Ltd',15,0),(11,'CallNo4','Java Full Course','Hira Lal Shrestha','Elibrary Pvt Ltd',10,0);
/*!40000 ALTER TABLE `e_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_issuebook`
--

DROP TABLE IF EXISTS `e_issuebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_issuebook` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `callno` varchar(100) DEFAULT NULL,
  `studentid` varchar(100) DEFAULT NULL,
  `studentname` varchar(100) DEFAULT NULL,
  `studentmobile` bigint(20) DEFAULT NULL,
  `issueddate` date DEFAULT NULL,
  `returnstatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_issuebook`
--

LOCK TABLES `e_issuebook` WRITE;
/*!40000 ALTER TABLE `e_issuebook` DISABLE KEYS */;
INSERT INTO `e_issuebook` VALUES (7,'CallNo2','54','Akshya Kumar',9876543210,'2018-07-01','no'),(8,'CallNo4','88','Mahesh Maharjan',9841567821,'2018-07-01','yes');
/*!40000 ALTER TABLE `e_issuebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_librarian`
--

DROP TABLE IF EXISTS `e_librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_librarian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_librarian`
--

LOCK TABLES `e_librarian` WRITE;
/*!40000 ALTER TABLE `e_librarian` DISABLE KEYS */;
INSERT INTO `e_librarian` VALUES (1,'Ram Shrestha','ram.shrestha@elibrary.com','Qwerty',9846128731),(2,'Sita Shrestha','sita.shrestha@elibrary.com','Qwerty',9841221188),(3,'Laxman Shakya','laxman.shakya@elibrary.com','Qwerty',9876543219);
/*!40000 ALTER TABLE `e_librarian` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-01 16:09:55
