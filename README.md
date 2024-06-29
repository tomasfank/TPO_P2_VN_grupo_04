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
#### 2.1 - Stack genérico e invertir sus elementos. (Rodrigo Nieva)

Se creó la clase `GenericStack`  en `org.example.classes` y una interfaz `iGenericStack` en `org.example.interfaces`. La implementación utiliza una clase genérica para permitir que la pila almacene elementos de cualquier tipo gracias al uso de `<T>`. Se han implementado métodos como `add`, `remove`, `top` y `isEmpty` para manipular y consultar la pila.

La solución del ejercicio se encuentra en la carpeta `Generic Util` en `org.example.utils` para que el usuario llame el método cuando lo necesite.


#### 2.2 - Copiar un set genérico. (Rodrigo Nieva)
Se creó la clase `Generic Set` en `org.example.classes` y una interfaz `iGenericSet` en `org.example.interfaces`. La implementación utiliza una clase genérica para permitir copiar elementos de cualquier tipo. En ella se encuentran los métodos `add`, `remove`, `isEmpty`. `choose`. `contains`.

La solución del ejercicio se encuentra en la carpeta `Generic Util` en `org.example.utils` para que el usuario llame el método cuando lo necesite.

### Ejercicio 3 (Lorenzo Cucco Nagore)
`QueueOfQueue` es una clase en `org.example.classes`. Ahí se encuentran los distintos métodos utilizados en la clase. Contamos con los métodos análogos a Queues y los solicitados `concaténate`, `flat` y `reverseWithDepth`. Así mismo se modifica el método `toString` a fines de testeo de los métodos antes mencionados. 

Los ítems 1, 2 y 3 están implementados en la clase `Ejercicio3` de `org.example.exercises.ejercicio3`. 
Dentro de esta clase, se deja a disposición el código para probar las distintos métodos solicitados. Cómo los métodos implementados afectan a las QueueOfQueue generados en el test, se procede a dejar como comentario las funciones que no se desean evaluar en esa instancia.

### Ejercicio 4

### Ejercicio 5
#### 5.1 Pila ordenada sin repetidos (Rodrigo Nieva)
La solución se encuentra en `org.example.exercises.ejercicio2_5` clase: `ejercicio1`. En el ejercicio reutilizamos las clases creadas en el  *Ejercicio 2*: *GenericStack* y *GenericSet*. También, en el mismo código está escrito su complejidad computacional. 

#### 5.2 - Cifrado Cesar (Alejo Keuroghlanian)
 La solución está implementada en la clase `CesarCipher` en `org.example.exercises.ejercicio5_2_Cesar`. Se implementó la solución usando una clase *ad-hoc*, `GenericStaticDictionary` en `org.example.classes`.
 En la clase `Main` de `org.example.exercises.ejercicio5_2_Cesar` se muestra el funcionamiento de la clase `CesarCipher`, encriptando y desencriptando una frase, dejando que el usuario elija la clave para encriptar, y mostrando cómo la clase desencripta el texto.
 
#### 5.3 - Paréntesis balanceados modificado (Rodrigo Nieva)
Como se puede realizar de muchas maneras, nuevamente se reutilizó *GenericStack*. La solución se encuentra en `org.example.exercises.ejercicio2_5` en la clase `ejercicio3` junto a su complejidad computacional.

####  5.4 - Método Montecarlo para la estimación de $\pi$. (Alejo Keuroghlanian)

La solución está implementada en las clases `CalculadoraPi` (donde se lleva a cabo la aproximación de $\pi$) y `Montecarlo`, en `org.example.exercises.ejercicio5Montecarlo`. En la solución hacemos uso de las clases `R2Point` y `SetOfR2Points`, en `org.example.classes`.

### Ejercicio 6

#### 6.3 - Cola dinámica cíclica doblemente enlazada (Lorenzo Cucco Nagore)
 La solución está implementada en la clase `Ejercicio6_3` en `org.example.exercises.ejercicio6`. Se implementó la solución usando una clase *ad-hoc*, `DoublyLinkedQueue` en `org.example.classes.dynamic.nodes`.
 En la clase `Main` de `org.example.exercises.Ejercicio6_3` se muestra el funcionamiento de la clase `DoublyLinkedQueue`, añadiendo elementos a la cola, eliminando, verificando si la cola está vacía, obteniendo los nodos anteriores y siguientes y el vaciado final de la cola.

#### 6.4 - Conjunto con repetidos (Lorenzo Cucco Nagore)
La solución está implementada en la clase `Ejercicio6_4` en `org.example.exercises.ejercicio6`. Se implementó la solución usando una clase *ad-hoc*, `MultiSet` en `org.example.classes`.
En la clase `Main` de `org.example.exercises.Ejercicio6_4` se muestra el funcionamiento de la clase `MultiSet`.

#### 6.5 - Diccionario aleatorio (Rodrigo Nieva)
Para dar con la solución, se creó la implmenteación (nuevo TDA) `RandomDictionary` en `org.example.classes` y su interfaz `MultipleDictionary` en `org.example.classes`. El TDA está testeado y en funcionamiento para cuando el usuario lo necesite.
