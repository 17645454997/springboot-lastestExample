#!/usr/bin/env python
# -*- coding: utf-8 -*-
# jack he
import os, sys, time
import redis


def redis_scan():
    try:
        redisconn = redis.StrictRedis(host="127.0.0.1", port=6379, db=0)  # 不同db需要修改
    except Exception as e:
        print(e)
        sys.exit(1)
    cursor = 1
    isNoe = True
    file = open('rediskey', 'a+')
    while cursor != 0:
        if isNoe:
            cursor = 0
            isNoe = False
        key = redisconn.scan(cursor, count=2000)  # 每次拿2000个key
        time.sleep(0.05)
        if len(key[1]) == 0:
            print("key scan finish")
        else:
            for n in key[1]:
                TMP = n.split(":")
                ARR = map(int, TMP)
                print(ARR[2])
                print(ARR[4])
                n = bytes.decode(n)
                file.write(n)
                file.write("\n")
                cursor = key[0]


file.close()

redis_scan()
