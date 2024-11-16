
create table branches(
id SERIAL PRIMARY KEY,
name VARCHAR(100) UNIQUE NOT NULL,
address TEXT,
phone_number VARCHAR(100) UNIQUE NOT NULL
)
create table users_role(
id SERIAL PRIMARY KEY,
name VARCHAR(100) UNIQUE NOT NULL,
description TEXT
)

create table employees(
id SERIAL PRIMARY KEY,
username VARCHAR(200) UNIQUE NOT NULL,
email VARCHAR(200) UNIQUE NOT NULL,
password VARCHAR(255) UNIQUE NOT NULL,
phone_number VARCHAR(100) UNIQUE NOT NULL,
status int NOT NUll,
position VARCHAR(100) NOT NULL, 
department VARCHAR(100),
confirmed_at TIMESTAMP,
branch_id int references branches(id) on delete cascade,
users_role_id int references users_role(id) on delete cascade,
created_at TIMESTAMP DEFAULT NOW(),
updated_at TIMESTAMP DEFAULT NOW(),
created_by int references employees(id) on delete cascade,
updated_by int references employees(id) on delete cascade)


create table customers(
id SERIAL PRIMARY KEY,
first_name 	VARCHAR(100) NOT NULL,
last_name VARCHAR(100),
email VARCHAR(100) UNIQUE NOT NULL,
nrc VARCHAR(100) UNIQUE NOT NULL,
phone VARCHAR(100) UNIQUE NOT NULL,
address TEXT,
status int NOT NUll,
date_of_birth DATE,
confirmed_at TIMESTAMP DEFAULT NOW(),
created_at TIMESTAMP DEFAULT NOW(),
updated_at TIMESTAMP DEFAULT NOW(),
created_by int references employees(id) on delete cascade,
updated_by int references employees(id) on delete cascade)


create table accounts(
id SERIAL PRIMARY KEY,
account_number VARCHAR(100) UNIQUE NOT NULL,
account_type INT NOT NULL,
balance float NOT NULL,
currency VARCHAR(100) NOT NULL, 
status int NOT NULL,
created_at TIMESTAMP DEFAULT NOW(),
updated_at TIMESTAMP DEFAULT NOW(),
created_by int references employees(id) on delete cascade,
updated_by int references employees(id) on delete cascade)


create table loans(
id SERIAL PRIMARY KEY,
loan_type INT NOT NULL,
loan_amount float NOT NULL,
status int NOT NULL,
interest_rate float NOT NULL,
loan_start_date DATE DEFAULT NOW(),
loan_end_date DATE NOT NULL,
customer_id int references customers(id) on delete cascade
)

