package view;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import store.Person;
import store.Repository;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Класс представление для взаимодействия с пользователем
 */
public class PeopleView {
    /** Поле сканер*/
    private static Scanner in = new Scanner(System.in);
    /**Поле хранилище*/
    private Repository repository;

    /**
     * Конструктор без параметров
     */
    public PeopleView() {
        this.repository = new Repository();
    }

    /**
     * Метод для взаимодействия с пользователем
     */
    public void show() throws ParseException {
        while (true) {
            int action=in.nextInt();
            switch (action) {
                case 0: {
                    repository.getAll();
                    break;
                }
                case 1: {
                    System.out.println("enter id");
                    int id = in.nextInt();
                    System.out.println("enter name");
                    String name = in.next();
                    System.out.println("enter surname");
                    String surname = in.next();
                    System.out.println("enter birthday");
//                    Data data=in.next();
                    System.out.println("enter sex");
                    String sex = in.next();

                    String dateTime = "11/15/2013";
                    DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
                    LocalDate jodatime = dtf.parseLocalDate(dateTime);

                    Person person=new Person((long)id, name, surname, jodatime, sex);
                    repository.addAndResize(person);
                    break;
                }
                case 2: {
                    System.out.println("enter id");
                    int id = in.nextInt();
                    repository.deleteById((long)id);
                }
            }
        }
    }

}
