package com.ly.avid.twitterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.net.MalformedURLException;
import java.net.URL;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "UBESZRySevxEhZgPJRB5Z48Hi";
    private static final String TWITTER_SECRET = "0Rjr5L0kG9HBsAmeyVe2ZkPchrFW8imgB6htU00KnrkPnfqRuN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Crashlytics(), new TwitterCore(authConfig), new Digits.Builder().build());
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    URL url0 = new URL("https://www.baidu.com");
                    new TweetComposer.Builder(MainActivity.this).text("第一次发送").url(url0).show();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
