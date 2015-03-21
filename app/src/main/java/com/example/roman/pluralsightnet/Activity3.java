package com.example.roman.pluralsightnet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity3 extends ActionBarActivity {

    public TextView getTextView() {
        if(textView == null)
            textView= (TextView) findViewById(R.id.text_for_button_pressed);
        return  textView;
    }

    TextView textView;
    static final String textViewState = "textViewState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        setupView();

        if(savedInstanceState !=null)
            restoreState(savedInstanceState);
    }

    private void restoreState(Bundle savedInstanceState) {
        String text = savedInstanceState.getString(textViewState);
        getTextView().setText(text);
    }

    private void setupView() {
        Button btn1 = (Button) findViewById(R.id.activity3_button1);
        Button btn2 = (Button) findViewById(R.id.activity3_button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButton1Click((Button) v);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onButton2Click((Button) v);
            }
        });
    }


    void onButton1Click(Button button) {
        getTextView().setText("Click 1");
    }

    void onButton2Click(Button button){
        getTextView().setText("Click 2");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        boolean handled = true;

        switch (id)
        {
            case R.id.action_showActivity1:
                onClickMenuShowActivity1(item);
                break;
            case R.id.action_showActivity2:
                onClickMenuShowActivity2(item);
                break;
            case R.id.action_exit:
                onClickMenuShowExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    void onClickMenuShowActivity1(MenuItem item ){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    void onClickMenuShowActivity2(MenuItem item){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    void onClickMenuShowExit(MenuItem item)
    {
        finish();
    }


    //<editor-fold desc="lifecycle">
    @Override
    public void onStart(){
        super.onStart();
        Logger.LogCallBack(this,"onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Logger.LogCallBack(this,"onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.LogCallBack(this, "onSaveInstanceState");

        outState.putString(textViewState,getTextView().getText().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.LogCallBack(this, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.LogCallBack(this, "onDestroy");
    }



    //</editor-fold>
}
