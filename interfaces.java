
import java.util.*;

public class interfaces implements CollectionTest{
    //Initialises the variables
    private CollectionType typeOfStructure;
    private TestType typeOfTest;
    private int size = 0;
    private LinkedList<Person> peopleLL = new LinkedList<Person>();
    private ArrayList<Person> peopleAL = new ArrayList<Person>();
    private HashMap<Integer, Person> peopleHM = new HashMap<Integer, Person>();
    public void setSize(int size){
        this.size = size;
    }

    public void runTest(CollectionType type, TestType test, int iters){
        this.typeOfStructure = type;
        this.typeOfTest = test;
        for(int i = 0; i<iters;i++){
            if(typeOfTest == TestType.ADD){
                add();
            }else if(typeOfTest == TestType.INDEX){
                index();
            }else{
                search();
            }
        }

    }

    public void add(){
        for(int i = 0; i<size;i++){
            Person person = new Person("Person"+Integer.toString(i), 80);
            if(typeOfStructure == CollectionType.LINKED_LIST){
                peopleLL.add(i,person);
            }else if(typeOfStructure == CollectionType.ARRAY_LIST){
                peopleAL.add(i, person);
            }else{
                peopleHM.put(i, person);
            }
        }

    }
    public Person index(){
        if(typeOfStructure == CollectionType.LINKED_LIST){
            return peopleLL.get((int)(size/2));
        }else if(typeOfStructure == CollectionType.ARRAY_LIST){
            return peopleAL.get((int)(size/2));
        }else{
            return peopleHM.get((int)(size/2));
        }
    }
    public Person search(){
        for(int i = 0; i<size;i++){
            if(typeOfStructure == CollectionType.LINKED_LIST){
                if(peopleLL.get(i).getName() == "Person"+Integer.toString((int)(size/2))){
                    return peopleLL.get(i);
                }
            }else if(typeOfStructure == CollectionType.ARRAY_LIST){
                if(peopleAL.get(i).getName() == "Person"+Integer.toString((int)(size/2))){
                    return peopleAL.get(i);
                }
            }else{
                if(peopleHM.get(i).getName() == "Person"+Integer.toString((int)(size/2))){
                    System.out.println(peopleHM.get(i).getName());
                    return peopleHM.get(i);
                }
            }
        }
        return null;

    }
}
