# Explore With Me (КудаGo)
Разработка многомодульного приложения в рамках дипломного проекта.

# Задача

Разработать приложение, которое позволит пользователям делиться информацией об интересных событиях и находить компанию для участия в них. 

# Стек технологий
- Java
- Spring Boot
- Hibernate
- PostgreSQL
- Docker
- Apache Maven
- Lombok
- Querydsl APT
- Postman
- IntelliJ IDEA
- DBeaver

# Структура

Проект состоит из двух модулей: основной и сервис статистики.

![01_Structure](https://github.com/avan-es/java-explore-with-me/assets/83888190/22f13916-77b5-4f90-9b5d-62dbf9799f7a)

### Ключевые требования

- основной сервис и сервис статистики успешно запускаются в Docker-контейнерах;
- для каждого сервиса запускается свой экземпляр PostgreSQL в Docker-контейнере;
- все эндпоинты отрабатывают в соответствии со спецификацией (для [основного сервиса](https://app.swaggerhub.com/apis/AVANESIANBAG/explore-with_me_api_server/1.0) и для [сервиса статистики](https://app.swaggerhub.com/apis/AVANESIANBAG/stat-service_api/v0#/StatsController/getStats);
- данные успешно сохраняются и выгружаются из базы данных;
- реализован HTTP-клиент сервиса статистики;
- основной сервис и сервис статистики корректно взаимодействуют;
- реализация работы с данными не производит лишней нагрузки на базу данных.

## Сервис статистики

Функционал сервиса прост и ограничен: сохранение информации о том, что к эндпоинту был запрос; получение статистики по посещениям.
Сервис реализован в соответствии со пецификацией (полная спецификация доступна по [ссылке](https://app.swaggerhub.com/apis/AVANESIANBAG/stat-service_api/v0#/StatsController/getStats)).

![02_StatsController_API](https://github.com/avan-es/java-explore-with-me/assets/83888190/acc0e5af-1fb0-4e60-829f-0d78b4a63458)

## Основной сервис

Модели данных основного сервиса включают в себя: 
- События;
- Категории событий;
- Подборки событий;
- Запросы на участие;
- Пользователи;
  
Реализовано 3 уровня доступа к моделям:
- Admin;
- Private;
- Public.

Сервис реализован в соответствии со пецификацией (полная спецификация доступна по [ссылке](https://app.swaggerhub.com/apis/AVANESIANBAG/explore-with_me_api_server/1.0)).

  |Модель/Уровень доступа|Admin|Private|Public|
  |:---:|:---:|:---:|:---:|
  |Событие|✅ Поиск событий;<br />✅ Редактирование данных события и его статуса (отклонение/публикация).|✅ Добавление нового события;<br />✅ Получение событий, добавленных текущим пользователем;<br />✅ Получение полной информации о событии добавленном текущим пользователем;<br />✅ Изменение события добавленного текущим пользователем;<br />✅ Получение информации о запросах на участие в событии текущего пользователя;<br />✅ Изменение статуса (подтверждена, отменена) заявок на участие в событии текущего пользователя.|✅ Получение событий с возможностью фильтрации;<br />✅ Получение подробной информации об опубликованном событии по его идентификатору.|
  |Категории событий|✅ Добавление новой категории;<br />✅ Удаление категории;<br />✅ Изменение категории. |⛔|✅Получение категорий;<br />✅Получение информации о категории по её идентификатору.|
  |Подборки событий|✅ Добавление новой подборки (подборка может не содержать событий);<br />✅ Удаление подборки;<br />✅ Обновить информацию о подборке.|✅ Получение подборок событий;<br />✅ Получение подборки событий по его id.|
  |Запросы на участие|⛔|✅ Получение информации о заявках текущего пользователя на участие в чужих событиях;<br />✅ Добавление запроса от текущего пользователя на участие в событии;<br />✅ Отмена своего запроса на участие в событии.|⛔|
  |Пользователи|✅ Получение информации о пользователях;<br />✅ Добавление нового пользователя; <br />✅ Удаление пользователя.|⛔|⛔|

  ## Схема базы данных
![exploreWithMeMainDb - public](https://github.com/avan-es/java-explore-with-me/assets/83888190/29b7c75a-24cd-4cad-ba46-a528c39873ea)

  
