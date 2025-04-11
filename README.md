# 🧑‍💼 Employee Rest API

A Spring Boot RESTful API for managing **employees, managers, employee details**, and **project assignments**.

> 📚 This project is part of an ongoing hands-on journey exploring real-world entity relationships, clean architecture, and backend best practices.

---

## 📌 Features

### ✅ Core CRUD Functionalities
- 🧑 Employees  
- 👨‍💼 Managers  
- 📄 Employee Details  
- 📁 Projects  

### 🔗 Relationship Mapping
- 🔁 **One-to-One**: `Employee` ↔ `EmployeeDetail`  
- 🔁 **One-to-Many**: `Manager` ↔ `Employees`  
- 🔁 **Many-to-Many**: `Employee` ↔ `Project`  

### 🧪 Backend Highlights
- Clean, RESTful endpoint design
- JPA + Hibernate with MySQL
- Entity validation via annotations
- Easy to extend and maintain structure

---

## 🛠 Technologies Used

- ☕ Java 17+
- 🍃 Spring Boot
- 🧰 Spring Data JPA (Hibernate)
- 🐬 MySQL
- 🪶 Maven

---

## 🧱 Database Schema

**Database**: `employee-rest-api`

```sql
-- Managers
CREATE TABLE manager (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100)
);

-- Employees
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT,
    department VARCHAR(100),
    location VARCHAR(100),
    manager_id INT,
    employee_detail_id INT,
    FOREIGN KEY (manager_id) REFERENCES manager(id),
    FOREIGN KEY (employee_detail_id) REFERENCES employee_detail(id)
);

-- Employee Details
CREATE TABLE employee_detail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(255),
    phone VARCHAR(50)
);

-- Projects
CREATE TABLE project (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT
);

-- Join Table: Employee-Project (Many-to-Many)
CREATE TABLE employee_project (
    employee_id INT,
    project_id INT,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);
