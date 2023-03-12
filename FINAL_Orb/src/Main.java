import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userName = myObj.nextLine();
        String area = userName.substring(0,3);
        String Type = userName.substring(3,4);
        System.out.println(area );
        System.out.println(Type);





    }
}