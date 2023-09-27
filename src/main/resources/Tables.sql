drop table Car if exists;
drop table Owner if exists;
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Create the tables
--select
--    case
--      WHEN @clean_title=1 then 'TRUE'
--      WHEN @clean_title=0 then 'FALSE'
--      ELSE NULL
--    end as result
CREATE TABLE Car (vin int primary key, model varchar(255), make varchar(255),model_year int, color varchar(255), clean_title bit, license_num int, foreign key (license_num) references Owner(license_num), price double);
CREATE TABLE Owner (license_num int primary key, name varchar(255), birth_year int, state varchar(255));
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Car"
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (1234, 'Acura', 'NSX', 1995, 'red', 1, 123456, 250000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (2671, 'Porsche', '911 GT3', 2018, 'silver', 1, 469756, 315000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (9270, 'BMW', 'M2', 1989, 'grey', 0, 982546, 80000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (8391, 'McLaren', 'F1', 1995, 'black', 0, 123456, 1500000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (8349, 'Plymouth', 'Barracuda', 1965, 'blue', 1, 857346, 60000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (9081, 'Ferrari', 'F50', 1995, 'red', 1, 469756, 900000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (4689, 'Ferrari', '458 Italia', 2015, 'yellow', 0, 469756, 125000);

--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Owner"
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (123456, 'Van Gogh');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (982546, 'Salvador Dali');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (857346, 'Pablo Picasso');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (469756, 'Da Vinci');

