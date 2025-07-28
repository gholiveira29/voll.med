Projeto Voll Med (Sistema de Gestão de Clínica Médica)
Visão Geral
Este projeto é um sistema de gestão de uma clínica médica chamado Voll Med, desenvolvido em Java. O objetivo é gerenciar médicos, pacientes e o agendamento de consultas. O sistema oferece funcionalidades completas de cadastro, listagem, atualização e inativação (exclusão lógica) de médicos e pacientes, além do agendamento e cancelamento de consultas, respeitando detalhes e regras de negócio específicas para garantir o bom funcionamento da clínica.

Funcionalidades
1. Médicos
Cadastro de médicos
Permite registrar médicos com os seguintes campos obrigatórios:
Nome
E-mail
Telefone
CRM
Especialidade (Ortopedia, Cardiologia, Ginecologia, Dermatologia)

Endereço completo (logradouro, bairro, cidade, UF, CEP)
Número e complemento do endereço são opcionais.

Listagem de médicos
Exibe uma lista de médicos cadastrados apresentando:
Nome
E-mail
CRM
Especialidade
A listagem é ordenada alfabeticamente pelo nome e paginada, exibindo 10 médicos por página.

Atualização de médicos
Permite atualizar:
Nome
Telefone
Endereço
Regras de negócio:
Não é permitido alterar o e-mail, CRM ou especialidade do médico.

Exclusão de médicos
Marca médicos como inativos, sem apagar seus dados do sistema.

2. Pacientes
Cadastro de pacientes
Registro completo com os seguintes campos obrigatórios:
Nome
E-mail
Telefone
CPF

Endereço completo (logradouro, bairro, cidade, UF, CEP)
Número e complemento do endereço são opcionais.

Listagem de pacientes
Exibe os pacientes cadastrados com:
Nome
E-mail
CPF
Ordenado alfabeticamente e paginado, com 10 pacientes por página.

Atualização de pacientes
Permite atualizar:
Nome
Telefone
Endereço
Regras de negócio:
Não é permitido alterar o e-mail ou o CPF do paciente.

Exclusão de pacientes
Marca pacientes como inativos, mantendo seu histórico de dados.

3. Consultas
Agendamento de consultas
Permite agendamento com:
Paciente
Médico (opcional; se não selecionado, o sistema escolhe aleatoriamente um médico disponível)
Data/Hora
Regras de negócio:

Funcionamento de segunda a sábado, das 07:00 às 19:00
Duração fixa de 1 hora
Agendamento mínimo de 30 minutos de antecedência
Apenas pacientes e médicos ativos podem agendar
Paciente só pode ter uma consulta por dia
Médico não pode ter duas consultas simultâneas

Cancelamento de consultas
Permite o cancelamento mediante:
Seleção da consulta
Motivo obrigatório do cancelamento: paciente desistiu, médico cancelou ou outros
Regras de negócio:

Cancelamento permitido apenas com pelo menos 24 horas de antecedência
Observações
Todas as exclusões são feitas via inativação, garantindo histórico e rastreabilidade.
Listagens são paginadas para garantir performance e usabilidade.

As regras de negócio asseguram integridade e correto funcionamento do sistema para a clínica Voll Med.
