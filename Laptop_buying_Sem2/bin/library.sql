-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2023 at 08:35 PM
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
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `Bookid` int(5) NOT NULL,
  `bookno` varchar(20) NOT NULL,
  `bookname` varchar(70) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `quantity` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`Bookid`, `bookno`, `bookname`, `author`, `publisher`, `quantity`) VALUES
(1, 'T@1', 'Engineering Mathematics', 'Tapan Kar', 'Santra', 30),
(2, 'B@3', 'Programming With Java', 'E Balagurusamy', 'McGraw Hill', 49),
(3, 'R@4', 'Applied Mechanics', 'R.S.Salaria', 'Khanna', 40),
(4, 'D@4', 'Programming In Python', 'R.K.Dhawan', 'S.Chand', 45),
(5, 'A@2', 'All In One', 'Balasubramaniya', 'Arihant', 23);

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `Bookid` int(5) NOT NULL,
  `bookno` varchar(20) NOT NULL,
  `bookname` varchar(70) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `sid` int(10) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `contactno` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`Bookid`, `bookno`, `bookname`, `author`, `publisher`, `sid`, `sname`, `contactno`) VALUES
(1, 'T@1', 'Engineering Mathematics', 'Tapan Kar', 'Santra', 125, 'Hitexa Ingle', '9867546543'),
(4, 'D@4', 'Programming In Python', 'R.K.Dhawan', 'S.Chand', 25, 'Dhrumil Patel', '9767543245'),
(2, 'B@3', 'Programming With Java', 'E Balagurusamy', 'McGraw Hill', 127, 'Leepy Shah', '9432532875'),
(1, 'T@1', 'Engineering Mathematics', 'Tapan Kar', 'Santra', 25, 'Dhrumil Patel', '9767543245'),
(2, 'B@3', 'Programming With Java', 'E Balagurusamy', 'McGraw Hill', 125, 'Hitexa Ingle', '9867546543');

-- --------------------------------------------------------

--
-- Table structure for table `librarian_information`
--

CREATE TABLE `librarian_information` (
  `id` int(5) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `contact_no` bigint(15) NOT NULL,
  `City` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `librarian_information`
--

INSERT INTO `librarian_information` (`id`, `Name`, `Password`, `Email`, `contact_no`, `City`) VALUES
(1, 'Dhrumil Trada', 'dhrumilT@22', 'tradadhrumil@gmail.com', 9876543213, 'Jamnagar'),
(2, 'Uma Joshi', 'UmaJ@4321', 'umajoshi@gmail.com', 9457573646, 'Ahemdabad');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sid` int(5) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `sem` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sid`, `sname`, `contactno`, `sem`) VALUES
(25, 'Dhrumil Patel', '9767543245', 'CE'),
(125, 'Hitexa Ingle', '9867546543', 'CE'),
(127, 'Leepy Shah', '9432532875', 'CE'),
(134, 'Shreya Shah', '7564236565', 'IT'),
(129, 'Hitanshi Gajjar', '9867546543', 'CSE'),
(148, 'Jiya Shah', '7546737982', 'CE'),
(165, 'Parth Prajapati', '9656443267', 'CSE');

-- --------------------------------------------------------

--
-- Table structure for table `viewbooks`
--

CREATE TABLE `viewbooks` (
  `Bookid` int(5) NOT NULL,
  `bookno` varchar(20) NOT NULL,
  `bookname` varchar(70) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `quantity` int(50) NOT NULL,
  `issuedBy` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `viewbooks`
--

INSERT INTO `viewbooks` (`Bookid`, `bookno`, `bookname`, `author`, `publisher`, `quantity`, `issuedBy`) VALUES
(1, 'T@1', 'Engineering Mathematics', 'Tapan Kar', 'Santra', 30, 0),
(2, 'B@3', 'Programming With Java', 'E Balagurusamy', 'McGraw Hill', 49, 1),
(3, 'R@4', 'Applied Mechanics', 'R.S.Salaria', 'Khanna', 40, 0),
(4, 'D@4', 'Programming In Python', 'R.K.Dhawan', 'S.Chand', 45, 0),
(5, 'A@2', 'All In One', 'Balasubramaniya', 'Arihant', 23, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`Bookid`);

--
-- Indexes for table `librarian_information`
--
ALTER TABLE `librarian_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `viewbooks`
--
ALTER TABLE `viewbooks`
  ADD PRIMARY KEY (`Bookid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `Bookid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `librarian_information`
--
ALTER TABLE `librarian_information`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `viewbooks`
--
ALTER TABLE `viewbooks`
  MODIFY `Bookid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
