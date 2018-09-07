package com.example.disen.tourguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class Restaurants extends Fragment {
    public Restaurants() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);
        ArrayList<MyArrayList> facts = new ArrayList<>();
        facts.add(new MyArrayList(getString(R.string.saigon),getString(R.string.abidjan),R.drawable.saigon));
        facts.add(new MyArrayList(getString(R.string.gourmand),getString(R.string.abidjan),R.drawable.le_jardin_gourmand));
        facts.add(new MyArrayList(getString(R.string.romaine),getString(R.string.abidjan),R.drawable.la_taverne_romaine));
        facts.add(new MyArrayList(getString(R.string.ambroise),getString(R.string.abidjan),R.drawable.ambroise));
        facts.add(new MyArrayList(getString(R.string.bateau),getString(R.string.abidjan),R.drawable.petit_bateau));
        facts.add(new MyArrayList(getString(R.string.mechoui),getString(R.string.abidjan),R.drawable.mechoui));
        MyCustomAdapter customAdapter = new MyCustomAdapter(getContext(),facts);
        ListView listView = (ListView)rootView.findViewById(R.id.resto);
        listView.setAdapter(customAdapter);
        return rootView;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}

