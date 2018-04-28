package com.example.haihesheng.chuckjokes.ui.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.R;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.ui.main.MainActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Hai on 2018-04-04.
 */

public class FavoritesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,FavoritesScreen {
    @Inject
    FavoritesPresenter favoritesPresenter;

    TextView textView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        JokesApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_white_24px));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritesPresenter.deleteJoke();
            }
        });

        textView = (TextView) findViewById(R.id.JokeValue);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button previousBtn = (Button) findViewById(R.id.PreviousBtn);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoritesPresenter.showPreviousJoke();
            }
        });

        Button nextBtn = (Button) findViewById(R.id.NextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoritesPresenter.showNextJoke();
            }
        });

        favoritesPresenter.Initialize();
        //
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

        if (id == R.id.nav_main) {
            Intent intent = new Intent(FavoritesActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_favorites) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        favoritesPresenter.attachScreen(this);
        favoritesPresenter.showNextJoke();
    }

    @Override
    protected void onStop() {
        super.onStop();
        favoritesPresenter.detachScreen();
    }

    @Override
    public void showJoke(final Joke joke) {
        if(joke != null){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(joke.getValue());
                }
            });

        }
    }
}
