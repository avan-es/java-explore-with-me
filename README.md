# Explore With Me (КудаGo)
Разработка многомодульного приложения в рамках дипломного проекта.

# Задача

Разработать приложение, которое позволит пользователям делиться информацией об интересных событиях и находить компанию для участия в них. 

# Структура

Проект состоит из двух модулей: основной и сервис статистики.

![01_Structure](https://github.com/avan-es/java-explore-with-me/assets/83888190/22f13916-77b5-4f90-9b5d-62dbf9799f7a)

### Ключивые требования

- основной сервис и сервис статистики успешно запускаются в Docker-контейнерах;
- для каждого сервиса запускается свой экземпляр PostgreSQL в Docker-контейнере;
- все эндпоинты отрабатывают в соответствии со спецификацией;
- данные успешно сохраняются и выгружаются из базы данных;
- реализован HTTP-клиент сервиса статистики;
- основной сервис и сервис статистики корректно взаимодействуют;
- реализация работы с данными не производит лишней нагрузки на базу данных.

## Сервис статистики

Функционал сервиса прост и ограничен: сохранение информации о том, что к эндпоинту был запрос; получение статистики по посещениям.
Сервис реализован в соответствии со пецификацией (полная спецификация доступна по [ссылке](https://app.swaggerhub.com/apis/AVANESIANBAG/stat-service_api/v0#/StatsController/getStats)).

![02_StatsController_API](https://github.com/avan-es/java-explore-with-me/assets/83888190/acc0e5af-1fb0-4e60-829f-0d78b4a63458)

## Основной сервис

