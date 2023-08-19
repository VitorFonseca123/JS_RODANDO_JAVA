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


  shell.cd('../java');
  shell.exec(`java -cp bin GeradorDeRelatorios ${modifiedString}`);
});
app.get('/executar-algo', (req, res) => {
  // Aqui você pode adicionar a lógica que deseja executar quando o botão for clicado
  console.log('Botão clicado! Fazendo algo...');
  res.send('Algo foi executado no java');
  shell.cd('../java');
  shell.exec(`java -cp bin GeradorDeRelatorios`);
});
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
