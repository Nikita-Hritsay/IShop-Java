-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: courseproject
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `basket` (
  `idbasket` int NOT NULL AUTO_INCREMENT,
  `Price` int NOT NULL,
  `user_iduser` int NOT NULL,
  PRIMARY KEY (`idbasket`,`user_iduser`),
  KEY `fk_basket_user1_idx` (`user_iduser`),
  CONSTRAINT `fk_basket_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket`
--

LOCK TABLES `basket` WRITE;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
INSERT INTO `basket` VALUES (1,0,3),(2,0,5),(3,0,4),(4,0,9),(5,0,11);
/*!40000 ALTER TABLE `basket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basket_product`
--

DROP TABLE IF EXISTS `basket_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `basket_product` (
  `idbasket_product` int NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  `basket_idbasket` int NOT NULL,
  `basket_user_iduser` int NOT NULL,
  `product_idProduct` int NOT NULL,
  PRIMARY KEY (`idbasket_product`,`basket_idbasket`,`basket_user_iduser`,`product_idProduct`),
  KEY `fk_basket_product_basket1_idx` (`basket_idbasket`,`basket_user_iduser`),
  KEY `fk_basket_product_product1_idx` (`product_idProduct`),
  CONSTRAINT `fk_basket_product_basket1` FOREIGN KEY (`basket_idbasket`, `basket_user_iduser`) REFERENCES `basket` (`idbasket`, `user_iduser`),
  CONSTRAINT `fk_basket_product_product1` FOREIGN KEY (`product_idProduct`) REFERENCES `product` (`idProduct`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket_product`
--

LOCK TABLES `basket_product` WRITE;
/*!40000 ALTER TABLE `basket_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `basket_product` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (22,'Доставка домой',';;',45),(23,'Доставка почтой',';;',48),(24,'Доставка домой','сюда',49),(25,'Доставка домой','asdcasdcasdcasdcasdcasdcasdcasdcasdcas',50),(26,'Доставка домой','сюда',51),(27,'msi 3080','сюда',52),(28,'Доставка в отделение','kn',53),(29,'Доставка домой','asdcasdcasdcasdcasdcasdcasdcasdcasdcas',54),(30,'Доставка домой','asdcasdcasdcasdcasdcasdcasdcasdcasdcas',55),(31,'Доставка домой',';;',56),(32,'','',57),(33,'Доставка в отделение','сюда',58),(34,'Доставка почтой',';;',59),(35,'Доставка в отделение',';;',60),(36,'Доставка почтой','kn',61),(37,'Доставка почтой',';;',62),(38,'Доставка в отделение','сюда',63),(39,'Доставка в отделение','сюда',64),(40,'Доставка в отделение',';;',65),(41,'Доставка почтой',';;',66),(42,'Доставка в отделение','asdcasdcasdcasdcasdcasdcasdcasdcasdcas',67),(43,'Доставка в отделение','asdcasdcasdcasdcasdcasdcasdcasdcasdcas',68),(44,'Доставка в отделение',';;',69),(45,'','',70),(46,'Доставка в отделение','сюда',71);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
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
  `productDescription` varchar(1000) NOT NULL,
  PRIMARY KEY (`idProduct`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `Img_idImg_fk` (`Img_idImg`),
  KEY `type_idType_fk` (`idType`),
  CONSTRAINT `Img_idImg_fk` FOREIGN KEY (`Img_idImg`) REFERENCES `img` (`idImg`),
  CONSTRAINT `type_idType_fk` FOREIGN KEY (`idType`) REFERENCES `type` (`idtype`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Motherboard ASRock B450M Steel Legend s-AM4 B450',2500,1,1,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(5,'Gigabyte B450M Gaming s-AM4 B450',1899,3,1,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(8,'GeForce GTX 1050 Ti Dual Fan 4GB GDDR5',7999,6,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(9,'Asus PCI-E GeForce GTX1050 Ti 4GB DDR5',8999,7,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(10,'GIGABYTE GeForce RTX 2060 OC 6G',21347,8,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(11,'Palit GeForce RTX 3060 12 GB Dual OC ',55000,9,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(12,'GIGABYTE X299X AORUS XTREME WF',54866,2,1,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(13,'MSI GeForce RTX 2060 VENTUS GP OC',23000,4,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(15,'test1',1,1,2,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(21,'intel core i5 7200u',5500,3,3,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(22,'Intel Core i5-8400',4500,4,3,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(23,'Intel Core i5-10400F',5400,5,3,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(24,'Intel Core i7-10700K',11750,6,3,'Kaчecтвeннaя maтepинckaя плaтa – kлючeвoй элemeнт komпьютepa. Oнa пpeдcтaвляeт coбoй пeчaтнyю kapтy c mиkpocxemamи. K этomy ycтpoйcтвy пoдkлючaютcя пpoцeccop, oпepaтивнaя пamять, видeokapтa, жecтkий диck. Дeвaйc yпpaвляeт paбoтoй cиcтemы. Пpoизвoдитeли выпyckaют oбopyдoвaниe, coвmecтиmoe c paзныmи komплekтyющиmи для ПK. Чтoбы coбpaть xopoший cиcтemный блok, yчитывaйтe xapakтepиcтиkи пpoцeccopa и дpyгиx cocтaвляющиx cиcтemы. Пpи выбope oбpaщaйтe вниmaниe нa фopm-фakтop, чипceт, koличecтвo cлoтoв пoд oпepaтивнyю пamять. Oт этиx пapameтpoв зaвиcят вoзmoжнocти и цeнa. источник: https://www.foxtrot.com.ua/ru/shop/materinskie_plati.html'),(26,'here',4123213,2,3,'nice tovar\r\n');
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (44,0,3,1),(45,0,3,1),(46,0,3,1),(47,0,3,1),(48,0,3,1),(49,0,3,1),(50,0,3,1),(51,0,3,4),(52,0,3,3),(53,0,9,1),(54,4123213,3,1),(55,14696,3,1),(56,3798,3,1),(57,8999,3,1),(58,7999,3,1),(59,9898,3,1),(60,21347,3,1),(61,1899,3,1),(62,1899,3,1),(63,7999,3,1),(64,7999,3,1),(65,4500,3,1),(66,7999,3,1),(67,7999,3,1),(68,7999,3,1),(69,7999,3,1),(70,71992,3,4),(71,21347,3,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=1756 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reciept_has_product`
--

LOCK TABLES `reciept_has_product` WRITE;
/*!40000 ALTER TABLE `reciept_has_product` DISABLE KEYS */;
INSERT INTO `reciept_has_product` VALUES (1510,3,21347,1,44),(1511,6,1899,1,44),(1512,3,21347,1,44),(1513,6,1899,1,44),(1514,3,21347,1,44),(1515,6,1899,1,44),(1516,3,21347,1,44),(1517,6,1899,1,44),(1518,3,21347,1,44),(1519,6,1899,1,44),(1520,3,21347,1,44),(1521,6,1899,1,44),(1522,3,21347,1,44),(1523,6,1899,1,44),(1524,3,21347,1,44),(1525,6,1899,1,44),(1526,3,21347,1,44),(1527,6,1899,1,44),(1528,3,21347,1,44),(1529,6,1899,1,44),(1530,3,21347,1,44),(1531,6,1899,1,44),(1532,3,21347,1,44),(1533,6,1899,1,44),(1534,3,21347,1,44),(1535,6,1899,1,44),(1536,3,21347,1,44),(1537,6,1899,1,44),(1538,3,21347,1,44),(1539,6,1899,1,44),(1540,3,21347,1,44),(1541,6,1899,1,44),(1542,3,21347,1,44),(1543,6,1899,1,44),(1544,3,21347,1,44),(1545,6,1899,1,44),(1546,3,21347,1,44),(1547,6,1899,1,44),(1548,3,21347,1,44),(1549,6,1899,1,44),(1550,3,21347,1,44),(1551,6,1899,1,44),(1552,3,21347,1,44),(1553,6,1899,1,44),(1554,3,21347,1,44),(1555,6,1899,1,44),(1556,3,21347,1,44),(1557,6,1899,1,44),(1558,3,21347,1,44),(1559,6,1899,1,44),(1560,3,21347,1,44),(1561,6,1899,1,44),(1562,3,21347,1,44),(1563,6,1899,1,44),(1564,3,21347,1,44),(1565,6,1899,1,44),(1566,3,21347,1,44),(1567,6,1899,1,44),(1568,3,21347,1,44),(1569,6,1899,1,44),(1570,3,21347,5,44),(1571,6,1899,5,44),(1572,3,21347,5,44),(1573,6,1899,5,44),(1574,3,21347,5,44),(1575,6,1899,5,44),(1576,3,21347,5,44),(1577,6,1899,5,44),(1578,3,21347,5,44),(1579,6,1899,5,44),(1580,3,21347,5,44),(1581,6,1899,5,44),(1582,3,21347,5,44),(1583,6,1899,5,44),(1584,3,21347,5,44),(1585,6,1899,5,44),(1586,3,21347,5,44),(1587,6,1899,5,44),(1588,3,21347,5,44),(1589,6,1899,5,44),(1590,3,21347,5,44),(1591,6,1899,5,44),(1592,3,21347,5,44),(1593,6,1899,5,44),(1594,3,21347,5,44),(1595,6,1899,5,44),(1596,3,21347,5,44),(1597,6,1899,5,44),(1598,3,21347,5,44),(1599,6,1899,5,44),(1600,3,21347,5,44),(1601,6,1899,5,44),(1602,3,21347,5,44),(1603,6,1899,5,44),(1604,3,21347,5,44),(1605,6,1899,5,44),(1606,3,21347,5,44),(1607,6,1899,5,44),(1608,3,21347,5,44),(1609,6,1899,5,44),(1610,3,21347,5,44),(1611,6,1899,5,44),(1612,3,21347,5,44),(1613,6,1899,5,44),(1614,3,21347,5,44),(1615,6,1899,5,44),(1616,3,21347,5,44),(1617,6,1899,5,44),(1618,3,21347,5,44),(1619,6,1899,5,44),(1620,3,21347,5,44),(1621,6,1899,5,44),(1622,3,21347,5,44),(1623,6,1899,5,44),(1624,3,21347,5,44),(1625,6,1899,5,44),(1626,3,21347,5,44),(1627,6,1899,5,44),(1628,3,21347,5,44),(1629,6,1899,5,44),(1630,3,21347,8,44),(1631,6,1899,8,44),(1632,3,21347,8,44),(1633,6,1899,8,44),(1634,3,21347,8,44),(1635,6,1899,8,44),(1636,3,21347,8,44),(1637,6,1899,8,44),(1638,3,21347,8,44),(1639,6,1899,8,44),(1640,3,21347,8,44),(1641,6,1899,8,44),(1642,3,21347,8,44),(1643,6,1899,8,44),(1644,3,21347,8,44),(1645,6,1899,8,44),(1646,3,21347,8,44),(1647,6,1899,8,44),(1648,3,21347,8,44),(1649,6,1899,8,44),(1650,3,21347,8,44),(1651,6,1899,8,44),(1652,3,21347,8,44),(1653,6,1899,8,44),(1654,3,21347,8,44),(1655,6,1899,8,44),(1656,3,21347,8,44),(1657,6,1899,8,44),(1658,3,21347,8,44),(1659,6,1899,8,44),(1660,3,21347,8,44),(1661,6,1899,8,44),(1662,3,21347,8,44),(1663,6,1899,8,44),(1664,3,21347,8,44),(1665,6,1899,8,44),(1666,3,21347,8,44),(1667,6,1899,8,44),(1668,3,21347,8,44),(1669,6,1899,8,44),(1670,3,21347,8,44),(1671,6,1899,8,44),(1672,3,21347,8,44),(1673,6,1899,8,44),(1674,3,21347,8,44),(1675,6,1899,8,44),(1676,3,21347,8,44),(1677,6,1899,8,44),(1678,3,21347,8,44),(1679,6,1899,8,44),(1680,3,21347,8,44),(1681,6,1899,8,44),(1682,3,21347,8,44),(1683,6,1899,8,44),(1684,3,21347,8,44),(1685,6,1899,8,44),(1686,3,21347,8,44),(1687,6,1899,8,44),(1688,3,21347,8,44),(1689,6,1899,8,44),(1690,3,21347,9,44),(1691,6,1899,9,44),(1692,3,21347,9,44),(1693,6,1899,9,44),(1694,3,21347,9,44),(1695,6,1899,9,44),(1696,3,21347,9,44),(1697,6,1899,9,44),(1698,3,21347,9,44),(1699,6,1899,9,44),(1700,3,21347,9,44),(1701,6,1899,9,44),(1702,3,21347,9,44),(1703,6,1899,9,44),(1704,3,21347,9,44),(1705,6,1899,9,44),(1706,3,21347,9,44),(1707,6,1899,9,44),(1708,3,21347,9,44),(1709,6,1899,9,44),(1710,3,21347,9,44),(1711,6,1899,9,44),(1712,3,21347,9,44),(1713,6,1899,9,44),(1714,3,21347,9,44),(1715,6,1899,9,44),(1716,3,21347,9,44),(1717,6,1899,9,44),(1718,3,21347,9,44),(1719,6,1899,9,44),(1720,3,21347,9,44),(1721,6,1899,5,49),(1722,3,21347,10,49),(1723,6,1899,5,50),(1724,3,21347,10,50),(1725,3,5400,23,50),(1726,6,1899,5,51),(1727,3,21347,10,51),(1728,3,5400,23,51),(1729,3,7999,8,51),(1730,6,1899,5,52),(1731,3,21347,10,52),(1732,3,5400,23,52),(1733,5,7999,8,52),(1734,6,8999,9,53),(1735,1,11750,24,53),(1736,1,4123213,26,54),(1737,3,1899,5,55),(1738,1,8999,9,55),(1739,2,1899,5,56),(1740,1,8999,9,57),(1741,1,7999,8,58),(1742,1,7999,8,59),(1743,1,1899,5,59),(1744,1,21347,10,60),(1745,1,1899,5,61),(1746,1,1899,5,62),(1747,1,7999,8,63),(1748,1,7999,8,64),(1749,1,4500,22,65),(1750,1,7999,8,66),(1751,1,7999,8,67),(1752,1,7999,8,68),(1753,1,7999,8,69),(1754,8,8999,9,70),(1755,1,21347,10,71);
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
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
  `User_password` varchar(200) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'ulogin','upass','Anton','Antonov','Antonovich','+3801231231',22),(4,'alogin','apass','Nikita','Hritsay','Olegovich','+380501326581',1),(5,'ulogin1','upass1','Segei','Sergeev','Sergeevich','+380505050505',22),(9,'ulogin2','upass2','Евгений','Евгениев','Евгениевич','+3801111111111',22),(11,'ulogin4','$2a$10$CR6Rx5QQhoeQjoPcBfeZzevi6DxjRn0VpiArs0jHkkdul4Ui6RwTK','Евгений','Евгениев','Евгениевич','+3801111111122',22);
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

-- Dump completed on 2021-07-09 15:14:45
