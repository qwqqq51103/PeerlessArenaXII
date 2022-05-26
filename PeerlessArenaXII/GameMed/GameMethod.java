/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII.GameMed;

import PeerlessArenaXII.npcmethod.monster;
import PeerlessArenaXII.npcmethod.npc;
import java.util.Scanner;
import PeerlessArenaXII.ArenaPlayer;
import PeerlessArenaXII.GameVar;
import javax.swing.JOptionPane;

/**
 * 1
 *
 * @author Joe
 */
public class GameMethod {

    //方法
    ArenaPlayer ap = new ArenaPlayer();
    GameVar var = new GameVar();
    npc npc = new npc();
    monster monster = new monster();
    GameContent gc = new GameContent();

    //新增夥伴功能 
    public void AddPartner() {
        if (GameVar.partnerCount == GameVar.partnerName.length) {
            JOptionPane.showMessageDialog(null, "你的小夥伴已滿", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        }
        System.out.println("123");
        npc.setNewPartner();
    }

    //選擇夥伴功能
    public void GiveChoose() {
        String m;
        String str = "你要做什麼?\n";
        str += "1.聊天談心\n";
//        str += "2.交換夥伴\n";
//        str += "3.退出\n";
        var.z = (String) JOptionPane.showInputDialog(null, str, null, JOptionPane.PLAIN_MESSAGE, null, new String[]{"1"}, 1);
        if ("1".equalsIgnoreCase(var.z)) {
            npc.givePartner();//method
        } else if ("2".equalsIgnoreCase(var.z)) {
            npc.changePartner();//method
        } else {
            return;
        }
    }

    //怪物功能
    public void AtkMonster() throws InterruptedException {
        monster.monster();
        if (var.z == null) {
            return;
        }
        char x = var.z.charAt(0);
        gc.mobnums = Character.getNumericValue(x);
        //強度檢測
        if (gc.mobnums > var.ChrLevel + 1) {
            JOptionPane.showMessageDialog(null, "請不要越級打怪！！", "絕代江湖", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //boss檢測
        if (gc.mobnums == 7) {
            monster.bossPk();
        } else {
            monster.atkmonster();
        }
    }
}