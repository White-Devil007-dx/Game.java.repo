public class Game {
    public static void main(String[] args){
        Knight igris = new Knight();
        ninja naruto = new ninja();
        Dragon toothless = new Dragon();
        
        toothless.takeDamage(igris.attack);
        naruto.takeDamage(toothless.attack);
        naruto.invisible();
        toothless.takeDamage(igris.attack);
        toothless.invisible();
        toothless.heal();
        igris.takeDamage(toothless.attack);
        igris.showStats();
        toothless.showStats();
        naruto.showStats();

        
    }
}

abstract class character{
    protected int health;
    protected int attack;
    public character(int health,int attack){
        this.health = health;
        this.attack = attack;
    }
    abstract void takeDamage(int x);
    abstract void showStats();

}
interface Villian{
    public void fly();
    public void heal();
    
}
interface Stealth{
    public void invisible();
}
class Knight extends character {// 100,10
    public Knight(){
        super(100,10);
    }
    @Override
    void showStats(){
        System.out.println("Knight Health:" + this.health + "Knight attack:" + this.attack);

    }
    @Override
    void takeDamage(int x){
        System.out.println("Knight took " + x + "damage");
        health -= x;
    }
}
class ninja extends character implements Stealth{
    public ninja(){
        super(80,5);
    }
    @Override
    void showStats(){
        System.out.println("Ninja Health:" + this.health + "Ninja attack:" + this.attack);

    }
    @Override
    void takeDamage(int x){
        System.out.println("Ninja took" + x + "damage");
        health -= x;

    }
    @Override
    public void invisible(){
        System.out.println("Ninja now in Stealth mode");
    }
}
class Dragon extends character implements Villian,Stealth{
    public Dragon(){
        super(200,15);
    }
    @Override
    void showStats(){
        System.out.println("Dragon Health:" + this.health + "Dragon attack:" + this.attack);

    }
    @Override
     void takeDamage(int x){
        System.out.println("Dragon took" + x +  "damage");
        health -= x;
    }
    @Override
    public void fly(){
        System.out.println("Dragon flew away");
    }
    @Override
    public void heal(){
        System.out.println("Dragon healed 25 hp");
        health += 25;
    }
    @Override
    public void invisible(){
        System.out.println("Dragon vanished into smoke");
    }
}


