import React, { useState } from 'react';

const TransactionList = ({ transactions }) => {
  const [sortOrder, setSortOrder] = useState('asc');

  const sortedTransactions = [...transactions].sort((a, b) => {
    if (sortOrder === 'asc') {
      return a.amount - b.amount;
    } else {
      return b.amount - a.amount;
    }
  });

  const toggleSortOrder = () => {
    setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
  };

  return (
    <div>
      <h2>Transactions</h2>
      <button onClick={toggleSortOrder}>
        Sort by Amount ({sortOrder === 'asc' ? 'Ascending' : 'Descending'})
      </button>
      <table>
        <thead>
          <tr>
            <th>Description</th>
            <th>Amount</th>
            <th>Category</th>
          </tr>
        </thead>
        <tbody>
          {sortedTransactions.map((transaction, index) => (
            <tr key={index}>
              <td>{transaction.description}</td>
              <td>{transaction.amount}</td>
              <td>{transaction.category}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TransactionList;
