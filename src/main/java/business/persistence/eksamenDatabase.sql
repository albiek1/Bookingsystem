-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: startcode
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `startcode`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `startcode` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `startcode`;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `idbooking` int NOT NULL AUTO_INCREMENT,
  `bookingStart` date NOT NULL,
  `bookingLength` int NOT NULL,
  `studentID` int NOT NULL,
  `itemID` int NOT NULL,
  `bookingstatus` varchar(8) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`idbooking`),
  UNIQUE KEY `idbooking_UNIQUE` (`idbooking`),
  KEY `studentID_idx` (`studentID`),
  KEY `itemID_idx` (`itemID`),
  CONSTRAINT `itemID` FOREIGN KEY (`itemID`) REFERENCES `items` (`iditems`),
  CONSTRAINT `studentID` FOREIGN KEY (`studentID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (0,'2021-06-11',6,1,9,'status'),(1,'2020-11-25',5,2,4,'active'),(4,'2021-07-26',5,5,0,'active'),(5,'2021-07-26',5,5,1,'active'),(6,'2021-07-26',10,5,6,'active'),(7,'2021-07-26',3,5,10,'active'),(8,'2021-07-26',6,5,18,'active'),(9,'2021-07-26',7,5,16,'active'),(10,'2021-07-26',9,5,8,'active');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `iditems` int NOT NULL,
  `itemID` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `itemType` varchar(45) NOT NULL,
  `roomID` int NOT NULL,
  `roomName` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'booked',
  PRIMARY KEY (`iditems`),
  UNIQUE KEY `itemID_UNIQUE` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (0,'vr-1','Oculus Quest 2','VR-headset',212,'Medialab','free'),(1,'vr-2','Oculus Quest 2','VR-headset',212,'Medialab','booked'),(2,'vr-3','Oculus Quest 2','VR-headset',212,'Medialab','free'),(3,'vr-4','Oculus Quest 2','VR-headset',212,'Medialab','free'),(4,'vr-5','Oculus Quest 2','VR-headset',212,'Medialab','free'),(5,'vr-6','Oculus Quest 2','VR-headset',212,'Medialab','free'),(6,'vr-7','Oculus Rift S','VR-headset',212,'Medialab','booked'),(7,'vr-8','Oculus Rift S','VR-headset',212,'Medialab','free'),(8,'pc-1','Arbejdsstation PC','Arbejdscomputer',212,'Medialab','booked'),(9,'print-1','HP','Plakatprinter',212,'Medialab','free'),(10,'3d-print-1','Creatlity CR-10 S5','3D printer',210,'Makerlab','booked'),(11,'3d-print-2','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(12,'3d-print-3','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(13,'3d-print-4','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(14,'3d-print-5','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(15,'3d-print-6','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(16,'3d-print-7','Creatlity CR-10 S5','3D printer',210,'Makerlab','booked'),(17,'3d-print-8','Creatlity CR-10 S5','3D printer',210,'Makerlab','free'),(18,'camera-1','Canon EOS 90D','Digitalkamera',212,'Medialab','booked'),(19,'camera-2','Canon EOS 90D','Digitalkamera',212,'Medialab','free'),(20,'camera-3','Canon EOS 90D','Digitalkamera',212,'Medialab','free'),(21,'camera-4','Panasonic 4K','Digitalkamera',212,'Medialab','free'),(22,'studio-1','Fotostudio','Fotostudio',212,'Medialab','free');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sName` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` int DEFAULT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'student',
  `point` int NOT NULL DEFAULT '50',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'Admin','admin@email.com','12345',NULL,'admin',50),(1,'student1','s1@email.com','1',NULL,'student',50),(2,'student2','s2@email.com','2',NULL,'student',50),(3,'student3','s3@email.com','3',NULL,'student',50),(5,'student4','s4@email.com','4',4,'student',34),(6,'student5','s5@email.com','5',12345678,'student',50);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `startcode_test`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `startcode_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `startcode_test`;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `idbooking` int NOT NULL AUTO_INCREMENT,
  `bookingStart` date NOT NULL,
  `bookingEnd` int NOT NULL,
  `studentID` int NOT NULL,
  `itemID` int NOT NULL,
  PRIMARY KEY (`idbooking`),
  UNIQUE KEY `idbooking_UNIQUE` (`idbooking`),
  KEY `studentID_idx` (`studentID`),
  KEY `itemID_idx` (`itemID`),
  CONSTRAINT `itemID` FOREIGN KEY (`itemID`) REFERENCES `items` (`iditem`),
  CONSTRAINT `studentID` FOREIGN KEY (`studentID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `iditem` int NOT NULL AUTO_INCREMENT,
  `itemID` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `itemType` varchar(45) NOT NULL,
  `RoomID` int NOT NULL,
  `RoomName` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL DEFAULT 'booked',
  PRIMARY KEY (`iditem`),
  UNIQUE KEY `iditem_UNIQUE` (`iditem`),
  UNIQUE KEY `itemID_UNIQUE` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sName` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` int DEFAULT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'student',
  `point` int NOT NULL DEFAULT '50',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Jens','jens@somewhere.com','jensen',11111111,'student',50),(2,'Ken','ken@somewhere.com','kensen',22222222,'student',50),(3,'Robin','robin@somewhere.com','batman',33333333,'admin',50);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-03 14:29:29
