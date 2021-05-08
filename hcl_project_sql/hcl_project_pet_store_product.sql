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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) unsigned DEFAULT NULL,
  `product_name` text,
  `description` text,
  `brand` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `price` float(10,0) unsigned DEFAULT NULL,
  `product_numbers` bigint(20) unsigned DEFAULT NULL,
  `photos` longtext,
  `weight` double DEFAULT NULL,
  `age` double DEFAULT NULL,
  `product_state` enum('NEW','USED') DEFAULT NULL,
  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `date_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  KEY `FKED8DCCEF8DB829FC` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `category_id`, `product_name`, `description`, `brand`, `material`, `origin`, `price`, `product_numbers`, `photos`, `weight`, `age`, `product_state`, `date_created`, `date_modified`) VALUES (1,1,'Fluffy Corgi Dog','Fluffy Corgi Dog',NULL,NULL,'Thailand',100,32,'imgccbce05f-f332-408f-a7a2-40873e580dc9.jpg,img20080bde3-f4de-4601-a6b8-63119c4e5eed.jpg,img489822403-e1ec-432a-b115-6d064d755f94.jpg,img57df29b1e-5e79-45c3-8207-96a7e5942850.jpg',4,5,NULL,'2021-05-07 14:33:21','2021-05-07 14:38:45'),(2,1,'Corgi Pembroke Dog','Corgi Pembroke Dog',NULL,NULL,'Thailand',200,2,'img7dd797873-ca24-40d1-a65b-ebcc0cd5c5e2.jpg,img835e48ed8-28d3-4ce1-aec6-c54391ca8c77.jpg,img5398ab1a9-1c73-4657-b593-cf51b3101858.jpg,img4f1842765-cb21-4644-a07a-a02deb1c5c18.jpg',6,2,NULL,'2021-05-05 06:30:05','2021-05-07 14:32:17'),(3,1,'Pomeranian Blacktan dog','Pomeranian Blacktan dog',NULL,NULL,' Thailand',250,1,'img5d8c4e0d-41ab-409e-8f32-daa2a96c9cfe.jpg,img675d10e2c-2984-41ee-b78e-d6781f073ce6.jpg,img727f8a57e-70a5-4f70-8062-6e753af66159.jpg,img4fa6c6a43-bddc-4518-a0c3-0a95dc2bd02a.jpg',2,2.5,NULL,'2021-05-05 05:45:45','2021-05-07 14:32:22'),(4,1,'Pomeranian Blacktan dog','Pomeranian Blacktan dog',NULL,NULL,'Thailand',400,3,'img1c83b6cea-8f01-42c0-a8b2-66bf6d7b4030.jpg,img8d4496689-e6fa-476a-9510-15abe06140fd.jpg,img5b9bdcd00-9ba9-4a7b-8a84-166dfc1e5eed.jpg,img7a63cfd25-4ab0-48bc-99cc-7ede853903b9.jpg',3.4,1.5,NULL,'2021-05-05 05:52:38','2021-05-07 14:32:26'),(5,1,'Nhung dog','Nhung dog',NULL,NULL,'Vietnam',100,1,'img831b28801-5dd7-46dc-8d88-4d4a7c9bb935.jpg,img189c03be6-eae9-48ae-b53d-8c53747c9f06.jpg,img468ea86e9-a49c-40ec-9db6-bdcae1a3317f.jpg,img2297202ce-e516-4c74-9ab4-12e7e16029f1.jpg',5,3.5,NULL,'2021-05-05 05:53:51','2021-05-07 14:32:31'),(6,1,'Conrgi Dog','Congi',NULL,NULL,'Vietnam',250,1,'img42b58a68f-2a86-4d71-80b9-4e71ef9f535f.jpg,img1e663315c-4542-4386-86d9-f2cabff07a2e.jpg,img59f4359ab-db58-4783-a459-528a92588cd4.jpg,img252299d27-0a63-404a-9646-091d1e47a9c9.jpg',1.4,2,NULL,'2021-05-05 06:29:54','2021-05-07 14:32:35'),(7,2,'Thuvien','Thuvien',NULL,NULL,'Japan',100,2,'img7e9695f95-0491-4a29-b787-deb496a6b76a.jpg,img5e46408e7-0b1e-43bd-a4ef-a67748eb9ce2.jpg,img446e608df-5759-4d58-b0a5-532e46f0d224.jpg,img2d333dee5-3faf-42c3-a6da-2a3761d82429.jpg',4,2,NULL,'2021-05-05 05:58:04','2021-05-07 14:32:41'),(8,2,'Latte','Latte',NULL,NULL,'China',100,1,'img4db0848fc-93af-4d28-9ee4-1a2c049c2963.jpg,img612a287c-359e-40f8-9f2b-298d9f7f7220.jpg,img20276d3d2-5258-401f-bd74-929b45ba08aa.jpg,img19227af87-134a-497f-86b3-b862ab198101.jpg',2.3,2.3,NULL,'2021-05-05 05:59:42','2021-05-07 14:32:45'),(9,1,'Kirin','Kirin',NULL,NULL,'China',500,24,'img45819ea4b-10e3-4e10-a2d6-273348ffa867.jpg,img1e640536a-f349-4c31-8b58-2a019f81665c.jpg,img28835d08-9d06-4c9b-b05a-1adaaf7597c8.jpg,img79f3f617a-22b1-4f76-893c-f8fdd8259c50.jpg',2.4,1,NULL,'2021-05-05 06:01:29','2021-05-07 14:41:13'),(10,2,'Tea','Tea',NULL,NULL,'China',300,2,'img7dac5bf41-298f-47f1-b6a0-4ef8d247ec01.jpg,img4f1d4ff7a-585b-474d-b841-a63070622e68.jpg,imgd86860c2-7b06-47dc-aac0-1be4cda7a6c2.jpg,img89a48db03-fc9c-48b1-9fd0-deba6fc99d64.jpg',4,3.5,NULL,'2021-05-05 06:03:53','2021-05-07 14:32:54'),(11,2,'Tiengviet ','Tiengviet',NULL,NULL,'Vietnam',400,2,'img6526f55f3-da9d-4850-a943-1892f96b8161.jpg,img239dc882f-714e-4432-8965-4ef5cec0cfc3.jpg,img432060fba-be0b-4ec3-b9c6-103e961ac827.jpg,img14d6a364b-592f-4dd0-95de-f19e0b29128e.jpg',4.5,2,NULL,'2021-05-05 06:05:57','2021-05-07 14:32:59'),(12,8,'Bibs','Bibs','Nickelodeon for Pets','cartoon','Thailand',15,20,'Domino_leash-biscuit-guinzaglio-dog-collar-leather-luxury-italy-pets-accessories-bwilde-b.wilde-wild8572e8f4-bf3e-49a0-9ee6-3c8b51551a51.jpg,images62eb96cb-e1ea-40fe-b821-3b0df8514dc7.jpg,leonard_church_pets_0337791998-8acf-4a82-b340-d2448ded90fa.jpg,freestocks--O5jgW2fkB8-unsplasheaf8b54b-9796-469b-9149-726a61dfb3c9.jpg',NULL,NULL,'NEW','2021-05-05 06:18:12','2021-05-07 14:33:03'),(13,8,'2 Color Bibs','color bibs','Necklace - Wires','cartoon','Thailand',20,40,'fernanda-matos-tj2OobwXFeA-unsplash31a31e25-6254-4322-9a9b-387d18a9e96d.jpg,leonard_church_pets_031fc44c62-de2d-4066-9dc6-4dce7509aac1.jpg,freestocks--O5jgW2fkB8-unsplash31c3a26c-c0d7-471a-a071-edd7341f888f.jpg,top-shop-ban-phu-kien-cho-thu-cung-uy-tin-hcm-8-650x4671ee0e1ab-19ba-4f4a-84b2-a4f94d7f661f.jpg',NULL,NULL,'USED','2021-05-05 06:20:18','2021-05-07 14:33:09');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 10:34:47
