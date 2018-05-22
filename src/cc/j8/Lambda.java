package cc.j8;

import cc.deadlock.bean.A;
import cc.j8.bean.Person;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        {
            int i = 0;
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("匿名内部类实现Runnable接口");
                    System.out.println("i=" + i);
                }
            }.run();

            ((Runnable) () -> {
                System.out.println("用lambda实现Runnable接口1");
//            i++;
                System.out.println("i=" + i);

            }).run();

            Runnable r = () -> System.out.println("用lambda实现Runnable接口2");
            r.run();
        }

        {
            ((Action) System.out::println).execute("自定义的interface");

            Action logout = content -> {
                System.out.println(content);
            };
            logout.execute("通过lambda的登出操作");

            Action login = System.out::println;
            login.execute("通过lambda的登录操作");
        }

        List<Person> people = createPeople();
        Stream<Person> personStream = people.stream();
        personStream.filter(
                person -> person.getSex() == Person.Sex.FEMALE
                        || person.getSex() == Person.Sex.BOTH
        ).limit(2).forEach(
                person -> System.out.println(person.toString())
        );
        personStream.close();

        double average = people.stream().filter(p -> p.getSex() == Person.Sex.FEMALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(average);

        IntStream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);
        /**
         * 我们生成了0和1的交替数列
         * 然后只保留不同的数值，比如说，一个0和一个1
         * 然后再将流的大小限制为10
         * 最后对流进行消费
         */
//        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(10).forEach(System.out::println);
//        IntStream.iterate(0, i -> (i + 1) % 2).distinct().forEach(System.out::println);


        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        //  Consumer
        features.forEach(System.out::println);

    }

    static interface Action {
        void execute(String content);
    }

    static List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        {
            Person p = new Person("张飞", Person.Sex.MALE, 16, 1.99f);
            people.add(p);
        }
        {
            Person p = new Person("王菲", Person.Sex.FEMALE, 22, 1.68f);
            people.add(p);
        }
        {
            Person p = new Person("阿飞", Person.Sex.MALE, 18, 1.71f);
            people.add(p);
        }
        {
            Person p = new Person("刘亦菲", Person.Sex.FEMALE, 28, 2.00f);
            people.add(p);
        }
        {
            Person p = new Person("高飞", Person.Sex.MALE, 15, 0.82f);
            people.add(p);
        }
        {
            Person p = new Person("化蝶飞", Person.Sex.BOTH, 34, 0.5f);
            people.add(p);
        }
        {
            Person p = new Person("到处飞", Person.Sex.UNDEFINED, Integer.MAX_VALUE, Float.MAX_VALUE);
            people.add(p);
        }
        return people;
    }
}
