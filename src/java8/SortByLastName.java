package java8;

import java.util.function.Function;

class Name {
    private final String first;
    private final String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    public String toString() {
        return this.first + " " + this.last;
    }
}

public class SortByLastName {

    public static void main(String[] args) {
        Function<Name, String> sortByLast = (name) -> name.getLast();
        // TODO Auto-generated method stub
        List<Name> names = Arrays.asList(new Name("Bala", "Chandar"), new Name("Bala", "zzrishn"), new Name("Sam", "Zhy"));
        names.stream().sorted(Comparator.comparing(sortByLast).reversed()).collect(Collectors.toList()).forEach(System.out::println);
    }

}
