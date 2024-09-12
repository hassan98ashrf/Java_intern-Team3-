# Library Management System

## Project Overview

The **Library Management System (LMS)** is a console-based application designed to manage a library's inventory and handle member transactions like borrowing and returning books. It is built using **Object-Oriented Programming (OOP)** principles such as encapsulation, inheritance, and abstraction. The application allows librarians to manage books and members efficiently and calculates overdue fines when returning books.

---

## Features

### 1. **Book Management**
   - **Add Books**: Create new entries for books with details like title, author, ISBN, and publication date.
   - **Update Books**: Modify existing book details (e.g., title, author, ISBN).
   - **Remove Books**: Remove books from the system using their ISBN.

### 2. **Member Management**
   - **Register Members**: Add new members with a name, membership ID, and contact information.
   - **Update Member Information**: Modify member details or update membership status.
   - **Borrowing History**: Track the borrowing history for each member, including borrowed books, due dates, and overdue fines.

### 3. **Borrowing and Returning Books**
   - **Borrow Books**: Allow members to borrow books, mark them as checked out, and record the borrowing date.
   - **Return Books**: Process returns, mark books as available, and calculate any overdue fines (fine = `days overdue * 2`).
   - **Fine Calculation**: Fines are calculated based on the number of overdue days.

---

## UML Design

### Classes:
   - **`Book`**: Manages book-related information (e.g., title, author, ISBN, and status).
   - **`Member`**: Handles member-related data, such as name, membership ID, and borrowed books.
   - **`Library`**: Manages books and members. Contains methods for adding/removing books, registering members, borrowing, and returning books.
   - **`Borrow`**: Manages borrowing functionality and records the borrow date.
   - **`Return`**: Handles book returns, calculates overdue fines, and updates the book's availability.

### Relationships:
   - **Association**: The `Library` class has a one-to-many relationship with both `Book` and `Member`.
   - **Aggregation**: A `Member` can borrow multiple `Books`.

---

## Kanban Workflow

We are using a **Kanban table** to distribute tasks among the team:
- **Task Distribution**: Tasks are broken down into functional components and assigned based on team capacity.
- **Progress Tracking**: The board is updated regularly to track task status (To Do, In Progress, Done).

Kanban URL: `[Insert Kanban URL here]`

---

## Contributors

- Hassan Ashraf
- Mohamed Abdelwahed
- Soliman Mahmoud

