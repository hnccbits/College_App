package bitsindri.hncc.collegeapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.fragments.EmptyFragment;
import bitsindri.hncc.collegeapp.fragments.GoogleMapFragment;

import bitsindri.hncc.collegeapp.fragments.HomeFragment;
import bitsindri.hncc.collegeapp.fragments.MarketplaceFragment;

import bitsindri.hncc.collegeapp.fragments.MenuFragment;
import bitsindri.hncc.collegeapp.fragments.ProfileFragment;
import bitsindri.hncc.collegeapp.fragments.Telephone_Directory;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    private ChipNavigationBar chipNavigationBar;
    int color1=0;
    Class fragmentClass;
    public static Fragment fragment;
    Class startingFragment;

    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth= FirebaseAuth.getInstance();

        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<com.shrikanthravi.customnavigationdrawer2.data.MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Home",R.drawable.news_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Marketplace",R.drawable.feed_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Messages",R.drawable.message_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Navigate",R.drawable.music_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Tel- Directory",R.drawable.music_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Empty Item",R.drawable.music_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("SignOut",R.drawable.ic_action_close));

        sNavigationDrawer.setMenuItemList(menuItems);

        startingFragment= HomeFragment.class;
        fragmentClass =  startingFragment;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }

        sNavigationDrawer.setOnMenuItemClickListener(position -> {
            System.out.println("Position "+position);

            switch (position){
                case 0:{
//                        color1 = ;
                    fragmentClass = HomeFragment.class;
                    break;
                }
                case 1:{
//                        color1 = R.color.orange;
//                        color1= Color.parseColor("#012dda");
                    fragmentClass = MarketplaceFragment.class;
                    break;
                }

                case 2:{
//                        color1 = R.color.blue;
                    //TODO: Implement chat (different channels for first ,second,third & final year students
                    customToast("this feature coming soon...");
                    break;
                }
                case 3:{
//                        color1 = R.color.blue;
                    //fragmentClass = MenuFragment.class;
                    fragmentClass = GoogleMapFragment.class;
                    customToast("navigation");
                    break;
                }
                case 4:{
                    customToast("tel-directory");
                    fragmentClass = Telephone_Directory.class;
                    break;
                }
                case 5:{
                    fragmentClass = EmptyFragment.class;
                    customToast("empty fragment");
                    break;
                }
                case 6:{

                    Auth.signOut();
                    customToast("SignOut Successful");
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    finish();

                }


            }
            sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                @Override
                public void onDrawerOpened() {

                }

                @Override
                public void onDrawerOpening(){

                }

                @Override
                public void onDrawerClosing(){
                    System.out.println("Drawer closed");

                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (fragment != null) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).addToBackStack(null).commit();

                    }
                }

                @Override
                public void onDrawerClosed() {

                }

                @Override
                public void onDrawerStateChanged(int newState) {
                    System.out.println("State "+newState);
                }
            });
        });



//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FoodFragment()).commit();
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                if(id == R.id.home) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FoodFragment()).commit();
//                }else if(id == R.id.marketplace) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MarketplaceFragment()).commit();
//                }
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });


        // setting up chip navigation bar
        chipNavigationBar = findViewById(R.id.bottom_nav_bar);

        chipNavigationBar.setItemSelected(R.id.home, true);

        BottomMenu(); //for handling clicks on chipNavigationBar

        //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FoodFragment()).commit();


    }

    private void BottomMenu(){

        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i){
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.menu:
                    fragment = new MenuFragment();
                    break;
                case R.id.user_profile:
                    fragment = new ProfileFragment();
                    //customToast("user profile coming soon");
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
        });

    }

/**EXIT ALERTDIALOG BOX :*/
    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0)
        {
            final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are you sure want to exit?");
            builder.setCancelable(true);
            builder.setNegativeButton("NO", (dialog, which) -> dialog.cancel());

            builder.setPositiveButton("YES", (dialog, which) -> {
               customToast("see you soon:)");
                finish();
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }

        else {

            super.onBackPressed();
        }
    }

    void customToast(String message)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}