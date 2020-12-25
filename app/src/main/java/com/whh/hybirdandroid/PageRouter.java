package com.whh.hybirdandroid;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Map;

/**
 * Created by weihh on 2020/12/9
 * <p>
 **/
public class PageRouter {

    public static final String NATIVE_PERSON_PAGE_URL = "native://PersonPage";
    public static final String NATIVE_MESSAGE_PAGE_URL = "native://MessagePage";

    public static final String FLUTTER_PERSON_PAGE_URL = "flutter://PersonPage";
    public static final String FLUTTER_MESSAGE_PAGE_URL = "flutter://MessagePage";

    public static final String FLUTTER_FRAGMENT_PAGE_URL = "flutterTab://FlutterFragmentPage";

    public static boolean openPageByUrl(Context context, String url, Map params) {
        return openPageByUrl(context, url, params, 0);
    }

    public static boolean openPageByUrl(Context context, String url, Map params, int requestCode) {

        String path = url.split("\\?")[0];

        Log.i("openPageByUrl", path);

        try {
            if (url.startsWith(NATIVE_PERSON_PAGE_URL)) {
                context.startActivity(new Intent(context, PersonActivity.class));
                return true;
            } else if (url.startsWith(NATIVE_MESSAGE_PAGE_URL)) {
                context.startActivity(new Intent(context, MessageActivity.class));
                return true;
            } else if (url.startsWith("flutter://")) {
                Intent intent = new Intent(context, FlutterActivity.class);
                intent.putExtra("url", path);
                context.startActivity(intent);
                return true;
            }

            return false;

        } catch (Throwable t) {
            return false;
        }
    }
}
