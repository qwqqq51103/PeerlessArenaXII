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
import PeerlessArenaXII.GameMed.ColorOutput;
import PeerlessArenaXII.NpcMethod.MobEffect;
import PeerlessArenaXII.npcmethod.monster;
import PeerlessArenaXII.MobVar;
import PeerlessArenaXII.npcmethod.monster;

/**
 *
 * @author qwqqq
 */
public class ArenaPlayer {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    ChrDiathesisVar cdv = new ChrDiathesisVar();
    ColorOutput cp = new ColorOutput();
    MobEffect mef = new MobEffect();
    MobVar mv = new MobVar();
    String a;
    String b;

    //名字
    public static boolean i = false;
    //素質
    public boolean z = true;
    //NPC+素質
    public boolean x = true;
    //怪物傷害
    public int damge;
    //玩家傷害
    public int Pdamge;

    //設定名字 
    public void setName() {
        if (i == false) {
            //do {
            String[] s = {"初夏薄荷", "初夏", "薄荷"};
            var.PlayerName = (String) JOptionPane.showInputDialog(null, "請選擇你的大名", "絕代江湖", JOptionPane.PLAIN_MESSAGE, null, s, 1);
            String Name = var.str + "\n等級 : " + var.NpcLevel[0] + "\n稱號 : " + var.NpcLevelName[0] + "\n姓名 : " + var.PlayerName;
            JOptionPane.showMessageDialog(null, "歡迎 : " + var.PlayerName + " 大俠 - 來到絕代江湖世界。", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            //取名結束
            i = true;
        }
    }

    //公式
    public void ex() {
        cdv.HPMAX = (STR * 2) + (INT * 1 + 2) + AGI;
        cdv.STRMAX = (cdv.STR + cdv.AGI);
        cdv.STRMIN = (STR + AGI) / 7;
        cdv.DEF = (float) ((AGI * 1.1f) + (LUK * 0.7f));
        int idef = (int) (cdv.DEF + 0.5f);
        cdv.def = idef;
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
    public void addDiathesis(int diath, int str, int agi, int in, int luk, boolean op) {
        a = "沒有足夠的能力點";
        b = "死亡時不可消耗能力點";
        if (op == true) {
            if (diath > 0 && z == true && var.isDie == false) {
                cdv.diathesis = cdv.diathesis - cdv.daitTotal;
                cdv.STR = cdv.STR + str;
                cdv.AGI = cdv.AGI + agi;
                cdv.INT = cdv.INT + in;
                cdv.LUK = cdv.LUK + luk;
                setDiathesis(diath);
            } else if (var.isDie == false) {
                printfChatLog(a, 1);
            } else {
                printfChatLog(b, 1);
            }
        } else {
            System.out.println("test");
        }
    }

    //預示能力值
    public void addDiathesis() {

    }

    //計算固定能力值(overload)
    public void setDiathesis(int cdvdiathesis) {
        if (cdv.diathesis >= 0 && cdv.HPMIN == cdv.HPMAX) {
            ex();
            cdv.HPMIN = cdv.HPMAX;
        } else {
            ex();
            cdv.HPMIN = cdv.HPMIN;
        }
    }

    //(overload)NPC+素質
    public void setDiathesis() {
        if (x == true) {
            ex();
            cdv.HPMIN = cdv.HPMAX;
        }
    }

    //怪物隨機範圍值浮動傷害(MOB)
    public void RonDamge(int lv, int hp, int strMax, int strMin, int def) {
        //計算固定能力值
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
        //printfChatLog(a + " ----- " + b, 1);
        playDamge(damge, cdv.def, cdv.HPMIN);
    }

    //玩家受傷害
    public int tmp;

    public void playDamge(int da, int def, int hp) {
        tmp = (def - da);
        if (tmp > 0) {
            cdv.HPMIN = hp;

        } else if (tmp < 0) {
            cdv.HPMIN += (tmp);
        }
        if (cdv.HPMIN <= 0) {
            a
                    = "\n\t\t你已死亡"
                    + "\n\t\t最後受傷害 : "
                    + tmp
                    + "\n\t\t剩餘HP : "
                    + cdv.HPMIN;
            printfChatLog(a, 3);
            var.isDie = true;
            mv.mobHPMIN[gc.mobnums - 1] = mv.mobHP[gc.mobnums - 1];
            return;
        }
    }

    public void playDie() {

    }

    //玩家打怪物傷害(Chr)
    public void playRonDange(int chrLv, int chrStrMin, int chrStrMax, int chrHp, int chrBuff, int chrDebuff, int mobHPMIN, int mobDef) {
        int chrStrNum = chrStrMax - chrStrMin;
        int[] eq = new int[chrStrNum + 1];
        for (int i = 0; i <= chrStrNum; i++) {
            //外層做ep陣列的index
            for (int j = chrStrMin; j <= chrStrMax; j++) {
                eq[i] = j;
            }
            chrStrMax--;
        }
        int num = (int) (Math.random() * chrStrNum);
        Pdamge = eq[num];
//        mef.mobDebuff();
        mobDange(Pdamge, mobHPMIN, mobDef);
    }

    //mob受傷害
    public int mobtmp;

    //mob受傷
    public void mobDange(int chrStr, int mobHPMIN, int mobDef) {
        mobtmp = (mobDef - chrStr);
        if (mobtmp > 0) {
            mv.mobHPMIN[gc.mobnums - 1] = mobHPMIN;
        } else if (mobtmp < 0) {
            mv.mobHPMIN[gc.mobnums - 1] += (mobtmp);
        }
    }

    public void mobDie() {
        mv.mobHPMIN[gc.mobnums - 1] = mv.mobHP[gc.mobnums - 1];
        a = "取得勝利";
        printfChatLog(a, 3);
    }
}
