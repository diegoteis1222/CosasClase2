// ======================
// EJERCICIO
// ======================
// Constructor de cuenta bancaria
function CuentaBancaria(titular, saldoInicial) {
  this.titular = titular;       // Nombre del titular
  this.saldo = saldoInicial;    // Saldo inicial de la cuenta

  // Método para ingresar dinero
  this.ingresar = function (cantidad) {
    if (cantidad > 0) {         // Solo permite ingresar cantidades positivas
      this.saldo += cantidad;   // Suma la cantidad al saldo actual
    }
  };

  // Método para extraer dinero
  this.extraer = function (cantidad) {
    if (cantidad > 0 && cantidad < this.saldo) {
      // Solo permite extraer si es positivo y menor al saldo
      this.saldo -= cantidad;   // Resta la cantidad del saldo
    }
  };

  // Método para mostrar la información de la cuenta
  this.informar = function () {
    // Template string para imprimir titular y saldo
    console.log(`Titular: ${this.titular}, Saldo: ${this.saldo}`);
  };
}

// Creamos una cuenta
let cuenta = new CuentaBancaria("Diego", 1000);
cuenta.informar();   // Muestra saldo inicial
cuenta.ingresar(500); // Ingresa 500
cuenta.informar();   // Muestra saldo actualizado
cuenta.extraer(200); // Extrae 200
cuenta.informar();   // Muestra saldo final
console.log("\n");

// ======================
// EJERCICIO
// ======================
// Módulo readline para leer datos del usuario en consola
const readline = require("readline");

const configuracion = {
  input: process.stdin,   // Entrada estándar (teclado)
  output: process.stdout, // Salida estándar (consola)
};

const rl = readline.createInterface(configuracion);

// Función que maneja el número ingresado por el usuario
function trabajarConNumero(num) {
  console.log(`El número es: ${num}`); // Muestra el número
  rl.close(); // Cierra la interfaz para no quedar bloqueado
}

// Pregunta al usuario por un número y llama a la función anterior
rl.question(`Dame un número: `, trabajarConNumero);
console.log("\n");

// ======================
// EJERCICIO
// ======================
// Constructor de coche
function coche() {
  this.marca = "Toyota"; // Marca por defecto
}

// Constructor de moto
function moto() {
  this.marca = "Honda";  // Marca por defecto
}

// Creamos instancias
let miCoche = new coche();
let miMoto = new moto();

// instanceof verifica si un objeto fue creado con un constructor específico
console.log(miCoche instanceof coche); // true, miCoche es un coche
console.log(miMoto instanceof moto);   // true, miMoto es una moto
console.log(miCoche instanceof moto);  // false, miCoche no es una moto
console.log(miMoto instanceof coche);  // false, miMoto no es un coche
