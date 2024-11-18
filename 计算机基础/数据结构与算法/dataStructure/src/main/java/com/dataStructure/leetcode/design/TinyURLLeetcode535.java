package com.dataStructure.leetcode.design;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author OldGj 2024/03/05
 * @version v1.0
 * @apiNote 535. TinyURL 的加密与解密
 */
public class TinyURLLeetcode535 {

    static class CodecRandom {
        private static final HashMap<String, String> longToShort = new HashMap<>();
        private static final HashMap<String, String> shortToLong = new HashMap<>();
        private static final String SHORTURL_PREFIX = "http://tinyurl.com/";

        // 基于随机数实现映射关系
        public String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            while (true) {
                int id = ThreadLocalRandom.current().nextInt();
                String shotUrl = SHORTURL_PREFIX + id;
                if (!shortToLong.containsKey(shotUrl)) {
                    longToShort.put(longUrl, shotUrl);
                    shortToLong.put(shotUrl, longUrl);
                    break;
                }
            }
            return longToShort.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortToLong.get(shortUrl);
        }
    }

    static class CodecHash {
        private static final HashMap<String, String> longToShort = new HashMap<>();
        private static final HashMap<String, String> shortToLong = new HashMap<>();
        private static final String SHORTURL_PREFIX = "http://tinyurl.com/";

        // 基于随机数实现映射关系
        public String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            int id = longUrl.hashCode();
            while (true) {
                String shotUrl = SHORTURL_PREFIX + id;
                if (!shortToLong.containsKey(shotUrl)) {
                    longToShort.put(longUrl, shotUrl);
                    shortToLong.put(shotUrl, longUrl);
                    break;
                }
                id++;
            }
            return longToShort.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortToLong.get(shortUrl);
        }
    }

    static class CodecSequence {
        private static final HashMap<String, String> longToShort = new HashMap<>();
        private static final HashMap<String, String> shortToLong = new HashMap<>();
        private static final String SHORTURL_PREFIX = "http://tinyurl.com/";
        private static final char[] toBase62 = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        private static final StringBuilder sb = new StringBuilder();

        private static String toBase62(int number) {
            if (number == 0) {
                return String.valueOf(toBase62[number]);
            }
            while (number > 0) {
                int r = number % 62;
                sb.append(toBase62[r]);
                number = number / 62;
            }
            return sb.toString();
        }

        // 基于随机数实现映射关系
        public static String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            int id = longUrl.hashCode();
            while (true) {
                String base62 = toBase62(id);
                String shotUrl = SHORTURL_PREFIX + base62;
                if (!shortToLong.containsKey(shotUrl)) {
                    longToShort.put(longUrl, shotUrl);
                    shortToLong.put(shotUrl, longUrl);
                    break;
                }
                id++;
            }
            return longToShort.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public static String decode(String shortUrl) {
            return shortToLong.get(shortUrl);
        }
    }
}
