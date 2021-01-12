package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public Controller getController() {
        return controller;
    }

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener fl = new FrameListener(this);
        addWindowListener(fl);
        setVisible(true);
    }
    public void exit(){controller.exit();}
    public void initMenuBar(){
        JMenuBar jmb = new JMenuBar();
        MenuHelper.initFileMenu(this, jmb);
        MenuHelper.initEditMenu(this, jmb);
        MenuHelper.initStyleMenu(this, jmb);
        MenuHelper.initAlignMenu(this, jmb);
        MenuHelper.initColorMenu(this, jmb);
        MenuHelper.initFontMenu(this, jmb);
        MenuHelper.initHelpMenu(this, jmb);
        getContentPane().add(jmb, BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollHtmlPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", scrollHtmlPane);
        JScrollPane scrollTextPane = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", scrollTextPane);
        tabbedPane.setPreferredSize(new Dimension(400, 400));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        else{
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Новый" : controller.createNewDocument(); break;
            case "Открыть" : controller.openDocument(); break;
            case "Сохранить" : controller.saveDocument(); break;
            case "Сохранить как..." : controller.saveDocumentAs(); break;
            case "Выход" : controller.exit(); break;
            case "О программе" : showAbout(); break;
        }
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void undo(){
        try{
            undoManager.undo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try{
            undoManager.redo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener(){
        return undoListener;
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        return  tabbedPane.getSelectedIndex() == 0 ? true : false;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Test message", "Help info", JOptionPane.INFORMATION_MESSAGE);
    }
}
