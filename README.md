# AutomacaoCrudAPIRestAssured

Este repositório contém um projeto de automação de API utilizando Rest Assured e o padrão Page Object, visando facilitar a manutenção e escalabilidade dos testes de API.

![Gstack_Integration_Tests](https://github.com/gstack/AutomacaoCrudAPIRestAssured/assets/14953996/0c2074c6-e196-4059-b040-aca852974bfa)


## Organização e Dinâmica do Projeto

O projeto é estruturado com base nos princípios SOLID, buscando ser escalável e de fácil distribuição. A seguir, apresentamos os passos sugeridos para implementar e expandir o projeto:

### Passo 1: Criar um arquivo ".feature"

- Nomeie o arquivo conforme a funcionalidade que deseja testar, por exemplo: `seuArquivo.feature`.
- Configure o idioma a ser utilizado, neste caso, Português Brasil (pt-BR).
- Utilize a sintaxe [Gherkin](https://cucumber.io/docs/gherkin/) para descrever a funcionalidade.
<img width="960" alt="DesafioGFTApi" src="https://github.com/renatobarrosbass/Desafio_GFT/assets/14953996/0fc52edf-8d9c-445f-a44e-f5f393d89da1">



### Passo 2: Criar a classe Step Definitions

- Crie uma classe com o mesmo nome do arquivo `.feature`, seguido de `StepDefinitions`, por exemplo: `seuArquivoStepDefinitions.class`.
- Insira os métodos gerados ao executar o arquivo `.feature` nesta classe.
<img width="960" alt="DesafioGFTSteps" src="https://github.com/renatobarrosbass/Desafio_GFT/assets/14953996/772b2ea7-a3b2-4f19-8503-ec4bc75c8aa9">

### Passo 3: Criar a classe de Serviço

- Crie uma classe de serviço com o mesmo nome do arquivo, por exemplo: `seuArquivoService.class`.
- Implemente os métodos de teste utilizando a classe `RestContext.class`, que fornece acesso a outras classes e enums do projeto.
<img width="960" alt="DesafioGFTService" src="https://github.com/renatobarrosbass/Desafio_GFT/assets/14953996/985ccf04-5c72-4c76-aa35-12ede183c270">
- Serão criados Logs a cada execução das requests:
<img width="960" alt="DesafioGFTLogs" src="https://github.com/renatobarrosbass/Desafio_GFT/assets/14953996/e0332014-872b-4e08-840e-a9946c404633">

### Resumo

A dinâmica do projeto consiste em seguir os passos acima, criando classes auxiliares ou enums conforme necessário, mantendo o princípio de responsabilidade única por classe e aderindo à orientação a objetos.

## Contribuindo

Contribuições são sempre bem-vindas! Por favor, pode enviar seu arquivo e sugiro utilizar um arquivo noemado CONTRIBUTING.md dentro de sua branch - indico criar uma branch para submeter melhorias para o projeto.

## Licença

Este projeto é uma contribuição livre para todo e qualquer QA que deseje utilizá-lo! Encorajo-os fortemente a testarem seus conhecimentos em Orientação a Objetos exemplificada no padrão de Projetos Page Object Model que guiou essa implementação.
