// Arrays

let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// Muestra el primer elemento del array
console.log(arr[0]); // 1

// Muestra la cantidad de elementos que tiene el array
console.log(arr.length); // 10

// Función que recibe un número y devuelve su valor multiplicado por 2
function doblar(num) {
  return num * 2;
}

// Función que verifica si un número es par
function esPar(num) {
  return num % 2 == 0;
}

// Aplica la función 'doblar' a cada elemento de 'arr' y devuelve un nuevo array (no modifica el array original)
arr.map(doblar);

// Filtra los elementos de 'arr' dejando solo los que son pares
arr.filter(esPar);

// Une todos los elementos del array en un string separado por guiones
arr.join("-");

// Convierte el string '1-2-3-4-5-6-7-8-9-10' en un array separando por guiones
let mewArr = "1-2-3-4-5-6-7-8-9-10".split("-");
console.log(mewArr);

// Agrega el número 11 al final del array
arr.push(11);
console.log(arr);

// Elimina el último elemento del array
arr.pop();
console.log(arr);

// Agrega el número 0 al inicio del array
arr.unshift(0);
console.log(arr);

// Elimina el primer elemento del array
arr.shift();
console.log(arr);

// Elimina 1 elemento desde el índice 4 (el número 5)
arr.splice(4, 1);
console.log(arr);

// Crea una copia de una parte del array desde el índice 0 hasta el 4 (sin incluir el 5)
// OJO: slice NO modifica el array original
arr.slice(0, 5);
console.log(arr); // arr sigue igual que antes

// reverse

arr.reverse();
console.log(arr);
