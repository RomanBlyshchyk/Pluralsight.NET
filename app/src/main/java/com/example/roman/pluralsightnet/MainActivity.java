package com.example.roman.pluralsightnet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    static final int PROVIDE_INFO_CODE = 1000;
    static final int TAKE_PICTURE_CODE = 1010;

    // <editor-fold desc="getters">
    public TextView getSelectionTextView() {
        if(selectionTextView == null)
            selectionTextView = (TextView) findViewById(R.id.textViewSelection);
        return selectionTextView;
    }

    public TextView getFirstNameTextView() {
        if(firstNameTextView == null)
            firstNameTextView = (TextView) findViewById(R.id.textViewFIrst);
        return firstNameTextView;
    }

    public TextView getLastnameTextview() {
        if(lastNameTextView == null)
            lastNameTextView = (TextView) findViewById(R.id.textViewLast);
        return lastNameTextView;
    }

    public ImageView getPicture() {
        if(picture == null)
            picture = (ImageView) findViewById(R.id.imageView);
        return picture;
    }
//</editor-fold>

    TextView selectionTextView;
    TextView firstNameTextView;
    TextView lastNameTextView;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        Button btnInfo = (Button) findViewById(R.id.btnGetInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGetInfoButton((Button) v);
            }
        });

        Button btnTakePic = (Button) findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                handleTakePicButton((Button) v);
            }
        });

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                handleSendButton((Button)v);
            }
        });
    }

    //TODO: fill out handle buttons methods
    private void handleSendButton(Button v) {
        //will handle send button click
    }

    private void handleTakePicButton(Button v) {
        //will handle taking a picture

    }

    private void handleGetInfoButton(Button v) {
        // Will open new activity ProvideInfoActivity
    }

    //TODO: finish basic set up of the activity.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        boolean handled = true;
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (id)
        {
            case R.id.action_showActivity2:
                onClickMenuShowActivity2(item);
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

    void onClickMenuShowActivity2(MenuItem item )
    {
        Intent intent = new Intent(this, MainActivity2.class);
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
