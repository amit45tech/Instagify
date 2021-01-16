package com.blueberry.instagify;

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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.CLIPBOARD_SERVICE;

import static androidx.core.content.ContextCompat.getSystemService;


public class MyListAdapter  extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{


    private MyListData[] listdata;


    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.category_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.cItemtextView.setText(listdata[position].getDescription());
        holder.hashtagTextView.setText(listdata[position].getTaglist());

        holder.arrow2.setVisibility(View.GONE);
        holder.hiddenLayout.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(holder.hiddenLayout.getVisibility() == View.GONE)
                {
                    holder.hiddenLayout.setVisibility(View.VISIBLE);
                    holder.arrow2.setVisibility(View.VISIBLE);
                    holder.arrow.setVisibility(View.GONE);
                }
                else
                {
                    holder.arrow.setVisibility(View.VISIBLE);
                    holder.arrow2.setVisibility(View.GONE);
                    holder.hiddenLayout.setVisibility(View.GONE);
                }

            }
        });

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager myClipboard;
                myClipboard = (ClipboardManager) holder.itemView.getContext().getSystemService(CLIPBOARD_SERVICE);
                ClipData myClip;

                String text = holder.hashtagTextView.getText().toString();
                myClip = ClipData.newPlainText("hashtag", text);
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(view.getContext(),"Tags copied!",Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cItemtextView , hashtagTextView;
        public ConstraintLayout hiddenLayout;
        public Button copyBtn;
        public ImageView arrow, arrow2;

        public ViewHolder(View itemView) {
            super(itemView);

            cItemtextView = itemView.findViewById(R.id.textView4);
            hashtagTextView = itemView.findViewById(R.id.textView5);
            hiddenLayout = itemView.findViewById(R.id.hiddenLayout);
            copyBtn =  itemView.findViewById(R.id.copybutton);
            arrow =  itemView.findViewById(R.id.arrow1);
            arrow2 =  itemView.findViewById(R.id.arrow2);

        }
    }




}
