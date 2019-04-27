-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: siparis
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `iletisimbilgisi`
--

DROP TABLE IF EXISTS `iletisimbilgisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `iletisimbilgisi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telefon` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gonderiAdresi` varchar(70) DEFAULT NULL,
  `faturaAdresi` varchar(70) DEFAULT NULL,
  `musteri_kod` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_musteri_kodİ` (`musteri_kod`),
  CONSTRAINT `FK_musteri_kodİ` FOREIGN KEY (`musteri_kod`) REFERENCES `musteri` (`kod`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iletisimbilgisi`
--

LOCK TABLES `iletisimbilgisi` WRITE;
/*!40000 ALTER TABLE `iletisimbilgisi` DISABLE KEYS */;
INSERT INTO `iletisimbilgisi` VALUES (1,'3457895478','lphmhş@gmail.com','istanbul','edirne',9809),(2,'56','kd','','dşlfgk',NULL),(3,'345','fgsf','','fvs',NULL),(4,'365899','nghjgcjö','','fmhgdmh',NULL);
/*!40000 ALTER TABLE `iletisimbilgisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kumas`
--

DROP TABLE IF EXISTS `kumas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kumas` (
  `kod` varchar(10) NOT NULL,
  `birimFiyat` float DEFAULT NULL,
  `iplikCesidi` varchar(50) DEFAULT NULL,
  `renk` varchar(30) DEFAULT NULL,
  `musteri_kod` int(11) DEFAULT NULL,
  PRIMARY KEY (`kod`),
  KEY `FK_musteri_kodK` (`musteri_kod`),
  CONSTRAINT `FK_musteri_kodK` FOREIGN KEY (`musteri_kod`) REFERENCES `musteri` (`kod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kumas`
--

LOCK TABLES `kumas` WRITE;
/*!40000 ALTER TABLE `kumas` DISABLE KEYS */;
INSERT INTO `kumas` VALUES ('43t',4,'dt','nghm',NULL),('4759485',5,'hsdljv','hflhg',NULL),('575tg',3.4,'polester','pink',NULL),('ke6yftbla',6.7,'keten','black',NULL);
/*!40000 ALTER TABLE `kumas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musteri`
--

DROP TABLE IF EXISTS `musteri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `musteri` (
  `kod` int(11) NOT NULL,
  `ad` varchar(45) NOT NULL,
  PRIMARY KEY (`kod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri`
--

LOCK TABLES `musteri` WRITE;
/*!40000 ALTER TABLE `musteri` DISABLE KEYS */;
INSERT INTO `musteri` VALUES (56,'gfn'),(356,'gdf'),(9809,'ZARA'),(45658,'MERTER GİYİM'),(45698,'PUMA'),(59748,'MAVİ');
/*!40000 ALTER TABLE `musteri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-27  5:11:41
