package java8;

import static java.util.stream.Collectors.*;


class Emp {

    private final String fname;
    private final String lname;
    private final int sal;
    private final String city;
    private final int sales;

    public Emp(String fname, String lname, int sal, String city, int sales) {
        this.fname = fname;
        this.lname = lname;
        this.sal = sal;
        this.city = city;
        this.sales = sales;
    }

    public String getFirstName() {
        return this.fname;
    }

    public String getLastName() {
        return this.lname;
    }

    public int getSalary() {
        return this.sal;
    }

    public int getSales() {
        return this.sales;
    }

    public String getCity() {
        return this.city;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" fname " + fname);
        str.append(" lname " + lname);
        str.append(" sal " + sal);
        str.append(" city " + city);
        str.append(" sales " + sales);

        return str.toString();
    }

}

public class GroupBy {

    public static Emp createEmp(String fname, String lname, int sal, String city, int sales) {
        return new Emp(fname, lname, sal, city, sales);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Emp> emps = Arrays.asList(createEmp("bala", "chandar", 1000, "cupertino", 2000),
                createEmp("ram", "krish", 2000, "cupertino", 20300),
                createEmp("bala", "chandar", 10002, "cupertino", 20020),
                createEmp("ssd", "zyna", 10000, "sa", 2000),
                createEmp("hello", "world", 4000, "chicago", 20002)
        );

        Map<String, List<Emp>> groupByCity = emps.stream().collect(groupingBy(Emp::getCity));
        System.out.println(groupByCity);

        Map<String, Long> groupByCityCount = emps.stream().collect(groupingBy(Emp::getCity, counting()));
        System.out.println(groupByCityCount);

        Map<String, Double> avgSalesPerCity = emps.stream().collect(groupingBy(Emp::getCity, averagingLong(Emp::getSales)));
        Map<String, Long> sumSalesPerCity = emps.stream().collect(groupingBy(Emp::getCity, summingLong(Emp::getSales)));

        System.out.println("avgSalesPerCity " + avgSalesPerCity);
        System.out.println("sumSalesPerCity " + avgSalesPerCity);

        Map<Boolean, List<Emp>> parti = emps.stream().collect(partitioningBy(x -> x.getCity() == "cupertino"));
        System.out.println("parti " + parti);

    }

}
