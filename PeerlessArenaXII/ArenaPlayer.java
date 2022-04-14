/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII;

import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;
import PeerlessArenaXII.GameMed.GameContent;
import PeerlessArenaXII.ChrDiathesisVar;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;

/**
 *
 * @author qwqqq
 */
public class ArenaPlayer {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    ChrDiathesisVar cdv = new ChrDiathesisVar();
    String a;
    //名字
    public static boolean i = false;
    //素質
    public static boolean z = true;

    //設定名字 
    public void setName() {
        if (i == false) {
            do {
                String[] s = {"初夏薄荷", "初夏", "薄荷"};
                var.PlayerName = (String) JOptionPane.showInputDialog(null, "請選擇你的大名", "絕代江湖", JOptionPane.PLAIN_MESSAGE, null, s, 1);
//            System.out.print("請輸入您的大名 : ");
//            var.PlayerName = new Scanner(System.in).next();
//            System.out.println("");
                String Name = var.str + "\n等級 : " + var.NpcLevel[0] + "\n稱號 : " + var.NpcLevelName[0] + "\n姓名 : " + var.PlayerName;
//            JOptionPane.showMessageDialog(null, Name, "絕代江湖", JOptionPane.PLAIN_MESSAGE);
//            System.out.println(var.str + "\n等級 : " + var.NpcLevel[0] + "\n稱號 : " + var.NpcLevelName[0] + "\n姓名 : " + var.PlayerName);
//            System.out.println("");
                var.NameCheck = JOptionPane.showInputDialog(null, "確定這組名字(Y/N)?\n\n" + Name, "絕代江湖", JOptionPane.PLAIN_MESSAGE);
//            var.NameCheck = new Scanner(System.in).next();
            } while (!"y".equalsIgnoreCase(var.NameCheck) && !"是".equalsIgnoreCase(var.NameCheck) && !"1".equalsIgnoreCase(var.NameCheck));
//        System.out.println("");
            JOptionPane.showMessageDialog(null, "歡迎 : " + var.PlayerName + " 大俠 - 來到絕代江湖世界。", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            //取名結束
            i = true;
        }
    }

    //NPC素質+到玩家身上
    public void diathesis(int z) {
        int num = (int) (Math.random() * 11 - 1);
        switch (z) {
            //江
            case 0:
                cdv.STR += num * 2;
                cdv.AGI += num;
                System.out.println("0");
                break;
            case 1:
                //花
                cdv.INT += num * 2;
                cdv.LUK += num;
                System.out.println("1");
                break;
            case 2:
                //鐵
                cdv.AGI += num * 2;
                cdv.STR += num;
                System.out.println("2");
                break;
            case 3:
                //燕
                cdv.STR += num;
                cdv.AGI += num;
                cdv.INT += num;
                cdv.LUK += num;
                System.out.println("3");
                break;
            case 4:
                //蘇
                cdv.STR += num;
                cdv.AGI += num;
                cdv.INT += num * 2;
                cdv.LUK += num * 2;
                System.out.println("4");
                break;
            default:
                System.out.println("6666");
                break;
        }
    }

    //消耗能力值
    public void addDiathesis(int diath) {
        if (diath > 0) {
            cdv.diathesis--;
        } else {
            z = false;
            a = "沒有足夠的能力點";
            printfChatLog(a);
        }
    }
}
