-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2023 at 01:19 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rto`
--

-- --------------------------------------------------------

--
-- Table structure for table `dl_slots`
--

CREATE TABLE `dl_slots` (
  `Test_Date` date NOT NULL,
  `Day_of_week` varchar(20) NOT NULL,
  `Slots_available` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dl_slots`
--

INSERT INTO `dl_slots` (`Test_Date`, `Day_of_week`, `Slots_available`) VALUES
('2023-10-07', 'Saturday', 20),
('2023-10-09', 'Monday', 20),
('2023-10-10', 'Tuesday', 20),
('2023-10-11', 'Wednesday', 20),
('2023-10-12', 'Thursday', 20),
('2023-10-13', 'Friday', 20),
('2023-10-14', 'Saturday', 20),
('2023-10-16', 'Monday', 20),
('2023-10-17', 'Tuesday', 20),
('2023-10-18', 'Wednesday', 20),
('2023-10-19', 'Thursday', 20),
('2023-10-20', 'Friday', 20),
('2023-10-21', 'Saturday', 20),
('2023-10-23', 'Monday', 20),
('2023-10-24', 'Tuesday', 20),
('2023-10-25', 'Wednesday', 20),
('2023-10-26', 'Thursday', 20),
('2023-10-27', 'Friday', 20),
('2023-10-28', 'Saturday', 20),
('2023-10-30', 'Monday', 20),
('2023-10-31', 'Tuesday', 20),
('2023-11-01', 'Wednesday', 20),
('2023-11-02', 'Thursday', 20),
('2023-11-03', 'Friday', 20),
('2023-11-04', 'Saturday', 20);

-- --------------------------------------------------------

--
-- Table structure for table `echallan`
--

CREATE TABLE `echallan` (
  `numberPlate` varchar(50) NOT NULL,
  `Price` int(50) NOT NULL,
  `Reason` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `echallan`
--

INSERT INTO `echallan` (`numberPlate`, `Price`, `Reason`) VALUES
('GJ 01 II 2697', 1000, 'No Helmet'),
('GJ 23 AB 5632', 1500, 'Speeding'),
('GJ 12 CD 4569', 1200, 'Running a Red Light'),
('GJ 31 EF 7456', 1800, 'No Seatbelt'),
('GJ 15 GH 7896', 500, 'Illegal Parking'),
('GJ 04 IJ 1456', 750, 'Driving without a License'),
('GJ 31 KL 4589', 900, 'DUI'),
('GJ 08 MN 4236', 1100, 'Reckless Driving'),
('GJ 27 OP 7458', 2000, 'Expired Registration'),
('GJ 19 QR 2658', 1600, 'Failure to Yield'),
('GJ 33 ST 1023', 550, 'No Insurance'),
('GJ 14 UV 9090', 1300, 'Speeding'),
('GJ 29 WX 4124', 1750, 'Running a Red Light'),
('GJ 06 YZ 9894', 1400, 'No Seatbelt'),
('GJ 35 AB 9856', 950, 'Illegal Parking'),
('GJ 22 CD 7153', 800, 'Driving without a License'),
('GJ 10 EF 6803', 1100, 'DUI'),
('GJ 18 GH 7817', 1750, 'Reckless Driving'),
('GJ 26 IJ 1018', 1850, 'Expired Registration'),
('GJ 02 KL 5619', 650, 'Failure to Yield'),
('GJ 30 MN 9812', 600, 'No Insurance');

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `User_id` int(11) NOT NULL,
  `First_name` varchar(20) NOT NULL,
  `Middle_name` varchar(20) NOT NULL,
  `Last_name` varchar(20) NOT NULL,
  `Mobile_no` varchar(10) NOT NULL,
  `DOB` varchar(10) NOT NULL,
  `RTO_Code` int(11) NOT NULL,
  `Pswd` varchar(4) NOT NULL,
  `LL_number` varchar(20) DEFAULT NULL,
  `DL_number` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`User_id`, `First_name`, `Middle_name`, `Last_name`, `Mobile_no`, `DOB`, `RTO_Code`, `Pswd`, `LL_number`, `DL_number`) VALUES
(1, 'Dhrumil', 'NileshBhai', 'Trada', '7405810278', '2004-09-22', 10, '0080', 'GJ10/882506/2023', NULL),
(2, 'Ansh', 'Pragnesh', 'Patel', '9988776655', '2004-06-13', 27, '1306', 'GJ27/849213/2023', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `phoneNo` varchar(10) NOT NULL,
  `COV` varchar(50) NOT NULL,
  `numberplate` varchar(50) NOT NULL,
  `RegisDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`phoneNo`, `COV`, `numberplate`, `RegisDate`) VALUES
('9876543219', 'LMV', 'GJ 01 II 2697', '2023-10-06'),
('9874561231', 'MCWOG', 'GJ 05 DP 2205', '2023-10-07'),
('9653278412', 'MCWG', 'GJ 21 CD 2789', '2023-10-07'),
('1234567890', 'MCWOG', 'GJ 23 XY 1234', '2023-10-07'),
('9876543210', 'MCWG', 'GJ 12 AB 5678', '2023-10-07'),
('5555555555', 'LMV', 'GJ 17 MQ 2048', '2023-10-07'),
('8888888888', 'MCWOG', 'GJ 15 PQ 3456', '2023-10-07'),
('7777777777', 'MCWG', 'GJ 04 KL 6789', '2023-10-07'),
('1111111111', 'LMV', 'GJ 31 CD 2345', '2023-10-07'),
('9999999999', 'MCWOG', 'GJ 08 EF 8901', '2023-10-07'),
('6666666666', 'MCWG', 'GJ 27 ST 4567', '2023-10-07'),
('2222222222', 'LMV', 'GJ 19 UV 7890', '2023-10-07'),
('4444444444', 'MCWOG', 'GJ 33 WX 1234', '2023-10-07'),
('5555555555', 'MCWG', 'GJ 17 MQ 2048', '2023-10-07'),
('3333333333', 'LMV', 'GJ 29 MN 2345', '2023-10-07'),
('7777777777', 'MCWOG', 'GJ 06 AB 8901', '2023-10-07'),
('8888888888', 'MCWG', 'GJ 35 CD 4567', '2023-10-07'),
('9999999999', 'LMV', 'GJ 22 EF 7890', '2023-10-07'),
('1111111111', 'MCWOG', 'GJ 10 ST 1234', '2023-10-07'),
('2222222222', 'MCWG', 'GJ 18 UV 5678', '2023-10-07'),
('4444444444', 'LMV', 'GJ 26 WX 2345', '2023-10-07'),
('6666666666', 'MCWOG', 'GJ 02 GH 8901', '2023-10-07'),
('3333333333', 'MCWG', 'GJ 30 MN 4567', '2023-10-07');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_data`
--
ALTER TABLE `user_data`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
