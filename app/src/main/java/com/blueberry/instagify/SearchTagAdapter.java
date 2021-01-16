package com.blueberry.instagify;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;

public class SearchTagAdapter extends RecyclerView.Adapter<SearchTagAdapter.ViewHolder>{



    private Context mCtx;
    private List<Tags> listdata;

    public SearchTagAdapter(Context mCtx, List<Tags> listdata) {
        this.mCtx = mCtx;
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.search_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Tags tags = listdata.get(position);
        holder.firstname.setText(tags.hastag);
        holder.checked.setVisibility(View.GONE);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(holder.checked.getVisibility() == View.GONE)
                {
                    String tagss = SearchActivity.getTextView();

                    holder.unchecked.setVisibility(View.GONE);
                    holder.checked.setVisibility(View.VISIBLE);
                    SearchActivity.updateTextView(tagss + " " + tags.hastag);

                }
                else
                {
                    String tagss = SearchActivity.getTextView();
                    tagss = tagss.replace(tags.hastag, "");
                    SearchActivity.updateTextView(tagss);


                    holder.unchecked.setVisibility(View.VISIBLE);
                    holder.checked.setVisibility(View.GONE);
                }
            }
        });


       
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstname, hashtagTextSelected;

        ImageView checked, unchecked;
        SearchActivity searchActivity;

        public ViewHolder(View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.name_text);
            checked = itemView.findViewById(R.id.checkedbox);
            unchecked = itemView.findViewById(R.id.box);

        }
    }
    
    
}
