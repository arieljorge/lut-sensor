# LUT-Sensor - Projeto de sensores de Luz, Umidade e Temperatura.

## Introdução

Um projeto simples de arduino com integração ao Java, e interface visual para dispositivo móveis. Projeto Integrador da faculdade, onde usaremos conceitos de IoT das disciplinas de tecnologias emergentes e ferramentas visuais.

## Motivação e Proposta

Marcos é um estudante de Análise e Desenvolvimento de Sistemas
que recentemente adquiriu uma casa antiga com a intenção de modernizá-
la. Ele decidiu transformar sua nova residência em um **ambiente**
**inteligente**, onde pudesse monitorar e controlar diversos aspectos do
ambiente, como temperatura, umidade e iluminação, de maneira eficiente
e integrada. 
<br/>
Ao planejar essa transformação, Marcos identificou a necessidade de
um sistema que não apenas coletasse dados em tempo real sobre as
condições ambientais de sua casa, mas que também permitisse visualizar e
analisar esses dados de forma intuitiva. Para isso, ele precisava de um
sistema que integrasse sensores de IoT e uma interface de usuário
amigável.

Inspirado pela necessidade de Marcos, decidimos desenvolver um projeto ao qual inclua os seguintes componentes:

- Um esquema ilustrativo de um [protótipo utilizando Arduino UNO](#Protótipo-utilizando-Arduino-UNO), utilizando sensores de temperatura, umidade e luminosidade que serão integrados à placa. Incluindo os códigos utilizados na placa.
- Um [módulo programado em  Java](#Módulo-programado-em-Java) para receber e processar os dados coletados pelos sensores dispostos no esquema, exibindo-os na medida que são lidos. Incluindo um diagrama de classes UML que ilustra a arquitetura e os componentes do sistema.
- um [protótipo de interface gráfica](#Protótipo-de-interface-gráfica) para o sistema de monitoramento

## Desenvolvimento

...descrição sobre o que pensamos para o projeto

## Protótipo utilizando Arduino UNO

falar sobre...

- Descrição do esquema e componentes utilizados.
- Diagramas ilustrativos do protótipo.
- Códigos produzidos durante o processo.

## Módulo programado em  Java

O módulo programado em Java seguirá o modelo de uma API, onde a cada algum período escolhido a aplicação irá puxar os dados do Arduino conectado direto à máquina. A API seguirá o fluxo simples de solicitar os dados via requisição http, onde a API irá puxar os dados do banco de dados tratados, mostrando ou todas as leituras, ou leituras em um período de tempo e ou média de cada leitura em um período.

Tratando a aplicação como API podemos tanto ler os dados localmente, quanto ler os dados via internet, caso tu queira conectar a sua máquina à internet. E podendo também ser adaptado para vários Arduinos com módulos de wifi, podendo enviar os dados vai método POST no endpoint para assim salvar os dados no banco de dados.

O projeto segue usando as seguinte bibliotecas e ou frameworks:
- Spring Boot
- Spring Web
- Spring Web Service
- Lombok
- JSerialCommon

### Diagrama de classes do projeto

![UML Módulo Programado em Java](./resources/diagrama_api_java.png)

### Endpoints da API

```
/leituras
```

## Protótipo de interface gráfica

falar sobre...

- Descrição e captura de telas do protótipo da interface visual.
- Breve explicação das funcionalidades. Além disso, deverá ser
entregue um pequeno vídeo (até 5 minutos) apresentando brevemente
o projeto desenvolvido.

## Conclusão

## Bibliografia

Em primeiro lugar utilizamos os conteúdos do curso, bem como as aulas como referência e consulta para o projeto, porém usamos também algumas de materiais didáticos por fora para atender aos requisitos do projeto integrado e entender de formas mais claras os conceitos. listados abaixo:

- Material introdutório ao Arduino: [Introdução ao Arduino - PET Computação UFRGS](https://petcomputacaoufrgs.github.io/intro-ao-arduino/introducao/introducao.html)
- [Livro Arduino Introdução à Robótica Educacional com Arduino - HANDS ON!](https://prp.usp.br/wp-content/uploads/sites/248/2020/07/1Livro-Arduino-Introdu%C3%A7%C3%A3o-a-Rob%C3%B3tica-Educacional-HANDS-ON-INTRODUCAO.pdf)
- [Modelos e Diagrams UML - IBM](https://www.ibm.com/docs/pt-br/rsas/7.5.0?topic=models-uml-diagrams)
- [O que é um diagrama UML - Lucidchart](https://www.lucidchart.com/pages/pt/o-que-e-uml)
