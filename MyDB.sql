create database hospital_management_system;
use hospital_management_system;
create table login(ID varchar(20), PW varchar(20));
select * from login;
insert into login value("Aasthayuli","123456789");


create table patient_info(ID varchar(20), Number varchar(40), Name varchar(20), Gender varchar(20), Patient_Disease varchar(20), Room_Number varchar(20), Time varchar(100), Deposite varchar(20));
select * from patient_info;

create table Room(room_no varchar(20), Availability varchar(20), Price varchar(20), Room_Type varchar(100));
select * from Room;
insert into Room values("100", "Available", "500", "G Bed 1");
insert into Room values("101", "Available", "500", "G Bed 2");
insert into Room values("102", "Available", "500", "G Bed 3");
insert into Room values("103", "Available", "500", "G Bed 4");
insert into Room values("200", "Available", "1500", "Private Room");
insert into Room values("201", "Available", "1500", "Private Room");
insert into Room values("202", "Available", "1500", "Private Room");
insert into Room values("203", "Available", "1500", "Private Room");
insert into Room values("300", "Available", "3500", "ICU Bed 1");
insert into Room values("301", "Available", "3500", "ICU Bed 2");
insert into Room values("302", "Available", "3500", "ICU Bed 3");
insert into Room values("303", "Available", "3500", "ICU Bed 4");
insert into Room values("304", "Available", "3500", "ICU Bed 5");
insert into Room values("305", "Available", "3500", "ICU Bed 6");


create table department(Department varchar(100), Phone varchar(20));
select * from department;

insert into department values("Surgical Department", "123456789");
insert into department values("Nursing Department", "123456789");
insert into department values("Operation Theatre complex(OT)", "123456789");
insert into department values("Paramedical Department", "123456789");

create table EMP_INFO(Name varchar(20), Age varchar(20), Phone_Number varchar(20), salary varchar(20), Gmail varchar(20), Aadhar_Number varchar(20));
select * from EMP_INFO;


insert into EMP_INFO values("Doctors1","30", "123456789", "50000", "dgbush@gmail.com", "123456789101");
insert into EMP_INFO values("Doctors2","28", "986456789", "45600", "ifhngi@gmail.com", "123456789133");

create table Ambulance(Name varchar(20), Gender varchar(20), Car_name varchar(20), Available varchar(20), Location varchar(20));
insert into Ambulance values("Abhinav", "Male", "Zen", "Available", "Area16");
insert into Ambulance values("Sia", "Female", "Zen", "Available", "Sector 14");
select * from Ambulance;