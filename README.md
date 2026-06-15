# Gym-management-system-java
Gym Management System - A Java Swing desktop application for managing gym memberships with OOP principles. Features include member registration (Regular/Premium), attendance tracking, payment processing, discounts, file I/O, and GUI interface.

# 🏋️ Gym Management System

A comprehensive desktop application built in **Java** using **Swing** for GUI and **Object-Oriented Programming** principles to automate gym operations.

## 📋 Features

### Member Management
- Add **Regular Members** and **Premium Members**
- Activate / Deactivate membership
- Revert membership to original state
- Unique ID validation

### Attendance & Upgrades
- Mark attendance (Regular: +5 loyalty points, Premium: +10 loyalty points)
- Auto-eligibility for plan upgrade after 30 attendances (Regular members)
- Upgrade plans: Basic → Standard → Deluxe

### Payment System
- Track paid amounts and due amounts
- Calculate **10% discount** for Premium members (on full payment)
- Partial payment support
- Pay due amount functionality

### File Handling
- Save member data to `.txt` files
- Read member data from files
- Separate files: `RegularMembers.txt` and `PremiumMembers.txt`

### GUI Interface
- Built with **Java Swing**
- Intuitive navigation between Regular/Premium panels
- Form validation and error handling
- Popup dialogs for user feedback

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java (OOP) | Core logic |
| Swing | GUI framework |
| BlueJ / Any Java IDE | Development environment |
| File I/O | Data persistence |
| Draw.io | Class diagrams & wireframes |

## 📁 Project Structure
