package com.android.apkbuilder.tools.aapt;
import java.io.File;

public class Aapt
{
    protected File mAapt;
    
    protected Aapt(File aapt){
        mAapt=aapt;
    }
    
    public static Aapt create(File aapt){
        return new Aapt(aapt);
    }
}
