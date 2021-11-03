package com.lilili.stream;

import org.junit.Test;
import sun.plugin.dom.core.CoreConstants;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author LiYuan
 * @Date 2021/7/2
 **/
public class StreamTest {
    @Test
    public void test() {
        //创建流的几种方式
        //1.
//        List<String> list = Arrays.asList("a", "b", "c");
//        //创建一个顺序流
//        Stream<String> stream = list.stream();
//        //创建一个并行流
//        Stream<String> parallelStream = list.parallelStream();
        //2.
//        int[] array = {1,2,3};
//        IntStream stream = Arrays.stream(array);
        //3.
//       Stream<Integer> stream = Stream.of(1, 2, 3, 4);

        Stream<Integer> res = Stream.iterate(0, (x) -> x + 3).limit(4);
        res.forEach(System.out::println);

    }

    @Test
    public void testFilter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);
    }

    @Test
    public void polymerize() {
//        List<String> list = Arrays.asList("admin", "user", "lilili957", "customer");
//        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
//        System.out.println("最长的字符串是:" + max.get());

//        //获取Integer集合最大值
//        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 5, 67890, 1);
//        //自然排序
//        Optional<Integer> max1 = integerList.stream().max(Integer::compare);
//        //自定义排序
//        Optional<Integer> max2 = integerList.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println("自然排序的最大值:" + max1.get());
//        System.out.println("自定义排序的最大值:" + max2.get());

        //count的使用，计算Integer集合中大于6的个数
        List<Integer> list = Arrays.asList(1, 23, 4, 545, 6, 5, 76, 8, 7, 1, 1, 1, 1, 12, 4, 5);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("大于6的数有:" + count);
    }

    @Test
    public void map() {
        //每个字母大写
        List<String> list = Arrays.asList("lilili", "dengfenglai", "ypP");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个字母大写: " + collect);
        //每个元素 + 3
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect2 = list2.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素 + 3:" + collect2);
    }

    @Test
    public void flatMap() {
        //将两个字符数组合成一个新的字符数据
        List<String> list = Arrays.asList("li,li,li", "9,5,7");
        List<String> collect = list.stream().flatMap(x -> {
            String[] split = x.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println("合并前的字符：" + list);
        System.out.println("合并后的字符：" + collect);
    }

    /**
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    @Test
    public void reduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //求和
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        //求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        //求最大值
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);

        System.out.println("求最大值:" + max.get());
        System.out.println("求和:" + sum.get());
        System.out.println("求乘积:" + product.get());
    }

    /**
     * 因为流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。
     * toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
     * 下面用一个案例演示toList、toSet和toMap：
     */
    @Test
    public void to() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println("listNew:" + listNew);
        System.out.println("set:" + set);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("lilili957", 8000, 21, "male", "Shanghai"));
        personList.add(new Person("dengfenlai", 7000, 21, "male", "Shanghai"));
        personList.add(new Person("fengzhongzhuifeng", 7000, 21, "male", "Shanghai"));
        Map<String, Person> map = personList.stream().filter(x -> x.getSalary() > 6000).collect(Collectors.toMap(Person::getName, p -> p));

        System.out.println("map:" + map);
    }

    /**
     * 统计(count/averaging)
     * Collectors提供了一系列用于数据统计的静态方法：
     */
    @Test
    public void collectors() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        //求平均工资
        Double avgSalary = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.println("平均工资:" + avgSalary);

        //求最高工资
        Optional<Integer> highestSalary = personList.stream().map(Person::getSalary).max(Integer::compare);
        System.out.println("最高工资:" + highestSalary.get());

        //求工资之和
//        Optional<Integer> sum = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        int sum = personList.stream().mapToInt(Person::getSalary).sum();
//        System.out.println("工资之和:" + sum.get());
        System.out.println("工资之和:" + sum);

        //一次性统计所有信息，包括count，highest, sum, avg。
        IntSummaryStatistics allInfo = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
        System.out.println("一次性统计所有信息:" + allInfo);
    }

    /**
     * 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     * ps:分区只能填写一个条件， 分组可以填写多个条件。
     */
    @Test
    public void partitionAndGroup() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "Washington"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "New York"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));

        //按薪资是否高于8000分组
//        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
//        System.out.println("按薪资分两组:" + part);
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.groupingBy(x -> x.getSalary() > 8000));
        System.out.println("按薪资分组:" + part);

        //按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println("按性别分组:" + group);

        //先按性别分组，再按地区分组。
        Map<String, Map<String, List<Person>>> groupTwo = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("先按性别分组，再按地区分组:" + groupTwo);

    }

    @Test
    public void join() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        String str = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名:" + str);
        List<String> strList = Arrays.asList("A", "B", "C");
        String str2 = strList.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串:" + str2);
    }

    @Test
    public void sorted() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));
        System.out.println("排序之前:" + personList);

        //使用Collections进行排序
//        Collections.sort(personList, (o1, o2) -> {
//            return o1.getSalary() - o2.getSalary();
//        });
//        System.out.println("排序之后:" + personList);

        //按工资升序排序
        List<String> salaryAsc = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资升序排序:" + salaryAsc);
        //按照工资降序排序
        List<String> salaryDesc = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println("按照工资降序排序:" + salaryDesc);
        //先按工资排序再按年龄排序
        List<String> salaryAndAge = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        System.out.println("先按工资排序再按年龄排序:" + salaryAndAge);
        //先按工资排序再按年龄自定义排序(都是降序)
        List<String> customer = personList.stream().sorted((o1, o2) -> {
            if (o1.getSalary() != o2.getSalary()) {
                return o1.getSalary() - o2.getSalary();
            } else {
                return o2.getAge() - o1.getAge();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("自定义排序:" + customer);
    }

    @Test
    public void extractAndComposition() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"c", "d", "e", "f"};
        //使用concat合并两个流， 然后distinct去重。
        List<String> l1 = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().collect(Collectors.toList());
        System.out.println("去重后的数组:" + l1);
        //使用limit限制数量
        List<Integer> l2 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        System.out.println("限制数量后的数组:" + l2);
        //使用skip跳过前n个元素
        List<Integer> l3 = Stream.iterate(1, x -> x + 2).skip(1).limit(10).collect(Collectors.toList());
        System.out.println("跳过元素后的数组:" + l3);
    }

    @Test
    public void sortedSkipLimit() {
        Integer[] arr = {3, 2, 2, 3, 7, 3, 5, 10, 6, 20, 30, 40, 50, 60, 10};
        List<Integer> collect = Arrays.stream(arr).sorted(Integer::compareTo).skip(0).limit(10).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 所谓并行，指的是多个任务在同一时间点发生，并由不同的cpu进行处理，不互相抢占资源；
     * 而并发，指的是多个任务在同一时间点内同时发生了，但由同一个cpu进行处理，互相抢占资源。
     * 在实际使用的时候，并行操作不一定比串行操作快！
     * 对于简单操作，数量非常大，同时服务器是多核的话，建议使用Stream并行！
     * 反之，采用串行操作更可靠！
     */
    @Test
    public void parallel() {
        List<String> list = Arrays.asList("ace", "silverAce", "lilili957", "", "", "", "957", "ypp");
        long count = list.stream().parallel().filter(String::isEmpty).count();
        System.out.println("并行操作的结果count:" + count);
    }

    @Test
    public void toMap() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom",7000,25,"male","安徽"));
        personList.add(new Person("Jack",8000,30,"female","北京"));
        personList.add(new Person("Lucy",9000,40,"male","上海"));
        personList.add(new Person("Airs",10000,40,"female","深圳"));

        Map<Integer, Person> m1 = personList.stream().collect(Collectors.toMap(Person::getAge, v -> v, (k1, k2) -> k1));
        System.out.println("toMap后的map:" + m1);
    }

    @Test
    public void testCount() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom",7000,25,"male","安徽"));
        personList.add(new Person("Jack",8000,30,"female","北京"));
        personList.add(new Person("Lucy",9000,40,"male","上海"));
        personList.add(new Person("Airs",10000,40,"female","深圳"));
        Stream<Person> personStream = personList.stream().filter(person -> person.getSalary() >= 9000);
        personList.stream().filter(person -> person.getSalary() >= 9000).forEach(x -> System.out.println(x));
    }
}

class Person {

    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
