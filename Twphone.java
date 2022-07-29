/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joe
 */
public class Twphone {

    //0955-111-111
    public static boolean twphone(String str) {
        if (str.length() != 12) {
            return false;
        }
        for (int i = 0; i <= 3; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        if (str.charAt(4) != '-') {
            return false;
        }
        for (int i = 5; i <= 7; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        if (str.charAt(8) != '-') {
            return false;
        }
        for (int i = 9; i <= 11; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static void parse(String str) {
        boolean isPhone = true;
        for (int i = 0; i < (str.length() - 11); i++) {
            String msg = new String();
            msg = str.substring(i, i + 12);
            if (twphone(msg)) {
                System.out.println("已找到號碼 : " + msg);
                isPhone = false;
            }
        }
        if (isPhone) {
            System.out.println("找不到");
        }
    }

    public static void main(String[] args) {
        String s = "你好 asdawd0955-409-118awdawd";
        String a = "你好 aawdsdasd51qwd";
        String b = "WDR#6519qw1awdawdw0911-555-888d98qw519wqd";
        //parse(s);
        parse(a);
        parse(b);
    }
}
