-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: _atividade04
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lista_de_profissoes`
--

DROP TABLE IF EXISTS `lista_de_profissoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_de_profissoes` (
  `id_lista_profissoes` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de uma lista de profissões',
  `pk_id_profissao1` int(11) NOT NULL COMMENT 'identificador da primeira profissão',
  `pk_id_profissao2` int(11) DEFAULT NULL COMMENT 'identificador da segunda profissão',
  `pk_id_profissao3` int(11) DEFAULT NULL COMMENT 'identificador da terceira profissão',
  PRIMARY KEY (`id_lista_profissoes`),
  KEY `lista_de_profissoes_FK_id_profissoes` (`pk_id_profissao1`),
  KEY `lista_de_profissoes_FK2_id_profissoes` (`pk_id_profissao2`),
  KEY `lista_de_profissoes_FK3_id_profissoes` (`pk_id_profissao3`),
  CONSTRAINT `lista_de_profissoes_FK2_id_profissoes` FOREIGN KEY (`pk_id_profissao2`) REFERENCES `profissoes` (`id_profissao`),
  CONSTRAINT `lista_de_profissoes_FK3_id_profissoes` FOREIGN KEY (`pk_id_profissao3`) REFERENCES `profissoes` (`id_profissao`),
  CONSTRAINT `lista_de_profissoes_FK_id_profissoes` FOREIGN KEY (`pk_id_profissao1`) REFERENCES `profissoes` (`id_profissao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_de_profissoes`
--

LOCK TABLES `lista_de_profissoes` WRITE;
/*!40000 ALTER TABLE `lista_de_profissoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_de_profissoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_de_telefones`
--

DROP TABLE IF EXISTS `lista_de_telefones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_de_telefones` (
  `id_telefones` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador da lista de telefones',
  `telefone1` bigint(20) NOT NULL COMMENT 'primeiro telefone',
  `telefone2` bigint(20) DEFAULT NULL COMMENT 'segundo telefone',
  `telefone3` bigint(20) DEFAULT NULL COMMENT 'terceiro telefone',
  PRIMARY KEY (`id_telefones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_de_telefones`
--

LOCK TABLES `lista_de_telefones` WRITE;
/*!40000 ALTER TABLE `lista_de_telefones` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_de_telefones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoas`
--

DROP TABLE IF EXISTS `pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoas` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de uma pessoa',
  `nome_pessoa` varchar(90) NOT NULL COMMENT 'nome da pessoa referente',
  `id_profissao` int(11) NOT NULL COMMENT 'identificador de uma lista de profissões',
  `id_lista_de_telefones` int(11) DEFAULT NULL COMMENT 'identificador de uma lista de telefones',
  PRIMARY KEY (`id_pessoa`),
  KEY `pessoas_FK` (`id_lista_de_telefones`),
  KEY `pessoas_FK_1` (`id_profissao`),
  CONSTRAINT `pessoas_FK` FOREIGN KEY (`id_lista_de_telefones`) REFERENCES `lista_de_telefones` (`id_telefones`),
  CONSTRAINT `pessoas_FK_1` FOREIGN KEY (`id_profissao`) REFERENCES `lista_de_profissoes` (`id_lista_profissoes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoas`
--

LOCK TABLES `pessoas` WRITE;
/*!40000 ALTER TABLE `pessoas` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profissoes`
--

DROP TABLE IF EXISTS `profissoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profissoes` (
  `id_profissao` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de uma profissao',
  `nome_profissao` varchar(90) NOT NULL COMMENT 'nome da profissão referente',
  `descricao` varchar(350) NOT NULL COMMENT 'descrição breve sobre a profissão',
  PRIMARY KEY (`id_profissao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissoes`
--

LOCK TABLES `profissoes` WRITE;
/*!40000 ALTER TABLE `profissoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `profissoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database '_atividade04'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-01  9:59:13
