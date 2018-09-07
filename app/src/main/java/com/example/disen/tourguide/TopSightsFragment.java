package com.example.disen.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TopSightsFragment extends Fragment {
    View layout;
    Toast toast;


    public TopSightsFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            clickAble(layout);
        } else {
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_top_sights, container, false);
        final ArrayList<MyArrayList> sights = new ArrayList<>();
        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) rootView.findViewById(R.id.toastID));
        sights.add(new MyArrayList(getString(R.string.banco), getString(R.string.banco_info), getString(R.string.abidjan), R.drawable.banco, getString(R.string.banco_webpage), getString(R.string.banco_loc)));
        sights.add(new MyArrayList(getString(R.string.yamoussoukro), getString(R.string.basilique_info), getString(R.string.yamoussoukro), R.drawable.basilique, getString(R.string.basilica_webpage), getString(R.string.basilica_loc)));
        sights.add(new MyArrayList(getString(R.string.comoe), getString(R.string.comoe_info), getString(R.string.bouna), R.drawable.comoe, getString(R.string.comoe_webpage), getString(R.string.comoe_loc)));
        sights.add(new MyArrayList(getString(R.string.tai), getString(R.string.tai_info), getString(R.string.soubre), R.drawable.tai, getString(R.string.tai_webpage), getString(R.string.tai_loc)));
        sights.add(new MyArrayList(getString(R.string.nimba), getString(R.string.nimba_info), getString(R.string.lola), R.drawable.nimba, getString(R.string.nimba_webpage), getString(R.string.nimba_loc)));
        sights.add(new MyArrayList(getString(R.string.mall), getString(R.string.mall_info), getString(R.string.abidjan), R.drawable.mall, getString(R.string.mall_webpage), getString(R.string.mall_loc)));
        sights.add(new MyArrayList(getString(R.string.cathedrale), getString(R.string.cathedrale_info), getString(R.string.abidjan), R.drawable.cathedrale, getString(R.string.cathedral_webpage), getString(R.string.cathedral_loc)));
        sights.add(new MyArrayList(getString(R.string.ehotile), getString(R.string.ehotiles_info), getString(R.string.abby), R.drawable.ehotile, getString(R.string.ehotile_webpage), getString(R.string.ehotile_loc)));
        sights.add(new MyArrayList(getString(R.string.stade), getString(R.string.stade_info), getString(R.string.abidjan), R.drawable.stade, getString(R.string.stade_webpage), getString(R.string.stade_loc)));
        sights.add(new MyArrayList(getString(R.string.pyramide), getString(R.string.pyramide_info), getString(R.string.abidjan), R.drawable.pyramide, getString(R.string.pyramide_webpage), getString(R.string.pyramide_loc)));
        sights.add(new MyArrayList(getString(R.string.plateau), getString(R.string.plateau_info), getString(R.string.abidjan), R.drawable.leplateau, getString(R.string.plateau_webpage), getString(R.string.plateau_loc)));

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(getContext(), sights);
        ListView listView = (ListView) rootView.findViewById(R.id.activity_top_sights);
        listView.setAdapter(myCustomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyArrayList sight = sights.get(position);
                Intent intent = new Intent(getContext(), TopSightsDetailsActivity.class);
                intent.putExtra(getString(R.string.title), sight.getName());
                intent.putExtra(getString(R.string.desc), sight.getDescription());
                intent.putExtra(getString(R.string.location), sight.getLocation());
                intent.putExtra(getString(R.string.image), sight.getImage());
                intent.putExtra(getString(R.string.webpage), sight.getWebpage_url());
                intent.putExtra(getString(R.string.lat_lon), sight.getLat_lon());
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void clickAble(View layout) {
        toast = new Toast(getActivity().getBaseContext());
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,10,20);
        toast.show();
    }

}
