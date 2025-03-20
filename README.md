Elecciones 2023 - API de Resultados

Este proyecto tiene como objetivo proporcionar una API RESTful para acceder a los resultados de las elecciones argentinas de 2023. Permite consultar información sobre distritos, cargos, secciones y resultados electorales de manera estructurada y eficiente.

📌 Contexto

¿Qué votamos en 2023?

En Argentina, durante el año electoral 2023, se llevaron a cabo las siguientes elecciones:

Presidente/a y vicepresidente/a

19 parlamentarios y parlamentarias del Mercosur por distrito nacional

24 parlamentarios y parlamentarias del Mercosur por distrito regional

130 diputados y diputadas nacionales

24 senadores y senadoras nacionales en 8 provincias

Sistema de Publicación de Resultados Electorales

Este proyecto permite el archivo, tratamiento, intercambio y publicación de datos históricos de elecciones nacionales y locales.

Incluye:

Buscador avanzado por agrupaciones políticas y geografía

Generación de informes personalizados

Descarga de resultados en formato CSV

API para desarrolladores con documentación disponible

Organización del padrón electoral

El padrón está dividido en:

Distritos (provincias y Ciudad Autónoma de Buenos Aires)

Secciones electorales

Circuitos electorales

🚀 Características del Proyecto

Este proyecto utiliza datos oficiales del Ministerio del Interior en formato CSV, expuestos a través de una API REST.

📌 API RESTful

La API incluye los siguientes endpoints:

1️⃣ Listado de Distritos

Endpoint: /distritos

Permite listar todos los distritos y realizar búsqueda por nombre.

Ejemplo:

2️⃣ Listado de Cargos por Distrito

Endpoint: /cargos?distrito_id=4

Devuelve los cargos disponibles en un distrito específico.

Ejemplo:

3️⃣ Listado de Secciones de un Distrito

Endpoint: /secciones?distrito_id=4

Permite listar todas las secciones de un distrito o buscar una específica.

Ejemplo:

4️⃣ Resumen de Resultados

Endpoint: /resultados?distrito_id=4&seccion_id=26

Devuelve los resultados ordenados por cantidad de votos, incluyendo porcentaje del total.

Ejemplo:

✅ Cobertura de Tests

El proyecto cuenta con pruebas automatizadas para garantizar la calidad del código y la funcionalidad de la API.

🐳 Docker

Para facilitar el despliegue, se incluyen:

Dockerfile para ejecutar la aplicación en un contenedor.

Docker Compose para ejecutar en simultáneo el servidor (tupfrcutn/elecciones-2023:1.0.0) y el cliente (nuestra API).

Ejemplo de ejecución:

📂 Estructura del Proyecto

📄 Documentación de la API

La documentación de la API está disponible en Swagger en el siguiente enlace:

🎯 Objetivo

Este proyecto busca ofrecer una herramienta de consulta para desarrolladores, investigadores y ciudadanos interesados en los resultados de las elecciones argentinas.

👨‍💻 Tecnologías utilizadas

Spring Boot (Backend)

Docker & Docker Compose (Contenedores)

JUnit (Testing)

Swagger (Documentación API)

CSV Parsing (Carga de datos oficiales)

🚀 Instalación y Ejecución

Clonar el repositorio:

Navegar al directorio del proyecto:

Construir y levantar los contenedores con Docker Compose:

Acceder a la API en:

Acceder a Swagger:
