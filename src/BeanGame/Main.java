package BeanGame;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> bowls = new ArrayList<>();

    public static void main(String[] args) {
        bowls =  Initiate();
        System.out.println(bowls);
        int counter = 0;

        while (!isFinished(bowls)) {
            Optional<Integer> max = bowls.stream().max(Integer::compareTo);
            int index = bowls.indexOf(max.get());
            PickUp(bowls, index);
            counter++;
            System.out.print(counter + "- ");
            System.out.println(bowls);
        }
        System.out.println("It takes " + counter + " times to complete.");
    }

    private static void PickUp(ArrayList<Integer> bowls, int index) {
        bowls.set(index, bowls.get(index)-2);
        if (index != 0 && index != bowls.size()-1) {
            bowls.set(index-1, bowls.get(index-1)+1);
            bowls.set(index+1, bowls.get(index+1)+1);
        } else if (index == 0) {
            bowls.set(index+1, bowls.get(index+1)+1);
            bowls.add(0, 1);
        } else {
            bowls.set(index-1, bowls.get(index-1)+1);
            bowls.add(1);
        }

    }

    private static boolean isFinished(ArrayList<Integer> bowls) {
        for (int i : bowls) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> Initiate() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> bowlsArray = new ArrayList<>();

        System.out.print("Please Enter the initial beans sequence: ");
        int beanSeq = scanner.nextInt();

        while (beanSeq > 0) {
            bowlsArray.add(0, beanSeq % 10);
            beanSeq = beanSeq / 10;
        }
        //System.out.println(bowls.size());
        if (bowlsArray.size() < 2) {
            bowlsArray.add(0);
        }
        return bowlsArray;
    }
}