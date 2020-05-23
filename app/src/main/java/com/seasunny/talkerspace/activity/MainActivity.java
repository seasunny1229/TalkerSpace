package com.seasunny.talkerspace.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.seasunny.framework.activity.BaseAppActivity;
import com.seasunny.talkerspace.R;

import butterknife.BindArray;
import butterknife.BindView;

public class MainActivity extends BaseAppActivity {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    @BindArray(R.array.arrays_main_fragment_classes)
    String[] fragmentClasses;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init fragments
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for(int i=0;i<mNavigation.getMenu().size();i++){
            MenuItem menuItem = mNavigation.getMenu().getItem(i);
            Fragment fragment = getSupportFragmentManager().getFragmentFactory().instantiate(getClassLoader(), fragmentClasses[i]);
            fragmentTransaction.add(R.id.lay_container, fragment, String.valueOf(menuItem.getItemId()));
            if(i != 0) {
                fragmentTransaction.hide(fragment);
            }
        }
        fragmentTransaction.commitNow();

        // navigation
        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(menuItem.getItemId()));
                for(Fragment target : getSupportFragmentManager().getFragments()){
                    if(target.isVisible()){
                        if(target != fragment){
                            ft.show(fragment);
                            ft.hide(target);
                        }
                    }
                }
                ft.commit();
                return true;
            }
        });
    }

}
