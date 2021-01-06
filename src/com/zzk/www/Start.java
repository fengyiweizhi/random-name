package com.zzk.www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start {
    public static void main(String[] args) {
       new MyFrame();
    }
}
class MyFrame extends JFrame implements ActionListener {
    //判断是否开始
    boolean  isStart=false;
    String name="别紧张";;
    String buttonLabel1="Start";
    String buttonLabel2="Stop";
    int width=600;
    int height=500;

    GetLine getLine = new GetLine();
    Data data = new Data();

    //定时器
    Timer timer=new Timer(120,this);
    //构造器，初始化
    public MyFrame(){
        setVisible(true);
        //设置布局为空
        setBounds(200,200,width,height);
        setLayout(null);
        setTitle("随机点名器");
        Button button1 = new Button();
        button1.setLabel(buttonLabel1);
        //按钮配置
        button1.setBounds(100,350,120,50);
        Button button2 = new Button(buttonLabel2);
        //按钮配置
        button2.setBounds(340,350,120,50);
        add(button1);
        add(button2);
        //设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗口大小不可调节
        setResizable(false);
        //按钮的事件监听
        button1.addActionListener(this::actionPerformed);
        button2.addActionListener(this::actionPerformed);
        //获取行数并赋值
        int line=getLine.getLine(0);
        //将行数值传递
        data.setLine(line);
    }
    //增加背景图片
    final ImageIcon bgImageIcon = new ImageIcon(MyFrame.class.getResource("/resources/bg.png"));
    final Image image = bgImageIcon.getImage();
    //利用画板，画上文字内容
    @Override
    public void paint(Graphics g) {
        //画上背景图片，并且自适应窗口大小
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        //设置画笔颜色
        g.setColor(Color.pink);
        //字体设置
        g.setFont(new Font("微软雅黑",Font.CENTER_BASELINE,60) );
        g.drawString(name,width/3+10,200);
    }
    //判断点击的按钮信息
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand()==buttonLabel1){
            isStart=true;
        }else if (e.getActionCommand()==buttonLabel2){
            isStart=false;
        }
        randomStart();
    }
    //名字页面的刷新，利用repaint，使名字闪动。
    public void randomStart(){
        if (isStart==true){
            data.randomName();
            //获取Data类中的随机名字
            name=data.getTheName();
            //刷新页面
            repaint();
        }
        timer.start();
    }

}
