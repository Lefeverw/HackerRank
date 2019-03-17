package Statistics.MeanMedianAndMode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lefeverw
 */
public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            arr[i] = arItem;
        }
        scanner.close();
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.printf("%.1f\n", Arrays.stream(arr).average().getAsDouble());
        System.out.printf("%.1f\n", n % 2 == 0 ? (arr[n / 2 - 1] + arr[n / 2]) / 2. : arr[n / 2]);
        List<Integer> sortedarr = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap();
        sortedarr.stream().forEach(number ->
        {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        });
        int maxfrq = map.values().stream().max(Integer::compareTo).get();
        System.out.println(map.keySet().stream().filter(key -> map.get(key) == maxfrq).mapToInt(x -> (int) Math.floor(x)).min().getAsInt());
    }
}
