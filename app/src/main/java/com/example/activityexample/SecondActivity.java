package com.example.activityexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class SecondActivity extends AppCompatActivity {

    String TAG ="ActivityTest-Second";
    Button btnMoveToMain;
    Button btnGetImage;
    ImageView ivImage;
    TextView tvSecondTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");

        btnMoveToMain = findViewById(R.id.btn_main);
        ivImage = findViewById(R.id.iv_image);
        btnGetImage = findViewById(R.id.btn_image);
        tvSecondTitle = findViewById(R.id.tv_second_title);

        Intent newIntent = getIntent();
        tvSecondTitle.setText(newIntent.getCharSequenceExtra(MainActivity.KEY));


        //onClick
        btnMoveToMain.setOnClickListener(view -> {
            //Intent -> msg use to lunch other components
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });


        btnGetImage.setOnClickListener(view -> {
            //implicit intent
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 2234);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        Uri uri = data.getData();

        if (requestCode == 2234 && resultCode == Activity.RESULT_OK){
            ivImage.setImageURI(uri);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    /**
     * The activity is interactive
     * where the user will spend most of their time
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    /**
     * when the activity is no longer int foreground
     * called for transitions
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    /**
     * When the activity is longer visible
     * but still in memory
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    /**
     * is a bundle that save the instance state
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    /**
     * Called when the activity is been freed from memory
     * or when is being recreated
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    /**
     * call the onStart function again
     * (restart the activity from the onStart)
     * only call if Activity is already created
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}