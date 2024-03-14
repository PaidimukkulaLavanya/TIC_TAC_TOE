import java.util.Scanner;

import board.Board;
import player.Player;
import game.Game;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First project -> TIC TAC TOE ");
        Board b=new Board(3,'-');
        b.printBoard();


        Scanner sc=new Scanner(System.in);

        System.out.println("enter the first person name");
        String name=sc.nextLine();
        System.out.println("Enter symbol");
        char symbol=sc.next().charAt(0);
        sc.nextLine();


        Player p1=new Player();
        p1.setPlayerDetails(name, symbol, "Guntur","63","hari@gmail.com",18);
        p1.getPlayerNameAndSymbol();

        System.out.println("enter the second person name");
        name=sc.nextLine();
        System.out.println("Enter symbol");
        symbol=sc.next().charAt(0);
        sc.nextLine();


        Player p2=new Player();
        p2.setPlayerDetails(name, symbol, "banglore","91","vaishu@gmail.com",21);
        p2.getPlayerNameAndSymbol();


        Game g=new Game(new Player[]{p1,p2},b);
        g.play();
        sc.close();

    }

}
