package action;


import Interfaces.*;
import Interfaces.INewFile;
import Interfaces.IOpenFile;
import Interfaces.ISaveFile;
import Interfaces.IDateAndTime;
import Interfaces.IAligment;
import Interfaces.IParagraph;
import layout.about.AbstractAbout;
import layout.findGui.AbstractFindGui;

import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record AListener(ICopy copy,
                        IPast past,
                        ICut cut,
                        StyledEditorKit.StyledTextAction boldFont,
                        StyledEditorKit.StyledTextAction italicFont,
                        StyledEditorKit.StyledTextAction underline,
                        StyledEditorKit.StyledTextAction strikeThrough,
                        ITextColor textColor,
                        ITextBackgroundColor textBackgroundColor,
                        StyledEditorKit.StyledTextAction subscript,
                        StyledEditorKit.StyledTextAction superscript,
                        IAligment aligment,
                        IParagraph paragraph,
                        ISelectAll selectAll,
                        IDateAndTime dateAndTime,
                        AbstractFindGui findGui,
                        IFind find,
                        IFindNext findNext,
                        IReplaceFirst replaceFirst,
                        IReplaceAll replaceAll,
                        ICancel cancel,
                        IUndoAndRedo undoAndRedo,
                        INewFile newFile,
                        IExit exit,
                        IOpenFile openFile,
                        ISaveFile saveFile,
                        AbstractAbout about) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Copy" -> copy.copy();
            case "Past" -> past.past();
            case "Cut" -> cut.cut();
            case "Replace", "Search" -> findGui.setVisible(true);
            case "Bold" -> boldFont.actionPerformed(null);
            case "Italic" -> italicFont.actionPerformed(null);
            case "Underline" -> underline.actionPerformed(null);
            case "StrikeThrough" -> strikeThrough.actionPerformed(null);
            case "TextColor" -> textColor.addTextColor();
            case "TextBackgroundColor" -> textBackgroundColor.addTextBackgroundColor();
            case "Subscript" -> subscript.actionPerformed(null);
            case "Superscript" -> superscript.actionPerformed(null);

            case "RightAlignment" -> aligment.reducingIndent();
            case "LeftAlignment" -> aligment.increasingIndent();

            case "LeftAlign" -> paragraph.alignLeft();
            case "CenterAlign" -> paragraph.alignCenter();
            case "RightAlign" -> paragraph.alignRight();
            case "Justification" -> paragraph.alignJustified();

            case "SelectAll" -> selectAll.selectAll();

            case "Time" -> dateAndTime.insertDataAndTime();
            case "FindFirst" -> find.find();
            case "FindNext" -> findNext.findNext();
            case "ReplaceFirst" -> replaceFirst.replaceFirst();
            case "ReplaceAll" -> replaceAll.replaceAll();
            case "Cancel" -> cancel.cancel(findGui);
            case "NewFile" -> newFile.newFile();
            case "OpenFile" -> openFile.openFile();
            case "SaveFile" -> saveFile.saveFile();
            case "SaveASFile" -> saveFile.saveAs();
            case "Exit" -> exit.exit();
            case "Redo" -> undoAndRedo.redo();
            case "Undo" -> undoAndRedo.undo();
            case "About" -> about.setVisible(true);
        }
    }
}

