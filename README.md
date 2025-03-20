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

