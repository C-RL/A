import java.util.*;
import java.io.*;
import java.math.*;

/**
 *The Problem:

Write a program to input the condensed formula of an alicylic hydrocarbon, and decide whether it is valid or not.
Condensed Formula: The condensed formula includes units of carbon linked to one another by one or more bonds.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        String result = "fail";
        List<Integer> bonds = new ArrayList<Integer>();
        List<Integer> desired_result = new ArrayList<Integer>();
        
        for (int j = 0; j < N; j++) {
            String C = in.nextLine();
           String temp = C;
   
           if(C.startsWith("C")){
                
                int t = 0;
                int carbons = temp.length() - temp.replace("C", "").length();
                //System.out.println(carbons);
                
                for (int i = 0; i < carbons; i++){
                    if (bonds.size() <= i){ bonds.add(i,0);}
                    desired_result.add(i, 4);
                    int b = bonds.get(i);
                    
                    //if ( t> 0 && i > 0){b = b + 1;}
                    
                    int index = C.indexOf('C', t);
                    if (C.charAt(index + 1) == 'H') {
                        int nofH = C.charAt(index +  2) - '0';
                        //System.out.println(index + " H: " + nofH);
                        b = b + nofH;
                        t = t + 2;
                    }
                    
                    if (C.length() - 1 > (index + 3)) {
                    if (C.charAt(index + 3) == '(') {
                        bonds.add(i + 1, 0);
                        
                        int nofB = C.charAt(index + 4) - '0';
                        b = b + nofB;
                        bonds.set(i + 1, bonds.get(i + 1) + nofB);
                        t = t + 3;
                    }}
                    
                    bonds.set(i, b);
                    //System.out.println(i + " " + bonds.get(i));
                }
            }
                
        }
        
        boolean r = bonds.equals(desired_result);
        if (r) {result = "VALID";} else { result = "INVALID";}
        
        
        
        

        System.out.println(result);
    }
}