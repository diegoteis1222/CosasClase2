// ejer9
function CuentaBancaria(titular, saldoInicial) {
  this.titular = titular;
  this.saldo = saldoInicial;

  this.ingresar = function (cantidad) {
    if (cantidad > 0) {
      this.saldo += cantidad;
    }
  };

  this.extraer = function (cantidad) {
    if (cantidad > 0 && cantidad < this.saldo) {
      this.saldo -= cantidad;
    }
  };

  this.informar = function () {
    console.log(`itular: ${this.titular}, Saldo: ${this.saldo}`); // templates para no cerrar las comillas cada puta vez
  };
}

let cuenta = new CuentaBancaria("Diego", 1000);
cuenta.informar();
cuenta.ingresar(500);
cuenta.informar();
cuenta.extraer(200);
cuenta.informar();

// ejer 10

const readline = require("readline");

const configuracion = {
  input: process.stdin,
  output: process.stdout,
};
const rl = readline.createInterface(configuracion);

// la wea de arriba es re importante: es el Scanner de JS

function trabajarConNumero(num) {
  console.log(`El numero es: ${num}`);
  rl.close();
}

rl.question(`dame un numero: `, trabajarConNumero);

// ejer 12 porque el 11 nos lo fumamos

function coche() {
  this.marca = "Toyota";
}

function moto() {
  this.marca = "Honda";
}

let miCoche = new coche();
let miMoto = new moto();

console.log(miCoche instanceof coche);
console.log(miMoto instanceof moto);
console.log(miCoche instanceof moto);
console.log(miMoto instanceof coche);

