package com.lyf.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
    //1.展示页面
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    //2.零钱通明细功能
    String detail = "-----零钱通明细-----";
    //3.完成收益入账（定义新的变量）
    double money = 0;
    double balance = 0;
    Date date = null; //date是java.util.Date类型 表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化
    //4.消费（定义新变量，记录消费的原因）
    String note = "";

    public void zhanshi() {
        do {
            System.out.println("\n=====零钱通菜单=====");
            System.out.println("\t1 零钱明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费");
            System.out.println("\t4 退   出");
            System.out.println("请选择（1-4）:");
            key = scanner.next();
            switch (key) {
                case "1":
                    mingxi();
                    break;
                case "2":
                    ruzhang();
                    break;
                case "3":
                    zhichu();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        } while (loop);


    }



    public void mingxi(){
         System.out.println(detail);
    }
    public void ruzhang(){
        System.out.println("收益入账金额：");
        money=scanner.nextDouble();
        balance+=money;
        date=new Date();//获取当前日期
        //拼接收益入账信息到detail
        detail+="\n收益入账\t"+money+"\t"+sdf.format(date)+"\t余额："+balance;
    }
    public void zhichu(){
        System.out.println("消费金额：");
        money=scanner.nextDouble();
        System.out.println("消费说明");
        note=scanner.next();
        balance-=money;
        date=new Date();//获取当前日期
        //拼接消费信息到detail
        detail+="\n"+note+"\t-"+money+"\t"+sdf.format(date)+"\t余额："+balance;
    }
    public void exit(){
        //定义一个变量接收用户的输入
        String choice="";
        while(true){
            System.out.println("你确定要退出吗？y/n");
            choice=scanner.next();
            if("y".equals(choice)||"n".equals(choice)){
                break;
            }
        }
        if(choice.equals("y")) {
            loop = false;
        }
        return;

    }
}


