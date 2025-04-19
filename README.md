# Sistema de Gestão de Biblioteca (CLI)

Sistema completo para gestão de bibliotecas em Java puro (sem frameworks), com controle de utilizadores, livros e empréstimos.

## 📚 Funcionalidades

### 👨‍💼 Administradores
- Cadastrar/listar/remover administradores, bibliotecários e leitores
- Visualizar todos os registros do sistema

### 📖 Bibliotecários
- Adicionar/remover/listar livros
- Registrar empréstimos e devoluções
- Verificar disponibilidade de exemplares

### 👩‍🎓 Leitores
- Consultar acervo de livros
- Realizar empréstimos (autenticado)

## 🛠 Tecnologias
- Java JDK 17+
- PostgreSQL (ou SQLite)
- JDBC para conexão com banco de dados

## 🗂 Estrutura do Projeto
/SistemaGestaoBiblioteca
├── bin/ # Arquivos compilados
├── lib/
│ └── postgresql-42.7.4.jar # Driver PostgreSQL
├── src/
│ ├── Configurations/
│ │ └── Configuration.java # Gestão de conexão
│ ├── DataAccessObject/ # Persistência
│ │ ├── AdministradorDAO.java
│ │ ├── BibliotecarioDAO.java
│ │ ├── LeitorDAO.java
│ │ └── LivroDAO.java
│ └── Entity/ # Modelos
│ ├── Administrador.java
│ ├── Bibliotecario.java
│ ├── Leitor.java
│ ├── Livro.java
│ └── Utilizador.java # Classe base
├── App.java # Ponto de entrada
├── README.md # Documentação inicial de um projecto

## ⚙️ Configuração (credenciais)

Edite Configuration.java:

private static final String url = "jdbc:postgresql://localhost:5432/biblioteca";
private static final String user = "seu_usuario";
private static final String password = "sua_senha";

🚀 Execução

# Compilar:
javac -d bin -cp lib/postgresql-42.7.4.jar src/**/*.java

# Executar:
java -cp bin:lib/postgresql-42.7.4.jar App


💡 Sobre Mim
Olá! Sou Didyon José Mondlhane, um entusiasta de desenvolvimento de software apaixonado por criar soluções práticas que resolvem problemas reais. Este projeto representa minha jornada de aprendizado contínuo em Java e sistemas de gestão.

"Não há nenhum problema em não saber, só em continuar a não saber." [Autor Desconhecido]

Acredito que cada linha de código é uma oportunidade para aprender e crescer. Se este projeto for útil para você, ficarei muito feliz!

📝 Licença
Projecto académico - livre para uso e modificação

Com carinho,
Didyon José Mondlhane