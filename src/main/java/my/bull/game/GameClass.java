package my.bull.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by book on 31.01.2018.
 */
public class GameClass {

    public static List<Integer> generate() {

        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 4) {
            generated.add(r.nextInt(9) + 1);
        }
        List<Integer> list = new ArrayList<Integer>(generated);
        Collections.shuffle(list);
        return list;
    }

    public static void main(String[] args) throws IOException {

        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 4) {
            generated.add(r.nextInt(9) + 1);
        }
        List<Integer> list = new ArrayList<Integer>(generated);
        Collections.shuffle(list);
        System.out.println(list.toString());

        int resultCount = 0;
        String resultString = "4Bulls4Cows";
        StringBuffer tryString = new StringBuffer(11);
        //---------in stream------------------------------------------------
        while(!resultString.equals(tryString.toString())) {
            tryString.delete(0,tryString.length());
            List<Integer> guessList = new ArrayList<Integer>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Integer:");
            try {
                guessList.add(Integer.parseInt(br.readLine()));
                guessList.add(Integer.parseInt(br.readLine()));
                guessList.add(Integer.parseInt(br.readLine()));
                guessList.add(Integer.parseInt(br.readLine()));

            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }

            tryString.append(bullExist(list, guessList) + "Bulls" + cowExist(list, guessList) + "Cows");
            System.out.println(tryString.toString());
            resultCount++;
        }
        System.out.println("u won with " + resultCount + " tries");
        //----------------------------------------------------------
    }

    public static int bullExist(List<Integer> secretArray,
                                   List<Integer> guessArray) {
        int count = 0;
        int k = 0;
        for (Integer i : guessArray)
            if (i.equals(secretArray.get(k++)))
                count++;
        return count;
    }

    public static int cowExist(List<Integer> secretArray,
                                    List<Integer> guessArray) {
        int count = 0;
        for (Integer i : guessArray) {
            if (secretArray.contains(i))
                count++;
        }

        return count;
    }
}
