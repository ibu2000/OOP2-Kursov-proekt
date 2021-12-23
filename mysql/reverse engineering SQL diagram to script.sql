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
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`booksstored`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`booksstored` (
  `total` INT NULL,
  `available` INT NULL,
  `chitalnq` INT NULL,
  `books_idBook` INT NOT NULL,
  INDEX `fk_booksstored_books1_idx` (`books_idBook` ASC) VISIBLE,
  PRIMARY KEY (`books_idBook`),
  CONSTRAINT `fk_booksstored_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`stateofbooks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`stateofbooks` (
  `idState` INT NOT NULL,
  `stateOfBooks` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idState`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`eksemplqri`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`eksemplqri` (
  `isbnUnikalenNomer` INT NOT NULL,
  `STATEOFBOOKS_idState` INT NOT NULL,
  `isItArchived` TINYINT NULL DEFAULT NULL,
  `books_idBook` INT NOT NULL,
  PRIMARY KEY (`isbnUnikalenNomer`, `books_idBook`),
  INDEX `fk_EKSEMPLQRI_STATEOFBOOKS1_idx` (`STATEOFBOOKS_idState` ASC) VISIBLE,
  INDEX `fk_eksemplqri_books1_idx` (`books_idBook` ASC) VISIBLE,
  CONSTRAINT `fk_EKSEMPLQRI_STATEOFBOOKS1`
    FOREIGN KEY (`STATEOFBOOKS_idState`)
    REFERENCES `bookstore`.`stateofbooks` (`idState`),
  CONSTRAINT `fk_eksemplqri_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
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
  `idUser` INT NOT NULL,
  `userName` VARCHAR(30) NULL DEFAULT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  `dateOfUserApproval` DATE NULL DEFAULT NULL,
  `rating` VARCHAR(30) NULL DEFAULT NULL,
  `USERTYPE_idUserType` INT NOT NULL,
  `STATUS_idStatus` INT NOT NULL,
  PRIMARY KEY (`idUser`, `USERTYPE_idUserType`, `STATUS_idStatus`),
  INDEX `fk_USER_USERTYPE1_idx` (`USERTYPE_idUserType` ASC) VISIBLE,
  INDEX `fk_USER_STATUS1_idx` (`STATUS_idStatus` ASC) VISIBLE,
  CONSTRAINT `fk_USER_STATUS1`
    FOREIGN KEY (`STATUS_idStatus`)
    REFERENCES `bookstore`.`status` (`idStatus`),
  CONSTRAINT `fk_USER_USERTYPE1`
    FOREIGN KEY (`USERTYPE_idUserType`)
    REFERENCES `bookstore`.`usertype` (`idUserType`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`form` (
  `idForm` INT NOT NULL,
  `submitionDate` DATE NULL DEFAULT NULL,
  `USER_idUser` INT NOT NULL,
  `content` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`idForm`, `USER_idUser`),
  INDEX `fk_FORM_USER1_idx` (`USER_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_FORM_USER1`
    FOREIGN KEY (`USER_idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`lendbooks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`lendbooks` (
  `idLendBook` INT NOT NULL,
  `dateOfTaking` DATE NULL DEFAULT NULL,
  `USER_idUser` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idLendBook`),
  INDEX `fk_LENDBOOKS_USER1_idx` (`USER_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_LENDBOOKS_USER1`
    FOREIGN KEY (`USER_idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`lendinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`lendinfo` (
  `idLendInfo` INT NOT NULL,
  `lendbooks_idLendBook` INT NOT NULL,
  `books_idBook` INT NOT NULL,
  PRIMARY KEY (`idLendInfo`, `lendbooks_idLendBook`, `books_idBook`),
  INDEX `fk_lendinfo_lendbooks1_idx` (`lendbooks_idLendBook` ASC) VISIBLE,
  INDEX `fk_lendinfo_books1_idx` (`books_idBook` ASC) VISIBLE,
  CONSTRAINT `fk_lendinfo_lendbooks1`
    FOREIGN KEY (`lendbooks_idLendBook`)
    REFERENCES `bookstore`.`lendbooks` (`idLendBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lendinfo_books1`
    FOREIGN KEY (`books_idBook`)
    REFERENCES `bookstore`.`books` (`idBook`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`userinfo` (
  `idUser` INT NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `phone` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  CONSTRAINT `fk_USERINFO_USER1`
    FOREIGN KEY (`idUser`)
    REFERENCES `bookstore`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
