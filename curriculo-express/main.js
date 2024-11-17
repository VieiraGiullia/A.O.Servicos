import express from 'express'
import dotenv from 'dotenv'

dotenv.config()

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json()); 

// Rota de teste
app.get('/', (req, res) => {
  res.send('Servidor funcionando!');
});

// Rota para criar novo curriculo

// Inicia o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
