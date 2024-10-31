#  FUNCIONALIDADES APLICADAS
<h3>EXECUTAR O BUILD DO JAVA</h3>
<p>Este comando limpa a pasta target e roda a execução do build da aplicação gerando o arquivo .jar da sua aplicação na pasta target </p>

```bash
 mvn clean install
```
<p>Para rodar sem passar pela validação dos testes execute o comando</p>

```bash
 mvn clean install -DskipTests
```

<p>Neste repositório estou usando dois profiles onde um utiliza o profile DEV (Padrão), utiliza o application.properties e o profile PROD que utiliza o aplication-prod.properties, esses profiles estão configurados no pom.xml como mostra abaixo</p>

```bash
 <profiles>
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <activatedProperties>dev</activatedProperties>
        </properties>
    </profile>
    <profile>
        <id>prod</id>
        <properties>
            <activatedProperties>prod</activatedProperties>
        </properties>
    </profile>
</profiles>
```
<p>Foi adicionado também no pom.xml a informação do diretório da main para que fosse realizado o build da aplicação dentro da tag build: </p>

```bash
 <mainClass>com.manager.ApiApplication</mainClass>
```

<h3>PLUGINS</h3>

<p>No site do maven é possível verificar os plugins que o maven suporta para utilizarmos na aplicação</p>

```bash
 https://maven.apache.org/plugins/
```

<h3>PMD</h3>
<p>Um dos plugins que podemos usar é o pmd onde é necessário somente limpar a pasta target e rodar o comando</p>

```bash
./mvnw pmd:pmd
```

<p>Será gerado uma página html com as informações dos possíveis erros que a sua apliação pode ter, para que seja feito essa verificação no momento do build foi adicionado no pom.xml o plugin </p>

```bash
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-pmd-plugin</artifactId>
    <version>3.26.0</version>
    <executions>
      <execution>
        <goals>
          <goal>check</goal>
          <goal>cpd-check</goal>
        </goals>
      </execution>
    </executions>
</plugin>
```
<p>Para gerar o build utilizando da verificação do pwd basta executar o comando</p>

```bash
mvn clean verify
```

<h3>Makefile</h3>
<p>Adicionei um arquivo chamado Makefile para realizar a automatização da tarefa de criação do arquivo .jar, contrução da imagem do Dockerfile e rodar o docker compose da aplicação, utilizando o comando</p>

```bash
make run
```

<p>Para parar a tarefa pode simplesmente apertar 'Crtl+C' ou o comando:</p>

```bash
make stop
```

<p>Obs: Este comando remove o container criado e não persiste os dados no banco</p>
<p>Para saber mais sobre Makefile: https://www.gnu.org/software/make/manual/make.html</p>

<h3>Heroku</h3>
<p>Para fazer o deploy com o Heroku, é preciso criar a conta no site 'https://dashboard.heroku.com' e fiz o login no terminal usando o comando:</p>

```bash
heroku login
```

<p>Para realizar a autenticação utilizando um app de autenticador usei o comando: </p>

```bash
heroku auth:token
```

<p>Após isso realizei o comando: </p>

```bash
echo $(heroku auth:token) | docker login --username=_ --password-stdin registry.heroku.com
```
<p>Para criar a aplicação no heroku utiliza o comando (Obs: Precisa ser um nome único que não exista na plataforma): </p>

```bash
heroku create api-manager-dev
```

<p>Além da aplicação, precisamos criar o banco de dados. Estamos trabalhando com PostgreSQL e ele será o nosso banco de dados. O Heroku tem uma configuração própria para o suporte do PostgreSQL, por isso, não vamos utilizá-lo no Docker (como fizemos localmente). Sendo assim, basta rodar o comando:</p>

```bash
heroku addons:create heroku-postgresql:hobby-dev -a nome-do-app
```
<p>ou seja, heroku addons, que se refere aos vários plugins internos, e create heroku-postgresql:hobby-dev, porque pediremos a ele que crie um plugin vinculado à aplicação. Este plugin é o do PostgreSQL, onde ele criará uma base de dados. Há também a opção hobby-devque é um banco de dados com limitações, mas gratuito. Clicamos "Enter" e ele vai baixar, instalar e configurar nosso banco de dados PostgreSQL disponibilizado na aplicação.</p>


