# Coursera - Bike Rental Data Aggregator Project

This is a project done exclusively by me in order to complete the course ([Applications of Software Architecture for Big Data](https://www.coursera.org/learn/software-architecture-for-big-data-applications)) of [Software Architecture for Big Data Specialization](https://www.coursera.org/specializations/software-architecture-big-data).
The main idea is to collect Bike Rental offers from many bike providers and find some useful information from it. At the first phase as a demonstration step I decided consume data from the API https://api.citybik.es/v2/.

## Tech Stack
- Java 17
- Springboot 3+
- Maven
- MongoDB
- Apache Kafka
- Spock Framework
- Continuous Integration - GitHub Actions
- Continuous Deployment - Heroku Pipeline
- Docker Compose


## Project Questions
### Goals
Provide to the users an easy way of discovering bike availability from multiple bike rental providers.

#### The initial project steps requires answering the following questions
##### What problem is the product aimed at solving?
As a bike rental user I have to have multiple applications in my phone to discover bike availability near to me. This process takes several minutes due to the huge amount of rentals in my city, especially during summer.

Because of that I would like to create an app that can aggregate data of multiple bike rental providers and offer to the users its availability.

At this first phase the idea is to create a data aggregator starting with a single bike rental provider. In the future add more providers and offer exclusive features like bike filtering, promotions, collect/track users behaviors offering custom solutions, cycling routes and so on.

##### Who is the product geared towards (targeted audience)?
The main target are users that need to rent a bike frequently. Those users have a wide age range and different rental behaviors like short rental period, specific bike types and other characteristics.

##### How is my product unique?
The idea is to make the bike rental experience more attractive to the users offering customized solutions accordingly with the users profiles.


## How to Run the Project

Run all test and quality gates:
```shell
make verify
```

### In order to test it locally you should run the following commands in this sequence

1 - Run Mongo DB and Kafka Server using Docker Compose
```shell
make run-local-support-servers
```

2 - Run API Server
```shell
make run-api-server
```

3 - Run Cron Server
```shell
make run-cron-server
```

3 - Run Data Analyzer
```shell
make run-data-analyzer-server
```

### To stop local servers (MongoDB and Kafka)

```shell
make stop-local-support-servers
```