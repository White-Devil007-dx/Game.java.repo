public class Game {
    public static void main(String[] args){
        Knight Igris = new Knight();
        Ninja Naruto = new Ninja();
        Dragon Toothless = new Dragon();
        Healer Angel = new Healer();
        Necromancer Leoric = new Necromancer();

        Toothless.showStats();
        Igris.showStats();
        Naruto.showStats();
        Angel.showStats();

        Leoric.summonSkeletons(30);
        Leoric.commandSkeletons(Toothless);

        Toothless.showStats();
        
        
    }
}

abstract class Character {
    protected int health;
    protected int attack;

    public Character(int health,int attack){
        this.health = health;
        this.attack = attack;
    }

    abstract void takeDamage(int x);
    abstract void showStats();
}

interface Villain {
    void fly();
    void heal();
}

interface Stealth {
    void invisible();
    void sneakAttack(Character target);
}

interface Magic {
    void heal(Character target);
    void regenerateMana();
}

interface DarkMagic {
    void summonSkeletons(int count);
    void commandSkeletons(Character target);
    void darkMeditation(int SacrificeCount); // kills some skeletons but restores mana significantly

    
}

class Necromancer extends Character implements Magic, DarkMagic{
    private int mana;
    private int skeletons;
    public Necromancer(){
        super(150,10);
        this.mana = 150;
        this.skeletons = 0;
    }

    void takeDamage(int x){
        System.out.println(getClass().getSimpleName() + " took " + x + " damage");
        health -= x;
    }
    void showStats(){
        System.out.println(getClass().getSimpleName() + 
                            " Health:" + health + 
                            " Attack:" + attack +
                            " Mana:" + mana + 
                            " Skeletons:" + skeletons);

    }
    @Override
    public void heal(Character target){
        if(mana >= 40){
            target.health += 20;
            mana -= 40;
            System.out.println(getClass().getSimpleName() + " healed " + 
                               target.getClass().getSimpleName() + " for 20 HP!");
        } else {
            System.out.println("Not enough mana to heal");
        }
    }
    @Override
    public void regenerateMana(){
        System.out.println("10 health is consumed for 30 mana for" + getClass().getSimpleName());
        mana += 30;
        health -= 10;

    }
    @Override
    public void summonSkeletons(int count){
        skeletons += count;
        mana -= count*6;//Each skeleton costs 6 mana
        System.out.println("*** " + count + " were summoned by " + getClass().getSimpleName());
    }
    @Override
    public void commandSkeletons(Character target){
        target.health -= skeletons*3;  //Each skeleton deals 3 damage instantly.
        System.out.println("The skeletons did " + skeletons*3 + " damage");
    }
    @Override
    public void darkMeditation(int SacrificeCount){
        if(SacrificeCount <= skeletons){
            System.out.println("***Ritual SUCCESSFUL***");
            skeletons -= SacrificeCount;
            mana += SacrificeCount*4;   //Soul tax is applied of 2 mana.
            System.out.println("Sacrificed " + SacrificeCount + " skeletons for " + SacrificeCount*4 + " mana");
        }
        else{
            System.out.println("***Ritual FAILED***");
            System.out.println("Cannot Sacrifice");
        }
    }
}

class Healer extends Character implements Magic {
    private int mana;

    public Healer(){
        super(80,5);
        this.mana = 100;
    }
    
    
    void showStats() {
        System.out.println(getClass().getSimpleName() + 
                           " Health:" + health + 
                           " Attack:" + attack + 
                           " Mana:" + mana);
    }

    
    void takeDamage(int x){
        System.out.println(getClass().getSimpleName() + " took " + x + " damage");
        health -= x;
    }

    @Override
    public void heal(Character target){
        if(mana >= 20){
            target.health += 40;
            mana -= 20;
            System.out.println(getClass().getSimpleName() + " healed " + 
                               target.getClass().getSimpleName() + " for 40 HP!");
        } else {
            System.out.println("Not enough mana to heal");
        }
    }

    @Override
    public void regenerateMana(){
        System.out.println("20 health is consumed for 30 mana for" + getClass().getSimpleName());
        mana += 30;
        health -= 20;
        
    }
}

class Knight extends Character {
    public Knight(){
        super(100,10);
    }

    
    void showStats(){
        System.out.println(getClass().getSimpleName() + 
                           " Health:" + health + 
                           " Attack:" + attack);
    }

    
    void takeDamage(int x){
        System.out.println(getClass().getSimpleName() + " took " + x + " damage");
        health -= x;
    }
}

class Ninja extends Character implements Stealth {
    public Ninja(){
        super(80,5);
    }
    
    
    void showStats(){
        System.out.println(getClass().getSimpleName() + 
                           " Health:" + health + 
                           " Attack:" + attack);
    }
    
    
    void takeDamage(int x){
        System.out.println(getClass().getSimpleName() + " took " + x + " damage");
        health -= x;
    }

    @Override
    public void invisible(){
        System.out.println(getClass().getSimpleName() + " now in Stealth mode");
    }

    @Override
    public void sneakAttack(Character target){
        System.out.println(getClass().getSimpleName() + 
                           " dealt 20 damage in stealth mode to " + 
                           target.getClass().getSimpleName());
        target.health -= 20;
    }
}

class Dragon extends Character implements Villain, Stealth {
    public Dragon(){
        super(200,15);
    }

    
    void showStats(){
        System.out.println(getClass().getSimpleName() + 
                           " Health:" + health + 
                           " Attack:" + attack);
    }

    
    void takeDamage(int x){
        System.out.println(getClass().getSimpleName() + " took " + x + " damage");
        health -= x;
    }

    @Override
    public void fly(){
        System.out.println(getClass().getSimpleName() + " flew away");
    }

    @Override
    public void heal(){
        health += 25;
        System.out.println(getClass().getSimpleName() + " healed 25 HP");
    }

    @Override
    public void invisible(){
        System.out.println(getClass().getSimpleName() + " vanished into smoke");
    }

    @Override
    public void sneakAttack(Character target){
        System.out.println(getClass().getSimpleName() + 
                           " dealt 25 damage in stealth mode to " + 
                           target.getClass().getSimpleName());
        target.health -= 25;
    }
}
