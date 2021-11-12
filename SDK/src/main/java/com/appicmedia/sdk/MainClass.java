package com.appicmedia.sdk;

import android.content.Context;
import android.widget.Toast;

public class MainClass {
    public static void ToastMethod(Context context, String msg){
        Toast.makeText(context, "Hello "+msg, Toast.LENGTH_SHORT).show();
    }

}
