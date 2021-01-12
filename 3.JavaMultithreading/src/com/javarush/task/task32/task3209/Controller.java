package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void resetDocument(){
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        this.document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        this.document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public HTMLDocument getDocument() {
        return document;
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader sr = new StringReader(text);
        HTMLEditorKit kit = new HTMLEditorKit();
        try {
            kit.read(sr, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit kit = new HTMLEditorKit();
        try {
            kit.write(stringWriter, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        View view = new View();
        Controller ctrl = new Controller(view);
        view.setController(ctrl);
        view.init();
        ctrl.init();
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        chooser.setDialogTitle("Open File");
        int result = chooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader reader = new FileReader(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.read(reader, document, 0);
                view.resetUndo();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null){
            saveDocumentAs();
        }
        else{
            view.selectHtmlTab();
            try(FileWriter writer = new FileWriter(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer, document, 0, document.getLength());
                writer.flush();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        chooser.setDialogTitle("Save File");
        int result = chooser.showSaveDialog(view);
        if (result == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter writer = new FileWriter(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer, document, 0, document.getLength());
                writer.flush();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }
}
