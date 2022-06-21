# Reto Final Kata Fullstack Web 2.1

Reto final de Kata-FullStack, donde se creó una aplicación web par crear listas de tareas, donde se aplicaron los conocimientos adquiridos durante el curso de desarrollo web 2.1 para la creación de una aplicación web desde el baque y frente  creando un CRUD sencillo pero funcional con Spring-Boot, una base de dato mariadb o MySql,  JavaScript vanilla para el DOM, HTML y CSS por el lado del front-end.

Sé debe clonar el repositorio y en un IDE como Intellij IDEA se podrá ejecutar el proyecto desde la carpeta demo crud y ejecutar la clase Demo crud Application.java, también es importante ejecutar la parte del front-end desde un servidor y tener la base de datos Mysql corriendo en su respectivo servidor.

## Video #
<a href="https://youtu.be/LSC4OqDS9Cw">Video de explicación con audio :) </a>


<img src="https://github.com/JohnEstebanAP/reto-final-kata-fullstack/blob/master/Reto-kata.png?raw=true" align="left">
<br>

## Instrucciones
 
Ingresar a la carpeta principal
```bash
$ cd reto-final-kata-fullstack/
```
Es importante que se tenga un servicia de Mysql corriendo, y modificar el archivo application.properties modificándola para tener la conexión a la base de datos, spring-boot creará las tabla,las conexiones y relaciones automáticamente.
 
```bash
$ cd reto-final-kata-fullstack/back-end/src/main/resources
```
### configuración
```bash
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/db_kata
spring.datasource.username=root
spring.datasource.password=12345678
spring.jpa.hibernate.ddl-auto=update
```
Se debe ingresar individualmente tanto en la carpeta del back-End como del Fronten.
 
ingresar a la carpeta del Back-end y correr los servicios.
```bash
 in repo: reto-final-kata-fullstack/
$ cd back-end
```
ejecutar el servicio de Spring-Boot
```bash
in repo: reto-final-kata-fullstack/back-end
$ mvn spring-boot:run
```
 
Ingresar a la carpeta del front-end individualmente de al del Back-end en otra consola
```bash
in repo: reto-final-kata-fullstack
$ cd front-end
```
instalamos las dependencias de npm
```bash
 npm install
```
Ahora ejecutar los servicios del cliente Web con Webpack-server
```bash
 npm star
```
ingresar a la ruta (http://localhost:9000/) desde el navegador web :)


