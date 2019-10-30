package com.example.shop;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edusername;
    private EditText edpassword;
    private EditText edemail;
    private ImageView result;
    private ImageView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edusername = findViewById(R.id.ed_username);
        edpassword = findViewById(R.id.ed_password);
        edemail = findViewById(R.id.ed_email);
        result = findViewById(R.id.result_image);
        result2 = findViewById(R.id.result_image2);
        result.setImageResource(R.drawable.wrong);
        result2.setImageResource(R.drawable.wrong);
        result.setVisibility(View.GONE);
        result2.setVisibility(View.GONE);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
    public void reset(){
        String message = "";
        edusername.setText(message);
        edpassword.setText(message);
        edemail.setText(message);
        result.setImageResource(R.drawable.wrong);
        result2.setImageResource(R.drawable.wrong);
        result.setVisibility(View.GONE);
        result2.setVisibility(View.GONE);
    }
    public void retry(){
        String enter = "";
        edusername.setText(enter);
        edpassword.setText(enter);
    }
    public  void Button(View view){
        result.setImageResource(R.drawable.wrong);
        result2.setImageResource(R.drawable.wrong);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                retry();
            }
        };
            if(edusername.length() < 4 &&edpassword.length() >= 6) {
                result.setVisibility(View.VISIBLE);
                result2.setVisibility(View.GONE);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Wrong!")
                        .setMessage("Please enter again")
                        .setPositiveButton("Ok", listener)
                        .show();
            }else if(edusername.length() >= 4 &&edpassword.length() < 6){
                result.setVisibility(View.GONE);
                result2.setVisibility(View.VISIBLE);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Wrong!")
                        .setMessage("Please enter again")
                        .setPositiveButton("Ok",listener)
                      .show();
            }else if (edusername.length()>=4 &&edpassword.length()>=6){
                result.setVisibility(View.GONE);
                result2.setVisibility(View.GONE);
            }else{
                result.setVisibility(View.VISIBLE);
                result2.setVisibility(View.VISIBLE);
        }

    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
