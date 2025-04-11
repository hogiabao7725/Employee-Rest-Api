DROP DATABASE IF EXISTS `employee-rest-api`;
CREATE DATABASE `employee-rest-api`;
USE `employee-rest-api`;

CREATE TABLE manager (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    department VARCHAR(255)
);

CREATE TABLE employee_detail (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    phone VARCHAR(20)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    age INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    manager_id INT,
    employee_detail_id INT UNIQUE,
    FOREIGN KEY (manager_id) REFERENCES manager(id) ON DELETE SET NULL,
    FOREIGN KEY (employee_detail_id) REFERENCES employee_detail(id) ON DELETE SET NULL
);


CREATE TABLE project (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE employee_project (
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE,
	FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE
);

INSERT INTO manager (name, email, department) VALUES
('Michael Scott', 'michael.scott@dundermifflin.com', 'Sales'),
('Miranda Priestly', 'miranda.priestly@runway.com', 'Fashion'),
('Elon Musk', 'elon.musk@tesla.com', 'Engineering');

INSERT INTO employee_detail (address, phone) VALUES
('1725 Slough Ave, Scranton, PA', '+1-570-555-1234'),
('5th Ave, New York, NY', '+1-212-555-5678'),
('3500 Deer Creek Rd, Palo Alto, CA', '+1-650-555-9876'),
('Calle de Alcalá 45, Madrid', '+34-91-555-1122'),
('Via del Corso, Rome', '+39-06-555-3344');

INSERT INTO employee (age, name, email, department, location, manager_id, employee_detail_id) VALUES
(29, 'Emma Johnson', 'emma.johnson@example.com', 'Engineering', 'New York', 3, 1),
(34, 'Liam Smith', 'liam.smith@example.com', 'Marketing', 'London', 1, 2),
(31, 'Olivia Müller', 'olivia.muller@example.de', 'Finance', 'Berlin', NULL, 3),
(45, 'Carlos García', 'carlos.garcia@example.es', 'Operations', 'Madrid', 2, 4),
(26, 'Sofia Rossi', 'sofia.rossi@example.it', 'Design', 'Rome', 1, 5);
