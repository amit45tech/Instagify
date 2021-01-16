package com.blueberry.instagify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class hashtagAdapter extends FirebaseRecyclerAdapter<Tags, hashtagAdapter.hashtagViewholder> {

   private Context context;

    public hashtagAdapter(@NonNull FirebaseRecyclerOptions<Tags> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final hashtagAdapter.hashtagViewholder holder, int position, @NonNull final Tags model) {
        holder.firstname.setText(model.getHastag());
        holder.checked.setVisibility(View.GONE);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(holder.checked.getVisibility() == View.GONE)
                {
                    String tags = SearchActivity.getTextView();

                    holder.unchecked.setVisibility(View.GONE);
                    holder.checked.setVisibility(View.VISIBLE);
//                    holder.hashtagTextSelected.setText(tags + " " + model.getHastag());
                    SearchActivity.updateTextView(tags + " " + model.getHastag());

                }
                else
                {
                    String tags = SearchActivity.getTextView();
                    tags = tags.replace(model.getHastag(), "");
                    SearchActivity.updateTextView(tags);

//                    holder.hashtagTextSelected.setText(tags);
                    holder.unchecked.setVisibility(View.VISIBLE);
                    holder.checked.setVisibility(View.GONE);
                }
            }
        });


    }

    @NonNull
    @Override
    public hashtagAdapter.hashtagViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list, parent, false);
        return new hashtagAdapter.hashtagViewholder(view);
    }



        class hashtagViewholder extends RecyclerView.ViewHolder
        {
            TextView firstname, hashtagTextSelected;

            ImageView checked, unchecked;
            SearchActivity searchActivity;

            public hashtagViewholder(@NonNull View itemView)
            {
                super(itemView);

                firstname = itemView.findViewById(R.id.name_text);
                checked = itemView.findViewById(R.id.checkedbox);
                unchecked = itemView.findViewById(R.id.box);
//                hashtagTextSelected =  ((Activity)context).findViewById(R.id.selectedTags);

            }
        }

}
