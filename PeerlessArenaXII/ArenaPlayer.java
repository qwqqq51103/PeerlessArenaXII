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
import static PeerlessArenaXII.ChrDiathesisVar.AGI;
import static PeerlessArenaXII.ChrDiathesisVar.INT;
import static PeerlessArenaXII.ChrDiathesisVar.LUK;
import static PeerlessArenaXII.ChrDiathesisVar.STR;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;
import PeerlessArenaXII.gui.GameMS;

/**
 *
 * @author qwqqq
 */
public class ArenaPlayer {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    ChrDiathesisVar cdv = new ChrDiathesisVar();
    String a;
    String b;
    //名字
    public static boolean i = false;
    //素質
    public boolean z = true;
    //NPC+素質
    public boolean x = true;

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
        setDiathesis();
        x = false;
    }

    //消耗能力值 &&  = and    || = or
    public void addDiathesis(int diath, int str, int agi, int in, int luk) {
        if (diath > 0 && z == true) {
            cdv.diathesis--;
            cdv.STR = cdv.STR + str;
            cdv.AGI = cdv.AGI + agi;
            cdv.INT = cdv.INT + in;
            cdv.LUK = cdv.LUK + luk;
            setDiathesis(diath);
        } else {
            a = "沒有足夠的能力點";
            printfChatLog(a);
        }
    }

    //計算固定能力值(overload)
    public void setDiathesis(int cdvdiathesis) {
        if (cdv.diathesis >= 0 && cdv.HPMIN == cdv.HPMAX) {
            cdv.HPMAX = (STR * 2) + (INT * 1 + 2) + AGI;
            cdv.HPMIN = cdv.HPMAX;
            //cdv.DEF = (AGI * 2 + 2 + LUK * 2) + 1 + INT;
        }
        cdv.HPMAX = (STR * 2) + (INT * 1 + 2) + AGI;
        cdv.HPMIN = cdv.HPMIN;
    }

    //(overload)NPC+素質
    public void setDiathesis() {
        if (x == true) {
            cdv.HPMAX = (STR * 2) + (INT * 1 + 2) + AGI;
            cdv.HPMIN = cdv.HPMAX;
            //cdv.DEF = (AGI * 2 + 2 + LUK * 2) + 1 + INT;
        }
    }

    //怪物隨機範圍值浮動傷害
    public void RonDamg(int lv, int hp, int strMax, int strMin, int def) {
        //怪物最後傷害
        int damge = 0;
        //計算固定能力值
        //setDiathesis();
        int toStr = strMax - strMin;
        int[] eq = new int[toStr + 1];
        for (int i = 0; i <= toStr; i++) {
            //外層做ep陣列的index
            for (int j = strMin; j <= strMax; j++) {
                //內層做怪物傷害的浮動值
                eq[i] = j;
                a = "num" + eq[i] + "d = " + j;
            }
            strMax--;
        }
        int num = (int) (Math.random() * toStr);
        damge = eq[num];
        b = "damge : " + damge;
        printfChatLog(a + " ----- " + b);
        playDamge(damge, cdv.DEF, cdv.HPMIN);
    }

    //玩家受傷害
    public void playDamge(int da, int def, int hp) {
        int tmp = (def - da);
        if (tmp > 0) {
            cdv.HPMIN = hp;
        }
        cdv.HPMIN += (tmp);
    }
}
