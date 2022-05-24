/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII.npcmethod;

import PeerlessArenaXII.ArenaPlayer;
import PeerlessArenaXII.GameMed.GameContent;
import PeerlessArenaXII.GameVar;
import static PeerlessArenaXII.GameVar.x;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;
import PeerlessArenaXII.ChrDiathesisVar;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;

/**
 *
 * @author Joe
 */
public class monster {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    exp exp = new exp();
    ArenaPlayer ap = new ArenaPlayer();
    ChrDiathesisVar cdv = new ChrDiathesisVar();
    String a;

    //(選擇怪物)
    public void monster() {
//        for (int i = 0; i < x + 1; i++) {
//            //修復"X"超出怪物索引界線
//            System.out.println((i + 1) + "." + var.mobname[i]);
//        }
        var.z = (String) JOptionPane.showInputDialog(null, "", "絕代江湖", JOptionPane.PLAIN_MESSAGE, null, var.mobname, 1);
        if (var.z == null) {
            return;
        }
        char x = var.z.charAt(0);
//        System.out.println("");
        JOptionPane.showMessageDialog(null, "目前帶著\t" + var.NpcName[var.choose - 1] + " 夥伴", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
//        System.out.println("目前帶著\t" + var.NpcName[var.choose - 1] + " 夥伴");
    }

    //打怪
    public void atkmonster() {
        //修練三次
//        int count = 3;
        //回合
        int ron = 10;
//        System.out.println("您目前選擇的是 " + var.mobname[gc.mobnums - 1] + " 怪物");
        JOptionPane.showMessageDialog(null, "您目前選擇的是 " + var.mobname[gc.mobnums - 1] + " 怪物", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        for (int i = 1; i <= ron; i++) {
            if (var.die == false) {
//                var.die = false;
                break;
            } else if (cdv.HPMIN > 0) {//傷害計算
                ap.RonDamge(var.mobLV[gc.mobnums - 1], var.mobHP[gc.mobnums - 1], var.mobSTRMAX[gc.mobnums - 1], var.mobSTRMIN[gc.mobnums - 1], var.mobDEF[gc.mobnums - 1]);
                a = "回合 " + i + " / " + ron + " :\t" + "受到傷害 : " + ap.damge + "\t剩餘HP : " + cdv.HPMIN;
                printfChatLog(a, 3);
                a = "------------------------------------------------------------------------------------------------------------";
                printfChatLog(a, 3);
            }
            if (var.pass == false) {
                var.atkcount += ron;
                //結算
                exp.close();
            }
        }
        if (var.pass == true) {
            var.atkcount += ron;
            //結算
            exp.close();
        }
//        for (int i = 0; i < count; i++) {
//            //用法 修練 停止三秒
//            Thread.sleep(1 * 3);
//        }
        //System.out.println("此次修煉已完成獲得.....");
    }
    //cheak is boss

    public void bossPk() {
        if (gc.mobnums == 7 && var.isBoss) {
            int total = 7 * var.atkcount * 3 * var.bossCount;
            var.ChrExp += total;
            if (var.bossCount == 1) {
//                System.out.println("此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
//                System.out.println("因第一次BOSS修練故無BOSS加倍！");
                JOptionPane.showMessageDialog(null, "此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗\n因第一次BOSS修練故無BOSS加倍！", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            } else if (var.bossCount != 1) {
//                System.out.println("此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
                JOptionPane.showMessageDialog(null, "此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            }
            var.bossCount++;
        }
//        System.out.println("你沒有資格挑戰最終BOSS，請完成同行任務！！");
        JOptionPane.showMessageDialog(null, "你沒有資格挑戰最終BOSS，請完成同行任務！！", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
    }
}
