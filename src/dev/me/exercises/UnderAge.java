package dev.me.exercises;

import dev.me.exercises.data.Person;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Get the names of all kids under the age of 18
 */
public class UnderAge {
    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(f -> f.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toSet());
    }
}
