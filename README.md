# Webapp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.1.

Technologies Used
Back-end: Spring Boot
Database: Oracle
Java Version: 17
Front-end: Angular

## Installation
Run `mvn install`
Run `npm install`

## Development server

Run `npm start` and `mvn spring-boot:run` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## APIs
http://localhost:8080/api/room [POST]
This API allows a user to input a restaurant of their choice, which will be submitted to the backend.

http://localhost:8080/api/room/{roomId} [GET]
This API allows a user to input a room PIN, which will display and retrieve his submitted choices from the backend.

http://localhost:8080/api/random-restaurant/{roomId} [GET]
This API returns a random restaurant from the submitted choices.

## Images
![home.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/home.PNG)
![create.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/create.PNG)
![create2.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/create2.PNG)

![view1.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/view1.PNG)
![view2.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/view2.PNG)

![enter.PNG](https://github.com/kaiguangg/lunch-kaki/blob/main/lunch-kaki-images/enter.PNG)
