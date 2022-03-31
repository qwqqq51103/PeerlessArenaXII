/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArena.npcmethod;

import PeerlessArena.GameMed.GameContent;
import PeerlessArena.GameVar;
import static PeerlessArena.GameVar.x;
import PeerlessArena.gui.GameMS;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Joe
 */
public class exp {

    GameVar var = new GameVar();
    GameContent gc = new GameContent();
    //計算經驗並給予
    public void chrexp() {
        //場數
        if (var.atkcount >= 0) {
            //怪物強度 //
            if (gc.mobnums >= 4) {
                //菁英場
                //一場經驗 * 3
                int total = gc.mobnums * var.atkcount * 3;
                var.ChrExp += total;
//                System.out.println("此次【菁英場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
                JOptionPane.showMessageDialog(null, "此次【菁英場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
                //chatLog.setText("此次【菁英場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
                var.atkcount++;
            } else {
                //普通場
                int total = gc.mobnums * 10;
                var.ChrExp += total;
//                System.out.println("此次【普通場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
                JOptionPane.showMessageDialog(null, "此次【普通場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            System.out.println("");
        }
    }

    //結算,計算經驗並給予(套)
    public void close() {
        chrexp();
        checkExp();
//        System.out.println("\n名稱：" + var.NpcName[var.choose - 1] + "\n經驗：" + var.ChrExp + "\n等級：" + var.ChrLevel);
        JOptionPane.showMessageDialog(null, "\n名稱：" + var.NpcName[var.choose - 1] + "\n經驗：" + var.ChrExp + "\n等級：" + var.ChrLevel, "絕代江湖", JOptionPane.PLAIN_MESSAGE);
    }

    //計算經驗是否升等
    public void checkExp() {
        int[] arr = null;
        for (int i = 0; i < var.exp.length; i++) {
            if (var.ChrExp >= var.exp[i]) {
                arr = new int[var.exp.length - 1];
                var.ChrLevel++;
                if (x < var.mobname.length - 1) {
                    x++;
                }
                for (int index = 0; index < i; index++) {
                    arr[index] = var.exp[index];
                }
                for (int j = i; j < var.exp.length - 1; j++) {
                    arr[j] = var.exp[j + 1];
                    //往前覆值
                }
                var.exp = arr;
            }
        }
    }

}
