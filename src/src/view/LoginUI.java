package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;

    public LoginUI(){
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.btn_login.addActionListener(e -> {

        });
    }
}
