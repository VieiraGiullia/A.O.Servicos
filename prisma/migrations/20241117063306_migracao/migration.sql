-- CreateTable
CREATE TABLE "curriculo" (
    "id" INTEGER NOT NULL,
    "name" TEXT NOT NULL,
    "endereco" TEXT NOT NULL,
    "contato" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "github" TEXT NOT NULL,
    "habilidades" TEXT NOT NULL,
    "objetivo" TEXT NOT NULL,

    CONSTRAINT "curriculo_pkey" PRIMARY KEY ("id")
);
