-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2023 at 05:47 AM
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
-- Database: `laptop_inventory`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetch_details` (IN `User` VARCHAR(20), OUT `Mobile` VARCHAR(10), OUT `Save_p` BOOLEAN, OUT `Pinn` INT)   BEGIN
select Mobile_no, Save_pass, pin into Mobile, Save_p, Pinn from users_mob where Username = User;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_saved_pin` (IN `User` VARCHAR(20), OUT `Mobile` VARCHAR(10), OUT `Save_p` BOOLEAN, OUT `Pinn` INT)   BEGIN
select Mobile_no, Save_pass, pin into Mobile, Save_p, Pinn from users_mob where Username = User;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `asus`
--

CREATE TABLE `asus` (
  `Lap_id` varchar(10) NOT NULL,
  `Lap_filename` varchar(40) NOT NULL,
  `Lap_content` text NOT NULL,
  `Lap_image` longblob NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dell`
--

CREATE TABLE `dell` (
  `Lap_id` varchar(10) NOT NULL,
  `Lap_filename` varchar(40) NOT NULL,
  `Lap_content` text NOT NULL,
  `Lap_image` longblob NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hp`
--

CREATE TABLE `hp` (
  `Lap_id` varchar(10) NOT NULL,
  `Lap_filename` varchar(40) NOT NULL,
  `Lap_content` text NOT NULL,
  `Lap_image` longblob NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lenovo`
--

CREATE TABLE `lenovo` (
  `Lap_id` varchar(10) NOT NULL,
  `Lap_filename` varchar(40) NOT NULL,
  `Lap_content` text NOT NULL,
  `Lap_image` longblob NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `msi`
--

CREATE TABLE `msi` (
  `Lap_id` varchar(10) NOT NULL,
  `Lap_filename` varchar(40) NOT NULL,
  `Lap_content` text NOT NULL,
  `Lap_image` longblob NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users_mob`
--

CREATE TABLE `users_mob` (
  `User_id` int(11) NOT NULL,
  `Username` varchar(40) NOT NULL,
  `Mobile_no` varchar(10) NOT NULL,
  `Save_pass` tinyint(1) NOT NULL,
  `Pin` int(11) NOT NULL,
  `Discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_mob`
--

INSERT INTO `users_mob` (`User_id`, `Username`, `Mobile_no`, `Save_pass`, `Pin`, `Discount`) VALUES
(1, 'Dhrumil_22', '7405810278', 1, 2315, 0),
(2, 'Hitexa_04', '6352323976', 0, 7807, 30),
(4, 'Dhrumil_10', '6352323975', 1, 1646, 35);

-- --------------------------------------------------------

--
-- Table structure for table `user_orders`
--

CREATE TABLE `user_orders` (
  `User_id` int(11) NOT NULL,
  `Username` varchar(40) NOT NULL,
  `Mobile_no` varchar(10) NOT NULL,
  `Order_history` text NOT NULL,
  `Amount` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_orders`
--

INSERT INTO `user_orders` (`User_id`, `Username`, `Mobile_no`, `Order_history`, `Amount`) VALUES
(2, 'Dhrumil_22', '7405810278', '                        Cart for User Dhrumil_22\r\n|Laptop name:ROG Zephyrus 2022           No of cores:8              Refresh rate:300 Hz  |\r\n|Processor:Intel i-12 12th Generation          RAM Size:16              Display size:14 inches |\r\n|Graphics card:GeForce RTX 3060Ti          RAM type:DDR6          Price:125000         |\r\n                               Product Key: 3\r\n                          Final Amount = 170000.0\r\n', 1015920),
(3, 'Akshat_05', '6359531000', '                        Cart for User Dhrumil_22\r\n|Laptop name:ROG Zephyrus 2022           No of cores:8              Refresh rate:300 Hz  |\r\n|Processor:Intel i-12 12th Generation          RAM Size:16              Display size:14 inches |\r\n|Graphics card:GeForce RTX 3060Ti          RAM type:DDR6          Price:125000         |\r\n                               Product Key: 3\r\n                          Final Amount = 170000.0\r\n', 516800),
(4, 'Hitexa_04', '6352323976', '                        Cart for User Dhrumil_22\r\n|Laptop name:ROG Zephyrus 2022           No of cores:8              Refresh rate:300 Hz  |\r\n|Processor:Intel i-12 12th Generation          RAM Size:16              Display size:14 inches |\r\n|Graphics card:GeForce RTX 3060Ti          RAM type:DDR6          Price:125000         |\r\n                               Product Key: 3\r\n                          Final Amount = 170000.0\r\n', 535840);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asus`
--
ALTER TABLE `asus`
  ADD PRIMARY KEY (`Lap_id`);

--
-- Indexes for table `dell`
--
ALTER TABLE `dell`
  ADD PRIMARY KEY (`Lap_id`);

--
-- Indexes for table `lenovo`
--
ALTER TABLE `lenovo`
  ADD PRIMARY KEY (`Lap_id`);

--
-- Indexes for table `msi`
--
ALTER TABLE `msi`
  ADD PRIMARY KEY (`Lap_id`);

--
-- Indexes for table `users_mob`
--
ALTER TABLE `users_mob`
  ADD PRIMARY KEY (`User_id`);

--
-- Indexes for table `user_orders`
--
ALTER TABLE `user_orders`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users_mob`
--
ALTER TABLE `users_mob`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_orders`
--
ALTER TABLE `user_orders`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
