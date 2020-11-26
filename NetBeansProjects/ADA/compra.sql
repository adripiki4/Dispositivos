-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: compra
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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `Id_Compra` int NOT NULL AUTO_INCREMENT,
  `FechaCompra` date NOT NULL,
  `Id-wallet` int NOT NULL,
  `Id_producto` int NOT NULL,
  PRIMARY KEY (`Id_Compra`),
  KEY `fk_Compra_E-wallet_idx` (`Id-wallet`),
  KEY `fk_Compra_Producto1_idx` (`Id_producto`),
  CONSTRAINT `fk_Compra_E-wallet` FOREIGN KEY (`Id-wallet`) REFERENCES `ewallet` (`Id_wallet`),
  CONSTRAINT `fk_Compra_Producto1` FOREIGN KEY (`Id_producto`) REFERENCES `producto` (`Id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devolucion` (
  `Id_devolucion` int NOT NULL AUTO_INCREMENT,
  `FechaDevolucion` date NOT NULL,
  `Id-wallet` int NOT NULL,
  `Id_producto` int NOT NULL,
  PRIMARY KEY (`Id_devolucion`),
  UNIQUE KEY `E-wallet_Id-wallet_UNIQUE` (`Id-wallet`),
  UNIQUE KEY `Producto_Id_producto_UNIQUE` (`Id_producto`),
  KEY `fk_Devolucion_E-wallet1_idx` (`Id-wallet`),
  KEY `fk_Devolucion_Producto1_idx` (`Id_producto`),
  CONSTRAINT `fk_Devolucion_E-wallet1` FOREIGN KEY (`Id-wallet`) REFERENCES `ewallet` (`Id_wallet`),
  CONSTRAINT `fk_Devolucion_Producto1` FOREIGN KEY (`Id_producto`) REFERENCES `producto` (`Id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ewallet`
--

DROP TABLE IF EXISTS `ewallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ewallet` (
  `Id_wallet` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Dni` varchar(45) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `SaldoPuntos` int DEFAULT NULL,
  `SaldoEuros` int DEFAULT NULL,
  PRIMARY KEY (`Id_wallet`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `Id_producto` int NOT NULL AUTO_INCREMENT,
  `NombreProducto` varchar(45) NOT NULL,
  `PrecioProducto` int DEFAULT NULL,
  `PuntosProducto` int DEFAULT NULL,
  PRIMARY KEY (`Id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-27  0:31:51
