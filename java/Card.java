import java.util.*;
import java.io.*;
import java.lang.*;

class Card{
    public static void main(String arg[]){
        System.out.println("最初に１枚カードが出ますから掛け金を決めてください。");
        System.out.println("次に出るカードが前のカードと同じか大きければ，あなたの勝ちです。");
        System.out.println("掛け金が戻りますから、続けるかどうかを決めてください。");
        System.out.println("続けて勝てば掛け金は2倍になります。以降，4倍，８倍と戻るお金が増えます。ただし，負けるとそれまでの勝ちはなくなります。");
        System.out.println("所持金がなくなって破産するか，1000＄を超えるとゲーム終了です。");
        System.out.println("---------------------------------------------------------------");
        Card.game();
    }
    public static void game(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int money = 100;
        while(flag==true){
            double buf = 2;
            double mag;
            int cont = 0;
            boolean winflag = true;
            System.out.println("ゲームを開始します。所持金は" + money + "＄です。");
            System.out.println("最初のカードです。");
            int ownerCard = Card.card();
            System.out.println("いくら賭けますか？(1$～" + money + "＄)");
            int bet = scanner.nextInt();
            while(winflag==true){
                int playerCard = Card.card();
                if(ownerCard<=playerCard){
                    cont++;
                    buf = buf*(Math.pow(2, (cont-1)));
                    mag = Math.floor(buf);
                    if(cont!=1){
                        bet = bet*(int)mag;
                    }
                    System.out.println("あなたの勝ち。" + bet + "＄の勝ちです。");
                    System.out.print("倍率は" + mag + "倍。");
                    System.out.println("続けますか?(1=Yes;0=No!)");
                    int flagNumber = scanner.nextInt();
                    if(flagNumber==0){
                        //所持金＋する
                        money = money+bet;
                        winflag=false;
                    }
                }else{
                    System.out.println("あなたの負け。");
                    money= money-bet;
                    winflag = false;
                }

                if(money>=1000){
                    System.out.println("所持金は" + money + "＄です。");
                    System.out.println("おめでとうございます。所持金が1000＄を超えました！");
                    flag=false;
                }else if(money<=0){
                    System.out.println("破産しました。");
                    flag=false;
                }
            }
        }
        scanner.close();
    }
    public static int card(){
        Random RandObj = new Random();
        int number = RandObj.nextInt(12)+1;
        if(number==1||number==11||number==12||number==13){
            switch (number){
                case 1:
                    System.out.println("|A|");
                    break;
                case 11:
                    System.out.println("|J|");
                    break;
                case 12:
                    System.out.println("|Q|");
                    break;
                case 13:
                    System.out.println("|K|");
                    break;
            }
        }else{
            System.out.println("|" + number + "|");
        }
    return number;
    }
}