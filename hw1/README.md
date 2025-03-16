# Проект Social network

## Описание
Проект написан на языке Java с использованием фреймворка Spring Boot
Для сборки используется Maven
Для запуска контейнер приложения и базы данных необходимо установить docker
Для тестирования используется Postman

## Запуск приложения

1. Перейти в директорию проекта
2. Выполнить команду `docker compose up -d --build`
3. Проверка API:
    1. Импортировать Postman коллекцию `./postman/Highload Architect.postman_collection.json`
    2. Импортировать Postman окружение `./postman/HighLoad Architect.postman_environment.json`
    3. Выполнить запрос с названием `Register`. http://localhost:8080/user/register 
   ```json 
   {
       "firstName": "Семенов",
       "lastName": "Олег",
       "login": "semenov",
       "birthDate": "1990-05-06",
       "email": "semenov@mail.ru",
       "password": "semenov",
       "gender": "MALE",
       "hobby": "book reading",
       "city": "Moscow",
       "role": "ROLE_ADMIN"
   }
   ```

   Результат:
   ```json 
   {
       "message": "User registered successfully!",
       "param": "semenov"
   }
   ```

   4. Выполнить запрос с названием `Login`. http://localhost:8080/login
   ```json 
   {
       "login": "semenov",
       "password": "semenov"
   }
   ```
   Результат:
    ```json 
   {
       "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzIiwiaWF0IjoxNzQyMTQwMzQxLCJleHAiOjE3NDIyMjY3NDF9.OPf4gKIqcewmRNtQw4zjHLEalqfiORwDl64G-3dIZGc",
   }
   ```
    5. Выполнить запрос с названием `Get User`. http://localhost:8080/user/get/1 
    Результат:
   ```json
   {
       "id": 1,
       "firstName": "Елена",
       "lastName": "Ольгина",
       "birthdate": "1990-05-06",
       "email": "olgina@mail.ru",
       "gender": "FEMALE",
       "hobby": "sport",
       "city": "Moscow"
   }
   ```