/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII.npcmethod;

import PeerlessArenaXII.ChrDiathesisVar;
import PeerlessArenaXII.GameMed.ColorOutput;
import static PeerlessArenaXII.GameMed.ColorOutput.Color.RED;
import PeerlessArenaXII.GameMed.GameContent;
import PeerlessArenaXII.GameVar;
import static PeerlessArenaXII.GameVar.x;
import PeerlessArenaXII.MobVar;
import PeerlessArenaXII.gui.GameMS;
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
    MobVar mv = new MobVar();

    //計算經驗並給予
    public void chrexp(int vt) {
        //場數
        if (var.atkcount >= 0) {
            //怪物強度 //
            if (gc.mobnums >= 4) {
                //菁英場
                //一場經驗 * 3
                int total = gc.mobnums * var.atkcount * 3 * vt;
                var.ChrExp += total;
                JOptionPane.showMessageDialog(null, "此次【菁英場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
                //chatLog.setText("此次【菁英場】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗");
                var.atkcount++;
            } else {
                //普通場
                int total = gc.mobnums * 10 * vt;
                var.ChrExp += total;
                JOptionPane.showMessageDialog(null, "此次【普通場】修煉已完成，" + "\n" + var.NpcName[var.choose - 1] + "\n獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            System.out.println("");
        }
    }

    //結算,計算經驗並給予(套)
    public void close(int vt) {
        chrexp(vt);
        checkExp();
        var.money = var.pass ? var.money + (vt * 1) : var.money + 1;
        if (var.isDie == false) {
            JOptionPane.showMessageDialog(null, "\n名稱：" + var.NpcName[var.choose - 1] + "\n經驗：" + var.ChrExp + "\n等級：" + var.ChrLevel, "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        }
    }

    //計算經驗是否升等
    public void checkExp() {
        int[] arr = null;
        for (int i = 0; i < var.exp.length; i++) {
            if (var.ChrExp >= var.exp[i]) {
                arr = new int[var.exp.length - 1];
                var.ChrLevel++;
                var.ChrExp = 0;
                if (x < mv.mobname.length - 1) {
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
                ChrDiathesisVar.diathesis += 3;
            }
        }
    }

}
