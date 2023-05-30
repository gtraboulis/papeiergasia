
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Cinema_last
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Cinema_last
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cinema_last` DEFAULT CHARACTER SET utf8 ;
USE `Cinema_last` ;

-- -----------------------------------------------------
-- Table `Cinema_last`.`CINEMAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`CINEMAS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `SEATS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`user` (
  `username` VARCHAR(32) NOT NULL,
  `email` VARCHAR(32) NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`CONTENT_ADMIN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`CONTENT_ADMIN` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`ID`, `user_username`),
  INDEX `fk_CONTENT_ADMIN_user1_idx` (`user_username` ASC) VISIBLE,
  CONSTRAINT `fk_CONTENT_ADMIN_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `Cinema_last`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`MOVIES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`MOVIES` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `CONTENT` VARCHAR(45) NOT NULL,
  `DIRECTOR` VARCHAR(45) NOT NULL,
  `CONTENT_ADMIN_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `NAME`, `CONTENT_ADMIN_ID`),
  INDEX `fk_MOVIES_CONTENT_ADMIN1_idx` (`CONTENT_ADMIN_ID` ASC) VISIBLE,
  CONSTRAINT `fk_MOVIES_CONTENT_ADMIN1`
    FOREIGN KEY (`CONTENT_ADMIN_ID`)
    REFERENCES `Cinema_last`.`CONTENT_ADMIN` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`PROVOLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`PROVOLES` (
  `MOVIES_ID` INT NOT NULL,
  `MOVIES_NAME` VARCHAR(45) NOT NULL,
  `CINEMAS_ID` INT NOT NULL,
  `ID` VARCHAR(45) NOT NULL,
  `CONTENT_ADMIN_ID` INT NOT NULL,
  PRIMARY KEY (`MOVIES_ID`, `MOVIES_NAME`, `CINEMAS_ID`, `CONTENT_ADMIN_ID`),
  INDEX `fk_MOVIES_has_CINEMAS_CINEMAS1_idx` (`CINEMAS_ID` ASC) VISIBLE,
  INDEX `fk_MOVIES_has_CINEMAS_MOVIES_idx` (`MOVIES_ID` ASC, `MOVIES_NAME` ASC) VISIBLE,
  INDEX `fk_PROVOLES_CONTENT_ADMIN1_idx` (`CONTENT_ADMIN_ID` ASC) VISIBLE,
  CONSTRAINT `fk_MOVIES_has_CINEMAS_MOVIES`
    FOREIGN KEY (`MOVIES_ID` , `MOVIES_NAME`)
    REFERENCES `Cinema_last`.`MOVIES` (`ID` , `NAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MOVIES_has_CINEMAS_CINEMAS1`
    FOREIGN KEY (`CINEMAS_ID`)
    REFERENCES `Cinema_last`.`CINEMAS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROVOLES_CONTENT_ADMIN1`
    FOREIGN KEY (`CONTENT_ADMIN_ID`)
    REFERENCES `Cinema_last`.`CONTENT_ADMIN` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`CUSTOMERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`CUSTOMERS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`ID`, `user_username`),
  INDEX `fk_CUSTOMERS_user1_idx` (`user_username` ASC) VISIBLE,
  CONSTRAINT `fk_CUSTOMERS_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `Cinema_last`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`RESERVATIONS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`RESERVATIONS` (
  `PROVOLES_MOVIES_ID` INT NOT NULL,
  `PROVOLES_MOVIES_NAME` VARCHAR(45) NOT NULL,
  `PROVOLES_CINEMAS_ID` INT NOT NULL,
  `CUSTOMERS_ID` INT NOT NULL,
  `NUMBER_OF_SEATS` INT NOT NULL,
  PRIMARY KEY (`PROVOLES_MOVIES_ID`, `PROVOLES_MOVIES_NAME`, `PROVOLES_CINEMAS_ID`, `CUSTOMERS_ID`),
  INDEX `fk_PROVOLES_has_CUSTOMERS_CUSTOMERS1_idx` (`CUSTOMERS_ID` ASC) VISIBLE,
  INDEX `fk_PROVOLES_has_CUSTOMERS_PROVOLES1_idx` (`PROVOLES_MOVIES_ID` ASC, `PROVOLES_MOVIES_NAME` ASC, `PROVOLES_CINEMAS_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PROVOLES_has_CUSTOMERS_PROVOLES1`
    FOREIGN KEY (`PROVOLES_MOVIES_ID` , `PROVOLES_MOVIES_NAME` , `PROVOLES_CINEMAS_ID`)
    REFERENCES `Cinema_last`.`PROVOLES` (`MOVIES_ID` , `MOVIES_NAME` , `CINEMAS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROVOLES_has_CUSTOMERS_CUSTOMERS1`
    FOREIGN KEY (`CUSTOMERS_ID`)
    REFERENCES `Cinema_last`.`CUSTOMERS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinema_last`.`ADMINS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinema_last`.`ADMINS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`ID`, `user_username`),
  INDEX `fk_ADMINS_user1_idx` (`user_username` ASC) VISIBLE,
  CONSTRAINT `fk_ADMINS_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `Cinema_last`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
