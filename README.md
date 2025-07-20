# 🎬 MovieAdda – Movie Streaming Platform

**MovieAdda** is a full-stack movie streaming platform built using **Java**, **Spring Boot**, and **Spring Data JPA**, with a frontend developed in **HTML** and **CSS**. It provides secure user authentication, subscription-based access control, and integrates with Razorpay for payment handling.

---

## 🚀 Features

- 🔐 **User Authentication**  
  Register and log in securely to access platform features.

- 🧾 **Subscription Management**  
  Only subscribed users can access and stream content. Subscription logic is handled securely on the backend.

- 💳 **Payment Integration**  
  Integrated with **Razorpay** for seamless and secure payment processing.

- 🎥 **Movie Streaming**  
  Subscribed users can browse and stream available movies.

---

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot, Spring Data JPA  
- **Frontend**: HTML, CSS  
- **Database**: MySQL  
- **Payment Gateway**: Razorpay API  

---

## 📂 Modules Overview

- **User Module**: Handles registration, login, and role-based access control.
- **Subscription Module**: Tracks and manages user subscriptions.
- **Movie Module**: Lists and streams movie content for subscribed users.
- **Payment Module**: Connects to Razorpay for transaction processing.

---

## ⚙️ Getting Started

### Prerequisites

- Java 17
- Maven
- MySQL
- Razorpay test credentials

### Run Locally

```bash
git clone https://github.com/adityabxj/MovieAdda---SpringBoot.git
cd MovieAdda---SpringBoot
./mvnw spring-boot:run
