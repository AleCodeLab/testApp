package com.alecodelab.testapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

       switch (id) {

           case R.id.action_settings1 :
               Toast.makeText(this, "Пункт 1", Toast.LENGTH_SHORT).show();
               return true;

             case R.id.action_settings2 :
               Toast.makeText(this, "Пункт 2", Toast.LENGTH_SHORT).show();
                 return true;

             case R.id.action_settings3 :
               Toast.makeText(this, "Пункт 3", Toast.LENGTH_SHORT).show();
                 return true;
      }

return super.onOptionsItemSelected(item);
    }
}
