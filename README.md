Elecciones 2023 - Sistema de Resultados Electorales

Este proyecto proporciona un sistema de publicación de resultados electorales, permitiendo el acceso y análisis de datos electorales de manera eficiente y estructurada.

📌 Descripción

El sistema permite la consulta de información sobre distritos, cargos disponibles para votar, secciones electorales y resultados de votación, proporcionando datos históricos y en tiempo real.

📊 Características

API REST para consultar distritos y buscar por nombre.

API para obtener los cargos disponibles en cada distrito.

API para consultar secciones electorales dentro de un distrito.

API para obtener el resumen de resultados electorales con ordenamiento y porcentaje de votos.

Implementación con contenedores Docker y Docker Compose.

Cobertura de pruebas del 80%.

🏛️ Contexto

En Argentina, el sistema electoral se organiza por distritos (provincias y CABA), secciones y circuitos electorales. Este sistema permite acceder a los resultados de las elecciones nacionales del 2023 y proporciona herramientas para la consulta y análisis de datos electorales.

🚀 Instalación y Ejecución

Requisitos Previos

Docker

Docker Compose

Node.js (para el cliente si aplica)

Pasos para ejecutar el proyecto

Clonar el repositorio:

Construir y ejecutar los contenedores:

Acceder a la API en http://localhost:8080

Documentación disponible en Swagger:

📡 Endpoints Principales

Obtener todos los distritos

Respuesta

Buscar distrito por nombre

Respuesta

Obtener cargos disponibles por distrito

Respuesta

Obtener secciones por distrito

Respuesta

Obtener resultados de votación

Respuesta

🧪 Pruebas

Para ejecutar las pruebas y verificar la cobertura:

📦 Docker

El proyecto incluye un Dockerfile y un archivo docker-compose.yml que permite ejecutar tanto el servidor como la API de datos electorales.
