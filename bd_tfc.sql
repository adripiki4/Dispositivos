CREATE DATABASE  IF NOT EXISTS `tfc_poli` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tfc_poli`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tfc_poli
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `idactividad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `dia` varchar(45) NOT NULL,
  `hora` varchar(45) NOT NULL,
  `maxpersonas` int DEFAULT NULL,
  `inscritos` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `idinstalacion` int NOT NULL,
  `iddeporte` int NOT NULL,
  `idmonitores` int NOT NULL,
  PRIMARY KEY (`idactividad`),
  KEY `fk_actividad_instalacion1_idx` (`idinstalacion`),
  KEY `fk_actividad_monitores1_idx` (`idmonitores`),
  KEY `fk_actividad_deportes1_idx` (`iddeporte`),
  CONSTRAINT `fk_actividad_deportes1` FOREIGN KEY (`iddeporte`) REFERENCES `deportes` (`iddeporte`),
  CONSTRAINT `fk_actividad_instalacion1` FOREIGN KEY (`idinstalacion`) REFERENCES `instalacion` (`idinstalacion`),
  CONSTRAINT `fk_actividad_monitores1` FOREIGN KEY (`idmonitores`) REFERENCES `monitores` (`idmonitores`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Remate x3','Lunes','16:00',4,1,24,12,1001,13),(2,'Curso Mañanas 1','Martes','09:00',8,0,18,30,1003,15),(3,'Curso Mañanas 2','Jueves','09:00',8,1,18,31,1003,15),(4,'Iniciación Nivel 1','Lunes','09:00',4,0,24,12,1001,11),(5,'Iniciación Nivel 2','Lunes','10:00',4,0,24,11,1001,12),(6,'Iniciación Nivel 3','Lunes','11:00',4,0,24,13,1001,12),(7,'Grupo Benjamín','Martes','17:00',16,0,30,20,1002,11),(8,'Grupo Alevín','Martes','19:00',16,0,30,20,1002,13),(9,'AquaGym Tardes','Viernes','18:00',8,0,18,33,1003,11);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquileres` (
  `idalquileres` int NOT NULL AUTO_INCREMENT,
  `precio` varchar(45) NOT NULL,
  `tiempo` float NOT NULL,
  `instalacion_idinstalacion` int NOT NULL,
  `clientes_idcliente` int NOT NULL,
  PRIMARY KEY (`idalquileres`),
  UNIQUE KEY `idalquileres_UNIQUE` (`idalquileres`),
  KEY `fk_alquileres_instalacion1_idx` (`instalacion_idinstalacion`),
  KEY `fk_alquileres_clientes1_idx` (`clientes_idcliente`),
  CONSTRAINT `fk_alquileres_clientes1` FOREIGN KEY (`clientes_idcliente`) REFERENCES `clientes` (`idcliente`),
  CONSTRAINT `fk_alquileres_instalacion1` FOREIGN KEY (`instalacion_idinstalacion`) REFERENCES `instalacion` (`idinstalacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cuota` float DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'4545478C','Adrian','Piquero Ibanez','698632654','adrian@dominio.es',0),(2,'54521444J','Pedro','Gonzalez','624895678','pedro@dominio.es',24),(4,'78159654G','Ana','Hernandez Gonzalez','644582324','anah@dominio.es',18);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deportes`
--

DROP TABLE IF EXISTS `deportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deportes` (
  `iddeporte` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`iddeporte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deportes`
--

LOCK TABLES `deportes` WRITE;
/*!40000 ALTER TABLE `deportes` DISABLE KEYS */;
INSERT INTO `deportes` VALUES (1001,'Padel'),(1002,'Futbol'),(1003,'Natacion'),(1004,'Baloncesto'),(1005,'Baile');
/*!40000 ALTER TABLE `deportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `idinscripcion` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `idactividad` int NOT NULL,
  PRIMARY KEY (`idinscripcion`),
  KEY `fk_inscripcion_clientes1_idx` (`idcliente`),
  KEY `fk_inscripcion_actividad1_idx` (`idactividad`),
  CONSTRAINT `fk_inscripcion_actividad1` FOREIGN KEY (`idactividad`) REFERENCES `actividad` (`idactividad`),
  CONSTRAINT `fk_inscripcion_clientes1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (3,2,1),(6,4,3);
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instalacion` (
  `idinstalacion` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  `iddeporte` int NOT NULL,
  PRIMARY KEY (`idinstalacion`),
  UNIQUE KEY `idinstalacion_UNIQUE` (`idinstalacion`),
  KEY `fk_instalacion_deportes1_idx` (`iddeporte`),
  CONSTRAINT `fk_instalacion_deportes1` FOREIGN KEY (`iddeporte`) REFERENCES `deportes` (`iddeporte`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (10,'Padel_1',24,1001),(11,'Padel_2',24,1001),(12,'Padel_3',24,1001),(13,'Padel_4',24,1001),(20,'Futbol_7',50,1002),(21,'Futbol_11',80,1002),(30,'Piscina calle 1',6,1003),(31,'Piscina calle 2',6,1003),(32,'Piscina calle 3',6,1003),(33,'Piscina calle 4',6,1003);
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitores`
--

DROP TABLE IF EXISTS `monitores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitores` (
  `idmonitores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `telefono` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmonitores`),
  UNIQUE KEY `idmonitores_UNIQUE` (`idmonitores`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitores`
--

LOCK TABLES `monitores` WRITE;
/*!40000 ALTER TABLE `monitores` DISABLE KEYS */;
INSERT INTO `monitores` VALUES (11,'Alvaro','Suarez',698741598,'alva@polideportivo.es'),(12,'Francisco','Torres',687635489,'franc@polideportivo.es'),(13,'Felipe','Gutierrez',623458475,'felipe@polideportivo.es'),(15,'Enrique','Garcia',625589324,'enriq@polideportivo.es');
/*!40000 ALTER TABLE `monitores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuarios` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-28 18:24:46
