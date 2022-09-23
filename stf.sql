/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : stf

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 23/09/2022 16:33:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子标题',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子作者',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子内容',
  `slug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子所属栏目',
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子标签',
  `created` datetime(0) NOT NULL COMMENT '帖子发表时间',
  `open_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '帖子关闭状态（0为关闭，1为打开）',
  `verify_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '2' COMMENT '帖子审核状态（0为未通过，1为通过，2为未审核）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '测试1', '测试1', '<p>测试1</p>', '测试1', '测试1', '2022-09-19 23:14:08', '1', '0');
INSERT INTO `post` VALUES (2, 'test', 'test', 'test', 'test', 'test', '2022-09-20 00:49:44', '0', '0');
INSERT INTO `post` VALUES (6, '1', '1', '<p>1</p>', '1', '1', '2022-09-23 23:44:35', '1', '1');
INSERT INTO `post` VALUES (7, '1', '1', '<p>1</p>', '1', '1', '2022-09-23 23:44:43', NULL, '2');
INSERT INTO `post` VALUES (8, '2', '2', '<p>2</p>', '2', '2', '2022-09-23 23:44:53', '1', '1');
INSERT INTO `post` VALUES (11, 'ergsdrg', 'dfgdfg', '<p>dfgdfg</p>', 'gfdf', 'ertgre', '2022-09-24 00:22:29', '1', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
