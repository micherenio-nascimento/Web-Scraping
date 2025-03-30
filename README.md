# Web Scraping

## Descrição
Este projeto realiza web scraping para baixar arquivos PDF de um site do governo, compactá-los em um único arquivo ZIP e armazená-los localmente. O projeto segue o padrão de arquitetura **MVC (Model-View-Controller)**.

## Metodologia de Desenvolvimento
O desenvolvimento deste projeto foi organizado utilizando o **Kanban**, uma metodologia ágil. O Kanban ajudou a organizar as tarefas, gerenciar o fluxo de trabalho e garantir que as atividades fossem realizadas de forma eficiente e com foco na entrega contínua. O uso dessa metodologia permitiu a priorização das tarefas e acompanhamento do progresso de cada etapa do desenvolvimento.

![trello](./assets/trello.gif)

## Tecnologias Utilizadas
- **Java**
- **Jsoup** (para web scraping)
- **Java I/O e NIO** (para manipulação de arquivos)
- **Java Util ZIP** (para compactação)

## Estrutura do Projeto
```
WebScraping/
│── src/
│   ├── model/
│   │   ├── Model.java
│   ├── view/
│   │   ├── View.java
│   ├── controller/
│   │   ├── Controller.java
│   ├── App.java
│── downloads/ (pasta para armazenar os PDFs baixados)
│── anexos.zip (arquivo compactado gerado)
│── README.md
```

## Funcionalidades
1. **Acessa o site**: [Atualização do Rol de Procedimentos](https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-dasociedade/atualizacao-do-rol-de-procedimentos)
2. **Extrai os links para os PDFs**.
3. **Faz o download dos PDFs** e os salva na pasta `downloads/`.
4. **Compacta os arquivos baixados** em `anexos.zip`.

## Como Executar

### Passos
1. **Clone o repositório**
   ```sh
   git clone https://github.com/micherenio-nascimento/Web-Scraping.git
   cd Web-Scraping
   ```

2. **Limpar e compilar o projeto (opcional, mas recomendado):**
   ```sh
   mvn clean install
   ```

3. **Execute a aplicação**
   ```sh
   mvn exec:java
   ```

4. Os arquivos baixados estarão em `downloads/`, e o arquivo ZIP será `anexos.zip`.

## Melhorias Futuras
- Implementar suporte para múltiplos formatos de compressão (RAR, 7z).
- Adicionar logs mais detalhados.
- Criar interface gráfica para facilitar o uso.