package com.kea.crossword;

import java.io.*;
import java.util.*;

public class Krydsord {
    private char[][] krydsord;
    //public static final char UNASSIGNED = ' ';
    public static final String ORDFIL = "ordlistMac.txt";
    //private List<String> ord;
    private Set<String> ord;
    private Set<Character> bogstaver;

    public Krydsord() {
        krydsord = new char[3][3];
    }

    public Krydsord(char[][] kryds){
        this.krydsord = kryds;
    }

    public void readOrd(){
        //indlæs alle ord i HashSet
        ord = new HashSet<String>();
        //indlæs alle ord i ArrayList
        //ord = new ArrayList<String>();
        try{
            Scanner input = new Scanner(new File(ORDFIL));
            while (input.hasNext()){
                ord.add(input.next());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //fyld manglende ord ind
        /*ord.add("ale");
        ord.add("abe");
        ord.add("ben");
        ord.add("eje");
        ord.add("lej");
        ord.add("ene");*/
    }

    public boolean checkKrydsord(){
        //check at ord i rækker findes
        for (int i=0;i<3;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<3;j++){
                sb.append(krydsord[i][j]);
            }
            String s = sb.toString();
            if (!ord.contains(s)){
                return false;
            }
        }
        //check at ord i kolonner findes
        for (int j=0;j<3;j++){
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<3;i++){
                sb.append(krydsord[i][j]);
            }
            String s = sb.toString();
            if (!ord.contains(s)){
                return false;
            }
        }
        //check bogstaver unikke
        bogstaver = new HashSet();
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++) {
                bogstaver.add(krydsord[i][j]);
            }
        }
        if (bogstaver.size()<9){
            return false;
        }
        return true;
    }

    public void printKrydsord(){
        //udskriv krydsord
        System.out.println("__");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(krydsord[i][j]);
            }
            System.out.println();
        }
        //System.out.println("___");
    }

    public void printOrd(){
        //udskriv ordbog
        for (String s:ord){
            System.out.println(s);
        }
    }

    public void solve(){
        //counter
        int count = 0;
        //vælg 3 ord
        for (String s0:ord){
            for (String s1:ord){
                for (String s2:ord){
                    //sæt ordene ind i krydsordet
                    for (int j=0;j<3;j++){
                        krydsord[0][j] = s0.charAt(j);
                        krydsord[1][j] = s1.charAt(j);
                        krydsord[2][j] = s2.charAt(j);
                    }
                    //er det en løsning?
                    if (checkKrydsord()){
                        count++;
                        System.out.print(count);
                        printKrydsord();
                    }
                }
            }
        }
    }
}
