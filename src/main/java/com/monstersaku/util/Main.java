package com.monstersaku.util;

import java.io.File;  // Import the File class
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //   Scanner myReader = new Scanner(System.in);
        try{
          String filename = "element-type-effectivity-chart.csv";
          File myObj = new File(filename);
          CSVReader reader = new CSVReader(myObj, ";");
          reader.setSkipHeader(true);
          List<String[]> isi = reader.read();
          for(String[] i : isi){
              for(String j : i){
                System.out.println(j);
              }
          }
        }catch(IOException e){
            System.out.println("");
        }

      }
}
