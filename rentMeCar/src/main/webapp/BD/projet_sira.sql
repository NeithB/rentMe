-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 23 mars 2024 à 22:13
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_sira`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `id_agence` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `cp` int DEFAULT NULL,
  `ville` varchar(15) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_agence`),
  UNIQUE KEY `nom` (`nom`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id_agence`, `nom`, `tel`, `email`, `adresse`, `cp`, `ville`, `image`) VALUES
(20, 'Barone Location', '745547068', 'barone@gmail.com', '13 avenue victo', 745547068, 'nangis', 'img6.jpg'),
(21, 'Louve', '745547068', 'louve@gmail.com', '13 avenue victo', 745547068, 'nangis', 'istockphoto-1029201576-1024x1024.jpg'),
(22, 'trimer Agence', '9877655', 'trimer@gmail.com', '13 avenue victo', 9877655, 'Essones', 'img5.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id_location` int NOT NULL AUTO_INCREMENT,
  `id_client` int DEFAULT NULL,
  `id_vehicule` int DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `total` float(10,2) DEFAULT NULL,
  `dateReservation` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_location`),
  KEY `location_ibfk_1` (`id_client`),
  KEY `location_ibfk_2` (`id_vehicule`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id_location`, `id_client`, `id_vehicule`, `dateDebut`, `dateFin`, `total`, `dateReservation`) VALUES
(1, 42, 5, '2023-12-09', '2023-12-01', 200.00, '2023-12-09 00:00:00'),
(14, 43, NULL, '2023-12-11', '2023-12-12', 123.00, '2023-12-10 00:00:00'),
(15, 43, 5, '2023-12-15', '2023-12-16', 200.00, '2023-12-13 00:00:00'),
(16, 42, 6, '2023-12-14', '2023-12-15', 123.00, '2023-12-14 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id_membre` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `login` varchar(8) DEFAULT NULL,
  `mdp` varchar(100) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `cp` int DEFAULT NULL,
  `ville` varchar(15) DEFAULT NULL,
  `statut` enum('CLIENT','ADMIN') DEFAULT 'CLIENT',
  `date_inscription` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_membre`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`id_membre`, `prenom`, `nom`, `login`, `mdp`, `tel`, `email`, `adresse`, `cp`, `ville`, `statut`, `date_inscription`) VALUES
(42, 'Neith Jurel Die', 'BITISSI', 'ilci', 'ilci', '745547068', 'shakstrimer@gma', '13 avenue victo', 77370, 'nangis', 'ADMIN', '2023-12-15 00:00:00'),
(43, 'Back', 'Girl', 'black', 'black', '745547068', 'black@gmail.com', '13 avenue victo', 77370, 'nangis', 'CLIENT', '2023-12-10 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `id_vehicule` int NOT NULL AUTO_INCREMENT,
  `marque` varchar(20) NOT NULL,
  `modele` varchar(20) DEFAULT NULL,
  `prix_journalier` float(5,2) DEFAULT NULL,
  `description` text,
  `image` varchar(50) DEFAULT NULL,
  `agence` int DEFAULT NULL,
  PRIMARY KEY (`id_vehicule`),
  KEY `agence` (`agence`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id_vehicule`, `marque`, `modele`, `prix_journalier`, `description`, `image`, `agence`) VALUES
(1, 'toyota', 'mflff', 200.00, 'kkeoee', 'img7.jpg', 20),
(5, 'eagttd', 'uufufi', 200.00, 'hhud', 'pexels-raphael-loquellano-8980830.jpg', 21),
(6, 'beachgtd', 'filmzyz', 123.00, 'patienceyz', 'pexels-sarmad-mughal-305070.jpg', 20),
(8, 'hdyioz', 'mqis', 123.00, 'kjzzkz', 'pexels-mike-bird-120049.jpg', 21),
(9, 'yeuizoze', 'izeoopezpze', 123.00, 'jkezkezez', 'pexels-mike-bird-170811.jpg', 21);

-- --------------------------------------------------------

--
-- Structure de la table `vhcdispo`
--

DROP TABLE IF EXISTS `vhcdispo`;
CREATE TABLE IF NOT EXISTS `vhcdispo` (
  `idDisp` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `vhcdispo`
--

INSERT INTO `vhcdispo` (`idDisp`) VALUES
(1),
(5),
(8),
(9);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `membre` (`id_membre`) ON DELETE SET NULL ON UPDATE RESTRICT,
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`) ON DELETE SET NULL ON UPDATE RESTRICT;

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`agence`) REFERENCES `agence` (`id_agence`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
