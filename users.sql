-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 04:39 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `userType` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `firstName`, `lastName`, `nic`, `userType`, `email`, `phoneNumber`, `password`) VALUES
(3, 'manudi', 'Wijethunga', '987670983v', 'Both', 'saduni12@gmail.com', '726677878', 'saduni12'),
(4, 'Tharushi', 'Ranasingha', '708976555V', 'Buyer', 'tharu2gmail.com', '812288999', 'Tharu12'),
(8, 'Hemal', 'Piyumal', '988766590V', 'Seller', 'nipun12@gmail.com', '715556778', 'nipun12'),
(10, 'Rashini', 'Dinelka', '808976555V', 'Buyer', 'ranjika12gmail.com', '812221111', 'ranjika128'),
(15, 'Ashani', 'Savishka', '977621348V', 'Buyer', 'savishka12@gmail.com', '715878555', 'asani89'),
(16, 'Lihini', 'Nethmini', '888745222V', 'Buyer', 'lihini123@gmail.com', '223656868', 'lihini987'),
(17, 'Hashini', 'Gunathunga', '807452221V', 'Seller', 'hashinii123@gmail.com', '114016868', 'hashini145'),
(22, 'lakshi', 'Gunathunga', '966545888V', 'Seller', 'hashinii123@gmail.com', '711523162', 'hashini145'),
(23, 'Shehani', 'Wanigasekara', '988754555V', 'Buyer', 'shehani123@gmail.com', '812233454', 'hashini145'),
(24, 'Gihan', 'Perera', '977642111V', 'Buyer', 'gihan12@gmail.com', '812242211', 'perera145'),
(29, 'a', 'a', '455415444V', '0114545777', 'a', 'a', 'a'),
(31, 'manudi', 'Wijethunga', '907670983v', 'Both', 'saduni12@gmail.com', '726677878', 'saduni12'),
(33, 'aad', 'd', '584888588V', '1234568962', 'ds@gmail.com', 'dd', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `nic` (`nic`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
