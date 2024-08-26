import React, { useState } from 'react';
import TransactionForm from './components/TransactionForm';
import TransactionList from './components/TransactionList';
import Summary from './components/Summary';
import Insights from './components/Insights';

const App = () => {
  const [transactions, setTransactions] = useState([]);
  const [showTransactions, setShowTransactions] = useState(false);
  const [showInsights, setShowInsights] = useState(false);
  const [exiting, setExiting] = useState(false);

  const addTransaction = (transaction) => {
    setTransactions([...transactions, transaction]);
  };

  const handleShowTransactions = () => {
    setShowTransactions(!showTransactions);
  };

  const handleShowInsights = () => {
    setShowInsights(!showInsights);
  };

  const handleExit = () => {
    setExiting(true);
  };

  if (exiting) {
    return <h1>Exiting the program, Goodbye</h1>;
  }

  return (
    <div className="App">
      <h1>Personal Finance Tracker</h1>
      <TransactionForm addTransaction={addTransaction} />
      <Summary transactions={transactions} />

      <div>
        <button onClick={handleShowTransactions}>
          {showTransactions ? "Hide Transactions" : "Show Transactions"}
        </button>
        <button onClick={handleShowInsights}>
          {showInsights ? "Hide Insights" : "Show Insights"}
        </button>
        <button onClick={handleExit}>Exit</button>
      </div>

      {showTransactions && (
        <TransactionList transactions={transactions} />
      )}

      {showInsights && (
        <Insights transactions={transactions} />
      )}
    </div>
  );
};

export default App;
