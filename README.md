#  Simulador de Editor de Texto con Undo/Redo en Java
### Autor:Valentina Gaviria Bedoya
### Materia:Estructura de Datos 
### Profesor:Steven Zuluaga

Este proyecto es un **editor de texto básico** que funciona en la consola. Te permite **escribir**, **deshacer** (Undo) y **rehacer** (Redo) cambios, usando pilas (stacks) hechas manualmente en Java.

##  ¿Qué contiene el proyecto?

Tiene dos archivos principales:

1. **`CustomStack.java`**: Una clase que crea una pila personalizada.
2. **`TextEditor.java`**: El programa principal donde puedes escribir texto, deshacer o rehacer cambios.

## ¿Qué hace cada archivo?

###  `CustomStack.java`

Es una clase que crea una **pila genérica**, es decir, que puede guardar cualquier tipo de dato. Tiene estas funciones:

* **`push()`**: Agrega un elemento a la pila.
* **`pop()`**: Quita y devuelve el último elemento.
* **`peek()`**: Solo mira el último elemento (sin quitarlo).
* **`isEmpty()`**: Verifica si la pila está vacía.
* **`size()`**: Devuelve cuántos elementos hay en la pila.

> Nota: La pila tiene un tamaño máximo de 100 elementos.

###  `TextEditor.java`

Aquí está el funcionamiento del editor de texto. Usa dos pilas para controlar los cambios:

* **`undoStack`**: Guarda versiones anteriores del texto, por si quieres deshacer algo.
* **`redoStack`**: Guarda los cambios que deshiciste, por si los quieres rehacer.
* **`currentText`**: Guarda el texto actual que estás escribiendo.

#### 🔹 Funciones principales:

* **`writeText(String texto)`**: Escribe texto nuevo y lo guarda como nuevo estado. Borra los cambios que se podían rehacer.
* **`undo()`**: Revierte el último cambio (deshace lo que escribiste).
* **`redo()`**: Rehace el cambio que deshiciste, si no has escrito nada nuevo.
* **`getCurrentText()`**: Muestra el texto actual.
* **`displayMenu()`**: Muestra un menú interactivo en consola.



## ¿Cómo usar el programa?

### 1. Compila el programa

Abre una terminal o consola y escribe:

```bash
javac CustomStack.java TextEditor.java
```
### 2. Ejecuta el programa

Una vez compilado, ejecuta:

```bash
java TextEditor
```
##  Menú del programa

Cuando lo ejecutes, verás este menú en la consola:

```
--- Editor de Texto Simple ---
1. Escribir texto
2. Deshacer (Undo)
3. Rehacer (Redo)
4. Mostrar texto actual
5. Salir
```

Solo escribe el número de la opción que quieres usar.

---

##  Ejemplo de uso

```
Seleccione una opción: 1
Ingrese el texto a añadir: Hola
Texto actual: Hola

Seleccione una opción: 1
Ingrese el texto a añadir: mundo
Texto actual: Holamundo

Seleccione una opción: 2
Acción deshecha.
Texto actual: Hola

Seleccione una opción: 3
Acción rehecha.
Texto actual: Holamundo

Seleccione una opción: 5
Saliendo del editor.
```