package com.example.voideplays;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView view;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view =(VideoView) findViewById(R.id.VdoView);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Playvideo("http://180.177.248.124:9453/9453.mp4");
                btn.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "播放成功", Toast.LENGTH_SHORT).show();
            }

        });
        view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer arg0) {
                Toast.makeText(MainActivity.this, "播放成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Playvideo(String path)
    {
        if(path!=null)
        {
            view.setVideoURI(Uri.parse(path));
            view.setMediaController(new MediaController(MainActivity.this));
            view.requestFocus();
            view.start();
        }else
        {
            Toast.makeText(MainActivity.this,"播放失敗",Toast.LENGTH_SHORT).show();
        }
    }
}
