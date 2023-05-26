package dev.me.exercises;

import dev.me.exercises.data.Person;
import java.util.Comparator;
import java.util.List;

public class GetOldestPerson {
    public static dev.me.exercises.data.Person getOldestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get();
    }
}
