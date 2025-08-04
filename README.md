# 💸 Expense Tracker App

A simple and clean **Expense Tracker** Android application built using **Java**, **Room Database**, and **MVVM Architecture**. This app helps users to track daily expenses including the **category**, **amount**, and **date** of each expense.

---

## 📱 Features

- ➕ Add a new expense with category, amount, and date.
- 📋 View a list of all expenses in a scrollable RecyclerView.
- 💾 Save expenses locally using Room database.
- 🧠 Follows MVVM architecture for better code management and separation of concerns.
- 🔄 Live updates to UI using LiveData and ViewModel.

---

## 🧰 Tech Stack

- **Java**
- **Room Database**
- **MVVM Architecture**
- **LiveData**
- **ViewModel**
- **RecyclerView**
- **Material Design Components**

---

## 📸 Screenshots


(<img width="266" height="496" alt="Image" src="https://github.com/user-attachments/assets/be62aecc-1e49-4de8-a685-153138174328" />) | 

<img width="251" height="542" alt="Image" src="https://github.com/user-attachments/assets/d2eebff7-25e6-47d2-984b-7de8d26158a1" />
<img width="261" height="558" alt="Image" src="https://github.com/user-attachments/assets/35ac5b38-72f9-469d-a1c1-17b058b3faf1" />

> (Add your actual screenshots in a `screenshots/` folder in the repo.)

---

## 📁 Folder Structure

com.example.myexpensetrackerapp/
│
├── Expense.java // Model class
├── ExpenseDao.java // DAO interface
├── ExpenseDatabase.java // Room database
├── ExpenseRepository.java // Repository for abstraction
├── ExpenseViewModel.java // ViewModel for UI data
│
├── MainActivity.java // Displays expense list
├── AddExpenseActivity.java // Add new expenses
│
├── ExpenseAdapter.java // RecyclerView Adapter
├── res/layout/ // XML layout files
│
└── AndroidManifest.xml

---

## ⚙️ How It Works

1. **Add Expense**: User enters category, amount, and date → saved using `Room`.
2. **Database**: Room handles local SQLite database and persists the data.
3. **MVVM Flow**:
   - `Activity` sends data to `ViewModel`.
   - `ViewModel` talks to `Repository`.
   - `Repository` accesses `Room` via DAO.
   - `LiveData` notifies the `RecyclerView` adapter on changes.

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Flamingo or later)
- Java 8 or above

### Run Locally

1. Clone the repository:

```bash
git clone https://github.com/your-username/ExpenseTrackerApp.git
