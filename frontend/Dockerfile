# Этап 1: Сборка фронтенда
FROM node:18-slim AS build-frontend

# Установим рабочую директорию
WORKDIR /app

# Копируем только package.json и package-lock.json для установки продакшн зависимостей
COPY package*.json ./

# Устанавливаем только зависимости для продакшн
RUN npm install --production && npm cache clean --force

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
