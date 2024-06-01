/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : manager

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 31/05/2024 23:45:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for electronicfence
-- ----------------------------
DROP TABLE IF EXISTS `electronicfence`;
CREATE TABLE `electronicfence`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `rail_id` int(0) DEFAULT NULL,
  `rail_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rail_num` int(0) DEFAULT NULL,
  `rail_lon` decimal(10, 6) DEFAULT NULL,
  `rail_lat` decimal(10, 6) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `job_caption` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `finished` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of electronicfence
-- ----------------------------
INSERT INTO `electronicfence` VALUES (1, 1, '轨道A段', 1001, 116.390743, 39.909230, '2024-05-31', '巡检任务A', '13912345678', 0);
INSERT INTO `electronicfence` VALUES (2, 2, '轨道B段', 1002, 116.392345, 39.910876, '2024-05-31', '巡检任务B', '13812345679', 0);
INSERT INTO `electronicfence` VALUES (3, 3, '轨道C段', 1003, 116.395678, 39.912400, '2024-05-31', '巡检任务C', '13712345678', 1);

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rail_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (2, '李四', '13900139000', '工程部', '2024-05-31');
INSERT INTO `employees` VALUES (3, '王五', '13700137000', '安全部', '2024-05-31');
INSERT INTO `employees` VALUES (4, '赵六', '13600136000', '财务部', '2024-05-31');

-- ----------------------------
-- Table structure for locationinfo
-- ----------------------------
DROP TABLE IF EXISTS `locationinfo`;
CREATE TABLE `locationinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `hat_id` int(0) DEFAULT NULL,
  `employee_id` int(0) DEFAULT NULL,
  `lon` decimal(10, 6) DEFAULT NULL,
  `lat` decimal(10, 6) DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of locationinfo
-- ----------------------------
INSERT INTO `locationinfo` VALUES (1, 1, 2, 116.389123, 39.908765, '北京某工地', '2024-05-31');
INSERT INTO `locationinfo` VALUES (2, 2, 3, 116.391234, 39.909654, '仓库区', '2024-05-31');
INSERT INTO `locationinfo` VALUES (3, 3, 4, 116.393567, 39.911289, '材料堆放区', '2024-05-31');

-- ----------------------------
-- Table structure for safetyhelmet
-- ----------------------------
DROP TABLE IF EXISTS `safetyhelmet`;
CREATE TABLE `safetyhelmet`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `employee_id` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of safetyhelmet
-- ----------------------------
INSERT INTO `safetyhelmet` VALUES (2, 'HH002', '安全帽B型', '2024-05-31 21:41:49', '2024-05-31 21:41:49', 2);
INSERT INTO `safetyhelmet` VALUES (3, 'HH003', '安全帽C型', '2024-05-31 21:41:49', '2024-05-31 21:41:49', 3);
INSERT INTO `safetyhelmet` VALUES (5, '1234', '111', '2024-05-31 23:38:10', '2024-05-31 23:38:10', 2);

-- ----------------------------
-- Table structure for warninginfo
-- ----------------------------
DROP TABLE IF EXISTS `warninginfo`;
CREATE TABLE `warninginfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `warning_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `employee_id` int(0) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `result` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warninginfo
-- ----------------------------
INSERT INTO `warninginfo` VALUES (1, '未戴安全帽警告', '2024-05-31', 3, '工地入口', 1);
INSERT INTO `warninginfo` VALUES (2, '超速警告', '2024-05-31', 5, '工地主干道', 0);
INSERT INTO `warninginfo` VALUES (3, '未穿防护服警告', '2024-05-31', 4, '施工现场', 1);

SET FOREIGN_KEY_CHECKS = 1;
