package com.android.edit.editor.view;
import android.view.inputmethod.BaseInputConnection;

public class QInputConnection extends BaseInputConnection
{ 
   public QInputConnection(AbstractEditorView view){
       super(view,true);
   }
}
