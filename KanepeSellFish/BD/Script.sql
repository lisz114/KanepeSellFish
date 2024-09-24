CREATE Schema IF NOT EXISTS Kanepe;

USE Kanepe;

-- -----------------------------------------------------
-- Table Usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuarios (
    idUsuarios INT NOT NULL AUTO_INCREMENT,
    nome_Usuario VARCHAR(100) NOT NULL,
    senha_Usuario VARCHAR(100) NOT NULL,
    email_Usuario VARCHAR(100) NOT NULL,
    PRIMARY KEY (idUsuarios)
);

-- -----------------------------------------------------
-- Table Enderecos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Enderecos (
    idEnderecos INT NOT NULL,
    Cidade VARCHAR(100) NOT NULL,
    Rua VARCHAR(100) NOT NULL,
    Bairro VARCHAR(100) NOT NULL,
    PRIMARY KEY (idEnderecos)
);

-- -----------------------------------------------------
-- Table Produtores
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produtores (
    idProdutores INT NOT NULL AUTO_INCREMENT,
    nomeNegocio VARCHAR(100) NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Usuarios_idUsuarios INT NOT NULL,
    Enderecos_idEnderecos INT NOT NULL,
    PRIMARY KEY (idProdutores),
    FOREIGN KEY (Usuarios_idUsuarios) REFERENCES Usuarios (idUsuarios),
    FOREIGN KEY (Enderecos_idEnderecos) REFERENCES Enderecos (idEnderecos)
);

-- -----------------------------------------------------
-- Table Produtos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produtos (
    idProdutos INT NOT NULL AUTO_INCREMENT,
    quantidade INT NOT NULL,
    validade DATE NOT NULL,
    nome_Produto VARCHAR(100) NOT NULL,
    preco DECIMAL(65) NOT NULL,
    Produtores_idProdutores INT NOT NULL,
    PRIMARY KEY (idProdutos),
    FOREIGN KEY (Produtores_idProdutores) REFERENCES Produtores (idProdutores)
);

-- -----------------------------------------------------
-- Table Clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Clientes (
    idClientes INT NOT NULL AUTO_INCREMENT,
    nome_Cliente VARCHAR(100) NOT NULL,
    Usuarios_idUsuarios INT NOT NULL,
    Enderecos_idEnderecos INT NOT NULL,
    nr_casa VARCHAR(6) NOT NULL,
    complemento VARCHAR(6) NULL,
    PRIMARY KEY (idClientes),
    FOREIGN KEY (Usuarios_idUsuarios) REFERENCES Usuarios (idUsuarios),
    FOREIGN KEY (Enderecos_idEnderecos) REFERENCES Enderecos (idEnderecos)
);

-- -----------------------------------------------------
-- Table Vendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Vendas (
    idVendas INT NOT NULL AUTO_INCREMENT,
    quantidade INT NOT NULL,
    Produtores_idProdutores INT NOT NULL,
    Clientes_idClientes INT NOT NULL,
    PRIMARY KEY (idVendas),
    FOREIGN KEY (Produtores_idProdutores) REFERENCES Produtores (idProdutores),
    FOREIGN KEY (Clientes_idClientes) REFERENCES Clientes (idClientes)
);

-- -----------------------------------------------------
-- Table Carrinho
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Carrinho (
    Vendas_idVendas INT NOT NULL,
    Produtos_idProdutos INT NOT NULL,
    idCarrinho INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idCarrinho),
    FOREIGN KEY (Vendas_idVendas) REFERENCES Vendas (idVendas),
    FOREIGN KEY (Produtos_idProdutos) REFERENCES Produtos (idProdutos)
);