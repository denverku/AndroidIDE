package com.android.edit.editor.view;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.OverScroller;
import android.graphics.Paint;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.EditorInfo;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.DragEvent;
import android.graphics.Canvas;
import android.view.inputmethod.InputConnection;
import android.util.Log;

 abstract class AbstractEditorView extends View
{
    public AbstractEditorView(Context context){
        super(context);
        initView();
    }
    
    public AbstractEditorView(Context context,AttributeSet attrs){
        super(context,attrs);
        initView();
    }
    
    public AbstractEditorView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        initView();
    }
    
    
    protected InputMethodManager mInputManager;
    protected OverScroller mScroller;
    protected Paint mPaint;
    protected Paint mTextPaint;
    
    protected EditorInfo mEditorInfo;
    protected boolean mEditable;
    
    protected void initView(){
        mInputManager=(InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        mScroller=new OverScroller(getContext());
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(getDefaultTextSize());
        mTextPaint.setTextSize(getDefaultTextSize());
        mTextPaint.setColor(getDefaultTextColor());
        mEditorInfo=getDefaultEditorInfo();
        mEditable=getDefaultEditable();
    }
    
    
    
    protected EditorInfo getDefaultEditorInfo(){
        EditorInfo info=new EditorInfo();
        info.inputType=InputType.TYPE_NULL;
        info.imeOptions=EditorInfo.IME_FLAG_NO_EXTRACT_UI;
        return info;
    }
    
    
    public void setInputTypes(int types){
        if(types!=mEditorInfo.inputType)
        mEditorInfo.inputType=types;
    }
    
    public int getInputTypes(){
        return mEditorInfo.inputType;
    }
    
    public void setImeOptions(int options){
        if(options!=mEditorInfo.imeOptions)
        mEditorInfo.imeOptions=options;
    }
    
    public int getImeOptions(){
        return mEditorInfo.imeOptions;
    }
    
    public InputMethodManager getInputMethodManager(){
        return mInputManager;
    }
    
    public void showIMEPicker(){
        getInputMethodManager().showInputMethodPicker();
    }
    
    public void showIME(boolean state){
        if(state)
            showIME();
        else
            hideIME();
    }
    
    public void showIME(){
        getInputMethodManager().showSoftInput(this,0);
    }
    
    public void hideIME(){
        getInputMethodManager().hideSoftInputFromInputMethod(getWindowToken(),0);
    }
    
    public OverScroller getScroller(){
        return mScroller;
    }
    
    protected int getDefaultTextColor(){
        return 0x21212121;
    }
    
    protected float getDefaultTextSize(){
        return 25f;
    }
    
    public Paint getPaint(){
        return mPaint;
    }
    
    public Paint getTextPaint(){
        return mTextPaint;
    }
       
    public Paint.FontMetricsInt getFontMetricsInt(){
        return getTextPaint().getFontMetricsInt();
    }
    
    public int getSignleRowHeight(){
        return getFontMetricsInt().descent-getFontMetricsInt().ascent;
    }
    
    public int getRowBaseline(int row){
        return (row+1)*getSignleRowHeight()-getFontMetricsInt().descent;
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        logt("onMeasure::","measure width:"+getMeasuredWidth(),"measure height:"+getMeasuredHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        logt("onSizeChanged::","width:"+w,"height:"+h,"old widht:"+oldw,"old height:"+oldh);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt)
    {
        super.onScrollChanged(l, t, oldl, oldt);
        logt("onScrollChanged::","left:"+l,"top:"+t,"old left:"+oldl,"old top:"+oldt);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event)
    {
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event)
    {
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onDragEvent(DragEvent event)
    {
        return super.onDragEvent(event);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    
    
    
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.save();
        onDrawBegin(canvas);
        canvas.restore();
        onDrawFinish(canvas);
    }
    
    
    protected void onDrawBegin(Canvas canvas){
        logt("onDraw::","Begin drawing...");
        log("getSignleRowHeight()::"+getSignleRowHeight());
        log("getRowBaseline()::"+getRowBaseline(0));
    }
    
    
    
    protected void onDrawFinish(Canvas canvas){
        
        log("onDraw::","Finish draw...");
    }

    
    
    
    
    
    
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs)
    {
        if(!isEditable())
        return super.onCreateInputConnection(outAttrs);
        else
        outAttrs.inputType=getInputTypes();
        outAttrs.imeOptions=getImeOptions();
        return null;
    }
    
    public void setEditable(boolean editable){
        mEditable=editable;
    }
    
    public boolean isEditable(){
        return mEditable;
    }
    
    protected boolean getDefaultEditable(){
        return true;
    }
   
    
    
    
    
    
    
    
    public static void log(String... msgs){
        for(String s:msgs){
            Log.d("EditorView",s);
        }
    }
    
    public static void logt(String name,String... msgs){
        
        for(String s:msgs){
            Log.d("EditorView",name+":"+s);
        }
    }
}
