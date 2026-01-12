# Estágio de construção
FROM maven:3.9-eclipse-temurin-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o arquivo pom.xml primeiro para aproveitar o cache do Docker
COPY pom.xml .

# Baixa as dependências Maven (estas serão armazenadas em cache se o pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Agora copia o código-fonte
COPY src ./src/

# Configura explicitamente o JAVA_HOME e executa o Maven
RUN export JAVA_HOME=/opt/java/openjdk && \
    mvn clean install -Dmaven.compiler.fork=true

# Estágio final
FROM eclipse-temurin:17-jre

# Define variável de ambiente para a porta
ENV PORT=8080

# Expõe a porta que a aplicação usará
EXPOSE ${PORT}

# Copia o JAR gerado do estágio de construção
# Atenção: Verifique se o nome e o caminho do JAR estão corretos
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]