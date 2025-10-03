// Definición de un "constructor function"
function Student(name) {
  // Propiedad de la instancia
  this.name = name;
  // Método definido como arrow function (se crea para cada objeto)
  this.notaMedia = () => 9;
}

// Creación de un objeto con el constructor function
const manolita = new Student("Manolita");
