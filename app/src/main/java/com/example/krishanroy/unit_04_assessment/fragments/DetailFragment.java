package com.example.krishanroy.unit_04_assessment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishanroy.unit_04_assessment.R;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

    private static final String NAME_KEY = "param1";
    private static final String IMAGE_KEY = "param2";
    private static final String WIKI_KEY = "param3";
    private String website;
    private String animalName;
    private String animalImage;
    private View rootview;
    private ImageView imageView;
    private TextView textView;
    private Button button;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String animalName, String animalImage, String infoWebsite) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, animalName);
        args.putString(IMAGE_KEY, animalImage);
        args.putString(WIKI_KEY, infoWebsite);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(NAME_KEY);
            animalImage = getArguments().getString(IMAGE_KEY);
            website = getArguments().getString(WIKI_KEY);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_detail, container, false);
        imageView = rootview.findViewById(R.id.animal_display_imageView);
        textView = rootview.findViewById(R.id.anima_name_display_textView);
        button = rootview.findViewById(R.id.website_button);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Picasso.get().load(animalImage).into(imageView);
        textView.setText(animalName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(website);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String website);

        void getDataFromTheMainActivity(String animalName, String animalImage, String infoWebsite);
    }
}
