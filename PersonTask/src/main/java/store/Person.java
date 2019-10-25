package store;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Класс человека со свойствами id, name, surname, birthday, sex
 * @author Елфимова Екатерина
 */

public class Person {

    /** Поле идентификатор*/
    private Long id;
    /** Поле имя*/
    private String  name;
    /** Поле фамилия*/
    private String surname;
    /** Поле дата рождения*/
    private LocalDate birthday;
    /** Поле пол*/
    private String sex;

    /**
     *Конструктор - создание нового объекта с определенными значениями
     * @param id идентификатор
     * @param name имя
     * @param surname фамилия
     * @param birthday дата рождения
     * @param sex пол
     */
    public Person(Long id, String name, String surname, LocalDate birthday, String sex) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
    }

    /**
     * Функция получения значений поля { @link Person#id }
     * @return возвращает идентификатор человека
     */
    public Long getId() {
        return id;
    }

    /**
     * Функция определения идентификатора {@link Person#id}
     * @param id идентификатор
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Функция получения значений поля {@link Person#name}
     * @return возвращает имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Функция определения имени {@link Person#name}
     * @param name идентификатор
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значений поля {@link Person#surname}
     * @return возвращает фамилию человека
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Функция определения фамилии {@link Person#surname}
     * @param surname идентификатор
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Функция получения значений поля {@link Person#birthday}
     * @return возвращает дату рождения
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Функция определения даты рождения {@link Person#birthday}
     * @param birthday идентификатор
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Функция получения значений поля {@link Person#sex}
     * @return возвращает пол человека
     */
    public String getSex() {
        return sex;
    }

    /**
     * Функция определения пола {@link Person#sex}
     * @param sex идентификатор
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Функция определения возраста
     * @return возраст
     */
    private int getAge() {
        return Years.yearsBetween(birthday, LocalDate.now()).getYears();
    }

    /**
     * Метод преобразования {@link Person} в строку
     * @return строка представление
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }
}
