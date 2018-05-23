package cc.j8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * 既然lambda表达式即将正式取代Java代码中的匿名内部类，那么有必要对二者做一个比较分析。
 * 一个关键的不同点就是关键字 this。
 * 匿名类的 this 关键字指向匿名类，而lambda表达式的 this 关键字指向包围lambda表达式的类。
 * 另一个不同点是二者的编译方式。
 * Java编译器将lambda表达式编译成类的私有方法。使用了Java 7的 invokedynamic 字节码指令来动态绑定这个方法。
 */
public class Lambda2 {
    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        {
            // 使用lambda表达式和函数式接口Predicate
            // 除了在语言层面支持函数式编程风格，Java 8也添加了一个包，叫做 java.util.function。
            // 它包含了很多类，用来支持Java的函数式编程。
            // 其中一个便是Predicate，使用 java.util.function.Predicate 函数式接口以及lambda表达式，
            // 可以向API方法添加逻辑，用更少的代码支持更多的动态行为。
            // 下面是Java 8 Predicate 的例子，展示了过滤集合数据的多种常用方法。Predicate接口非常适用于做过滤。

            out.println("*********Languages which starts with J :");
            filter(languages, (str) -> str.startsWith("J"));

            out.println("*********Languages which ends with a ");
            filter(languages, (str) -> str.endsWith("a"));

            out.println("*********Print all languages :");
            filter(languages, (str) -> true);

            out.println("*********Print no language : ");
            filter(languages, (str) -> false);

            out.println("*********Print language whose length greater than 4:");
            filter(languages, (str) -> str.length() > 4);
            out.println();

        }
        {
            // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
            // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
            Predicate<String> startWithJ = n -> n.startsWith("J");
            Predicate<String> fourLetterLong = n -> n.length() == 4;
            languages.stream().filter(startWithJ.and(fourLetterLong))
                    .forEach(n -> out.print("nName, which starts with 'J' and four letter long is : " + n));
            out.println();
        }
        {
            // 不使用lambda表达式为每个订单加上12%的税
            List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
            for (Integer cost : costBeforeTax) {
                double price = cost + .12 * cost;
                out.print(price + "\t");
            }
            out.println();

            // 使用lambda表达式
            List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
            costBeforeTax2.stream()
                    .map((cost) -> cost + .12 * cost)
                    .forEach(n -> out.print(n + "\t"));
            out.println();
        }
        {
            // 为每个订单加上12%的税
            // 老方法：
            List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
            double total = 0;
            for (Integer cost : costBeforeTax) {
                double price = cost + .12 * cost;
                total = total + price;
            }
            out.println("Total : " + total);

            // 新方法：
            List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
            double bill = costBeforeTax2.stream()
                    .map((cost) -> cost + .12 * cost)
                    .reduce((sum, cost) -> sum + cost)
                    .get();
            out.println("Total : " + bill);
        }
        {
            List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
            // 创建一个字符串列表，每个字符串长度大于2
            List<String> filtered = strList.stream()
                    .filter(x -> x.length() > 2)
                    .collect(Collectors.toList());
            out.printf("Original List : %s,\nfiltered list : %s %n", strList, filtered);
        }
        {
            // 将字符串换成大写并用逗号链接起来
            List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
            String G7Countries = G7.stream()
//                    .map(x -> x.toUpperCase())
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(", "));
            out.println(G7Countries);
        }
        {
            // 复制不同的值，创建一个子列表
            // 本例展示了如何利用流的 distinct() 方法来对集合进行去重。
            // 用所有不同的数字创建一个正方形列表
            List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
            List<Integer> distinct = numbers.stream()
                    .map(i -> i * i)
                    .distinct()
                    .collect(Collectors.toList());
            out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
        }
        {
            //获取数字的个数、最小值、最大值、总和以及平均值
            List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
            IntSummaryStatistics stats = primes.stream()
                    .mapToInt((x) -> x)
                    .summaryStatistics();
            out.println("Highest prime number in List : " + stats.getMax());
            out.println("Lowest prime number in List : " + stats.getMin());
            out.println("Sum of all prime numbers : " + stats.getSum());
            out.println("Average of all prime numbers : " + stats.getAverage());
        }
    }

    static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                out.print(name + "\t");
            }
        }
        out.println();

        names.forEach(name -> {
            if (condition.test(name)) {
                out.print(name + "\t");
            }
        });
        out.println();

//        names.stream().filter((name) -> condition.test(name))
//        names.stream().filter(condition::test)
        names.stream().filter(condition)
                .forEach((name) -> out.print(name + "\t"));
        out.println();
    }
}
