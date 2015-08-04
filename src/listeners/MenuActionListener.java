package listeners;

import interfaceCalc.InformAboutProg;
import interfaceCalc.PlansImplementation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener {
    public static PlansImplementation plansImplementation;
    public static InformAboutProg inform;

    public static class ActionUsual implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            plansImplementation = new PlansImplementation();

        }
    }

    public static class ActionEngineering implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            plansImplementation = new PlansImplementation();

        }
    }

    public static class ActionCopy implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            plansImplementation = new PlansImplementation();

        }
    }

    public static class ActionInsert implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            plansImplementation = new PlansImplementation();

        }
    }


    public static class ActionAboutProg implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            inform = new InformAboutProg();
        }
    }

}
