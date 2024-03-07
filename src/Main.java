import java.util.ArrayList;
import java.util.List;

//Интерфейс определяющий методы для всех кандидатов
interface Candidate{
    //кандидат должен уметь представляться и описывать свой опыт
    void hello();
    void describeExperience();
}

//Создаем абстрактныый класс который реализует интерфейс(для этого имплиментируем класс с интерфейсом ) и содержит логику для всех кондидатов
abstract class AbstractCandidate implements Candidate{
    protected String name;
    //конструктор позволяющий принимать имя
    public AbstractCandidate(String name){
        this.name=name;
    }
    //Реализация приветсвия
    @Override
    public void hello(){
        System.out.println("Hi! My name is " + name + "!");
    }
    // Абстрактный метод describeExperience, который должен быть переопределен в подклассах
    @Override
    public abstract void describeExperience();
}
//Создаем класс для кандидата которыйц сам изучал
class SelfLearner extends AbstractCandidate{
    public SelfLearner(String name) {
        super(name);
    }
    //Метод который выводит сообщение что кандидат сам изучал
    @Override
    public void describeExperience(){
        System.out.println("I have been learning Java by myself, nobody examined how thorough is my knowledge and how good is my code.");
    }
}

//Создаем класс для кандидата который окончил курсы
class GetJavaJobGraduate extends AbstractCandidate{
    public GetJavaJobGraduate(String name){
        super(name);
    }
    //Метод который выводит сообщение что кандидат успешно прошел курсы
    @Override
    public void describeExperience(){
        System.out.println("I passed successfully getJavaJob exams and code reviews.");
    }
}

//Создаем класс который представляет работодателя
class Employer{
    //метод для привествия
    public void hello(){
        System.out.println("Hi! Introduce yourself and describe your java experience please");
    }
}
//Создаем точку входа/класс Main
public class Main {
    public static void main(String[] args) {
        //Создаем объект
        Employer employer = new Employer();
        //создаем кондидатов
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new SelfLearner("Anna"));
        candidates.add(new GetJavaJobGraduate("Max"));
        candidates.add(new SelfLearner("Brad"));
        candidates.add(new GetJavaJobGraduate("Dan"));
        candidates.add(new SelfLearner("Eve"));
        candidates.add(new GetJavaJobGraduate("Frank"));
        candidates.add(new SelfLearner("Petr"));
        candidates.add(new GetJavaJobGraduate("Ivan"));
        candidates.add(new SelfLearner("Igor"));
        candidates.add(new GetJavaJobGraduate("Anton"));

        //Проходим циклом по всему лситу и выводим диалог
        for(Candidate candidate : candidates){
            employer.hello();
            candidate.hello();
            candidate.describeExperience();
            System.out.println();
        }
    }
}