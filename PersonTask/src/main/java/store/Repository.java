package store;

import java.util.Arrays;

/**
 * Класс для хранения объектов {@link Person}
 */
public class Repository {

    /**Поле пунктов увеличения массива*/
    private final static int numOfResize = 5;
    /**Поле люди*/
    private Person[] people= new Person[1];

    /**
     * Конструктор без параметров для хранилища
     */
    public Repository() {
    }

    /**
     * Метод для печати {@link Person} по идентификатору
     * @param id идентификатор
     */
    public void getById(Long id) {
        for (Person p:people) {
            if (p.getId().equals(id)) {
                System.out.println(p);
            }
        }
    }

    /**
     * Метод для добавления {@link Person} в хранилище
     * изменяющий размер хранилища при необходимости
     * @param p человек
     */
    public void addAndResize(Person p) {
        if (add(p))
            return;
        people = Arrays.copyOf(people,people.length + numOfResize);
        add(p);
    }

    /**
     * Метод для добавления {@link Person} в хранилище
     * @param p человек
     * @return добавлен ли {@link Person}
     */
    private boolean add(Person p) {
        for (int i=0; i<people.length; i++) {
            if (people[i]==null) {
                people[i]=p;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для печати всех {@link Person} в хранилище
     */
    public void getAll() {
        for (Person p:people) {
            if (p!=null) {
                System.out.println(p.toString());
            }
        }
    }

    /**
     * Метод для удаления {@link Person} по идентификатору
     * @param id идентификатор
     */
    public void deleteById(Long id) {
        int ind=0;
        for(int i=0;i<people.length;i++) {
            if((people[i]!=null)&&(people[i].getId().equals(id))) {
                ind=i;
            }
        }
        Person[] newArr=new Person[people.length-1];
        System.arraycopy(people, 0, newArr, 0,ind);
        System.arraycopy(people, ind+1, newArr,ind, people.length-ind-1);
        people= Arrays.copyOf(newArr,newArr.length);
    }
}
