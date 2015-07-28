package interfaceCalc;

import java.awt.*;
import javax.swing.*;


public class InterfaceCalculator extends JFrame {
    public JMenuBar menuBar;
    public JMenu view,setting, reference;
    public JMenuItem usual, engineering, copy, insert, aboutProg;
    public static JTextArea inputOutputText1;
    public static JTextArea inputOutputText2;
    public static JTextArea inputOutputText3;
    public JButton button1, button2, button3, button4, button5, button6, button7, button8, button9,
                   button0, button_add, button_minus, button_equals, button_multiply, button_divide,
                   button_fraction, button_sqrt, button_percent, button_octothorpe, button_delete_last_charact,
                   button_undo_last_action, button_clear, button_memory_add, button_memory_minus, button_memory_reach,
                   button_memory_clear, button_memory_set, button_comma;

    public InterfaceCalculator(){
        super("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        view = new JMenu("Вид");
        setting = new JMenu("Правка");
        reference = new JMenu("Справка");
        usual = new JMenuItem("Обычный");
        engineering = new JMenuItem("Инженерный");
        copy = new JMenuItem("Копировать");
        insert = new JMenuItem("Вставить");
        aboutProg = new JMenuItem("О программе");

        view.add(usual);
        view.add(engineering);
        setting.add(copy);
        setting.add(insert);
        reference.add(aboutProg);
        menuBar.add(view);
        menuBar.add(setting);
        menuBar.add(reference);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
        setContentPane(createGUI());
        setSize(345, 302);
        setVisible(true);
    }

    private JPanel createGUI(){

        inputOutputText1 = new JTextArea("0", 1, 28);
        inputOutputText2 = new JTextArea("0", 1, 28);
        inputOutputText3 = new JTextArea(1, 7);
        inputOutputText1.setLineWrap(true);
        inputOutputText2.setLineWrap(true);

        JPanel flow = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        JPanel grid1 = new JPanel( new GridLayout( 1,3,2,2));
        JPanel grid2 = new JPanel( new GridLayout( 6,5,2,2) );

        button_memory_clear = new JButton("MC");
        button_memory_reach = new JButton("MR");
        button_memory_set = new JButton("MS");
        button_memory_add = new JButton("M+");
        button_memory_minus = new JButton("M-");
        button_delete_last_charact = new JButton("delete");
        button_undo_last_action = new JButton("CE");
        button_clear = new JButton("C");
        button_octothorpe = new JButton("+/-");
        button_octothorpe.setActionCommand("-");
        button_sqrt = new JButton(new ImageIcon("D:\\Calculator\\square root.gif"));
        button_sqrt.setActionCommand("sqrt");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button_divide = new JButton("/");
        button_percent = new JButton("%");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button_multiply = new JButton("*");
        button_fraction = new JButton("1/x");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button_minus = new JButton("-");
        button_equals = new JButton("=");
        button0 = new JButton("0");
        button_comma = new JButton(".");
        button_add = new JButton("+");

        button0.addActionListener(new ActionContentP.ActionNumbers());
        button1.addActionListener(new ActionContentP.ActionNumbers());
        button2.addActionListener(new ActionContentP.ActionNumbers());
        button3.addActionListener(new ActionContentP.ActionNumbers());
        button4.addActionListener(new ActionContentP.ActionNumbers());
        button5.addActionListener(new ActionContentP.ActionNumbers());
        button6.addActionListener(new ActionContentP.ActionNumbers());
        button7.addActionListener(new ActionContentP.ActionNumbers());
        button8.addActionListener(new ActionContentP.ActionNumbers());
        button9.addActionListener(new ActionContentP.ActionNumbers());
        button_comma.addActionListener(new ActionContentP.ActionComma());
        button_octothorpe.addActionListener(new ActionContentP.ActionOctothorpe());
        button_add.addActionListener(new ActionContentP.ActionOperation());
        button_equals.addActionListener(new ActionContentP.ActionOperation());
        button_minus.addActionListener(new ActionContentP.ActionOperation());
        button_multiply.addActionListener(new ActionContentP.ActionOperation());
        button_divide.addActionListener(new ActionContentP.ActionOperation());
        button_fraction.addActionListener(new ActionContentP.ActionFraction());
        button_sqrt.addActionListener(new ActionContentP.ActionSquareRoot());
        button_percent.addActionListener(new ActionContentP.ActionOperation());
        button_clear.addActionListener(new ActionContentP.ActionC());
        button_delete_last_charact.addActionListener(new ActionContentP.ActionDeleteLastCharact());
        button_undo_last_action.addActionListener(new ActionContentP.ActionUndoLastAction());
        button_memory_set.addActionListener(new ActionMemory());
        button_memory_add.addActionListener(new ActionMemory());
        button_memory_minus.addActionListener(new ActionMemory());
        button_memory_reach.addActionListener(new ActionMemory());
        button_memory_clear.addActionListener(new ActionMemory());
        usual.addActionListener(new ActionMenu.ActionUsual());
        engineering.addActionListener(new ActionMenu.ActionEngineering());
        copy.addActionListener(new ActionMenu.ActionCopy());
        insert.addActionListener(new ActionMenu.ActionInsert());
        aboutProg.addActionListener(new ActionMenu.ActionAboutProg());

        grid1.add(inputOutputText3);
        grid1.add(button_delete_last_charact);
        grid1.add(button_undo_last_action);
        grid1.add(button_clear);
        grid2.add(button_memory_clear);
        grid2.add(button_memory_reach);
        grid2.add(button_memory_set);
        grid2.add(button_memory_add);
        grid2.add(button_memory_minus);
        grid2.add(button7);
        grid2.add(button8);
        grid2.add(button9);
        grid2.add(button_divide);
        grid2.add(button_sqrt);
        grid2.add(button4);
        grid2.add(button5);
        grid2.add(button6);
        grid2.add(button_multiply);
        grid2.add(button_percent);
        grid2.add(button1);
        grid2.add(button2);
        grid2.add(button3);
        grid2.add(button_minus);
        grid2.add(button_fraction);
        grid2.add(button_comma);
        grid2.add(button0);
        grid2.add(button_octothorpe);
        grid2.add(button_add);
        grid2.add(button_equals);
        flow.add(inputOutputText1);
        flow.add(inputOutputText2);
        flow.add(grid1);
        flow.add(grid2);
        return flow;
    }
}
