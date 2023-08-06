package ua.andrii.springcourse.db;

import ua.andrii.springcourse.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PeopleDB {
    public static int PEOPLE_ID;
    public static List<Person> personList;

    static {
        personList = new ArrayList<>();
        personList.add(new Person(++PEOPLE_ID, "Andrii", 44, "andrii@ukr.net"));
        personList.add(new Person(++PEOPLE_ID, "Dina", 43, "dina@ukr.net"));
        personList.add(new Person(++PEOPLE_ID, "Glib", 16, "glib@ukr.net"));
    }
}
