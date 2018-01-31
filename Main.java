import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Pazuk on 25.01.2018.
 */

// Main idea:
// Step 1. Find all the numbers with same digits and mark em. For this perform
// every number of default array as array of digits.
// Step 2. Remove all marked numbers from array.
// Step 3. Get requested number from processed array

public class Main {

    static int[] arrayUnprocessed; //
    static ArrayList<Integer> arrayProcessed;

    static ArrayList<Integer> arraylistTemp;

    public static void main(String[] args) throws FileNotFoundException {

        int s=26057; // unprocessed array length. 26057 - because it is max lenght for
                     // max requested  position==10000 in processed  array.
                     // Able to be any length>=26057

        arrayUnprocessed = new int[s]; // unprocessed array {1, 2, 3, ... , s}
        for(int k=0; k<arrayUnprocessed.length; k++) {
            arrayUnprocessed[k]=k+1;
        }

        arrayProcessed=new ArrayList<>(); // processed array
        for(int f=0; f<s; f++) {
            arrayProcessed.add(f+1);
        }

        removeNumbers(); // remove from processed array all numbers with repeating digits



        PrintWriter writer=new PrintWriter("output.txt");

        int position=getPositionNumber(); // get position number from file
        boolean checkInput=true;
        if(position<1 || position>10000) { //check position number for compliance with the conditions of the task
            checkInput=false;
        }
        if(checkInput) {
            int arrayIndex=position-1; // convert position number to array index
            writer.print(arrayProcessed.get(arrayIndex)); // print the number in output file
        }
        writer.close();


    }

    static boolean checkIdenticalDigits(){ // check if array with number's digits have same digits
        boolean boo=false;
        int c=0;
        for (c = 0; c < arraylistTemp.size(); c++) {
            for (int b = c + 1; b < arraylistTemp.size(); b++) {
                if (arraylistTemp.get(c) == arraylistTemp.get(b)) { // check if digits are identical
                    boo = true;
                    break;
                }
            }
            if(boo) {
                break;
            }
        }
        if(boo) {
            return true;
        } else {
            return  false;
        }
    }


    static void removeNumbers(){ // remove from processed array all numbers with repeating digits
        int temp=0;
        int i=0;
        for(i=0; i<arrayUnprocessed.length; i++) {

            arraylistTemp=new ArrayList<Integer>();
            int u = 0;
            int x = arrayUnprocessed[i];
            int y=x;
            while (y>0) {
                temp = y % 10;
                arraylistTemp.add(u, temp);
                y = y / 10;
                u++;
            }

            checkIdenticalDigits();

            if (checkIdenticalDigits()) {
                arrayProcessed.set(i, 0); // mark all numbers with identical digits
            }
        }
        arrayProcessed.removeAll(Collections.singleton(0)); // remove all marked numbers from processed array
    }

    static int getPositionNumber() throws FileNotFoundException { // get position number from file
        File file=new File("input.txt");
        Scanner scanner=new Scanner(file);
        int position=scanner.nextInt();
        scanner.close();
        return position;
    }

}
