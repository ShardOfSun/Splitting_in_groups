/*1к 15г Терновская Е.В.
  Вариант 22(*) В классе N мальчиков и M девочек. Необходимо разбить всех учеников на
команды так, чтобы в каждой команде было ровно по 3 человека (и мальчики и
девочки). Необходимо определить, какое максимальное кол-во команд, следуя
данным правилам, можно составить из учеников данного класса. (Очевидно, что
возможны ситуации, когда некоторые ученики не войдут ни в одну команду.)
Ввод: boys, girls
Вывод: maxGroup

30/2>10 +10 30-10
15/2=7 +7 break
15/2<10 +15/2 15-15/2*2  -15/2

*/
import java.util.Scanner;

public class Main {
    public static int Splitting(int boys, int girls){
        int maxGroup = 0;
        int count = 0;
        while (Math.min(boys, girls) != 0) {
            count++;
            if (Math.max(boys,girls) / 2 == Math.min(boys, girls)) { maxGroup += Math.min(boys, girls); break; }
            else if (Math.max(boys,girls) / 2 < Math.min(boys, girls)) {
                maxGroup += Math.max(boys, girls) / 2;

                if (boys > girls) { girls -= boys/2; boys -= boys/2*2; }
                else { boys -= girls/2; girls -= girls/2*2; }
            }
            else if (Math.max(boys,girls) / 2 > Math.min(boys, girls)){
                maxGroup += Math.min(boys, girls);

                if (boys > girls) { boys -= girls*2; girls = 0; }
                else { girls -= boys*2; boys = 0; }
            }
        }
        System.out.println(count);
        return maxGroup;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to program Splitting into groups!\nInput the number of Boys: ");
        int boys = scanner.nextInt();

        System.out.println("Input the number of Girls: ");
        int girls = scanner.nextInt();
        if (girls < 0 || boys < 0) {
            System.out.println("Incorrect input!");
            System.exit(-1);
        }
        System.out.println("The maximum number of groups is: " + Splitting(boys, girls));
    }
}