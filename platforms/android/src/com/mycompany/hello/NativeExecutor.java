package com.mycompany.hello;

import android.app.Activity;
import android.content.Intent;

import com.mycompany.cordova.Native;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

/** ネイティブ連携用プラグインの実装. */
public class NativeExecutor implements Native.Executor {

    /** 結果の受信時に利用する遷移先を判別するための要求コード. */
    private static final int SUB_ACTIVITY_REQUEST = 1;

    @Override
    public boolean execute(CordovaPlugin plugin, String action, JSONArray data, CallbackContext callbackContext) {
        if (action.equals("startSubActivity")) {
            // WebView 搭載のメインアクティビティを取得
            Activity activity = plugin.cordova.getActivity();

            // 独自に追加したアクティビティを起動
            activity.startActivityForResult(
                    new Intent(activity, SubActivity.class),
                    SUB_ACTIVITY_REQUEST);

            // 呼び出し元の JS メソッドの処理が成功したことを通知
            callbackContext.success();

            return true;
        }

        return false;
    }

    @Override
    public void onActivityResult(CordovaPlugin plugin, int requestCode, int resultCode, Intent intent) {
        if (requestCode == SUB_ACTIVITY_REQUEST) {
            // 独自に追加したアクティビティの結果である場合
            String message;

            if (resultCode == 0) {
                message = "NG";
            } else {
                message = "OK";
            }

            // あらかじめ用意した受信用の JS メソッドを実行
            String callJs = String.format("javascript:onSubActivityResult('%s')", message);
            plugin.webView.loadUrl(callJs);
        }
    }
}
