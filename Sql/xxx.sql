-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2015 at 01:44 PM
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
  `MSDT` int(11) NOT NULL,
  `MSCH` int(11) NOT NULL AUTO_INCREMENT,
  `MSDCH` int(11) NOT NULL,
  `MSDK` int(11) NOT NULL,
  `CH_NOIDUNGCAUHOI` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CH_DIEM` float NOT NULL,
  `CH_DAPANDUNG` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MSCH`),
  KEY `FK_DETHI_CAUHOI` (`MSDT`),
  KEY `FK_DOKHO_CAUHOI` (`MSDK`),
  KEY `FK_THUOC` (`MSDCH`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=85 ;

--
-- Dumping data for table `cauhoi`
--

INSERT INTO `cauhoi` (`MSDT`, `MSCH`, `MSDCH`, `MSDK`, `CH_NOIDUNGCAUHOI`, `CH_DIEM`, `CH_DAPANDUNG`) VALUES
(7, 9, 1, 3, '<p>Trong word có mấy cách tạo Word Art&nbsp;</p>', 1, '38'),
(7, 10, 1, 2, '<p>Trong word để canh lề trái cho đoạn văn bản đã được chọn, ta bấm tổ hợp phím</p>', 1, '41'),
(7, 11, 1, 3, '<p>Trong soạn thảo văn bản word, muốn tạo hồ sơ mới ta thực hiện lệnh:</p>', 1, '46'),
(7, 12, 1, 1, '<p>1 Byte bằng</p>', 1, '50'),
(7, 13, 1, 1, '<p>Đơn vị đo lượng tin là:</p>', 1, '55'),
(7, 14, 1, 3, '<p>Thiết bị lưu trữ nào sao đây có thời gian truy cập nhanh nhất.</p>', 1, '57'),
(7, 15, 1, 3, '<p>Bạn muốn che dấu 1 thanh công cụ trong word, việc đầu tiên cần thực hiện là nhấp chuốt vào:</p>', 1, '61'),
(7, 16, 1, 2, '<p>1KB bằng</p>', 1, '66'),
(7, 17, 1, 3, '<p>Đâu là ví dụ về phần mềm máy tính</p>', 1, '69'),
(7, 18, 1, 3, '<p>Loại máy tính nào thường đắt nhất</p>', 1, '77'),
(68, 82, 2, 3, '<p>Đâu là kim loại?</p>', 1, '303-305-306-'),
(68, 83, 3, 1, '<p><strike>Hóa học</strike> là ngành khoa học chuyên <strike>nghiên cứu</strike> các chất và sự <strike>biến đổi</strike> các chất</p>', 3, ''),
(68, 84, 1, 1, '<p>Kim tử tháp nằm ở đâu?</p>', 1, '309');

-- --------------------------------------------------------

--
-- Table structure for table `cautraloi`
--

CREATE TABLE IF NOT EXISTS `cautraloi` (
  `MSCH` int(11) NOT NULL,
  `MSCTL` int(11) NOT NULL AUTO_INCREMENT,
  `CTL_NOIDUNG` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSCTL`),
  KEY `FK_CAUHOI_CAUTRALOI` (`MSCH`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=310 ;

--
-- Dumping data for table `cautraloi`
--

INSERT INTO `cautraloi` (`MSCH`, `MSCTL`, `CTL_NOIDUNG`) VALUES
(9, 37, '<p>1</p>'),
(9, 38, '<p>2</p>'),
(9, 39, '<p>3</p>'),
(9, 40, '<p>4</p>'),
(10, 41, '<p>Ctrl + C</p>'),
(10, 42, '<p>Ctrl + L</p>'),
(10, 43, '<p>Ctrl + R</p>'),
(10, 44, '<p>Ctrl + J</p>'),
(11, 45, '<p>Insert/New</p>'),
(11, 46, '<p>File/New</p>'),
(11, 47, '<p>Edit/New</p>'),
(12, 48, '<p>6 Bit</p>'),
(12, 49, '<p>7 Bits</p>'),
(12, 50, '<p>8 Bits</p>'),
(12, 51, '<p>9 Bits</p>'),
(13, 52, '<p>Hz</p>'),
(13, 53, '<p>KHz</p>'),
(13, 54, '<p>GHz</p>'),
(13, 55, '<p>Bit</p>'),
(14, 56, '<p>USB</p>'),
(14, 57, '<p>Đĩa cứng</p>'),
(14, 58, '<p>Băng từ</p>'),
(14, 59, '<p>Đĩa mềm</p>'),
(15, 60, '<p>file</p>'),
(15, 61, '<p>view</p>'),
(15, 62, '<p>insert</p>'),
(15, 63, '<p>tool</p>'),
(16, 64, '<p>100 bit</p>'),
(16, 65, '<p>1024 bit</p>'),
(16, 66, '<p>1024 byte</p>'),
(16, 67, '<p>1024 Mb</p>'),
(17, 68, '<p>Đĩa cứng</p>'),
(17, 69, '<p>Hệ điều hành</p>'),
(17, 70, '<p>Đĩa CD</p>'),
(17, 71, '<p>Cả 3 ý trên</p>'),
(18, 76, '<p>Máy tính cá nhân</p>'),
(18, 77, '<p>Máy chủ</p>'),
(18, 78, '<p>Máy để bàn</p>'),
(18, 79, '<p>Máy xách tay</p>'),
(82, 303, '<p>Sắt</p>'),
(82, 304, '<p>Kẻm</p>'),
(82, 305, '<p>nước</p>'),
(82, 306, '<p>chì</p>'),
(84, 307, '<p>Cam - pu - chia</p>'),
(84, 308, '<p>Nhật Bản</p>'),
(84, 309, '<p><img class="fr-fin fr-dib" alt="Image title" src="http://i.froala.com/download/d7afd961710e732b237529d69fc4b807c9f6d40d.jpg?1430124985" width="159"></p><p><br></p>');

-- --------------------------------------------------------

--
-- Table structure for table `chude`
--

CREATE TABLE IF NOT EXISTS `chude` (
  `ND_TAIKHOAN` varchar(100) DEFAULT NULL,
  `MSCD` int(11) NOT NULL AUTO_INCREMENT,
  `CD_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSCD`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `chude`
--

INSERT INTO `chude` (`ND_TAIKHOAN`, `MSCD`, `CD_TEN`) VALUES
('tranthanhdien', 1, 'Hóa vô cơ'),
('tranthanhdien', 3, 'Hóa hữu cơ'),
('huynhnhatminh', 4, 'Hóa phân tích'),
('tranthanhdien', 5, 'Hóa lượng tử'),
('tranthanhdien', 6, 'Hóa đại cương');

-- --------------------------------------------------------

--
-- Table structure for table `dangcauhoi`
--

CREATE TABLE IF NOT EXISTS `dangcauhoi` (
  `MSDCH` int(11) NOT NULL AUTO_INCREMENT,
  `DCH_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSDCH`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `dangcauhoi`
--

INSERT INTO `dangcauhoi` (`MSDCH`, `DCH_TEN`) VALUES
(1, 'Chọn câu đúng nhất'),
(2, 'Chọn câu đúng'),
(3, 'Điền vào chổ trống');

-- --------------------------------------------------------

--
-- Table structure for table `dangthi`
--

CREATE TABLE IF NOT EXISTS `dangthi` (
  `MSDANGTHI` int(11) NOT NULL AUTO_INCREMENT,
  `DT_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DT_HESO` int(11) NOT NULL,
  PRIMARY KEY (`MSDANGTHI`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `dangthi`
--

INSERT INTO `dangthi` (`MSDANGTHI`, `DT_TEN`, `DT_HESO`) VALUES
(1, 'Kiểm tra hệ số 1', 1),
(2, 'Kiểm tra hệ số 2', 2),
(3, 'Kiểm tra hệ số 3', 3),
(4, 'Kiểm tra thử', 0);

-- --------------------------------------------------------

--
-- Table structure for table `dethi`
--

CREATE TABLE IF NOT EXISTS `dethi` (
  `MSDT` int(11) NOT NULL AUTO_INCREMENT,
  `MSNK` int(11) NOT NULL,
  `MSHK` int(11) NOT NULL,
  `MSCD` int(11) NOT NULL,
  `MSMH` int(11) NOT NULL,
  `MSDANGTHI` int(11) NOT NULL,
  `DT_TENDE` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DT_THOIGIANLAMBAI` int(11) NOT NULL,
  `DT_TRANGTHAI` int(1) NOT NULL,
  `DT_MATKHAU` varchar(20) NOT NULL,
  `DT_NGAYTAODE` date NOT NULL,
  `DT_NGAYCAPNHAT` date DEFAULT NULL,
  `DT_DANDO` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `DT_solanchophep` int(11) NOT NULL,
  `DT_NGUOIRADE` varchar(100) NOT NULL,
  `LANCAPNHAT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MSDT`),
  KEY `FK_CHUA` (`MSCD`),
  KEY `FK_DETHI_NIENKHOA` (`MSNK`),
  KEY `FK_HOCKY_DETHI` (`MSHK`),
  KEY `FK_MON_DETHI` (`MSMH`),
  KEY `FK_RELATIONSHIP_20` (`MSDANGTHI`),
  KEY `dethi_user` (`DT_NGUOIRADE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=110 ;

--
-- Dumping data for table `dethi`
--

INSERT INTO `dethi` (`MSDT`, `MSNK`, `MSHK`, `MSCD`, `MSMH`, `MSDANGTHI`, `DT_TENDE`, `DT_THOIGIANLAMBAI`, `DT_TRANGTHAI`, `DT_MATKHAU`, `DT_NGAYTAODE`, `DT_NGAYCAPNHAT`, `DT_DANDO`, `DT_solanchophep`, `DT_NGUOIRADE`, `LANCAPNHAT`) VALUES
(7, 1, 1, 3, 10, 1, 'Đề thi số 3', 3, 1, '123456', '2015-04-15', NULL, 'Trao đổi nhỏ thôi mấy em             ', 50, 'tranthanhdien', NULL),
(68, 1, 1, 6, 1, 1, 'Thais', 30, 1, 'dsa', '2015-04-11', NULL, 'dsa											', 100, 'tranthanhdien', NULL),
(105, 1, 1, 1, 1, 1, 'Đề mẫu', 30, 0, 'dsa', '2015-04-30', NULL, 'dsa											', 2, 'tranthanhdien', NULL),
(106, 1, 1, 1, 1, 1, 'DDee', 1, 0, 'dsa', '2015-04-30', NULL, 'dsa											', 3, 'tranthanhdien', NULL),
(107, 1, 1, 1, 1, 1, 'DDeef maamdsa', 120, 0, 'dsadsa', '2015-04-30', NULL, 'dsa											', 3, 'tranthanhdien', NULL),
(108, 1, 1, 1, 1, 1, 'xxx', 1, 0, 'dsa', '2015-04-29', NULL, 'dsa											', 3, 'tranthanhdien', NULL),
(109, 1, 1, 1, 1, 1, 'acb', 30, 0, 'dsa', '2015-04-30', NULL, 'dsa											', 3, 'tranthanhdien', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `dethi_lop`
--

CREATE TABLE IF NOT EXISTS `dethi_lop` (
  `MSL` varchar(10) NOT NULL,
  `MSDT` int(11) NOT NULL,
  `MSPT` int(11) DEFAULT NULL,
  `NGAY` date DEFAULT NULL,
  `GIOBATDAU` time DEFAULT NULL,
  `GIOKETTHUC` time DEFAULT NULL,
  PRIMARY KEY (`MSL`,`MSDT`),
  KEY `FK_RELATIONSHIP_29` (`MSDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dethi_lop`
--

INSERT INTO `dethi_lop` (`MSL`, `MSDT`, `MSPT`, `NGAY`, `GIOBATDAU`, `GIOKETTHUC`) VALUES
('10A1', 106, 1, '2015-04-30', '01:30:00', '02:30:00'),
('12A1', 107, 1, '2015-04-30', '03:30:00', '03:40:00'),
('12A1', 108, 1, '2015-04-30', '07:30:00', '08:30:00'),
('12A2', 109, 8, '2015-04-30', '09:30:00', '10:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `dokho`
--

CREATE TABLE IF NOT EXISTS `dokho` (
  `MSDK` int(11) NOT NULL AUTO_INCREMENT,
  `DK_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSDK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `dokho`
--

INSERT INTO `dokho` (`MSDK`, `DK_TEN`) VALUES
(1, 'Khó'),
(2, 'Trung bình'),
(3, 'Dễ');

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE IF NOT EXISTS `hocky` (
  `MSHK` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`MSHK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`MSHK`) VALUES
(1),
(2),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `khoi`
--

CREATE TABLE IF NOT EXISTS `khoi` (
  `MSK` varchar(10) NOT NULL,
  PRIMARY KEY (`MSK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `MSKT` int(11) NOT NULL AUTO_INCREMENT,
  `MSDT` int(11) NOT NULL,
  `KT_TEN` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSKT`),
  KEY `FK_LANTHI_DETHI` (`MSDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE IF NOT EXISTS `lop` (
  `MSL` varchar(10) NOT NULL,
  `MSK` varchar(10) NOT NULL,
  PRIMARY KEY (`MSL`),
  KEY `FK_THUOCD` (`MSK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `MSMH` int(11) NOT NULL AUTO_INCREMENT,
  `MH_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSMH`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`MSMH`, `MH_TEN`) VALUES
(1, 'Toán'),
(2, 'Vật lý'),
(3, 'Ngữ văn'),
(4, 'Lịch sử'),
(5, 'Tiếng Anh'),
(6, 'Sinh học'),
(7, 'Giáo dục công dân'),
(8, 'Quốc phòng'),
(9, 'Thể dục'),
(10, 'Tin học'),
(11, 'Công nghệ'),
(12, 'Hóa học');

-- --------------------------------------------------------

--
-- Table structure for table `nienkhoa`
--

CREATE TABLE IF NOT EXISTS `nienkhoa` (
  `MSNK` int(11) NOT NULL AUTO_INCREMENT,
  `NK_TEN` varchar(20) NOT NULL,
  `NK_NAMBATDAU` int(11) NOT NULL,
  `NK_NAMKETTHUC` int(11) NOT NULL,
  `NK_NGAYBATDAU` date NOT NULL,
  `NK_NGAYKETTHUC` date NOT NULL,
  PRIMARY KEY (`MSNK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `nienkhoa`
--

INSERT INTO `nienkhoa` (`MSNK`, `NK_TEN`, `NK_NAMBATDAU`, `NK_NAMKETTHUC`, `NK_NGAYBATDAU`, `NK_NGAYKETTHUC`) VALUES
(1, '2001-2002', 2001, 2002, '2015-01-01', '2015-05-01'),
(2, '2002-2003', 2002, 2002, '2015-01-01', '2015-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `phancongvaitro`
--

CREATE TABLE IF NOT EXISTS `phancongvaitro` (
  `MSPCVT` int(11) NOT NULL AUTO_INCREMENT,
  `MSDT` int(11) DEFAULT NULL,
  `ND_TAIKHOAN` varchar(100) NOT NULL,
  `MSVT` int(11) NOT NULL,
  `MSCDA` int(11) NOT NULL,
  `MSPT` int(11) DEFAULT NULL,
  `NGAY` date DEFAULT NULL,
  `GIOBATDAU` time DEFAULT NULL,
  `GIOKETTHUC` time DEFAULT NULL,
  PRIMARY KEY (`MSPCVT`),
  KEY `FK_RELATIONSHIP_26` (`ND_TAIKHOAN`),
  KEY `FK_RELATIONSHIP_25` (`MSDT`),
  KEY `FK_RELATIONSHIP_27` (`MSVT`),
  KEY `phancongvaitro_phongthi` (`MSPT`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=337 ;

--
-- Dumping data for table `phancongvaitro`
--

INSERT INTO `phancongvaitro` (`MSPCVT`, `MSDT`, `ND_TAIKHOAN`, `MSVT`, `MSCDA`, `MSPT`, `NGAY`, `GIOBATDAU`, `GIOKETTHUC`) VALUES
(194, 7, 'tranthanhdien', 5, 3, NULL, NULL, NULL, NULL),
(195, 7, 'truongvanmenh', 4, 3, 6, '2015-04-24', '15:30:00', '16:30:00'),
(286, 68, 'tranthanhdien', 5, 6, NULL, NULL, NULL, NULL),
(287, 68, 'truongvanmenh', 4, 6, 5, '2015-04-25', '03:30:00', '04:30:00'),
(326, 105, 'tranthanhdien', 5, 1, NULL, NULL, NULL, NULL),
(327, 106, 'tranthanhdien', 5, 1, NULL, NULL, NULL, NULL),
(328, 106, 'huynhnhatminh', 3, 1, 1, '2015-04-30', '01:30:00', '02:30:00'),
(329, 107, 'tranthanhdien', 5, 1, NULL, NULL, NULL, NULL),
(330, 107, 'huynhnhatminh', 3, 1, 1, '2015-04-30', '03:30:00', '03:40:00'),
(331, 108, 'tranthanhdien', 5, 1, NULL, NULL, NULL, NULL),
(332, 108, 'huynhnhatminh', 3, 1, 1, '2015-04-30', '07:30:00', '08:30:00'),
(333, 109, 'tranthanhdien', 5, 1, NULL, NULL, NULL, NULL),
(334, 109, 'huynhnhatminh', 3, 1, 8, '2015-04-30', '09:30:00', '10:30:00'),
(335, 109, 'nguyenvannhan', 4, 1, 8, '2015-04-30', '09:30:00', '10:30:00'),
(336, 109, 'truongvanmenh', 4, 1, 8, '2015-04-30', '09:30:00', '10:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE IF NOT EXISTS `phongthi` (
  `MSPT` int(11) NOT NULL AUTO_INCREMENT,
  `PT_TEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSPT`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `phongthi`
--

INSERT INTO `phongthi` (`MSPT`, `PT_TEN`) VALUES
(1, 'Phòng 1'),
(2, 'Phòng 2'),
(3, 'Phòng 3'),
(4, 'Phòng 4'),
(5, 'Phòng 5'),
(6, 'Phòng 6'),
(7, 'Phòng 7'),
(8, 'Phòng hội trường');

-- --------------------------------------------------------

--
-- Table structure for table `thi`
--

CREATE TABLE IF NOT EXISTS `thi` (
  `MST` int(11) NOT NULL AUTO_INCREMENT,
  `ND_TAIKHOAN` varchar(100) NOT NULL,
  `SOLANTHI` int(11) DEFAULT NULL,
  `MSDT` int(11) NOT NULL,
  `T_SOCAUDUNG` int(11) DEFAULT NULL,
  `T_TONGSOCAU` int(11) DEFAULT NULL,
  `T_KHOABAILAM` tinyint(1) DEFAULT NULL,
  `T_NGAYLAM` datetime DEFAULT NULL,
  `T_DIEM` float NOT NULL,
  PRIMARY KEY (`MST`),
  KEY `FK_HOCSINH_LAM` (`ND_TAIKHOAN`),
  KEY `FK_LAM_DETHI` (`MSDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `traloi`
--

CREATE TABLE IF NOT EXISTS `traloi` (
  `MSDT` int(11) NOT NULL,
  `MSCH` int(11) NOT NULL,
  `ND_TAIKHOAN` varchar(10) NOT NULL,
  `TL_DIEM` float NOT NULL,
  `TL_NOIDUNG` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MSDT`,`MSCH`,`ND_TAIKHOAN`),
  KEY `FK_RELATIONSHIP_23` (`ND_TAIKHOAN`),
  KEY `FK_RELATIONSHIP_22` (`MSCH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ND_TAIKHOAN` varchar(100) NOT NULL,
  `MSVT` int(11) NOT NULL,
  `MSL` varchar(10) DEFAULT NULL,
  `ND_MATKHAU` varchar(100) NOT NULL,
  `ND_HOTEN` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ND_EMAIL` varchar(100) NOT NULL,
  `ND_AVATAR` longtext NOT NULL,
  `coderandom` varchar(10) NOT NULL,
  PRIMARY KEY (`ND_TAIKHOAN`),
  KEY `FK_THUOCS` (`MSL`),
  KEY `FK_VAITRO_USER` (`MSVT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ND_TAIKHOAN`, `MSVT`, `MSL`, `ND_MATKHAU`, `ND_HOTEN`, `ND_EMAIL`, `ND_AVATAR`, `coderandom`) VALUES
('huynhnhatminh', 2, NULL, '123456', 'Huỳnh Nhật Minh', 'huynhnhatminh@gmail.com', '', ''),
('luongducduy', 2, NULL, '123456', 'Lương Đức Duy', 'luongducduy@gmail.com', '', ''),
('lyconguan', 4, '12A2', '123456', 'Lý Công Uẩn', 'uan@gmail.com', '', ''),
('ngominhphuong', 4, NULL, '123456', 'Ngô Minh Phương', 'ngominhphuong@gmail.com', '', ''),
('nguyenminhtri', 4, '12A1', '123456', 'Nguyễn Minh Trí', 'tri@gmail.com', '', ''),
('nguyenquoclo', 4, '12A2', '123456', 'Nguyễn Quốc Lộ', 'lo@gmail.com', '', ''),
('nguyenvanbao', 4, '12A2', '123456', 'Nguyễn Văn Bạo', 'bao@gmail.com', '', ''),
('nguyenvannhan', 4, '12A1', '123456', 'Nguyễn Văn Nhân', 'nhan@gmail.com', '', ''),
('nguyenvikhang', 4, '12A2', '123456', 'Nguyễn Vĩ Khang', 'khang@gmail.com', '', ''),
('thaiquocdung', 4, '12A1', '123456', 'Thái Quốc Dũng', 'dung@gmail.com', '', ''),
('tranhuutinh', 2, NULL, '123456', 'Trần Hữu Tính', 'tranhuutinh@gmail.com', '', ''),
('tranthanhdien', 1, '12A2', '123456', 'Trần Thanh Điền', 'tranthanhdien123321@gmail.com', 'data:image/jpeg;base64,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', '');
INSERT INTO `user` (`ND_TAIKHOAN`, `MSVT`, `MSL`, `ND_MATKHAU`, `ND_HOTEN`, `ND_EMAIL`, `ND_AVATAR`, `coderandom`) VALUES
('truongvanmenh', 4, '12A1', '123456', 'Trương Văn Mệnh', 'menh@gmail.com', 'data:image/jpeg;base64,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', '');

-- --------------------------------------------------------

--
-- Table structure for table `vaitro`
--

CREATE TABLE IF NOT EXISTS `vaitro` (
  `MSVT` int(11) NOT NULL,
  `VT_TEN` varchar(20) NOT NULL,
  PRIMARY KEY (`MSVT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vaitro`
--

INSERT INTO `vaitro` (`MSVT`, `VT_TEN`) VALUES
(1, 'QuanTri'),
(2, 'GiaoVien'),
(3, 'GiamThi'),
(4, 'HocSinh'),
(5, 'GVRaDe');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cauhoi`
--
ALTER TABLE `cauhoi`
  ADD CONSTRAINT `FK_DETHI_CAUHOI` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DOKHO_CAUHOI` FOREIGN KEY (`MSDK`) REFERENCES `dokho` (`MSDK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_THUOC` FOREIGN KEY (`MSDCH`) REFERENCES `dangcauhoi` (`MSDCH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cautraloi`
--
ALTER TABLE `cautraloi`
  ADD CONSTRAINT `FK_CAUHOI_CAUTRALOI` FOREIGN KEY (`MSCH`) REFERENCES `cauhoi` (`MSCH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dethi`
--
ALTER TABLE `dethi`
  ADD CONSTRAINT `dethi_user` FOREIGN KEY (`DT_NGUOIRADE`) REFERENCES `user` (`ND_TAIKHOAN`),
  ADD CONSTRAINT `FK_CHUA` FOREIGN KEY (`MSCD`) REFERENCES `chude` (`MSCD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DETHI_NIENKHOA` FOREIGN KEY (`MSNK`) REFERENCES `nienkhoa` (`MSNK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_HOCKY_DETHI` FOREIGN KEY (`MSHK`) REFERENCES `hocky` (`MSHK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MON_DETHI` FOREIGN KEY (`MSMH`) REFERENCES `monhoc` (`MSMH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_20` FOREIGN KEY (`MSDANGTHI`) REFERENCES `dangthi` (`MSDANGTHI`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dethi_lop`
--
ALTER TABLE `dethi_lop`
  ADD CONSTRAINT `FK_RELATIONSHIP_28` FOREIGN KEY (`MSL`) REFERENCES `lop` (`MSL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_29` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `FK_RELATIONSHIP_25` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_26` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_27` FOREIGN KEY (`MSVT`) REFERENCES `vaitro` (`MSVT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phancongvaitro_phongthi` FOREIGN KEY (`MSPT`) REFERENCES `phongthi` (`MSPT`);

--
-- Constraints for table `thi`
--
ALTER TABLE `thi`
  ADD CONSTRAINT `FK_HOCSINH_LAM` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LAM_DETHI` FOREIGN KEY (`MSDT`) REFERENCES `dethi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `traloi`
--
ALTER TABLE `traloi`
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`MSCH`) REFERENCES `cauhoi` (`MSCH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`ND_TAIKHOAN`) REFERENCES `user` (`ND_TAIKHOAN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_24` FOREIGN KEY (`MSDT`) REFERENCES `cauhoi` (`MSDT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_THUOCS` FOREIGN KEY (`MSL`) REFERENCES `lop` (`MSL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_VAITRO_USER` FOREIGN KEY (`MSVT`) REFERENCES `vaitro` (`MSVT`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
