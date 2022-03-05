-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.7.3-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para db_microservicio_encuesta
CREATE DATABASE IF NOT EXISTS `db_microservicio_encuesta` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_microservicio_encuesta`;

-- Volcando estructura para tabla db_microservicio_encuesta.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `cliente_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `primer_apellido` varchar(255) DEFAULT NULL,
  `primer_nombre` varchar(255) DEFAULT NULL,
  `segundo_apellido` varchar(255) DEFAULT NULL,
  `segundo_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_microservicio_encuesta.encuesta
CREATE TABLE IF NOT EXISTS `encuesta` (
  `encuesta_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_encuesta` datetime(6) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`encuesta_id`),
  KEY `FKldb5g4lvvkcguy5c64mykipw5` (`cliente_id`),
  CONSTRAINT `FKldb5g4lvvkcguy5c64mykipw5` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_microservicio_encuesta.items_pregunta
CREATE TABLE IF NOT EXISTS `items_pregunta` (
  `items_pregunta_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opcion` varchar(255) DEFAULT NULL,
  `pregunta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`items_pregunta_id`),
  KEY `FK1tmd2ftacxnmrj2etc186bsme` (`pregunta_id`),
  CONSTRAINT `FK1tmd2ftacxnmrj2etc186bsme` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`pregunta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_microservicio_encuesta.pregunta
CREATE TABLE IF NOT EXISTS `pregunta` (
  `pregunta_id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `tipo_pregunta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pregunta_id`),
  KEY `FKhvtb6ih519307jp6dthfhh5he` (`tipo_pregunta_id`),
  CONSTRAINT `FKhvtb6ih519307jp6dthfhh5he` FOREIGN KEY (`tipo_pregunta_id`) REFERENCES `tipo_pregunta` (`tipo_pregunta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_microservicio_encuesta.respuesta_x_pregunta
CREATE TABLE IF NOT EXISTS `respuesta_x_pregunta` (
  `respuesta_x_pregunta_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(255) DEFAULT NULL,
  `respuesta` varchar(255) DEFAULT NULL,
  `encuesta_id` int(11) DEFAULT NULL,
  `pregunta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`respuesta_x_pregunta_id`),
  KEY `FK6jp4ew9wkufj00e0xj0h8tbb4` (`encuesta_id`),
  KEY `FK2nj2pe4hxw4y0p5d0ir6wywjx` (`pregunta_id`),
  CONSTRAINT `FK2nj2pe4hxw4y0p5d0ir6wywjx` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`pregunta_id`),
  CONSTRAINT `FK6jp4ew9wkufj00e0xj0h8tbb4` FOREIGN KEY (`encuesta_id`) REFERENCES `encuesta` (`encuesta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla db_microservicio_encuesta.tipo_pregunta
CREATE TABLE IF NOT EXISTS `tipo_pregunta` (
  `tipo_pregunta_id` int(11) NOT NULL AUTO_INCREMENT,
  `detalle_tipo_pregunta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tipo_pregunta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
