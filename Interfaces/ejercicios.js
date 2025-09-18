// ejer 6
function addSemicolonAtEndOfLines(str) {
  return (str += ";");
}

let msg = "Hola mundo";
let msg2 = addSemicolonAtEndOfLines(msg);
console.log(msg);
console.log(msg2);

// ejer 7
function operaNumeros(a, b, operacion) {
  return operacion(a, b);
}

function suma(a, b) {
  return a + b;
}
function resta(a, b) {
  return a - b;
}

function multiplica(a, b) {
  return a * b;
}
function divide(a, b) {
  return a / b;
}

console.log(operaNumeros(4, 2, suma));
console.log(operaNumeros(4, 2, resta));
console.log(operaNumeros(4, 2, multiplica));
console.log(operaNumeros(4, 2, divide));

// ejer 8

function Semafoto() {
  this.color = "rojo";

  this.showState = function () {
    console.log("El semaforo está en " + this.color);
  };

  this.cambiarColor = function () {
    if (this.color == "rojo") {
      this.color = "amarillo";
    } else if (this.color == "amarillo") {
      this.color = "verde";
    } else if (this.color == "verde") {
      this.color = "rojo";
    }
  };
}

let semaforo = new Semafoto();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();
semaforo.cambiarColor();
semaforo.showState();

