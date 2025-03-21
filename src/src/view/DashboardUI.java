package view;

import core.Helper;
import entity.User;
import javax.swing.*;

public class DashboardUI extends JFrame {
    private JPanel container;
    private User user;

    public DashboardUI(User user) {
        this.user = user;

        if(user == null) {
            Helper.showMsg("error");
            dispose();
        }

        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        System.out.println(this.user.toString());
    }




}
