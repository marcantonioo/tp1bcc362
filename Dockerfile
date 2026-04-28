FROM hazelcast/hazelcast:5.6.0

# Copia apenas seu JAR
COPY target/hazelcast-teste-1.0-SNAPSHOT.jar /opt/hazelcast/

# Adiciona ao classpath do Hazelcast
ENV HZ_CLASSPATH=/opt/hazelcast/hazelcast-teste-1.0-SNAPSHOT.jar

# Mantém o diretório de trabalho padrão
WORKDIR /opt/hazelcast
