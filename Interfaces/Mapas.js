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
