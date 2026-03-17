# 📱 KRMU Nexus – Academic Management Android App

## 📌 Overview

**KRMU Nexus** is a modern Android application designed to streamline academic interactions between students and teachers within a university environment.

The app follows a **role-based system**, allowing users to log in as either a **Student** or a **Teacher**, and provides a structured dashboard experience tailored to each role.

This project demonstrates the implementation of **industry-level Android development practices**, including clean architecture, Firebase integration, and modern UI design principles.

---

## 🚀 Features Implemented (Till Day 6)

### 🔐 Authentication System

* Separate login flows for **Student** and **Teacher**
* Firebase Authentication using Email & Password
* Input validation and error handling
* MVVM-based login architecture

### 👥 Role-Based Navigation

* Role selection screen (Student / Teacher)
* Navigation flow based on selected role
* Scalable structure for multi-role systems

### 🎬 Splash Screen

* Animated splash screen with logo and branding
* Session-based navigation logic
* Auto redirection based on login state

### 🧠 Session Management

* Persistent login using SharedPreferences
* Stores user role and session data
* Automatic login on app restart

### 🏫 Teacher Dashboard (UI Structure)

* Bottom Navigation-based dashboard
* Modular fragments:

  * Home
  * Attendance
  * Schedule
  * Profile
* Clean and scalable fragment architecture

---

## 🧱 Architecture

The application follows **MVVM (Model-View-ViewModel)** architecture:

* **Model:** Firebase & local data handling
* **View:** XML layouts with Fragments
* **ViewModel:** Business logic & UI state
* **Repository:** Handles data operations

Additional practices:

* Single Activity Architecture
* Fragment-based navigation
* Separation of concerns

---

## 🛠️ Tech Stack

### 📱 Android Development

* **Kotlin**
* **XML (UI Design)**
* **Material Design 3**

### 🧠 Architecture & Components

* **MVVM Architecture**
* **ViewModel**
* **LiveData**
* **Repository Pattern**

### 🔗 Navigation & UI

* **Navigation Component**
* **Bottom Navigation View**
* **ConstraintLayout**

### ☁️ Backend & Storage

* **Firebase Authentication**
* **Firebase Firestore**

### ⚙️ Other Tools

* **View Binding**
* **SharedPreferences (Session Management)**
* **Coroutines (Async operations)**

---

## 🎯 Project Highlights

* Designed a **role-based academic system** similar to real-world ERP applications
* Implemented **clean and scalable architecture** for future expansion
* Built **professional UI/UX with Material Design principles**
* Integrated **Firebase for authentication and cloud data handling**

---

## 📌 Future Scope

* Attendance Management System
* Assignment Upload & Submission
* Timetable Integration
* Offline-first support using Room Database
* Push Notifications

---

## 🏁 Conclusion

KRMU Nexus serves as a strong foundation for a **full-scale academic management system** and showcases practical knowledge of modern Android development and real-world app architecture.
