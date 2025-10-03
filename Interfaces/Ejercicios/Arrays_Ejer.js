// Ejercicio para Arrays en JS
let array = [
  1,
  2,
  3,
  4,
  5,
  6,
  7,
  8,
  9,
  10,
  function esPositivo(num) {
    return num > 0;
  },
  (producto = {
    nombre: "cosa1",
    precio: 20,
    disponible: true,
  }),
  true,
];

// Muestra el primer elemento del array (posición 0)
console.log(array[0]); // 1

// Ejecuta la función esPositivo que está en la posición 10 del array, pasándole el número 5
console.log(array); // true

// Accede al objeto que está en la posición 11 del array y muestra su propiedad 'nombre'
console.log(array[11].nombre); // "cosa1"

// Agrega el número 0 al inicio del array
array.unshift(0);

// Agrega el valor booleano false al final del array
array.push(false);

// Muestra la cantidad de elementos que hay actualmente en el array
console.log(array.length);
