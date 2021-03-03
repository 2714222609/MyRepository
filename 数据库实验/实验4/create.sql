-- create.sql
-- SQL statements for table creation for CAP database
create database CAP
on
(name=cap_data,--�����ļ����߼�����,ע�ⲻ������־�߼�ͬ��
filename='d:\sql_data\cap_data.mdf' ,--�������ƣ�ע��·���������
size=10,--���ݳ�ʼ����Ϊ5M
maxsize=50,--��󳤶�Ϊ10M
filegrowth=5%)--�����ļ�ÿ������5%
log on
( name=cap_log, 
filename='d:\sql_data\cap_log.ldf ' , 
size=2 , 
maxsize=5 , 
filegrowth=1)
go
use CAP
go
if exists(select name from sysobjects where name='customers')
	drop table customers;
create table customers (cid char(4) not null, cname varchar(13),
  city varchar(20), discnt real, primary key(cid));
go
create table agents (aid char(3) not null, aname varchar(13),
  city varchar(20), per smallint, primary key (aid));

create table products (pid char(3) not null, pname varchar(13),
  city varchar(20), quantity integer, price money,
  primary key(pid));

create table orders (ordno integer not null, month char(3),
  cid char(4), aid char(3), pid char(3),
  qty integer, dollars money, primary key(ordno));
