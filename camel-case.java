import java.io.*;
import java.util.*;

public class Solution {
    public static String Capitalize(String s)
    {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public static String camelCase(String str){
        String[] textConvert = str.split(";");
        
        switch (textConvert[0]) //operation
        {
           case "S":
                if (textConvert[1].equals("M")) //for method remove ()
                {
                    textConvert[2] = textConvert[2].replace("()", "");
                }

                String[] listText = textConvert[2].split("(?<!^)(?=[A-Z])");
                textConvert[2] = "";
                
                for (int i = 0; i < listText.length; i++)
                {
                    textConvert[2] += listText[i].toLowerCase() + " ";
                }
                
                textConvert[2].trim();
                break;

           case "C":
                String[] splitText = textConvert[2].split(" ");

                textConvert[2] = textConvert[1].equals("C") ? Capitalize(splitText[0]) : splitText[0].toLowerCase();
                for (int i = 1; i < splitText.length; i++)
                {
                    textConvert[2] += Capitalize(splitText[i]);
                }
                textConvert[2].trim();
                if (textConvert[1].equals("M"))
                {
                        textConvert[2] += "()";
                }
                break;

           default:
               break;
       }

       return textConvert[2];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        while(sc.hasNextLine()){
            arr.add(sc.nextLine());
        }
        
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(camelCase(arr.get(i)));
        }
        
        sc.close();
    }
}
