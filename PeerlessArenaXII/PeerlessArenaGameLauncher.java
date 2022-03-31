/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII;

/**
 *
 * @author qwqqq
 */
import PeerlessArenaXII.npcmethod.npc;
import java.util.Scanner;
import javax.swing.JOptionPane;
import PeerlessArenaXII.GameMed.GameContent;
import com.sun.javafx.iio.ImageFrame;
import javafx.scene.control.PopupControl;
import javafx.scene.input.KeyCode;
import javax.swing.ImageIcon;

public class PeerlessArenaGameLauncher {
 
    public static void main(String[] args) throws InterruptedException {
        ArenaPlayer t = new ArenaPlayer();
        GameContent g = new GameContent();
        GameVar gv = new GameVar();
        JOptionPane.showMessageDialog(null, "歡迎來到絕代江湖", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        npc npc = new npc();
        //設定名字
        t.setName();
        //選擇夥伴  
        npc.setChoosePartner();
        //設定好感動NPC
        npc.setLoves();
        g.game();
//        test();
        
    }
}
