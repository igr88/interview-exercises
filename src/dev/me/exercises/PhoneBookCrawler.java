package dev.me.exercises;

import java.util.Map.Entry;

public class PhoneBookCrawler extends PhoneBook {
    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return phoneBook.getPhoneBookEntries().entrySet().stream()
                .filter(entry -> entry.getKey().equals(name))
                .map(Entry::getValue)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }

}
