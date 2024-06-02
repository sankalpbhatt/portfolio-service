# Portfolio-service

This repository is committed to developing a backend application that supports a frontend-intensive platform.
This platform assists individuals in crafting portfolios to showcase their essential skills.

## Prerequisites

- Docker installed on your machine
- Docker Compose installed on your machine

### PostgreSQL Docker Setup

This guide will help you set up a PostgreSQL database using Docker Compose, and then create a user and a database using
the `psql` terminal.

#### Create and Start the PostgreSQL Container

To create and start the PostgreSQL container, run the following command:

Clone Git Repository

```shell
git clone git@github.com:sankalpbhatt/portfolio-service.git
```

Open terminal and navigate to service folder

```shell
cd portfolio
```

```sh
docker-compose -f ./docker-compose.yml up -d
```

## Clone and Build the application

Build and package application

```shell
./gradlew clean build
```

## Run the application

Build and package application

```shell
./gradlew bootRun
```

## Access

Use the below-mentioned base path to invoke various endpoints
[http://localhost:8080/portfolio/](http://localhost:8080/portfolio/)

## API Documents

Click on below link to access Swagger API Documentation.
[http://localhost:8083/portfolio-service/swagger-ui/index.html](http://localhost:8083/portfolio-service/swagger-ui/index.html)

## Issues

For raising any issues please use the issue section [here](https://github.com/sankalpbhatt/portfolio-service/issues)