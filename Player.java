package player;

public class Player {
    
    String name;
    char symbol;
    String address;
    String number;
    String email;
    int age;
    public void setPlayerDetails(String name,char symbol,String address,String number,String email,int age)
    {
        this.name=name;
        this.symbol=symbol;
        this.address=address;
        this.number=number;
        this.email=email;
        this.age=age;
    }
    public void setPlayerNameAndSymbol(String name,char symbol)
    {
        this.name=name;
        this.symbol=symbol;
    }
    public void getPlayerDetails()
    {
        System.out.println("Player name:"+name);
        System.out.println("Player symbol:"+symbol);
        System.out.println("Player address:"+address);
        System.out.println("Player contact number:"+number);
        System.out.println("Player email:"+email);
        System.out.println("Player age:"+age);

    }
    public void getPlayerNameAndSymbol()
    {
        System.out.println("Player name:"+name);
        System.out.println("Player Symbol:"+symbol);
    }
    public String getPlayerName()
    {
        return this.name;
    }
    public char getSymbol()
    {
        return this.symbol;
    }

}
