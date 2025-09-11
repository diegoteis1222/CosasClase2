// npm run (nombre del script en package.json)

import express from "express";
import dotenv from "dotenv";
dotenv.config();

let PORT = process.env.PORT;

const app = express();

app.get("/saluda", saludar);
app.get("/", inicio);

function inicio(req, res) {
  res.send("INICIOOOOOOOOOOOOOOOOOOO");
}

function saludar(req, res) {
  console.log("AAAAAAAAAAAAAAAH");
  res.send("ESTA VIVOOOOOOOOOOOOOOOO");
}

app.listen(PORT, () => console.log("Servidor arrancado en el puerto " + PORT));
