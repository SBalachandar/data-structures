package java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Employee {
    private final String name;
    private final int age;
    private final int sal;
    private final String dept;
    private final boolean active;

    public Employee(String name, int age, int sal, String dept, boolean active) {
        this.name = name;
        this.age = age;
        this.sal = sal;
        this.dept = dept;
        this.active = active;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.sal;
    }

    public String getDept() {
        return this.dept;
    }

    public boolean isActive() {
        return this.active;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" name :" + name);
        str.append(" age :" + age);
        str.append(" sal :" + sal);
        str.append(" dept :" + dept);
        str.append(" active :" + active);
        return str.toString();
    }
}

public class EmployeeItem {

    final static List<Employee> emps = Arrays.asList(new Employee("bala", 35,
                    1000, "HR", true), new Employee("OM", 35, 1000, "HR", true),
            new Employee("bala", 52, 10012, "BigData", true), new Employee(
                    "bala", 52, 10012, "BigData", true), new Employee("Ram",
                    21, 1001, "Service", true), new Employee("Sam", 35, 1000,
                    "Service", true), new Employee("Ram", 42, 131231, "Mobile",
                    true), new Employee("bala", 29, 1000, "Mobile", false),
            new Employee("Ram", 41, 131231, "Mobile", true), new Employee(
                    "Sam", 41, 131231, "Mobile", true)

    );

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("count " + emps.stream().count());

        // Print <40
        Comparator<Employee> byAge = (emp1, emp2) -> emp1.getAge()
                - emp2.getAge();
        Comparator<Employee> bySal = (emp1, emp2) -> emp1.getSalary()
                - emp2.getSalary();

        Function<Employee, Integer> byAge1 = emp -> emp.getAge();
        Function<Employee, Integer> bySal1 = emp -> emp.getSalary();
        Function<Employee, String> byName1 = emp -> emp.getName();

        emps.stream().filter(Employee::isActive).filter(x -> (x.getAge() < 30))
                .collect(Collectors.toList()).forEach(System.out::println);

        // Sort by Sal

        List<Employee> sortedAge = emps.stream().sorted(byAge)
                .collect(Collectors.toList());
        List<Employee> sortedSal = emps.stream().sorted(bySal.reversed())
                .collect(Collectors.toList());

        List<Employee> sortedAge1 = emps.stream().sorted(comparing(byAge1))
                .collect(Collectors.toList());
        List<Employee> sortedSal1 = emps.stream().sorted(comparing(bySal1))
                .collect(Collectors.toList());

        List<Employee> olderThan50 = emps.stream().filter(x -> x.getAge() > 50)
                .collect(Collectors.toList());

        Set<Employee> emp2 = emps.stream().filter(x -> x.getAge() > 50)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        System.out.println(sortedAge);
        System.out.println(sortedAge1);

        System.out.println(sortedSal);
        System.out.println(sortedSal1);

        List<Employee> sorted = emps
                .stream()
                .sorted(comparing(bySal1).thenComparing(byAge1).thenComparing(
                        byName1)).collect(Collectors.toList());

        System.out.println("sorted  " + sorted);
        System.out.println("olderThan50  " + olderThan50);
        System.out.println("olderThan50  " + emp2);

        // GroupBY

        Map<Integer, List<Employee>> empsMap = emps.stream().collect(
                Collectors.groupingBy(Employee::getAge));

        Map<Integer, List<String>> empAgeVsName = emps.stream().collect(
                Collectors.groupingBy(
                        Employee::getAge,
                        Collectors.mapping(Employee::getName,
                                Collectors.toList())));

        Map<Integer, Set<String>> empAgeVsNameNoDup = emps.stream().collect(
                Collectors.groupingBy(
                        Employee::getAge,
                        Collectors.mapping(Employee::getName,
                                Collectors.toSet())));

        System.out.println("empsMap " + empsMap);
        System.out.println("empAgeVsName " + empAgeVsName);
        System.out.println("empAgeVsNameNoDup " + empAgeVsNameNoDup);

        Map<Integer, Set<String>> e = empAgeVsNameNoDup.entrySet().stream()
                .filter(x -> (x.getKey() == 35))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        System.out.println("e " + e);

        Map<Integer, Set<String>> e1 = empAgeVsNameNoDup.entrySet().stream()
                .filter(x -> x.getValue().contains("bala"))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        System.out.println("e " + e1);

        List<Integer> n1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(n1.stream().count());

        System.out.println(n1.stream().mapToInt(x -> x).summaryStatistics());
        System.out.println(n1.stream().mapToInt(x -> x).max());
        System.out.println(n1.stream().mapToInt(x -> x).sum());
        System.out.println(n1.stream().mapToInt(x -> x).min());
        System.out.println(n1.stream().mapToInt(x -> x).average());

        System.out.println(n1.stream().reduce(0, Math::min).intValue());
        System.out.println(n1.stream().reduce(0, Math::max).intValue());
        System.out.println(n1.stream().reduce(0, (a, b) -> (a + b)).intValue());

        double avgSalforDept = emps.stream()
                .filter(x -> x.getDept().equals("Mobile"))
                .mapToInt(Employee::getSalary).average().getAsDouble();
        int minSalforDept = emps.stream()
                .filter(x -> x.getDept().equals("Mobile"))
                .mapToInt(Employee::getSalary).min().getAsInt();
        int maxSalforDept = emps.stream()
                .filter(x -> x.getDept().equals("Mobile"))
                .mapToInt(Employee::getSalary).max().getAsInt();
        int sumSalforDept = emps.stream()
                .filter(x -> x.getDept().equals("Mobile"))
                .mapToInt(Employee::getSalary).sum();

        // final Function<Employee,String> groupByDept = emp -> emp.getDept();
        Map<String, List<Employee>> groupByDeptValues = emps.stream().collect(
                Collectors.groupingBy(Employee::getDept));
        Map<String, Long> groupByCount = emps.stream().collect(
                Collectors.groupingBy(Employee::getDept, counting()));
        Map<String, Double> groupBySal = emps.stream().collect(
                Collectors.groupingBy(Employee::getDept,
                        averagingDouble(Employee::getSalary)));
        Map<String, Long> groupBySumsal = emps.stream().collect(
                Collectors.groupingBy(Employee::getDept,
                        summingLong(Employee::getSalary)));
        Map<String, Optional<Employee>> groupByMaxSalEmp = emps.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept,
                                maxBy(comparing(Employee::getSalary))));

        // Collectors.maxBy(Comparator.comparing(Employee::getSalary))

        System.out.println("avgSalforDept " + avgSalforDept);
        System.out.println("minSalforDept " + minSalforDept);
        System.out.println("maxSalforDept " + maxSalforDept);
        System.out.println("sumSalforDept " + sumSalforDept);
        System.out.println("groupByDeptValues " + groupByDeptValues);
        System.out.println("groupByCount " + groupByCount);
        System.out.println("groupBySal " + groupBySal);
        System.out.println("groupByDeptValues " + groupByDeptValues);
        System.out.println("groupBySumsal " + groupBySumsal);
        System.out.println("groupByMaxSalEmp " + groupByMaxSalEmp);

    }

}
