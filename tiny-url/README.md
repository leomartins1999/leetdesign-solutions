# tiny-url

Problem: https://leetdesign.com/problems/tiny-url

# Solution

Web API with 2 endpoints:

- create short link (`POST /`)
- access short link (`GET /:id`)

Information about the shorted link is persisted in a Redis instance for 5 years

# Implementation

Built using:
- [kotlin](https://kotlinlang.org/)
- [ktor](https://ktor.io/)
- [kreds](https://github.com/crackthecodeabhi/kreds) (redis client for kotlin)

# How to run it

## Requirements
- Java
- Gradle
- Docker

## Steps
1. Start the redis container `docker compose up redis`
2. Start the app `./gradlew run`

## Requests

### Create short link

```bash
curl -v --header "x-tiny-url: <your-link>" -X POST http://localhost:8080/
```

### Access short link

```bash
curl -v http://localhost:8080/<link-id>
```