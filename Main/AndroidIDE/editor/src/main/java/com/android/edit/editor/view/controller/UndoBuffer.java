package com.android.edit.editor.view.controller;
import android.view.View.BaseSavedState;
import android.os.Parcelable;
import android.os.Parcel;

public class UndoBuffer
{
    
    
    
    public static interface OnUndoRedoListener{
        void onUndo();
        void onRedo();
    }
    
    
    
    public static class TextData implements Parcelable
    {

        @Override
        public void writeToParcel(Parcel p1, int p2)
        {
        }

        @Override
        public int describeContents()
        {
            return 0;
        }


        
    }
    
    public void setEnabled(boolean enable){
        
    }
    
    public boolean isEnabled(){
        return true;
    }
    
    public void setUndoMax(int value){
        
    }
    
    public int maxValue(){
        return 0;
    }
    

    
    
    
    public void save(){
        
    }
    
    public void reset(){
        
    }
    
    //android of batch edit
    public static class State{
       public static int BATCH_UNLL=0;
       public static int BATCH_BEGIN=1;
       public static int BATCH_END=2;
    }
    
}
