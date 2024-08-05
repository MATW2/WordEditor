package file;

import Interfaces.*;
import layout.AbstractAppLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.io.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class File implements IOpenFile, ISaveFile, INewFile {
    private AbstractAppLayout appLayout;
    private IUndoAndRedo undoAndRedo;
    private IClear clear;
    private String filleName;
    private String filleAdress;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public IUndoAndRedo getUndoAndRedo() {
        return undoAndRedo;
    }

    public IClear getClear() {
        return clear;
    }

    public String getFilleName() {
        return filleName;
    }

    public String getFilleAdress() {
        return filleAdress;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setUndoAndRedo(IUndoAndRedo undoAndRedo) {
        this.undoAndRedo = undoAndRedo;
    }

    public void setClear(IClear clear) {
        this.clear = clear;
    }

    public void setFilleName(String filleName) {
        this.filleName = filleName;
    }

    public void setFilleAdress(String filleAdress) {
        this.filleAdress = filleAdress;
    }

    public File(AbstractAppLayout appLayout, IUndoAndRedo undoAndRedo, IClear clear) {
        this.appLayout = appLayout;
        this.undoAndRedo = undoAndRedo;
        this.clear = clear;
        this.filleName = null;
        this.filleAdress = null;
    }

    private void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filleAdress + filleName)))) {
            RTFEditorKit rtfKit = new RTFEditorKit();
            StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            rtfKit.write(outputStream, doc, 0, doc.getLength());
            bufferedWriter.write(outputStream.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Błąd podczas zapisu.", "WordEditor", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void openFile() {
        FileDialog fileDialog = new FileDialog(appLayout, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String selectedFile = fileDialog.getFile();
        if (selectedFile != null) {
            filleName = selectedFile;
            filleAdress = fileDialog.getDirectory();
            appLayout.setTitle("WordEditor " + filleName);
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filleAdress + filleName)))) {
                appLayout.getMainContent().getTextPane().setText("");
                RTFEditorKit rtfKit = new RTFEditorKit();
                StyledDocument doc = appLayout.getMainContent().getTextPane().getStyledDocument();
                rtfKit.read(bufferedReader, doc, 0);
                clear.clearLineSpacing();
                clear.clearParagraph();
                undoAndRedo.reset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Błąd podczas odczytu.", "WordEditor", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void saveFile() {
        if (filleName == null) {
            saveAs();
        } else {
            save();
        }
    }

    @Override
    public void saveAs() {
        FileDialog fileDialog = new FileDialog(appLayout, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            filleName = fileDialog.getFile().endsWith(".rtf") ? fileDialog.getFile() : fileDialog.getFile() + ".rtf";
            filleAdress = fileDialog.getDirectory();
            appLayout.setTitle("WordEditor " + filleName);
        }
        save();
    }

    @Override
    public void newFile() {
        appLayout.getMainContent().getTextPane().setText("");
        appLayout.setTitle("WordEditor New File");
        clear.clear();
        clear.clearLineSpacing();
        clear.clearParagraph();
        filleName = null;
        filleAdress = null;
        undoAndRedo.reset();
    }
}
