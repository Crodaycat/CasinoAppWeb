-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Servidor: sql10.freemysqlhosting.net
-- Tiempo de generación: 29-11-2017 a las 04:39:18
-- Versión del servidor: 5.5.53-0ubuntu0.14.04.1
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sql10207113`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `award`
--

CREATE TABLE `award` (
  `id` int(11) NOT NULL,
  `machineType` int(11) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `award`
--

INSERT INTO `award` (`id`, `machineType`, `price`, `description`) VALUES
(1, 5, 150000, 'Triple red 7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Dealer`
--

CREATE TABLE `Dealer` (
  `id` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `workedHourPrice` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FinancialProfit`
--

CREATE TABLE `FinancialProfit` (
  `id` int(11) NOT NULL,
  `baccara` float NOT NULL,
  `rulete` float NOT NULL,
  `blackjack` float NOT NULL,
  `poker` float NOT NULL,
  `date` varchar(15) NOT NULL,
  `marginProfitBaccara` int(11) NOT NULL,
  `marginProfitBlacjack` int(11) NOT NULL,
  `marginProfitPoker` int(11) NOT NULL,
  `marginProfitRulete` int(11) NOT NULL,
  `financialProfit` float NOT NULL,
  `dealerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameHistory`
--

CREATE TABLE `GameHistory` (
  `idGameHistory` int(11) NOT NULL,
  `moneyCollected` float NOT NULL,
  `machineId` int(11) NOT NULL,
  `awardId` int(11) NOT NULL,
  `awardPrice` float NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `machine`
--

CREATE TABLE `machine` (
  `serie` int(11) NOT NULL,
  `machineType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `machine`
--

INSERT INTO `machine` (`serie`, `machineType`) VALUES
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `machinetype`
--

CREATE TABLE `machinetype` (
  `id` int(11) NOT NULL,
  `description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `machinetype`
--

INSERT INTO `machinetype` (`id`, `description`) VALUES
(5, 'prueba'),
(6, 'DanielSan');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `award`
--
ALTER TABLE `award`
  ADD PRIMARY KEY (`id`,`price`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `machineType_idx` (`machineType`);

--
-- Indices de la tabla `Dealer`
--
ALTER TABLE `Dealer`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `FinancialProfit`
--
ALTER TABLE `FinancialProfit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dealerId` (`dealerId`);

--
-- Indices de la tabla `GameHistory`
--
ALTER TABLE `GameHistory`
  ADD PRIMARY KEY (`idGameHistory`),
  ADD UNIQUE KEY `idGameHistory_UNIQUE` (`idGameHistory`),
  ADD KEY `historyMachineId_idx` (`machineId`),
  ADD KEY `historyAwardId_idx` (`awardId`,`awardPrice`);

--
-- Indices de la tabla `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`serie`),
  ADD UNIQUE KEY `id_UNIQUE` (`serie`),
  ADD KEY `machinetype_idx` (`machineType`);

--
-- Indices de la tabla `machinetype`
--
ALTER TABLE `machinetype`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `award`
--
ALTER TABLE `award`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Dealer`
--
ALTER TABLE `Dealer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `GameHistory`
--
ALTER TABLE `GameHistory`
  MODIFY `idGameHistory` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `machine`
--
ALTER TABLE `machine`
  MODIFY `serie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `machinetype`
--
ALTER TABLE `machinetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `award`
--
ALTER TABLE `award`
  ADD CONSTRAINT `machineTypeAward` FOREIGN KEY (`machineType`) REFERENCES `machinetype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `FinancialProfit`
--
ALTER TABLE `FinancialProfit`
  ADD CONSTRAINT `FinancialProfit_ibfk_1` FOREIGN KEY (`dealerId`) REFERENCES `Dealer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `GameHistory`
--
ALTER TABLE `GameHistory`
  ADD CONSTRAINT `historyMachineId` FOREIGN KEY (`machineId`) REFERENCES `machine` (`serie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historyAwardId` FOREIGN KEY (`awardId`,`awardPrice`) REFERENCES `award` (`id`, `price`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `machine`
--
ALTER TABLE `machine`
  ADD CONSTRAINT `machinetype` FOREIGN KEY (`machineType`) REFERENCES `machinetype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
