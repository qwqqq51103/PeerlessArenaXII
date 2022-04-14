/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerlessArenaXII.gui;

import PeerlessArenaXII.ArenaPlayer;
import PeerlessArenaXII.GameVar;
import PeerlessArenaXII.npcmethod.monster;
import java.awt.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import PeerlessArenaXII.npcmethod.npc;
import java.util.logging.Logger;
import PeerlessArenaXII.GameMed.Gamemethod;
import PeerlessArenaXII.ChrDiathesisVar;

/**
 *
 * @author Joe
 */
public class GameMS extends javax.swing.JFrame {

    npc npc = new npc();
    ArenaPlayer ap = new ArenaPlayer();
    monster mob = new monster();
    Gamemethod gm = new Gamemethod();
    GameVar gv = new GameVar();
    ChrDiathesisVar cdv = new ChrDiathesisVar();
    String a;

    /**
     * Creates new form GameMS
     */
    public GameMS() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outText = new javax.swing.JScrollPane();
        chatLog = new javax.swing.JTextPane();
        主畫面 = new javax.swing.JTabbedPane();
        人物資訊 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        Level = new javax.swing.JLabel();
        稱號 = new javax.swing.JLabel();
        更新 = new javax.swing.JButton();
        開始 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        夥伴資訊 = new javax.swing.JPanel();
        顯示夥伴 = new javax.swing.JLabel();
        選擇夥伴 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        夥伴好感度 = new javax.swing.JTextArea();
        同行奇遇 = new javax.swing.JButton();
        打怪修煉 = new javax.swing.JPanel();
        選擇怪物 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("你好！我是來打雜的");

        chatLog.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                chatLogAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        outText.setViewportView(chatLog);

        Name.setText("姓名 :");

        exp.setText("經驗 :");

        Level.setText("等級 :");

        稱號.setText("稱號 :");

        更新.setText("更新(卡住請按)");
        更新.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                更新ActionPerformed(evt);
            }
        });

        開始.setText("開始");
        開始.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                開始ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout 人物資訊Layout = new javax.swing.GroupLayout(人物資訊);
        人物資訊.setLayout(人物資訊Layout);
        人物資訊Layout.setHorizontalGroup(
            人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(人物資訊Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, 人物資訊Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(開始)
                        .addGap(18, 18, 18)
                        .addComponent(更新))
                    .addGroup(人物資訊Layout.createSequentialGroup()
                        .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Level, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(稱號, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        人物資訊Layout.setVerticalGroup(
            人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(人物資訊Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Level, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(稱號, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(65, 65, 65)
                .addGroup(人物資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(更新)
                    .addComponent(開始))
                .addContainerGap())
        );

        主畫面.addTab("人物資訊", 人物資訊);

        夥伴資訊.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                夥伴資訊AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        顯示夥伴.setText("尚未選擇夥伴");
        顯示夥伴.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                顯示夥伴AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        選擇夥伴.setText("選擇");
        選擇夥伴.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                選擇夥伴ActionPerformed(evt);
            }
        });

        夥伴好感度.setColumns(20);
        夥伴好感度.setRows(5);
        夥伴好感度.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                夥伴好感度AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(夥伴好感度);

        同行奇遇.setText("同行奇遇");
        同行奇遇.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                同行奇遇ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout 夥伴資訊Layout = new javax.swing.GroupLayout(夥伴資訊);
        夥伴資訊.setLayout(夥伴資訊Layout);
        夥伴資訊Layout.setHorizontalGroup(
            夥伴資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(夥伴資訊Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(夥伴資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(夥伴資訊Layout.createSequentialGroup()
                        .addComponent(顯示夥伴, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(選擇夥伴))
                    .addComponent(同行奇遇))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        夥伴資訊Layout.setVerticalGroup(
            夥伴資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(夥伴資訊Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(夥伴資訊Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(顯示夥伴, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(選擇夥伴))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(同行奇遇)
                .addGap(31, 31, 31))
            .addGroup(夥伴資訊Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        主畫面.addTab("夥伴資訊", 夥伴資訊);

        選擇怪物.setText("選擇怪物");
        選擇怪物.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                選擇怪物ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout 打怪修煉Layout = new javax.swing.GroupLayout(打怪修煉);
        打怪修煉.setLayout(打怪修煉Layout);
        打怪修煉Layout.setHorizontalGroup(
            打怪修煉Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, 打怪修煉Layout.createSequentialGroup()
                .addContainerGap(478, Short.MAX_VALUE)
                .addComponent(選擇怪物)
                .addGap(25, 25, 25))
        );
        打怪修煉Layout.setVerticalGroup(
            打怪修煉Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, 打怪修煉Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(選擇怪物)
                .addContainerGap())
        );

        主畫面.addTab("打怪打怪囉", 打怪修煉);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(主畫面)
                    .addComponent(outText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(主畫面)
                .addGap(18, 18, 18)
                .addComponent(outText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void 顯示夥伴AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_顯示夥伴AncestorAdded

    }//GEN-LAST:event_顯示夥伴AncestorAdded

    private void 夥伴資訊AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_夥伴資訊AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_夥伴資訊AncestorAdded

    private void 選擇夥伴ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_選擇夥伴ActionPerformed

        if (gv.isOneChoose) {
            npc.setChoosePartner();
            npc.setLoves();
            顯示夥伴.setText("目前夥伴 : " + GameVar.NpcName[GameVar.choose - 1]);
        } else {
            a = "夥伴資訊：不可更換夥伴！";
            printfChatLog(a);
        }
        Updata();
    }//GEN-LAST:event_選擇夥伴ActionPerformed

    private void 更新ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_更新ActionPerformed
        // TODO add your handling code her
        Updata();
    }//GEN-LAST:event_更新ActionPerformed

    private void 開始ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_開始ActionPerformed
        // TODO add your handling code here:
        if (ap.i == true) {
            a = "人物資訊：已有名字！！";
            printfChatLog(a);
        } else {
            ap.setName();
        }
        Name.setText("姓名 : " + GameVar.PlayerName);
        Updata();
    }//GEN-LAST:event_開始ActionPerformed

    private void chatLogAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_chatLogAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLogAncestorAdded

    private void 選擇怪物ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_選擇怪物ActionPerformed
        if (ap.i == true) {
            try {
                // TODO add your handling code here:
                gm.AtkMonster();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            chatLog.setText("請點選*人物資訊 - 開始遊戲*");
        }
        Updata();
    }//GEN-LAST:event_選擇怪物ActionPerformed

    private void 夥伴好感度AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_夥伴好感度AncestorAdded
        // TODO add your handling code here:
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < GameVar.NpcLoves.length; i++) {
            value.append("\n " + GameVar.NpcName[i] + "\t" + GameVar.NpcLevelName[GameVar.NpcLevel[i]] + "\t" + GameVar.NpcLoves[i]);
        }
        夥伴好感度.setText("姓名\t稱號\t好感度" + value.toString());
        Updata();
    }//GEN-LAST:event_夥伴好感度AncestorAdded

    private void 同行奇遇ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_同行奇遇ActionPerformed
        // TODO add your handling code here:
        gm.GiveChoose();
        Updata();
    }//GEN-LAST:event_同行奇遇ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMS().setVisible(true);
                xx();
            }
        });
    }

    //訊息廣播
    public static void printfChatLog(String str) {
        chatLog.setText(chatLog.getText() + str + "\r\n");
    }

    //
    public void loveupdate() {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < GameVar.NpcLoves.length; i++) {
            value.append("\n " + GameVar.NpcName[i] + "\t" + GameVar.NpcLevelName[GameVar.NpcLevel[i]] + "\t" + GameVar.NpcLoves[i]);
        }
        夥伴好感度.setText("姓名\t稱號\t好感度" + value.toString());
    }

    //隨時更新資訊
    public void Updata() {
        Name.setText("姓名 : " + GameVar.PlayerName);
        Level.setText("等級 : " + GameVar.ChrLevel);
        exp.setText("經驗 : " + GameVar.ChrExp);
        稱號.setText("稱號 : " + GameVar.str);
        jLabel1.setText("STR : " + cdv.STR);
        jLabel2.setText("AGI : " + cdv.AGI);
        jLabel3.setText("INT : " + cdv.INT);
        jLabel4.setText("LUK : " + cdv.LUK);
        loveupdate();
    }

    //鎖定文字視窗
    static void xx() {
        夥伴好感度.setEnabled(false);
        chatLog.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Level;
    private javax.swing.JLabel Name;
    public static javax.swing.JTextPane chatLog;
    private javax.swing.JLabel exp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane outText;
    private javax.swing.JTabbedPane 主畫面;
    private javax.swing.JPanel 人物資訊;
    private javax.swing.JButton 同行奇遇;
    public static javax.swing.JTextArea 夥伴好感度;
    private javax.swing.JPanel 夥伴資訊;
    private javax.swing.JPanel 打怪修煉;
    private javax.swing.JButton 更新;
    private javax.swing.JLabel 稱號;
    private javax.swing.JButton 選擇夥伴;
    private javax.swing.JButton 選擇怪物;
    private javax.swing.JButton 開始;
    public javax.swing.JLabel 顯示夥伴;
    // End of variables declaration//GEN-END:variables
}
