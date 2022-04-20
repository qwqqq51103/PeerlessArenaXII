/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeerlessArenaXII.GameMed;

import java.awt.Color;

/**
 *
 * @author Joe
 */
public class ColorOutput {

    public enum Color {
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        PINKISH_RED(35),
        CYAN(36),
        WHITE(37);

        public int code;

        Color(int code) {
            this.code = code;
        }
    }

    public static String output(Color color, String str) {
        return "\033[" + color.code + ";2m" + str + "\033[0m";
    }
}
