package com.zzk.www;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//获取行数
public class GetLine {
    //获取记事本内容行数，返回行数的值
    public int getLine(int getLine){
        String a;
        try {
            //获取文件Data.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\zzk\\project\\random-name\\src\\name\\Data.txt"));
            //一行一行获取
            while ((a = reader.readLine())!=null){
                getLine++;
            }
            System.out.println("该文本共有有"+getLine+"行");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getLine;
    }
}
