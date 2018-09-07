package com.example.disen.tourguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DictionaryFragment extends Fragment {
    AudioManager audioManager;
    MediaPlayer mediaPlayer;


    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN || focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE){
                mediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public DictionaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_dictionary, container, false);
        final ArrayList<MyArrayList> words = new ArrayList<>();
        audioManager = (AudioManager)getContext().getSystemService(getContext().AUDIO_SERVICE);
        words.add(new MyArrayList(getString(R.string.hi),getString(R.string.bonjour),getString(R.string.hi_pronunciation),R.drawable.ic_language_black_48dp, R.raw.bonjour, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.taxi_en),getString(R.string.taxi),getString(R.string.taxi_en_pronunciation),R.drawable.ic_local_taxi_black_48dp, R.raw.taxi, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.phone),getString(R.string.telephone),getString(R.string.phone_pronunciation),R.drawable.ic_phone_black_48dp, R.raw.cabine, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.thanks),getString(R.string.merci),getString(R.string.thanks_pronunciation),R.drawable.ic_language_black_48dp,R.raw.merci, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.welcome),getString(R.string.bienvenue),getString(R.string.welcome_pronunciation),R.drawable.ic_language_black_48dp,R.raw.bienvenue, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.welcome),getString(R.string.akwaba),getString(R.string.welcome_dialect),R.drawable.ic_language_black_48dp,R.raw.akwaba, R.drawable.ic_play_arrow_black_18dp));
        words.add(new MyArrayList(getString(R.string.toilet),getString(R.string.toilettes),getString(R.string.toilet_pronunciation),R.drawable.ic_trending_flat_black_48dp,R.raw.toilettes, R.drawable.ic_play_arrow_black_18dp));
        MyCustomAdapter customAdapter = new MyCustomAdapter(getContext(),words);
        ListView listView = (ListView)rootView.findViewById(R.id.activity_dictionary);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyArrayList word = words.get(position);
                mediaPlayer = MediaPlayer.create(getActivity(),word.getSound());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
        return rootView;
    }
    public void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer = null;
        }
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }
}
