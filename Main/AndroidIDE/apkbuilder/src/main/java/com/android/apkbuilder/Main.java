package com.android.apkbuilder;
import com.android.apkbuilder.build.android.tasks.AndroidBuilder;
import com.android.apkbuilder.build.java.tasks.JavaBuilder;
import java.util.Arrays;

public class Main
{
    
   private Main(){
       System.out.println("Create class:"+this.getClass().getName());
   }
   
   public static final int ERROR=1;
   public static final int SUCCESS=0;
   public static final int UNKNOWN=-1;
   
   
   public static int main(String[] args){
          if(args[0].equals("android")){
              return execAndroid(Arrays.copyOfRange(args,1,args.length));
          } else if(args[0].equals("java")){
              return execJava(Arrays.copyOfRange(args,1,args.length));
          }else if(args[0].equals("help")|args[0].equals("-help")){
              System.out.println(usage());
              return SUCCESS;
          }else{
              System.out.println("未知的命令:"+args[0]);
              return UNKNOWN;
          }
   }
   
    
    public static int execAndroid(String[] args){
        for(String arg:args){
            System.out.println(arg);
        }
        return ERROR;
    }
    
    public static int execJava(String[] args){
        for(String arg:args){
            System.out.println(arg);
        }
        return ERROR;
    }
    
    public static String usage(){
        return "用法:\n主要命令 android 或 java"/* \n附加选项:\n-exec-task 执行单一任务\n-exec-all 执行全部任务按流程\n-build 构建\n-help"*/;
    }
    
    public static String androidHelp(){
        return "android(builder)";
    }
    
    public static String javaHelp(){
        return "java(builder): project path\n-task 执行任务\n-build 构建";
    }
    
    
    public static String info(){
        return "ApkBuilder是一个在安卓环境下构建APK的工具\n使用Google开源的apksigner zipalign aapt aapt2 aidl dx 版本(28.0.1)等工具\n没有官方支持";
    }
    
    
}
