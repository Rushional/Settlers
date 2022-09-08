package client.views.inputs.dialogs;

import javax.swing.*;
import java.awt.*;

public class VerticalSpinner extends JSpinner {
    public VerticalSpinner(SpinnerModel model) {
        super(model);
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(new SpinnerLayout());
    }

    static class SpinnerLayout extends BorderLayout {
        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if ("Editor".equals(constraints)) {
                constraints = "Center";
            } else if ("Next".equals(constraints)) {
                constraints = "North";
            } else if ("Previous".equals(constraints)) {
                constraints = "South";
            }
            super.addLayoutComponent(comp, constraints);
        }
    }
}
