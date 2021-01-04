package com.example.springbootdemo.fun.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

public class StreamTry {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        for (Integer x : arr) {
            System.out.println(x);
        }
        Integer xxxxxxx = 1;
        System.out.println(xxxxxxx.equals(1));
        String ip = "129.157.123.513 ,213";
        System.out.println(ip.substring(0, ip.length()));
        int i = 0;
        for (i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) != '.' && (ip.charAt(i) < '0' || ip.charAt(i) > '9')) {
                break;
            }
        }
        System.out.println(i);
        System.out.println(ip.substring(0, i));
        List<String> stringList = new ArrayList<>();

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.sort((o1, o2) -> o1.charAt(0) < o2.charAt(0) ? 1 : -1);
//        stringList.get(0);
        stringList.stream().filter(x -> x.equals("a")).forEach(System.out::println);

        Date date=new Date();
        SimpleDateFormat sdf8=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf8.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));//设置时区为东八区
        System.out.println("东八区的时间:"+sdf8.format(date));//输出格式化日期
        System.out.println(date.getTimezoneOffset());

        SimpleDateFormat sdf9=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf9.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));//设置时区为东八区
        System.out.println("东九区的时间:"+sdf9.format(date));//输出格式化日期
        System.out.println();

        Long timestamp = System.currentTimeMillis();
        Date date2 = new Date(timestamp);
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        System.out.println("def: "+ calendar.getTimeInMillis());
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeZone());
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        calendar.setTimeZone(tz);
        System.out.println("amr: " + calendar.getTimeInMillis());
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeZone());
        int a = 3;

        System.out.println(a);
        String phone = "+85 12346";
        System.out.println(phone.substring(4));
        String str = "\u003cstrong\u003e用左右声道选择配音\u0026nbsp;\u0026nbsp;\u0026nbsp;\u0026nbsp;\u0026nbsp;\u003c/strong\u003e\r\n\u0026nbsp;\u0026nbsp;\u0026nbsp;\u0026nbsp; \u003cQ版三国\u003e是历时2年耗资1000万本土第一部大型成人动画。 39集历史搞笑动画巨制。 魏蜀吴历史全面颠覆，刘关张人性爆笑解构。\r\n\u0026nbsp;\u0026nbsp;\u0026nbsp;\u0026nbsp;\u0026nbsp; 话说天下大事，分久必合，合久必分。东汉末年，由于汉献帝昏庸无能，引起天下大乱，历史上三国鼎立的时代由此开始。刘备（种白菜的）、关羽（剪牛杂的）、张飞（杀猪的）三人本来打算去应征当兵，谁知道被无故抓进了桃园监狱，三人一见如故，在桃园中结义为史弟。 \u003cbr /\u003e\r\n　 出狱后，刘备一心想找个大佬罩住自己，而刘备很倒霉，所拜大佬都必死无疑！！世人称刘备为\u0026ldquo;大佬克星&rdquo;，此名一出，很快就红遍大江南北。\u0026ldquo;曹记刀铺\u0026rdquo;老板曹操出于好意请刘备叫火锅\u0026ldquo;煮酒论英雄\u0026rdquo;，刘备却怕曹操加害于他，先行将曹打昏在地，仓皇逃跑之余，发现生平最爱的女人\u0026ldquo;花花\u0026rdquo;被自己丢在曹府，遂叫关羽回去营救，曹操久仰关羽大名，用\u0026ldquo;极品牛杂\u0026rdquo;令关流连忘返。 \u003cbr /\u003e\r\n　 失业几年的诸葛亮巧遇刘备，竟被刘奉为天人，亮误打误撞，帮刘把生意越做越大，刘、曹、孙三分天下的格局初具雏形，接着，亮又一手策划了三家在赤壁举行的\u0026ldquo;攀岩大赛\u0026rdquo;，在东风的帮助下，刘备大获全胜。";
        System.out.println(StringEscapeUtils.unescapeHtml4(str).replaceAll("<([^>]*)>",""));
        List<People> peopleList = new ArrayList<>();
        People zhao = new People("zhao", 19);
        People qian = new People("qian", 10);
        People sun = new People("sun", 5);
        People li = new People("li", 13);
        peopleList.add(zhao);
        peopleList.add(qian);
        peopleList.add(sun);
        peopleList.add(li);
        peopleList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        peopleList.forEach(System.out::println);
        System.out.println("--------");
        peopleList.stream().filter(x -> {
            if (x.getAge() < 10) {
                x.setAge(x.getAge() + 10);
            }
            return x.getAge() > 13;
        }).forEach(System.out::println);
    }
}