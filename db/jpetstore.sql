/*
 Navicat Premium Data Transfer

 Source Server         : Terminal
 Source Server Type    : MySQL
 Source Server Version : 100135
 Source Host           : localhost:3306
 Source Schema         : jpetstore

 Target Server Type    : MySQL
 Target Server Version : 100135
 File Encoding         : 65001

 Date: 19/12/2018 22:32:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `firstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr2` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('a', 'a', 'a', 'a', NULL, 'a', 'a', 'aa', 'a', 'a', 'a', 'a');
INSERT INTO `account` VALUES ('ACID', 'acid@yourdomain.com', 'ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');
INSERT INTO `account` VALUES ('j2ee', 'yourname@yourdomain.com', 'ABC', 'XYX', NULL, '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');
INSERT INTO `account` VALUES ('sun', '', '', '', NULL, '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for bannerdata
-- ----------------------------
DROP TABLE IF EXISTS `bannerdata`;
CREATE TABLE `bannerdata`  (
  `favcategory` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bannername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`favcategory`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bannerdata
-- ----------------------------
INSERT INTO `bannerdata` VALUES ('BIRDS', '<image src=\"/jpetstore/static/images/banner_birds.gif\">');
INSERT INTO `bannerdata` VALUES ('CATS', '<image src=\"/jpetstore/static/images/banner_cats.gif\">');
INSERT INTO `bannerdata` VALUES ('DOGS', '<image src=\"/jpetstore/static/images/banner_dogs.gif\">');
INSERT INTO `bannerdata` VALUES ('FISH', '<image src=\"/jpetstore/static/images/banner_fish.gif\">');
INSERT INTO `bannerdata` VALUES ('REPTILES', '<image src=\"/jpetstore/static/images/banner_reptiles.gif\">');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `catid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`catid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('BIRDS', 'Birds', '<image src=\"/jpetstore/static/images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>');
INSERT INTO `category` VALUES ('CATS', 'Cats', '<image src=\"/jpetstore/static/images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>');
INSERT INTO `category` VALUES ('DOGS', 'Dogs', '<image src=\"/jpetstore/static/images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>');
INSERT INTO `category` VALUES ('FISH', 'Fish', '<image src=\"/jpetstore/static/images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>');
INSERT INTO `category` VALUES ('REPTILES', 'Reptiles', '<image src=\"/jpetstore/static/images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('EST-1', 10000);
INSERT INTO `inventory` VALUES ('EST-10', 10000);
INSERT INTO `inventory` VALUES ('EST-11', 10000);
INSERT INTO `inventory` VALUES ('EST-12', 10000);
INSERT INTO `inventory` VALUES ('EST-13', 10000);
INSERT INTO `inventory` VALUES ('EST-14', 10000);
INSERT INTO `inventory` VALUES ('EST-15', 10000);
INSERT INTO `inventory` VALUES ('EST-16', 10000);
INSERT INTO `inventory` VALUES ('EST-17', 10000);
INSERT INTO `inventory` VALUES ('EST-18', 10000);
INSERT INTO `inventory` VALUES ('EST-19', 10000);
INSERT INTO `inventory` VALUES ('EST-2', 10000);
INSERT INTO `inventory` VALUES ('EST-20', 10000);
INSERT INTO `inventory` VALUES ('EST-21', 10000);
INSERT INTO `inventory` VALUES ('EST-22', 10000);
INSERT INTO `inventory` VALUES ('EST-23', 10000);
INSERT INTO `inventory` VALUES ('EST-24', 10000);
INSERT INTO `inventory` VALUES ('EST-25', 10000);
INSERT INTO `inventory` VALUES ('EST-26', 10000);
INSERT INTO `inventory` VALUES ('EST-27', 10000);
INSERT INTO `inventory` VALUES ('EST-28', 10000);
INSERT INTO `inventory` VALUES ('EST-3', 10000);
INSERT INTO `inventory` VALUES ('EST-4', 10000);
INSERT INTO `inventory` VALUES ('EST-5', 10000);
INSERT INTO `inventory` VALUES ('EST-6', 10000);
INSERT INTO `inventory` VALUES ('EST-7', 10000);
INSERT INTO `inventory` VALUES ('EST-8', 10000);
INSERT INTO `inventory` VALUES ('EST-9', 10000);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `listprice` decimal(10, 2) NULL DEFAULT NULL,
  `unitcost` decimal(10, 2) NULL DEFAULT NULL,
  `supplier` int(11) NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr3` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr4` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr5` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `fk_item_2`(`supplier`) USING BTREE,
  INDEX `itemProd`(`productid`) USING BTREE,
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('EST-1', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Large', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-10', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotted Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-11', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Venomless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-12', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Rattleless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-13', 'RP-LI-02', 18.50, 12.00, 1, 'P', 'Green Adult', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-14', 'FL-DSH-01', 58.50, 12.00, 1, 'P', 'Tailless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-15', 'FL-DSH-01', 23.50, 12.00, 1, 'P', 'With tail', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-16', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-17', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-18', 'AV-CB-01', 193.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-19', 'AV-SB-02', 15.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-2', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Small', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-20', 'FI-FW-02', 5.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-21', 'FI-FW-02', 5.29, 1.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-22', 'K9-RT-02', 135.50, 100.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-23', 'K9-RT-02', 145.49, 100.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-24', 'K9-RT-02', 255.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-25', 'K9-RT-02', 325.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-26', 'K9-CW-01', 125.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-27', 'K9-CW-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-28', 'K9-RT-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-3', 'FI-SW-02', 18.50, 12.00, 1, 'P', 'Toothless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-4', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotted', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-5', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-6', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Male Adult', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-7', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Female Puppy', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-8', 'K9-PO-02', 18.50, 12.00, 1, 'P', 'Male Puppy', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-9', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotless Male Puppy', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for lineitem
-- ----------------------------
DROP TABLE IF EXISTS `lineitem`;
CREATE TABLE `lineitem`  (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`orderid`, `linenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int(11) NOT NULL,
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipaddr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shipcity` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipstate` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipzip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipcountry` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billaddr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billaddr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `billcity` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billstate` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billzip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billcountry` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courier` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `totalprice` decimal(10, 2) NOT NULL,
  `billtofirstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billtolastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shiptofirstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shiptolastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creditcard` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `exprdate` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardtype` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `locale` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orderstatus
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus`  (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`orderid`, `linenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------
INSERT INTO `orderstatus` VALUES (1003, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1004, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1005, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1006, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1007, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1008, 0, '1901-03-05', '1');
INSERT INTO `orderstatus` VALUES (1009, 0, '1901-03-05', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`productid`) USING BTREE,
  INDEX `productCat`(`category`) USING BTREE,
  INDEX `productName`(`name`) USING BTREE,
  CONSTRAINT `fk_product_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('AV-CB-01', 'BIRDS', 'Amazon Parrot', '<img src=\"/jpetstore/static/images/bird4.gif\">Great companion for up to 75 years');
INSERT INTO `product` VALUES ('AV-SB-02', 'BIRDS', 'Finch', '<img src=\"/jpetstore/static/images/bird1.gif\">Great stress reliever');
INSERT INTO `product` VALUES ('FI-FW-01', 'FISH', 'Koi', '<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan');
INSERT INTO `product` VALUES ('FI-FW-02', 'FISH', 'Goldfish', '<img src=\"/jpetstore/static/images/fish2.gif\">Fresh Water fish from China');
INSERT INTO `product` VALUES ('FI-SW-01', 'FISH', 'Angelfish', '<img src=\"/jpetstore/static/images/fish1.jpg\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FI-SW-02', 'FISH', 'Tiger Shark', '<img src=\"/jpetstore/static/images/fish4.gif\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FL-DLH-02', 'CATS', 'Persian', '<img src=\"/jpetstore/static/images/cat1.gif\">Friendly house cat, doubles as a princess');
INSERT INTO `product` VALUES ('FL-DSH-01', 'CATS', 'Manx', '<img src=\"/jpetstore/static/images/cat3.gif\">Great for reducing mouse populations');
INSERT INTO `product` VALUES ('K9-BD-01', 'DOGS', 'Bulldog', '<img src=\"/jpetstore/static/images/dog2.gif\">Friendly dog from England');
INSERT INTO `product` VALUES ('K9-CW-01', 'DOGS', 'Chihuahua', '<img src=\"/jpetstore/static/images/dog4.gif\">Great companion dog');
INSERT INTO `product` VALUES ('K9-DL-01', 'DOGS', 'Dalmation', '<img src=\"/jpetstore/static/images/dog5.gif\">Great dog for a Fire Station');
INSERT INTO `product` VALUES ('K9-PO-02', 'DOGS', 'Poodle', '<img src=\"/jpetstore/static/images/dog6.gif\">Cute dog from France');
INSERT INTO `product` VALUES ('K9-RT-01', 'DOGS', 'Golden Retriever', '<img src=\"/jpetstore/static/images/dog1.gif\">Great family dog');
INSERT INTO `product` VALUES ('K9-RT-02', 'DOGS', 'Labrador Retriever', '<img src=\"/jpetstore/static/images/dog5.gif\">Great hunting dog');
INSERT INTO `product` VALUES ('RP-LI-02', 'REPTILES', 'Iguana', '<img src=\"/jpetstore/static/images/lizard2.gif\">Friendly green friend');
INSERT INTO `product` VALUES ('RP-SN-01', 'REPTILES', 'Rattlesnake', '<img src=\"/jpetstore/static/images/lizard3.gif\">Doubles as a watch dog');

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile`  (
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `langpref` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `favcategory` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mylistopt` tinyint(1) NULL DEFAULT NULL,
  `banneropt` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('a', 'japanese', 'DOGS', NULL, NULL);
INSERT INTO `profile` VALUES ('ACID', 'english', 'CATS', 1, 1);
INSERT INTO `profile` VALUES ('j2ee', 'english', 'FISH', 1, 1);

-- ----------------------------
-- Table structure for request_list
-- ----------------------------
DROP TABLE IF EXISTS `request_list`;
CREATE TABLE `request_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `uri` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `query` varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_ajax` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `timestamp` bigint(20) NULL DEFAULT NULL,
  `refresh_count` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sid` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `request_list_f1`(`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 180 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of request_list
-- ----------------------------
INSERT INTO `request_list` VALUES (1, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'FE2023924363E901F54852CEC5670D84');
INSERT INTO `request_list` VALUES (2, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `request_list` VALUES (3, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `request_list` VALUES (4, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `request_list` VALUES (5, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4', 'workingItemId=EST-4', NULL, NULL, NULL, 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `request_list` VALUES (6, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, '8BF98145529429943F7E0849E0587067');
INSERT INTO `request_list` VALUES (7, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (8, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (9, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (10, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4', 'workingItemId=EST-4', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (11, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (12, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=REPTILES', 'categoryId=REPTILES', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (13, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=RP-LI-02', 'productId=RP-LI-02', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (14, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-13', 'workingItemId=EST-13', NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (15, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/updateCartQuantities', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (16, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (17, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (18, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (19, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (20, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (21, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '0A002441DC2A0B1232843C1F572CE2F5');
INSERT INTO `request_list` VALUES (22, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, '70F6A9BC73555F403DDE7997DE43C1B2');
INSERT INTO `request_list` VALUES (23, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'D5BA95AE4521CE53051808E013B24F1E');
INSERT INTO `request_list` VALUES (24, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/css/jpetstore.css', NULL, NULL, NULL, NULL, 'D5BA95AE4521CE53051808E013B24F1E');
INSERT INTO `request_list` VALUES (25, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (26, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/cart.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (27, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/logo-topbar.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (28, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/separator.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (29, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_fish.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (30, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_dogs.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (31, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_reptiles.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (32, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_cats.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (33, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/splash.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (34, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/reptiles_icon.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (35, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/fish_icon.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (36, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/cats_icon.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (37, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_birds.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (38, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/birds_icon.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (39, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/dogs_icon.gif', NULL, NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (40, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `request_list` VALUES (41, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, 'BF3EC5A90527C19A1411F03DF913B285');
INSERT INTO `request_list` VALUES (42, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewItem?itemId=EST-4', 'itemId=EST-4', NULL, NULL, NULL, '398A895ADD9C1EF062DE018DA6F7E0E8');
INSERT INTO `request_list` VALUES (43, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/fish3.gif', NULL, NULL, NULL, NULL, '398A895ADD9C1EF062DE018DA6F7E0E8');
INSERT INTO `request_list` VALUES (44, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, 'D041463AF1CDA06534DFA0350AEF52A4');
INSERT INTO `request_list` VALUES (45, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS', 'keyword=BIRDS', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (46, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS', 'keyword=BIRDS', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (47, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS', 'keyword=BIRDS', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (48, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=CAT', 'keyword=CAT', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (49, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=cats', 'keyword=cats', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (50, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (51, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (52, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=fish', 'keyword=fish', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (53, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=FISH', 'keyword=FISH', NULL, NULL, NULL, '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `request_list` VALUES (54, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'AAEE521A81CD19AA4D946CEC1858E7E1');
INSERT INTO `request_list` VALUES (55, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, 'AAEE521A81CD19AA4D946CEC1858E7E1');
INSERT INTO `request_list` VALUES (56, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=', 'keyword=', NULL, NULL, NULL, 'AAEE521A81CD19AA4D946CEC1858E7E1');
INSERT INTO `request_list` VALUES (57, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=cat', 'keyword=cat', NULL, NULL, NULL, 'AAEE521A81CD19AA4D946CEC1858E7E1');
INSERT INTO `request_list` VALUES (58, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'E2453E5BA831C4D820D7700DEC10C609');
INSERT INTO `request_list` VALUES (59, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'EA1C18F4676CF4FAC97E17585710D754');
INSERT INTO `request_list` VALUES (60, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'F48C9E59CE69BFE4BC722DBC3060E607');
INSERT INTO `request_list` VALUES (61, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, 'F48C9E59CE69BFE4BC722DBC3060E607');
INSERT INTO `request_list` VALUES (62, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=CAT', 'keyword=CAT', NULL, NULL, NULL, 'F48C9E59CE69BFE4BC722DBC3060E607');
INSERT INTO `request_list` VALUES (63, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=cat', 'keyword=cat', NULL, NULL, NULL, 'F48C9E59CE69BFE4BC722DBC3060E607');
INSERT INTO `request_list` VALUES (64, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', 'keyword=Birds', NULL, NULL, NULL, '8F18CC05534C598CADB522A174B2BC8F');
INSERT INTO `request_list` VALUES (65, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi', 'keyword=Koi', NULL, NULL, NULL, 'C376A9ED08FCBC7235C1B080B20D4F5B');
INSERT INTO `request_list` VALUES (66, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, 'F4365DF06FBAB9F701D3DA541FCCC602');
INSERT INTO `request_list` VALUES (67, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, 'F4365DF06FBAB9F701D3DA541FCCC602');
INSERT INTO `request_list` VALUES (68, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/newAccountForm', NULL, NULL, NULL, NULL, '720057374821827AE310F67FBFC506F3');
INSERT INTO `request_list` VALUES (69, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '720057374821827AE310F67FBFC506F3');
INSERT INTO `request_list` VALUES (70, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '871D1A1B398EB9EC923FC8B037063552');
INSERT INTO `request_list` VALUES (71, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, 'B7AED6E8FAFD7BBB6AA71838CC3378B7');
INSERT INTO `request_list` VALUES (72, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi', 'keyword=Koi', NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (73, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (74, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (75, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (76, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (77, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/editAccountForm', NULL, NULL, NULL, NULL, '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `request_list` VALUES (78, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/listOrders', NULL, NULL, NULL, NULL, '45B9D74F3670DD16EA1017B59BAD6E9D');
INSERT INTO `request_list` VALUES (79, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/listOrders', NULL, NULL, NULL, NULL, '45B9D74F3670DD16EA1017B59BAD6E9D');
INSERT INTO `request_list` VALUES (80, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, '83D270BD87B1BE8530DDBDED5707CEFF');
INSERT INTO `request_list` VALUES (81, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (82, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (83, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (84, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (85, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (86, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (87, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (88, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (89, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (90, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/editAccountForm', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (91, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/listOrders', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (92, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (93, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (94, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (95, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4', 'workingItemId=EST-4', NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (96, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `request_list` VALUES (97, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, '2516714A625EA9B98838C9E46E7F1808');
INSERT INTO `request_list` VALUES (98, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, '2516714A625EA9B98838C9E46E7F1808');
INSERT INTO `request_list` VALUES (99, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, 'B80867934793602EDA6470B3CD6A14A7');
INSERT INTO `request_list` VALUES (100, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, 'B80867934793602EDA6470B3CD6A14A7');
INSERT INTO `request_list` VALUES (101, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, 'B80867934793602EDA6470B3CD6A14A7');
INSERT INTO `request_list` VALUES (102, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'B2E18157B4ACB7D4E6B3E02E35EF455D');
INSERT INTO `request_list` VALUES (103, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (104, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (105, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (106, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4', 'workingItemId=EST-4', NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (107, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (108, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (109, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (110, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (111, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (112, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (113, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/viewCart', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (114, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (115, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `request_list` VALUES (116, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, '4899C7C3D8EF9701DF32611E981ED13A');
INSERT INTO `request_list` VALUES (117, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `request_list` VALUES (118, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `request_list` VALUES (119, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `request_list` VALUES (120, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `request_list` VALUES (121, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `request_list` VALUES (122, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, '982A99241361C5D5D05EBB5B263E6087');
INSERT INTO `request_list` VALUES (123, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (124, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (125, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (126, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (127, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (128, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (129, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (130, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (131, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (132, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (133, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/editAccountForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (134, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/listOrders', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (135, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (136, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', 'productId=FI-FW-01', NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (137, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4', 'workingItemId=EST-4', NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (138, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (139, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (140, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (141, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (142, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (143, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/viewCart', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (144, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (145, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/editAccountForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (146, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/viewCart', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (147, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `request_list` VALUES (148, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, 'FF1D0AC7A577530FE7A0D4773F518F1C');
INSERT INTO `request_list` VALUES (149, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, 'FF1D0AC7A577530FE7A0D4773F518F1C');
INSERT INTO `request_list` VALUES (150, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder?confirmed=true', 'confirmed=true', NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (151, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrder', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (152, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (153, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/css/jpetstore.css', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (154, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/logo-topbar.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (155, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_fish.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (156, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/separator.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (157, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/cart.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (158, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_dogs.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (159, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_reptiles.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (160, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_cats.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (161, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/static/images/sm_birds.gif', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (162, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (163, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (164, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `request_list` VALUES (165, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '90D6FFA3C23AAAE7C75369B3A2F99E37');
INSERT INTO `request_list` VALUES (166, '127.0.0.1', 'localhost:8080/jpetstore/', NULL, NULL, NULL, NULL, 'D4A27EBC2B92600CDD10C10F1E948F47');
INSERT INTO `request_list` VALUES (167, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=REPTILES', 'categoryId=REPTILES', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (168, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=RP-LI-02', 'productId=RP-LI-02', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (169, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-13', 'workingItemId=EST-13', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (170, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=CATS', 'categoryId=CATS', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (171, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewProduct?productId=FL-DLH-02', 'productId=FL-DLH-02', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (172, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-16', 'workingItemId=EST-16', NULL, NULL, NULL, '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `request_list` VALUES (173, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/order/newOrderForm', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (174, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (175, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signInForm', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (176, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/verify', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (177, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/account/signIn', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (178, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/main', NULL, NULL, NULL, NULL, '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `request_list` VALUES (179, '0:0:0:0:0:0:0:1', 'localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', 'categoryId=FISH', NULL, NULL, NULL, '9EE25801F18FB9C0BC178CF58E282225');

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence`  (
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nextid` int(11) NOT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('linenum', 1000);
INSERT INTO `sequence` VALUES ('ordernum', 1010);

-- ----------------------------
-- Table structure for session_attribute
-- ----------------------------
DROP TABLE IF EXISTS `session_attribute`;
CREATE TABLE `session_attribute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `value` varchar(3000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sid` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `session_attribute_f1`(`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of session_attribute
-- ----------------------------
INSERT INTO `session_attribute` VALUES (1, 'jpetstore', 'com.nevercome.jpetstore.common.log.JPetStoreSession@7eb576c3', 'FE2023924363E901F54852CEC5670D84');
INSERT INTO `session_attribute` VALUES (2, 'jpetstore', 'com.nevercome.jpetstore.common.log.JPetStoreSession@24071406', 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `session_attribute` VALUES (3, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `session_attribute` VALUES (4, 'cart', 'com.nevercome.jpetstore.domain.model.Cart@f336496', 'A4FC18A051A35FBCCC94F89A6CBE021C');
INSERT INTO `session_attribute` VALUES (5, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 19:32:27 CST 2018, lastRequest=Wed Dec 19 19:32:27 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@2d4d76e1}', '70F6A9BC73555F403DDE7997DE43C1B2');
INSERT INTO `session_attribute` VALUES (6, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/, localhost:8080/jpetstore/static/css/jpetstore.css], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'\', start=Wed Dec 19 19:32:28 CST 2018, lastRequest=Wed Dec 19 19:32:28 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@7126063f}', 'D5BA95AE4521CE53051808E013B24F1E');
INSERT INTO `session_attribute` VALUES (7, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/static/images/cart.gif, localhost:8080/jpetstore/static/images/logo-topbar.gif, localhost:8080/jpetstore/static/images/separator.gif, localhost:8080/jpetstore/static/images/sm_fish.gif, localhost:8080/jpetstore/static/images/sm_dogs.gif, localhost:8080/jpetstore/static/images/sm_reptiles.gif, localhost:8080/jpetstore/static/images/sm_cats.gif, localhost:8080/jpetstore/static/images/splash.gif, localhost:8080/jpetstore/static/images/reptiles_icon.gif, localhost:8080/jpetstore/static/images/fish_icon.gif, localhost:8080/jpetstore/static/images/cats_icon.gif, localhost:8080/jpetstore/static/images/sm_birds.gif, localhost:8080/jpetstore/static/images/birds_icon.gif, localhost:8080/jpetstore/static/images/dogs_icon.gif, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 19:33:29 CST 2018, lastRequest=Wed Dec 19 19:33:35 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4f63d22c}', 'C99375A2B2F73F1C1CD29A062941B72A');
INSERT INTO `session_attribute` VALUES (8, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH\', start=Wed Dec 19 19:37:41 CST 2018, lastRequest=Wed Dec 19 19:37:41 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4b7b164e}', 'BF3EC5A90527C19A1411F03DF913B285');
INSERT INTO `session_attribute` VALUES (9, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', 'BF3EC5A90527C19A1411F03DF913B285');
INSERT INTO `session_attribute` VALUES (10, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/viewItem?itemId=EST-4, localhost:8080/jpetstore/static/images/fish3.gif], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01\', start=Wed Dec 19 19:40:48 CST 2018, lastRequest=Wed Dec 19 19:40:49 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@5d3030ce}', '398A895ADD9C1EF062DE018DA6F7E0E8');
INSERT INTO `session_attribute` VALUES (11, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', '398A895ADD9C1EF062DE018DA6F7E0E8');
INSERT INTO `session_attribute` VALUES (12, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/viewItem?itemId=EST-4\', start=Wed Dec 19 19:42:10 CST 2018, lastRequest=Wed Dec 19 19:42:10 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@1a865531}', 'D041463AF1CDA06534DFA0350AEF52A4');
INSERT INTO `session_attribute` VALUES (13, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS, localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS, localhost:8080/jpetstore/catalog/searchProducts?keyword=BIRDS, localhost:8080/jpetstore/catalog/searchProducts?keyword=CAT, localhost:8080/jpetstore/catalog/searchProducts?keyword=cats, localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds, localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds, localhost:8080/jpetstore/catalog/searchProducts?keyword=fish, localhost:8080/jpetstore/catalog/searchProducts?keyword=FISH], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds\', start=Wed Dec 19 19:42:32 CST 2018, lastRequest=Wed Dec 19 19:43:03 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@44471fb2}', '177CBDE453F691DC01BD0D6E6F827CED');
INSERT INTO `session_attribute` VALUES (14, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds, localhost:8080/jpetstore/catalog/searchProducts?keyword=, localhost:8080/jpetstore/catalog/searchProducts?keyword=cat], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 19:44:05 CST 2018, lastRequest=Wed Dec 19 19:44:24 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@50c7324a}', 'AAEE521A81CD19AA4D946CEC1858E7E1');
INSERT INTO `session_attribute` VALUES (15, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 19:44:01 CST 2018, lastRequest=Wed Dec 19 19:44:01 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@33331e3}', 'E2453E5BA831C4D820D7700DEC10C609');
INSERT INTO `session_attribute` VALUES (16, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 19:46:54 CST 2018, lastRequest=Wed Dec 19 19:46:54 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@7ac8c465}', 'EA1C18F4676CF4FAC97E17585710D754');
INSERT INTO `session_attribute` VALUES (17, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds, localhost:8080/jpetstore/catalog/searchProducts?keyword=CAT, localhost:8080/jpetstore/catalog/searchProducts?keyword=cat], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 19:47:19 CST 2018, lastRequest=Wed Dec 19 19:47:45 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@47f01b96}', 'F48C9E59CE69BFE4BC722DBC3060E607');
INSERT INTO `session_attribute` VALUES (18, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=cat\', start=Wed Dec 19 19:49:20 CST 2018, lastRequest=Wed Dec 19 19:49:20 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@6e641ced}', '8F18CC05534C598CADB522A174B2BC8F');
INSERT INTO `session_attribute` VALUES (19, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds\', start=Wed Dec 19 19:49:38 CST 2018, lastRequest=Wed Dec 19 19:49:38 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@372cceb3}', 'C376A9ED08FCBC7235C1B080B20D4F5B');
INSERT INTO `session_attribute` VALUES (20, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi\', start=Wed Dec 19 19:53:27 CST 2018, lastRequest=Wed Dec 19 19:53:28 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@47cf6b48}', 'F4365DF06FBAB9F701D3DA541FCCC602');
INSERT INTO `session_attribute` VALUES (21, 'code', '1C15', 'F4365DF06FBAB9F701D3DA541FCCC602');
INSERT INTO `session_attribute` VALUES (22, 'codePic', 'BufferedImage@522e796c: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', 'F4365DF06FBAB9F701D3DA541FCCC602');
INSERT INTO `session_attribute` VALUES (23, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/account/newAccountForm, localhost:8080/jpetstore/account/verify], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/signInForm\', start=Wed Dec 19 19:53:51 CST 2018, lastRequest=Wed Dec 19 19:53:52 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4565c2db}', '720057374821827AE310F67FBFC506F3');
INSERT INTO `session_attribute` VALUES (24, 'code', 'SVAK', '720057374821827AE310F67FBFC506F3');
INSERT INTO `session_attribute` VALUES (25, 'languages', '[english, japanese]', '720057374821827AE310F67FBFC506F3');
INSERT INTO `session_attribute` VALUES (26, 'category', '[FISH, DOGS, REPTILES, CATS, BIRDS]', '720057374821827AE310F67FBFC506F3');
INSERT INTO `session_attribute` VALUES (27, 'codePic', 'BufferedImage@27ad4fbb: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '720057374821827AE310F67FBFC506F3');
INSERT INTO `session_attribute` VALUES (28, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/account/newAccount?account.userId=bys&account.password=123456&repeatedPassword=123456&verifyCode=SVAK&account.firstName=&account.lastName=&account.email=&account.phone=&account.address1=&account.address2=&account.city=&account.state=&account.zip=&account.country=&account.languagePreference=english&account.favouriteCategoryId=FISH], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/newAccountForm\', start=Wed Dec 19 19:54:40 CST 2018, lastRequest=Wed Dec 19 19:54:40 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@5ae389a}', 'BD0307B6CDADA00CF47BEA98AD0FF97A');
INSERT INTO `session_attribute` VALUES (29, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/account/signIn], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/signInForm\', start=Wed Dec 19 19:58:58 CST 2018, lastRequest=Wed Dec 19 19:58:58 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@58231c31}', '871D1A1B398EB9EC923FC8B037063552');
INSERT INTO `session_attribute` VALUES (30, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/account/signIn], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/signInForm\', start=Wed Dec 19 20:00:25 CST 2018, lastRequest=Wed Dec 19 20:00:25 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@485dea4}', 'B7AED6E8FAFD7BBB6AA71838CC3378B7');
INSERT INTO `session_attribute` VALUES (31, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi, localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main, localhost:8080/jpetstore/account/editAccountForm], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds\', start=Wed Dec 19 20:01:40 CST 2018, lastRequest=Wed Dec 19 20:02:01 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@59de45d7}', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (32, 'code', '0CAX', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (33, 'languages', '[english, japanese]', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (34, 'myList', '[]', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (35, 'category', '[FISH, DOGS, REPTILES, CATS, BIRDS]', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (36, 'codePic', 'BufferedImage@15abf059: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (37, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', '363A7EDF3FA26B84DECD9E0B22FDB7CE');
INSERT INTO `session_attribute` VALUES (38, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/listOrders, localhost:8080/jpetstore/order/listOrders], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/editAccountForm\', start=Wed Dec 19 20:03:10 CST 2018, lastRequest=Wed Dec 19 20:03:21 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@622282cd}', '45B9D74F3670DD16EA1017B59BAD6E9D');
INSERT INTO `session_attribute` VALUES (39, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 20:08:09 CST 2018, lastRequest=Wed Dec 19 20:08:09 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@3ac23a13}', '83D270BD87B1BE8530DDBDED5707CEFF');
INSERT INTO `session_attribute` VALUES (40, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main, localhost:8080/jpetstore/account/editAccountForm, localhost:8080/jpetstore/order/listOrders, localhost:8080/jpetstore/main, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH, localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01, localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4, localhost:8080/jpetstore/order/newOrderForm], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 20:10:11 CST 2018, lastRequest=Wed Dec 19 20:10:55 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@1570880c}', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (41, 'code', 'ENX7', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (42, 'languages', '[english, japanese]', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (43, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (44, 'myList', '[]', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (45, 'creditCardTypes', '[Visa, MasterCard, American Express]', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (46, 'category', '[FISH, DOGS, REPTILES, CATS, BIRDS]', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (47, 'codePic', 'BufferedImage@3143cb6a: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (48, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (49, 'cart', 'Cart{itemMap={EST-4=CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}}, itemList=[CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}]}', '49534D92C728E47D8A70E395C8F7CDF5');
INSERT INTO `session_attribute` VALUES (50, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/order/newOrder?confirmed=true], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/order/newOrderForm\', start=Wed Dec 19 20:11:21 CST 2018, lastRequest=Wed Dec 19 20:11:25 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@3aa3aee6}', '2516714A625EA9B98838C9E46E7F1808');
INSERT INTO `session_attribute` VALUES (51, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrder?confirmed=true, localhost:8080/jpetstore/order/newOrder?confirmed=true, localhost:8080/jpetstore/order/newOrder?confirmed=true], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/order/newOrder\', start=Wed Dec 19 20:15:12 CST 2018, lastRequest=Wed Dec 19 20:15:26 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4a19388e}', 'B80867934793602EDA6470B3CD6A14A7');
INSERT INTO `session_attribute` VALUES (52, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 20:20:36 CST 2018, lastRequest=Wed Dec 19 20:20:36 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4e339a12}', 'B2E18157B4ACB7D4E6B3E02E35EF455D');
INSERT INTO `session_attribute` VALUES (53, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH, localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01, localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4, localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main, localhost:8080/jpetstore/cart/viewCart, localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/order/newOrder], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 20:20:38 CST 2018, lastRequest=Wed Dec 19 20:21:27 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@78a4e3aa}', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (54, 'code', 'QEJ6', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (55, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (56, 'creditCardTypes', '[Visa, MasterCard, American Express]', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (57, 'myList', '[]', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (58, 'cart', 'Cart{itemMap={EST-4=CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}}, itemList=[CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}]}', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (59, 'codePic', 'BufferedImage@7ccf2a71: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (60, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', '2108403290A9B86A8EDC460275D97DD6');
INSERT INTO `session_attribute` VALUES (61, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrder?confirmed=true], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/order/newOrder\', start=Wed Dec 19 20:24:14 CST 2018, lastRequest=Wed Dec 19 20:24:14 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4e44e8b5}', '4899C7C3D8EF9701DF32611E981ED13A');
INSERT INTO `session_attribute` VALUES (62, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 20:26:40 CST 2018, lastRequest=Wed Dec 19 20:27:01 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@518d3e2b}', 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `session_attribute` VALUES (63, 'code', '5494', 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `session_attribute` VALUES (64, 'myList', '[]', 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `session_attribute` VALUES (65, 'codePic', 'BufferedImage@2ca51c0a: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `session_attribute` VALUES (66, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', 'B281E9D0CB7EF294DE1E6D06540ED1D8');
INSERT INTO `session_attribute` VALUES (67, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 20:26:37 CST 2018, lastRequest=Wed Dec 19 20:26:37 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@3663b588}', '982A99241361C5D5D05EBB5B263E6087');
INSERT INTO `session_attribute` VALUES (68, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main, localhost:8080/jpetstore/main, localhost:8080/jpetstore/main, localhost:8080/jpetstore/main, localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main, localhost:8080/jpetstore/main, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH, localhost:8080/jpetstore/account/editAccountForm, localhost:8080/jpetstore/order/listOrders, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH, localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01, localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-4, localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH, localhost:8080/jpetstore/cart/viewCart, localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/account/editAccountForm, localhost:8080/jpetstore/cart/viewCart, localhost:8080/jpetstore/order/newOrderForm], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/account/signInForm\', start=Wed Dec 19 20:30:43 CST 2018, lastRequest=Wed Dec 19 20:31:47 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@456b6f4d}', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (69, 'code', 'LVZD', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (70, 'languages', '[english, japanese]', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (71, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (72, 'myList', '[]', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (73, 'creditCardTypes', '[Visa, MasterCard, American Express]', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (74, 'category', '[FISH, DOGS, REPTILES, CATS, BIRDS]', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (75, 'codePic', 'BufferedImage@534604b7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (76, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (77, 'cart', 'Cart{itemMap={EST-4=CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}}, itemList=[CartItem{item=Item{itemId=\'EST-4\', productId=\'FI-FW-01\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Spotted\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FI-FW-01\', categoryId=\'FISH\', name=\'Koi\', description=\'<img src=\"/jpetstore/static/images/fish3.gif\">Fresh Water fish from Japan\'}}, quantity=1, inStock=true, total=18.50}]}', 'E4D95AFF974ED79770082530E2EF1212');
INSERT INTO `session_attribute` VALUES (78, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/order/newOrder?confirmed=true], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/order/newOrderForm\', start=Wed Dec 19 20:32:05 CST 2018, lastRequest=Wed Dec 19 20:32:10 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@45873bcb}', 'FF1D0AC7A577530FE7A0D4773F518F1C');
INSERT INTO `session_attribute` VALUES (79, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrder?confirmed=true, localhost:8080/jpetstore/order/newOrder, localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/static/css/jpetstore.css, localhost:8080/jpetstore/static/images/logo-topbar.gif, localhost:8080/jpetstore/static/images/sm_fish.gif, localhost:8080/jpetstore/static/images/separator.gif, localhost:8080/jpetstore/static/images/cart.gif, localhost:8080/jpetstore/static/images/sm_dogs.gif, localhost:8080/jpetstore/static/images/sm_reptiles.gif, localhost:8080/jpetstore/static/images/sm_cats.gif, localhost:8080/jpetstore/static/images/sm_birds.gif, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/account/verify], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/order/newOrder\', start=Wed Dec 19 20:38:41 CST 2018, lastRequest=Wed Dec 19 20:38:51 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@4871f120}', '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `session_attribute` VALUES (80, 'code', 'FM3L', '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `session_attribute` VALUES (81, 'creditCardTypes', '[Visa, MasterCard, American Express]', '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `session_attribute` VALUES (82, 'codePic', 'BufferedImage@294d0e05: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '73E308C6C43549DEB96936A3E065536D');
INSERT INTO `session_attribute` VALUES (83, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/main], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/\', start=Wed Dec 19 21:13:34 CST 2018, lastRequest=Wed Dec 19 21:13:34 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@56c3f0f5}', '90D6FFA3C23AAAE7C75369B3A2F99E37');
INSERT INTO `session_attribute` VALUES (84, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/], attributes={}, hostname=\'127.0.0.1\', initialReferrer=\'\', start=Wed Dec 19 21:13:32 CST 2018, lastRequest=Wed Dec 19 21:13:32 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@35efe479}', 'D4A27EBC2B92600CDD10C10F1E948F47');
INSERT INTO `session_attribute` VALUES (85, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/viewCategory?categoryId=REPTILES, localhost:8080/jpetstore/catalog/viewProduct?productId=RP-LI-02, localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-13, localhost:8080/jpetstore/catalog/viewCategory?categoryId=CATS, localhost:8080/jpetstore/catalog/viewProduct?productId=FL-DLH-02, localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-16], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/main\', start=Wed Dec 19 21:14:06 CST 2018, lastRequest=Wed Dec 19 21:14:11 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@2856ea04}', '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `session_attribute` VALUES (86, 'javax.servlet.jsp.jstl.fmt.request.charset', 'UTF-8', '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `session_attribute` VALUES (87, 'cart', 'Cart{itemMap={EST-16=CartItem{item=Item{itemId=\'EST-16\', productId=\'FL-DLH-02\', listPrice=93.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Adult Female\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FL-DLH-02\', categoryId=\'CATS\', name=\'Persian\', description=\'<img src=\"/jpetstore/static/images/cat1.gif\">Friendly house cat, doubles as a princess\'}}, quantity=1, inStock=true, total=93.50}, EST-13=CartItem{item=Item{itemId=\'EST-13\', productId=\'RP-LI-02\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Green Adult\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'RP-LI-02\', categoryId=\'REPTILES\', name=\'Iguana\', description=\'<img src=\"/jpetstore/static/images/lizard2.gif\">Friendly green friend\'}}, quantity=1, inStock=true, total=18.50}}, itemList=[CartItem{item=Item{itemId=\'EST-13\', productId=\'RP-LI-02\', listPrice=18.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Green Adult\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'RP-LI-02\', categoryId=\'REPTILES\', name=\'Iguana\', description=\'<img src=\"/jpetstore/static/images/lizard2.gif\">Friendly green friend\'}}, quantity=1, inStock=true, total=18.50}, CartItem{item=Item{itemId=\'EST-16\', productId=\'FL-DLH-02\', listPrice=93.50, unitCost=12.00, supplierId=1, status=\'P\', attribute1=\'Adult Female\', attribute2=\'null\', attribute3=\'null\', attribute4=\'null\', attribute5=\'null\', quantity=10000, product=Product{productId=\'FL-DLH-02\', categoryId=\'CATS\', name=\'Persian\', description=\'<img src=\"/jpetstore/static/images/cat1.gif\">Friendly house cat, doubles as a princess\'}}, quantity=1, inStock=true, total=93.50}]}', '91DD3EEEB74580C0267E49C0FD2D22EB');
INSERT INTO `session_attribute` VALUES (88, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/order/newOrderForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signInForm, localhost:8080/jpetstore/account/verify, localhost:8080/jpetstore/account/signIn, localhost:8080/jpetstore/main], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-16\', start=Wed Dec 19 21:21:46 CST 2018, lastRequest=Wed Dec 19 21:21:58 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@20736f4f}', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (89, 'code', '2YH7', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (90, 'creditCardTypes', '[Visa, MasterCard, American Express]', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (91, 'myList', '[]', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (92, 'codePic', 'BufferedImage@31087cb7: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 IntegerInterleavedRaster: width = 90 height = 20 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (93, 'account', 'Account{userId=\'j2ee\', username=\'null\', password=\'null\', email=\'yourname@yourdomain.com\', firstName=\'ABC\', lastName=\'XYX\', status=\'null\', address1=\'901 San Antonio Road\', address2=\'MS UCUP02-206\', city=\'Palo Alto\', state=\'CA\', zip=\'94303\', country=\'USA\', phone=\'555-555-5555\', favouriteCategoryId=\'1\', languagePreference=\'english\', listOption=false, bannerOption=false, bannerName=\'FISH\', authenticated=true}', '5AD71A070794CDAE5FD9BEA6164073FD');
INSERT INTO `session_attribute` VALUES (94, 'jpetstore', 'JPetStoreSession{jPetStoreRequestList=[localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH], attributes={}, hostname=\'0:0:0:0:0:0:0:1\', initialReferrer=\'http://localhost:8080/jpetstore/main\', start=Wed Dec 19 21:23:40 CST 2018, lastRequest=Wed Dec 19 21:23:40 CST 2018, bot=false, session=org.apache.catalina.session.StandardSessionFacade@536c5f73}', '9EE25801F18FB9C0BC178CF58E282225');

-- ----------------------------
-- Table structure for session_record
-- ----------------------------
DROP TABLE IF EXISTS `session_record`;
CREATE TABLE `session_record`  (
  `id` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ip` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `referer` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_bot` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `request_count` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of session_record
-- ----------------------------
INSERT INTO `session_record` VALUES ('0A002441DC2A0B1232843C1F572CE2F5', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '15', '2018-12-14 15:44:09', '2018-12-14 15:44:43');
INSERT INTO `session_record` VALUES ('177CBDE453F691DC01BD0D6E6F827CED', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', '0', '9', '2018-12-19 19:42:32', '2018-12-19 19:43:03');
INSERT INTO `session_record` VALUES ('2108403290A9B86A8EDC460275D97DD6', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '13', '2018-12-19 20:20:38', '2018-12-19 20:21:27');
INSERT INTO `session_record` VALUES ('2516714A625EA9B98838C9E46E7F1808', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/order/newOrderForm', '0', '2', '2018-12-19 20:11:21', '2018-12-19 20:11:25');
INSERT INTO `session_record` VALUES ('28013D829BDF40A0D527BA9311B307AB', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '22', '2018-12-14 15:24:27', '2018-12-14 15:25:12');
INSERT INTO `session_record` VALUES ('363A7EDF3FA26B84DECD9E0B22FDB7CE', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', '0', '6', '2018-12-19 20:01:40', '2018-12-19 20:02:01');
INSERT INTO `session_record` VALUES ('398A895ADD9C1EF062DE018DA6F7E0E8', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/viewProduct?productId=FI-FW-01', '0', '2', '2018-12-19 19:40:48', '2018-12-19 19:40:49');
INSERT INTO `session_record` VALUES ('45B9D74F3670DD16EA1017B59BAD6E9D', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/editAccountForm', '0', '2', '2018-12-19 20:03:10', '2018-12-19 20:03:21');
INSERT INTO `session_record` VALUES ('46C3E17E2F453EE052CAF229367A5D75', '127.0.0.1', '', '0', '1', '2018-12-14 15:21:40', '2018-12-14 15:21:40');
INSERT INTO `session_record` VALUES ('4899C7C3D8EF9701DF32611E981ED13A', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/order/newOrder', '0', '1', '2018-12-19 20:24:14', '2018-12-19 20:24:14');
INSERT INTO `session_record` VALUES ('49534D92C728E47D8A70E395C8F7CDF5', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '16', '2018-12-19 20:10:11', '2018-12-19 20:10:55');
INSERT INTO `session_record` VALUES ('5AD71A070794CDAE5FD9BEA6164073FD', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/cart/addItemToCart?workingItemId=EST-16', '0', '6', '2018-12-19 21:21:46', '2018-12-19 21:21:58');
INSERT INTO `session_record` VALUES ('70F6A9BC73555F403DDE7997DE43C1B2', '127.0.0.1', '', '0', '1', '2018-12-19 19:32:27', '2018-12-19 19:32:27');
INSERT INTO `session_record` VALUES ('720057374821827AE310F67FBFC506F3', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/signInForm', '0', '2', '2018-12-19 19:53:51', '2018-12-19 19:53:52');
INSERT INTO `session_record` VALUES ('73E308C6C43549DEB96936A3E065536D', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/order/newOrder', '0', '15', '2018-12-19 20:38:41', '2018-12-19 20:38:51');
INSERT INTO `session_record` VALUES ('81FC8E99E7CBC95FAA81B79D269B9DE1', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '10', '2018-12-14 15:32:20', '2018-12-14 15:32:47');
INSERT INTO `session_record` VALUES ('83D270BD87B1BE8530DDBDED5707CEFF', '127.0.0.1', '', '0', '1', '2018-12-19 20:08:09', '2018-12-19 20:08:09');
INSERT INTO `session_record` VALUES ('871D1A1B398EB9EC923FC8B037063552', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/signInForm', '0', '1', '2018-12-19 19:58:58', '2018-12-19 19:58:58');
INSERT INTO `session_record` VALUES ('8BF98145529429943F7E0849E0587067', '127.0.0.1', '', '0', '1', '2018-12-14 15:43:10', '2018-12-14 15:43:10');
INSERT INTO `session_record` VALUES ('8F18CC05534C598CADB522A174B2BC8F', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=cat', '0', '1', '2018-12-19 19:49:20', '2018-12-19 19:49:20');
INSERT INTO `session_record` VALUES ('90D6FFA3C23AAAE7C75369B3A2F99E37', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '1', '2018-12-19 21:13:34', '2018-12-19 21:13:34');
INSERT INTO `session_record` VALUES ('91DD3EEEB74580C0267E49C0FD2D22EB', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/main', '0', '6', '2018-12-19 21:14:06', '2018-12-19 21:14:11');
INSERT INTO `session_record` VALUES ('982A99241361C5D5D05EBB5B263E6087', '127.0.0.1', '', '0', '1', '2018-12-19 20:26:37', '2018-12-19 20:26:37');
INSERT INTO `session_record` VALUES ('9EE25801F18FB9C0BC178CF58E282225', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/main', '0', '1', '2018-12-19 21:23:40', '2018-12-19 21:23:40');
INSERT INTO `session_record` VALUES ('A4FC18A051A35FBCCC94F89A6CBE021C', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '4', '2018-12-14 15:36:52', '2018-12-14 15:36:59');
INSERT INTO `session_record` VALUES ('AAEE521A81CD19AA4D946CEC1858E7E1', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '4', '2018-12-19 19:44:05', '2018-12-19 19:44:24');
INSERT INTO `session_record` VALUES ('B281E9D0CB7EF294DE1E6D06540ED1D8', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '5', '2018-12-19 20:26:40', '2018-12-19 20:27:01');
INSERT INTO `session_record` VALUES ('B2E18157B4ACB7D4E6B3E02E35EF455D', '127.0.0.1', '', '0', '1', '2018-12-19 20:20:36', '2018-12-19 20:20:36');
INSERT INTO `session_record` VALUES ('B7AED6E8FAFD7BBB6AA71838CC3378B7', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/signInForm', '0', '1', '2018-12-19 20:00:25', '2018-12-19 20:00:25');
INSERT INTO `session_record` VALUES ('B80867934793602EDA6470B3CD6A14A7', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/order/newOrder', '0', '3', '2018-12-19 20:15:12', '2018-12-19 20:15:26');
INSERT INTO `session_record` VALUES ('B9F63FA4711D2C224F7338B1878DCED2', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '18', '2018-12-14 15:21:43', '2018-12-14 15:22:27');
INSERT INTO `session_record` VALUES ('BD0307B6CDADA00CF47BEA98AD0FF97A', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/newAccountForm', '0', '1', '2018-12-19 19:54:40', '2018-12-19 19:54:40');
INSERT INTO `session_record` VALUES ('BF3EC5A90527C19A1411F03DF913B285', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/viewCategory?categoryId=FISH', '0', '1', '2018-12-19 19:37:41', '2018-12-19 19:37:41');
INSERT INTO `session_record` VALUES ('C376A9ED08FCBC7235C1B080B20D4F5B', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Birds', '0', '1', '2018-12-19 19:49:38', '2018-12-19 19:49:38');
INSERT INTO `session_record` VALUES ('C99375A2B2F73F1C1CD29A062941B72A', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '16', '2018-12-19 19:33:29', '2018-12-19 19:33:35');
INSERT INTO `session_record` VALUES ('CE7118ED496E4724F33A58BE83FDF437', '127.0.0.1', '', '0', '1', '2018-12-14 15:32:17', '2018-12-14 15:32:17');
INSERT INTO `session_record` VALUES ('D041463AF1CDA06534DFA0350AEF52A4', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/viewItem?itemId=EST-4', '0', '1', '2018-12-19 19:42:10', '2018-12-19 19:42:10');
INSERT INTO `session_record` VALUES ('D4A27EBC2B92600CDD10C10F1E948F47', '127.0.0.1', '', '0', '1', '2018-12-19 21:13:32', '2018-12-19 21:13:32');
INSERT INTO `session_record` VALUES ('D5BA95AE4521CE53051808E013B24F1E', '0:0:0:0:0:0:0:1', '', '0', '2', '2018-12-19 19:32:28', '2018-12-19 19:32:28');
INSERT INTO `session_record` VALUES ('DD886C5B8D494E3C4A221DBA5817EF38', '127.0.0.1', '', '0', '1', '2018-12-14 15:24:24', '2018-12-14 15:24:24');
INSERT INTO `session_record` VALUES ('E2453E5BA831C4D820D7700DEC10C609', '127.0.0.1', '', '0', '1', '2018-12-19 19:44:01', '2018-12-19 19:44:01');
INSERT INTO `session_record` VALUES ('E4D95AFF974ED79770082530E2EF1212', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/account/signInForm', '0', '25', '2018-12-19 20:30:43', '2018-12-19 20:31:47');
INSERT INTO `session_record` VALUES ('EA1C18F4676CF4FAC97E17585710D754', '127.0.0.1', '', '0', '1', '2018-12-19 19:46:54', '2018-12-19 19:46:54');
INSERT INTO `session_record` VALUES ('F4365DF06FBAB9F701D3DA541FCCC602', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/catalog/searchProducts?keyword=Koi', '0', '2', '2018-12-19 19:53:27', '2018-12-19 19:53:28');
INSERT INTO `session_record` VALUES ('F48C9E59CE69BFE4BC722DBC3060E607', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/', '0', '4', '2018-12-19 19:47:19', '2018-12-19 19:47:45');
INSERT INTO `session_record` VALUES ('FE2023924363E901F54852CEC5670D84', '127.0.0.1', '', '0', '1', '2018-12-14 15:36:28', '2018-12-14 15:36:28');
INSERT INTO `session_record` VALUES ('FF1D0AC7A577530FE7A0D4773F518F1C', '0:0:0:0:0:0:0:1', 'http://localhost:8080/jpetstore/order/newOrderForm', '0', '2', '2018-12-19 20:32:05', '2018-12-19 20:32:10');

-- ----------------------------
-- Table structure for signon
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon`  (
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of signon
-- ----------------------------
INSERT INTO `signon` VALUES ('a', 'a');
INSERT INTO `signon` VALUES ('ACID', 'ACID');
INSERT INTO `signon` VALUES ('j2ee', 'j2ee');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `suppid` int(11) NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`suppid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, 'XYZ Pets', 'AC', '600 Avon Way', '', 'Los Angeles', 'CA', '94024', '212-947-0797');
INSERT INTO `supplier` VALUES (2, 'ABC Pets', 'AC', '700 Abalone Way', '', 'San Francisco ', 'CA', '94024', '415-947-0797');

SET FOREIGN_KEY_CHECKS = 1;
