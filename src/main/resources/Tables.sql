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
CREATE TABLE Owner (license_num int primary key, name varchar(255), birth_year int, state varchar(255));
CREATE TABLE Car (vin int primary key, model varchar(255), make varchar(255), model_year int, color varchar(255), clean_title bit, license_num int, foreign key (license_num) references Owner(license_num), price double);

--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Owner"
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (123456, 'Van Gogh', 1980, 'Florida');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (982546, 'Salvador Dali', 2001, 'California');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (857346, 'Pablo Picasso', 1890, 'New Jersey');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (469756, 'Da Vinci', 1890, 'New york');


--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Car"
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (1234, 'NSX', 'Acura', 1995, 'red', 1,123456, 250000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (2671, '911 GT3', 'Porsche', 2018, 'silver', 1,469756, 315000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (9270, 'M2', 'BMW', 1989, 'grey', 0,982546, 80000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (8391, 'F1', 'McLaren', 1994, 'black', 0,123456, 1500000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (8349, 'Barracuda', 'Plymouth', 1965, 'blue', 1,857346, 60000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (9081, 'F50', 'Ferrari', 1995, 'red', 1,469756, 900000);
INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (4689, '458 Italia', 'Ferrari', 2015, 'yellow', 0,469756, 125000);

