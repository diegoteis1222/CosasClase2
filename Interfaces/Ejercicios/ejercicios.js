// ======================
// EJERCICIO
// ======================
// Función que agrega un punto y coma al final de un string
function addSemicolonAtEndOfLines(str) {
  // Devuelve una nueva cadena con un ";" agregado al final
  return str + ";"; 
}

// Declaramos una cadena
let msg = "Hola mundo";

// Llamamos a la función y guardamos el resultado
let msg2 = addSemicolonAtEndOfLines(msg);

console.log("Ejercicio:");
// Mostramos el valor original
console.log("msg original:", msg);     // Hola mundo
// Mostramos el valor modificado por la función
console.log("msg modificado:", msg2); // Hola mundo;
console.log("\n"); // Salto de línea para separar ejercicios

// ======================
// EJERCICIO
// ======================
// Función que recibe dos números y otra función que indica la operación a realizar
function operaNumeros(a, b, operacion) {
  return operacion(a, b); // Llama a la función pasada con los dos números
}

// Definimos funciones básicas para operaciones matemáticas
function suma(a, b) { return a + b; }
function resta(a, b) { return a - b; }
function multiplica(a, b) { return a * b; }
function divide(a, b) { return a / b; }

console.log("Ejercicio:");
// Llamamos a operaNumeros con cada operación
console.log("suma:", operaNumeros(4, 2, suma));         // 6
console.log("resta:", operaNumeros(4, 2, resta));       // 2
console.log("multiplica:", operaNumeros(4, 2, multiplica)); // 8
console.log("divide:", operaNumeros(4, 2, divide));     // 2
console.log("\n");

// ======================
// EJERCICIO
// ======================
// Clase para modelar un semáforo usando ES6
class Semaforo {
  constructor() {
    this.color = "rojo"; // Estado inicial del semáforo
  }

  // Método para mostrar el color actual
  showState() {
    console.log("El semáforo está en", this.color);
  }

  // Método para cambiar de color siguiendo el ciclo: rojo -> amarillo -> verde -> rojo
  cambiarColor() {
    if (this.color === "rojo") {
      this.color = "amarillo";
    } else if (this.color === "amarillo") {
      this.color = "verde";
    } else {
      this.color = "rojo";
    }
  }
}

console.log("Ejercicio:");
// Creamos un semáforo
let semaforo = new Semaforo();

// Simulamos 6 cambios de estado para ver el ciclo completo
for (let i = 0; i < 6; i++) {
  semaforo.showState();    // Muestra el color actual
  semaforo.cambiarColor(); // Cambia al siguiente color
}
