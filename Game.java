package game;
import board.Board;
import player.Player;
import java.util.Scanner;


public class Game {
    Player[]players;
    Board b;
    int turns;
    int noOfMoves;
    boolean gameOver;
    String zeros;
    String cross;
    public Game(Player []players,Board b)
    {
        this.players=players;
        this.b=b;
        this.turns=0;
        this.noOfMoves=0;
        this.gameOver=false;
        StringBuilder z=new StringBuilder();
        StringBuilder c=new StringBuilder();
        for(int i=0;i<b.size;i++)
        {
            z.append(players[0].getSymbol());
            c.append(players[1].getSymbol());
        }
        this.zeros=z.toString();
        this.cross=c.toString();

    }

    public void printBoardConfig()
    {
        int s=b.size;
        for(int i=0;i<s;i++)
        {
            for(int j=0;j<s;j++)
            {
                System.out.print(b.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void play(){
        printBoardConfig();
        int sz = b.size;

        while(!gameOver){
            noOfMoves++;
            int idx = getIndex();

            int row = idx/sz;
            int col = idx%sz;

            b.matrix[row][col] = players[turns].getSymbol();

            if(noOfMoves>=sz*sz){
                System.out.println("Game Draw");
                return;
            }

            if(noOfMoves>=2*sz-1 && check()==true){
                gameOver = true;
                printBoardConfig();
                System.out.println("Winner is "+players[turns].getPlayerName());
                return;
            }

            turns = (turns+1)%2;
            printBoardConfig();
        }
    }
    
    public int getIndex()
    {
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("player:"+players[turns].getPlayerName()+"enter the position");
            int position=sc.nextInt()-1;
        
            int s=b.size;
            int row=position/s;
            int col=position%s;
            if(row>=s ||row<0 ||col>=s ||col<0)
            {
                System.out.println("invalid position .please select position again");
                continue;
            }
            if(b.matrix[row][col]!='-')
            {
                System.out.println("position already filled .please select position again");
                continue;
            }
           // sc.close();

            return position;
        }
    }
    public boolean check()
    {
        int s=b.size;
        char m[][]=b.matrix;
        

        //rowwise
        for(int i=0;i<s;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s;j++)
            {

                sb.append(m[i][j]);
            }
            String str=sb.toString();

        
            if(str.equals(zeros)||str.equals(cross))
            {
                return true;
            }
        }



        //colwise
        for(int i=0;i<s;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s;j++)
            {
                sb.append(m[j][i]);
            }
            String str=sb.toString();
        
            if(str.equals(zeros)||str.equals(cross))
            {
                return true;
            }
        }



        //diagonalwise
        for(int i=0;i<s;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s;j++)
            {
                if(i==j)
                {
                    sb.append(m[i][j]);
                }
            }
            String str=sb.toString();
            if(str.equals(zeros)||str.equals(cross))
            {
                return true;
            }
        }

        //antidiagonal
        int i=0;
        int j=s-1;
        StringBuilder sb=new StringBuilder();
        while(i<s)
        {
            sb.append(m[i][j]);
            i++;
            j--;
        }
        String str=sb.toString();
        if(str.equals(zeros)||str.equals(cross))
        {
            return true;
        }
        return false;

    }


    
}
