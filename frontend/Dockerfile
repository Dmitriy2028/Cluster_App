# Этап 1: Сборка фронтенда
FROM node:18 AS build-frontend

# Установим рабочую директорию
WORKDIR /app

# Копируем package.json и package-lock.json (или yarn.lock) для установки зависимостей
COPY package*.json ./

# Устанавливаем зависимости для фронтенда
RUN npm install

# Копируем все остальные файлы проекта
COPY . .

# Собираем приложение для продакшн
RUN npm run build

# Этап 2: Создание минимального образа для продакшн
FROM nginx:alpine AS prod-frontend

# Копируем собранные файлы из первого этапа в директорию Nginx для обслуживания статичных файлов
COPY --from=build-frontend /app/build /usr/share/nginx/html

# Открываем порт 80 для доступа к приложению
EXPOSE 80

# Запуск Nginx для обслуживания фронтенда
CMD ["nginx", "-g", "daemon off;"]
