package com.ly.avid.twitterdemo;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "UBESZRySevxEhZgPJRB5Z48Hi";
    private static final String TWITTER_SECRET = "0Rjr5L0kG9HBsAmeyVe2ZkPchrFW8imgB6htU00KnrkPnfqRuN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    URL url0 = new URL("https://www.google.com/");
                    Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "test.jpg"));
                    new TweetComposer.Builder(MainActivity.this).text("测试发送").url(url0).image(imageUri).show();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
