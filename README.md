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
```json 
{
    "dateFrom" : "YYYY-MM-DD"
    "dateTo" : "YYYY-MM-DD"
}
```
POST - http://localhost:8080/visit
```json 
{
    "pageId" : "int8 Id"
    "visitorId" : "int8 Id"
}
``` 
Для удобства проверки работы приложения так же есть метод:

POST - http://localhost:8080/visit/withDate
```json 
{
    "pageId" : "int8 Id"
    "visitorId" : "int8 Id"
    "date" : "YYYY-MM-DD"
}
``` 
    
### Инструкция по работе с тестами:	
	
- Создайте отдельную базу данных PostgreSQL для тестов.
- Укажите данные своей БД в файле application-test.properties:
spring.datasource.url - host вашей БД
spring.datasource.username - username для подключения к БД
spring.datasource.password - password для подключения к БД
- Запустите тесты.

