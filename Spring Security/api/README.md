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