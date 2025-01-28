import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://segmentfault.com/a/1190000009186509
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class LambdaLearn {
    public static void main(String[] agrs) {
        // thread
        // new Thread(() -> System.out.println("Hello world")).start();

        // traverse
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // list.forEach(n->System.out.println(n));
        // list.forEach(System.out::println);

        System.out.print("输出所有数字：");
        evaluate(list, (n) -> true);

        System.out.print("不输出：");
        evaluate(list, (n) -> false);

        System.out.print("输出偶数：");
        evaluate(list, (n) -> {
            return n % 2 == 0;
        });

        System.out.print("输出奇数：");
        evaluate(list, (n) -> n % 2 == 1);

        System.out.print("输出大于 5 的数字：");
        evaluate(list, (n) -> n > 5);

        // Stream
        list.stream().mapToInt(n -> n * n).forEach(System.out::println);
        int sum = list.stream().map(n -> n * n).reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}
