-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2019 at 04:07 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dcc`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('Admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `dFirstName` varchar(20) NOT NULL,
  `doctorId` varchar(20) NOT NULL,
  `dAge` int(2) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dDob` date NOT NULL,
  `dSex` varchar(10) NOT NULL,
  `dAddress` varchar(30) NOT NULL,
  `dEntry` date NOT NULL,
  `dPassword` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`dFirstName`, `doctorId`, `dAge`, `email`, `dDob`, `dSex`, `dAddress`, `dEntry`, `dPassword`) VALUES
('Md.Saidur', 'saidur', 35, 'saidur@gmail.com', '1996-08-11', 'Male', 'Tangail', '2015-09-13', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `guard`
--

CREATE TABLE `guard` (
  `gFirstName` varchar(20) NOT NULL,
  `guardId` int(10) NOT NULL,
  `gAge` int(2) NOT NULL,
  `gParentName` varchar(20) NOT NULL,
  `gDob` date NOT NULL,
  `gSex` varchar(10) NOT NULL,
  `gAddress` varchar(30) NOT NULL,
  `startDate` date NOT NULL,
  `gPhone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guard`
--

INSERT INTO `guard` (`gFirstName`, `guardId`, `gAge`, `gParentName`, `gDob`, `gSex`, `gAddress`, `startDate`, `gPhone`) VALUES
('Sirajul', 22222, 29, 'Azizul Haque', '1991-06-12', 'Male', 'Gazipur', '2009-09-13', 1800000000),
('Rahim', 111, 25, 'jahangir', '1990-07-12', 'Male', 'jhigatola', '2019-06-11', 193723893),
('Karim', 112, 32, 'Abbas', '1982-09-12', 'Male', 'Nobiganj', '2018-09-12', 187237611),
('Mahbub', 101, 21, 'Md. Sabbir', '1998-01-01', 'Male', 'Mirpur', '2019-08-18', 1919214544);

-- --------------------------------------------------------

--
-- Table structure for table `prisoner`
--

CREATE TABLE `prisoner` (
  `pFirstName` varchar(20) NOT NULL,
  `prisonerId` varchar(20) NOT NULL,
  `pAge` int(2) NOT NULL,
  `pParentName` varchar(20) NOT NULL,
  `pDob` date NOT NULL,
  `pSex` varchar(10) NOT NULL,
  `pAddress` varchar(30) NOT NULL,
  `pHealth` varchar(30) DEFAULT NULL,
  `crime` varchar(30) NOT NULL,
  `entryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prisoner`
--

INSERT INTO `prisoner` (`pFirstName`, `prisonerId`, `pAge`, `pParentName`, `pDob`, `pSex`, `pAddress`, `pHealth`, `crime`, `entryDate`) VALUES
('sakib', '11117', 21, 'rakib bin', '1990-12-12', 'Male', 'sald', NULL, 'murder', '2017-12-12'),
('rahim', '11119', 21, 'kamal', '1991-12-12', 'Male', 'hidfskds', 'feaver', 'sudgch', '2012-12-12');

-- --------------------------------------------------------

--
-- Table structure for table `stuff`
--

CREATE TABLE `stuff` (
  `sFirstName` varchar(20) NOT NULL,
  `stuffId` int(10) NOT NULL,
  `sAge` int(2) NOT NULL,
  `sDob` date NOT NULL,
  `sSex` varchar(10) NOT NULL,
  `sWork` varchar(20) NOT NULL,
  `sAddress` varchar(30) NOT NULL,
  `sEntry` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stuff`
--

INSERT INTO `stuff` (`sFirstName`, `stuffId`, `sAge`, `sDob`, `sSex`, `sWork`, `sAddress`, `sEntry`) VALUES
('Ramiz', 44441, 29, '1991-12-14', 'Male', 'Chef', 'Noabgong', '2004-04-13'),
('Nobab', 112, 21, '1998-08-11', 'Male', 'Other', 'Noakhali', '2017-06-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `prisoner`
--
ALTER TABLE `prisoner`
  ADD UNIQUE KEY `prisonId` (`prisonerId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
