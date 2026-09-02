//Demostration of Constructor overloading (overloading-> same name + different parameters)
class Student{
    String name;
    int age;
    double gpa;

    Student(String name,double gpa){//topper
        this.name = name;
        this.gpa = gpa;
    }
    Student(double gpa,int age){//duller
        this.gpa = gpa;
        this.age = age;
    }

    void display(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(gpa);

    }
}
public class Constructors2 {
    public static void main(String[] args){
        Student student1 = new Student("chakri",9.5);
        Student student2 = new Student(7.3,18);


        System.out.println(student1.gpa);
        System.out.println(student2.gpa);

        student1.display();

    }
    
}
