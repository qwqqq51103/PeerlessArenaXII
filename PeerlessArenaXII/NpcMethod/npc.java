/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII.npcmethod;

import PeerlessArenaXII.GameMed.GameContent;
import PeerlessArenaXII.GameVar;
import PeerlessArenaXII.gui.GameMS;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;
import PeerlessArenaXII.ArenaPlayer;
import PeerlessArenaXII.ChrDiathesisVar;
import static PeerlessArenaXII.GameVar.choose;
import javafx.scene.paint.Color;

/**
 *
 * @author Joe
 */
public class npc {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    ArenaPlayer ap = new ArenaPlayer();

    //設定NPC的好感度
    public void setLoves() {

        for (int i = 0; i < var.NpcLoves.length; i++) {
            var.NpcLoves[i] = 100;
        }

        switch (var.choose - 1) {
            default:
                for (int i = 0; i < var.NpcName.length; i++) {
                    var.NpcLoves[i] -= 20;
                }
                var.NpcLoves[var.choose - 1] = 100;
                break;
            case 5:
                for (int i = 0; i < var.NpcName.length; i++) {
                    var.NpcLoves[i] -= 20;
                }
                var.NpcLoves[4] = 100;
                break;
        }
        String value = "所有NPC的好感度列表 \n";
    }

    //選擇你的夥伴
    public void setChoosePartner() {
        String s1 = ("請 " + var.PlayerName + " 大俠選擇一位江湖人，進行結伴同行! (選擇結伴同行好感度會浮動)");
        String str = "1.江小魚\n";
        str += "2.花無缺\n";
        str += "3.鐵心蘭\n";
        str += "4.燕南天\n";
        str += "5.蘇櫻";
        do {
            //強轉
            var.z = (String) JOptionPane.showInputDialog(null, s1, "絕代江湖", JOptionPane.PLAIN_MESSAGE, null, var.NpcName, 1);
            char x = var.z.charAt(0);
            var.choose = Character.getNumericValue(x);
        } while (var.choose > 5 || var.choose < 1);
        String s3 = ("恭喜大俠選擇成功以後  " + var.NpcName[var.choose - 1] + "  就是你的江湖好夥伴");
        JOptionPane.showMessageDialog(null, s3, "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        int oneChoose = choose - 1;
        ap.diathesis(oneChoose);
        var.isOneChoose = false;
    }

    //新增夥伴
    public void setNewPartner() {
        System.out.print("請輸入自製小夥伴名稱 : ");
        String NewName = new Scanner(System.in).next();
        //需要變更 好感度數組 名字數組
        var.partnerName[var.partnerCount] = NewName;
        var.partnerLoves[var.partnerCount] = 80;
        var.partnerCount++;
        //新增小夥伴 選擇 的夥伴-10好感
        if (var.partnerCount > 0) {
            var.NpcLoves[var.choose - 1] -= 10;
        }
        //未寫好 -頭腦爆炸了

//        //新增夥伴的其他人-10 用於第2位新增夥伴
//        if (var.partnerCount > 1) { 
//            for (int i = 0; i < 1; i++) {
//                var.partnerLoves[var.partnerCount - 2] -= 10;
//            }
//        }
        System.out.println("");
        for (int i = 0; i < 1; i++) {
            System.out.println(var.NpcName[var.choose - 1] + "\t" + var.NpcLevelName[var.NpcLevel[i]] + "\t" + var.NpcLoves[i]);
        }
        for (int i = 0; i < var.partnerCount; i++) {
            System.out.println(var.partnerName[i] + "\t" + var.NpcLevelName[var.NpcLevel[i]] + "\t" + var.partnerLoves[i]);
        }
    }

    //送禮聊天夥伴
    public void givePartner() {
        String str;
        int yn;
        int[] nums = new int[1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 11 - 1);
        }
        //找夥伴
        for (int i = var.choose - 1; i < var.choose; i++) {
            str = (i - var.choose + 2) + "." + var.NpcName[var.choose - 1];
        }
        //找新增夥伴
        for (int i = 0; i < var.partnerCount; i++) {
            //str = (i + 2) + "." + var.partnerName[i];
            //printfChatLog(str);
            //System.out.println((i + 2) + "." + var.partnerName[i]);
        }
        switch (1) {
            case 1:
                //預設的npc夥伴
                if (var.talk <= 10) {
                    String[] talk = {"你好", "你又來了", "怎麼又是你!", "聽說我家鄉有寶藏圖!", "一起去釣魚吧!"};
                    int num = (int) (Math.random() * talk.length);
                    str = ("對話次數 : " + (var.talk + 1) + "\t\n" + var.NpcNameXnum[var.choose - 1] + "  :   " + talk[num]);
                    printfChatLog(str, 4);
                } else if (var.talk > 11 && var.talk < 25) {
                    String[] talk2 = {"聽說帶著我去同行有好處哦!", "又見面了遇到妳真好!"};
                    int num2 = (int) (Math.random() * talk2.length);
                    str = ("對話次數 : " + (var.talk + 1) + "\t\n" + var.NpcNameXnum[var.choose - 1] + "  :  " + talk2[num2]);
                    printfChatLog(str, 4);

                } else if (var.talk == nums[0]) {
                    str = "對話次數 : " + (var.talk + 1) + "\n一直找我聊天好感度大爆";
                    printfChatLog(str, 4);
                    var.NpcLoves[var.choose - 1] += 90;
                } else {
                    str = "對話次數 : " + (var.talk + 1) + "\n普通";
                    printfChatLog(str, 4);
                }
                var.talk++;
                var.NpcLoves[var.choose - 1] += 10;
                break;
            default:
                //新增的夥伴
                //夥伴暫無奇遇
                String[] talk3 = {"讓我靜靜", "你先下車，我去找魏子婷", "可以幫我..."};
                int num3 = (int) (Math.random() * talk3.length);
                System.out.println();
                System.out.println(talk3[num3]);
                var.partnerLoves[var.partnerCount - 1] += 10;
                System.out.println("夥伴名稱 : " + var.partnerName[var.partnerCount - 1] + "\t" + var.partnerLoves[var.partnerCount - 1]);
                break;
        }
    }

    //交換夥伴
    public void changePartner() {
        System.out.println("暫不啟用");
    }
}
