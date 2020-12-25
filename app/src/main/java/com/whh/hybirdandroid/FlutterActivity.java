package com.whh.hybirdandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.idlefish.flutterboost.containers.FlutterFragment;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class FlutterActivity extends AppCompatActivity {
    private static final String TAG = FlutterActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flutter);

        initPage();
    }

    private void initPage() {
        String url = getIntent().getExtras().getString("url");
        Fragment fragment = new FlutterFragment.NewEngineFragmentBuilder().url(url).build();
        Log.i(TAG,"url:"+url);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, fragment)
                .commit();
    }

}