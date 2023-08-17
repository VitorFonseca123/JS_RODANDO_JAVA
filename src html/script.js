const express = require('express');
const fs = require('fs'); // Módulo File System do Node.js
const app = express();
const port = 3000;
var shell = require('shelljs');
app.use(express.urlencoded({ extended: true }));
app.use(express.static('public')); // Define o diretório 'public' como estático

app.get('/', (req, res) => {
  fs.readFile('teste.html', 'utf8', (err, content) => {
    if (err) {
      res.status(500).send('Erro ao ler o arquivo HTML.');
    } else {
      res.send(content);
    }
  });
});

app.post('/submit', (req, res) => {
  const { name, email } = req.body;
  const modifiedString = name.replace(/\s+/g, "_");
  res.send(`Dados recebidos:<br>Nome: ${modifiedString}`);

  shell.cd('../java');
  shell.exec(`java -cp bin GeradorDeRelatorios ${modifiedString}`);
});

app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
