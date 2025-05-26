# Simple Java CRUD

Este ejemplo demuestra operaciones CRUD básicas en Java usando JDBC para conectarse a una base de datos MySQL.

## Compilación

1. Asegúrate de tener instalado el JDK y el conector JDBC de MySQL (`mysql-connector-j`).
2. Compila el archivo desde la raíz del proyecto:

```bash
javac -cp /ruta/al/mysql-connector-j.jar -d . src/SimpleCRUD.java
```

## Ejecución

```bash
java -cp .:/ruta/al/mysql-connector-j.jar SimpleCRUD
```

## Configuración de MySQL

1. Crea una base de datos llamada `testdb` (o ajusta la variable `URL` en el código).
2. Define el usuario y contraseña de acuerdo con tu instalación de MySQL editando las constantes `USER` y `PASSWORD`.

Al ejecutar la aplicación se creará la tabla `users` (si no existe) y se realizarán operaciones de inserción, consulta, actualización y eliminación.
