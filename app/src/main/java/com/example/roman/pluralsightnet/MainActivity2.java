package com.example.roman.pluralsightnet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        setupUiEvents();
    }

    void setupUiEvents() {
        Button myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(this);
    }

    void handleButton1Click(Button button){
        TextView txt1 = (TextView) findViewById(R.id.textView3);
        TextView txt2 = (TextView) findViewById(R.id.textView4);

        String temp = (String) txt1.getText();
        txt1.setText(txt2.getText());
        txt2.setText(temp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
            case R.id.action_showActivity3:
                onClickMenuShowActivity3(item);
                break;
            case R.id.action_exit:
                onClickMenuShowExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    void onClickMenuShowActivity1(MenuItem item )
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    void onClickMenuShowActivity3(MenuItem item )
    {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    void onClickMenuShowExit(MenuItem item)
    {
        finish();
    }

    @Override
    public void onClick(View v) {
        handleButton1Click((Button) v);
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
