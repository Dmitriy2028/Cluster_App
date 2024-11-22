import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import '@testing-library/jest-dom';  // Добавьте этот импорт

// Мокируем запросы с помощью axios-mock-adapter
const mock = new MockAdapter(axios);

describe('Calculator App', () => {
  beforeEach(() => {
    mock.reset();  // Сбрасываем все моки перед каждым тестом
    global.alert = jest.fn();  // Мокируем alert один раз для всех тестов
  });

  test('renders calculator and input fields', () => {
    render(<App />);
    // Проверка, что заголовок калькулятора и поля ввода отображаются
    expect(screen.getByText(/Calculator/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/First Number/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Second Number/i)).toBeInTheDocument();
  });

  test('performs addition operation', async () => {
    render(<App />);

    // Вводим числа
    fireEvent.change(screen.getByPlaceholderText(/First Number/i), { target: { value: '5' } });
    fireEvent.change(screen.getByPlaceholderText(/Second Number/i), { target: { value: '3' } });

    // Мокаем успешный ответ от сервера
    mock.onPost('http://localhost:8080/api/calculator/add').reply(200, 8);

    // Нажимаем кнопку сложения
    fireEvent.click(screen.getByText(/Add/i));

    // Проверка, что результат отображается
    await screen.findByText(/Result: 8/i);
  });

  test('shows alert when input is incomplete', () => {
    render(<App />);

    // Вводим только первое число
    fireEvent.change(screen.getByPlaceholderText(/First Number/i), { target: { value: '5' } });

    // Нажимаем кнопку сложения без второго числа
    fireEvent.click(screen.getByText(/Add/i));

    // Проверка, что alert был вызван с правильным сообщением
    expect(global.alert).toHaveBeenCalledWith('Please enter both numbers.');
  });
  
});
