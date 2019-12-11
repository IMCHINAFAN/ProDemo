package cn.study.springbootthreadpool;

import cn.study.springbootthreadpool.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootThreadpoolApplicationTests {

    private int tickets = 500;

    @Autowired
    private AsyncService asyncService;

    @Test
    void test01() {
        for(int i = 0;i<1000;i++){
            asyncService.sale(tickets);
        }
    }

}
