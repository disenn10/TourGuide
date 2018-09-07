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


public class FunFactsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public FunFactsFragment() {
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
        View rootView = inflater.inflate(R.layout.activity_fun_facts, container, false);
        ArrayList<MyArrayList> facts = new ArrayList<>();
        facts.add(new MyArrayList(getString(R.string.prev),getString(R.string.previous),getString(R.string.fact1),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.choc),getString(R.string.cocoa),getString(R.string.fact2),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.how_large),getString(R.string.city),getString(R.string.fact3),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.nienokoue_mount),getString(R.string.nienokoue),getString(R.string.fact4),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.oscars),getString(R.string.oscar),getString(R.string.fact5),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.dolphins_what),getString(R.string.dolphins),getString(R.string.fact6),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.no_legs),getString(R.string.lizards),getString(R.string.fact7),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.two_capitals),getString(R.string.capitals),getString(R.string.fact8),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.more_animals),getString(R.string.animals),getString(R.string.fact9),R.drawable.ic_lightbulb_outline_black_24dp));
        facts.add(new MyArrayList(getString(R.string.fashion_here),getString(R.string.fashion),getString(R.string.fact10),R.drawable.ic_lightbulb_outline_black_24dp));
        MyCustomAdapter customAdapter = new MyCustomAdapter(getContext(),facts);
        ListView listView = (ListView)rootView.findViewById(R.id.activity_fun_facts);
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
