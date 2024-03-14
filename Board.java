package board;

public class Board {

    public int size;
    public char matrix[][];
    public char symbol;
    public Board(int size,char symbol)
    {
        this.size=size;
        this.symbol=symbol;
        matrix= new char[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                matrix[i][j]=symbol;
            }
        }
    }
    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
