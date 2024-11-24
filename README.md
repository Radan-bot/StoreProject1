# Proyecto Formativo - Store Project

## **Descripción General**
Este proyecto es una aplicación web desarrollada en React que simula una tienda en línea básica. Incluye funcionalidades para mostrar productos en un catálogo con un diseño visual agradable, utilizando colores cálidos.

## **Estructura del Proyecto**
El proyecto está dividido en dos partes principales:
1. **Frontend**: Aplicación web construida con React que muestra la interfaz de usuario.
2. **Backend (pendiente de desarrollo)**: Se planea crear un backend utilizando Java con JDBC para la gestión de la base de datos.

## **Servicios Implementados**
A continuación se detalla la documentación de los servicios creados para la aplicación:

### **Frontend - Componentes**

#### 1. **Header Component**
   - **Descripción**: Componente que muestra la barra de navegación en la parte superior de la página.
   - **Propósito**: Permite la navegación básica dentro de la tienda.
   - **Ubicación**: `src/Header.js`
   - **Características**:
     - Contiene enlaces a diferentes secciones de la tienda.
     - Presenta el logo y un menú básico.
   - **Tecnologías**: React, CSS.

#### 2. **Hero Component**
   - **Descripción**: Componente que muestra una imagen destacada o promoción principal en la página de inicio.
   - **Propósito**: Llamar la atención del usuario sobre ofertas especiales o productos destacados.
   - **Ubicación**: `src/Hero.js`
   - **Características**:
     - Imágenes promocionales.
     - Textos destacados para atraer al usuario.
   - **Tecnologías**: React, CSS.

#### 3. **ProductList Component**
   - **Descripción**: Componente que muestra una lista de productos disponibles en la tienda.
   - **Propósito**: Mostrar al usuario un catálogo de productos de la tienda.
   - **Ubicación**: `src/ProductList.js`
   - **Características**:
     - Genera una lista de productos utilizando el componente `ProductCard`.
     - Los datos de los productos son simulados y se integrarán con el backend en el futuro.
   - **Tecnologías**: React, CSS.

#### 4. **ProductCard Component**
   - **Descripción**: Componente que muestra la información básica de un producto individual.
   - **Propósito**: Proporcionar una vista previa rápida de cada producto.
   - **Ubicación**: `src/ProductCard.js`
   - **Características**:
     - Muestra la imagen del producto, el nombre, y el precio.
     - Incluye botones para más detalles o agregar al carrito (en desarrollo).
   - **Tecnologías**: React, CSS.

#### 5. **Footer Component**
   - **Descripción**: Componente que muestra la información del pie de página de la aplicación.
   - **Propósito**: Proporcionar información adicional o enlaces relevantes, como contactos o términos de servicio.
   - **Ubicación**: `src/Footer.js`
   - **Características**:
     - Incluye enlaces a redes sociales o información de contacto.
   - **Tecnologías**: React, CSS.

## **Servicios Planificados (Backend - JDBC con Java)**
Aún está en desarrollo la parte del backend para la gestión de datos de productos en la base de datos. Se planea implementar los siguientes servicios utilizando Java con JDBC:

### 1. **Servicio de Inserción de Productos**
   - **Descripción**: Servicio para agregar nuevos productos a la base de datos.
   - **EndPoint Planificado**: `/api/productos/agregar`
   - **Datos de Entrada**: Nombre del producto, descripción, precio, categoría.
   - **Respuesta**: Confirmación de la creación del producto.

### 2. **Servicio de Consulta de Productos**
   - **Descripción**: Servicio para recuperar la lista de productos de la base de datos.
   - **EndPoint Planificado**: `/api/productos/lista`
   - **Datos de Entrada**: Ninguno.
   - **Respuesta**: Lista de productos con sus detalles.

### 3. **Servicio de Actualización de Productos**
   - **Descripción**: Servicio para actualizar la información de un producto existente.
   - **EndPoint Planificado**: `/api/productos/actualizar/{id}`
   - **Datos de Entrada**: ID del producto, información a actualizar (nombre, precio, etc.).
   - **Respuesta**: Confirmación de la actualización.

### 4. **Servicio de Eliminación de Productos**
   - **Descripción**: Servicio para eliminar un producto de la base de datos.
   - **EndPoint Planificado**: `/api/productos/eliminar/{id}`
   - **Datos de Entrada**: ID del producto.
   - **Respuesta**: Confirmación de la eliminación del producto.

## **Cómo Ejecutar el Proyecto**
### **Requisitos**
- Node.js y npm instalados.
- Java y JDBC configurados (para el backend, una vez implementado).
- Navegador web.

### **Instalación**
1. Clona el repositorio desde GitHub:
   ```bash
   git clone <URL del repositorio>
