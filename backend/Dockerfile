# Этап 1: Сборка бэкенда
FROM gradle:7.4.0-jdk17 AS build-backend

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем build.gradle и другие необходимые файлы для сборки
COPY build.gradle settings.gradle ./

# Копируем исходники проекта для сборки
COPY src ./src

# Скачиваем зависимости и собираем JAR файл
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
