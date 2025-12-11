# Estágio de construção
FROM ubuntu:latest AS build

# Atualiza o repositório e instala OpenJDK e Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho
WORKDIR /app

# Copia todos os arquivos do projeto para o contêiner
COPY . .

# Executa o Maven para construir a aplicação
RUN mvn clean install

# Estágio final
FROM openjdk:17-jdk-alpine

# Expõe a porta que a aplicação usará
EXPOSE 8080

# Copia o JAR gerado do estágio de construção
COPY --from=build /app/target/gestao-vagas-0.0.1.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]