/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeerlessArenaXII.NpcMethod;

import PeerlessArenaXII.ChrDiathesisVar;
import PeerlessArenaXII.GameVar;
import static PeerlessArenaXII.gui.GameMS.printfChatLog;
import static java.lang.System.exit;

/**
 *
 * @author Joe
 */
public class MobEffect {

    ChrDiathesisVar cdv = new ChrDiathesisVar();
    GameVar var = new GameVar();

    public static int num;
    boolean dos = true;
    private int max;
    private int min;

    public void mobDebuff() {
        if(var.isDie == true) {
            return;
        }
        if (dos) {
            max = cdv.STRMAX;
            min = cdv.STRMIN;
        } else if (!dos) {
            Reload(max, min);
        }
        num = (int) (Math.random() * 2 + 1);
        mobDebuff(num);
        dos = false;
    }

    void mobDebuff(int num) {
        String a;
        switch (num) {
            case 1:
                //虛弱
                if (cdv.STRMIN == 1) {
                    cdv.STRMIN = 1;
                } else {
                    cdv.STRMIN = cdv.STRMIN / 2;
                }
                cdv.STRMAX = cdv.STRMAX / 2;
                a = "此回合不幸獲得 虛弱 狀態";
                printfChatLog(a, 3);
                break;
            case 2:
                //掠奪
                var.money--;
                a = "此回合不幸獲得 掠奪 狀態 金幣-1";
                printfChatLog(a, 3);
                break;
            case 3:
                //吸血
                a = "此回合不幸獲得 吸血 狀態";
                printfChatLog(a, 3);
                break;
            default:
                break;
        }
    }

    private void Reload(int strmax, int strmin) {
        cdv.STRMAX = strmax;
        cdv.STRMIN = strmin;
    }
}
