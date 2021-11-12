package com.appicmedia.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.framed.FrameReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AdView extends WebView {
    private String url;
    private String adtype;
    private String adheight;
    private String adwidth;
    private static String adid;
    private static String deviceId;
    private Context ccontext;
    private OkHttpClient client;
    private TypedArray typedArray = null;


    WebView webView;


    
    public AdView(@NonNull Context context) {
        super(context);
        this.client = new OkHttpClient();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public AdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.client = new OkHttpClient();
        this.loadAds(context, attrs);
        this.ccontext = context;



    }

    public AdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.client = new OkHttpClient();
        this.loadAds(context, attrs);
        this.ccontext = context;
    }


    private void loadAds(final Context context, final AttributeSet attrs) {
        inflate(context,R.layout.ad_view_custom,this);
        webView = findViewById(R.id.webview);
        setattributes(attrs);
        this.requestLayout();
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.AdView, 0, 0);
            this.adtype = typedArray.getString(R.styleable.AdView_adstype);
            this.adheight = typedArray.getString(R.styleable.AdView_adsheight);
            this.adwidth = typedArray.getString(R.styleable.AdView_adswidth);
            this.install(this.ccontext, this.adtype, this.adheight, this.adwidth, AdView.adid, AdView.deviceId);
        }
        finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    private void setattributes(AttributeSet attrs) {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) layoutParams).addRule(RelativeLayout.CENTER_HORIZONTAL);
        ((RelativeLayout.LayoutParams) layoutParams).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        webView.setLayoutParams(layoutParams);
    }


    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int parentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        final int parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @SuppressLint("WrongConstant")
    public void install(final Context cnxt, final String adtype, final String adh, final String adw, final String adid, final String did) {
        AdView.this.getSettings().setJavaScriptEnabled(true);
        AdView.this.getSettings().setCacheMode(2);
        AdView.this.getSettings().setLoadWithOverviewMode(true);
        AdView.this.getSettings().setUseWideViewPort(true);
        AdView.this.clearCache(true);
        AdView.this.clearHistory();
        final String html = "<html><head><meta charset= utf-8 ><script async src= https://securepubads.g.doubleclick.net/tag/js/gpt.js ></script><script>window.googletag = window.googletag || {cmd: []};googletag.cmd.push(function() {googletag.defineSlot('/6355419/Travel/Europe/France/Paris', [300, 250], 'banner-ad').addService(googletag.pubads());googletag.enableServices();});</script></head><body><div id= banner-ad  style= width: 300px; height: 250px; ><script>googletag.cmd.push(function() {googletag.display('banner-ad');});</script></div></body></html>";
        AdView.this.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
        AdView.this.setLayerType(1, (Paint)null);
    }


//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.RED);
//    }
}
