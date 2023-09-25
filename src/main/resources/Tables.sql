drop table Car if exists;
drop table Owner if exists;
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Create the tables
CREATE TABLE Car (vin int primary key, model varchar(255), make varchar(255),model_year int, color varchar(255), clean_title bit, license_num int, foreign key (license_num) references Owner(license_num));
select
    case
      WHEN @clean_title=1 then 'TRUE'
      WHEN @clean_title=0 then 'FALSE'
      ELSE NULL
    end as result
CREATE TABLE Owner (license_num int primary key, name varchar(255), birth_year int, state varchar(255));
--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Car"
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (1234, 'Acura', 'NSX', 1995, 'red', 1, 123456);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (2671, 'Porsche', '911 GT3', 2018, 'silver', 1, 469756);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (9270, 'BMW', 'M2', 1989, 'grey', 0, 982546);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (8391, 'McLaren', 'F1', 1995, 'black', 0, 123456);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (1234, 'Plymouth', 'Barracuda', 1965, 'blue', 1, 857346);
INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (1234, 'Ferrari', 'F50', 1995, 'red', 1, 469756);

--=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
--Insert into table "Owner"
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (123456, 'Van Gogh');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (982546, 'Salvador Dali');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (857346, 'Pablo picasso');
INSERT INTO Owner (license_num, name, birth_year, state) VALUES (469756, 'Da Vinci');

