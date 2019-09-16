package com.android.edit;
import android.app.Activity;
import android.os.Bundle;
import com.android.edit.editor.view.EditorView;

public class TestActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EditorView view=new EditorView(this);
        setContentView(view);
    }
    
}
