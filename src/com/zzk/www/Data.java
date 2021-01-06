package com.zzk.www;

import java.io.*;
import java.util.Random;

//获取随机名字
public class Data{
    String theName;
    private int line;

    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }

    public String getTheName() {
        return theName;
    }
    public void setTheName(String theName) {
        this.theName = theName;
    }

    public void randomName(){
        //将记事本行数的值赋予到max中
        int max= this.getLine();
        int lineNum=0;
        String b;
        try {
            //获取文件Data.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\zzk\\project\\random-name\\src\\name\\Data.txt"));
            //取随机数，随机数范围在1~行数之间
            int random = new Random().nextInt (max)+1;
            //一行一行获取
            while ((b = reader.readLine())!=null){
                lineNum++;
                //如果读取到随机行，输出该行
                if (lineNum==random){
                    theName=b;
                    System.out.println(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
