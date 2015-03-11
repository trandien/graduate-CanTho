-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2015 at 12:00 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tracnghiem`
--

-- --------------------------------------------------------

--
-- Table structure for table `cauhoi`
--

CREATE TABLE IF NOT EXISTS `cauhoi` (
  `MSDT` varchar(5) NOT NULL,
  `MSCH` int(11) NOT NULL,
  `MSDCH` int(11) NOT NULL,
  `MSDK` int(11) NOT NULL,
  `CH_NOIDUNGCAUHOI` varchar(1000) NOT NULL,
  `CH_DIEM` float NOT NULL,
  `CH_DAPANDUNG` varchar(2) NOT NULL,
  PRIMARY KEY (`MSDT`,`MSCH`),
  KEY `FK_DOKHO_CAUHOI` (`MSDK`),
  KEY `FK_THUOC` (`MSDCH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cautraloi`
--

CREATE TABLE IF NOT EXISTS `cautraloi` (
  `MSDT` varchar(5) NOT NULL,
  `MSCH` int(11) NOT NULL,
  `MSCTL` int(11) NOT NULL,
  `CTL_NOIDUNG` varchar(1000) NOT NULL,
  PRIMARY KEY (`MSDT`,`MSCH`,`MSCTL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chude`
--

CREATE TABLE IF NOT EXISTS `chude` (
  `MSCD` int(11) NOT NULL,
  `MSMH` int(11) NOT NULL,
  `CD_TEN` varchar(100) NOT NULL,
  PRIMARY KEY (`MSCD`),
  KEY `FK_MON_CHUDE` (`MSMH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dangcauhoi`
--

CREATE TABLE IF NOT EXISTS `dangcauhoi` (
  `MSDCH` int(11) NOT NULL,
  `DCH_TEN` varchar(100) NOT NULL,
  PRIMARY KEY (`MSDCH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dangthi`
--

CREATE TABLE IF NOT EXISTS `dangthi` (
  `MSDANGTHI` int(11) NOT NULL,
  `DT_TEN` varchar(20) NOT NULL,
  `DT_HESO` int(11) NOT NULL,
  PRIMARY KEY (`MSDANGTHI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dethi`
--

CREATE TABLE IF NOT EXISTS `dethi` (
  `MSDT` varchar(5) NOT NULL,
  `MSNK` int(11) NOT NULL,
  `MSHK` int(11) NOT NULL,
  `MSCD` int(11) NOT NULL,
  `MSMH` int(11) NOT NULL,
  `MSDANGTHI` int(11) NOT NULL,
  `DT_TENDE` varchar(100) NOT NULL,
  `DT_THOIGIANLAMBAI` int(11) NOT NULL,
  `DT_TRANGTHAI` tinyint(1) NOT NULL,
  `DT_MATKHAU` varchar(20) NOT NULL,
  `DT_NGAYTAODE` datetime NOT NULL,
  `DT_NGAYCAPNHAT` datetime NOT NULL,
  `DT_DANDO` text,
  PRIMARY KEY (`MSDT`),
  KEY `FK_CHUA` (`MSCD`),
  KEY `FK_DETHI_NIENKHOA` (`MSNK`),
  KEY `FK_HOCKY_DETHI` (`MSHK`),
  KEY `FK_MON_DETHI` (`MSMH`),
  KEY `FK_RELATIONSHIP_20` (`MSDANGTHI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dethi_lop`
--

CREATE TABLE IF NOT EXISTS `dethi_lop` (
  `MSL` varchar(10) NOT NULL,
  `MSDT` varchar(5) NOT NULL,
  PRIMARY KEY (`MSL`,`MSDT`),
  KEY `FK_RELATIONSHIP_29` (`MSDT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dokho`
--

CREATE TABLE IF NOT EXISTS `dokho` (
  `MSDK` int(11) NOT NULL,
  `DK_TEN` varchar(100) NOT NULL,
  PRIMARY KEY (`MSDK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hinhanh`
--

CREATE TABLE IF NOT EXISTS `hinhanh` (
  `MSHA` int(11) NOT NULL,
  `MSDT` varchar(5) NOT NULL,
  `MSCTL` int(11) NOT NULL,
  `MSCH` int(11) NOT NULL,
  `HA_NOIDUNG` longblob NOT NULL,
  PRIMARY KEY (`MSHA`),
  KEY `FK_HINHANH_CAUTRALOI` (`MSDT`,`MSCH`,`MSCTL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE IF NOT EXISTS `hocky` (
  `MSHK` int(11) NOT NULL,
  PRIMARY KEY (`MSHK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `khoi`
--

CREATE TABLE IF NOT EXISTS `khoi` (
  `MSK` varchar(10) NOT NULL,
  PRIMARY KEY (`MSK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khoi`
--

INSERT INTO `khoi` (`MSK`) VALUES
('10'),
('11'),
('12');

-- --------------------------------------------------------

--
-- Table structure for table `kithi`
--

CREATE TABLE IF NOT EXISTS `kithi` (
  `MSKT` int(11) NOT NULL,
  `MSDT` varchar(5) NOT NULL,
  `KT_TEN` varchar(20) NOT NULL,
  `KT_SOLANCHOPHEP` char(10) DEFAULT NULL,
  PRIMARY KEY (`MSKT`),
  KEY `FK_LANTHI_DETHI` (`MSDT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE IF NOT EXISTS `lop` (
  `MSL` varchar(10) NOT NULL,
  `MSK` varchar(10) NOT NULL,
  PRIMARY KEY (`MSL`),
  KEY `FK_THUOCD` (`MSK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`MSL`, `MSK`) VALUES
('10A1', '10'),
('10A2', '10'),
('10A3', '10'),
('11A1', '11'),
('11A2', '11'),
('11A3', '11'),
('12A1', '12'),
('12A2', '12');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE IF NOT EXISTS `monhoc` (
  `MSMH` int(11) NOT NULL,
  `MH_TEN` varchar(100) NOT NULL,
  PRIMARY KEY (`MSMH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nienkhoa`
--

CREATE TABLE IF NOT EXISTS `nienkhoa` (
  `MSNK` int(11) NOT NULL,
  `NK_TEN` varchar(20) NOT NULL,
  `NK_NAMBATDAU` int(11) NOT NULL,
  `NK_NAMKETTHUC` int(11) NOT NULL,
  `NK_NGAYBATDAU` int(11) NOT NULL,
  `NK_NGAYKETTHUC` int(11) NOT NULL,
  PRIMARY KEY (`MSNK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phancongvaitro`
--

CREATE TABLE IF NOT EXISTS `phancongvaitro` (
  `MSDT` varchar(5) NOT NULL,
  `ND_TAIKHOAN` varchar(10) NOT NULL,
  `MSVT` int(11) NOT NULL,
  `MSCDA` int(11) NOT NULL,
  PRIMARY KEY (`MSDT`,`ND_TAIKHOAN`,`MSVT`),
  KEY `FK_RELATIONSHIP_26` (`ND_TAIKHOAN`),
  KEY `FK_RELATIONSHIP_27` (`MSVT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE IF NOT EXISTS `phongthi` (
  `MSPT` int(11) NOT NULL,
  `PT_TEN` varchar(10) NOT NULL,
  PRIMARY KEY (`MSPT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `thi`
--

CREATE TABLE IF NOT EXISTS `thi` (
  `ND_TAIKHOAN` varchar(10) NOT NULL,
  `MSDT` varchar(5) NOT NULL,
  `MSPT` int(11) NOT NULL,
  `T_DANHDAU` tinyint(1) NOT NULL,
  `T_KHOABAILAM` tinyint(1) NOT NULL,
  `T_NGAYLAM` datetime NOT NULL,
  `T_THOIGIANBATDAU` datetime NOT NULL,
  `T_THOIGIANKETTHUC` datetime NOT NULL,
  `T_DIEM` float NOT NULL,
  PRIMARY KEY (`ND_TAIKHOAN`,`MSDT`),
  KEY `FK_LAM_DETHI` (`MSDT`),
  KEY `FK_THI_TRONG_PHONG` (`MSPT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `traloi`
--

CREATE TABLE IF NOT EXISTS `traloi` (
  `MSDT` varchar(5) NOT NULL,
  `MSCH` int(11) NOT NULL,
  `ND_TAIKHOAN` varchar(10) NOT NULL,
  `TL_DIEM` float NOT NULL,
  `TL_NOIDUNG` varchar(1000) NOT NULL,
  PRIMARY KEY (`MSDT`,`MSCH`,`ND_TAIKHOAN`),
  KEY `FK_RELATIONSHIP_23` (`ND_TAIKHOAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ND_TAIKHOAN` varchar(100) NOT NULL,
  `MSVT` int(11) NOT NULL,
  `MSL` varchar(10) NOT NULL,
  `ND_MATKHAU` varchar(100) NOT NULL,
  `ND_HOTEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ND_EMAIL` varchar(100) NOT NULL,
  `ND_AVATAR` longtext NOT NULL,
  `coderandom` varchar(10) NOT NULL,
  PRIMARY KEY (`ND_TAIKHOAN`),
  KEY `FK_THUOCS` (`MSL`),
  KEY `FK_VAITRO_USER` (`MSVT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ND_TAIKHOAN`, `MSVT`, `MSL`, `ND_MATKHAU`, `ND_HOTEN`, `ND_EMAIL`, `ND_AVATAR`, `coderandom`) VALUES
('tranthanhdien', 1, '12A2', '123456', 'Trần Thanh Điền', 'tranthanhdien123321@gmail.com', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `vaitro`
--

CREATE TABLE IF NOT EXISTS `vaitro` (
  `MSVT` int(11) NOT NULL,
  `VT_TEN` varchar(20) NOT NULL,
  PRIMARY KEY (`MSVT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vaitro`
--

INSERT INTO `vaitro` (`MSVT`, `VT_TEN`) VALUES
(1, 'QuanTri'),
(2, 'GiaoVien'),
(3, 'GiamThi'),
(4, 'HocSinh');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cauhoi`
--
ALTER TABLE `cauhoi`
  ADD CONSTRAINT `FK_THUOC` FOREIGN KEY (`MSDCH`) REFERENCES `dangcauhoi` (`MSDCH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHUAW` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DOKHO_CAUHOI` FOREIGN KEY (`MSDK`) REFERENCES `dokho` (`MSDK`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cautraloi`
--
ALTER TABLE `cautraloi`
  ADD CONSTRAINT `FK_CHUAF` FOREIGN KEY (`MSDT`, `MSCH`) REFERENCES `cauhoi` (`MSDT`, `MSCH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chude`
--
ALTER TABLE `chude`
  ADD CONSTRAINT `FK_MON_CHUDE` FOREIGN KEY (`MSMH`) REFERENCES `monhoc` (`MSMH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dethi`
--
ALTER TABLE `dethi`
  ADD CONSTRAINT `FK_RELATIONSHIP_20` FOREIGN KEY (`MSDANGTHI`) REFERENCES `dangthi` (`MSDANGTHI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHUA` FOREIGN KEY (`MSCD`) REFERENCES `chude` (`MSCD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DETHI_NIENKHOA` FOREIGN KEY (`MSNK`) REFERENCES `nienkhoa` (`MSNK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_HOCKY_DETHI` FOREIGN KEY (`MSHK`) REFERENCES `hocky` (`MSHK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MON_DETHI` FOREIGN KEY (`MSMH`) REFERENCES `monhoc` (`MSMH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dethi_lop`
--
ALTER TABLE `dethi_lop`
  ADD CONSTRAINT `FK_RELATIONSHIP_29` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_28` FOREIGN KEY (`MSL`) REFERENCES `lop` (`MSL`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hinhanh`
--
ALTER TABLE `hinhanh`
  ADD CONSTRAINT `FK_HINHANH_CAUTRALOI` FOREIGN KEY (`MSDT`, `MSCH`, `MSCTL`) REFERENCES `cautraloi` (`MSDT`, `MSCH`, `MSCTL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHUA1` FOREIGN KEY (`MSDT`, `MSCH`) REFERENCES `cauhoi` (`MSDT`, `MSCH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kithi`
--
ALTER TABLE `kithi`
  ADD CONSTRAINT `FK_LANTHI_DETHI` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `FK_THUOCD` FOREIGN KEY (`MSK`) REFERENCES `khoi` (`MSK`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phancongvaitro`
--
ALTER TABLE `phancongvaitro`
  ADD CONSTRAINT `FK_RELATIONSHIP_27` FOREIGN KEY (`MSVT`) REFERENCES `vaitro` (`MSVT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_25` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_26` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `thi`
--
ALTER TABLE `thi`
  ADD CONSTRAINT `FK_THI_TRONG_PHONG` FOREIGN KEY (`MSPT`) REFERENCES `phongthi` (`MSPT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_HOCSINH_LAM` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LAM_DETHI` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `traloi`
--
ALTER TABLE `traloi`
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`MSDT`, `MSCH`) REFERENCES `cauhoi` (`MSDT`, `MSCH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_THUOCS` FOREIGN KEY (`MSL`) REFERENCES `lop` (`MSL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_VAITRO_USER` FOREIGN KEY (`MSVT`) REFERENCES `vaitro` (`MSVT`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
