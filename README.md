# Permission Switcher 
- To complete permissions switcher function with Java Spring boot.

## Environments

- Java JDK 17
- Maven 3.8.3
- Spring 2.6.2

## Running Permission Switcher
### Docker

Pull public project from repo

```bash
docker pull
```

### IDE / bash

1. Clone project and Change directory into git folder
1. Build with 
    ``` bash
    ./mvnw clean install 
    ```
1. Run spring with 
    ``` bash
    ./mvnw spring-boot:run
    ```

## EndPoint
### Swagger

Access Swagger from localhost

URL : http://localhost:8080/swagger-ui/


### Bash / Postman

| Method | Description | Endpoint |
| :---   |     :---:   |     ---: |
| GET | Returns feature canAccess of User | /feature?email={email}&featureName={featureName} |
| POST | Update or Create permissions | /feature/{permissions} |
| GET | Returns all permissions endpoint| /permissions/ |

#### Examples
1. GET /feature
```bash
curl -X GET "localhost:8080/feature?email=fin@mail.com&featureName=payment"
```
1. POST /feature
```bash
curl -X POST -w "%{http_code}" localhost:8080/feature \
   -H 'Content-Type: application/json'\
   -d '{"email":"sales@mail.com","featureName":"CRM","enable":true}'
```
1. GET /permissions
```bash
curl -X GET "localhost:8080/permissions"
```