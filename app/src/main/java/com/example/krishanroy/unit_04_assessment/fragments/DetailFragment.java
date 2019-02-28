package com.example.krishanroy.unit_04_assessment.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishanroy.unit_04_assessment.R;

public class DetailFragment extends Fragment {

    private static final String NAME_KEY = "param1";
    private static final String IMAGE_KEY = "param2";
    private static final String WIKI_KEY = "param3";
    private String mParam1;
    private String mParam2;
    private String mParam3;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String animalName,
                                             String animalImage,
                                             String animalWikiInfo) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, animalName);
        args.putString(IMAGE_KEY, animalImage);
        args.putString(WIKI_KEY, animalWikiInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(NAME_KEY);
            mParam2 = getArguments().getString(IMAGE_KEY);
            mParam3 = getArguments().getString(WIKI_KEY);
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
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
