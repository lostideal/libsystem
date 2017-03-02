-- --------------------------------------------------------
-- Host:                         172.16.19.122
-- Server version:               5.6.35 - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for libsystem
DROP DATABASE IF EXISTS `libsystem`;
CREATE DATABASE IF NOT EXISTS `libsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `libsystem`;

-- Dumping structure for table libsystem.bookinfo
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE IF NOT EXISTS `bookinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` int(13) NOT NULL COMMENT '   ',
  `barcode` int(20) NOT NULL COMMENT ' 条形码 ',
  `name` varchar(50) NOT NULL COMMENT ' 书名  ',
  `publish` varchar(50) NOT NULL COMMENT ' 出版社 ',
  `publish_date` date NOT NULL COMMENT ' 出版时间  ',
  `author` varchar(50) NOT NULL COMMENT ' 作者  ',
  `translator` varchar(50) NOT NULL COMMENT ' 译者  ',
  `classify` varchar(10) NOT NULL COMMENT ' 分类  ',
  `content_intro` text NOT NULL COMMENT ' 内容简介  ',
  `author_intro` text NOT NULL COMMENT ' 作者简介  ',
  `price` double NOT NULL COMMENT ' 单价  ',
  `binding_type` int(2) NOT NULL COMMENT ' 装帧类型  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍信息表';

-- Data exporting was unselected.
-- Dumping structure for table libsystem.bookstorage
DROP TABLE IF EXISTS `bookstorage`;
CREATE TABLE IF NOT EXISTS `bookstorage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` int(13) NOT NULL COMMENT '   ',
  `barcode` int(20) NOT NULL COMMENT ' 条形码 ',
  `serial` int(20) NOT NULL COMMENT ' 商家id前缀+本店序列号：store/store_prefix+bookstorage/id  ',
  `location` varchar(50) NOT NULL COMMENT ' 位置  ',
  `reward` int(10) NOT NULL COMMENT ' 积分  ',
  `inventory` int(5) NOT NULL COMMENT ' 库存  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍库存表';

-- Data exporting was unselected.
-- Dumping structure for table libsystem.storagehistory
DROP TABLE IF EXISTS `storagehistory`;
CREATE TABLE IF NOT EXISTS `storagehistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) NOT NULL COMMENT ' bookstorage表主键  ',
  `deal_type` int(1) NOT NULL COMMENT ' 交易类型：1/借出,2/还回,3/卖出 ',
  `deal_date` date NOT NULL COMMENT ' 交易日期  ',
  `deal_user` int(10) NOT NULL COMMENT ' 交易人 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存记录表';

-- Data exporting was unselected.
-- Dumping structure for table libsystem.store
DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` int(10) NOT NULL COMMENT ' 商店名称  ',
  `store_address` varchar(20) NOT NULL COMMENT ' 商店地址  ',
  `store_phone` varchar(15) NOT NULL COMMENT ' 商店电话  ',
  `store_owner` int(10) NOT NULL COMMENT ' 店主ID：user表主键  ',
  `store_prefix` varchar(7) NOT NULL COMMENT ' 前缀  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家表';

-- Data exporting was unselected.
-- Dumping structure for table libsystem.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '   用户名 ',
  `credentials_name` varchar(10) NOT NULL COMMENT '   用户实名  ',
  `credentials_type` int(1) NOT NULL COMMENT '   证件类型：1/居民身份证、2/军人身份证、3/武装警察身份证、4/港澳居民往来内地通行证、5/台湾居民来往大陆通行证、6/护照 ',
  `credentials_num` varchar(20) NOT NULL COMMENT '   证件号码  ',
  `address` varchar(50) NOT NULL COMMENT '     ',
  `telephone` varchar(15) NOT NULL COMMENT '     ',
  `email` varchar(60) NOT NULL COMMENT '     ',
  `wxid` int(20) NOT NULL COMMENT '     ',
  `type` int(2) NOT NULL COMMENT '   用户类型：1/书馆工作人员，2/普通会员，3/付费年费会员，4/付费兑换会员，5/名誉会员，9/系统管理员 ',
  `photo` varchar(120) NOT NULL COMMENT '     ',
  `reward` int(10) NOT NULL COMMENT '   积分  ',
  `reward_used` int(10) NOT NULL COMMENT '   已兑换积分 ',
  `register_date` date NOT NULL,
  `validity_start_date` date NOT NULL,
  `validity_end_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
