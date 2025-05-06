# Проект Backend Sandbox

Проект песочница на основе Docker для тестирования и экспериментов.

## Содержание

* [Запуск проекта](#запуск-проекта)
* [Тестирование проекта](#тестирование-проекта)
* [Тестирование сервиса postgresql-backend](#тестирование-сервиса-postgresql-backend)
* [Тестирование Prometheus](#тестирование-prometheus)
* [Тестирование Grafana](#тестирование-grafana)
* [Выключение проекта](#выключение-проекта)

## Запуск проекта

1. Клонируем проект

```
git clone https://github.com/IvanIzv/backend-sandbox.git
```

2. Перемещаемся в каталог backend-sandbox:

```
cd backend-sandbox
```

3. Создаем каталоги для хранения данных:

```
mkdir data                  
mkdir data/postgresql      
mkdir data/postgresql/data 
mkdir data/prometheus
mkdir data/grafana
```

4. Собираем backend сервис postgresql-backend:

```
mvn clean install
```

5. Запускаем Docker Compose:

```
docker compose up -d
```

## Тестирование проекта

### Тестирование сервиса postgresql-backend

#### Тестирование логики postgresql-backend

1. Проверка взаимодействия postgresql-backend с базой данных:

```
curl -v http://localhost:8181/database/version
```

2. Проверка генерации случайных чисел postgresql-backend:

```
curl -v -X POST -H 'Content-Type: application/json' -d '{"min": 1, "max": 100}' http://localhost:8181/random/number
```

#### Тестирование Health Check postgresql-backend

```
curl -v http://localhost:8181/actuator/health
```

#### Тестирование генерации метрик Prometheus сервисом postgresql-backend

```
curl -v http://localhost:8181/actuator/prometheus
```

### Тестирование Prometheus

```
http://localhost:9090/targets
```

### Тестирование Grafana

```
http://localhost:3000
```

## Выключение проекта

Останавливаем Docker Compose:

```
docker compose down
```