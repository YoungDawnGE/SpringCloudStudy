import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * Created by GYC
 * 2021/2/5 20:19
 *
 * 获得gateway中 Predicates中After Before Between里面的时间设置
 */
public class ZonedDateTimeTest {
    @Test
    public void getZonedDateTime() {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);//2021-02-05T20:21:44.387+08:00[Asia/Shanghai]
    }
}
