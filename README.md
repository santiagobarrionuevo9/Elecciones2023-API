# 🗳️ Elecciones 2023 - Sistema de Resultados  

Un sistema desarrollado para visualizar y consultar datos electorales de las Elecciones 2023 en Argentina. Permite obtener información sobre distritos, secciones, cargos y resultados de votación.  

## 🚀 Funcionalidades  

- ✅ Listado de todos los distritos disponibles  
- ✅ Búsqueda de distritos por nombre  
- ✅ Consulta de cargos disponibles por distrito  
- ✅ Listado de secciones dentro de un distrito  
- ✅ Consulta de una sección específica dentro de un distrito  
- ✅ Resumen de resultados electorales por distrito y sección  
- ✅ Cálculo de porcentaje de votos por agrupación política  

## 🛠️ Tecnologías  

- Spring Boot  
- Java  
- Docker  
- Docker Compose  
- REST API  
- Swagger  

## 📌 Endpoints Principales  

### 📍 Obtener todos los distritos  
```bash
curl --location 'http://localhost:8080/distritos'

[
  { "id": 1, "nombre": "Ciudad Autónoma de Buenos Aires" },
  { "id": 2, "nombre": "Buenos Aires" },
  { "id": 3, "nombre": "Catamarca" },
  { "id": 4, "nombre": "Córdoba" }
]

```

Buscar distrito por nombre
```bash
curl --location 'http://localhost:8080/distritos?distrito_nombre=bue'
📌 Respuesta esperada
json
Copiar
Editar
[
  { "id": 1, "nombre": "Ciudad Autónoma de Buenos Aires" },
  { "id": 2, "nombre": "Buenos Aires" }
]
```

🗳️ Obtener cargos disponibles por distrito
```bash
curl --location 'http://localhost:8080/cargos?distrito_id=4'
📌 Respuesta esperada
json
Copiar
Editar
{
  "distrito": { "id": 4, "nombre": "Córdoba" },
  "cargos": [
    { "id": 1, "nombre": "PRESIDENTE Y VICE" },
    { "id": 3, "nombre": "DIPUTADO NACIONAL" },
    { "id": 8, "nombre": "PARLAMENTO MERCOSUR NACIONAL" },
    { "id": 9, "nombre": "PARLAMENTO MERCOSUR REGIONAL" }
  ]
}
```

📊 Obtener resultados por distrito y sección
```bash
curl --location 'http://localhost:8080/resultados?distrito_id=4&seccion_id=26'
📌 Respuesta esperada
json
Copiar
Editar
{
  "distrito": "Córdoba",
  "seccion": "Unión",
  "resultados": [
    { "orden": 1, "nombre": "LA LIBERTAD AVANZA", "votos": 24965, "porcentaje": 0.3497 },
    { "orden": 2, "nombre": "JUNTOS POR EL CAMBIO", "votos": 17239, "porcentaje": 0.2415 },
    { "orden": 3, "nombre": "HACEMOS POR NUESTRO PAIS", "votos": 16164, "porcentaje": 0.2264 },
    { "orden": 4, "nombre": "UNION POR LA PATRIA", "votos": 11192, "porcentaje": 0.1567 }
  ]
}
```
🐳 Uso con Docker
📦 Construcción y ejecución con Docker
```bash
Copiar
Editar
docker build -t elecciones-2023 .
docker run -p 8080:8080 elecciones-2023
```
📦 Uso con Docker Compose
```bash
Copiar
Editar
docker-compose up
```
📜 Documentación API
Para explorar la API y probar los endpoints, accede a:
🔗 Swagger UI

🧪 Cobertura de Tests
Se han desarrollado pruebas unitarias y de integración asegurando una cobertura mínima del 80%.
