import java.util.Scanner;


/**
 * Created by arogoz on 7/8/2014.
 */


public class MyMain {

    public static void main(String[] args) {


        MyList list = new MyList();


        String key = " ";

        Object obj = null;


        MyHashMap myHashMapInstance = new MyHashMap();


        System.out.println("Enter your name in a format first name - Last name: ");

        System.out.println("After the last name enter 'end-end' world");


        while (!key.equals("end")) {

            String s;

            Scanner scan = new Scanner(System.in);

            s = scan.nextLine();

            String[] str = s.split("-");

            key = str[0];

            obj = str[1];

            if (!key.equals("end")) {

                myHashMapInstance.add(key, obj);


            }


        }

        myHashMapInstance.printMap();


    }

}