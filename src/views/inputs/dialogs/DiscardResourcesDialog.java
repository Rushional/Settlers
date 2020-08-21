package views.inputs.dialogs;

import models.ResourcesSet;

import javax.swing.*;
import java.awt.*;

public class DiscardResourcesDialog extends JDialog {
    private ResourcesSet discardedResources = null;

    public DiscardResourcesDialog(JFrame frame, ResourcesSet playersResources)
    {
//        Dialog settings
        super(frame, ModalityType.APPLICATION_MODAL);
        setSize(300, 200);
        setUndecorated(true);
        setLocationRelativeTo(frame);
        GridBagLayout dialogLayout = new GridBagLayout();
        setLayout(dialogLayout);
        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;
        JPanel panel = new JPanel();
//        panel.setBorder(BorderFactory.createLineBorder(new Color(65, 76, 145), 2));
        panel.setBorder(BorderFactory.createMatteBorder(2,2,2,1, new Color(65, 76, 145)));
//        Panel settings
        GridBagLayout panelLayout = new GridBagLayout();
        panel.setLayout(panelLayout);
        panel.setBackground(new Color(173, 196, 228));
        panel.setPreferredSize(new Dimension(300, 200));
//        Panel components
        var bricksLabel = new JLabel("Bricks");
        var bricksLabelConstraints = new GridBagConstraints();
        bricksLabelConstraints.gridx = 0;
        bricksLabelConstraints.gridy = 0;
        panel.add(bricksLabel, bricksLabelConstraints);

        var woodLabel = new JLabel("Wood");
        var woodLabelConstraints = new GridBagConstraints();
        woodLabelConstraints.gridx = 1;
        woodLabelConstraints.gridy = 0;
        woodLabelConstraints.insets.left = 2;
        panel.add(woodLabel, woodLabelConstraints);

        var sheepLabel = new JLabel("Sheep");
        var sheepLabelConstraints = new GridBagConstraints();
        sheepLabelConstraints.gridx = 2;
        sheepLabelConstraints.gridy = 0;
        sheepLabelConstraints.insets.left = 2;
        panel.add(sheepLabel, sheepLabelConstraints);

        var wheatLabel = new JLabel("Wheat");
        var wheatLabelConstraints = new GridBagConstraints();
        wheatLabelConstraints.gridx = 3;
        wheatLabelConstraints.gridy = 0;
        wheatLabelConstraints.insets.left = 2;
        panel.add(wheatLabel, wheatLabelConstraints);

        var oreLabel = new JLabel("Ore");
        var oreLabelConstraints = new GridBagConstraints();
        oreLabelConstraints.gridx = 4;
        oreLabelConstraints.gridy = 0;
        oreLabelConstraints.insets.left = 2;
        panel.add(oreLabel, oreLabelConstraints);

        SpinnerModel bricksSpinnerModel = new SpinnerNumberModel(0, 0, playersResources.getBricks(), 1);
        SpinnerModel woodSpinnerModel = new SpinnerNumberModel(0, 0, playersResources.getWood(), 1);
        SpinnerModel sheepSpinnerModel = new SpinnerNumberModel(0, 0, playersResources.getSheep(), 1);
        SpinnerModel wheatSpinnerModel = new SpinnerNumberModel(0, 0, playersResources.getWheat(), 1);
        SpinnerModel oreSpinnerModel = new SpinnerNumberModel(0, 0, playersResources.getOre(), 1);

        var bricksSpinner = new VerticalSpinner(bricksSpinnerModel);
        var bricksSpinnerConstraints = new GridBagConstraints();
        bricksSpinnerConstraints.gridx = 0;
        bricksSpinnerConstraints.gridy = 1;
        bricksSpinnerConstraints.insets.top = 2;
        bricksSpinnerConstraints.insets.left = 15;
        bricksSpinnerConstraints.insets.right = 15;
        panel.add(bricksSpinner, bricksSpinnerConstraints);

        var woodSpinner = new VerticalSpinner(woodSpinnerModel);
        var woodSpinnerConstraints = new GridBagConstraints();
        woodSpinnerConstraints.gridx = 1;
        woodSpinnerConstraints.gridy = 1;
        woodSpinnerConstraints.insets.top = 2;
        woodSpinnerConstraints.insets.left = 15;
        woodSpinnerConstraints.insets.right = 15;
        panel.add(woodSpinner, woodSpinnerConstraints);

        var sheepSpinner = new VerticalSpinner(sheepSpinnerModel);
        var sheepSpinnerConstraints = new GridBagConstraints();
        sheepSpinnerConstraints.gridx = 2;
        sheepSpinnerConstraints.gridy = 1;
        sheepSpinnerConstraints.insets.top = 2;
        sheepSpinnerConstraints.insets.left = 15;
        sheepSpinnerConstraints.insets.right = 15;
        panel.add(sheepSpinner, sheepSpinnerConstraints);

        var wheatSpinner = new VerticalSpinner(wheatSpinnerModel);
        var wheatSpinnerConstraints = new GridBagConstraints();
        wheatSpinnerConstraints.gridx = 3;
        wheatSpinnerConstraints.gridy = 1;
        wheatSpinnerConstraints.insets.top = 2;
        wheatSpinnerConstraints.insets.left = 15;
        wheatSpinnerConstraints.insets.right = 15;
        panel.add(wheatSpinner, wheatSpinnerConstraints);

        var oreSpinner = new VerticalSpinner(oreSpinnerModel);
        var oreSpinnerConstraints = new GridBagConstraints();
        oreSpinnerConstraints.gridx = 4;
        oreSpinnerConstraints.gridy = 1;
        oreSpinnerConstraints.insets.top = 2;
        oreSpinnerConstraints.insets.left = 15;
        oreSpinnerConstraints.insets.right = 15;
        panel.add(oreSpinner, oreSpinnerConstraints);

//        button and functionality
        var okayButton = new JButton("Okay");
        var okayButtonConstraints = new GridBagConstraints();
        okayButtonConstraints.gridx = 0;
        okayButtonConstraints.gridy = 2;
        okayButtonConstraints.gridwidth = 5;
        okayButtonConstraints.insets.top = 6;
        panel.add(okayButton, okayButtonConstraints);

        okayButton.addActionListener(e -> {
//            maybe do it in another method, so that it's shorter?
            int discardedBricks = getSpinnerValue(bricksSpinner);
            int discardedWood = getSpinnerValue(woodSpinner);
            int discardedSheep = getSpinnerValue(sheepSpinner);
            int discardedWheat = getSpinnerValue(wheatSpinner);
            int discardedOre = getSpinnerValue(oreSpinner);
            if (playersResources.getTotalAmount()/2 ==
                    discardedBricks + discardedWood + discardedSheep + discardedWheat + discardedOre) {
                discardedResources = new ResourcesSet(discardedBricks, discardedWood, discardedSheep, discardedWheat, discardedOre);
                DiscardResourcesDialog.this.dispose();
            }
        });

        add(panel, panelConstraints);
        pack();
        setVisible(true);
    }

    private int getSpinnerValue(VerticalSpinner spinner) {
        try {
            spinner.commitEdit();
        } catch ( java.text.ParseException ignored) { }
        return (Integer) spinner.getValue();
    }

    public ResourcesSet getDiscardedResources() {
        return discardedResources;
    }
}
