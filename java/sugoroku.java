import java.util.*;
import java.io.*;

class sugoroku{
    public static void main(String[] args){
        System.out.println("30マス先にゴールがあります。");
        System.out.println("1,2,3の３つの目を持つ特別なサイコロ10個を、好きな数だけ振って駒を進めます。");
        System.out.println("ぴったり上がりに止まれば終わりです。目の数が多ければ、余った目の数だけ戻ります。");
        System.out.println("---------------------------------------------------");
        sugoroku.gameplay();
    }
    public static void gameplay(){
        Scanner scanner = new Scanner(System.in);
        boolean Flag=true;
        int n = 30;
        int IND = 0;
        int count = 0;
        String[] position = new String[30]; 
        for(int j = 0; j < 30; j++){
            position[j] = "-";
        }
        position[0] = "＊";
        while(Flag==true){
            System.out.print(Arrays.toString(position));
            System.out.print("|上がり!\n");
            System.out.println("残りマスは" + n + "マスです。サイコロの数は?");
            int number = scanner.nextInt();
            if(number>10){
                System.out.println("サイコロの数は10個までです");
                continue;
            }
            int diceTotal = sugoroku.DiceNumber(number);
            if(n>diceTotal){
                count++;
                n = n-diceTotal;
                position[IND] = "-";
                position[29-n] = "＊";
                IND = 29-n;
                System.out.println("出た目の合計" + diceTotal);
            }else if(n<diceTotal){
                count++;
                n = diceTotal-n;
                position[IND] = "-";
                position[29-n] = "＊";
                IND = 29-n;
                System.out.println("出た目の合計" + diceTotal);
            }else if(n==diceTotal){
                count++;
                System.out.println("出た目の合計" + diceTotal);
                System.out.println("おめでとう！！" + count + "回目で上がりです");
                System.out.println("もう一度やりますか？（1=Yes; 0=No!）");
                int ans = scanner.nextInt();
                if(ans==1){
                    n = 30;
                    position[IND] = "-";
                    position[0]="＊";
                    IND = 0;
                    count=0;
                }else if(ans==0){
                    scanner.close();
                    Flag=false;
                }
            }
        }
    }

    public static int  DiceNumber(int number){
        Random RandObj = new Random();
        int dice;
        int diceTotal = 0;
        for(int i = 0; i <= number; i++){
            dice = RandObj.nextInt(3)+1;
            diceTotal = diceTotal+dice;
        }
        return diceTotal;
    }
    
}