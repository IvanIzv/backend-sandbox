# Проект Backend Sandbox

Проект песочница на основе Docker для тестирования и экспериментов.

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
```

4. Собираем backend сервис postgresql-backend:

```
mvn clean install
```

5. Запускаем Docker Compose:

```
docker compose up -d
```

6. Запускаем backend сервис postgresql-backend:

```
java -jar postgresql-backend/target/postgresql-backend-1.0.0-SNAPSHOT.jar
```

## Тестирование проекта

### Тестирование backend сервиса postgresql-backend

1. Проверка postgresql-backend и его взаимодействия с базой данных:

```
curl -v -X GET http://localhost:8181/database/version
```

2. Проверка postgresql-backend:

```
curl -v -X POST -H 'Content-Type: application/json' -d '{"min": 1, "max": 100}' http://localhost:8181/random/number
```

## Выключение проекта

1. Останавливаем backend сервис postgresql-backend:

```
pkill -f "postgresql-backend-1.0.0-SNAPSHOT.jar"
```

2. Останавливаем Docker Compose:

```
docker compose down
```