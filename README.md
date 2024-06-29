# Programación 2 - Trabajo Práctico Obligatorio
## Turno: Viernes-Noche; Grupo 4
### Integrantes:

 1. Lorenzo Cucco Nagore
 2. Tomás Fank
 3. Alejo Keuroghlanian
 4. Rodrigo Nieva

## Introducción
La resolución de los distintos ejercicios fue implementada a través de distintas clases que representan TDA's y/o que representan funciones auxiliares (*Utils*) para permitir operaciones con esas clases. A continuación una explicación de cómo rastrear las distintas partes que constituyen la resolución de cada ejercicio.

### Ejercicio 1 (Alejo Keuroghlanian)
`QueueOfStacks` es una clase en `org.example.classes`. Ahí se encuentra el análisis de la complejidad de sus distintos métodos.

Los ítems 1, 2 y 3 están implementados en la clase `ejercicio1` de `org.example.exercises`. Allí se hace uso de clases con métodos auxiliares, como `StackUtils` y `QueueOfStacksUtils`.
`ejercicio1Test` es una clase para probar *a mano* (por ejemplo, corriéndolo en modo *debugging*) el funcionamiento de las clases implementadas. No es un test unitario ni nada por el estilo.
 
El análisis de la complejidad se agregó como comentarios al final de las líneas correspondientes. Cada método lleva el análisis de su complejidad debajo de la firma, como comentarios en varias líneas.

### Ejercicio 2

### Ejercicio 3

### Ejercicio 4

### Ejercicio 5
#### 5.1
#### 5.2 - Cifrado Cesar (Alejo Keuroghlanian)
 La solución está implementada en la clase `CesarCipher` en `org.example.exercises.ejercicio5_2_Cesar`. Se implementó la solución usando una clase *ad-hoc*, `GenericStaticDictionary` en `org.example.classes`.
 En la clase `Main` de `org.example.exercises.ejercicio5_2_Cesar` se muestra el funcionamiento de la clase `CesarCipher`, encriptando y desencriptando una frase, dejando que el usuario elija la clave para encriptar, y mostrando cómo la clase desencripta el texto.
#### 5.3
####  5.4 - Método Montecarlo para la estimación de $\pi$. (Alejo Keuroghlanian)
La solución está implementada en las clases `CalculadoraPi` (donde se lleva a cabo la aproximación de $\pi$) y `Montecarlo`, en `org.example.exercises.ejercicio5Montecarlo`. En la solución hacemos uso de las clases `R2Point` y `SetOfR2Points`, en `org.example.classes`.
