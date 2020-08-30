import java.util.Vector;
import java.util.Iterator;
import java.util.Arrays;

class Q2 {  // Change to Main if you're using an online compiler
    public static String doubleSpeak(String S, Vector V){           // or well :\
        char tArr[] = S.toCharArray();

        for (Iterator<String> iter = V.iterator(); iter.hasNext(); ) {  //iterating-on-elements-of-vec
            String temp = iter.next();
            System.out.println(temp);
            for(int i = 0; i < S.length(); i++){
                if(S.indexOf(temp,i) == i){
                    System.out.println(i);
                    System.out.println(temp.length());
                    for(int j = i+1; j < temp.length(); j++){
                        System.out.println("2");
                        tArr[j] = '*';    // Somehow manages to replace only when the word is at location 0 and then only one instance. Why not just use python for this seriously. This immutability thing reminds me of purely recursive languages smh.
                    }
                }
            }
        }
        System.out.println(tArr);
        String op = new String(tArr);
        return op;
    }


    public static void main(String[] args) {
        Vector vecOfStrings = new Vector();
        vecOfStrings.add("happy");
        vecOfStrings.add("fun");
        //vecOfStrings.add("Elation");

        String ipString = System.console().readLine();
        String opString = doubleSpeak(ipString, vecOfStrings);

        System.out.println(opString);
        //System.out.println(vecOfStrings);
        //System.out.println(ipString);
    }
}
