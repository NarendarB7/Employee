CREATE TABLE IF NOT EXISTS company(
company_code int AUTO_INCREMENT PRIMARY KEY,
company_name varchar(80) NOT NULL,
percentage_profit varchar(80),
country varchar(80) NOT NULL,
founded_in varchar(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee(
id int AUTO_INCREMENT PRIMARY KEY,
employee_id int NOT NULL,
name varchar(150) NOT NULL,
company_name varchar(80) NOT NULL,
status varchar(80),
employee_type varchar(80) NOT NULL,
salary varchar(80) NOT NULL,
location varchar(80) NOT NULL,
mobile_number varchar(12) NOT NULL,
join_date varchar(80) NOT NULL,
last_date varchar(80)




);