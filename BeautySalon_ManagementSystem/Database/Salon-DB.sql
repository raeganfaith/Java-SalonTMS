--Front-end and back-end developer: Raegan Faith F. Paguirigan
--Database for Beauty Salon TPS
CREATE DATABASE SalonTPS;

--Accounts and Users
CREATE TABLE Account(
	Acc_ID INT PRIMARY KEY IDENTITY(81962,8) NOT NULL,
	Employee_Name VARCHAR (20) NOT NULL,
	Employee_Type VARCHAR (20) NOT NULL,
	Employee_Position VARCHAR (20) NOT NULL,
	Employee_Phone VARCHAR(11) NOT NULL,
	Acc_User VARCHAR (20) NOT NULL,
	Acc_Pass VARCHAR (20) NOT NULL,
);
--Default Accounts of the system
INSERT INTO Account(Employee_Name, Employee_Type,Employee_Position, Employee_Phone, Acc_User, Acc_Pass )
VALUES ('Raegan Paguirigan','Full-time', 'Admin', '09454276452', 'AdminRae', 'Admin123');

INSERT INTO Account(Employee_Name, Employee_Type,Employee_Position, Employee_Phone, Acc_User, Acc_Pass )
VALUES ('Faith Flores','Full-time', 'User', '09283259212', 'UserFaith', 'User123');

INSERT INTO Account(Employee_Name, Employee_Type,Employee_Position, Employee_Phone, Acc_User, Acc_Pass )
VALUES ('Rafa Reyes','Part-time', 'User', '09283259212', 'UserRaFa', 'User456');

SELECT * FROM Account;
DROP TABLE Account;

--Services of the Salon
CREATE TABLE Service(
	Service_ID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,	
	Employee_Name VARCHAR(20) NOT NULL,
	Employee_Type VARCHAR(20) NOT NULL,
	Services_Name VARCHAR(20) NOT NULL,
);

SELECT * FROM Service;
DROP TABLE Service;

--For the TRANSACTIONS in booking, reservation, and payment.
CREATE TABLE BookingPayment(
	Booking_Payment_ID INT PRIMARY KEY IDENTITY(101,1) NOT NULL,
	Cust_Name VARCHAR(20),
	Cust_Status VARCHAR(20),
	Cust_Amount VARCHAR(20),
	Cust_Discount VARCHAR(20),
	Cust_Total VARCHAR(20) ,	
);
SELECT * FROM BookingPayment; 
DROP TABLE BookingPayment; 
--
CREATE TABLE ReservationPayment(
	Reservation_Payment_ID INT PRIMARY KEY IDENTITY(101,1) NOT NULL,
	Cust_Name VARCHAR(20),
	Cust_Status VARCHAR(20),
	Cust_Amount VARCHAR(20),
	Cust_Discount VARCHAR(20),
	Cust_Total VARCHAR(20) ,	
);
SELECT * FROM ReservationPayment; 
DROP TABLE ReservationPayment; 
--
CREATE TABLE Booking(
	Booking_No INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Booking_Payment_ID INT FOREIGN KEY REFERENCES BookingPayment(Booking_Payment_ID) NOT NULL,
	Cust_Name VARCHAR (20) NOT NULL,
	Cust_Address VARCHAR (20) NOT NULL,
	Cust_Phone VARCHAR (11) NOT NULL,
	Service_ID INT FOREIGN KEY REFERENCES Service(Service_ID) NOT NULL,
	Services_Name VARCHAR (20) NOT NULL,	
	Employee_Name VARCHAR (20) NOT NULL,	
	Acc_ID INT FOREIGN KEY REFERENCES Account(Acc_ID) NOT NULL,
	Booking_Date DATE NOT NULL,
);
SELECT * FROM Booking;
DROP TABLE Booking;

CREATE TABLE Reservation(
	Reservation_No INT PRIMARY KEY IDENTITY(2,1) NOT NULL,
	Reservation_Payment_ID INT FOREIGN KEY REFERENCES ReservationPayment(Reservation_Payment_ID) NOT NULL,
	Cust_Name VARCHAR (20) NOT NULL,
	Cust_Address VARCHAR (20) NOT NULL,
	Cust_Phone VARCHAR (11) NOT NULL,
	Service_ID INT FOREIGN KEY REFERENCES Service(Service_ID) NOT NULL,
	Services_Name VARCHAR (20) NOT NULL,
	Employee_Name VARCHAR (20) NOT NULL,
	Reserve_Time VARCHAR (20) NOT NULL,
	Reserve_Date DATE NOT NULL,
	Acc_ID INT FOREIGN KEY REFERENCES Account(Acc_ID) NOT NULL,
);	

SELECT * FROM Reservation;
DROP TABLE Reservation;

------------------------------TRANSACTIONS HISTORY--------------------------------------
--Join Table for the Transaction History of Bookings
SELECT * FROM BookingPayment JOIN Booking ON BookingPayment.Booking_Payment_ID = Booking.Booking_Payment_ID;
SELECT * FROM ReservationPayment JOIN Reservation ON ReservationPayment.Reservation_Payment_ID = Reservation.Reservation_Payment_ID;

--Preview of the values in the Booking Payment
SELECT * FROM BookingPayment JOIN Booking ON BookingPayment.Booking_Payment_ID = Booking.Booking_Payment_ID; 

--Preview of the values in the Reservation Payment
SELECT * FROM Reservation JOIN ReservationPayment ON Reservation.Reservation_Payment_ID = ReservationPayment.Reservation_Payment_ID;

--For fillComboBox 
SELECT DISTINCT Services_Name FROM Service;
SELECT DISTINCT Cust_Name FROM ReservationPayment 
SELECT DISTINCT Cust_Name FROM BookingPayment 

--View All Tables
SELECT * FROM Reservation;
SELECT * FROM Booking;
SELECT * FROM ReservationPayment;
SELECT * FROM BookingPayment;
SELECT * FROM Account;
SELECT * FROM Service;

--To Delete Tables
DROP TABLE Reservation;
DROP TABLE Booking;
DROP TABLE ReservationPayment;
DROP TABLE BookingPayment;
DROP TABLE Account;
DROP TABLE Service;