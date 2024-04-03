package com.example.navdraw;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.navdraw.fragment.HomeFragment;
import com.example.navdraw.fragment.ProfileFragment;
import com.example.navdraw.fragment.GuruFragment;
import com.example.navdraw.fragment.SiswaFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showHomePage();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_item1) {
                    showHomePage();
                    getSupportActionBar().setTitle("Home Page");
                } else if (itemId == R.id.menu_item2) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new ProfileFragment())
                            .commit();
                    getSupportActionBar().setTitle("Profile Page");
                } else if (itemId == R.id.menu_item3) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new GuruFragment())
                            .commit();
                    getSupportActionBar().setTitle("Guru Page");
                } else if (itemId == R.id.menu_item4) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new SiswaFragment()   )
                        .commit();
                getSupportActionBar().setTitle("Siswa Page");
            }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new HomeFragment())
                .commit();

        getSupportActionBar().setTitle("Home Page");
    }
}
