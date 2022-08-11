package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * author: weijli
 * date: 2022/8/5 15:12
 * description:
 */

public class KafkaProducerTest implements Runnable{
  
  private String topic;
  private KafkaProducer producer;
  public KafkaProducerTest(String topicName){
    Properties props = new Properties();
    props.put("bootstrap.servers", "10.33.4.123:9091,10.33.4.123:9091,10.33.4.123:9091");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("key.serializer", StringSerializer.class.getName());
    props.put("value.serializer", StringSerializer.class.getName());
    this.producer = new KafkaProducer<String, String>(props);
    this.topic = topicName;
  
  }
  
  
  public static void main(String[] args) {
    KafkaProducerTest kafkaProducerTest =new KafkaProducerTest("test-producer");
    Thread thread = new Thread(kafkaProducerTest);
    thread.start();
  }
  
  @Override
  public void run() {
    int messageNo = 1;
    try {
      for(;;) {
        String messageStr="你好，这是第"+messageNo+"条数据";
        producer.send(new ProducerRecord<String, String>(topic, "Message", messageStr));
        //生产了100条就打印
        if(messageNo%100==0){
          System.out.println("发送的信息:" + messageStr);
        }
        //生产1000条就退出
        if(messageNo%1000==0){
          System.out.println("成功发送了"+messageNo+"条");
          break;
        }
        messageNo++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      producer.close();
    }
    
  }
}
