package com.xingjiahe.www.rpc.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/8/18 11:43 AM
 */
public class ZlibUtil {
    public static byte[] uncompress(byte[] input, boolean nowrap) throws IOException {
        Inflater inflater = new Inflater(nowrap);
        inflater.setInput(input);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);
        try {
            byte[] buff = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buff);
                /*if(count == 0){
                    break;
                }*/
                baos.write(buff, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        inflater.end();
        byte[] output = baos.toByteArray();
        return output;
    }

    public static byte[] compress(byte[] data, boolean nowrap) throws IOException {
        byte[] output;
        Deflater compress = new Deflater(Deflater.BEST_COMPRESSION, nowrap);
        compress.reset();
        compress.setInput(data);
        compress.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compress.finished()) {
                int i = compress.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            bos.close();
        }
        compress.end();
        return output;
    }
}


