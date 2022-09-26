package com.logicbig.example;

import com.logicbig.example.Product.Product;
import com.redcompany.app.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
@Slf4j
public class Main {
    public static void main(String[] args) {
        /*String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 0, 3);*/

       /* Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();*/
        /*Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);*/

       /* Stream<Integer> streamIterated = Stream.iterate(1, n -> n * 2).limit(20);*/
        /*IntStream intStream = IntStream.range(1, 10);
        LongStream longStream = LongStream.rangeClosed(1, 10);*/
        /*IntStream streamOfChars = "ABC".chars();*/

       /* Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));*/
        //Optional<String> anyElement = stream.findAny();

        /*List<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        System.out.println(anyElement);
        System.out.println(firstElement);*/
        //stream.forEach(element -> System.out.println(element));

        /*List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();*/

        /*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num < 4).findAny();
        System.out.println(result);*/





        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        /*Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });*/

/*
        Optional<String> stream = list.stream().filter(element -> {
            log.info("filter() was called");
            return element.contains("2");
        }).map(element -> {
            log.info("map() was called");
            return element.toUpperCase();
        }).findFirst();

        System.out.println(stream);*/


       /* long size = list.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();

        System.out.println(size);*/


       /* int reducedParams = Stream.of(1, 2, 3).parallel()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParams);*/

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

       /* List<Integer> collectorCollection =
                productList.stream().map(Product::getprice).collect(Collectors.toList());

        String listToString = productList.stream().map(Product::getProductName)
                .collect(Collectors.joining(", ", "[", "]"));

        collectorCollection.forEach(product -> System.out.println(product));
        System.out.println(listToString);*/

       /* Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));*/

        /*Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        System.out.println(mapPartioned);*/

        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.sequential().isParallel();
        boolean bigPrice = streamOfCollection
                .map(product -> {
                    System.out.println("in map "+ product.getProductName() );
                    return product.getPrice() * 12;
                })
                .anyMatch(price -> price > 2000);

        System.out.println(bigPrice);



    }









    private static long counter;

    private static  void wasCalled() {
        counter++;
    }
}
