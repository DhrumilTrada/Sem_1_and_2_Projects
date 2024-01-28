-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2023 at 07:46 PM
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
('GJ 01 II 2697', 1000, 'No Helmet');

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
('9876543219', 'LMV', 'GJ 01 II 2697', '2023-10-06');

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
