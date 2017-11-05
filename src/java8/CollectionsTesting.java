package java8;

import java.util.function.Function;
import java.util.function.Predicate;


public class CollectionsTesting {

    public static Predicate<String> checkIfStartsWith(String letter) {
        return name -> name.startsWith(letter);
    }

    ;


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> names = Arrays.asList("bala", "chandarasdfasf", "janani", "adhya", "avani", "sangita");
        names.forEach(System.out::print);
        names.forEach(name -> System.out.print(name));
        System.out.println("");
        names.stream().findFirst().ifPresent(x -> System.out.println(x));
        names.stream().findAny().ifPresent(x -> System.out.println(x));

        //Transformation

        List<String> upperName = names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        List<String> upperName1 = names.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(upperName1);

        //Filter

        final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

        List<String> namesT = names.stream().filter(x -> x.startsWith("b")).map(String::toUpperCase).collect(Collectors.toList());
        namesT.forEach(System.out::println);

        final Predicate<String> startsWith = checkIfStartsWith("N");

        List<String> namesT1 = names.stream().filter(startsWithLetter.apply("b")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(names.stream().filter(startsWith).map(String::toUpperCase).count());

        namesT1.forEach(System.out::println);


        Optional<String> validname = names.stream().filter(startsWithLetter.apply("baL")).map(String::toUpperCase).findFirst();
        System.out.println("validname " + validname.orElse("not present"));


        //Length

        Integer x = names.stream().map(name -> name.length()).max(Integer::compareTo).get();
        Integer x1 = names.stream().mapToInt(name -> name.length()).sum();
        Optional<String> int2 = names.stream().reduce((name1, name2) -> (name1.length() >= name2.length() ? name1 : name2));
        final String int3 = names.stream()
                .reduce("BALACHANDAR HEREASFSF", (name1, name2) ->
                        (name1.length() >= name2.length() ? name1 : name2));

        String str2 = names.stream().reduce("", (name1, name2) -> name1 + "," + name2);
        String st3 = names.stream().collect(Collectors.joining(","));
        String st2 = names.stream().reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append).toString();


        int2.ifPresent(System.out::println);
        System.out.println("int3" + int3);
        System.out.println("str2 " + str2);
        System.out.println("st3" + st3);
        System.out.println("st2 " + st2);


        //Reduce


        //System.out.println("x" + x +" x1 "+ x1);
    }

}
