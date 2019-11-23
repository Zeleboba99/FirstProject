package ru.vsu.lab.store.repository;

import com.opencsv.CSVReader;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import ru.vsu.lab.store.entities.IPerson;
import ru.vsu.lab.store.entities.Person;
import ru.vsu.lab.store.entities.enums.Gender;
import ru.vsu.lab.store.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

/**
 * Класс для хранения объектов {@link Person}
 */
public class Repository implements IRepository{

    //создать массив подразделений для того чтобы не плодить новых дивизий
    /**Поле пунктов увеличения массива*/
    private final static int numOfResize = 5;
    /**Поле люди*/
    private IPerson[] people = new IPerson[5];

    /**
     * Конструктор без параметров для хранилища
     */
    public Repository() {
    }

    /**
     * Конструктор с параметрами для хранилища
     * @param people люди
     */
    public Repository(IPerson[] people) {
        this.people = people;
    }


    /**
     * Метод для добавления {@link Person} в хранилище
     * изменяющий размер хранилища при необходимости
     * @param p человек
     */
    @Override
    public void add(IPerson p) {
        if (tryAdd(p))
            return;
        people = Arrays.copyOf(people,people.length + numOfResize);
        tryAdd(p);
    }

    /**
     * Method for removing by index in repository {@link IPerson}
     * @param index
     * @return Optional of removing person
     */
    @Override
    public Optional<IPerson> delete(int index) {
        if (index>=getLastIndexOfNotNull()+1 || index<0)
            return Optional.empty();
        IPerson person=people[index];
        System.arraycopy(people, index+1, people, index,people.length-index-1);
        people[people.length-1]=null;
        return Optional.of(person);
    }

    /**
     * Method for reciving {@link IPerson} from repository
     * @param index
     * @return Optional of getting person
     */
    @Override
    public Optional<IPerson> get(int index) {
        if (index>=getLastIndexOfNotNull()+1 || index<0)
            return Optional.empty();
        return Optional.of(people[index]);
    }

    /**
     * Method for set {@link IPerson}
     * @param index
     * @param person
     * @return
     */
    @Override
    public Optional<IPerson> set(int index, IPerson person) {
        if (index>=getLastIndexOfNotNull()+1 || index<0)
            return Optional.empty();
        people[index]=person;
        return Optional.of(person);
    }

    @Override
    public void add(int index, IPerson person) {
        if (index>getLastIndexOfNotNull()+1 || index<0)
            return;
        IPerson[] newArr = new IPerson[people.length+1];
        System.arraycopy(people, 0, newArr, 0,index);
        newArr[index]=person;
        System.arraycopy(people, index, newArr, index+1, people.length-index);
        people = Arrays.copyOf(newArr,newArr.length);
    }

    @Override
    public List<IPerson> toList() {
        return Arrays.asList(people);
    }

    @Override
    public void sortBy(Comparator<IPerson> comparator) {
        Sorter sorter = new Sorter();
        sorter.bubleSort(comparator, people);
    }

    @Override
    public IRepository searchBy(Predicate<IPerson> condition) {
        IRepository newRepository=new Repository();
        for (IPerson person : people) {
            if (Optional.ofNullable(person).isPresent() && condition.test(person)) {
                newRepository.add(person);
            }
        }
        return newRepository;
    }

    public void loadCSVFile(String filePath){
        CSVReader reader = null;
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.mm.yyyy");
        try {
            reader = new CSVReader(new FileReader(filePath), ';');
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                add(new Person(Integer.parseInt(line[0]), line[1], line[1], Gender.valueOf(line[2].toUpperCase()), dtf.parseLocalDate(line[3]), null, new BigDecimal(line[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод для добавления {@link Person} в хранилище
     * @param p человек
     * @return добавлен ли {@link Person}
     */
    private boolean tryAdd(IPerson p) {
        for (int i=0; i<people.length; i++) {
            if (!Optional.ofNullable(people[i]).isPresent()) {
                people[i]=p;
                return true;
            }
        }
        return false;
    }



    private int getLastIndexOfNotNull(){
        for(int i=people.length-1;i<=0;i--){
            if (people[i]!=null)
                return i;
        }
        return 0;
    }


}
