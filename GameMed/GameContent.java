/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArena.GameMed;

import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import PeerlessArena.GameVar;

/**
 *
 * @author qwqqq
 */
public class GameContent {

    //功能選擇
    int gamechoose;
    //遊戲天數
    int gameday = 1;
    //怪物選擇
    public static int mobnums;

    public void game() throws InterruptedException {
        GameVar var = new GameVar();
        Gamemethod gm = new Gamemethod();
        while (gameday <= 100) {
//            System.out.println();
//            System.out.println("遊戲進行到第" + gameday + "天");
//            System.out.println("1.新增夥伴名稱");
//            System.out.println("2.管理夥伴");
//            System.out.println("3.打怪修練");
//            System.out.println("4.同行奇遇");
//            gamechoose = new Scanner(System.in).nextInt();
            String str = "遊戲進行到第" + gameday + "天\n";
            str += "1.新增夥伴名稱\n";
            str += "2.管理夥伴\n";
            str += "3.打怪修練\n";
            str += "4.同行奇遇\n";
            var.z = JOptionPane.showInputDialog(null, str, null, JOptionPane.PLAIN_MESSAGE);
            gamechoose = Integer.parseInt(var.z);
            switch (gamechoose) {
                case 1: //add partner
                    gm.AddPartner();
                    gameday++;
                    break;
                case 2:// give partner item and choose 
                    gm.GiveChoose();
                    gameday++;
                    break;
                case 3://Atk monster
                    gm.AtkMonster();
                    gameday++;
                    break;
                case 4://partrner event 
                    break;
            }
        }
    }

}
