// map

let numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map((num) => num * 2);
console.log(doubled);

// filter

numbers = [1, 2, 3, 4, 5];
const odd = numbers.filter((num) => num % 2 !== 0);
console.log(odd);

// reduce
numbers = [1, 2, 3, 4, 5];
const sumas = numbers.reduce((acc, num) => acc + num, 0);
console.log(sumas);

const sumasReverso = numbers.reduceRight((acc, num) => acc + num, 0);
console.log(sumasReverso);

// for each

numbers = [1, 2, 3, 4, 5];
numbers.forEach((num) => console.log(num));
numbers.forEach((num, index) => console.log(`Index: ${index}, Value: ${num}`));

// find
numbers = [1, 2, 3, 4, 5];
const found = numbers.find((num) => num > 3);
console.log(found);

// some
numbers = [1, 2, 3, 4, 5];
const hasEven = numbers.some((num) => num % 2 === 0);
console.log(hasEven);

// every
numbers = [1, 2, 3, 4, 5];
const allPositive = numbers.every((num) => num > 0);
console.log(allPositive);

// sort
numbers = [5, 3, 8, 1, 2];
numbers.sort();
console.log(numbers);

numbers.sort((a, b) => a - b);
console.log(numbers);

//concat
const array1 = [1, 2, 3];
const array2 = [4, 5, 6];
const combined = array1.concat(array2);
console.log(combined);
console.log(...array1, ...array2);

// slice
numbers = [1, 2, 3, 4, 5];
const sliced = numbers.slice(1, 4);
console.log(sliced); // [2, 3, 4]

// splice
numbers = [1, 2, 3, 4, 5];
numbers.splice(2, 1, 'a', 'b');
console.log(numbers); // [1, 2, 'a', 'b', 4, 5]

// flat

numbers = [1, 2, [3, 4], [5, 6]];
const flattened = numbers.flat();
console.log(flattened); // [1, 2, 3, 4, 5, 6]