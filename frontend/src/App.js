import React, { useState } from 'react';
import axios from 'axios';


function App() {
  const [num1, setNum1] = useState('');
  const [num2, setNum2] = useState('');
  const [result, setResult] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');

  const handleNum1Change = (e) => {
    setNum1(e.target.value);
  };

  const handleNum2Change = (e) => {
    setNum2(e.target.value);
  };

  const calculate = async (operation) => {
    if (!num1 || !num2) {
      alert('Please enter both numbers.');
      return;
    }

    const operationDto = {
      num1: parseFloat(num1),
      num2: parseFloat(num2),
    };

    try {
      let response;

      // отправка запроса для выбранной операции
      switch (operation) {
        case 'add':
          response = await axios.post('http://localhost:8080/api/calculator/add', operationDto);
          break;
        case 'subtract':
          response = await axios.post('http://localhost:8080/api/calculator/subtract', operationDto);
          break;
        case 'multiply':
          response = await axios.post('http://localhost:8080/api/calculator/multiply', operationDto);
          break;
        case 'divide':
          response = await axios.post('http://localhost:8080/api/calculator/divide', operationDto);
          break;
        default:
          alert('Invalid operation selected.');
          return;
      }

      setResult(response.data); // выводим результат
      setErrorMessage(''); // очищаем сообщение об ошибке
    } catch (error) {
      setResult(null); // очищаем результат при ошибке
      console.error('Error during calculation:', error); // логируем ошибку
      setErrorMessage(error.response ? error.response.data : 'Error: Could not perform the calculation.'); // выводим ошибку из ответа сервера
    }
  };

  return (
    <div style={styles.container}>
      <h1>Calculator</h1>

      <div style={styles.formGroup}>
        <input
          type="number"
          value={num1}
          onChange={handleNum1Change}
          placeholder="First Number"
          style={styles.input}
        />
        <input
          type="number"
          value={num2}
          onChange={handleNum2Change}
          placeholder="Second Number"
          style={styles.input}
        />
      </div>

      <div style={styles.buttonsContainer}>
        <button onClick={() => calculate('add')} style={styles.button}>Add</button>
        <button onClick={() => calculate('subtract')} style={styles.button}>Subtract</button>
        <button onClick={() => calculate('multiply')} style={styles.button}>Multiply</button>
        <button onClick={() => calculate('divide')} style={styles.button}>Divide</button>
      </div>

      {errorMessage && (
        <div style={styles.errorMessage}>
          <p>{errorMessage}</p>
        </div>
      )}

      <div style={styles.result}>
        <h3>Result: {result !== null ? result : '---'}</h3>
      </div>
    </div>
  );
}

const styles = {
  container: {
    textAlign: 'center',
    marginTop: '50px',
    fontFamily: 'Arial, sans-serif',
  },
  formGroup: {
    marginBottom: '20px',
  },
  input: {
    width: '200px',
    padding: '10px',
    margin: '10px',
    fontSize: '16px',
    borderRadius: '5px',
    border: '1px solid #ccc',
  },
  buttonsContainer: {
    marginBottom: '20px',
  },
  button: {
    padding: '10px 20px',
    fontSize: '16px',
    borderRadius: '5px',
    border: '1px solid #ccc',
    cursor: 'pointer',
    margin: '5px',
    backgroundColor: '#4CAF50',
    color: 'white',
  },
  buttonHover: {
    backgroundColor: '#45a049',
  },
  errorMessage: {
    color: 'red',
    marginTop: '20px',
  },
  result: {
    marginTop: '30px',
    fontSize: '20px',
    fontWeight: 'bold',
    color: '#333',
  },
};

export default App;
