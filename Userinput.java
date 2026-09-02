import java.util.Scanner;
class Userinput{
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = cin.nextLine();
        System.out.print("Enter your age: ");
        int  age = cin.nextInt();
        System.out.print("Enter your gpa: ");
        double gpa = cin.nextDouble();
        System.out.println("Hello " + name);
        System.out.println("Your age is " + age);
        System.out.println("You got " + gpa);

        cin.close();
    }
}