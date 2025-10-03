// Función tipica
function sumar(a, b) {
  return a + b;
}

// Función lambda
let sumar2 = (a, b) => a + b;

// Función tipica
function meLLamo1() {
  return `AAAAAAAAAAAAAAAAAAAAAAAAAAAAAH `;
}

// Otra forma de declarar una función tipica
let meLLamo2 = function () {
  return `AAAAAAAAAAAAAAAAAAAAAAAAAAAAAH `;
};

// Función lambda
let meLLamo3 = () => `AAAAAAAAAAAAAAAAAAAAAAAAAAAAAH `;

// Array de números
const data = [3, 4, -8, 5];

// Función para comprobar si es positivo
function soloPositivos(num) {
  return num > 0;
}

// Filtra solo los números negativos llamando a una funcion
console.log(data.filter(soloPositivos)); // [3, 4, 5]

// Hace lo mismo pero usando una lambda
console.log(data.filter((num) => num > 0)); // [3, 4, 5]
