package com.xingjiahe.www.controller;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

import java.nio.charset.Charset;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/6/24 11:59 AM
 */
public class PiplineTest {


    private static int[] getBitIndices(String str, int hashNum, int bitmapLength) {
        int[] indices = new int[hashNum];

        byte[] bytes = Hashing.murmur3_128()
                .hashObject(str, Funnels.stringFunnel(Charset.forName("UTF-8")))
                .asBytes();

        long hash1 = Longs.fromBytes(
                bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]
        );
        long hash2 = Longs.fromBytes(
                bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]
        );

        long combinedHash = hash1;
        for (int i = 0; i < hashNum; i++) {
            indices[i] = (int) (combinedHash & Integer.MAX_VALUE) % bitmapLength;
            combinedHash += hash2;
        }
        return indices;
    }


    public static void main(String args[]) {
        int[] bitIndices = getBitIndices("token", 10, 10000);
         for(int i: bitIndices){
             System.out.println(i);
         }

    }
}
