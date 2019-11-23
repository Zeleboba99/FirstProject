package ru.vsu.lab.store.entities;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import ru.vsu.lab.store.entities.enums.Gender;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс человека со свойствами id, name, surname, birthday, sex
 * @author Елфимова Екатерина
 */

public class Person implements IPerson{

    /** Поле идентификатор*/
    private Integer id;
    /** Поле имя*/
    private String firstName;
    /** Поле фамилия*/
    private String lastName;
    /** Поле пол*/
    private Gender gender;
    /** Поле дата рождения*/
    private LocalDate birthdate;


    private IDivision division;

    private BigDecimal salary;

    /**
     *Конструктор - создание нового объекта с определенными значениями
     * @param id идентификатор
     * @param firstName имя
     * @param lastName фамилия
     * @param birthdate дата рождения
     * @param gender пол
     */
    public Person(Integer id, String firstName, String lastName, Gender gender, LocalDate birthdate, IDivision division, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Функция получения значений поля { @link Person#id }
     * @return возвращает идентификатор человека
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Функция определения идентификатора {@link Person#id}
     * @param id идентификатор
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Функция получения значений поля {@link Person#firstName}
     * @return возвращает имя человека
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Функция определения имени {@link Person#firstName}
     * @param firstName идентификатор
     * @return
     */
    @Override
    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    /**
     * Функция получения значений поля {@link Person#lastName}
     * @return возвращает фамилию человека
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Функция определения фамилии {@link Person#lastName}
     * @param lastName идентификатор
     * @return
     */
    @Override
    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    /**
     * Функция получения значений поля {@link Person#birthdate}
     * @return возвращает дату рождения
     */
    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Функция определения даты рождения {@link Person#birthdate}
     * @param birthdate идентификатор
     * @return
     */
    public LocalDate setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return birthdate;
    }

    /**
     * Функция получения значений поля {@link Person#gender}
     * @return возвращает пол человека
     */
    @Override
    public Gender getGender() {
        return gender;
    }

    /**
     * Функция определения пола {@link Person#gender}
     * @param gender идентификатор
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Функция определения возраста
     * @return возраст
     */
    @Override
    public Integer getAge() {
        return Years.yearsBetween(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public IDivision getDivision() {
        return division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    /**
     * Метод преобразования {@link Person} в строку
     * @return строка представление
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
