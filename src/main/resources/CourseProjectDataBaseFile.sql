-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: testcourseproject
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `idDelivery` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `delivery_info` varchar(100) NOT NULL,
  `Receipt_idReceipt` int NOT NULL,
  PRIMARY KEY (`idDelivery`),
  KEY `Receipt_Receipt_idReceipt_fk` (`Receipt_idReceipt`),
  CONSTRAINT `Receipt_Receipt_idReceipt_fk` FOREIGN KEY (`Receipt_idReceipt`) REFERENCES `receipt` (`idReceipt`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (8,'Доставка в отделение','куда то туда',23),(9,'Доставка в отделение','Переулок Токаревский дом 6 ',24),(10,'Доставка в отделение','Переулок Токаревский дом 6 ',25),(11,'Доставка домой','asda',26),(12,'Доставка в отделение','Переулок Токаревский дом 6 ',27),(13,'Доставка в отделение','пер ТОкаревский',28),(14,'Доставка домой','adas',31),(15,'Доставка домой','adas',31),(16,'Доставка домой','adas',31),(17,'Доставка в отделение','Переулок Токаревский дом 6 ',32);
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img` (
  `idImg` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `path_to_file` varchar(1000) NOT NULL,
  PRIMARY KEY (`idImg`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (1,'motherboard_first','/images/recomandation/1.jpg'),(2,'motherboard_second','/images/recomandation/2.jpg'),(3,'motherboard_third','/images/recomandation/3.jpg'),(4,'motherboard_fourth','/images/recomandation/4.jpg'),(5,'motherboard_fiveth','/images/recomandation/5.jpg'),(6,'motherboard_sixth','/images/recomandation/6.jpg'),(7,'motherboard_seventh','/images/recomandation/7.jpg'),(8,'graphics_card_first','/images/recomandation/8.jpg'),(9,'graphics_card_second','/images/recomandation/9.jpg'),(10,'graphics_card_third','/images/recomandation/10.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idProduct` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `Img_idImg` int NOT NULL,
  `idType` int NOT NULL,
  PRIMARY KEY (`idProduct`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `Img_idImg_fk` (`Img_idImg`),
  KEY `type_idType_fk` (`idType`),
  CONSTRAINT `Img_idImg_fk` FOREIGN KEY (`Img_idImg`) REFERENCES `img` (`idImg`),
  CONSTRAINT `type_idType_fk` FOREIGN KEY (`idType`) REFERENCES `type` (`idtype`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Motherboard ASRock B450M Steel Legend s-AM4 B450',2500,1,1),(5,'Gigabyte B450M Gaming s-AM4 B450',1899,3,1),(8,'GeForce GTX 1050 Ti Dual Fan 4GB GDDR5',7999,6,2),(9,'Asus PCI-E GeForce GTX1050 Ti 4GB DDR5',8999,7,2),(10,'GIGABYTE GeForce RTX 2060 OC 6G',21347,8,2),(11,'Palit GeForce RTX 3060 12 GB Dual OC ',55000,9,2),(12,'GIGABYTE X299X AORUS XTREME WF',54866,2,1),(13,'MSI GeForce RTX 2060 VENTUS GP OC',23000,4,2),(15,'test1',1,1,2),(18,'NEW TEST',213123,1,2),(21,'intel core i5 7200u',5500,3,3),(22,'Intel Core i5-8400',4500,4,3),(23,'Intel Core i5-10400F',5400,5,3),(24,'Intel Core i7-10700K',11750,6,3),(25,'Intel Core i9-9900K',11593,6,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `idReceipt` int NOT NULL AUTO_INCREMENT,
  `Price` int NOT NULL,
  `user_iduser` int NOT NULL,
  `idStatus` int NOT NULL,
  PRIMARY KEY (`idReceipt`),
  KEY `fk_Receipt_user1_idx` (`user_iduser`),
  KEY `status_idStatus_fk` (`idStatus`),
  CONSTRAINT `fk_Receipt_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `status_idStatus_fk` FOREIGN KEY (`idStatus`) REFERENCES `status` (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (23,90284,3,3),(24,3798,3,3),(25,9000,3,3),(26,3798,3,3),(27,9495,3,3),(28,85559,3,3),(29,45896,3,1),(30,45896,3,1),(31,45896,3,3),(32,23186,3,3);
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reciept_has_product`
--

DROP TABLE IF EXISTS `reciept_has_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reciept_has_product` (
  `idreciept_has_product` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  `idProduct` int NOT NULL,
  `idReceipt` int NOT NULL,
  PRIMARY KEY (`idreciept_has_product`),
  KEY `product_idProduct_fk` (`idProduct`),
  KEY `receipt_idReceipt_fk` (`idReceipt`),
  CONSTRAINT `product_idProduct_fk` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  CONSTRAINT `receipt_idReceipt_fk` FOREIGN KEY (`idReceipt`) REFERENCES `receipt` (`idReceipt`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reciept_has_product`
--

LOCK TABLES `reciept_has_product` WRITE;
/*!40000 ALTER TABLE `reciept_has_product` DISABLE KEYS */;
INSERT INTO `reciept_has_product` VALUES (31,7,13293,5,23),(32,9,71991,8,23),(33,2,5000,1,23),(34,2,3798,5,24),(35,2,9000,22,25),(36,2,3798,5,26),(37,5,9495,5,27),(38,2,15998,8,28),(39,3,3,15,28),(40,6,69558,25,28),(41,3,26997,9,30),(42,3,26997,9,30),(43,1,5500,21,30),(44,1,5500,21,30),(45,1,5400,23,30),(46,1,5400,23,30),(47,1,7999,8,30),(48,1,7999,8,30),(49,3,26997,9,31),(50,2,23186,25,32);
/*!40000 ALTER TABLE `reciept_has_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_user` (
  `idRole_user` int NOT NULL AUTO_INCREMENT,
  `Role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idRole_user`),
  UNIQUE KEY `Role_name_UNIQUE` (`Role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` VALUES (1,'ROLE_ADMIN'),(22,'ROLE_USER');
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `idStatus` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'В обработке'),(2,'Готов'),(3,'Доставлен'),(4,'Отменен');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `idtype` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idtype`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (2,'graphicsCard'),(1,'motherboard'),(3,'processor');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `Login` varchar(45) NOT NULL,
  `User_password` varchar(45) NOT NULL,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `Patronymic` varchar(45) NOT NULL,
  `Telephone` varchar(45) NOT NULL,
  `idRole` int NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `idusers_UNIQUE` (`iduser`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  UNIQUE KEY `Telephone_UNIQUE` (`Telephone`),
  KEY `role_user_idRole_user_fk` (`idRole`),
  CONSTRAINT `role_user_idRole_user_fk` FOREIGN KEY (`idRole`) REFERENCES `role_user` (`idRole_user`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'ulogin','upass','Anton','Antonov','Antonovich','+3801231231',22),(4,'alogin','apass','Nikita','Hritsay','Olegovich','+380501326581',1),(5,'ulogin1','upass1','Segei','Sergeev','Sergeevich','+380505050505',22);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-09 16:13:39
