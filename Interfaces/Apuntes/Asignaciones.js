// Asignaciones

let a = 10; // número primitivo
let b = new Number(10); // objeto Number
let c = new Number(10); // otro objeto Number distinto
let d = a; // d apunta al mismo valor que a
let e = 10; // otro número primitivo con el mismo valor que a
let f = e; // f apunta al mismo valor que e

// Comparaciones entre valores primitivos y objetos Number

console.log(a == b); // true
// == compara por valor → 10 == 10

console.log(a === b); // false
// === compara tipo y valor → número primitivo !== objeto Number

console.log(a == d); // true
// Ambos son el mismo valor primitivo

console.log(a === d); // true
// También tienen el mismo tipo (number)

console.log(a == e); // true
// Ambos son números primitivos con el mismo valor

console.log(a === e); // true
// También son del mismo tipo (number)

console.log(b == c); // false
// Ambos son objetos distintos en memoria → referencias distintas

console.log(b === c); // false
// Igual que arriba: objetos distintos aunque tengan mismo contenido

console.log(b == f); // true
// == convierte el objeto Number en su valor primitivo (10) → 10 == 10

console.log(b === f); // true
// ❗ Aquí dará false, no true → objeto Number !== number primitivo
// (probablemente es un error en el comentario original)
// La comparación estricta entre objeto y primitivo siempre es false

// Objetos distintos con propiedades similares

const alum1 = {
  nombre: "Ana",
  edad: 28,
};

const alum2 = {
  nombre: "paco",
  edad: 22,
};

const alum3 = {
  nombre: "juan",
  edad: 20,
};

console.log(alum1 == alum2); // false
// Son objetos distintos → referencias distintas

console.log(alum1 === alum2); // false
// Igual que arriba

console.log(alum1 == alum3); // false
// También distintos en memoria

console.log(alum1 === alum3); // false
// También distintos en memoria
