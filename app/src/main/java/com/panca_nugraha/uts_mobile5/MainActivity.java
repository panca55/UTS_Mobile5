package com.panca_nugraha.uts_mobile5;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnavViewId;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnavViewId = findViewById(R.id.bottomNavViewId);
        frameLayout = findViewById(R.id.frameLayoutId);

        setFragment(new fragmentHome());

        btnavViewId.setOnNavigationItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();

            if (itemId == R.id.HomeId) {
                btnavViewId.setItemBackgroundResource(R.color.colorPrimary);
                setFragment(new fragmentHome());
                return true;
            } else if (itemId == R.id.MenuId) {
                btnavViewId.setItemBackgroundResource(R.color.colorSecondary);
                setFragment(new fragmentMenu());
                return true;
            } else if (itemId == R.id.ProfileId) {
                btnavViewId.setItemBackgroundResource(R.color.colorError);
                setFragment(new ProfileFragment());
                return true;
            } else {
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, fragment);
        fragmentTransaction.commit();
    }
}
