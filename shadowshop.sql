/*
Navicat MySQL Data Transfer

Source Server         : testMysql
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : shadowshop

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-12-17 09:29:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pNo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pName` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pNumber` int(11) NOT NULL,
  `pUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pIntroduce` varchar(255) NOT NULL,
  `pMoney` double(18,2) NOT NULL,
  `pType` int(11) NOT NULL,
  `pDetail` varchar(255) NOT NULL,
  `pUrl2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pNo`),
  KEY `pNo` (`pNo`),
  KEY `pName` (`pName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('245c3adb-4ce2-4bb8-a80f-feaefebccb10', '泊舒祛痘霜', '149', '..\\img\\245c3adb-4ce2-4bb8-a80f-feaefebccb10_1.jpg', '男士祛痘霜', '60.00', '1', '容量：30g|清痘修护霜', '');
INSERT INTO `product` VALUES ('2c7e5ffa-e192-42e3-a1d5-2203c5121574', 'DHC润唇膏', '299', '..\\img\\2c7e5ffa-e192-42e3-a1d5-2203c5121574_1.jpg', '修复嘴唇、保持长久湿润！', '50.00', '1', '日本进口|可修复嘴唇裂开等症状', '');
INSERT INTO `product` VALUES ('591c4682-73d0-4bb8-ab7b-34aee7018cc9', '美加净面霜', '130', '..\\img\\591c4682-73d0-4bb8-ab7b-34aee7018cc9_1.jpg', '冬天抹一抹，干皮不找我。', '35.00', '1', '容量：80g|功效：抵御干燥、恢复肌肤细泽', '');
INSERT INTO `product` VALUES ('968738d7-da67-4cd5-8801-515771056e13', '可爱小水杯', '200', '..\\img\\968738d7-da67-4cd5-8801-515771056e13_1.jpg', '暖手可用哦', '40.00', '1', '体积：300ML', '');
INSERT INTO `product` VALUES ('cc2dbc34-dcfd-493d-94a2-a2f19788d021', 'MAC口红', '200', '..\\img\\cc2dbc34-dcfd-493d-94a2-a2f19788d021_1.jpg', '全色号，总有你想要的！', '150.00', '1', '热销-chili|热销-麻辣鸡丝', '');
INSERT INTO `product` VALUES ('f4a6f7f1-6d0b-4fce-a29d-77bd4fe3a4be', '美加净身体乳', '120', '..\\img\\f4a6f7f1-6d0b-4fce-a29d-77bd4fe3a4be_1.jpg', '美加净身体乳，易推开，长久保湿！', '38.00', '1', '容量：200ML|香味：椰子香、玫瑰花香', '');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rNo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uNo` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pNo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rTime` datetime NOT NULL,
  `rType` int(11) NOT NULL,
  `pBuyNum` int(11) NOT NULL,
  `pMoney` double(18,2) NOT NULL,
  PRIMARY KEY (`rNo`),
  KEY `pBuyNum` (`pBuyNum`),
  KEY `uNo` (`uNo`),
  KEY `pNo` (`pNo`),
  CONSTRAINT `pNo` FOREIGN KEY (`pNo`) REFERENCES `product` (`pNo`) ON DELETE CASCADE,
  CONSTRAINT `uNo` FOREIGN KEY (`uNo`) REFERENCES `user` (`uNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('05e58707-243f-410d-8444-0ef7c922c8d3', '20191207', '591c4682-73d0-4bb8-ab7b-34aee7018cc9', '2019-12-16 20:19:57', '1', '0', '0.00');
INSERT INTO `record` VALUES ('12g16s200509', 'shadow', '2c7e5ffa-e192-42e3-a1d5-2203c5121574', '2019-12-16 20:05:09', '3', '1', '50.00');
INSERT INTO `record` VALUES ('12Q16Q201755', 'shadow', '245c3adb-4ce2-4bb8-a80f-feaefebccb10', '2019-12-16 20:17:55', '3', '1', '60.00');
INSERT INTO `record` VALUES ('47a4606d-8d2e-41e5-ac3b-dd9267ae4c48', 'shadow', '2c7e5ffa-e192-42e3-a1d5-2203c5121574', '2019-12-16 20:05:03', '1', '0', '0.00');
INSERT INTO `record` VALUES ('70487b56-d7b1-4b07-bb9b-569416d1e466', 'shadow', '245c3adb-4ce2-4bb8-a80f-feaefebccb10', '2019-12-16 20:04:50', '1', '0', '0.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uNo` char(12) NOT NULL,
  `uName` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uPassword` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uBalance` double(18,2) NOT NULL,
  `uAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`uNo`),
  KEY `uName` (`uName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20191207', 'testagain', '20191207', '111111@qq.com', '1000.00', null);
INSERT INTO `user` VALUES ('admin', '管理员', 'admin', '764215769@qq.com', '10140.00', 'C3-324');
INSERT INTO `user` VALUES ('shadow', 'shadow', 'shadow', '764215769@qq.com', '5770.00', 'C3-324');
INSERT INTO `user` VALUES ('test', 'fortest', 'fortest', '9999999@qq.com', '8888.22', null);

-- ----------------------------
-- Procedure structure for AddBrowsedRecord
-- ----------------------------
DROP PROCEDURE IF EXISTS `AddBrowsedRecord`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddBrowsedRecord`(IN `uuno` char(12),IN `ppno` varchar(100),IN `ttime` datetime,IN `rrno` varchar(100))
BEGIN
	#Routine body goes here...

DECLARE newrno VARCHAR(100) CHARACTER SET utf8;

select rNo into newrno
from record
where uNo=uuno and pNo=ppno and rType=1;

IF newrno is NULL THEN
insert into record
VALUES(rrno,uuno,ppno,ttime,1,0,0);
ELSE
update record
set rTime=ttime
where rNo=rrno;
end if;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for AddShoppingCar
-- ----------------------------
DROP PROCEDURE IF EXISTS `AddShoppingCar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddShoppingCar`(IN `rrno` varchar(100),IN `uuno` char(12),IN `ppno` varchar(100),IN `ttime` datetime)
BEGIN
	#Routine body goes here...
DECLARE newrno VARCHAR(100) CHARACTER SET utf8;

select rNo into newrno
from record
where uNo=uuno and pNo=ppno and rType=2;

IF newrno IS NULL THEN
INSERT into record
VALUES(rrno,uuno,ppno,ttime,2,1,0);
ELSE
update record
set pBuyNum=pBuyNum+1
where newrno=rNo;
END IF;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for BuyOne
-- ----------------------------
DROP PROCEDURE IF EXISTS `BuyOne`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `BuyOne`(IN `rrno` varchar(100),IN `uuno` char(12),IN `ppno` varchar(100),IN `ttime` datetime)
BEGIN
	#Routine body goes here...
	DECLARE num int;
	DECLARE reserve INT;
	DECLARE exist INT;
	DECLARE money DOUBLE;
START TRANSACTION;
SELECT pBuyNum INTO num
FROM record
WHERE ppno = pNo and uuno = uNo and rType = 2;

SELECT pNumber INTO reserve
FROM product
WHERE pNo = ppno;

	IF `reserve` = -1 THEN
	SET exist = 4;
	ELSEIF reserve >= num THEN
	SELECT pMoney INTO money FROM product WHERE ppno = pNo;
	DELETE FROM record WHERE ppno = pNo and uuno = uNo and rType = 2;
	INSERT INTO record VALUES(rrno,uuno,ppno,ttime,3,num,money);
	UPDATE `user` SET `uBalance` = `uBalance` - `num`*`money` WHERE uuno = uNo;
	UPDATE `user` SET `uBalance` = `uBalance` + `num`*`money` WHERE uNo = 'admin';
	UPDATE `product` SET `pNumber` = `pNumber` - `num` WHERE ppno = pNo;
	SET exist = 1;
	ELSE 
	SET exist = 3;
	END IF ;
	SELECT exist;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for ChangeProduct
-- ----------------------------
DROP PROCEDURE IF EXISTS `ChangeProduct`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ChangeProduct`(IN `ppno` varchar(100),IN `ppname` char(30),IN `ppNumber` int(11),IN `ppUrl` varchar(255),IN `ppIntroduce` varchar(255),IN `ppMoney` double,IN `ppDetail` varchar(255),IN `ppUrl2` varchar(255))
BEGIN
	#Routine body goes here...
START TRANSACTION;
update product
set pName=ppname,pIntroduce=ppIntroduce,pMoney=ppMoney,pNumber=ppNumber,pDetail=ppDetail
WHERE pNo = ppno;
IF ppUrl != '' THEN
update product
set pUrl = ppUrl
WHERE pNo = ppno;
END IF;
IF ppUrl2 != '' THEN
update product
set pUrl2 = ppUrl2
WHERE pNo = ppno;
END IF;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for loadBoughtProduct
-- ----------------------------
DROP PROCEDURE IF EXISTS `loadBoughtProduct`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadBoughtProduct`()
BEGIN
	#Routine body goes here...
SELECT p.pName pName,r.pMoney pMoney,count(r.pBuyNum) pBuyNum	,r.pNo pNo,p.pIntroduce pIntroduce,p.pDetail pDetail,p.pNumber pNumber
FROM record r
LEFT JOIN product p on r.pNo = p.pNo  
WHERE r.rType = 3
GROUP BY r.pNo,r.pMoney;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for loadCustomerInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `loadCustomerInfo`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadCustomerInfo`()
BEGIN
	#Routine body goes here...
SELECT rTime,uName,rType,pName,pBuyNum
FROM record
LEFT JOIN `user` on record.uNo = `user`.uNo
LEFT JOIN product ON record.pNo = product.pNo
WHERE `user`.uNo != 'admin'
ORDER BY rTime DESC;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for LoadMyBought
-- ----------------------------
DROP PROCEDURE IF EXISTS `LoadMyBought`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadMyBought`(IN `uuno` char(12))
BEGIN
	#Routine body goes here...
SELECT r.rTime rTime,p.pName pName,p.pIntroduce pIntroduce,r.pMoney pMoney,r.pBuyNum pBuyNum, r.pMoney*pBuyNum pAllMoney
FROM record r
LEFT JOIN product p ON r.pNo = p.pNo 
WHERE r.uNo = uuno AND r.rType = 3 
ORDER BY r.rTime DESC;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for LoadMyBrowsed
-- ----------------------------
DROP PROCEDURE IF EXISTS `LoadMyBrowsed`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadMyBrowsed`(IN `uuno` char(12))
BEGIN
	#Routine body goes here...
START TRANSACTION;
SELECT  r.rTime rTime, p.*
FROM record r
LEFT JOIN product p ON r.pNo = p.pNo
WHERE r.uNo = uuno AND r.rType = 1 ;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for LoadShoppingCar
-- ----------------------------
DROP PROCEDURE IF EXISTS `LoadShoppingCar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadShoppingCar`(IN `uuno` char(12))
BEGIN
	#Routine body goes here...

SELECT r.`rNo` rNo, p.*, r.`pBuyNum` pBuyNum
FROM `record` r
LEFT JOIN `product` p ON r.`pNo` = p.`pNo`
WHERE r.`uNo`=uuno AND r.`rType` = 2 ;
COMMIT;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Login
-- ----------------------------
DROP PROCEDURE IF EXISTS `Login`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Login`(IN `userno` char(12),IN `userPwd` char(30))
BEGIN
	#Routine body goes here...
START TRANSACTION;
select `uNo`,`uName`,`uPassword`,`uEmail`,`uAddress`,`uBalance`
from `user`
where `uNo`=userno and `uPassword`=userPwd;
COMMIT;
END
;;
DELIMITER ;
