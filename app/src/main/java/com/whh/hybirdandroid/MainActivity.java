package com.whh.hybirdandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterFragment;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MainActivity extends AppCompatActivity{
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        context = this;

        setListener();
    }

    private void setListener(){
        findViewById(R.id.btn_flutter_person).setOnClickListener(v -> {
            PageRouter.openPageByUrl(context,PageRouter.FLUTTER_PERSON_PAGE_URL,null);
        });

        findViewById(R.id.btn_flutter_message).setOnClickListener(v -> {
            PageRouter.openPageByUrl(context,PageRouter.FLUTTER_MESSAGE_PAGE_URL,null);
        });

        findViewById(R.id.btn_native_person).setOnClickListener(v -> {
            PageRouter.openPageByUrl(context,PageRouter.NATIVE_PERSON_PAGE_URL,null);
        });

        findViewById(R.id.btn_native_message).setOnClickListener(v -> {
            PageRouter.openPageByUrl(context,PageRouter.NATIVE_MESSAGE_PAGE_URL,null);
        });
    }

}