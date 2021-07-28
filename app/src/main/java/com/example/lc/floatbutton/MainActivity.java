package com.example.lc.floatbutton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    FloatWindow dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SpeedDialOverlayLayout mask=findViewById(R.id.mask);
        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.openOrCloseMenu();
            }
        });
        dialog=new FloatWindow(this,1,500, new FloatWindow.IOnItemClicked() {
            @Override
            public void onBackItemClick() {
                Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
                dialog.openOrCloseMenu();
            }

            @Override
            public void onStartClick()
            {
                Log.i("BUTTON_Action", "onStartClick: Start！");
            }

            @Override
            public void onStopClick()
            {
                Log.i("BUTTON_Action", "onStopClick: Stop！");
            }

            @Override
            public void onClose() {
                mask.hide();
            }

            @Override
            public void onExpand() {
                mask.show();
            }
        });
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.show();
            }
        });
        Button textColorBtn= findViewById(R.id.set_text_color);
        textColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
