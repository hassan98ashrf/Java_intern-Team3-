# Personal Finance Tracker Project

## 1. Introduction
The Personal Finance Tracker is designed to help users manage their financial transactions through a command-line interface. Users can input transaction details, view and sort transactions, analyze their financial data, and gain insights into their spending habits. The project incorporates procedural and object-oriented programming principles, testing (manual and automated), and a web page simulation for automation testing using Java Selenium.

## 2. System Overview
The system provides the following key features:
- **Input Transactions**: Record financial transactions with descriptions, amounts, and categories.
- **View Transactions**: Display a list of all transactions with optional sorting by amount.
- **View Summary**: Summarize total income, expenses, and net balance.
- **Get Insights**: Offer detailed insights into spending habits categorized by type.

## 3. Features and Functionality

### 3.1 Input Transactions
- **Purpose**: Add new financial transactions to the system.
- **Process**:
  - Enter a description (e.g., "Lunch", "Electric Bill").
  - Input the transaction amount. Positive values represent income, negative values represent expenses.
  - Specify the transaction category (e.g., Food, Bills).
  - Transactions are stored in lists or arrays for easy access and management.

### 3.2 View Transactions
- **Purpose**: Display all recorded transactions.
- **Features**:
  - Tabular format showing Description, Amount, and Category.
  - Sorting options (ascending/descending by amount).
- **Process**:
  - Transactions are presented in an easily readable format.
  - Sorting helps quickly identify high or low-value transactions.

### 3.3 View Summary
- **Purpose**: Summarize financial transactions.
- **Features**:
  - **Total Income**: Sum of all income transactions.
  - **Total Expenses**: Sum of all expenses.
  - **Balance**: The difference between total income and total expenses.
- **Process**:
  - Calculate and display a financial summary, showing users their current financial status.

### 3.4 Get Insights
- **Purpose**: Provide insights into spending habits by category.
- **Features**:
  - Display total expenses and breakdown by category.
  - Show percentage contributions of each category to total expenses.
- **Process**:
  - Analyze spending patterns by aggregating expenses across different categories.

## 4. Development Process

### 4.1 Flowchart
The first step in developing the Personal Finance Tracker was to create a flowchart detailing the application's processes, helping visualize the steps from inputting transactions to viewing summaries and gaining insights.

### 4.2 Kanban Board
A Kanban board was created to manage the development tasks. Each team member was assigned tasks based on the board, which tracked the project's progress from initial development to testing.

- **Link to Kanban Board**: [Kanban](https://trello.com/b/w9rc8dkC/second-project)

### 4.3 Code Implementation
Once tasks were assigned, coding began. Developers followed the flowchart, ensuring that all system features were implemented as planned.

### 4.4 Testing
- **Manual Testing**: Tests were conducted manually to validate input handling, sorting functionality, summary calculations, and insights generation.
- **Automation Testing**: A web page was developed to simulate the project, allowing automated testing using Java Selenium. Automated tests were designed to simulate user actions and verify system functionality.

## 5. How to Use

### Menu Options:
- **Input Transactions**: Record a new transaction by following the prompts.
- **View Transactions**: Display all transactions and optionally sort by amount.
- **View Summary**: Get a summary of income, expenses, and balance.
- **Get Insights**: Review detailed insights into your spending by category.
- **Exit**: Close the application.

### Example Workflow:
1. **Input**: Add a transaction such as "Groceries", an amount of "-30.00", and categorize it as "Food".
2. **View Transactions**: Display all transactions and sort if needed.
3. **Summary**: Review your total income, expenses, and net balance.
4. **Insights**: Gain insights into your spending habits by reviewing expenses by category.


## Contributors

- Hassan Ashraf
- Abraam Sobhy
- Mohamed Abdelwahed
- Soliman Mahmoud
