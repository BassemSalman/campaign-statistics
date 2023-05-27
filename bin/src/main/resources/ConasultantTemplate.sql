CREATE DATABASE  IF NOT EXISTS `consultant_template_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `consultant_template_db`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 192.168.10.54    Database: consultant_template_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `tbl_customicon`
--

DROP TABLE IF EXISTS `tbl_customicon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_customicon` (
  `ICON_ID` bigint NOT NULL AUTO_INCREMENT,
  `ICON_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ICON_MAXINPUT` int DEFAULT NULL,
  `ICON_MAXOUTPUT` int DEFAULT NULL,
  `ICON_IMAGE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ICON_SOURCE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ICON_HASINPUT` tinyint DEFAULT NULL,
  `ICON_HASOUTPUT` tinyint DEFAULT NULL,
  `ICON_CATEGORY` int DEFAULT NULL,
  `ICON_MENUCLASS` varchar(45) DEFAULT NULL,
  `ICON_TYPE` int DEFAULT NULL,
  `JOURNEYID` varchar(45) DEFAULT NULL,
  `GATEWAY_ICON_TYPE` bigint DEFAULT NULL,
  `IS_GATEWAY` tinyint DEFAULT '0',
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  `ICON_ROLE` varchar(1024) DEFAULT NULL COMMENT '\n',
  `PARAMETERS_DESCRIPTION` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`ICON_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1667485651141881 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customicon`
--

LOCK TABLES `tbl_customicon` WRITE;
/*!40000 ALTER TABLE `tbl_customicon` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customicon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_internal_consultants`
--

DROP TABLE IF EXISTS `tbl_internal_consultants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_internal_consultants` (
  `id` bigint NOT NULL DEFAULT '0',
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `consultantNumber` int DEFAULT NULL,
  `consultantGroup` varchar(45) DEFAULT NULL,
  `automaticStartup` tinyint DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `port` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `interface_url` varchar(100) DEFAULT NULL,
  `controller_url` varchar(50) DEFAULT NULL,
  `userprofile_id` bigint DEFAULT NULL,
  `protocol` varchar(45) DEFAULT NULL,
  `server_id` int DEFAULT NULL,
  `to_reload` tinyint DEFAULT NULL,
  `is_jar` tinyint DEFAULT NULL,
  `deleted_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_internal_consultants`
--

LOCK TABLES `tbl_internal_consultants` WRITE;
/*!40000 ALTER TABLE `tbl_internal_consultants` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_internal_consultants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_internal_consultants_icon_settings`
--

DROP TABLE IF EXISTS `tbl_internal_consultants_icon_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_internal_consultants_icon_settings` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `consultant_type_id` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `is_input` tinyint DEFAULT NULL,
  `query_id` int NOT NULL DEFAULT '0',
  `query_value` longtext,
  `description` varchar(2000) DEFAULT NULL,
  `field_name` varchar(100) DEFAULT NULL,
  `default_value` varchar(200) DEFAULT NULL,
  `required` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `FK_7141672475126471524_idx` (`consultant_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_internal_consultants_icon_settings`
--

LOCK TABLES `tbl_internal_consultants_icon_settings` WRITE;
/*!40000 ALTER TABLE `tbl_internal_consultants_icon_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_internal_consultants_icon_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_internal_consultants_settings`
--

DROP TABLE IF EXISTS `tbl_internal_consultants_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_internal_consultants_settings` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `consultant_type_id` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `query_id` int NOT NULL DEFAULT '0',
  `query_value` longtext,
  `required` tinyint NOT NULL DEFAULT '1',
  `default_value` varchar(200) DEFAULT NULL,
  `field_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_234124434534314_idx` (`consultant_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_internal_consultants_settings`
--

LOCK TABLES `tbl_internal_consultants_settings` WRITE;
/*!40000 ALTER TABLE `tbl_internal_consultants_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_internal_consultants_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_internal_consultants_settings_values`
--

DROP TABLE IF EXISTS `tbl_internal_consultants_settings_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_internal_consultants_settings_values` (
  `ID` bigint NOT NULL,
  `setting_id` bigint DEFAULT NULL,
  `internal_consultant_id` bigint DEFAULT NULL,
  `value` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_4234423541423424_idx` (`internal_consultant_id`),
  KEY `fk_35345234234124_idx` (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_internal_consultants_settings_values`
--

LOCK TABLES `tbl_internal_consultants_settings_values` WRITE;
/*!40000 ALTER TABLE `tbl_internal_consultants_settings_values` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_internal_consultants_settings_values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_internal_consultants_type`
--

DROP TABLE IF EXISTS `tbl_internal_consultants_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_internal_consultants_type` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `server_id` int DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `is_jar` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_internal_consultants_type`
--

LOCK TABLES `tbl_internal_consultants_type` WRITE;
/*!40000 ALTER TABLE `tbl_internal_consultants_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_internal_consultants_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_settings_mapping`
--

DROP TABLE IF EXISTS `tbl_settings_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_settings_mapping` (
  `COLUMNID` int NOT NULL AUTO_INCREMENT,
  `COLUMNNAME` varchar(255) NOT NULL,
  `COLUMNDESCRIPTION` varchar(255) NOT NULL,
  `LABELDISPLAY` varchar(255) NOT NULL,
  `FIELDTYPE` varchar(255) NOT NULL,
  `RELATEDCOLUMNS` int NOT NULL DEFAULT '0',
  `COLUMNVALUE` varchar(255) NOT NULL DEFAULT '',
  `QUERYTEXT` varchar(500) NOT NULL DEFAULT '',
  `ENABLED` int NOT NULL DEFAULT '0',
  `EDITABLE` int NOT NULL DEFAULT '0',
  `SUBTABLENAME` varchar(255) NOT NULL DEFAULT '',
  `AUTOINC` int NOT NULL DEFAULT '0',
  `UNIQUEVALUE` int NOT NULL DEFAULT '0',
  `MANDATORY` int NOT NULL DEFAULT '0',
  `RELATEDCOLNAME` varchar(50) NOT NULL DEFAULT '',
  `RELATEDAUTOINCCOLNAME` varchar(50) NOT NULL DEFAULT '',
  `COLUMNCATEGORY` varchar(50) NOT NULL DEFAULT 'GENERAL',
  `ISADMIN` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`COLUMNID`)
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_settings_mapping`
--

LOCK TABLES `tbl_settings_mapping` WRITE;
/*!40000 ALTER TABLE `tbl_settings_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_settings_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_statistics`
--

DROP TABLE IF EXISTS `tbl_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_statistics` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `statistic_description` varchar(45) DEFAULT NULL,
  `data` mediumblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5002 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_statistics`
--

LOCK TABLES `tbl_statistics` WRITE;
/*!40000 ALTER TABLE `tbl_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_statistics_consultants`
--

DROP TABLE IF EXISTS `tbl_statistics_consultants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_statistics_consultants` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CURRENT_DATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CONSULTANT_ID` bigint NOT NULL DEFAULT '1',
  `CONSULTANT_TYPE` int NOT NULL,
  `DATA` json NOT NULL,
  `INSERTION_DATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `IDX_CONSTYPE` (`CONSULTANT_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=4694 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_statistics_consultants`
--

LOCK TABLES `tbl_statistics_consultants` WRITE;
/*!40000 ALTER TABLE `tbl_statistics_consultants` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_statistics_consultants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'consultant_template_db'
--

--
-- Dumping routines for database 'consultant_template_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `PROC_SELECT_CONSULTANT_STATISTICS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `PROC_SELECT_CONSULTANT_STATISTICS`(IN ROW_DATETIME VARCHAR(30), IN IN_CONSULTANT_TYPE INT)
BEGIN
	DECLARE VAR_EXIST INTEGER;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		GET DIAGNOSTICS CONDITION 1 @sqlstate = RETURNED_SQLSTATE, 
		@errno = MYSQL_ERRNO, @t = MESSAGE_TEXT;
	END;
    SET ROW_DATETIME = CONCAT(ROW_DATETIME, '');
    
    SELECT CONSULTANT_ID, DATA FROM TBL_STATISTICS_CONSULTANTS WHERE CONSULTANT_TYPE = IN_CONSULTANT_TYPE AND CURRENT_DATETIME = ROW_DATETIME;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PROC_UPDATE_CONSULTANT_STATISTICS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `PROC_UPDATE_CONSULTANT_STATISTICS`(IN ROW_DATETIME VARCHAR(30), IN IN_CONSULTANT_ID BIGINT, IN IN_CONSULTANT_TYPE INT, IN IN_JSON_DATA LONGTEXT)
BEGIN
	DECLARE VAR_EXIST INTEGER;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		GET DIAGNOSTICS CONDITION 1 @sqlstate = RETURNED_SQLSTATE, 
		@errno = MYSQL_ERRNO, @t = MESSAGE_TEXT;
	END;
    SET ROW_DATETIME = CONCAT(ROW_DATETIME, '');
    
    SELECT COUNT(1) INTO VAR_EXIST FROM TBL_STATISTICS_CONSULTANTS WHERE CURRENT_DATETIME=ROW_DATETIME AND CONSULTANT_ID = IN_CONSULTANT_ID AND CONSULTANT_TYPE = IN_CONSULTANT_TYPE;
    IF VAR_EXIST = 1 THEN
        UPDATE TBL_STATISTICS_CONSULTANTS SET DATA = IN_JSON_DATA
            WHERE CURRENT_DATETIME=ROW_DATETIME AND CONSULTANT_ID = IN_CONSULTANT_ID AND CONSULTANT_TYPE = IN_CONSULTANT_TYPE;
	ELSE
        INSERT INTO TBL_STATISTICS_CONSULTANTS (CURRENT_DATETIME, CONSULTANT_ID, CONSULTANT_TYPE, DATA)
			VALUES (ROW_DATETIME, IN_CONSULTANT_ID, IN_CONSULTANT_TYPE, IN_JSON_DATA);
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05  8:26:45
