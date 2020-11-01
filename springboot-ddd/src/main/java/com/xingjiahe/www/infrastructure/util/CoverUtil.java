package com.xingjiahe.www.infrastructure.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CoverUtil {
    public static void main(String[] args) {
        // 飞哥提供
        String message = "\\346\\212\\261\\346\\255\\211,\\347\\275\\221\\347\\273\\234\\345\\274\\200\\345\\260\\217\\345\\267\\256\\344\\272\\206,\\350\\257\\267\\347\\250\\215\\345\\220\\216\\351\\207\\215\\350\\257\\225\\";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(message.getBytes());
        int read = -1;
        byte[] byte3 = new byte[3];
        while ((read = inputStream.read()) > -1) {
            if (read == '\\') {
                try {
                    inputStream.read(byte3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                outputStream.write(Integer.parseInt(new String(byte3), 8));
            } else {
                outputStream.write(read);
            }
        }
        String decodeMessage = null;
        try {
            decodeMessage = new String(outputStream.toByteArray(), "utf-8");
        } catch (Exception e) {

        }

        System.out.println(decodeMessage);
    }
}
