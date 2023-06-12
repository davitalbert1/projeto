-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12/06/2023 às 22:18
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `curso` varchar(50) DEFAULT NULL,
  `cod_turma` int(11) DEFAULT NULL,
  `cod_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `curso`, `cod_turma`, `cod_pessoa`) VALUES
(6, '1', 3, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `curso`
--

CREATE TABLE `curso` (
  `cod_curso` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `carga_horaria` int(11) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `curso`
--

INSERT INTO `curso` (`cod_curso`, `nome`, `descricao`, `carga_horaria`, `ativo`) VALUES
(1, '1', '1', 1, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `cod_pessoa` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cpf` varchar(15) NOT NULL,
  `celular` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pessoa`
--

INSERT INTO `pessoa` (`cod_pessoa`, `nome`, `email`, `endereco`, `cpf`, `celular`) VALUES
(1, '1', '1', '1', '1', '1'),
(2, '1', '1', '1', '1', '1'),
(3, '1', '1', '1', '1', '1'),
(4, '1', '1', '1', '1', '1'),
(5, '1', '1', '1', '1', '1'),
(6, '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

CREATE TABLE `professor` (
  `cod_professor` int(11) NOT NULL,
  `curso` varchar(50) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `cod_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `professor`
--

INSERT INTO `professor` (`cod_professor`, `curso`, `salario`, `cod_pessoa`) VALUES
(1, '1', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor_curso`
--

CREATE TABLE `professor_curso` (
  `cod_professor` int(11) DEFAULT NULL,
  `cod_curso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `sala`
--

CREATE TABLE `sala` (
  `cod_sala` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `local_sala` varchar(100) DEFAULT NULL,
  `capacidade` int(11) DEFAULT NULL,
  `dia_semana` varchar(15) DEFAULT NULL,
  `disciplina` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `sala`
--

INSERT INTO `sala` (`cod_sala`, `nome`, `local_sala`, `capacidade`, `dia_semana`, `disciplina`) VALUES
(1, '1', '1', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma`
--

CREATE TABLE `turma` (
  `cod_turma` int(11) NOT NULL,
  `numero_alunos` int(11) DEFAULT NULL,
  `cod_curso` int(11) DEFAULT NULL,
  `cod_sala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `turma`
--

INSERT INTO `turma` (`cod_turma`, `numero_alunos`, `cod_curso`, `cod_sala`) VALUES
(3, NULL, 1, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`),
  ADD KEY `cod_turma` (`cod_turma`),
  ADD KEY `cod_pessoa` (`cod_pessoa`);

--
-- Índices de tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`cod_curso`);

--
-- Índices de tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`cod_pessoa`);

--
-- Índices de tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`cod_professor`),
  ADD KEY `cod_pessoa` (`cod_pessoa`);

--
-- Índices de tabela `professor_curso`
--
ALTER TABLE `professor_curso`
  ADD KEY `cod_curso` (`cod_curso`),
  ADD KEY `cod_professor` (`cod_professor`);

--
-- Índices de tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`cod_sala`);

--
-- Índices de tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`cod_turma`),
  ADD UNIQUE KEY `cod_sala` (`cod_sala`),
  ADD KEY `cod_curso` (`cod_curso`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `cod_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `cod_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `cod_professor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `cod_sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `cod_turma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`cod_turma`) REFERENCES `turma` (`cod_turma`),
  ADD CONSTRAINT `aluno_ibfk_2` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod_pessoa`);

--
-- Restrições para tabelas `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod_pessoa`);

--
-- Restrições para tabelas `professor_curso`
--
ALTER TABLE `professor_curso`
  ADD CONSTRAINT `professor_curso_ibfk_1` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`cod_curso`),
  ADD CONSTRAINT `professor_curso_ibfk_2` FOREIGN KEY (`cod_professor`) REFERENCES `professor` (`cod_professor`);

--
-- Restrições para tabelas `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`cod_curso`),
  ADD CONSTRAINT `turma_ibfk_2` FOREIGN KEY (`cod_sala`) REFERENCES `sala` (`cod_sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
