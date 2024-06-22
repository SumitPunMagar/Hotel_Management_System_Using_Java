-- create bank management system

create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), date_of_birth varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(20), state varchar(20), pincode varchar(20)); 

show tables;

select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan_number varchar(30), citizenship_number varchar(20), senior_citizen varchar(40), existing_account varchar(20)); 

show tables;

select * from signuptwo;

select * from signup;

create table signupthree(formno varchar(20), account_type varchar(40), card_number varchar(25), pin_number varchar(10), facilities varchar(200));

create table login(formno varchar(20), card_number varchar(25), pin_number varchar(10));

show tables;

select * from signupthree;

select * from login;

drop table signupthree;

create table bank(pin_number varchar(10), date varchar(50), type varchar(20), amount varchar(20));

select * from bank;



-- create hotel management system

create database hotelmanagementsystem; 

use hotelmanagementsystem;

create table hotellogin(username varchar(30), password varchar(20));

show tables;

insert into hotellogin values ("sumit", "12345");

select * from hotellogin;


create table employee(name varchar(20), age varchar(10), gender varchar(10), job varchar(20), salary varchar(20), phone varchar(20), email varchar(50));

drop table employee;

select * from employee;

create table room(room_number varchar(20), status varchar(10), cleaning_status varchar(10), price varchar(20), bed_type varchar(20));

drop table room;

select * from room;

create table driver(name varchar(20), age varchar(10), gender varchar(10), car_company varchar(20), car_model varchar(20), availablility varchar(20), location varchar(50));

select * from driver;

alter table driver rename column availablility to availability;

drop table driver;

create table customer(document varchar(30), id_number varchar(20), name varchar(20), gender varchar(20), country varchar(20), room varchar(20), check_in_time varchar(100), deposit varchar(20));

drop table customer;

select * from customer;

create table department(department varchar(30), budget varchar(20));

insert into department values('Front Office', '1000000');
insert into department values('House Keeping', '50000');
insert into department values('Food and Beverage', '30000');
insert into department values('Kitchen or Food Production', '5000000');
insert into department values('Security', '500000');

select * from department;











