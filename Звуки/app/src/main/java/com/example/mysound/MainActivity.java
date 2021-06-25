package com.example.mysound;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button button2;
    private SoundPool mSoundPool;
    private SoundPool mSoundPool1;
    private int mSoundCollision=1;
    private int mStreamId;
    private int mStreamId1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNewSoundPool() ;
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        mSoundPool.load(this,R.raw.collision,1);
        mSoundPool1.load(this,R.raw.charged,1);
    }
    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.button:
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mStreamId = mSoundPool.play(mSoundCollision,1,1,1,1,1);
        Toast.makeText(getApplicationContext(), "soundPool.play()", Toast.LENGTH_LONG).show();
        break;
    case R.id.button2:
        AudioManager audioManager1 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mStreamId1 = mSoundPool1.play(mSoundCollision,1,1,1,1,1);
        Toast.makeText(getApplicationContext(), "soundPool.play()", Toast.LENGTH_LONG).show();
        break;
}
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) //вызов класса SoundPool.Builder
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
        mSoundPool1 = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }


}