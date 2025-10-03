// MAP -> crea un nuevo array transformando cada elemento
let numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map((num) => num * 2);
console.log("map:", doubled); // [2, 4, 6, 8, 10]

// FILTER -> crea un nuevo array con los elementos que cumplen la condición
numbers = [1, 2, 3, 4, 5];
const odd = numbers.filter((num) => num % 2 !== 0);
console.log("filter:", odd); // [1, 3, 5]

// REDUCE -> reduce el array a un solo valor (de izquierda a derecha)
numbers = [1, 2, 3, 4, 5];
const sumas = numbers.reduce((acc, num) => acc + num, 0);
console.log("reduce:", sumas); // 15

// REDUCERIGHT -> igual que reduce pero empieza de derecha a izquierda
const sumasReverso = numbers.reduceRight((acc, num) => acc + num, 0);
console.log("reduceRight:", sumasReverso); // 15

// FOREACH -> recorre el array pero no devuelve nada
numbers = [1, 2, 3, 4, 5];
numbers.forEach((num) => console.log("forEach:", num));
numbers.forEach((num, index) =>
  console.log(`forEach index=${index}, value=${num}`)
);

// FIND -> devuelve el primer elemento que cumple la condición
numbers = [1, 2, 3, 4, 5];
const found = numbers.find((num) => num > 3);
console.log("find:", found); // 4

// SOME -> devuelve true si al menos un elemento cumple la condición
numbers = [1, 2, 3, 4, 5];
const hasEven = numbers.some((num) => num % 2 === 0);
console.log("some:", hasEven); // true

// EVERY -> devuelve true si todos cumplen la condición
numbers = [1, 2, 3, 4, 5];
const allPositive = numbers.every((num) => num > 0);
console.log("every:", allPositive); // true

// SORT -> ordena el array
numbers = [5, 3, 8, 1, 2];
numbers.sort();
console.log("sort (como string):", numbers); // [1, 2, 3, 5, 8]

numbers.sort((a, b) => a - b);
console.log("sort (numérico):", numbers); // [1, 2, 3, 5, 8]

// CONCAT -> une arrays en uno nuevo
const array1 = [1, 2, 3];
const array2 = [4, 5, 6];
const combined = array1.concat(array2);
console.log("concat:", combined); // [1, 2, 3, 4, 5, 6]

// Spread operator -> alternativa a concat
console.log("spread:", ...array1, ...array2); // 1 2 3 4 5 6

// SLICE -> devuelve una copia de una parte del array
numbers = [1, 2, 3, 4, 5];
const sliced = numbers.slice(1, 4);
console.log("slice:", sliced); // [2, 3, 4]

// SPLICE -> modifica el array (elimina y/o agrega)
numbers = [1, 2, 3, 4, 5];
numbers.splice(2, 1, "a", "b");
console.log("splice:", numbers); // [1, 2, 'a', 'b', 4, 5]

// FLAT -> aplana un array de arrays en uno solo
numbers = [1, 2, [3, 4], [5, 6]];
const flattened = numbers.flat();
console.log("flat:", flattened); // [1, 2, 3, 4, 5, 6]
