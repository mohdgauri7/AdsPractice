package com.appicmedia.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BannerView extends androidx.appcompat.widget.AppCompatImageView {


    public BannerView(@NonNull Context context) {
        super(context);
        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
    }



}
