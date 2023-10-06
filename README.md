# Fabrica Microservicio

## Descripción

Este microservicio es una aplicación Spring Boot diseñada para gestionar las operaciones CRUD y otras operaciones personalizadas relacionadas con las fábricas.

## Endpoints

### GET Endpoints

- `GET /`: Obtiene una lista de todas las fábricas disponibles.
- `GET /presupuesto/{idFabrica}`: Obtiene el presupuesto para una fábrica específica identificada por `{idFabrica}`.
- `GET /stock-piezas/{idFabrica}`: Obtiene el stock de piezas de una fábrica específica identificada por `{idFabrica}`.
- `GET /filtro-presupuesto/{presupuestoMinimo}/{presupuestoMaximo}`: Filtra y obtiene las fábricas basadas en un rango de presupuesto especificado.

### POST Endpoints

- `POST /`: Crea una nueva fábrica a partir de los datos proporcionados en el cuerpo de la solicitud.

### PUT Endpoints

- `PUT /actualizar-stock-piezas/{idFabrica}/{stockPiezas}`: Actualiza el stock de piezas para una fábrica específica.
- `PUT /actualizar-presupuesto/{idFabrica}/{presupuesto}`: Actualiza el presupuesto para una fábrica específica.
- `PUT /optimizar/{idModelo}`: Optimiza el proceso de fabricación para un modelo específico.

### DELETE Endpoints

- `DELETE /{idFabrica}`: Elimina la fábrica con el ID especificado.


### Pasos para ejecutar

1. Clona el repositorio a tu máquina local
2. Crear base de datos MySQL si fuera necesario con las sentencias documentadas en el archivo create.sql dentro de la carpeta META-INF
3. Ejecuta `mvn spring-boot:run` para iniciar el microservicio.
4. El servicio ahora está corriendo y los endpoints pueden ser accedidos vía `localhost:9091`.
 
