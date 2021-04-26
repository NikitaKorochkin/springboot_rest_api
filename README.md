# Spring Boot REST API

## Описание
REST API для получения и изменения информации о работниках из таблицы `employees` в БД в виде JSON. Реализует взаимодействие посредством HTTP протокола. Обрабатывает HTTP запросы, использующие методы:

HTTP метод | URL | CRUD операция |
--- | :--- | :---
GET | employees | Получение всех работников
GET | employees/{employeeId} | Получение одного работника по ID
POST | employees | Добавление работника
PUT | employees | Изменение работника
DELETE | employees/{employeeId} | Удаление работника

---

## Технологии
Java 8, Spring Boot, JPA, JSON, MySQL

Для проверки правильности работы каждого метода использовался Postman

---

## Запуск

1. Клонировать репозиторий:
   
   ```git 
   git clone https://github.com/NikitaKorochkin/springboot_rest_api.git
   ```

2. Собрать проект с помощью Maven
   ```
   mvn clean install
   ```

3. Настроить конфигурацию подключения и БД
   
Файл [application.properties](https://github.com/NikitaKorochkin/springboot_rest_api/blob/master/src/main/resources/application.properties) позволяет вносить и изменять параметры по умолчанию.
```java
spring.datasource.url=jdbc:mysql://localhost:'port'/'your_db'?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow
spring.datasource.username=
spring.datasource.password=
```
Далее необходимо подготовить таблицу в БД:

```sql
USE my_db;

CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int,
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.employees (name, surname, department, salary)
VALUES
	('Maksim', 'Reus', 'IT', 500),
	('Oleg', 'Ivanov', 'Sales', 700),
	('Nina', 'Sidorova', 'HR', 850);
```

4. Запустить REST сервер
   
```
cd sprinboot_rest_api
mvn spring-boot:run
```
