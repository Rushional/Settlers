package game_view.graphics;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

public class ErrorNotification extends JInternalFrame {
    public ErrorNotification() {
        super("I'M BEING TESTED?! YOU'RE BEING TESTED!!!", false, false, false);
        setPreferredSize(new Dimension(400, 400));
        setBorder(null);
        setBackground(new Color(255, 241, 255));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        setBounds(30, 30, 350, 200);
    }

//    testing panels and internal panels

    //        JFrame frame = new JFrame("Testing internal frame");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JDesktopPane desktopPane = new JDesktopPane();
////        ErrorNotification errNot = new ErrorNotification();
//        JInternalFrame internalFrame = new JInternalFrame
//                ("I'M BEING TESTED?! YOU'RE BEING TESTED!!!", false, false, false);
//        internalFrame.setPreferredSize(new Dimension(400, 400));
//        internalFrame.setBorder(null);
//        internalFrame.setBackground(new Color(255, 241, 255));
//        BasicInternalFrameUI bi = (BasicInternalFrameUI)internalFrame.getUI();
//        bi.setNorthPane(null);
//        internalFrame.setBounds(30, 30, 350, 200);
////        errNot.setBounds(30, 30, 350, 200);
//        desktopPane.add(internalFrame);
////        desktopPane.add(errNot);
//        frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
//        frame.setPreferredSize(new Dimension(500, 400));
//        internalFrame.setVisible(true);
////        errNot.setVisible(true);
//        frame.pack();
//        frame.setVisible(true);

//        JFrame frame = new JFrame("Testing internal frame");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(500, 400));
//        GridBagLayout layout = new GridBagLayout();
//        frame.setLayout(layout);
//        GridBagConstraints gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.fill = GridBagConstraints.BOTH;
//        gridBagConstraints.weightx = 0;
//        gridBagConstraints.weighty = 0;
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 0;
//        JPanel externalPanel = new JPanel();
//        externalPanel.setBackground(new Color(255, 241, 255));
//        JPanel internalPanel = new JPanel();
//        internalPanel.setBackground(new Color(0, 0, 255));
////        internalPanel.setSize(60, 60);
//        internalPanel.setBounds(20, 20, 300, 300);
//        internalPanel.setPreferredSize(new Dimension(300, 300));
//        externalPanel.add(internalPanel);
//        frame.add(externalPanel, gridBagConstraints);
//        frame.pack();
//        frame.setVisible(true);

    //ALSO PopupFactory
}
