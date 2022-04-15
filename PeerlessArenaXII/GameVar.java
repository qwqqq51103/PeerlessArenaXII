package PeerlessArenaXII;

import javax.swing.JTextField;

/**
 *
 * @author qwqqq
 */
public class GameVar {

    //稱號
    public static String str = ("【 初顧茅廬 】");
    //玩家名稱
    public static String PlayerName;
    //確定玩家名稱
    public static String NameCheck;
    //NPC名稱
    public static String[] NpcName = {"江小魚", "花無缺", "鐵心蘭", "燕南天", "蘇櫻"};
    //NPC好感度
    public static int[] NpcLoves = new int[5];
    //NPC等級
    public static int[] NpcLevel = new int[10];
    //夥伴名稱
    public static String[] partnerName = {"", "", "", "", ""};
    //夥伴選擇的數字
    public static int choose;
    //夥伴新增次數
    public static int partnerCount;
    //夥伴好感度
    public static int[] partnerLoves = new int[5];
    //夥伴聊天次數
    public static int talk = 0;
    //怪物名稱
    public static String[] mobname = {"1.泡沫海馬", "2.咖切龍蝦", "3.竹筒木馬", "4.少林小木憎", "5.夏日蓮蓬頭", "6.霸王阿修羅", "7.真單親媽媽"};
    public static String[] mobnameXnum = {"泡沫海馬", "咖切龍蝦", "竹筒木馬", "少林小木憎", "夏日蓮蓬頭", "霸王阿修羅", "真單親媽媽"};
    public static int[] mobLV = {1,2,3,4,5,6,7};
    public static int[] mobHP = {50,100,150,200,250,500,1250};
    public static int[] mobSTRMIN = {1,5,6,11,17,35,101};
    public static int[] mobSTRMAX = {5,12,15,22,47,66,147};
    public static int[] mobDEF = {3,11,7,30,33,10,177};
    //exp階級
    public static int[] exp = {10, 50, 100, 150, 250, 400, 650, 1050, 1700, 2750};
    //等級稱號
    public static String[] NpcLevelName = {"江湖人", "江湖十奇", "武尊", "武皇", "至尊武皇"};
    //修練場數
    public static int atkcount = 0;
    //角色經驗
    public static int ChrExp = 0; //綁EXP階級
    //角色等級
    public static int ChrLevel;
    //夥伴經驗
    public static int paExp = 0;
    //打王資格
    public static boolean isBoss = false;
    //Boss場數
    public static int bossCount = 0;
    //怪物索引界線
    public static int x = 0;
    //強轉
    public static String z;
    //選擇夥伴只能1次
    public static boolean isOneChoose = true;
}
