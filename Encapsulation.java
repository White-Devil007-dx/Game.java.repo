public class Encapsulation {
    public static void main(String[] args){
        bankAccount SBI = new bankAccount("Chakradhar", 6000);
        System.out.println(SBI.Check_balance());
        System.out.println(SBI.accountName());
        SBI.Deposit(-50);
        System.out.println(SBI.Check_balance());
        
    }
}
class bankAccount{
    private String AccountName;
    private int Balance;

    public bankAccount(String aName,int bal){
        this.AccountName = aName;
        this.Balance = bal;
    }
    public String accountName(){
        return AccountName;
    }
    public int Check_balance(){
        return Balance;
    }
    public void Deposit(int money){
        if(money<0){
            System.out.println("You cannot deposit negative amount");
        }
        else{
            Balance += money;
        }
    }
}
