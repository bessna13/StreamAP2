import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long notAdult = persons.stream()
                .filter(x -> x.age > 18)
                .count();
        System.out.println(notAdult);

        persons.stream()
                .filter(y -> y.age >= 18 && y.age <= 27)
                .map(y -> y.getFamily())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        persons.stream()
                .filter(z -> z.getSex().equals(Sex.WOMAN) && z.age >= 18 && z.age <= 60 && z.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        persons.stream()
                .filter(z -> z.getSex().equals(Sex.MAN) && z.age >= 18 && z.age <= 65 && z.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

}
