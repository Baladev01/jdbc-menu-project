# 🚀 JDBC Menu Based Login & Signup Application

A **menu-driven console-based Java application** developed using **Core Java and JDBC**.
This project implements **Signup, Login, and View Users** functionality using a
**MySQL database with Stored Procedures**.

The main goal of this project is to understand **JDBC connectivity, database interaction,
and backend logic** without using any web framework.

---

## 🖥️ Application Preview (Console)
===== MAIN MENU =====

1.Signup
2.Login
3.View All Users
4.Exit

---

## 🛠️ Technologies Used
- ☕ Java (Core Java)
- 🔗 JDBC
- 🗄️ MySQL
- ⚙️ Stored Procedures
- 🖥️ Console-based UI
- 🌱 Git & GitHub

---

## ✨ Features
- 🔐 User Signup (store user details in database)
- 🔑 User Login (email & password validation)
- 📋 View All Registered Users
- 🧭 Menu-based interaction
- 🛡️ Secure database calls using `CallableStatement`

---

## 🗂️ Database Design

### Database Name

### Table Structure

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(50)
);
