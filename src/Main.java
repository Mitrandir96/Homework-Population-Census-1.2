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
        Stream<Person> underage = persons.stream();
        Stream<Person> conscripts = persons.stream();
        Stream<Person> ableToWork = persons.stream();
        underage
                .filter(x -> x.getAge() < 18)
                .count();

        List<String> newConscripts = conscripts
                .filter(x -> x.getSex().equals(Sex.MAN) && x.getAge() <= 27 && x.getAge() >= 18)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());

        System.out.println(newConscripts);

        List<Person> filteredPerson = ableToWork
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x -> (x.getSex().equals(Sex.MAN) && x.getAge() >= 18 && x.getAge() < 65) ||
                        (x.getSex().equals(Sex.WOMAN) && x.getAge() >= 18 && x.getAge() < 60))
                .sorted(Comparator.comparing(x -> x.getFamily()))
                .collect(Collectors.toList());

        System.out.println(filteredPerson);














    }
}