package com.heihei.hehe.materalloadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.heihei.hehe.materalloadingview.progress.ProgressView;

public class MainActivity extends AppCompatActivity {

    private ProgressView loadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView = (ProgressView) findViewById(R.id.matral);
    }

    int i;

    public void load(View v){
        loadView.loading(++i % 2 != 0);
    }
}
