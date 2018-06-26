CREATE TABLE `Usuarios` (
	`idUsuario` INT NOT NULL AUTO_INCREMENT,
	`poderAcesso` INT NOT NULL,
	`usuario` varchar(30) NOT NULL,
	`senha` varchar(30) NOT NULL,
	`nome` varchar(20) NOT NULL,
	`sobrenome` varchar(30) NOT NULL,
	`dataNascimento` DATE NOT NULL,
	`email` varchar(100) NOT NULL,
	`chaveRecuperacao` INT NOT NULL,
	PRIMARY KEY (`idUsuario`)
);

CREATE TABLE `Personagem` (
	`idUsuario` INT NOT NULL,
	`nomeChar` varchar(30) NOT NULL,
	`classeChar` varchar(30) NOT NULL,
	`nivelChar` INT NOT NULL,
	`statsForca` INT NOT NULL,
	`statsInteligencia` INT NOT NULL,
	`statsAgilidade` INT NOT NULL,
	`statsTalento` INT NOT NULL,
	`statsVitalidade` INT NOT NULL,
	PRIMARY KEY (`nomeChar`)
);

CREATE TABLE `Estatisticas` (
	`usuarios` varchar(30) NOT NULL,
	`nomeUsuario` varchar(30) NOT NULL,
	`dataCriacao` DATE NOT NULL,
	`horaCriacao` DATETIME NOT NULL,
	`ultimoLogin` varchar(40) NOT NULL,
	PRIMARY KEY (`usuarios`)
);

ALTER TABLE `Personagem` ADD CONSTRAINT `Personagem_fk0` FOREIGN KEY (`idUsuario`) REFERENCES `Usuarios`(`idUsuario`);

