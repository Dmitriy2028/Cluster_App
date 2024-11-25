# Этап 1: Сборка бэкенда
FROM gradle:8.7-jdk17 AS build-backend

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем только необходимые файлы для скачивания зависимостей
COPY build.gradle settings.gradle ./

# Скачиваем зависимости
RUN gradle dependencies --no-daemon

# Копируем исходники проекта
COPY src ./src

# Собираем JAR файл
RUN gradle build --no-daemon

# Этап 2: Создание минимального образа для продакшн
FROM openjdk:17-alpine AS prod-backend

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR файл из этапа сборки
COPY --from=build-backend /app/build/libs/*.jar app.jar

# Открываем порт для бэкенда
EXPOSE 8080

# Запуск Spring Boot приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
