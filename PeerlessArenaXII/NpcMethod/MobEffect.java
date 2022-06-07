/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeerlessArenaXII.NpcMethod;

import PeerlessArenaXII.ChrDiathesisVar;
import PeerlessArenaXII.GameVar;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;

/**
 *
 * @author Joe
 */
public class MobEffect {

    ChrDiathesisVar cdv = new ChrDiathesisVar();
    GameVar var = new GameVar();

    public static int num = 0;

    public void mobDebuff() {
        //num = (int) (Math.random() * 2 + 1);
        mobDebuff(num);
    }

    void mobDebuff(int num) {
        String a;
        switch (num) {
            case 0:
                //虛弱
                cdv.STR = cdv.STR / 21;
                a = "此回合不幸獲得 虛弱 狀態";
                printfChatLog(a, 3);
                break;
            case 1:
                //掠奪
                var.money--;
                break;
            case 2:
                //吸血
                break;
            default:
                break;
        }
    }
}
