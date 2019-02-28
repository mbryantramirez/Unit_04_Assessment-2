package com.example.krishanroy.unit_04_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishanroy.unit_04_assessment.R;

import com.example.krishanroy.unit_04_assessment.SecondActivity;
import com.example.krishanroy.unit_04_assessment.model.Messages;
import com.squareup.picasso.Picasso;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    public static final String ANIMAL_KEY = "animal key";
    public static final String IMAGE_KEY = "image key";
    public static final String WIKI_KEY = "wiki key";
    private TextView textView;
    private ImageView imageView;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.animal_name_text);
        imageView = itemView.findViewById(R.id.animal_image);
    }

    public void onBind(final Messages messages) {
        textView.setText(messages.getAnimal());
        Picasso.get().load(messages.getImage()).into(imageView);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(ANIMAL_KEY, messages.getAnimal());
                intent.putExtra(IMAGE_KEY, messages.getImage());
                intent.putExtra(WIKI_KEY, messages.getWiki());
                v.getContext().startActivity(intent);
            }
        });

    }
}
