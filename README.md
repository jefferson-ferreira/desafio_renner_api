# Desafio Renner
Projeto de automação de teste com Java, RestAssured para testar a API

## Descrição
Este projeto é uma estrutura de teste automatizado com o objetivo de testar APIs com Java, RestAssured. O objetivo deste projeto é garantir que a API esteja funcionando corretamente e que todas as funcionalidades estejam de acordo com as especificações.

## Pré-requisitos
* `Java8` [Link para download](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html)
* `RestAssured` na versão [5.3.0](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.3.0)
* `Junit 5` na versão [5.9.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2)
* `Maven` [Link para download](https://maven.apache.org/download.cgi)

## Instalação
* Clone / Baixe o projeto em seu local
* Abra o prompt de comando e navegue até o local do projeto
* Execute os seguintes comandos do Maven
* `mvn clean` :- Para limpar o repositório maven
* `mvn install` :- Para instalar os requirments maven

## Executando os testes
* Abra o prompt de comando e navegue até o local do projeto
* Execute o comando `mvn test` no seu prompt de comando.

## Verificar o report gerado dos testes
* Abra o prompt de comando e navegue até o local do projeto
* Execute o comando `allure serve target/surefire-reports`.

## Autor
Jefferson Ferreira Faria.