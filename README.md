### Инструкция по работе с приложением:
- Скачайте репозиторий в удобную для Вас директорию. 
- Распакуйте его.
- Создайте базу данных PostgreSQL.
- Укажите данные своей БД в файле application.properties:
spring.datasource.url - host вашей БД
spring.datasource.username - username для подключения к БД
spring.datasource.password - password для подключения к БД
- Соберите приложение.
- С помощью любого инструмента, для тестирования REST API приложений, отправляйте запросы на URL: http://localhost:8080/visit/.
Варианты запросов: 

GET - http://localhost:8080/visit
    
    parametrs:
    dateFrom - YYYY-MM-DD, dateTo - YYYY-MM-DD

POST - http://localhost:8080/visit

    parametrs:
    pageId, visitorId 
    
Для удобства проверки работы приложения так же есть метод:

POST - http://localhost:8080/visit/withDate
    
    parametrs:
        pageId, visitorId, date - YYYY-MM-DD
    
