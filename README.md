# Actividad-2-Desarrollo-Web-Fullstack
Desarrollar parte de la arquitectura de microservicios para el proyecto de una aplicación web para una empresa de venta de libros

Arrancar microservicio catalogue:
Dentro del poryecto ejecutar:
    1º Arrancar BD: docker compose up -d
    2º Compilar aplicación sin test: mvn clean install -DskipTests
    3º Arrancar aplicación backend: mvn spring-boot:run