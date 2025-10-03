// Mapas
let mapa = new Map();

// Agregamos pares clave-valor al mapa
mapa.set("nombre", "Ana");
mapa.set("edad", 28);
mapa.set("ciudad", "Madrid");

// Obtiene el valor asociado a la clave "edad"
console.log(mapa.get("edad")); // 28

// Verifica si existe la clave "ciudad" en el mapa
console.log(mapa.has("ciudad")); // true

// Elimina la clave "ciudad" y su valor del mapa
mapa.delete("ciudad");

// Verifica si la clave "ciudad" existe (ya no debería existir)
mapa.has("ciudad"); // false

// Muestra cuántos elementos quedan en el mapa
console.log(mapa.size); // 2

// Elimina todos los elementos del mapa
mapa.clear();

// Se crea un Map vacío llamado "studiantes"
const studiantes = new Map();

// Se agregan elementos al Map usando .set(clave, valor)
studiantes.set("david", 2); // clave: "david", valor: 2
studiantes.set("ana", 9); // clave: "ana", valor: 9

// Recorre todas las CLAVES del Map
for (let key of studiantes.keys()) {
  console.log(key); // Muestra: "david", luego "ana"
}

// Recorre todos los VALORES del Map
for (let value of studiantes.values()) {
  console.log(value); // Muestra: 2, luego 9
}

// Recorre el Map completo (clave y valor)
for (let [key, value] of studiantes.entries()) {
  console.log(key, value); // Muestra: "david 2", luego "ana 9"
}
