package views.harvest_stage;

import views.graphics.SettlersFrame;

import javax.swing.*;
import java.awt.*;

public class DiscardResourcesDialog extends JDialog {
    private boolean sheepFlag = true;

    public DiscardResourcesDialog(SettlersFrame frame)
    {
        super(frame, ModalityType.APPLICATION_MODAL);
        setSize(300, 200);
        setUndecorated(true);
        setLocationRelativeTo(frame);
        GridBagLayout dialogLayout = new GridBagLayout();
        setLayout(dialogLayout);
        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;
        JPanel panel = new JPanel();
        GridBagLayout panelLayout = new GridBagLayout();
        panel.setLayout(panelLayout);
        panel.setBackground(new Color(173, 196, 228));
        panel.setPreferredSize(new Dimension(300, 200));
        JButton buttonSheep = new JButton("Физика");
        buttonSheep.addActionListener(e -> {
            setSheepFlag(false);
            DiscardResourcesDialog.this.dispose();
        });
        GridBagConstraints sheepConstraints = new GridBagConstraints();
        sheepConstraints.gridx = 0;
        sheepConstraints.gridy = 0;
        panel.add(buttonSheep, sheepConstraints);
        JButton physicsButton = new JButton("Забирайте овцу!");
        physicsButton.addActionListener(e -> {
            setSheepFlag(true);
            DiscardResourcesDialog.this.dispose();
        });
        GridBagConstraints physicsConstraints = new GridBagConstraints();
        physicsConstraints.gridx = 1;
        physicsConstraints.gridy = 0;
        panel.add(physicsButton, physicsConstraints);

        add(panel, panelConstraints);
        pack();
        setVisible(true);
    }

    public boolean isSheepFlag() {
        return sheepFlag;
    }

    void setSheepFlag(boolean sheepFlag) {
        this.sheepFlag = sheepFlag;
    }
}
