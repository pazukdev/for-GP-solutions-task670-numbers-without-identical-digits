import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Pazuk on 25.01.2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int s=26057;
        int[] arrayUnprocessed = new int[s];
        for(int k=0; k<arrayUnprocessed.length; k++) {
            arrayUnprocessed[k]=k+1;
        }

        ArrayList<Integer> arrayProcessed=new ArrayList<>();
        for(int f=0; f<s; f++) {
            arrayProcessed.add(f+1);
        }

        int temp=0;
        int i=0;
        for(i=0; i<arrayUnprocessed.length; i++) {

            ArrayList<Integer> arraylistTemp=new ArrayList<Integer>();
            int u = 0;
            int x = arrayUnprocessed[i];
            int y=x;
            while (y>0) {
                temp = y % 10;
                arraylistTemp.add(u, temp);
                y = y / 10;
                u++;
            }

            boolean boo=false;
            int c=0;
            for (c = 0; c < arraylistTemp.size(); c++) {
                for (int b = c + 1; b < arraylistTemp.size(); b++) {
                    if (arraylistTemp.get(c) == arraylistTemp.get(b)) {
                        boo = true;
                        //break;
                    }
                }
            }

            if (boo) {
                arrayProcessed.set(i, 0);
            }
        }

        //System.out.println(Arrays.toString(arrayUnprocessed));
        //System.out.println(arrayProcessed);
        arrayProcessed.removeAll(Collections.singleton(0));
        //System.out.println(arrayProcessed);

        File file=new File("input.txt");
        Scanner scanner=new Scanner(file);
        int position=scanner.nextInt();
        scanner.close();

        PrintWriter writer=new PrintWriter("output.txt");
        boolean checkInput=true;
        if(position<1 || position>10000) {
            checkInput=false;
        }
        if(checkInput) {
            int arrayIndex=position-1;
            writer.print(arrayProcessed.get(arrayIndex));
            //System.out.println(position);
            //System.out.println(checkInput);
            //System.out.println(arrayProcessed.get(arrayIndex));
        }
        else {
            //System.out.println(position);
            //System.out.println(checkInput);
        }
        writer.close();


    }

}
