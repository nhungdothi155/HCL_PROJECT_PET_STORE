-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: hcl_project_pet_store
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `pet_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pet_name` varchar(255) NOT NULL,
  `pet_age` float(255,0) NOT NULL,
  `pet_weight` double(10,2) NOT NULL,
  `pet_type` varchar(255) NOT NULL,
  `pet_origin` varchar(255) NOT NULL,
  `status` enum('IN_STOCK','OUT_OF_STOCK') NOT NULL,
  `photos` varchar(255) NOT NULL,
  `pet_description` text NOT NULL,
  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `date_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` (`pet_id`, `pet_name`, `pet_age`, `pet_weight`, `pet_type`, `pet_origin`, `status`, `photos`, `pet_description`, `date_created`, `date_modified`) VALUES (1,'Dog',4,4.30,'CORGI','VIETNAME','IN_STOCK','https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg','ngoan va hien','2021-04-21 03:29:00','2021-05-01 07:08:04'),(2,'Dog',4,4.30,'CORGI','VIETNAME','IN_STOCK','https://pixabay.com/get/ga1ea62bd5a5e2f81c7af13dc062a873fb9cd8b1559b47be531ed6e9578f89f5134a225071bd55606681760c15d0600ce_1920.jpg','ngoan va hien','2021-04-21 03:30:44','2021-05-01 07:08:19'),(3,'Dog',4,4.30,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','ngo va hien','2021-05-01 09:25:58','2021-05-01 09:25:58'),(4,'Dog',4,4.40,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','nice and beauty','2021-05-01 09:26:45','2021-05-01 09:26:45'),(5,'Dog',4,4.43,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beauty and nice','2021-05-01 09:27:31','2021-05-01 09:27:31'),(6,'Dog',4,4.40,'PULL FRENCH','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beauty and nice','2021-05-01 09:28:25','2021-05-01 09:28:25'),(7,'Dog',4,4.40,'PULL FRENCH','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','nice and beauty ','2021-05-01 09:29:26','2021-05-01 09:29:26'),(8,'Dog',4,4.35,'PULL FRENCH','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','nice and beauty','2021-05-01 09:30:04','2021-05-01 09:30:04'),(9,'Dog',4,4.35,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beautiful and nice','2021-05-01 09:31:04','2021-05-01 09:31:04'),(10,'Dog',4,4.35,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beautiful and nice','2021-05-01 09:31:42','2021-05-01 09:31:42'),(11,'Dog',4,4.35,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beautifyl an dnice','2021-05-01 09:32:18','2021-05-01 09:32:18'),(12,'Dog',4,3.45,'CORGI','VIETNAME','IN_STOCK','http://localhost:8080/HCL_PROJECT_PET_STORE/customer/images/ad1.png','beutifyl and nice','2021-05-01 09:33:00','2021-05-01 09:33:00');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 10:34:46
