# <span style="color: #cf4c34"> Проект Backend Sandbox </span>

Проект песочница на основе Docker для тестирования и экспериментов.

## <span style="color: #4cc037"> Содержание </span>

* [Запуск проекта](#project-startup)
* [Тестирование проекта](#project-testing)
    * [Тестирование сервиса postgresql-backend](#postgresql-backend-testing)
    * [Тестирование Prometheus](#prometheus-testing)
    * [Тестирование Grafana](#grafana-testing)
* [Выключение проекта](#project-shutdown)

## <span style="color: #4cc037"> Запуск проекта </span> <a id="project-startup"></a>

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

## <span style="color: #4cc037"> Тестирование проекта </span> <a id="project-testing"></a>

### <span style="color: #bf72fe"> Тестирование сервиса postgresql-backend </span> <a id="postgresql-backend-testing"></a>

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

### <span style="color: #bf72fe"> Тестирование Prometheus </span> <a id="prometheus-testing"></a>

```
http://localhost:9090/targets
```

### <span style="color: #bf72fe"> Тестирование Grafana </span> <a id="grafana-testing"></a>

```
http://localhost:3000
```

## <span style="color: #4cc037"> Выключение проекта </span> <a id="project-shutdown"></a>

Останавливаем Docker Compose:

```
docker compose down
```