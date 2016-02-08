drop table if exists UserLogin;
create table UserLogin
(
  ID          VARCHAR(50) NOT NULL,
  Password    VARCHAR(50) NOT NULL,
  Name        VARCHAR(50),
  CreateDate  VARCHAR(20),
  CreateUser  VARCHAR(50),
  EntryDate   VARCHAR(20),
  EntryUser   VARCHAR(50),
  primary key(ID)
)Engine=InnoDB;

insert into UserLogin values
('admin',sha('admin'), 'Administrator', '2016-01-01 17:00:00','admin', null, null);

drop table if exists MasterResident;
create table MasterResident  
(
   NIK            VARCHAR(100) NOT NULL,
   KKNo           VARCHAR(100) NOT NULL,
   Name           VARCHAR(100) NOT NULL,
   BirthCity      VARCHAR(100) NOT NULL,
   BirthDate      VARCHAR(100) NOT NULL,
   Sex            INT,
   Religion       VARCHAR(20) NOT NULL,
   MaritalStatus  VARCHAR(100) NOT NULL,
   Work           VARCHAR(100),
   Nationality    VARCHAR(100) NOT NULL,  #Kewarganegaraan
   Address        VARCHAR(100) NOT NULL,
   City           VARCHAR(100) NOT NULL,  #Kota
   Region         VARCHAR(100) NOT NULL,  #Propinsi
   PostalCode     VARCHAR(20) NOT NULL,
   RT             VARCHAR(20) NOT NULL,
   RW             VARCHAR(20) NOT NULL,
   Kelurahan      VARCHAR(75) NOT NULL,
   Kecamatan      VARCHAR(75) NOT NULL,
   Note           TEXT,
   PRIMARY KEY(NIK)
)Engine=InnoDB;
