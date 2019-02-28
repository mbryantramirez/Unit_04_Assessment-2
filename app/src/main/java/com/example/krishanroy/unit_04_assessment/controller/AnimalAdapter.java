package com.example.krishanroy.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishanroy.unit_04_assessment.model.Messages;
import com.example.krishanroy.unit_04_assessment.view.AnimalViewHolder;
import com.example.krishanroy.unit_04_assessment.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    List<Messages> messagesList;

    public AnimalAdapter(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_itemview, viewGroup, false);
        return new AnimalViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.onBind(messagesList.get(i));

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
}
