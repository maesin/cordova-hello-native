package com.mycompany.hello;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/** 独自に追加したアクティビティ. */
public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンによって結果値を変更
                setResult(((Button) v).getText().equals("OK") ? 1 : 0);

                // アクティビティを終了
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAndRemoveTask();
                } else {
                    finish();
                }
            }
        };

        ((Button) findViewById(R.id.ok)).setOnClickListener(buttonClickListener);
        ((Button) findViewById(R.id.ng)).setOnClickListener(buttonClickListener);
    }
}
