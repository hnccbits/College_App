package bitsindri.hncc.collegeapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
//import androidx.appcompat.view.menu.MenuAdapter;
import bitsindri.hncc.collegeapp.Adapters.MenuAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.menuClass;
import bitsindri.hncc.collegeapp.R;

public class MenuFragment extends Fragment implements MenuAdapter.calluser {

    ArrayList<menuClass> menuListLeft;
    ArrayList<menuClass> menuListRight;
    private RecyclerView recyclerViewLeft;
    private RecyclerView recyclerViewRight;
    MenuAdapter menuAdapterLeft;
    MenuAdapter menuAdapterRight;

    public MenuFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menuListLeft = new ArrayList<>();
        menuListRight = new ArrayList<>();
        setData();
        setRecycler();
    }

    private void setData() {
        menuListLeft.clear();
        menuListLeft.add(new menuClass("Ideas & Projects","Join hands with BIT's Business or Project Ideas, seek mentors and learn from mature Alumni's", R.drawable.image_project));
        menuListLeft.add(new menuClass("Lost & Found","Report missing objects or find something you lost", R.drawable.vector_lost_found));
        menuListLeft.add(new menuClass("Navigate","New in BIT ?\nFind paths across all tags  ", R.drawable.vector_navigate));
        menuListLeft.add(new menuClass("Study Materials","Study material for all branches", R.drawable.vector_study_material));
        menuListLeft.add(new menuClass("Contribute","Interested in maintaining this project? Work with your college to help everyone", R.drawable.vector_contribute));

        menuListRight.clear();
        menuListRight.add(new menuClass("Books","Need help?\nFind a senior who is willing to give away belongings as a motive to reuse products", R.drawable.image_books));
        menuListRight.add(new menuClass("Question Papers","Archive of Question papers from previous years\nAll Branches", R.drawable.image_question_paper));
        menuListRight.add(new menuClass("Order @Canteen","Going from class to canteen? Pre order to save time", R.drawable.vector_food));
        menuListRight.add(new menuClass("Something","Something", R.drawable.settings));
        menuListRight.add(new menuClass("Mentor","Mentor juniors and help the community", R.drawable.vectoe_mentor));
    }

    private void setRecycler() {
        recyclerViewLeft = getActivity().findViewById(R.id.menuRecyclerview_1);
        recyclerViewRight = getActivity().findViewById(R.id.menuRecyclerview_2);
        recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRight.setLayoutManager(new LinearLayoutManager(getContext()));

//        int orientation = getResources().getConfiguration().orientation;
//        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
//        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),2));
//        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        menuAdapterLeft = new MenuAdapter(menuListLeft,this);
        menuAdapterRight = new MenuAdapter(menuListRight,this);
        recyclerViewLeft.setAdapter(menuAdapterLeft);
        recyclerViewRight.setAdapter(menuAdapterRight);
    }


//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),4));
//        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),2));
//        }
//
//    }

    @Override
    public void productDetails(int position) {
        Toast.makeText(getContext(),"position: "+position,Toast.LENGTH_SHORT).show();
        //TO DO ADD TASK
    }
}