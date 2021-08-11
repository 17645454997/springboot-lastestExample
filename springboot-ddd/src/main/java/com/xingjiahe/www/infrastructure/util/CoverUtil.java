package com.xingjiahe.www.infrastructure.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CoverUtil {
    public static void main(String[] args) {
        // 飞哥提供
        String message = "350\\257\\245\\347\\254\\224\\350\\256\\242\\345\\215\\225\\345\\267\\262\\351\\200\\200\\346\\254\\276\\357\\274\\214\\350\\257\\267\\345\\213\\277\\351\\207\\215\\350\\257\\225";
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
