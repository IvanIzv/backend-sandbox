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

4. Запускаем Docker Compose:

```
docker compose up -d
```

## Выключение проекта

1. Останавливаем Docker Compose:

```
docker compose down
```