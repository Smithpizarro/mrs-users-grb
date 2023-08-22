# mrs-users-grb
A continuacion de indicara el flujo para el proceso.
**Spring boot application  REST API  se tiene expuesto en el puerto 8092.**
**Consideraciones:**

1.- Java 11

2.- Gradle

3.- Habilitar Lombok

## 1. peticion del authenticate 
http://localhost:8092/grb/authenticate POST

**body:**

<sub>{
"username": "jpizarroaguado@gmail.com",
"password": "Arlette1234"
}
</sub>
 obs: se tiene un usuario inicial de prueba.
 ![Diagram](./src/main/resources/user_paso1.jpg "Diagram")

## 1. validacion del jwt en la lista usuarios 
http://localhost:8092/grb/users  GET

 ![Diagram](./src/main/resources/user_paso2.jpg "Diagram")
## 2. validacion del jwt y creacion de  usuario 
http://localhost:8092/grb/users POST

**body:**

<sub>{
"name": "Juan Rodriguez",
"email": "jpizarrosmith@gmail.com",
"password": "Arlette1235",
"phones": [
               {
                    "number": 933445566,
                    "citycode": 1,
                    "countrycode": 4
                }
           ]        
}
</sub>

 ![Diagram](./src/main/resources/user_paso3.jpg "Diagram")
