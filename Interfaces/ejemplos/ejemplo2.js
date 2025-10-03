let Inquilino = {
  nombre: "Ana",
  edad: 28,
  esEstudiante: false,
  direccion: {
    calle: "Calle Falsa 123",
    ciudad: "Springfield",
    pais: "USA",
  },
};

console.log(Inquilino.nombre);
console.log(Inquilino.direccion.calle);
console.log(Inquilino["direccion"]["calle"]);

console.log(Inquilino["nombre"]);

let c = {
  nombre: "Juan",
};

let d = c;

d.nombre = "Pepe";

console.log(c.nombre);
console.log(d.nombre);

let m = 5;
let n = m;
n = 10;

console.log(m);
console.log(n);

let usuario = {
  nombre: "Ana",
  edad: 28,
};

function saludar(datos) {
  console.log(`Hola, mi nombre es ${datos.nombre}`);
}

saludar(usuario);

function apuñalar(apuñalamiento) {
  apuñalamiento();
}

function apuñalarVieja() {
  console.log("Vieja apuñalada");
}

function apuñalarJoven() {
  console.log("Joven apuñalado");
}

apuñalar(apuñalarVieja);
apuñalar(apuñalarJoven);

function construirUsuario(nombre, edad) {
  return {
    nombre: nombre,
    edad: edad,
  };
}

function generarFuncion() {
  return function () {
    console.log("Hola");
  };
}

function a() {
  console.log("a");
}

a.nombre = "funcion a";
console.log(a.nombre);
a();

let persona = {
  nombre: "Ana",
  edad: 28,
  saludar: function () {
    console.log(`Hola, mi nombre es ${this.nombre}`);
  },
};

console.log(persona.nombre);
persona.saludar();
