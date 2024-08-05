package storage;

import Interfaces.IUndoAndRedo;

import javax.swing.undo.UndoManager;

public class undoAndRedo implements IUndoAndRedo {
    private UndoManager undoManager;

    public UndoManager getUndoManager() {
        return undoManager;
    }

    public void setUndoManager(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public undoAndRedo(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undo() {
        if (undoManager.canUndo()) undoManager.undo();
    }

    @Override
    public void redo() {
        if (undoManager.canRedo()) undoManager.redo();
    }

    @Override
    public void reset() {
        undoManager.discardAllEdits();
    }
}
