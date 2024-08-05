package listAction;

import Interfaces.IClear;
import Interfaces.ISelectAtribute;
import Interfaces.IUndoAndRedo;
import SelectAtribute.SelectAttribute;
import action.*;
import exit.Exit;
import file.*;
import find.*;
import font.BoldFont;
import font.FontFamily;
import font.ItalicFont;
import font.SizeFont;
import insertion.DateAndTime;
import layout.AbstractAppLayout;
import layout.about.About;
import layout.findGui.AbstractFindGui;
import paragraph.*;
import storage.*;
import text.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class ListAction {
    private AbstractAppLayout appLayout;
    private AbstractFindGui findGui;
    private ActionListener actionListener;
    private ItemListener itemListener;
    private CaretListener caretListener;
    private DocumentListener documentListener;
    private MouseListener mouseListener;
    private UndoManager undoManager;
    private IUndoAndRedo undoAndRedo;
    private IClear clear;

    public AbstractAppLayout getAppLayout() {
        return appLayout;
    }

    public AbstractFindGui getFindGui() {
        return findGui;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public ItemListener getItemListener() {
        return itemListener;
    }

    public CaretListener getCaretListener() {
        return caretListener;
    }

    public DocumentListener getDocumentListener() {
        return documentListener;
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }

    public IUndoAndRedo getUndoAndRedo() {
        return undoAndRedo;
    }

    public IClear getClear() {
        return clear;
    }

    public void setAppLayout(AbstractAppLayout appLayout) {
        this.appLayout = appLayout;
    }

    public void setFindGui(AbstractFindGui findGui) {
        this.findGui = findGui;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setCaretListener(CaretListener caretListener) {
        this.caretListener = caretListener;
    }

    public void setDocumentListener(DocumentListener documentListener) {
        this.documentListener = documentListener;
    }

    public void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    public void setUndoManager(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void setUndoAndRedo(IUndoAndRedo undoAndRedo) {
        this.undoAndRedo = undoAndRedo;
    }

    public void setClear(IClear clear) {
        this.clear = clear;
    }

    public ListAction(AbstractAppLayout appLayout, AbstractFindGui findGui) {
        this.appLayout = appLayout;
        this.findGui = findGui;
        init();
    }

    private void init() {
        undoManager = new UndoManager();
        undoAndRedo = new undoAndRedo(undoManager);
        clear = new Clear(appLayout);
        File file = new File(appLayout, undoAndRedo, clear);

        actionListener = new AListener(
                new Copy(appLayout),
                new Past(appLayout),
                new Cut(appLayout),
                new BoldFont(appLayout),
                new ItalicFont(appLayout),
                new TextUnderline(appLayout),
                new TextStrikethrough(appLayout),
                new TextColorAndBackground(appLayout),
                new TextColorAndBackground(appLayout),
                new TextSubscript(appLayout),
                new TextSuperscript(appLayout),
                new Aligment(appLayout),
                new Paragraph(appLayout),
                new SelectAll(appLayout),
                new DateAndTime(appLayout),
                findGui,
                new Find(appLayout, findGui),
                new FindNext(appLayout, findGui),
                new ReplaceFirst(appLayout, findGui),
                new ReplaceAll(appLayout, findGui),
                new Cancel(),
                undoAndRedo,
                file,
                new Exit(),
                file,
                file,
                new About(appLayout));

        itemListener = new IListener(
                appLayout,
                new SizeFont(appLayout),
                new FontFamily(appLayout),
                new LineSpacing(appLayout)
        );
        caretListener = new CListener(new SelectAttribute(appLayout));
        documentListener = new DListener(clear);
        mouseListener = new MListener(appLayout);
        addActionListener();
        addActionCommand();
        addItemListener();
        addCaretUpdate();
        addDocumentListener();
        addAccelerator();
        addUndoListener();
        addMouseAction();
    }

    private void addActionListener() {
        appLayout.getHeader().getCopyButton().addActionListener(actionListener);
        appLayout.getHeader().getPastButton().addActionListener(actionListener);
        appLayout.getHeader().getCutButton().addActionListener(actionListener);
        appLayout.getHeader().getReplaceButton().addActionListener(actionListener);

        appLayout.getHeader().getBoldButton().addActionListener(actionListener);
        appLayout.getHeader().getItalicButton().addActionListener(actionListener);
        appLayout.getHeader().getUnderlineButton().addActionListener(actionListener);
        appLayout.getHeader().getStrikeButton().addActionListener(actionListener);
        appLayout.getHeader().getTextColorButton().addActionListener(actionListener);
        appLayout.getHeader().getTextBackgroundColorButton().addActionListener(actionListener);
        appLayout.getHeader().getSubscriptButton().addActionListener(actionListener);
        appLayout.getHeader().getSuperscriptButton().addActionListener(actionListener);

        appLayout.getHeader().getRightAlignmentButton().addActionListener(actionListener);
        appLayout.getHeader().getLeftAlignmentButton().addActionListener(actionListener);

        appLayout.getHeader().getLeftAlignButton().addActionListener(actionListener);
        appLayout.getHeader().getCenterAlignButton().addActionListener(actionListener);
        appLayout.getHeader().getRightAlignButton().addActionListener(actionListener);
        appLayout.getHeader().getJustificationButton().addActionListener(actionListener);

        appLayout.getHeader().getSearchButton().addActionListener(actionListener);
        appLayout.getHeader().getSelectAllButton().addActionListener(actionListener);

        appLayout.getHeader().getTimeButton().addActionListener(actionListener);


        findGui.getFindButton().addActionListener(actionListener);
        findGui.getFindNextButton().addActionListener(actionListener);
        findGui.getReplaceButton().addActionListener(actionListener);
        findGui.getReplaceAllButton().addActionListener(actionListener);
        findGui.getCancelButton().addActionListener(actionListener);

        appLayout.getMenu().getiNew().addActionListener(actionListener);
        appLayout.getMenu().getiOpen().addActionListener(actionListener);
        appLayout.getMenu().getiSave().addActionListener(actionListener);
        appLayout.getMenu().getiSaveAS().addActionListener(actionListener);
        appLayout.getMenu().getiExit().addActionListener(actionListener);

        appLayout.getMenu().getiRedo().addActionListener(actionListener);
        appLayout.getMenu().getiUndo().addActionListener(actionListener);
        appLayout.getMenu().getiCut().addActionListener(actionListener);
        appLayout.getMenu().getiCopy().addActionListener(actionListener);
        appLayout.getMenu().getiPast().addActionListener(actionListener);
        appLayout.getMenu().getiSelectAll().addActionListener(actionListener);

        appLayout.getMenu().getiAbout().addActionListener(actionListener);
    }

    private void addActionCommand() {
        appLayout.getHeader().getCopyButton().setActionCommand("Copy");
        appLayout.getHeader().getPastButton().setActionCommand("Past");
        appLayout.getHeader().getCutButton().setActionCommand("Cut");
        appLayout.getHeader().getReplaceButton().setActionCommand("Replace");

        appLayout.getHeader().getBoldButton().setActionCommand("Bold");
        appLayout.getHeader().getItalicButton().setActionCommand("Italic");
        appLayout.getHeader().getUnderlineButton().setActionCommand("Underline");
        appLayout.getHeader().getStrikeButton().setActionCommand("StrikeThrough");
        appLayout.getHeader().getTextColorButton().setActionCommand("TextColor");
        appLayout.getHeader().getTextBackgroundColorButton().setActionCommand("TextBackgroundColor");
        appLayout.getHeader().getSubscriptButton().setActionCommand("Subscript");
        appLayout.getHeader().getSuperscriptButton().setActionCommand("Superscript");

        appLayout.getHeader().getRightAlignmentButton().setActionCommand("RightAlignment");
        appLayout.getHeader().getLeftAlignmentButton().setActionCommand("LeftAlignment");

        appLayout.getHeader().getLeftAlignButton().setActionCommand("LeftAlign");
        appLayout.getHeader().getCenterAlignButton().setActionCommand("CenterAlign");
        appLayout.getHeader().getRightAlignButton().setActionCommand("RightAlign");
        appLayout.getHeader().getJustificationButton().setActionCommand("Justification");

        appLayout.getHeader().getSearchButton().setActionCommand("Search");
        appLayout.getHeader().getSelectAllButton().setActionCommand("SelectAll");

        appLayout.getHeader().getTimeButton().setActionCommand("Time");

        findGui.getFindButton().setActionCommand("FindFirst");
        findGui.getFindNextButton().setActionCommand("FindNext");
        findGui.getReplaceButton().setActionCommand("ReplaceFirst");
        findGui.getReplaceAllButton().setActionCommand("ReplaceAll");
        findGui.getCancelButton().setActionCommand("Cancel");

        appLayout.getMenu().getiNew().setActionCommand("NewFile");
        appLayout.getMenu().getiOpen().setActionCommand("OpenFile");
        appLayout.getMenu().getiSave().setActionCommand("SaveFile");
        appLayout.getMenu().getiSaveAS().setActionCommand("SaveASFile");
        appLayout.getMenu().getiExit().setActionCommand("Exit");

        appLayout.getMenu().getiRedo().setActionCommand("Redo");
        appLayout.getMenu().getiUndo().setActionCommand("Undo");
        appLayout.getMenu().getiCut().setActionCommand("Cut");
        appLayout.getMenu().getiCopy().setActionCommand("Copy");
        appLayout.getMenu().getiPast().setActionCommand("Past");
        appLayout.getMenu().getiSelectAll().setActionCommand("SelectAll");

        appLayout.getMenu().getiAbout().setActionCommand("About");

    }

    private void addAccelerator() {
        appLayout.getMenu().getiNew().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiOpen().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiSave().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiSaveAS().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));

        appLayout.getMenu().getiUndo().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiRedo().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        appLayout.getMenu().getiCut().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiCopy().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiPast().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        appLayout.getMenu().getiSelectAll().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    }


    private void addItemListener() {
        appLayout.getHeader().getFontComboBox().addItemListener(itemListener);
        appLayout.getHeader().getSizeFontComboBox().addItemListener(itemListener);
        appLayout.getHeader().getLineSpacingComboBox().addItemListener(itemListener);
    }

    private void addCaretUpdate() {
        appLayout.getMainContent().getTextPane().addCaretListener(caretListener);
    }

    private void addDocumentListener() {
        appLayout.getMainContent().getTextPane().getDocument().addDocumentListener(documentListener);
    }

    private void addUndoListener() {
        appLayout.getMainContent().getTextPane().getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }

    private void addMouseAction() {
        appLayout.getHeader().getCopyButton().addMouseListener(mouseListener);
        appLayout.getHeader().getPastButton().addMouseListener(mouseListener);
        appLayout.getHeader().getCutButton().addMouseListener(mouseListener);
        appLayout.getHeader().getReplaceButton().addMouseListener(mouseListener);

        appLayout.getHeader().getBoldButton().addMouseListener(mouseListener);
        appLayout.getHeader().getItalicButton().addMouseListener(mouseListener);
        appLayout.getHeader().getUnderlineButton().addMouseListener(mouseListener);
        appLayout.getHeader().getStrikeButton().addMouseListener(mouseListener);
        appLayout.getHeader().getTextColorButton().addMouseListener(mouseListener);
        appLayout.getHeader().getTextBackgroundColorButton().addMouseListener(mouseListener);
        appLayout.getHeader().getSubscriptButton().addMouseListener(mouseListener);
        appLayout.getHeader().getSuperscriptButton().addMouseListener(mouseListener);

        appLayout.getHeader().getLineSpacingComboBox().addMouseListener(mouseListener);
        appLayout.getHeader().getFontComboBox().addMouseListener(mouseListener);
        appLayout.getHeader().getSizeFontComboBox().addMouseListener(mouseListener);

        appLayout.getHeader().getLeftAlignmentButton().addMouseListener(mouseListener);
        appLayout.getHeader().getRightAlignmentButton().addMouseListener(mouseListener);
        appLayout.getHeader().getLeftAlignButton().addMouseListener(mouseListener);
        appLayout.getHeader().getCenterAlignButton().addMouseListener(mouseListener);
        appLayout.getHeader().getRightAlignButton().addMouseListener(mouseListener);
        appLayout.getHeader().getJustificationButton().addMouseListener(mouseListener);
        appLayout.getHeader().getSearchButton().addMouseListener(mouseListener);
        appLayout.getHeader().getSelectAllButton().addMouseListener(mouseListener);
        appLayout.getHeader().getTimeButton().addMouseListener(mouseListener);

    }
}