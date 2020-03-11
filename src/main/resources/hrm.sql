CREATE DATABASE  IF NOT EXISTS `hrm4` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `hrm4`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hrm4
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `tb_department`
--

DROP TABLE IF EXISTS `tb_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `code` varchar(255) DEFAULT NULL COMMENT '部门编码',
  `organization_id` int(11) NOT NULL COMMENT '组织ID',
  `manager_id` int(11) DEFAULT NULL COMMENT '经理ID',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE,
  KEY `organization_id` (`organization_id`),
  CONSTRAINT `tb_department_ibfk_2` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
INSERT INTO `tb_department` VALUES (3,0,'信息技术部','0100',12,NULL,1,'2020-03-09 11:19:03','2020-03-09 11:19:03'),(4,3,'基础运维部','0101',12,NULL,1,'2020-03-09 11:19:58','2020-03-09 11:19:58'),(5,3,'系统开发部','0102',12,NULL,1,'2020-03-09 11:20:48','2020-03-09 11:21:22'),(6,3,'系统测试部','0103',12,NULL,1,'2020-03-09 11:25:01','2020-03-09 11:25:01'),(9,0,'人力资源部','0200',12,NULL,1,'2020-03-10 13:54:53','2020-03-10 13:54:53'),(10,9,'行政管理部','0201',12,NULL,1,'2020-03-10 13:55:19','2020-03-10 13:55:19'),(12,0,'信息技术部','1100',10,NULL,1,'2020-03-11 15:32:03','2020-03-11 15:32:03'),(13,12,'基础运维部','1101',10,NULL,1,'2020-03-11 15:32:30','2020-03-11 15:32:30'),(14,12,'系统开发部','1102',10,NULL,1,'2020-03-11 15:32:58','2020-03-11 15:32:58'),(15,0,'人力资源部','1200',10,NULL,1,'2020-03-11 15:33:32','2020-03-11 15:33:32'),(16,15,'行政管理部','1201',10,NULL,1,'2020-03-11 15:33:54','2020-03-11 15:33:54'),(17,0,'信息技术部','3100',13,NULL,1,'2020-03-11 16:44:24','2020-03-11 16:44:24'),(18,17,'基础运维部','3101',13,NULL,1,'2020-03-11 16:46:19','2020-03-11 16:47:18'),(19,17,'系统开发部','3102',13,NULL,1,'2020-03-11 17:00:54','2020-03-11 17:00:54');
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee`
--

DROP TABLE IF EXISTS `tb_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(255) NOT NULL COMMENT '员工姓名',
  `username` varchar(255) NOT NULL COMMENT '员工工号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `state` varchar(255) DEFAULT NULL COMMENT '在职状态',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `hiredate` datetime DEFAULT NULL COMMENT '入职时间',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `marriage` varchar(255) DEFAULT NULL COMMENT '婚姻状态：单身，已婚，离异，丧偶',
  `national` varchar(255) DEFAULT NULL COMMENT '国籍',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `education` varchar(255) DEFAULT NULL COMMENT '学历',
  `degree` varchar(255) DEFAULT NULL COMMENT '学位',
  `graduation_school` varchar(255) DEFAULT NULL COMMENT '毕业院校',
  `graduation_date` datetime DEFAULT NULL COMMENT '毕业时间',
  `job_id` int(11) NOT NULL COMMENT '职位ID',
  `department_id` int(11) NOT NULL COMMENT '部门ID',
  `organization_id` int(11) NOT NULL COMMENT '组织ID',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `political_visage` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `id_card` (`id_card`) USING BTREE,
  KEY `job_id` (`job_id`),
  KEY `department_id` (`department_id`),
  KEY `organization_id` (`organization_id`),
  CONSTRAINT `tb_employee_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `tb_job` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_employee_ibfk_3` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_employee_ibfk_4` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee`
--

LOCK TABLES `tb_employee` WRITE;
/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employeestate`
--

DROP TABLE IF EXISTS `tb_employeestate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_employeestate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `state` varchar(255) NOT NULL COMMENT '员工状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employeestate`
--

LOCK TABLES `tb_employeestate` WRITE;
/*!40000 ALTER TABLE `tb_employeestate` DISABLE KEYS */;
INSERT INTO `tb_employeestate` VALUES (1,'在职'),(2,'离职'),(3,'返聘'),(4,'退休'),(5,'留职查看'),(6,'停薪留职'),(7,'试用期'),(8,'试用延长期');
/*!40000 ALTER TABLE `tb_employeestate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_icon`
--

DROP TABLE IF EXISTS `tb_icon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_icon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_icon`
--

LOCK TABLES `tb_icon` WRITE;
/*!40000 ALTER TABLE `tb_icon` DISABLE KEYS */;
INSERT INTO `tb_icon` VALUES (1,'el-icon-s-tools'),(2,'el-icon-s-home'),(3,'el-icon-s-claim'),(4,'el-icon-s-platform'),(5,'el-icon-s-order'),(6,'el-icon-s-promotion'),(7,'el-icon-s-flag'),(8,'el-icon-s-data'),(9,'el-icon-menu'),(11,'el-icon-s-help'),(12,'el-icon-user-solid'),(13,'el-icon-s-custom'),(14,'el-icon-s-goods');
/*!40000 ALTER TABLE `tb_icon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_job`
--

DROP TABLE IF EXISTS `tb_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '职位名称',
  `code` varchar(255) DEFAULT NULL COMMENT '职位编码',
  `level` int(11) NOT NULL COMMENT '职位级别，从1级到19级，10级及以上为管理人员或者技术专家',
  `department_id` int(11) NOT NULL COMMENT '部门ID',
  `organization_id` int(11) NOT NULL COMMENT '组织ID',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE,
  KEY `department_id` (`department_id`),
  KEY `organization_id` (`organization_id`),
  CONSTRAINT `tb_job_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_job_ibfk_2` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job`
--

LOCK TABLES `tb_job` WRITE;
/*!40000 ALTER TABLE `tb_job` DISABLE KEYS */;
INSERT INTO `tb_job` VALUES (1,'初级开发工程师','010201',5,5,12,1,'2020-03-11 13:29:00','2020-03-11 14:34:55'),(3,'中级开发工程师','010202',7,5,12,1,'2020-03-11 14:49:29','2020-03-11 14:49:29'),(5,'高级开发工程师','010203',9,5,12,1,'2020-03-11 15:15:00','2020-03-11 15:15:00'),(7,'初级开发工程师','110201',5,14,10,1,'2020-03-11 16:58:15','2020-03-11 16:58:15'),(8,'中级开发工程师','310202',7,19,13,1,'2020-03-11 17:01:25','2020-03-11 17:01:25'),(9,'初级运维工程师','010101',5,4,12,1,'2020-03-11 17:02:53','2020-03-11 17:02:53');
/*!40000 ALTER TABLE `tb_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_leavetype`
--

DROP TABLE IF EXISTS `tb_leavetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_leavetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` varchar(255) NOT NULL COMMENT '请假类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_leavetype`
--

LOCK TABLES `tb_leavetype` WRITE;
/*!40000 ALTER TABLE `tb_leavetype` DISABLE KEYS */;
INSERT INTO `tb_leavetype` VALUES (1,'调休假'),(2,'年假'),(3,'病假'),(4,'事假'),(5,'婚假'),(6,'产假'),(7,'授乳假'),(8,'丧假'),(9,'工伤假'),(10,'外出办公'),(11,'陪产假'),(12,'公假'),(13,'产检假');
/*!40000 ALTER TABLE `tb_leavetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_organization`
--

DROP TABLE IF EXISTS `tb_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(255) NOT NULL COMMENT '组织名称',
  `code` varchar(255) DEFAULT NULL COMMENT '组织代码',
  `address` varchar(255) DEFAULT NULL COMMENT '组织地址',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法人代表',
  `phone` varchar(255) DEFAULT NULL COMMENT '组织电话',
  `mail` varchar(255) DEFAULT NULL COMMENT '组织邮箱',
  `status` int(11) DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_organization`
--

LOCK TABLES `tb_organization` WRITE;
/*!40000 ALTER TABLE `tb_organization` DISABLE KEYS */;
INSERT INTO `tb_organization` VALUES (10,0,'金石集团','1500000MA5U5MLK89','重庆市沙坪坝区','陈林','15677778888','15677778888@qq.com',1,'2020-03-07 20:44:29','2020-03-07 21:01:33'),(12,10,'金石科技有限公司','1500000MA5U5MLK88','重庆市渝北区','林凡','13566667777','13566667777@qq.com',1,'2020-03-07 23:05:32','2020-03-07 23:05:32'),(13,12,'金石通讯设备有限公司','1500000MA5U5MLK77','重庆市渝中区','朱俊','13455556666','13455556666@qq.com',1,'2020-03-08 21:10:55','2020-03-08 21:26:03');
/*!40000 ALTER TABLE `tb_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_permission`
--

DROP TABLE IF EXISTS `tb_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `parent_id` int(11) NOT NULL COMMENT '父权限ID',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `css` varchar(255) DEFAULT NULL COMMENT 'CSS样式',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `type` int(11) DEFAULT NULL COMMENT '权限类型 0为目录 1为菜单 2为按钮',
  `permission` varchar(255) DEFAULT NULL COMMENT '具体权限',
  `sort` int(11) NOT NULL DEFAULT '999' COMMENT '排序值',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_permission`
--

LOCK TABLES `tb_permission` WRITE;
/*!40000 ALTER TABLE `tb_permission` DISABLE KEYS */;
INSERT INTO `tb_permission` VALUES (1,0,'系统管理','el-icon-s-tools','',0,'',1,1,'2020-01-31 10:02:02','2020-01-31 10:02:02'),(2,1,'用户管理','el-icon-s-custom','user',1,'user:list',1,1,'2020-01-31 10:02:02','2020-01-31 10:02:02'),(3,1,'角色管理','el-icon-s-claim','role',1,'role:list',2,1,'2020-01-31 10:02:02','2020-01-31 10:02:02'),(4,1,'权限管理','el-icon-s-flag','permission',1,'permission:list',3,1,'2020-01-31 10:02:02','2020-01-31 10:02:02'),(5,2,'用户新增',NULL,'user',2,'user:add',1,1,'2020-02-27 15:37:09','2020-02-27 15:37:09'),(6,2,'用户修改',NULL,'user',2,'user:update',2,1,'2020-02-27 15:37:09','2020-02-27 15:37:09'),(7,2,'用户删除',NULL,'user',2,'user:delete',3,1,'2020-02-27 15:37:09','2020-02-27 15:37:09'),(14,1,'图标管理','el-icon-menu','icon',1,'system:icon',999,1,'2020-03-01 12:32:38','2020-03-01 12:32:38'),(15,3,'角色新增','','role',2,'role:add',999,1,'2020-03-05 15:21:45','2020-03-05 15:21:45'),(16,3,'角色修改','','role',2,'role:update',999,1,'2020-03-05 15:22:34','2020-03-05 15:22:34'),(17,3,'角色删除','','role',2,'role:delete',999,1,'2020-03-05 15:22:52','2020-03-05 15:22:52'),(18,4,'权限新增','','permission',2,'permission:add',999,1,'2020-03-05 15:23:51','2020-03-05 15:23:51'),(19,4,'权限修改','','permission',2,'permission:update',999,1,'2020-03-05 15:24:14','2020-03-05 15:24:14'),(20,4,'权限删除','','permission',2,'permission:delete',999,1,'2020-03-05 15:24:34','2020-03-05 15:24:34'),(21,14,'图标新增','','icon',2,'icon:add',999,1,'2020-03-05 15:25:22','2020-03-05 15:25:22'),(22,14,'图标删除','','icon',2,'icon:delete',999,1,'2020-03-05 15:25:36','2020-03-05 15:25:36'),(23,0,'公司管理','el-icon-s-home','',0,'',999,1,'2020-03-06 10:51:31','2020-03-06 10:51:31'),(24,23,'组织管理','el-icon-s-goods','organization',1,'organization:list',999,1,'2020-03-06 10:59:20','2020-03-06 10:59:20'),(25,24,'组织新增','','organization',2,'organization:add',999,1,'2020-03-06 11:02:53','2020-03-06 11:02:53'),(26,24,'组织修改','','organization',2,'organization:update',999,1,'2020-03-06 11:05:45','2020-03-06 11:05:45'),(27,24,'组织删除','','organization',2,'organization:delete',999,1,'2020-03-06 11:06:16','2020-03-06 11:06:16'),(28,23,'部门管理','el-icon-s-help','department',1,'department:list',999,1,'2020-03-06 11:11:36','2020-03-06 11:11:36'),(29,28,'部门新增','','department',2,'department:add',999,1,'2020-03-06 11:29:01','2020-03-06 11:29:01'),(30,28,'部门修改','','department',2,'department:update',999,1,'2020-03-06 11:29:30','2020-03-06 11:29:30'),(31,28,'部门删除','','department',2,'department:delete',999,1,'2020-03-06 11:34:40','2020-03-06 11:34:40'),(32,23,'职位管理','el-icon-s-order','job',1,'job:list',999,1,'2020-03-06 14:12:52','2020-03-06 14:12:52'),(33,32,'职位新增','','job',2,'job:add',999,1,'2020-03-06 14:13:20','2020-03-06 14:13:20'),(34,32,'职位修改','','job',2,'job:update',999,1,'2020-03-06 14:14:02','2020-03-06 14:14:02'),(35,32,'职位删除','','job',2,'job:delete',999,1,'2020-03-06 14:14:19','2020-03-06 14:14:19'),(36,23,'员工状态','el-icon-s-platform','employeestate',1,'employeestate:list',999,1,'2020-03-06 14:54:16','2020-03-06 14:54:16'),(37,36,'状态新增','','employeestate',2,'employeestate:add',999,1,'2020-03-06 14:54:58','2020-03-06 14:54:58'),(38,36,'状态修改','','employeestate',2,'employeestate:update',999,1,'2020-03-06 14:55:26','2020-03-06 14:55:26'),(39,36,'状态删除','','employeestate',2,'employeestate:delete',999,1,'2020-03-06 14:55:48','2020-03-06 14:55:48'),(40,23,'员工管理','el-icon-user-solid','employee',1,'employee:list',999,1,'2020-03-06 14:56:55','2020-03-06 14:56:55'),(41,40,'员工新增','','employee',2,'employee:add',999,1,'2020-03-06 14:57:33','2020-03-06 14:57:33'),(42,40,'员工修改','','employee',2,'employee:update',999,1,'2020-03-06 14:57:53','2020-03-06 14:57:53'),(43,40,'员工删除','','employee',2,'employee:delete',999,1,'2020-03-06 14:58:12','2020-03-06 14:58:12'),(44,23,'请假类型','el-icon-s-promotion','leavetype',1,'leavetype:list',999,1,'2020-03-06 14:59:11','2020-03-06 14:59:11'),(45,44,'类型新增','','leavetype',2,'leavetype:add',999,1,'2020-03-06 14:59:47','2020-03-06 14:59:47'),(46,44,'类型修改','','leavetype',2,'leavetype:update',999,1,'2020-03-06 15:00:11','2020-03-06 15:00:11'),(47,44,'类型删除','','leavetype',2,'leavetype:delete',999,1,'2020-03-06 15:00:35','2020-03-06 15:29:47');
/*!40000 ALTER TABLE `tb_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,'ROLE_ADMIN','管理员',1,'2020-01-22 11:57:11','2020-01-22 11:57:11'),(2,'ROLE_USER','普通用户',1,'2020-02-02 23:17:11','2020-03-04 13:28:30'),(6,'ROLE_GUEST','游客',1,'2020-03-05 15:40:49','2020-03-05 15:40:49');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_permission`
--

DROP TABLE IF EXISTS `tb_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_permission_id` (`role_id`,`permission_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `tb_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_permission`
--

LOCK TABLES `tb_role_permission` WRITE;
/*!40000 ALTER TABLE `tb_role_permission` DISABLE KEYS */;
INSERT INTO `tb_role_permission` VALUES (61,1,1,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(62,1,2,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(63,1,5,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(64,1,6,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(65,1,7,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(66,1,3,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(67,1,15,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(68,1,16,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(69,1,17,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(70,1,4,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(71,1,18,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(72,1,19,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(73,1,20,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(74,1,14,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(75,1,21,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(76,1,22,'2020-03-06 10:38:50','2020-03-06 10:38:50'),(77,6,14,'2020-03-06 10:39:53','2020-03-06 10:39:53'),(78,6,21,'2020-03-06 10:39:53','2020-03-06 10:39:53'),(79,6,22,'2020-03-06 10:39:53','2020-03-06 10:39:53'),(80,6,1,'2020-03-06 10:39:53','2020-03-06 10:39:53'),(81,2,3,'2020-03-06 10:42:34','2020-03-06 10:42:34'),(82,2,15,'2020-03-06 10:42:34','2020-03-06 10:42:34'),(83,2,16,'2020-03-06 10:42:34','2020-03-06 10:42:34'),(84,2,17,'2020-03-06 10:42:34','2020-03-06 10:42:34'),(85,2,1,'2020-03-06 10:42:34','2020-03-06 10:42:34');
/*!40000 ALTER TABLE `tb_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '员工工号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0为禁用，1为启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'cq00001','$2a$10$LFLwbPI2rSunbIve/Adv7.dDaEyK34zFAJ4nzwTGQzPfazSRwuNkO',1,'2020-01-22 11:55:42','2020-02-02 23:42:38'),(2,'cq00002','$2a$10$SpgUwrsARZBpKF7SDacFdeXeAoxR//J9Kd2A6HAUuP8kpl5erdw26',1,'2020-01-23 14:26:43','2020-01-23 14:26:43'),(4,'cq00003','$2a$10$zEoNRD3hIxWsVsSCLSDt7eM.ieB8AATuDxdOlUSxOsaCfsUtOjhDm',0,'2020-01-23 15:28:37','2020-02-17 16:08:19'),(10,'cq00004','$2a$10$f5Gb1pdQAAqZphQoUfHO8.c/KiOGv4r3ake9mCu4o2mAYjCtooIeu',1,'2020-01-31 17:40:06','2020-02-17 16:08:21'),(23,'cq00005','$2a$10$/gzur77guQvd4TiXnAkuEuylB/UzwAIy/ceADf9W5jZpN4i/64rDK',0,'2020-02-03 15:47:07','2020-02-18 14:54:28'),(24,'cq00006','$2a$10$l7VrAcExgAYdYm6ri.X7iuWEmU8amo8gWl.TDd4K4S9qhzVyTdsyS',1,'2020-02-03 15:47:51','2020-02-03 15:47:51'),(25,'cq00007','$2a$10$f0TaXJcxAIkw74hu40Db2OlL3u4WmADMyUeBRhGXSC5gIfk./ICu6',1,'2020-02-03 15:53:26','2020-02-03 15:53:26'),(26,'cq00008','$2a$10$3iROxWsAIkO2LT/70Zdtaeo9tCf.3NKAqy8MDTsGcvFYtlkoN/QJG',1,'2020-02-03 15:54:42','2020-02-13 14:52:25'),(27,'cq00009','$2a$10$aTmRUwBo54/Mko5LaqzcnuoUm4638.LHWnccdGBXoKtq6BD6Vk4Tm',1,'2020-02-14 14:55:49','2020-02-14 14:55:49'),(28,'cq00010','$2a$10$mWLjVAvE7Zzv.wDPTgIugOUwNfyRGhrTsc0T8Nr8c7ntf/CDNC882',1,'2020-02-14 14:56:17','2020-02-14 14:56:17'),(29,'cq00011','$2a$10$Ql5zCLmuwRHpQSUqocqGdOOdOcd5hEVn9C4TYaBHlMh0Et0G7.Ld6',1,'2020-02-14 16:02:42','2020-02-14 16:02:42'),(30,'cq00012','$2a$10$VY3kHMctg68pnh9hN4ycY.tsC/D6IhjN4XehewnchbvIx7yUV2DEG',1,'2020-02-17 13:48:22','2020-02-17 13:48:22'),(31,'cq00013','$2a$10$NAYB9nxMUXjFJifVezLrnOLkTN9Q6QGwQzbBddYR0L4WWJHbjrXR2',1,'2020-02-18 14:58:31','2020-02-18 14:58:31');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role`
--

DROP TABLE IF EXISTS `tb_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_id` (`user_id`,`role_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
INSERT INTO `tb_user_role` VALUES (1,1,1,'2020-01-22 11:58:00','2020-01-22 11:58:00'),(2,2,2,'2020-02-02 23:50:56','2020-02-02 23:50:56'),(3,4,2,'2020-02-02 23:50:56','2020-02-02 23:50:56'),(4,10,2,'2020-02-02 23:50:56','2020-02-02 23:50:56'),(8,23,2,'2020-02-03 15:47:07','2020-02-03 15:47:07'),(9,24,1,'2020-02-03 15:47:51','2020-02-03 16:22:15'),(10,25,2,'2020-02-03 15:53:26','2020-02-03 16:35:52'),(11,26,2,'2020-02-03 15:54:42','2020-02-03 16:22:57'),(12,27,2,'2020-02-14 14:55:49','2020-02-14 14:55:49'),(13,28,2,'2020-02-14 14:56:17','2020-02-14 14:56:17'),(14,29,2,'2020-02-14 16:02:42','2020-02-14 16:02:42'),(15,30,1,'2020-02-17 13:48:22','2020-02-18 14:59:22'),(16,31,1,'2020-02-18 14:58:31','2020-02-18 14:58:31');
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-11 17:18:11
