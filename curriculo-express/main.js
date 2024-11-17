import express from 'express'
import dotenv from 'dotenv'
import { createCurriculo, getAllCurriculos } from './adapters/prismaAdapter.js';

dotenv.config()

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json()); 

// Rota de teste
app.get('/', (req, res) => {
  res.send('Servidor funcionando!');
});

// Rota para criar novo curriculo
app.post('/novoCurriculo', async (req, res) => {
  try {
    const curriculoData = req.body;
    const newCurriculo = await createCurriculo(curriculoData);
    res.status(201).json(newCurriculo); // Retorna o currículo criado com status 201
  } catch (error) {
    console.error("Erro ao criar currículo:", error);
    res.status(500).json({ error: 'Erro ao criar currículo' });
  }
});

// Rota para buscar todos os currículos
app.get('/todosCurriculos', async (req, res) => {
  try {
    const curriculos = await getAllCurriculos();
    res.status(200).json(curriculos); // Retorna a lista de currículos com status 200
  } catch (error) {
    console.error("Erro ao buscar currículos:", error);
    res.status(500).json({ error: 'Erro ao buscar currículos' });
  }
});

// Inicia o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
