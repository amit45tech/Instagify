package com.blueberry.instagify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;


public class MainActivity extends AppCompatActivity {

    ImageButton searchBtn,Btn25,Btn27,Btn28,Btn29,Btn30,Btn31,Btn32, shareBtn, donateBtn;
    ImageButton Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,Btn10,Btn11,Btn12,Btn13,Btn14,Btn15,Btn16,Btn17,Btn18,Btn19,Btn20,Btn21,Btn22,Btn23,Btn24;

    ImageView Btn26;

    private String unityGameID = "3868439";
    private Boolean testMode = false;
    private String placementId = "video";
    private String placementId2 = "Interstitial";
    private String placementId1 = "rewardedVideo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final UnityAdsListener myAdsListener = new UnityAdsListener ();
        // Add the listener to the SDK:
        UnityAds.addListener(myAdsListener);
        // Initialize the SDK:
        UnityAds.initialize (this, unityGameID, testMode);


        searchBtn = findViewById(R.id.searchImageBtn);
        shareBtn = findViewById(R.id.share);
        donateBtn = findViewById(R.id.donate);

        Btn1 = findViewById(R.id.imageButton1);
        Btn2 = findViewById(R.id.imageButton2);
        Btn3 = findViewById(R.id.imageButton3);
        Btn4 = findViewById(R.id.imageButton4);
        Btn5 = findViewById(R.id.imageButton5);
        Btn6 = findViewById(R.id.imageButton6);
        Btn7 = findViewById(R.id.imageButton7);
        Btn8 = findViewById(R.id.imageButton8);
        Btn9 = findViewById(R.id.imageButton9);
        Btn10 = findViewById(R.id.imageButton10);
        Btn11 = findViewById(R.id.imageButton11);
        Btn12 = findViewById(R.id.imageButton12);
        Btn13 = findViewById(R.id.imageButton13);
        Btn14 = findViewById(R.id.imageButton14);
        Btn15 = findViewById(R.id.imageButton15);
        Btn16 = findViewById(R.id.imageButton16);
        Btn17 = findViewById(R.id.imageButton17);
        Btn18 = findViewById(R.id.imageButton18);
        Btn19 = findViewById(R.id.imageButton19);
        Btn20 = findViewById(R.id.imageButton20);
        Btn21 = findViewById(R.id.imageButton21);
        Btn22 = findViewById(R.id.imageButton22);
        Btn23 = findViewById(R.id.imageButton23);
        Btn24 = findViewById(R.id.imageButton24);
        Btn25 = findViewById(R.id.imageButton25);
        Btn26 = findViewById(R.id.imageButton26);
        Btn27 = findViewById(R.id.imageButton27);
        Btn28 = findViewById(R.id.imageButton28);
        Btn29 = findViewById(R.id.imageButton29);
        Btn30 = findViewById(R.id.imageButton30);
        Btn31 = findViewById(R.id.imageButton31);
        Btn32 = findViewById(R.id.imageButton32);





        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button1");
                startActivity(intent);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button2");
                startActivity(intent);
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button3");
                startActivity(intent);
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button4");
                startActivity(intent);
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button5");
                startActivity(intent);
            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button6");
                startActivity(intent);
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button7");
                startActivity(intent);
            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button8");
                startActivity(intent);
            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button9");
                startActivity(intent);
            }
        });
        Btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button10");
                startActivity(intent);
            }
        });
        Btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button11");
                startActivity(intent);
            }
        });
        Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button12");
                startActivity(intent);
            }
        });
        Btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button13");
                startActivity(intent);
            }
        });
        Btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button14");
                startActivity(intent);
            }
        });
        Btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button15");
                startActivity(intent);
            }
        });
        Btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button16");
                startActivity(intent);
            }
        });
        Btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button17");
                startActivity(intent);
            }
        });
        Btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button18");
                startActivity(intent);
            }
        });
        Btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button19");
                startActivity(intent);
            }
        });
        Btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button20");
                startActivity(intent);
            }
        });
        Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button21");
                startActivity(intent);
            }
        });
        Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button22");
                startActivity(intent);
            }
        });
        Btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button23");
                startActivity(intent);
            }
        });
        Btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button24");
                startActivity(intent);
            }
        });
        Btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button25");
                startActivity(intent);
            }
        });
        Btn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button26");
                startActivity(intent);
            }
        });
        Btn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button27");
                startActivity(intent);
            }
        });
        Btn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button28");
                startActivity(intent);
            }
        });
        Btn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button29");
                startActivity(intent);
            }
        });
        Btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button30");
                startActivity(intent);
            }
        });
        Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1 ();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button31");
                startActivity(intent);
            }
        });
        Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd1 ();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("buttonClicked", "Button32");
                startActivity(intent);
            }
        });


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisplayInterstitialAd2 ();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2 ();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayInterstitialAd2 ();

                Intent intent = new Intent(MainActivity.this, DonateActivity.class);
                startActivity(intent);
            }
        });

    }

    // Implement a function to display an ad if the Placement is ready:
    public void DisplayInterstitialAd () {

        if (UnityAds.isReady (placementId)) {
            UnityAds.show (this, placementId);

        }

    }
    public void DisplayInterstitialAd1 () {

        if (UnityAds.isReady (placementId1)) {
            UnityAds.show (this, placementId1);

        }

    }

    public void DisplayInterstitialAd2 () {

        if (UnityAds.isReady (placementId2)) {
            UnityAds.show (this, placementId2);

        }

    }

    // Implement the IUnityAdsListener interface methods:
    private class UnityAdsListener implements IUnityAdsListener {

        @Override
        public void onUnityAdsReady (String placementId) {
            // Implement functionality for an ad being ready to show.
        }

        @Override
        public void onUnityAdsStart (String placementId) {
            // Implement functionality for a user starting to watch an ad.
        }

        @Override
        public void onUnityAdsFinish (String placementId, UnityAds.FinishState finishState) {
            // Implement functionality for a user finishing an ad.
        }

        @Override
        public void onUnityAdsError (UnityAds.UnityAdsError error, String message) {
            // Implement functionality for a Unity Ads service error occurring.
        }
    }
}
