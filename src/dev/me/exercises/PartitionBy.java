package dev.me.exercises;

import static java.util.Arrays.asList;

import dev.me.exercises.data.Person;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*

Partition these people into adults and kids, you'll need a special collector for this one
 */
public class PartitionBy {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults(collection);

        result.forEach((k,v) -> System.out.println("[" + k + "]: " + v));
    }
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 18));
    }
}
