package core;

import javax.swing.*;

public class Helper {
    public static void setTheme(){
        //UIManager.getInstalledLookAndFeels(); : hazır temaları almaya yarar.

        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if(info.getName().equals("Nimbus")){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
