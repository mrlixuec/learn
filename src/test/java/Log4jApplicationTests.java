import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * author: weijli
 * date: 2021/12/21 11:25
 * description:
 */
@SpringBootTest
public class Log4jApplicationTests {
  
  private static final Logger logger = LogManager.getLogger(SpringBootTest.class);
  
  @Test
  public void log4j() {
    logger.info("content {}", "${java:vm}");
  }
}