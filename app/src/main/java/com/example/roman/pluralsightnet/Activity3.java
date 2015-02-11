package com.example.roman.pluralsightnet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Activity3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
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


    void onClickMenuShowActivity1(MenuItem item )
    {
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
