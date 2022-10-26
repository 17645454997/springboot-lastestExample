package com.xingjiahe.www.bloom;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.lucene.util.RamUsageEstimator;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/8/17 7:07 PM
 */
public class BizBitTest {


        private final static String HEX = "0.01";

        /**
         * 16进制字符串转字节数组
         *
         * @param hexString 16进制字符串
         * @return 转化后的字节数组
         */
        public static byte[] hexToByte(String hexString) {
            int len = hexString.length() / 2;
            byte[] result = new byte[len];
            for (int i = 0; i < len; i++) {
                result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
            }
            return result;
        }





        /**
         * 字节数组转16进制字符串
         *
         * @param bytes 字节数组
         * @return 转化后的字符串
         */
        public static String byteToHex(byte[] bytes) {
            if (bytes == null) {
                return "";
            }
            StringBuilder result = new StringBuilder(2 * bytes.length);
            for (byte b : bytes) {
                result.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
            }
            return result.toString();
        }

//        public static void main(String args[]) {
//         byte[]bytes =HEX.getBytes(StandardCharsets.US_ASCII);
//         System.out.println("UTF-8"+ Arrays.toString(bytes));
//         String  str = new String(bytes, StandardCharsets.US_ASCII);
//            System.out.println(RamUsageEstimator.sizeOf(bytes));
//        //    System.out.println(str);
//
//        }



        /**
         * Hex转byte,hex只能含两个字符，如果是一个字符byte高位会是0
         */
        public static byte hexStrTobyte(String hex) {
            return (byte) Integer.parseInt(hex, 16);
        }

        /**
         * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
         */
        public static byte[] getBooleanArray(byte b) {
            byte[] array = new byte[8];
            for (int i = 7; i >= 0; i--) {
                array[i] = (byte)(b & 1);
                b = (byte) (b >> 1);
            }
            return array;
        }

        /**
         * 把byte转为字符串的bit
         */
        public static String byteToBit(byte b) {
            return ""
                    + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                    + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                    + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                    + (byte) ((b >> 1) & 0x1) + (byte) ((b) & 0x1);
        }

        public static void main(String[] args) {
//            byte b = 0x35; // 0011 0101
//            byte d = hexStrTobyte("35");
//            // 输出 [0, 0, 1, 1, 0, 1, 0, 1]
//            Map<Integer, BitSet> map=new HashMap<>();
//            map.computeIfAbsent(135, k -> new BitSet()).set(66789098);
//            BitSet bitSet =  new BitSet();
//
//            System.setProperty("java.vm.name","Java HotSpot(TM) ");
//            System.out.println(ObjectSizeCalculator.getObjectSize(32131231123L));
//            System.out.println(RamUsageEstimator.sizeOf(HEX));
//            System.out.println(RamUsageEstimator.sizeOf(b));
//            int a = 1;
//            long c = 1L;
//
//            byte[] ret= new byte[2];
//            byte  h=(byte) 1;
//            boolean aq =  true;
//            String  tt = "sada";
//            // 1 bytes = 8 bit;     1bit 存数据
//            System.out.println(RamUsageEstimator.sizeOf(aq));
//            System.out.println(tt.getBytes().length);

            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(50000);
            for(int i=0;i<50000;i++){
                workQueue.add(()->{
                    try {
                        List<Integer> list  =  new ArrayList<>(10000);
                        for (int j=0;j<10000;j++){
                            list.add((j));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
            }
            System.out.println(workQueue.size());
            System.out.println( RamUsageEstimator.sizeOf(workQueue));

       }



}
