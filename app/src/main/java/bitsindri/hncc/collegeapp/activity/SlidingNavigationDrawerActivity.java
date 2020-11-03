package com.anjali.myjavaapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.anjali.myjavaapplication.Drawer.DrawerAdapter;
import com.anjali.myjavaapplication.Drawer.DrawerItem;
import com.anjali.myjavaapplication.Drawer.SimpleItem;
import com.anjali.myjavaapplication.Drawer.SpaceItems;
import com.anjali.myjavaapplication.R;
import com.anjali.myjavaapplication.fragments.AboutUsFragment;
import com.anjali.myjavaapplication.fragments.DashboardFragment;
import com.anjali.myjavaapplication.fragments.NeraByAidFragment;
import com.anjali.myjavaapplication.fragments.ProfileFragment;
import com.anjali.myjavaapplication.fragments.SettingsFragment;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final  int POS_CLOSE=0;
    private static final  int POS_DASHBOARD=1;
    private static final  int POS_MY_PROFILE=2;
    private static final  int POS_NEARBY_AID=3;
    private static final  int POS_SETTINGS=4;
    private static final  int POS_ABOUT_US=5;
    private static final  int POS_LOGOUT=7;

    //string arrays to pass item name and icon

    private  String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       slidingRootNav = new SlidingRootNavBuilder(this)
               .withDragDistance(180)
               .withRootViewScale(0.75f)
               .withRootViewElevation(25)
               .withToolbarMenuToggle(toolbar)
               .withMenuOpened(false)
               .withContentClickableWhenMenuOpened(false)
               .withSavedState(savedInstanceState)
               .withMenuLayout(R.layout.drawerlayout)
               .inject();

       screenIcons = loadScreenIcon();
       screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_CLOSE),
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_MY_PROFILE),
                createItemFor(POS_NEARBY_AID),
                createItemFor(POS_SETTINGS),
                createItemFor(POS_ABOUT_US),
                new SpaceItems(260),
                createItemFor(POS_LOGOUT)
        ));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);

    }

    private void setToolbarTitle(String title){
        ActionBar ab =  getSupportActionBar();
        ab.setTitle(title);
    }

    //setting color on selected toolbar
    private DrawerItem createItemFor(int position){
        return new SimpleItem(screenIcons[position],screenTitles[position])
                .withIcontint(color(R.color.pink))
                .withTextTint(color(R.color.black))
                .withSelectedIconTint(color(R.color.pink))
                .withSelectedTextTint(color(R.color.pink));
    }

    private  int color(int res){
        return ContextCompat.getColor(this,res);
    }

    private String[] loadScreenTitles() {
        return  getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    private Drawable[] loadScreenIcon() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i=0;i<ta.length();i++){
            int id = ta.getResourceId(i,0);
            if(id!=0){
                icons[i] = ContextCompat.getDrawable(this,id);
            }
        }
        ta.recycle();
        return icons;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(position == POS_DASHBOARD){
            setToolbarTitle("Dashboard Fragment");
            DashboardFragment dashboardFragment = new DashboardFragment();
            transaction.replace(R.id.container,dashboardFragment);
        }
       else if(position == POS_MY_PROFILE){
            setToolbarTitle("Profile Fragment");
            ProfileFragment profileFragment = new ProfileFragment();
            transaction.replace(R.id.container,profileFragment);
        }
       else if(position == POS_NEARBY_AID){
           setToolbarTitle("AID Fragment");
            NeraByAidFragment nearByAidFragment = new NeraByAidFragment();
            transaction.replace(R.id.container,nearByAidFragment);
        }
        else if(position == POS_SETTINGS){
            setToolbarTitle("Settings Fragment");
            SettingsFragment settingsFragment = new SettingsFragment();
            transaction.replace(R.id.container,settingsFragment);
        }
        else if(position == POS_ABOUT_US) {
            setToolbarTitle("Aboutus Fragment");
            AboutUsFragment aboutUsFragment = new AboutUsFragment();
            transaction.replace(R.id.container, aboutUsFragment);
        }
        else if(position == POS_LOGOUT){
        finish();
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }



}