package com.blueberry.instagify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private EditText mSearchField;
    ImageButton mSearchBtn;

    private RecyclerView recyclerView;

    SearchTagAdapter adapter;
    DatabaseReference mUserDatabase;


    public static TextView  selectTags;

    Button copySelectedBtn, clearSelectedBtn;

    private List<Tags> hashTagList;
    LottieAnimationView lottieAnimationView;
    TextView noResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Tags");

        lottieAnimationView = findViewById(R.id.lottie);
        selectTags = findViewById(R.id.selectedTags);
        copySelectedBtn = findViewById(R.id.button);
        clearSelectedBtn = findViewById(R.id.button2);

        mSearchField = findViewById(R.id.search_field);
        mSearchBtn =  findViewById(R.id.search_btn);

        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hashTagList = new ArrayList<>();
        adapter =  new SearchTagAdapter(this, hashTagList);
        recyclerView.setAdapter(adapter);
        lottieAnimationView.setVisibility(View.GONE);
        noResult = findViewById(R.id.noresult);
        noResult.setVisibility(View.GONE);

        copySelectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager myClipboard;
                myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myClip;

                String text = selectTags.getText().toString();
                myClip = ClipData.newPlainText("copied", text);
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(SearchActivity.this,"Tags Copied",Toast.LENGTH_LONG).show();

            }
        });

        clearSelectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTags.setText("");

                String searchText = mSearchField.getText().toString();
                if(searchText != ""){
                    firebaseUserSearch(searchText);
                }
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
                Toast.makeText(SearchActivity.this,"Tags cleared",Toast.LENGTH_LONG).show();
            }
        });

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getText().toString();

                if(searchText=="")
                {Toast.makeText(SearchActivity.this,"please enter text",Toast.LENGTH_LONG).show();}
                else {
                    firebaseUserSearch(searchText);
                }

            }
        });


//        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Tags>()
//                .setQuery(mUserDatabase.child("Tags"), Tags.class)
//                .build();
//        adapter = new hashtagAdapter(options, getApplicationContext());
//        recyclerView.setAdapter(adapter);
//        adapter.startListening();

    }

    private void firebaseUserSearch(String searchText)
    {
//        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Tags>()
//                .setQuery(mUserDatabase.child("Tags").orderByChild("hastag").startAt("#" + searchText)
//                .endAt(searchText+"\uf8ff"), Tags.class)
//                .build();
//        // Connecting object of required Adapter class to
//        // the Adapter class itself
//        adapter = new hashtagAdapter(options, getApplicationContext());
//        // Connecting Adapter class with the Recycler view*/
//        recyclerView.setAdapter(adapter);
//        adapter.startListening();
        if (searchText == "")
        {
            Toast.makeText(this, "Please Enter Keyword to Search!", Toast.LENGTH_SHORT).show();
        }else
        {
            mUserDatabase.addListenerForSingleValueEvent(eventListener);
            lottieAnimationView.setVisibility(View.VISIBLE);
        }


    }

    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Boolean found, notfound;
            notfound = true;
            hashTagList.clear();
            String search = mSearchField.getText().toString();
            if (dataSnapshot.exists())
            {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                String movieName = ds.child("movieName").getValue(String.class);
//                found = movieName.contains(search);

                    Tags tags = ds.getValue(Tags.class);
                    String tag = tags.getHastag();
                    found = tag.contains(search);
                    if (found)
                    {
                        notfound= false;
                        lottieAnimationView.setVisibility(View.GONE);
                        hashTagList.add(tags);
                    }

                }
                if (notfound)
                {
                    lottieAnimationView.setVisibility(View.GONE);
                    noResult.setVisibility(View.VISIBLE);
                }
                adapter.notifyDataSetChanged();
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            lottieAnimationView.setVisibility(View.GONE);
        }
    };


    public static void updateTextView(String DataUWantToUpadate) {
        selectTags.setText(DataUWantToUpadate);
    }

    public static String getTextView()
    {
        return selectTags.getText().toString();
    }





}
