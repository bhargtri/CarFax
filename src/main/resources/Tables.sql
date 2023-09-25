drop table Car if exists;
drop table Owner if exists;
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Create the tables
CREATE TABLE Car (vin int primary key, model varchar(255), make varchar(255),model_year int, color varchar(255), clean_title bit);
select
    case
      WHEN @clean_title=1 then 'TRUE'
      WHEN @clean_title=0 then 'FALSE'
      ELSE NULL
    end as result
CREATE TABLE Owner (license_num int primary key, name varchar(255), birth_year int, state varchar(255));
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Car"
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (1234, 'Acura', 'NSX', 1995, 'red', 1);
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Owner"
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (123456, 'Van Gogh');

