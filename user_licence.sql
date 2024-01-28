-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2023 at 06:31 PM
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
-- Database: `licence_creation`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_licence`
--

CREATE TABLE `user_licence` (
  `User_id` int(11) NOT NULL,
  `First_name` varchar(20) NOT NULL,
  `Middle_name` varchar(20) NOT NULL,
  `Last_name` varchar(20) NOT NULL,
  `Mobile_no` varchar(10) NOT NULL,
  `DOB` varchar(10) NOT NULL,
  `RTO_Code` int(11) NOT NULL,
  `LL_number` varchar(20) NOT NULL,
  `DL_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_licence`
--

INSERT INTO `user_licence` (`User_id`, `First_name`, `Middle_name`, `Last_name`, `Mobile_no`, `DOB`, `RTO_Code`, `LL_number`, `DL_number`) VALUES
(1, 'Dhrumil', 'NileshBhai', 'Trada', '7405810278', '2004-09-22', 10, '1234567890', '0987654321');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_licence`
--
ALTER TABLE `user_licence`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_licence`
--
ALTER TABLE `user_licence`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
