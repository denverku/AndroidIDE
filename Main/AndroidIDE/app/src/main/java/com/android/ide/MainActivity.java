package com.android.ide;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }

    @Override
    public VoiceInteractor getVoiceInteractor()
    {
        return super.getVoiceInteractor();
    }
    
}
