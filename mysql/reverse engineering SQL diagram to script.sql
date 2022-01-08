-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bookstore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookstore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bookstore` ;

-- -----------------------------------------------------
-- Table `bookstore`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`books` (
  `idBook` INT NOT NULL AUTO_INCREMENT,
  `bookName` VARCHAR(30) NULL DEFAULT NULL,
  `author` VARCHAR(40) NULL DEFAULT NULL,
  `genre` VARCHAR(30) NULL DEFAULT NULL,
  `yearOfPublishing` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idBook`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`booksstored`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`booksstored` (
  `total` INT NULL DEFAULT NULL,
  `available` INT NULL DEFAULT NULL,
  `chitalnq` INT NULL DEFAULT NULL,
  `books_idBook` INT NOT NULL,
  PRIMARY KEY (`books_idBook`),
  CONSTRAINT `fk_booksstored_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`stateofbooks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`stateofbooks` (
  `idState` INT NOT NULL AUTO_INCREMENT,
  `stateOfBooks` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idState`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`eksemplqri`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`eksemplqri` (
  `isbnUnikalenNomer` INT NOT NULL AUTO_INCREMENT,
  `STATEOFBOOKS_idState` INT NOT NULL,
  `isItArchived` TINYINT NULL DEFAULT NULL,
  `books_idBook` INT NOT NULL,
  `isitAvailable` TINYINT NULL DEFAULT NULL,
  `copyDate` DATE NULL,
  PRIMARY KEY (`isbnUnikalenNomer`),
  INDEX `fk_EKSEMPLQRI_STATEOFBOOKS1_idx` (`STATEOFBOOKS_idState` ASC) VISIBLE,
  INDEX `fk_eksemplqri_books1_idx` (`books_idBook` ASC) VISIBLE,
  CONSTRAINT `fk_eksemplqri_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`),
  CONSTRAINT `fk_EKSEMPLQRI_STATEOFBOOKS1`
    FOREIGN KEY (`STATEOFBOOKS_idState`)
    REFERENCES `bookstore`.`stateofbooks` (`idState`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`status` (
  `idStatus` INT NOT NULL,
  `status` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idStatus`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`usertype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`usertype` (
  `idUserType` INT NOT NULL,
  `userType` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idUserType`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(30) NULL DEFAULT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  `dateOfUserApproval` DATE NULL DEFAULT NULL,
  `rating` VARCHAR(30) NULL DEFAULT NULL,
  `status_idStatus` INT NOT NULL,
  `usertype_idUserType` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_user_status1_idx` (`status_idStatus` ASC) VISIBLE,
  INDEX `fk_user_usertype1_idx` (`usertype_idUserType` ASC) VISIBLE,
  CONSTRAINT `fk_user_status1`
    FOREIGN KEY (`status_idStatus`)
    REFERENCES `bookstore`.`status` (`idStatus`),
  CONSTRAINT `fk_user_usertype1`
    FOREIGN KEY (`usertype_idUserType`)
    REFERENCES `bookstore`.`usertype` (`idUserType`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`form` (
  `idForm` INT NOT NULL AUTO_INCREMENT,
  `submitionDate` DATE NULL DEFAULT NULL,
  `content` VARCHAR(300) NULL DEFAULT NULL,
  `user_idUser` INT NOT NULL,
  PRIMARY KEY (`idForm`),
  INDEX `fk_form_user1_idx` (`user_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_form_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`lendbooks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`lendbooks` (
  `idLendBook` INT NOT NULL AUTO_INCREMENT,
  `dateOfTaking` DATE NULL DEFAULT NULL,
  `user_idUser` INT NOT NULL,
  `dateOfReturn` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idLendBook`),
  INDEX `fk_lendbooks_user1_idx` (`user_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_lendbooks_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`lendinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`lendinfo` (
  `idLendInfo` INT NOT NULL AUTO_INCREMENT,
  `lendbooks_idLendBook` INT NOT NULL,
  `books_idBook` INT NOT NULL,
  `eksemplqri_isbnUnikalenNomer` INT NOT NULL,
  `inChitalnq` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`idLendInfo`, `eksemplqri_isbnUnikalenNomer`),
  INDEX `fk_lendinfo_lendbooks1_idx` (`lendbooks_idLendBook` ASC) VISIBLE,
  INDEX `fk_lendinfo_books1_idx` (`books_idBook` ASC) VISIBLE,
  INDEX `fk_lendinfo_eksemplqri1_idx` (`eksemplqri_isbnUnikalenNomer` ASC) VISIBLE,
  CONSTRAINT `fk_lendinfo_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`),
  CONSTRAINT `fk_lendinfo_eksemplqri1`
    FOREIGN KEY (`eksemplqri_isbnUnikalenNomer`)
    REFERENCES `bookstore`.`eksemplqri` (`isbnUnikalenNomer`),
  CONSTRAINT `fk_lendinfo_lendbooks1`
    FOREIGN KEY (`lendbooks_idLendBook`)
    REFERENCES `bookstore`.`lendbooks` (`idLendBook`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`userinfo` (
  `user_idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `phone` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`user_idUser`),
  INDEX `fk_userinfo_user1_idx` (`user_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_userinfo_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
