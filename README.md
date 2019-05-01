# Trabalho Final Microservices
> MICROSERVICES DEVELOPMENT & API <br>
> Trabalho FINAL da Disciplina

## Endpoints

### Save Transaction (POST) - localhost:8081/save

```
{
    "amount": 259,
    "timestamp": 1556579338000
}
```

### Get Statistics (GET) - http://localhost:8081/statistics

```
{
    "sum": 259, 
    "avg": 259, 
    "max": 259, 
    "min": 259, 
    "count": 1
}
```

## Docker Build

```
docker build -f Dockerfile -t trabalho-final-microservices
```

## How To Execute

```
docker run -p 8081:8081 -t trabalho-final-microservices
docker run -p 8082:8081 -t trabalho-final-microservices
```

## Swagger API Documentation
http://localhost:8081/swagger-ui.html