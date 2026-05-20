# 🎬 Movie Ticket Booking System

A simple console-based Java application for booking movie tickets.  
This project allows users to select movies, book seats, cancel bookings, and view booking details with total ticket cost.

---

## 📌 Features

- 🎥 Display available movies with show timings
- 🪑 View seat layout in real time
- ✅ Book available seats
- ❌ Cancel booked seats
- 💰 Automatic ticket price calculation
- ⭐ Premium & Regular seat categories
- 📋 Booking confirmation with selected seats

---

## 🛠️ Technologies Used

- Java
- OOP Concepts
  - Classes & Objects
  - Arrays
  - ArrayList
  - Encapsulation
- Console-based UI

---

## 📂 Project Structure

```bash
MovieTicketBooking.java
```

### Classes Used

| Class | Purpose |
|------|---------|
| `Movie` | Stores movie name and show timing |
| `Seat` | Stores seat type, price, and booking status |
| `Booking` | Handles booking, cancellation, and seat display |
| `MovieTicketBooking` | Main class containing program execution |

---

## 🎟️ Seat Categories

| Seat Type | Rows | Price |
|-----------|------|--------|
| Premium | Row 1-2 | ₹300 |
| Regular | Row 3-5 | ₹150 |

---

## ▶️ How to Run

### 1️⃣ Compile the Program

```bash
javac MovieTicketBooking.java
```

### 2️⃣ Run the Program

```bash
java MovieTicketBooking
```

---

## 📷 Sample Output

```text
=========================================
     Welcome to Movie Ticket Booking
=========================================

Available Movies:
1. Avengers Doomsday   | 10:00 AM
2. KGF Chapter 3       | 01:30 PM
3. Pushpa 3            | 05:00 PM
4. Mission Impossible 8| 08:30 PM
```

---

## 📌 Menu Options

```text
1. Book seat
2. Cancel seat
3. View booking
4. Exit
```

---

## 🧠 Concepts Demonstrated

- 2D Arrays for seat management
- Dynamic booking storage using `ArrayList`
- Input handling using `Scanner`
- Conditional logic & loops
- Real-world simulation using Java OOP

---

## 🚀 Future Improvements

- Add multiple screens/theatres
- Store booking data in files or database
- Add user login system
- Generate digital tickets
- GUI version using Java Swing/JavaFX

---

## 👨‍💻 Author

Developed by **Keshav Yadav**

---

## 📄 License

This project is open-source and free to use for learning purposes.
