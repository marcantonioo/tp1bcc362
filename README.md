# TP1 BCC362
Projeto voltado para aprendizado utilizando como middleware principal o hazelcast e como orquestrador principal o kubernetes.

## Instruções de execução:
Todas as seções a seguir são voltadas para a compilação e execução do tp, além de dicas práticas
## Organização do ambiente hazelcast
### docker build -t tp1bcc362 .
### docker network create hazelcast-network
### docker run -it   --network hazelcast-network   --rm -e HZ_NETWORK_PUBLICADDRESS=<COLOCASEUIPAQUI>:5701 -e HZ_CLUSTERNAME=hello-world -p 5701:5701 tp1bcc362
TIRE O <> QUE ENVOLVE O SEU IP, SENAO NAO FUNCIONA
## Compilação e execução:

mvn exec:java -Dexec.mainClass="com.exemplo.Main"
