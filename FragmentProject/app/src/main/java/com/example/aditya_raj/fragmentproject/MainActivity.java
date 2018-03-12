package com.example.aditya_raj.fragmentproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button frag1,frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frag1=(Button)findViewById(R.id.frag2);
        frag2=(Button)findViewById(R.id.frag3);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentcontainer,new FragmentOne());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void changefragment(View view) {
           switch (view.getId()){
               case R.id.frag2:
                   FragmentManager fragmentManager1=getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                   fragmentTransaction1.replace(R.id.fragmentcontainer,new FragmentTwo());
                   fragmentTransaction1.commit();
                   fragmentTransaction1.addToBackStack(null);
                    frag1.setVisibility(View.INVISIBLE);
                   break;

               case R.id.frag3:
                   FragmentManager fragmentManager2=getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                   fragmentTransaction2.replace(R.id.fragmentcontainer,new FragmentThree());
                   fragmentTransaction2.commit();
                   fragmentTransaction2.addToBackStack(null);
                   frag2.setVisibility(View.INVISIBLE);
                   break;

           }


    }
}
