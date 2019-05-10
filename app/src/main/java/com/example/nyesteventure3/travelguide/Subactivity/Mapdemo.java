package com.example.nyesteventure3.travelguide.Subactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.nyesteventure3.travelguide.R;

public class Mapdemo extends Fragment {

    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Map");
        View view=inflater.inflate(R.layout.activity_mapdemo1,null,false);
        webView=(WebView)view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.in/maps?source=tldsi&hl=en");
        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        return view;
    }
}
