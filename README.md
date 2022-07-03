# TrabEngSWII - Enunciado do Trabalho
Objetivo:  implementar um solução utilizando uma arquitetura baseada em microservioços. Este trabalho terá como escopo implementar a solução usando microserviços, sem considerar ainda a dimensão de implantação (que será tema do trabalho seguinte;

Enunciado: a partir do exemplo de cadastro de estudantes visto em aula, evolua para uma solução de proveja as funcionalidades a seguir, utilizando uma arquitetura de microserviços. Assim:

Defina os microserviços (controllers para cada microserviço);
defina as rotas que serão disponibilizadas e que implementarão as funcionalidades descritas abaixo;
As funcionalidades adionais, a serem implementadas sobre a base fornecida, são:


Implemente uma funcionalidade simples de Login, que suporte:
criação de usuários com senha
não permitir usuário duplicados
fazer Login
só permitir acesso aos endpoints se houver algum usuário conectado.
Consulta um estudante pelo número de matrícula
Consulta um estudante por um segmento de seu nome
Se houver mais de um "match", retorna uma lista
cadastrar disciplinas
codigo da disciplina
nome da disciplina
horário da disciplina (por códigos: A, B, C, D ...., G)
uma mesma disciplina (mesmo código e nome) pode ocorrer em múltiplos horários
matricular estudante na disciplina
escolher disciplina
escolher horário
efetuar matrícula
