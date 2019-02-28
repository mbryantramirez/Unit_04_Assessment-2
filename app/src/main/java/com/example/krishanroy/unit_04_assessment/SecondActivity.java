package com.example.krishanroy.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.krishanroy.unit_04_assessment.fragments.DetailFragment;
import com.example.krishanroy.unit_04_assessment.view.AnimalViewHolder;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra(AnimalViewHolder.ANIMAL_KEY);
        String image = intent.getStringExtra(AnimalViewHolder.IMAGE_KEY);
        String website = intent.getStringExtra(AnimalViewHolder.WIKI_KEY);
        DetailFragment detailFragment = DetailFragment.newInstance(name, image, website);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack("null")
                .commit();
    }

    @Override
    public void onFragmentInteraction(String website) {
        String url = website;
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);


    }

    @Override
    public void getDataFromTheMainActivity(String animalName, String animalImage, String infoWebsite) {

    }
}
