package com.whh.hybirdandroid;

import android.app.Application;
import android.content.Context;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Platform;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;

import java.util.Map;

import io.flutter.embedding.android.FlutterView;

/**
 * Created by weihh on 2020/12/9
 * <p>
 **/
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        INativeRouter router = (context, url, urlParams, requestCode, exts) -> {
            String assembleUrl = Utils.assembleUrl(url, urlParams);
            PageRouter.openPageByUrl(context, assembleUrl, urlParams);
        };

        FlutterBoost.BoostLifecycleListener boostLifecycleListener = new FlutterBoost.BoostLifecycleListener() {

            @Override
            public void beforeCreateEngine() {
                //
            }

            @Override
            public void onEngineCreated() {
                //
            }

            @Override
            public void onPluginsRegistered() {
                //
            }

            @Override
            public void onEngineDestroy() {
                //
            }

        };

        Platform platform = new FlutterBoost
                .ConfigBuilder(this, router)
                .isDebug(true)
                .whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
                .renderMode(FlutterView.RenderMode.texture)
                .lifecycleListener(boostLifecycleListener)
                .build();
        FlutterBoost.instance().init(platform);
    }
}
