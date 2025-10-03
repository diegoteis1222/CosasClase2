// Colecciones
let items = new Set();

// Agregamos elementos al conjunto
items.add(1);
items.add(2);
items.add(3);
items.add(4);
items.add(5);
items.add(5); // No se añade porque ya existe en el conjunto (los Set no permiten duplicados)

// Muestra la cantidad de elementos únicos que hay en el conjunto
console.log(items.size); // 5

// Verifica si el valor 3 está en el conjunto → devuelve true
items.has(3);

// Verifica si el valor 6 está en el conjunto → devuelve false
items.has(6);

// Elimina el elemento con valor 4 del conjunto
items.delete(4);

// Elimina todos los elementos del conjunto, dejándolo vacío
items.clear();
