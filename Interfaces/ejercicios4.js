let favouriteFilms = {
  title: "Wall-E",
  director: "Andrew Stanton",
  year: 2008,
};
console.log(favouriteFilms);

let title = favouriteFilms.title;
let director = favouriteFilms.director;

console.log(`My favourite film is ${title}, directed by ${director}`);

let { title: t, director: d } = favouriteFilms;
console.log(`My favourite film is ${t}, directed by ${d}`);

function favouriteDirectors() {
  ["Steven Spielberg", "Martin Scorsese", "Christopher Nolan"];
}

let director1 = favouriteDirectors()[0];
let director2 = favouriteDirectors()[1];
let director3 = favouriteDirectors()[2];

function favouriteDirectors2() {
  return ["Steven Spielberg", "Martin Scorsese", "Christopher Nolan"];
}

let [d1, , d3] = favouriteDirectors2();

function favouriteActor() {
  return {
    name: "Leonardo DiCaprio",
    age: 48,
    isSinglre: false,
    money: 324234234,
  };
}

let theName = favouriteActor().name;
let theAge = favouriteActor().age;

const angelTeacher = {
  id: 40,
  name: "Ángel",
  school: {
    name: "Cebem",
    address: "Hispanidad 33",
  },
};

const {
  name,
  school: { address },
} = angelTeacher;

console.log(`El profe ${name} trabaja en la calle ${address}`);

let numbers = [1, 2, 3, 4, 5];
let newNumbers = [6, 7, 8, 9, 10];

let allNumbers = [...numbers, ...newNumbers];
console.log(allNumbers);

const edificio = {
  altura: 100,
  numeroDePlantas: 20,
  direccion: "Calle Falsa 123",
};

// Convertir el objeto a JSON
const edificioJSON = JSON.stringify(edificio);
console.log(edificioJSON);

// Convertir el JSON de vuelta a un objeto
const edificioObjeto = JSON.parse(edificioJSON);
console.log(edificioObjeto);

let maquinaCafe = {
  cantidadAzucar: 10,
  tipoCafe: "Expreso, Café con leche, Capuchino",
  hacerCafe: function () {
    setTimeout(() => {
      console.log(`Haciendo un café ${this.tipoCafe}`);
    }, 3000);
  },
};

maquinaCafe.hacerCafe();
