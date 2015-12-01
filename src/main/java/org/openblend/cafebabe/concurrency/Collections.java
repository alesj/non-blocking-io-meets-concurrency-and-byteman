/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Ales Justin
 */
public class Collections {
    public static void main(String[] args) {
        ConcurrentNavigableMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("a", 0);
        map.put("a/b", 1);
        map.put("a/b/c", 2);
        map.put("a/b/c/d", 3);
        map.put("a/b/c/d/e", 4);
        map.put("a/b/c/d/e/f", 5);
        map.put("b", 6);
        map.put("b/a", 7);
        map.put("b/a/c", 8);

        String path = "a/b/c/d/e/f/g";

        // Start at the last possible matching entry, and scan upwards until the first matching entry is found.
        Map.Entry<String, Integer> floor = map.floorEntry(path);
        Map.Entry<String, Integer> result = null;
        while (floor != null && path.startsWith(floor.getKey())) {
            result = floor;
            floor = map.lowerEntry(floor.getKey());
        }

        System.out.println(result);
    }
}
