function myFunction() {
  // 'arguments' es un objeto especial disponible en todas las funciones normales de JavaScript.
  // Contiene todos los parámetros pasados, aunque no estén declarados explícitamente.
  console.log(arguments[0]); // imprime solo el primer argumento recibido.
}

myFunction(2, 4, 5); // imprime 2 (primer argumento).
myFunction(3, 2);    // imprime 3 (primer argumento).

// Ahora se define una función con el operador "rest" (...n).
function sumar(...n) {
  // 'n' se convierte en un arreglo que contiene todos los argumentos pasados.
  // Ejemplo: sumar(5, 8, -1) -> n = [5, 8, -1]
  return n.reduce((a, b) => a + b); 
  // reduce() recorre el arreglo acumulando la suma: ((5 + 8) + -1) = 12.
}

console.log(sumar(5, 8, -1)); // imprime 12
