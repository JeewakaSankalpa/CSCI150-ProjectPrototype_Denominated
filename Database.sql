-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ClassManager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ClassManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ClassManager` DEFAULT CHARACTER SET utf8 ;
USE `ClassManager` ;

-- -----------------------------------------------------
-- Table `ClassManager`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Student` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Student` (
  `Student_ID` INT NOT NULL,
  `Student_First_Name` VARCHAR(45) NULL,
  `Student_Last_Name` VARCHAR(45) NULL,
  `Student_Middle_Initial` VARCHAR(45) NULL,
  `Student_Address_1` VARCHAR(200) NULL,
  `Student_Address_2` VARCHAR(150) NULL,
  `Student_Mobile_No` VARCHAR(45) NULL,
  PRIMARY KEY (`Student_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Faculty` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Faculty` (
  `Faculty_ID` INT NOT NULL,
  `Faculty_First_Name` VARCHAR(45) NULL,
  `Faculty_Last_Name` VARCHAR(45) NULL,
  `Faculty_Middle_Initial` VARCHAR(45) NULL,
  `Faculty_Address_1` VARCHAR(200) NULL,
  `Faculty_Mobile_No` VARCHAR(45) NULL,
  `AcessLevel` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  PRIMARY KEY (`Faculty_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Subject` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Subject` (
  `Subject_ID` VARCHAR(12) NOT NULL,
  `Subject_Name` VARCHAR(45) NULL,
  `Subject_Description` VARCHAR(300) NULL,
  PRIMARY KEY (`Subject_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Class` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Class` (
  `Classs_ID` INT NOT NULL,
  `Faculty_Faculty_ID` INT NOT NULL,
  `Subject_Subject_ID` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`Classs_ID`),
  INDEX `fk_Class_Faculty_idx` (`Faculty_Faculty_ID` ASC),
  INDEX `fk_Class_Subject1_idx` (`Subject_Subject_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Attendance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Attendance` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Attendance` (
  `Date` DATE NOT NULL,
  `Class_Classs_ID` INT NOT NULL,
  `Attendance` TINYINT(1) NULL,
  `Student_Student_ID` INT NOT NULL,
  PRIMARY KEY (`Date`, `Class_Classs_ID`, `Student_Student_ID`),
  INDEX `fk_Attendance_Class1_idx` (`Class_Classs_ID` ASC),
  INDEX `fk_Attendance_Student1_idx` (`Student_Student_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Shedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Shedule` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Shedule` (
  `Student_Student_ID` INT NOT NULL,
  `Class_Classs_ID` INT NOT NULL,
  PRIMARY KEY (`Student_Student_ID`, `Class_Classs_ID`),
  INDEX `fk_Shedule4_Class1_idx` (`Class_Classs_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ClassManager`.`Class_Times`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ClassManager`.`Class_Times` ;

CREATE TABLE IF NOT EXISTS `ClassManager`.`Class_Times` (
  `Class_Classs_ID` INT NOT NULL,
  `Day` VARCHAR(45) NULL,
  `Start_Time` TIME NULL,
  `End_Time` TIME NULL,
  PRIMARY KEY (`Class_Classs_ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ClassManager`.`Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Student` (`Student_ID`, `Student_First_Name`, `Student_Last_Name`, `Student_Middle_Initial`, `Student_Address_1`, `Student_Address_2`, `Student_Mobile_No`) VALUES (111, 'A', 'B', 'C', '11', '', NULL);
INSERT INTO `ClassManager`.`Student` (`Student_ID`, `Student_First_Name`, `Student_Last_Name`, `Student_Middle_Initial`, `Student_Address_1`, `Student_Address_2`, `Student_Mobile_No`) VALUES (222, 'B', 'D', 'E', '22', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Faculty`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Faculty` (`Faculty_ID`, `Faculty_First_Name`, `Faculty_Last_Name`, `Faculty_Middle_Initial`, `Faculty_Address_1`, `Faculty_Mobile_No`, `AcessLevel`, `Password`) VALUES (111, 'A', 'BC', 'DE', '1', '11', 'Admin', 'Test');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Subject`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Subject` (`Subject_ID`, `Subject_Name`, `Subject_Description`) VALUES ('111', 'ABC', '........................');
INSERT INTO `ClassManager`.`Subject` (`Subject_ID`, `Subject_Name`, `Subject_Description`) VALUES ('222', 'def', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Class`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Class` (`Classs_ID`, `Faculty_Faculty_ID`, `Subject_Subject_ID`) VALUES (111, 111, '111');
INSERT INTO `ClassManager`.`Class` (`Classs_ID`, `Faculty_Faculty_ID`, `Subject_Subject_ID`) VALUES (222, 222, '222');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Attendance`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Attendance` (`Date`, `Class_Classs_ID`, `Attendance`, `Student_Student_ID`) VALUES ('2014-10-15', 111, 1, 111);
INSERT INTO `ClassManager`.`Attendance` (`Date`, `Class_Classs_ID`, `Attendance`, `Student_Student_ID`) VALUES ('2014-11-15', 111, 0, 111);
INSERT INTO `ClassManager`.`Attendance` (`Date`, `Class_Classs_ID`, `Attendance`, `Student_Student_ID`) VALUES ('2014-10-15', 222, 1, 222);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Shedule`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Shedule` (`Student_Student_ID`, `Class_Classs_ID`) VALUES (111, 111);
INSERT INTO `ClassManager`.`Shedule` (`Student_Student_ID`, `Class_Classs_ID`) VALUES (111, 222);
INSERT INTO `ClassManager`.`Shedule` (`Student_Student_ID`, `Class_Classs_ID`) VALUES (222, 111);
INSERT INTO `ClassManager`.`Shedule` (`Student_Student_ID`, `Class_Classs_ID`) VALUES (222, 222);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ClassManager`.`Class_Times`
-- -----------------------------------------------------
START TRANSACTION;
USE `ClassManager`;
INSERT INTO `ClassManager`.`Class_Times` (`Class_Classs_ID`, `Day`, `Start_Time`, `End_Time`) VALUES (111, 'MONDAY', '11:00', '12:00');
INSERT INTO `ClassManager`.`Class_Times` (`Class_Classs_ID`, `Day`, `Start_Time`, `End_Time`) VALUES (222, 'TUESDAY', '12:30', '14:00');

COMMIT;

