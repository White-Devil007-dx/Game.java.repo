public class Interfaces {
    public static void main(String[] args){
        Rabbit rabbit = new Rabbit();
        Fish fish = new Fish();
        Hawk hawk = new Hawk();
        fish.flee();
        hawk.hunt();
        rabbit.flee();
    }
}

interface prey {

    void flee();
}
interface predator {

    void hunt();
}
class Rabbit implements prey{

    @Override
    public void flee(){
        System.out.println("The rabbit is running away");
    }
}
class Fish implements prey{
    @Override
    public void flee(){
        System.out.println("The fish is escaping by swimming very fast");
    }
}
class Hawk implements predator{
    @Override
    public void hunt(){
        System.out.println("The Hawk is out for hunt");
    }

}

