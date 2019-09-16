package com.android.edit.editor.view.connection;
import android.view.inputmethod.BaseInputConnection;
import com.android.edit.editor.view.AbstractEditorView;

public class JoyiInputConnection extends BaseInputConnection
{
    public JoyiInputConnection(AbstractEditorView view){
        super(view,true);
    }

    @Override
    public boolean setComposingText(CharSequence text, int newCursorPosition)
    {
        return super.setComposingText(text, newCursorPosition);
    }
    
}
