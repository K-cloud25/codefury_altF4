-- User Setup
CREATE USER 'havenuser' IDENTIFIED BY 'rootpwd';

-- Database Setup
CREATE DATABASE IF NOT EXISTS havenhive;
USE havenhive;

-- Privilege Access
GRANT ALL PRIVILEGES ON havenhive.* TO 'havenuser' WITH GRANT OPTION; 

-- Employee Table
CREATE TABLE IF NOT EXISTS employee (
    empID INT PRIMARY KEY AUTO_INCREMENT ,	-- DB defined ID's
    empName VARCHAR(50) NOT NULL, 
    email VARCHAR(150),
    phone VARCHAR(10),
    empType INT NOT NULL DEFAULT 3,	-- By Default Employee is Member 
    passwd VARCHAR(255) NOT NULL	-- Time Being Not Hashed Plain Txt Passwd
);

CREATE TABLE IF NOT EXISTS credit (
	empID INT PRIMARY KEY,			-- Should only map to user with Manager Type 
    credit INT NOT NULL DEFAULT 2000,
    FOREIGN KEY ( empID ) REFERENCES employee( empID )
);

CREATE TABLE IF NOT EXISTS room (
	roomID INT PRIMARY KEY AUTO_INCREMENT,
    roomType VARCHAR(60) NOT NULL, -- RoomID-RoomTypeName 
    seatingCapacity INT NOT NULL-- Only Admin Modify
);

CREATE TABLE IF NOT EXISTS amenity(
	amenityName varchar(40),
    costPerHour INT NOT NULL
);

CREATE TABLE IF NOT EXISTS meeting (
	meetingID int PRIMARY KEY AUTO_INCREMENT,
    roomID INT,
    managerID INT,
    startTime DATETIME, 	-- DATE TIME -- YYYY-MM-DD HH:MI:SSproduct
    endTime DATETIME,	-- DATE TIME -- YYYY-MM-DD HH:MI:SS
    costOfMeeting INT NOT NULL,
    descrip VARCHAR(255) NOT NULL, -- {pro:0,wifi:0,con:0,white:0,water:0,tv:0,coff:0}
    FOREIGN KEY ( roomID ) REFERENCES room ( roomID ),
    FOREIGN KEY ( managerID ) REFERENCES employee ( empID )
);

CREATE TABLE IF NOT EXISTS mapMeetingUser(
	empID int,
    meetingID int,
    FOREIGN KEY ( empID ) REFERENCES employee ( empID ),
    FOREIGN KEY ( meetingID ) REFERENCES meeting ( meetingID )
);

-- dummy data
INSERT INTO employee 
VALUES
	( 1, "Admin", "admin@gmail.com", "9845689754", 1, "admin" ),
    ( 2, "Manager", "manager@gmail.com", "9845689754", 2, "manager" ),
    ( 3, "Member" , "member@gmail.com", "9845689754", 3, "member" )
;

INSERT INTO room
VALUE ( 1, "classroomtraining", 30);

INSERT INTO credit
VALUE ( 2, 2000 ); 

INSERT INTO meeting
VALUE ( 3532, 1, 2, "2024-08-25 09:00:00", "2024-08-25 10:00:00", 40, "MeeetingDescrip" );

INSERT INTO mapmeetinguser
VALUE ( 3, 3532 );
