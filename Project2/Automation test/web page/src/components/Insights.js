import React from 'react';

const Insights = ({ transactions }) => {
  // Calculate total expenses
  const totalExpenses = transactions
    .filter((t) => t.amount < 0)
    .reduce((acc, t) => acc + Math.abs(t.amount), 0);

  // Calculate expenses by category
  const expensesByCategory = transactions
    .filter((t) => t.amount < 0)
    .reduce((acc, t) => {
      const category = t.category;
      if (!acc[category]) acc[category] = 0;
      acc[category] += Math.abs(t.amount);
      return acc;
    }, {});

  // Calculate the percentage of total expenses for each category
  const categoryPercentages = {};
  for (let category in expensesByCategory) {
    categoryPercentages[category] = ((expensesByCategory[category] / totalExpenses) * 100).toFixed(2);
  }

  return (
    <div>
      <h2>Insights</h2>
      <p>Total Expenses: ${totalExpenses.toFixed(2)}</p>
      <h3>Category Analysis</h3>
      {Object.keys(expensesByCategory).map((category) => (
        <div key={category}>
          {category}: ${expensesByCategory[category].toFixed(2)} ({categoryPercentages[category]}%)
        </div>
      ))}
    </div>
  );
};

export default Insights;
