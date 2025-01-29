Enunciado:

Esta práctica consiste en la implementación de un servidor socket que atenderá peticiones de clientes que desean
consultar la disponibilidad y precio de artículos en un almacén de frutería.

Debes crear un proyecto en Intellij con el nombre ActividadUF2-1, atendiendo a las especificaciones que se indican en
este documento.
Empaquetarás el proyecto en un archivo .zip que entregarás a tu tutor, junto con un documento en formato Word o PDF
donde harás una exposición sobre lo que has ido realizando y pegarás las partes principales del código.
Especificaciones:

Para comenzar, partirás de una copia de la última versión de la aplicación cliente-servidor que desarrollaste durante el
estudio de la unidad. Concretamente la que quedó desarrollada en la lección “2.3. Utilización de hilos en la
programación de aplicaciones en red” apartado “Servidor multihilo”.

Esta vez el cliente no se comunicará con el servidor para enviarle simples mensajes, sino que enviará códigos de
artículos para consultar, esperando que el servidor responda con todos los detalles del artículo si ha sido encontrado
en el almacén de frutería.

Cada código de artículo es una cadena de texto de 2 caracteres.
Los artículos estarán guardados en una colección de tipo TreeMap de objetos Producto cuya declaración estará situada en
la clase Servidor y podrás copiar desde aquí:
TreeMap<String, Producto> productos = new TreeMap<String, Producto>();

productos.put("PL",new Producto("Peras limoneras", 14, 5f));

productos.put("PC",new Producto("Peras conferencia", 12, 7f));

productos.put("PN",new Producto("Plátano canario", 5, 2.5f));

productos.put("BN",new Producto("Bananas", 7, 1.3f));

productos.put("TP",new Producto("Tomates tipo pera", 8, 1.7f));

productos.put("TR",new Producto("Tomates Raf", 7, 5.3f));

productos.put("UN",new Producto("Uvas negras", 8, 3.2f));

productos.put("UB",new Producto("Uvas blancas", 5, 2.7f));

productos.put("PT",new Producto("Picotas", 8, 4.3f));

productos.put("CR",new Producto("Ciruelas rojas", 10, 2.8f));

productos.put("MR",new Producto("Melocotones rojos", 3, 2.5f));

productos.put("MA",new Producto("Melocotones amarillos", 4, 3.2f));

Necesitarás crear la clase Producto con las siguientes propiedades: nombre, stock y precio.