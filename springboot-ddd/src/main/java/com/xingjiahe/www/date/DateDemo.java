package com.xingjiahe.www.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class DateDemo {
    public static void main(String[] args) {
        //获取纪元的毫秒值
        LocalDate localDate = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
        //写入数据库
        System.out.println(java.sql.Date.valueOf(localDate));
        System.out.println(localDate);
    }
}
