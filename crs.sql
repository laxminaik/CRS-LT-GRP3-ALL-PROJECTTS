/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs
Target Host: localhost
Target Database: crs
Date: 3/21/2022 6:24:32 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` varchar(32) default NULL,
  KEY `adminId` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `courseCode` varchar(32) NOT NULL default '',
  `courseName` varchar(32) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`courseCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseCode` varchar(100) NOT NULL,
  `courseName` varchar(32) NOT NULL,
  `instructorId` varchar(32) NOT NULL,
  `availableSeats` int(10) NOT NULL,
  `courseFee` double(32,0) default NULL,
  PRIMARY KEY  (`courseCode`),
  KEY `courseCode` (`courseCode`,`courseName`,`instructorId`,`availableSeats`),
  KEY `instructorId` (`instructorId`),
  CONSTRAINT `instructorId` FOREIGN KEY (`instructorId`) REFERENCES `professor` (`instructorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `referenceId` varchar(32) default NULL,
  `notificationType` varchar(32) default NULL,
  `notificationId` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`notificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `referenceId` varchar(100) default NULL,
  `studentId` varchar(32) NOT NULL,
  `amount` float(32,0) default NULL,
  `modeOfPayment` varchar(32) default NULL,
  `status` tinyint(1) default '0',
  KEY `studentId` (`studentId`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `instructorId` varchar(32) NOT NULL,
  `department` varchar(32) NOT NULL,
  `designation` varchar(32) NOT NULL,
  PRIMARY KEY  (`instructorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registeredcourse
-- ----------------------------
DROP TABLE IF EXISTS `registeredcourse`;
CREATE TABLE `registeredcourse` (
  `studentId` varchar(32) NOT NULL,
  `courseCode` varchar(32) NOT NULL,
  `grade` varchar(32) NOT NULL,
  KEY `courseCode` (`courseCode`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `registeredcourse_ibfk_7` FOREIGN KEY (`courseCode`) REFERENCES `course` (`courseCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registeredcourse_ibfk_8` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleType` varchar(32) NOT NULL,
  `userId` varchar(32) NOT NULL,
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(32) NOT NULL,
  `branch` varchar(32) NOT NULL,
  `batch` varchar(32) NOT NULL,
  `isRegistered` varchar(32) NOT NULL,
  `isApproved` varchar(32) default NULL,
  PRIMARY KEY  (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `gender` varchar(32) NOT NULL,
  `address` varchar(32) NOT NULL,
  `role` varchar(32) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('101');
INSERT INTO `catalog` VALUES ('2er', 'www', 'Test');
INSERT INTO `catalog` VALUES ('abtty', 'www', 'Test');
INSERT INTO `catalog` VALUES ('AWS', 'Amazon', 'Amazon cloud certifcation');
INSERT INTO `catalog` VALUES ('Az-104', 'Azure', 'Microsoft certification');
INSERT INTO `catalog` VALUES ('Az-900', 'Azure', 'Microsoft certification');
INSERT INTO `catalog` VALUES ('lz-808', 'Java', 'Java certification');
INSERT INTO `catalog` VALUES ('office365', 'MS', 'Ms certification');
INSERT INTO `catalog` VALUES ('ooo', 'xyz', 'Test');
INSERT INTO `catalog` VALUES ('ooy', 'www', 'Test');
INSERT INTO `catalog` VALUES ('qqq', 'www', 'Test');
INSERT INTO `catalog` VALUES ('sdd', 'www', 'Test');
INSERT INTO `catalog` VALUES ('uiu', 'www', 'Test');
INSERT INTO `catalog` VALUES ('www', 'xyz', 'Test');
INSERT INTO `course` VALUES ('201', 'java', '2', '7', null);
INSERT INTO `course` VALUES ('304', 'Security', '5', '2', null);
INSERT INTO `course` VALUES ('5', 'history', '21', '10', null);
INSERT INTO `course` VALUES ('52', 'laxmi', '21', '10', null);
INSERT INTO `course` VALUES ('English', 'Vocal English Certification', '2', '1', '1500');
INSERT INTO `course` VALUES ('Hindi', 'Hindi Certification', '2', '0', '1500');
INSERT INTO `payment` VALUES ('b66f30cf-c916-4925-8187-5bcefb97f6f4', '2', '1500', 'debit  card', '0');
INSERT INTO `payment` VALUES ('0d8c517b-9c23-45fb-b783-42d052a55291', '2', '1500', 'debit  card', '0');
INSERT INTO `payment` VALUES ('1bacba7a-8a67-4355-abc9-f177f7a7683f', '2', '1500', 'debit  card', '0');
INSERT INTO `professor` VALUES ('10', 'Biology', 'AP');
INSERT INTO `professor` VALUES ('1090', 'Humanity', 'Lecturer');
INSERT INTO `professor` VALUES ('123', 'training', 'trainer');
INSERT INTO `professor` VALUES ('13', 'maths', 'Ass');
INSERT INTO `professor` VALUES ('2', 'IT', 'AS');
INSERT INTO `professor` VALUES ('20', 'Chemistry', 'Lecturer');
INSERT INTO `professor` VALUES ('201', 'Chemistry', 'Lecturer');
INSERT INTO `professor` VALUES ('202', 'maths', 'Lecturer');
INSERT INTO `professor` VALUES ('21', 'history', 'Lecturer');
INSERT INTO `professor` VALUES ('210', 'Tax', 'Lecturer');
INSERT INTO `professor` VALUES ('401', 'Maths', 'AP');
INSERT INTO `professor` VALUES ('402', 'Maths', 'AP');
INSERT INTO `professor` VALUES ('5', 'IT', 'AS');
INSERT INTO `professor` VALUES ('7', 'IT', 'AS');
INSERT INTO `professor` VALUES ('9', 'IT', 'AM');
INSERT INTO `registeredcourse` VALUES ('21', 'Python', 'A');
INSERT INTO `registeredcourse` VALUES ('2', 'English', 'B');
INSERT INTO `student` VALUES ('1', 'IT', '2022', '1', '1');
INSERT INTO `student` VALUES ('2', 'IT', '2022', '1', '1');
INSERT INTO `student` VALUES ('203', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('301', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('302', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('303', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('abcd', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('abhi', 'IT', '2022', '1', '1');
INSERT INTO `student` VALUES ('amit', 'CS', '1', '0', '1');
INSERT INTO `student` VALUES ('Rakesh', 'CS', '1', '0', '1');
INSERT INTO `student` VALUES ('Rakesh1', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('Rakesh3', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('Ram', 'CS', '11', '0', '1');
INSERT INTO `student` VALUES ('Ujjwal', 'CS', '1', '0', '1');
INSERT INTO `student` VALUES ('xyz', 'CS', '11', '0', '1');
INSERT INTO `user` VALUES ('203', 'root', 'laxminaik', 'FEMALE', 'mumbai', 'Student');
INSERT INTO `user` VALUES ('301', 'root', 'laxmi', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('302', 'root', 'laxmi', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('303', 'root', 'laxmi', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('abcd', 'root', 'abc', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('abhi', 'qwe', 'abhi', 'MALE', 'UP', 'STUDENT');
INSERT INTO `user` VALUES ('amit', 'asd', 'Amit', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('laxmi', 'root', 'laxmi', 'FEMALE', 'mumbai', 'STUDENT');
INSERT INTO `user` VALUES ('Rakesh', 'asd', 'Rakesh', 'Male', 'pune', 'Student');
INSERT INTO `user` VALUES ('Rakesh1', 'asd', 'Rakesh1', 'Male', 'pune', 'Student');
INSERT INTO `user` VALUES ('Rakesh3', 'asd', 'Rakesh1', 'Male', 'pune', 'Student');
INSERT INTO `user` VALUES ('Ram', 'shoot', 'Ram', 'Male', 'Banluru', 'Student');
INSERT INTO `user` VALUES ('Ujjwal', 'asd', 'Ujjwal', 'Male', 'pune', 'Student');
INSERT INTO `user` VALUES ('xyz', 'asd', 'Rakesh1', 'Male', 'pune', 'Student');
