# Actividad-2-Desarrollo-Web-Fullstack
Desarrollar parte de la arquitectura de microservicios para el proyecto de una aplicación web para una empresa de venta de libros

Arrancar microservicio catalogue:
Dentro del poryecto ejecutar:
    1º Arrancar BD: docker compose up -d
    2º Compilar aplicación sin test: mvn clean install -DskipTests
    3º Arrancar aplicación backend: mvn spring-boot:run


------------------------------------------------------------
ENDPOINTS DISPONIBLES
------------------------------------------------------------
Buscar con filtro:
	GET http://localhost:8081/api/books/search?title={title}&author={author}&publicationDate={publicationDate}&category={category}&isbn={isbn}&rating={rating}&visible={visible}

Obtener todos los libros:
	GET http://localhost:8081/api/books

Obtener libro por id:
	GET http://localhost:8081/api/books/{id}

Crear libro:
	POST http://localhost:8081/api/books
	Body:
		{
  		   "title": "Creacion libro prueba",
  		   "author": "Autor prueba",
 		   "publicationDate": "2026-05-13",
  		   "category": "Fantasía",
  		   "isbn": "111111111",
  		   "rating": 4,
  		   "visible": true,
  		   "stock": 35,
  		   "price": 19.99
		}

Eliminar libro:
	DELETE http://localhost:8081/api/books/{id}

Actualización total libro:
	PUT http://localhost:8081/api/books/{id}
	Body:
		{
  		   "title": "Actualizacion total libro",
  		   "author": "Actualizacion total libro",
 		   "publicationDate": "2000-01-01",
  		   "category": "Fantasía",
  		   "isbn": "111111111",
  		   "rating": 4,
  		   "visible": true,
  		   "stock": 35,
  		   "price": 19.99
		}

Actualizacion parcial libro:
	PATCH http://localhost:8081/api/books/{id}
	Body:
	{
  	   "title": "Actualizacion Parcial",
  	   "author": "Actualizacion Parcial"
	}























