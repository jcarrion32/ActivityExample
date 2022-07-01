package com.example.activityexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    static String KEY = "KEY";
    String TAG = "ActivityTest-Main";
    Button btnMoveToSecond;
    TextInputEditText tietDataToMove;

    //Activity Lifecycle
    /**
     * the activity gets created
     * where we connect the vies to the code
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        //Context -> the current state of the application
        //applicationContext, baseContext, context

        btnMoveToSecond = findViewById(R.id.btn_to_second);
        tietDataToMove = findViewById(R.id.tiet_data_to_move);

        //Intent vs Bundle
        //Intent is the msg for other components
        //Bundle store primitive data to transfer


        btnMoveToSecond.setOnClickListener( view -> {
            //Intent -> msg use to lunch other components
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(KEY, tietDataToMove.getText());
            startActivity(intent);
        });

        tietDataToMove.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //length
                btnMoveToSecond.setEnabled(tietDataToMove.getText().length() > 7);
            }
        });
    }

    /**
     * the view is visible, but cannot be interacted with
     */
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