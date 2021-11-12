package com.appicmedia.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Hello extends WebView {



    public Hello(@NonNull Context context) {
        super(context);
    }

    public Hello(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        for (int i=0;i<attrs.getAttributeCount();i++){
            Toast.makeText(context, attrs.getAttributeName(i), Toast.LENGTH_SHORT).show();
        }
        Hello.this.loadUrl("https://github.com/StartApp-SDK/StartApp_InApp_SDK_Example");


    }

    public Hello(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
    }

    public Hello(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
    }

    public Hello(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        Toast.makeText(context, "4", Toast.LENGTH_SHORT).show();
    }

}
