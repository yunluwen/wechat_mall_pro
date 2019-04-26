package com.zyh.mall.tools;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试StringRedisTemplate的使用
 * 使用注意事项：
 * 当你的redis数据库里面本来存的是字符串数据或者你要存取的数据就是字符串类型数据的时候，那么你就使用StringRedisTemplate即可。
 * 但是如果你的数据是复杂的对象类型，而取出的时候又不想做任何的数据转换，直接从Redis里面取出一个对象，那么使用RedisTemplate是更好的选择。
 *
 * RedisTemplate使用时常见问题：
 *      redisTemplate 中存取数据都是字节数组。当redis中存入的数据是可读形式而非字节数组时，
 *      使用redisTemplate取值的时候会无法获取导出数据，获得的值为null。可以使用 StringRedisTemplate 试试。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisTemplateTest {


}
