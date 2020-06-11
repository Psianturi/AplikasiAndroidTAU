package me.posmajanius.advancemobileprogramming_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import me.posmajanius.advancemobileprogramming_uts.fragment.AboutUsFragment;
import me.posmajanius.advancemobileprogramming_uts.fragment.CoursesFragment;
import me.posmajanius.advancemobileprogramming_uts.fragment.FiturFragment;
import me.posmajanius.advancemobileprogramming_uts.fragment.HomeFragment;
import me.posmajanius.advancemobileprogramming_uts.fragment.LecturerFragment;
import me.posmajanius.advancemobileprogramming_uts.fragment.QuizFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Variable back pressed
    private long backPressedTime;
    private Toast backToast;
    private DrawerLayout drawerLayout;
    private FirebaseAuth mAuth;

    //Fragment
    private HomeFragment homeFragment;

    // Bottom Navigation
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = menuItem -> {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            case R.id.nav_course:
                fragment = new CoursesFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            case R.id.nav_lecture:
                fragment = new LecturerFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;

        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("Kenal TAU");
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //NavigationView navigationView = findViewById(R.id.naView);
        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //homeFragment = new HomeFragment();
        //setFragment(homeFragment);

        NavigationView navigationView = findViewById(R.id.naView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationbar);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

    // onBackPressed untuk exit
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }


    public void displaySelectedListener(int itemId){

        Fragment fragment=null;

        /* switch (itemId){
            case R.id.dashboard:
                fragment=new HomeFragment();
                break;

            case R.id.about_us:
                fragment=new AboutUsFragment();
                break;

        }*/

       /* if (fragment!=null){

            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame,fragment);
            ft.commit();

        }

        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);*/

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
                break;

            case R.id.about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new AboutUsFragment()).commit();
                break;

            case R.id.quiz:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new QuizFragment()).commit();
                break;

            case R.id.fitur:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new FiturFragment()).commit();
                break;

            case R.id.log_out:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START );
        return true;
    }

}
