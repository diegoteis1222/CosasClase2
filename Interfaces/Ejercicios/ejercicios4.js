// ======================
// EJERCICIO
// ======================
// Objeto con información de una película favorita
let favouriteFilms = {
  title: "Wall-E",
  director: "Andrew Stanton",
  year: 2008,
};
console.log(favouriteFilms); // Muestra el objeto completo

// Acceso a propiedades usando notación de punto
let title = favouriteFilms.title;
let director = favouriteFilms.director;
console.log(`My favourite film is ${title}, directed by ${director}`);

// Desestructuración de objeto
let { title: t, director: d } = favouriteFilms;
console.log(`My favourite film is ${t}, directed by ${d}`);

// ======================
// EJERCICIO
// ======================
// Función que devuelve un array (ojo: aquí NO se devuelve nada realmente)
function favouriteDirectors() {
  ["Steven Spielberg", "Martin Scorsese", "Christopher Nolan"];
}

// Las siguientes líneas darán error porque favouriteDirectors() no retorna nada
// let director1 = favouriteDirectors()[0];
// let director2 = favouriteDirectors()[1];
// let director3 = favouriteDirectors()[2];

// Función correcta que sí devuelve el array
function favouriteDirectors2() {
  return ["Steven Spielberg", "Martin Scorsese", "Christopher Nolan"];
}

// Desestructuración de arrays, saltando el segundo elemento
let [d1, , d3] = favouriteDirectors2();

// ======================
// EJERCICIO
// ======================
// Función que devuelve un objeto con info de un actor
function favouriteActor() {
  return {
    name: "Leonardo DiCaprio",
    age: 48,
    isSinglre: false, // ❌ typo: debería ser isSingle
    money: 324234234,
  };
}

// Acceso a propiedades
let theName = favouriteActor().name;
let theAge = favouriteActor().age;

// ======================
// EJERCICIO
// ======================
// Objeto con información de un profesor y su escuela
const angelTeacher = {
  id: 40,
  name: "Ángel",
  school: {
    name: "Cebem",
    address: "Hispanidad 33",
  },
};

// Desestructuración anidada
const {
  name,
  school: { address },
} = angelTeacher;

console.log(`El profe ${name} trabaja en la calle ${address}`);

// ======================
// EJERCICIO
// ======================
// Concatenación de arrays usando spread operator
let numbers = [1, 2, 3, 4, 5];
let newNumbers = [6, 7, 8, 9, 10];
let allNumbers = [...numbers, ...newNumbers]; // Combina ambos arrays
console.log(allNumbers);

// ======================
// EJERCICIO
// ======================
// Conversión de objeto a JSON y viceversa
const edificio = {
  altura: 100,
  numeroDePlantas: 20,
  direccion: "Calle Falsa 123",
};

const edificioJSON = JSON.stringify(edificio); // Convierte a string JSON
console.log(edificioJSON);

const edificioObjeto = JSON.parse(edificioJSON); // Convierte JSON a objeto
console.log(edificioObjeto);

// ======================
// EJERCICIO
// ======================
// Objeto que simula una máquina de café
let maquinaCafe = {
  cantidadAzucar: 10,
  tipoCafe: "Expreso, Café con leche, Capuchino",
  hacerCafe: function () {
    // setTimeout con arrow function para mantener "this" del objeto
    setTimeout(() => {
      console.log(`Haciendo un café ${this.tipoCafe}`);
    }, 3000); // Espera 3 segundos
  },
};

maquinaCafe.hacerCafe();

// ======================
// EJERCICIO
// ======================
// Clase Cuadrado
class Cuadrado {
  constructor(lado) {
    this.lado = lado;
  }
  getArea() {
    return this.lado * this.lado;
  }
}

// Clase Rectangulo hereda de Cuadrado
class Rectangulo extends Cuadrado {
  constructor(lado1, lado2) {
    super(lado1); // Llama al constructor de Cuadrado
    this.lado2 = lado2;
  }
  getArea() {
    return this.lado * this.lado2; // Área de rectángulo
  }
}

let miRect = new Rectangulo(5, 10);
console.log(miRect.getArea()); // 50

// ======================
// EJERCICIO
// ======================
// Clase Habitante con método estático
class Habitante {
  constructor(nombre) {
    this.nombre = nombre;
  }
  // Método estático (se puede llamar sin crear instancia)
  static get contadorHabitantes() {}
}

// Nota: contadorHabitantes no hace nada, solo está definido
