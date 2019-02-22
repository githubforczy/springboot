package com.springboot.day06;

import com.springboot.day06.service.LambdaInterface;
import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class java8Test {
    @Test
    public void sort(){
        List<Integer> names = Arrays.asList(3, 7, 5, 1);
        Collections.sort(names, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(names);

        Collections.sort(names,(a,b) -> a.compareTo(b));

        System.out.println(names);
    }

    @Test
    public void convert(){
        LambdaInterface<String, Integer> lambda = Integer::valueOf;
        Integer convert = lambda.convert("123");
        System.out.println(convert);

        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(String.valueOf(i), "val" + i);
        }
        map.putIfAbsent(null,null);
        map.forEach((id,value) -> System.out.println(value));

        System.out.println(map.get("0"));
        System.out.println(map.getOrDefault(20,"没有key为20的数据"));
    }

    @Test
    public void Colock(){
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parse = LocalTime.parse("2019-02-22 13：45：33", dateTimeFormatter);
        System.out.println(parse);
        System.out.println(clock.instant());
        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
        ZoneId berlin = ZoneId.of("Europe/Berlin");
        LocalTime nowShanghai = LocalTime.now(shanghai);
        LocalTime nowBerlin = LocalTime.now(berlin);
        System.out.println(nowShanghai);
        System.out.println(nowBerlin);
        long betweenTime = ChronoUnit.HOURS.between(nowShanghai, nowBerlin);
        System.out.println(betweenTime);
        System.out.println(LocalTime.of(12,13,14));

    }
}
