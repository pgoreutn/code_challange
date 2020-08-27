# code_challenge project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

```
swagger
http://localhost:8082/swagger-ui/
```

## Create user
```
POST http://localhost:8082/users
Content-Type: application/json

{
  "name": "Pablo Gore2",
  "email": "pablo.m.gore2@gmail.com"
}
```

## Create account
```
POST http://localhost:8082/accounts
Content-Type: application/json

{
  "accountNumber": 1,
  "balance": 100.5,
  "user": "pablo.m.gore2@gmail.com"
}
```

## Get users
```
GET http://localhost:8082/users
```

## Get accounts
```
GET http://localhost:8082/accounts
```

## Update balance
```
PUT  http://localhost:8082/accounts/0034fa0e-a227-43e1-b876-a65f51fa38f1/balance/-100
``` 

## Update balance
```
PUT  http://localhost:8082/accounts/0034fa0e-a227-43e1-b876-a65f51fa38f1/balance/1000.5
``` 

## Delete user
```
DELETE  http://localhost:8082/users/pablo.m.gore@gmail.com
``` 