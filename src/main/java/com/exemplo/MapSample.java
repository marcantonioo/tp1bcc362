  package com.exemplo;
  import com.hazelcast.client.HazelcastClient;
  import com.hazelcast.client.config.ClientConfig;
  import com.hazelcast.core.Hazelcast;
  import com.hazelcast.core.HazelcastInstance;
  import com.hazelcast.map.EntryProcessor;
  import com.hazelcast.map.IMap;

  import java.util.*;

  public class MapSample {
    
    public void Sample(){
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.setClusterName("hello-world"); 

      HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig); 
      IMap <String,String> map = client.getMap("my-distributed-map"); 

      
      map.put("1", "John");
      map.put("2", "Mary");
      map.put("3", "Jane");
    }
    public void Sample2(){

      ClientConfig clientConfig = new ClientConfig();
      clientConfig.setClusterName("hello-world");

      HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

      
      IMap <String,String> map = client.getMap("my-distributed-map");
      for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
      }

      client.shutdown(); 
    }
    public void Sample3(){

      ClientConfig clientConfig = new ClientConfig();
      clientConfig.setClusterName("hello-world");

      HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

      
      IMap <String,String> map = client.getMap("my-distributed-map");
      for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
      }
      Map<String, String> res = map.executeOnEntries( new IncrementingEntryProcessor() ); 
      for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
      }

      client.shutdown(); 
    }
  }


  /*map.executeOnEntries((EntryProcessor<Integer, String, String>)entry -> {
        System.out.println("Executando em: " + Hazelcast.getHazelcastInstanceByName("dev"));
        String updatedValue = entry.getValue() + "f";
        entry.setValue(updatedValue);
        return updatedValue;
      }); */