package interfaceCalc;

import listeners.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.metal.MetalBorders;


public class CalculatorUI extends JFrame {
    public JMenuBar menuBar;
    public JMenu view,correction, reference;
    public JMenuItem usual, engineering, copy, insert, aboutProg;
    public static JTextArea inputOutputText1;
    public static JTextArea inputOutputText2;
    public static JTextArea inputOutputText3;
    public JButton button1, button2, button3, button4, button5, button6, button7, button8, button9,
                   button0, buttonAdd, buttonMinus, buttonEquals, buttonMultiply, buttonDivide,
                   buttonFraction, buttonSqrt, buttonPercent, buttonOctothorpe, buttonDeleteLastCharact,
                   buttonUndoLastAction, buttonClear, buttonMemoryAdd, buttonMemoryMinus, buttonMemoryReach,
                   buttonMemoryClear, buttonMemorySet, buttonComma;

    public CalculatorUI(){
        super(Constants.calculator);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        menuBar = new JMenuBar();
        view = new JMenu(Constants.view);
        correction = new JMenu(Constants.correction);
        reference = new JMenu(Constants.reference);
        usual = new JMenuItem(Constants.usual);
        engineering = new JMenuItem(Constants.engineering);
        copy = new JMenuItem(Constants.copy);
        insert = new JMenuItem(Constants.insert);
        aboutProg = new JMenuItem(Constants.aboutProg);

        view.add(usual);
        view.add(engineering);
        correction.add(copy);
        correction.add(insert);
        reference.add(aboutProg);
        menuBar.add(view);
        menuBar.add(correction);
        menuBar.add(reference);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);
        setContentPane(createGUI());
        setPreferredSize(new Dimension(355, 260));
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createGUI(){

        inputOutputText1 = new JTextArea("0", 1, 10);
        inputOutputText2 = new JTextArea("0", 1, 10);
        inputOutputText3 = new JTextArea(1, 1);
        inputOutputText1.setLineWrap(true);
        inputOutputText2.setLineWrap(true);
        inputOutputText1.setEditable(false);
        inputOutputText2.setEditable(false);
        inputOutputText3.setEditable(false);
        inputOutputText3.grabFocus();
        inputOutputText3.setBorder(new BorderUIResource(new MetalBorders.OptionDialogBorder()));

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        JPanel grid1 = new JPanel( new GridLayout( 2,1,2,2));
        JPanel grid2 = new JPanel( new GridLayout( 1,3,2,2));
        JPanel grid3 = new JPanel( new GridLayout( 6,5,2,2) );
        box.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonMemoryClear = new JButton("MC");
        buttonMemoryReach = new JButton("MR");
        buttonMemorySet = new JButton("MS");
        buttonMemoryAdd = new JButton("M+");
        buttonMemoryMinus = new JButton("M-");
        buttonDeleteLastCharact = new JButton("delete");
        buttonUndoLastAction = new JButton("CE");
        buttonClear = new JButton("C");
        buttonOctothorpe = new JButton("+/-");
        buttonOctothorpe.setActionCommand("-");
        buttonSqrt = new JButton("\u221A");
        buttonSqrt.setActionCommand("sqrt");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDivide = new JButton("/");
        buttonPercent = new JButton("%");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        buttonMultiply = new JButton("*");
        buttonFraction = new JButton("1/x");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        buttonMinus = new JButton("-");
        buttonEquals = new JButton("=");
        button0 = new JButton("0");
        buttonComma = new JButton(".");
        buttonAdd = new JButton("+");

        NumbersActionListener numbersActionListener = new NumbersActionListener();
        OperationActionListener operationActionListener = new OperationActionListener();
        MemoryActionListener memoryActionListener = new MemoryActionListener();
        button0.addActionListener(numbersActionListener);
        button1.addActionListener(numbersActionListener);
        button2.addActionListener(numbersActionListener);
        button3.addActionListener(numbersActionListener);
        button4.addActionListener(numbersActionListener);
        button5.addActionListener(numbersActionListener);
        button6.addActionListener(numbersActionListener);
        button7.addActionListener(numbersActionListener);
        button8.addActionListener(numbersActionListener);
        button9.addActionListener(numbersActionListener);
        buttonComma.addActionListener(new CommaActionListener());
        buttonOctothorpe.addActionListener(new OctothorpeActionListener());
        buttonAdd.addActionListener(operationActionListener);
        buttonEquals.addActionListener(operationActionListener);
        buttonMinus.addActionListener(operationActionListener);
        buttonMultiply.addActionListener(operationActionListener);
        buttonDivide.addActionListener(operationActionListener);
        buttonFraction.addActionListener(new FractionActionListener());
        buttonSqrt.addActionListener(new SquareRootActionListener());
        buttonPercent.addActionListener(operationActionListener);
        buttonClear.addActionListener(new CActionListener());
        buttonDeleteLastCharact.addActionListener(new DeleteLastCharactActionListener());
        buttonUndoLastAction.addActionListener(new UndoLastActionListener());
        buttonMemorySet.addActionListener(memoryActionListener);
        buttonMemoryAdd.addActionListener(memoryActionListener);
        buttonMemoryMinus.addActionListener(memoryActionListener);
        buttonMemoryReach.addActionListener(memoryActionListener);
        buttonMemoryClear.addActionListener(memoryActionListener);
        usual.addActionListener(new MenuActionListener.ActionUsual());
        engineering.addActionListener(new MenuActionListener.ActionEngineering());
        copy.addActionListener(new MenuActionListener.ActionCopy());
        insert.addActionListener(new MenuActionListener.ActionInsert());
        aboutProg.addActionListener(new MenuActionListener.ActionAboutProg());

        grid1.add(inputOutputText1);
        grid1.add(inputOutputText2);
        grid2.add(inputOutputText3);
        grid2.add(buttonDeleteLastCharact);
        grid2.add(buttonUndoLastAction);
        grid2.add(buttonClear);
        grid3.add(buttonMemoryClear);
        grid3.add(buttonMemoryReach);
        grid3.add(buttonMemorySet);
        grid3.add(buttonMemoryAdd);
        grid3.add(buttonMemoryMinus);
        grid3.add(button7);
        grid3.add(button8);
        grid3.add(button9);
        grid3.add(buttonDivide);
        grid3.add(buttonSqrt);
        grid3.add(button4);
        grid3.add(button5);
        grid3.add(button6);
        grid3.add(buttonMultiply);
        grid3.add(buttonPercent);
        grid3.add(button1);
        grid3.add(button2);
        grid3.add(button3);
        grid3.add(buttonMinus);
        grid3.add(buttonFraction);
        grid3.add(buttonComma);
        grid3.add(button0);
        grid3.add(buttonOctothorpe);
        grid3.add(buttonAdd);
        grid3.add(buttonEquals);
        box.add(grid1);
        box.add(grid2);
        box.add(grid3);
        return box;
    }
}
