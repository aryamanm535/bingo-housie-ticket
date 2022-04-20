import java.util.*;
class housie
{
    int card[][] = new int[3][9];
    ArrayList <Integer> random = new ArrayList();
    ArrayList <Integer> combos = new ArrayList();
    void card()
    {
        //adding random digits in order: 1s in col 0, 10s in col 1, etc. Adding digits to each index for now, blanks will be added later
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<9;)
            {
                int x = (int)(Math.random()*((j+1)*10 - j*10) + j*10);
                if (x==0)
                    x=1;
                if(!inArray(x,random))
                {
                    random.add(x);
                    card[i][j] = x;
                    j++;
                }
            }
        }
        //sorting array column wise
        int col = 0;
        while(col<9)
        {
            for(int i=0; i < 2; i++)
            {  
                int minIndex = i;
                for(int j=i+1; j < 3; j++)
                {  
                    if(card[j][col] < card[minIndex][col])
                    {  
                        minIndex = j; 
                    }  
                }  
                int temp = card[minIndex][col];
                card[minIndex][col] = card[i][col];
                card[i][col] = temp;
            }  
            col++;
        }
        //adding blanks in 4 random places in each row
        for(int j=0; j<3; j++)
        for(int i=0; i<4;)
        {
            int c = (int)(Math.random()*9);
            String combo = Integer.toString(j)+Integer.toString(c);
            int comb = Integer.parseInt(combo);
            if(!inArray(comb, combos))
            {
                card[j][c] = 100;
                i++;
                combos.add(comb);
            }
        }
    }

    boolean inArray(int a, ArrayList <Integer> b)
    {
        for(int i=0; i<b.size(); i++)
        {
            if(a == b.get(i))
                return true;
        }
        return false;
    }

    void display()
    {
        System.out.println();
        System.out.println();
        for(int i=0; i<3; i++) 
        {
            for(int j=0; j<9; j++)
            {
                if(card[i][j] == 100)
                    System.out.print("   ");
                else
                {
                    if(isSingleDigit(card[i][j]))
                        System.out.print(card[i][j]+"  ");
                    else
                        System.out.print(card[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    boolean isSingleDigit(int x)
    {
        int count = 0;
        while(x>0)
        {
            x = x/10;
            count++;
        }
        if(count == 1)
            return true;
        return false;
    }

    public static void main()
    {
        housie card1 = new housie();
        housie card2 = new housie();
        housie card3 = new housie();
        housie card4 = new housie();
        housie card5 = new housie();
        housie card6 = new housie();
        housie card7 = new housie();
        housie card8 = new housie();
        housie card9 = new housie();
        housie card10 = new housie();
        card1.card();
        card1.display();
        card2.card();
        card2.display();
        card3.card();
        card3.display();
        card4.card();
        card4.display();
        card5.card();
        card5.display();
    }
}
