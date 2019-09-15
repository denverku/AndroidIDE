package com.android.apkbuilder;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.File;
import java.io.PrintStream;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;

public class TestActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        PrintStream out=null;
        try
        {
             out=new PrintStream(new File(getFilesDir(),"out.txt"));
            System.setOut(out);
            System.setErr(out);
      
        Main.main(new String[]{"help"});
        TextView view=new TextView(this);
        
        StringBuilder buffer=new StringBuilder();
        BufferedReader read=new BufferedReader(new FileReader( new File(getFilesDir(),"out.txt")));
        String txt=null;
        while((txt=read.readLine())!=null){
            buffer.append(txt+"\n");
        }
        read.close();
        view.setText(buffer.toString());
        setContentView(view);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
