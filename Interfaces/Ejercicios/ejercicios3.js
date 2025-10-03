// ======================
// EJERCICIO
// ======================
// Intento de función flecha para mostrar nombre y apellido usando "this"
const fullname = (name, surname) =>
  `Nombre: ${this.name}, Apellido ${this.surname}`;

// ⚠ Nota: Esto NO funcionará como se espera porque las funciones flecha
// NO tienen su propio "this". Aquí "this.name" y "this.surname" serán undefined
// cuando se invoque fullname(). Para acceder a los parámetros se debería usar:
// const fullname = (name, surname) => `Nombre: ${name}, Apellido: ${surname}`;

// ======================
// EJERCICIO
// ======================
// Función que hace operaciones básicas con condicionales
const calculator = (a, b, operation) => {
  if (operation === "suma") return a + b;
  if (operation === "resta") return a - b;
  return 0; // Devuelve 0 si no coincide ninguna operación
};

// ======================
// EJERCICIO
// ======================
// Versión mejorada usando un objeto para mapear operaciones
const calculator2 = (a, b, operation) => {
  // operations[operation] devuelve la función correspondiente
  // Si no existe, devuelve undefined y usamos "|| 0" para retornar 0
  return operations[operation](a, b) || 0;
};

// Objeto con funciones de operaciones
const operations = {
  suma: function (a, b) {
    return a + b;
  },
  resta: function (a, b) {
    return a - b;
  },
  division: function (a, b) {
    return a / b;
  },
};

// ======================
// EJERCICIO
// ======================
// Función flecha que devuelve un saludo
const greets = () => "hola";

// Función que imprime la referencia a la función greets
// ⚠ Nota: No llama a greets(), solo imprime la función misma
const printsgreets = () => console.log(greets);

// ======================
// EJERCICIO
// ======================
// Función que crea objetos "persona" de manera concisa
const personCreator = (name, age) => ({
  name: name,   // propiedad name
  age: age,     // propiedad age
  gender: "male", // propiedad por defecto
  state: "single" // propiedad por defecto
});

// Ejemplo de uso
const person1 = personCreator("Diego", 22);
console.log(person1);
// Output: { name: "Diego", age: 22, gender: "male", state: "single" }
