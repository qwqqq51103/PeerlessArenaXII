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
import PeerlessArenaXII.MobVar;
import PeerlessArenaXII.NpcMethod.MobEffect;
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
    MobEffect mef = new MobEffect();
    MobVar mv = new MobVar();
    String a;
    public static int vt = 0;

    //(選擇怪物)
    public void monster() {
        var.z = (String) JOptionPane.showInputDialog(null, "", "絕代江湖", JOptionPane.PLAIN_MESSAGE, null, mv.mobname, 1);
        if (var.z == null) {
            return;
        }
        char x = var.z.charAt(0);
        JOptionPane.showMessageDialog(null, "目前帶著\t" + var.NpcName[var.choose - 1] + " 夥伴", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
    }

    //打怪
    public void atkmonster() {
        //回合
        int ron = 10;
        JOptionPane.showMessageDialog(null, "您目前選擇的是 " + mv.mobname[gc.mobnums - 1] + " 怪物", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
        vt = 0;
        String b;
        for (int i = 1; i <= ron; i++) {
            if (var.isDie == true) {
                break;
            } else if (mv.mobHPMIN[gc.mobnums - 1] <= 0) {
                ap.mobDie();
                break;
            } else if (cdv.HPMIN > 0) {//傷害計算
                b = "玩家目前血量 : " + cdv.HPMIN + "\t\t怪物目前血量 : " + mv.mobHPMIN[gc.mobnums - 1];
                printfChatLog(b, 3);
                ap.RonDamge(mv.mobLV[gc.mobnums - 1], mv.mobHP[gc.mobnums - 1], mv.mobSTRMAX[gc.mobnums - 1], mv.mobSTRMIN[gc.mobnums - 1], mv.mobDEF[gc.mobnums - 1]);
                mef.mobDebuff();
                ap.playRonDange(var.ChrLevel, cdv.STRMIN, cdv.STRMAX, cdv.HPMIN, 0, 0, mv.mobHPMIN[gc.mobnums - 1], mv.mobDEF[gc.mobnums - 1]);
                if (var.isDie == false) {
                    a
                            = "回合 : "
                            + i
                            + " / "
                            + ron
                            + "\n攻擊 : "
                            + cdv.STRMIN + " = " + cdv.STRMAX
                            + "\n怪物傷害 : "
                            + ap.damge + "\t\t\t"
                            + "玩家傷害 : "
                            + ap.Pdamge
                            + "\n受到傷害 : "
                            + (cdv.def - ap.damge) + "\t\t\t"
                            + "怪物受傷害 : "
                            + ap.mobtmp
                            + "\n剩餘HP : "
                            + cdv.HPMIN + "\t\t\t"
                            + "怪物剩餘HP : "
                            + mv.mobHPMIN[gc.mobnums - 1];
                    vt++;
                    printfChatLog(a, 3);
                }
                a = "---------------------------------------------------------------------------------------------------------------------------------";
                printfChatLog(a, 3);
            }
            if (var.pass == false && var.isDie == false) {
                var.atkcount += ron;
                //結算
                exp.close(1);
            }
        }
        //回合例外
        if (vt == ron && mv.mobHPMIN[gc.mobnums - 1] <= 0) {
            a = "取得勝利";
            printfChatLog(a, 3);
        }
        //回合打平
        if (vt == ron && cdv.HPMIN > 0 && mv.mobHPMIN[gc.mobnums - 1] > 0) {
            a = "［玩家］:" + var.PlayerName + " 和［ " + mv.mobname[gc.mobnums - 1] + " ］纏鬥了十天十夜難分高下，達成和平協議來日在戰！";
            printfChatLog(a, 3);
            mv.mobHPMIN[gc.mobnums - 1] = mv.mobHP[gc.mobnums - 1];
        }
        if (var.pass == true) {
            var.atkcount += ron;
            //結算
            exp.close(vt);
        }
    }

    //cheak is boss
    public void bossPk() {
        if (gc.mobnums == 7 && var.isBoss) {
            int total = 7 * var.atkcount * 3 * var.bossCount;
            var.ChrExp += total;
            if (var.bossCount == 1) {
                JOptionPane.showMessageDialog(null, "此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗\n因第一次BOSS修練故無BOSS加倍！", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            } else if (var.bossCount != 1) {
                JOptionPane.showMessageDialog(null, "此次【BOSS】修煉已完成，" + var.NpcName[var.choose - 1] + "獲得" + total + "經驗", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
            }
            var.bossCount++;
        }
        JOptionPane.showMessageDialog(null, "你沒有資格挑戰最終BOSS，請完成同行任務！！", "絕代江湖", JOptionPane.PLAIN_MESSAGE);
    }
}
