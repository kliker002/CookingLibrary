package com.cooking.library.cookinglibrary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private better_fragment better_fragment;
    private better_fragment better_fragment1;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private All_Recepts_Fragment all_recepts_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        better_fragment = new better_fragment();
        manager = getSupportFragmentManager();
        all_recepts_fragment = new All_Recepts_Fragment();

        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_lib));


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        manager.beginTransaction().remove(better_fragment).commit();
//        manager.beginTransaction().remove(all_recepts_fragment).commit();

        if (id == R.id.nav_lib) {

            transaction = manager.beginTransaction();

//            transaction.add(R.id.main_fragment, all_recepts_fragment);
            transaction.replace(R.id.main_fragment, all_recepts_fragment);

            transaction.commit();

        }
        else if (id == R.id.nav_gallery) {
            manager.beginTransaction().remove(better_fragment).commit();
            manager.beginTransaction().remove(all_recepts_fragment).commit();
        }
        else if (id == R.id.nav_better) {
            transaction = manager.beginTransaction();

//            transaction.add(R.id.main_fragment,better_fragment);
            transaction.replace(R.id.main_fragment,better_fragment);

            transaction.commit();
        }
        else if (id == R.id.nav_share) {
            manager.beginTransaction().remove(better_fragment).commit();
            manager.beginTransaction().remove(all_recepts_fragment).commit();
        }

        else if (id == R.id.nav_send) {
            manager.beginTransaction().remove(better_fragment).commit();
            manager.beginTransaction().remove(all_recepts_fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // buttons actions:
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.egg_btn:
                if (findViewById(R.id.egg_recept).getVisibility() == View.GONE){
                    findViewById(R.id.egg_recept).setVisibility(View.VISIBLE);
                }else{
                    findViewById(R.id.egg_recept).setVisibility(View.GONE);
                }
                break;
            case R.id.meat_btn:
                if (findViewById(R.id.meat_recept).getVisibility() == View.GONE){
                    findViewById(R.id.meat_recept).setVisibility(View.VISIBLE);
                }else{
                    findViewById(R.id.meat_recept).setVisibility(View.GONE);
                }
                break;
        }
    }
}
