package com.xingjiahe.www.domain.service.concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午8:54
 */
public class PageSizeSorter {
    private static final ConcurrentHashMap<String, Integer> sizeMap = new ConcurrentHashMap<>();

    private static class GetSizeWorker implements Runnable {
        private String urlString;
        CountDownLatch signal;

        public GetSizeWorker(String urlString, CountDownLatch signal) {
            this.urlString = urlString;
            this.signal = signal;
        }

        @Override
        public void run() {
            try {
                InputStream is = new URL(urlString).openStream();
                int size = is.read();
                sizeMap.put(urlString, size);
            } catch (IOException e) {
                sizeMap.put(urlString, -1);
                e.printStackTrace();
            } finally {
                signal.countDown();
            }

        }

        private void sort() {
            List<Map.Entry<String, Integer>> list = new ArrayList<>();
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.compare(o2.getValue(), o1.getValue());
                }
            });
            System.out.println(Arrays.deepToString(list.toArray()));
        }

        public void SortPageSize(Collection<String> urls) throws InterruptedException {
            CountDownLatch sortSignal = new CountDownLatch(urls.size());
            for (String url : urls) {
                new Thread(new GetSizeWorker(url, sortSignal)).start();
            }
            sortSignal.await();
            sort();
        }
    }
}
