package com.sentosh1ne.firechat.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sentosh1ne.firechat.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void setNumberOfUsers() {

    }
}
