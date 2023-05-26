package dev.me.exercises;

import static java.util.Arrays.asList;

import dev.me.exercises.data.Person;
import java.util.List;
import java.util.stream.Collectors;

/*
Return a comma-separated string of all these people's names
 */
public class StreamJoining {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        System.out.println(namesToString(collection));
    }

    public static String namesToString(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
    }
}
