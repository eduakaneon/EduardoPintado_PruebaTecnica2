-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: turnos
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `CIUDADANO`
--

DROP TABLE IF EXISTS `CIUDADANO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CIUDADANO` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CIUDADANO`
--

LOCK TABLES `CIUDADANO` WRITE;
/*!40000 ALTER TABLE `CIUDADANO` DISABLE KEYS */;
INSERT INTO `CIUDADANO` VALUES (1,'Pintado santias','01673161A','Eduardo','691496277'),(2,'Santias','054445555s','tere','635660561'),(3,'Pintado','01673161U','Eduardo',NULL),(4,'Santias','01673161U','EduardoJR',NULL),(5,'Armando','822368864D','Diego',NULL),(6,'jr','822368864D','Diego',NULL),(7,'Santias viada','01673161U','EduardoJR',NULL),(8,'chocolatero','272722772S','paquito',NULL),(9,'Palomo','5555555555H','Juan',NULL),(10,'Lozano','222333333W','Diego',NULL);
/*!40000 ALTER TABLE `CIUDADANO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRAMITE`
--

DROP TABLE IF EXISTS `TRAMITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TRAMITE` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRAMITE`
--

LOCK TABLES `TRAMITE` WRITE;
/*!40000 ALTER TABLE `TRAMITE` DISABLE KEYS */;
INSERT INTO `TRAMITE` VALUES (1,'prestacion'),(2,'prestacion'),(3,NULL),(4,NULL),(5,'prestacion'),(6,'prestacion'),(7,'prestacion'),(8,'prestacion'),(9,'casta'),(10,NULL),(11,NULL),(12,NULL),(13,'casta'),(14,'prestacion'),(15,NULL),(16,NULL),(17,NULL);
/*!40000 ALTER TABLE `TRAMITE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TURNO`
--

DROP TABLE IF EXISTS `TURNO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TURNO` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ATENDIDO` tinyint(1) DEFAULT '0',
  `FECHATURNO` date DEFAULT NULL,
  `NUMERO` int DEFAULT NULL,
  `ciudadano_id` bigint DEFAULT NULL,
  `TRAMITE_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`),
  KEY `FK_TURNO_TRAMITE_ID` (`TRAMITE_ID`),
  CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `CIUDADANO` (`ID`),
  CONSTRAINT `FK_TURNO_TRAMITE_ID` FOREIGN KEY (`TRAMITE_ID`) REFERENCES `TRAMITE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TURNO`
--

LOCK TABLES `TURNO` WRITE;
/*!40000 ALTER TABLE `TURNO` DISABLE KEYS */;
INSERT INTO `TURNO` VALUES (1,1,'2024-03-30',1,1,1),(2,1,'2024-03-30',2,2,2),(3,0,'2024-03-29',1,3,3),(4,1,'2024-03-31',1,4,4),(5,0,'2024-03-31',2,4,5),(6,1,'2024-03-31',3,4,6),(7,0,'2024-03-29',2,4,7),(8,0,'2024-03-31',4,4,8),(9,1,'2024-03-30',3,4,9),(10,0,'2024-03-31',5,5,10),(11,1,'2024-03-30',4,6,11),(12,0,'2024-03-31',6,7,12),(13,1,'2024-03-30',5,4,13),(14,1,'2024-03-29',3,4,14),(15,1,'2024-03-30',6,8,15),(16,0,'2024-03-30',7,9,16),(17,0,'2024-03-30',8,10,17);
/*!40000 ALTER TABLE `TURNO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-28 10:55:25
