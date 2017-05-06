package com.bizhawkz.listitemdelete;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class websitecall extends AppCompatActivity {
    WebView webView;
    ProgressDialog pb;

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websitecall);

        webView = (WebView) findViewById(R.id.web1);
        dialog = new ProgressDialog(websitecall
                .this);
        dialog.setMessage("Loading, please wait");
        dialog.show();
        dialog.setCancelable(false);
        webView.setWebViewClient(new MyWebViewClient());
        String url = "http://newsite.katarinaphang.com/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:document.getElementById(\"header\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:document.getElementById('navi-wrap').setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('app_img')[0].style.display='none'; })()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('head-inner')[0].style.display='none'; })()");

                pb.dismiss();

            }
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(websitecall.this);
                TextView myMsg = new TextView(websitecall.this);
                myMsg.setText("Mobile Data is off");
                myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                myMsg.setTextSize(20);
                myMsg.setTextColor(Color.BLACK);
                builder.setCustomTitle(myMsg);
                builder.setMessage("Turn on mobile data or use Wi-Fi to access data.");
                builder.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                builder.setNegativeButton("Setting", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        webView.loadUrl(url);

    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    public void onResume(){
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            pb.show();
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
