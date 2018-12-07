package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://www.codechef.com/problems/COUPSYS
 */
public class Coupsys {

    private static class DiscountInfo implements Comparable<DiscountInfo> {

        private final int city;
        private final int discountValue;
        private final int level;

        public DiscountInfo(int city, int discountValue, int level) {
            this.city = city;
            this.discountValue = discountValue;
            this.level = level;
        }

        public int getCity() {
            return city;
        }

        public int getDiscountValue() {
            return discountValue;
        }

        @Override
        public int compareTo(DiscountInfo o) {
            if (discountValue == o.discountValue) {
                return java.lang.Integer.compare(o.city, city);
            }
            return java.lang.Integer.compare(discountValue, o.discountValue);
        }

        @Override
        public String toString() {
            return discountValue + " " + city;
        }

    }

    public static String[] evaluate(java.util.Map<Integer, java.util.List<DiscountInfo>> discountInfos) {
        String[] result = new String[discountInfos.size()];
        for (int i = 0; i < discountInfos.size(); ++i) {
            java.util.List<DiscountInfo> current = discountInfos.get(i + 1);
            java.util.Collections.sort(current);
            DiscountInfo max = current.get(current.size() - 1);
            result[i] = max.toString();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; ++tc) {
            java.util.Map<Integer, java.util.List<DiscountInfo>> discounts = new java.util.HashMap<>();

            String[] line = br.readLine().split("\\s+");
            int n = java.lang.Integer.parseInt(line[0]);
            for (int i = 0; i < n; ++i) {
                String[] discountsInput = br.readLine().split("\\s+");
                int city = java.lang.Integer.parseInt(discountsInput[0]);
                int level = java.lang.Integer.parseInt(discountsInput[1]);
                int discount = java.lang.Integer.parseInt(discountsInput[2]);
                DiscountInfo discountInfo = new DiscountInfo(city, discount, level);
                if (discounts.containsKey(level)) {
                    discounts.get(level).add(discountInfo);
                } else {
                    discounts.put(level, new java.util.ArrayList<>(java.util.Arrays.asList(discountInfo)));
                }
            }
            String[] result = evaluate(discounts);
            for (int i = 0; i < result.length; ++i) {
                System.out.println(result[i]);
            }
        }
    }
}
