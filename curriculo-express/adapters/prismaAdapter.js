import { PrismaClient } from '@prisma/client'
const prisma = new PrismaClient();

// cria um novo currículo
async function createCurriculo(curriculoData) {
  try {
    const newCurriculo = await prisma.curriculo.create({
      data: curriculoData,
    });
    return newCurriculo;
  } catch (error) {
    console.error("Erro ao criar currículo:", error);
    throw error;
  }
}

// busca todos os currículos
async function getAllCurriculos() {
  try {
    const curriculos = await prisma.curriculo.findMany();
    return curriculos;
  } catch (error) {
    console.error("Erro ao buscar currículos:", error);
    throw error;
  }
}

export {
    createCurriculo,
    getAllCurriculos
}