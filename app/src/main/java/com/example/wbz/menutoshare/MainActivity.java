package com.example.wbz.menutoshare;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements RecentsFragment.OnFragmentInteractionListener
            ,FavoritesFragment.OnFragmentInteractionListener,NearbyFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayFragment(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        Fragment chosenFragment = null;

        if(buttonText.equals("Favorites")) {
            chosenFragment = new FavoritesFragment();
        } else if (buttonText.equals("Recents")) {
            chosenFragment = new RecentsFragment();
        } else if (buttonText.equals("Nearby")) {
            chosenFragment = new NearbyFragment();
        }

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.container, chosenFragment);

        transaction.commit();


    }
    public void onFragmentInteraction(Uri uri) {

    }
}
