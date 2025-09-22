function myFunction() {
  console.log(arguments[0]);
}

myFunction(2, 4, 5);
myFunction(3, 2);

function sumar(...n) {
  return n.reduce((a, b) => a + b);
}

console.log(sumar(5, 8, -1));
