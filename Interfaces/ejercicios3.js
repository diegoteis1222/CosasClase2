const fullname = (name, surname) =>
  `Nombre: ${this.name}, Apellido ${this.surname}`;

const calculator = (a, b, operation) => {
  if (operation === "suma") return a + b;
  if (operation === "resta") return a - b;
  return 0;
};

const calculator2 = (a, b, operation) => {
  return operations[operation](a, b) || 0;
};

const operations = {
  suma: function (a, b) {
    return a + b;
  },
  resta: function (a, b) {
    return a - b;
  },
  division: function (a, b) {
    return a / b;
  },
};

const greets = () => "hola";

const printsgreets = () => console.log(greets);

const personCreator = (name, age) => ({
  name: name,
  age: age,
  gender: "male",
  state: "single",
});
