package com.blueberry.instagify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.UnityBanners;
import com.unity3d.services.banners.view.BannerPosition;

public class Main2Activity extends AppCompatActivity {

    MyListData[] myListData;
    Context mContext;

    TextView mainCategory;

    String unityGameID = "3868439";
    Boolean testMode = false;
    Boolean enableLoad = true;
    String bannerPlacement = "BannerPlacement";
    // Listener for banner events:
    UnityBannerListener bannerListener = new UnityBannerListener();

    // This banner view object will be placed at the bottom of the screen:
    BannerView bottomBanner;
    // View objects to display banners:

    RelativeLayout bottomBannerView;
    // Buttons to show the banners:


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize Unity Ads:
        UnityAds.initialize (this, unityGameID, null, testMode, enableLoad);


        mainCategory = findViewById(R.id.heading);

        String clickedBtn = getIntent().getStringExtra("buttonClicked");

        bottomBanner = new BannerView(this, bannerPlacement, new UnityBannerSize(400, 50));
        bottomBanner.setListener(bannerListener);
        bottomBannerView = findViewById(R.id.bottomBanner);
        bottomBannerView.addView(bottomBanner);
        UnityBanners.setBannerPosition(BannerPosition.BOTTOM_CENTER);
        bottomBanner.load();


        switch (clickedBtn)
        {
            case "Button1":
                mainCategory.setText("Popular");
                 myListData = new MyListData[] {
                         new MyListData("Most Popular 1", "#love #instagood #photooftheday #beautiful #fashion #happy #cute #followme #like4like #follow #me\n" +
                                 "#picoftheday #selfie #instadaily #friends #summer #girl #art #fun #repost #smile #nature #instalike\n" +
                                 "#food #style #tagsforlikes #family #likeforlike\n"),
                         new MyListData("Most Popular 2", "#igers #fitness #nofilter #follow4follow #instamood #amazing #life #travel #beauty #vscocam #sun\n" +
                                 "#bestoftheday #music #followforfollow #beach #instagram #photo #sky #vsco #dog #l4l #sunset #f4f\n" +
                                 "#ootd #pretty #swag #makeup #foodporn #hair #cat\n"),
                         new MyListData("Most Popular 3", "#party #girls #photography #cool #baby #lol #tflers #model #motivation #night #instapic #funny #gym\n" +
                                 "#healthy #yummy #hot #design #black #pink #flowers #christmas #blue #work #instafood #fit #instacool\n" +
                                 "#iphoneonly #wedding #blackandwhite #workout\n"),
                         new MyListData("Most Popular 4", "#lifestyle #handmade #followback #instafollow #home #drawing #my #nyc #webstagram #sweet\n" +
                                 "#instalove #photooftheday #instagood #nofilter #tbt #igers #picoftheday #love #nature #swag\n" +
                                 "#lifeisgood #caseofthemondays #instapic #instadaily #selfie #instamood #bestoftheday"),
                         new MyListData("Most Popular 5", "#gym #baby #instafood #pretty #likeforfollow #lol #party #foodie #cool #memes #fit #healthy #yummy\n" +
                                 "#blackandwhite #explore #home #landscape #sea #holiday #catsofinstagram #pink #christmas #blue\n" +
                                 "#puppy #nails #illustration #london #happiness #tattoo #night"),
                         new MyListData("Most Popular 6", "#instagrammers #igers #instalove #instamood #instagood #followme #follow #comment #shoutout\n" +
                                 "#iphoneography #androidography #filter #filters #hipster #contests #photo #instadaily #igaddict\n" +
                                 "#photooftheday #pics #insta #picoftheday #bestoftheday #instadaily #instafamous #popularpic\n" +
                                 "#popularphoto\n"),
                         new MyListData("Top 1", "#love #instagood #fashion #photooftheday #art #beautiful #photography #happy #follow #cute #nature\n" +
                                 "#tbt #followme #instagram #travel #like4like #style #repost #summer #instadaily #selfie #fitness #food\n" +
                                 "#beauty #girl #friends #fun #instalike #smile #photo"),
                         new MyListData("Top 2", "#life #likeforlike #music #ootd #makeup #follow4follow #amazing #dog #nofilter #model #sunset #beach\n" +
                                 "#design #motivation #foodporn #lifestyle #followforfollow #sky #l4l #f4f #likeforlikes #일상 #cat #hair\n" +
                                 "#dogsofinstagram #artist #bestoftheday #drawing #vscocam #vsco"),
                         new MyListData("Top 3", "#gym #baby #instafood #pretty #likeforfollow #lol #party #foodie #cool #memes #fit #healthy #yummy\n" +
                                 "#blackandwhite #explore #home #landscape #sea #holiday #catsofinstagram #pink #christmas #blue\n" +
                                 "#puppy #nails #illustration #london #happiness #tattoo #night"),
                         new MyListData("Trending 1", "#photooftheday #photography #cute #instagram #repost #me #girl #instalike #photo #music\n" +
                                 "#follow4follow #dog #beach #motivation #followforfollow #tagsforlikes #vscocam #instadaily #style #tbt\n" +
                                 "#follow #beautiful #fashion\n"),
                         new MyListData("Trending 2", "#love #art #happy #nature #travel #summer #food #friends #smile #life #ootd #amazing #model #sun\n" +
                                 "#foodporn #sky #bestoftheday #lifestyle #design #sunset #igers #makeup #likeforlike #family #fun\n" +
                                 "#beauty"),
                         new MyListData("Likes 1", "#instalike #tagsforlikes #like4likes #likeback #likeme #followforlike #follow4like #tagforlikes\n" +
                                 "#chuvadelikes #followshoutoutlikecomment #likeforlikealways #autolike #pleaselike #likes4like\n" +
                                 "#instatags4likes #like4tags #50likes"),
                         new MyListData("Likes 2", "#likeforafollow #likeforshoutout #morningslikethese #40likes #likeforspam #likeforlikeandfollow\n" +
                                 "#likeagirl #likeforfollows #tags4like #likeplease #likesforspam #likemyphoto #likemypic #like4likesback\n" +
                                 "#unlimlikes #vscolike #likemotherlikedaughter #like4likealways #follow4likes\n"),
                         new MyListData("Likes 3", "#likesback #likeforalike #likeforcomment #30likes #ilike #likeitup #instalikesandfollowers4u\n" +
                                 "#girlswholikegirls #followforlikes #like4followers #likephoto #ilikeit #200likes #likeforliketeam\n" +
                                 "#tagsforlikesfslc #likethis #likeforme #tagforlike #likesforlikesback #likeaboss #liketkit #likebackalways\n" +
                                 "#lookslikefilm #like4likeback #likesreturned #likeforfollowers"),
                         new MyListData("Likes 4", "#10likes #l4like #liked #100likes #likeit #likesforfollow #likers #instalikes #likebackteam #likesforlike\n" +
                                 "#tagsforlikesapp #liketeam #likeall #likeforlikeback #likes4likes #likesforlikes #likeforfollow #likeforlike\n" +
                                 "#likeforlikes #likes #20likes #liker #likeforfollowers #lookslikefilm #like4likeback #likesreturned"),
                         new MyListData("Follow 1", "#10likes #l4like #liked #100likes #likeit #likesforfollow #likers #instalikes #likebackteam #likesforlike\n" +
                                 "#tagsforlikesapp #liketeam #likeall #likeforlikeback #likes4likes #likesforlikes #likeforfollow #likeforlike\n" +
                                 "#likeforlikes #likes #20likes #liker #likeforfollowers #lookslikefilm #like4likeback #likesreturned #follow\n" +
                                 "#followme #follow4follow #followforfollow"),
                         new MyListData("Follow 2", "#likesforfollow #followshoutoutlikecomment #followbackalways #f4follow #gayfollow #followplease\n" +
                                 "#gainfollowers #uglyfollowtrain #alwaysfollowback #followmeback #followmefollowyou\n" +
                                 "#followyourdreams #ifollow #like4followers #instafollowers #teachersfollowteachers #ilovemyfollowers\n" +
                                 "#followfollow #pleasefollowme #ifollowback #likeforfollowers #followbackinstantly #followmeto\n" +
                                 "#followmenow #turkishfollowers #followersaktif #followforlikes\n"),
                         new MyListData("Follow 3", "#follow_me #followformore #instalikesandfollowers4u #followersindonesia #followfollowfollow\n" +
                                 "#tambahfollowers #followersinstagram #likeforafollow #likeforlikeandfollow #followerspasif\n" +
                                 "#followyourheart #follow4folow #followtofollow #like4follower #follow4likes #jasatambahfollowers\n" +
                                 "#slimmingworldfollowers #follownow #tagsforfollow #followyou #followgram #likeforfollowback\n" +
                                 "#cashfollowtrain #followstagram #followforspam #followbacknow #followforafollow\n"),
                         new MyListData("Comments", "#comment #comment4comment #c4c #commenter #comments #commenting #love\n" +
                                 "#comments4comments #instagood #commentteam #commentback #commentbackteam\n" +
                                 "#commentbelow #photooftheday #commentall #commentalways #pleasecomment"),

                };
                break;

            case "Button2":
                mainCategory.setText("General");
                 myListData = new MyListData[] {
                         new MyListData("Foodies", "#foodie #food #foodporn #instafood #foodphotography #foodstagram #foodblogger #yummy\n" +
                                 "#foodlover #delicious #foodgasm #homemade #instagood #foodies #foodiesofinstagram #healthyfood\n" +
                                 "#tasty #foodpics #dinner #love #lunch #cooking #dessert #bhfyp #breakfast #yum #chef #healthy\n" +
                                 "#foodblog #bhfyp"),
                         new MyListData("Instagram", "#instagram #instagood #love #like #follow #photography #photooftheday #instadaily #likeforlikes\n" +
                                 "#picoftheday #fashion #beautiful #instalike #bhfyp #me #followforfollowback #likes #smile #art\n" +
                                 "#followme #myself #photo #happy #style #life #likeforfollow #l #nature #insta #bhfyp"),
                         new MyListData("Vintage", "#vintagewatch #vintageclothing #90svintage #vintagewedding #vintagecar #vintagestore #vintagelife\n" +
                                 "#vintagejewelry #kacamatavintage #vintagedress #vintageinspired #vintageforsale #vintagefurniture\n" +
                                 "#vintageaesthetic #vintagehome #vintagegirl #vintagedecor #vintagefashion #vintageshop #vintagecars\n" +
                                 "#vintagelook #vintageclothes #vintagelove #vintagefinds #vintagetoys"),
                         new MyListData("StreetWear", "#streetwearfashion #bestofstreetwear #streetwearbrand #streetwearstyle #streetwearculture #menstreetwear #streetweardaily #mensstreetwear #streetwearaddicted #streetwears #luxurystreetwear #cozystreetwear #menwithstreetwear #streetwearco #streetwearbeast #vintagestreetwear #smartstreetwear #sumstreetwear #classystreetwear #streetwearde"),
                         new MyListData("Festival", "#ultramusicfestival #festivals #portraitfestival #festivalfashion #filmfestival #musicfestival #festivalseason #musicfestivals #festivallife #summerfestival #jazzfestival #festivaloutfit #festivalvibes #edmfestival #beerfestival #festivalwear #psytrancefestival #festivalmakeup"),
                         new MyListData("Yummy", "#yum #yumyum #yummyinmytummy #yummy #yumm #yummm #yummie #yummi #yummyfood #soyummy #yummyeats #yummyyummy #yummylicious #yummmm #yummyy #yummymummies #yummy\uD83D\uDE0B\uD83D\uDE0B #instayummy #yummylunch #yummy\uD83D\uDE0B"),
                         new MyListData("Chocolate", "#chocolat #chocolatelover #chocolatelabrador #whitechocolate #chocolatechipcookies #hechoconamor #bolodechocolate #chocolatechip #chocolatecake #chocolatelab #chocolovers #chocolatelovers #chocolates #chocoholic #darkchocolate #chocolatecoveredstrawberries #hotchocolate #choco"),
                         new MyListData("Bikini", "#bikiniprep #bikinigirl #bikinifitness #bikinilife #npcbikini #bikinimodel #jualbikini #fitnessbikini #bikinicompetitor #bikinis #bikinimurah #bikinibabe #bikinicompetition #npcbikinicompetitor #bikiniset #bikinistyle #ifbbbikini #bikinifiness #bikinisexy #bikinilovers #bikinifashion #bikinipro #bikiniseason #bikinitime #bikinishoot #bikiniathlete"),
                         new MyListData("Selfie", "#selfie #like #me #myself #love #instagood #follow #smile #photooftheday #style #happy #cute #photography #instagram #picoftheday #girl #photo #fashion #life #beautiful #instadaily #art #followme #model #beauty #l #makeup #fun #instalike \n"),
                         new MyListData("Photo", "#photo #photography #photooftheday #instagood #love #instagram #like #picoftheday #art #photographer #follow #beautiful #nature #fashion #me #style #myself #model #happy #smile #photoshoot #likeforlikes #bhfyp #instadaily #beauty #travel #cute #portrait #selfie "),
                         new MyListData("Thought", "#thoughts #love #yourself #quotes #loveyourself #life #instadaily #writer #poetry #writersofinstagram #quoteoftheday #photooftheday #bhfyp #quote #sad #motivation #inspirationalquotes #mindset #words #art #lifestyle #goals #happy #motivational #believe #followforfollowback #positivity #photography #positivevibes"),
                         new MyListData("Music", "#music #love #hiphop #art #musician #rap #musica #singer #instagood #instagram #follow #artist #like #rock #dj #dance #s #guitar #photography #song #life #bhfyp #happy #nature #fashion #live #style #newmusic #party"),
                         new MyListData("Video", "#instavideo #meme #videography #explore #song #dance #explorepage #l #nature #edits #trending #artist #v #beautiful #new #life #insta #bhfyp #repost #cute #instadaily #movie #happy #r #rap #fashion #hiphop #n #o #instalike"),
                         new MyListData("Green", "#green #nature #photography #love #naturephotography #blue #flowers #photooftheday #art #beautiful #instagood #plants #red #garden #summer #instagram #trees #photo #landscape #tree #travel #beauty #sky #naturelovers #yellow #picoftheday #spring #forest #like"),
                         new MyListData("Color", "#green #nature #photography #love #naturephotography #blue #flowers #photooftheday #art #beautiful #instagood #plants #red #garden #summer #instagram #trees #photo #landscape #tree #travel #beauty "),
                         new MyListData("Retro", "#retro #vintage #s #vintagestyle #art #fashion #retrostyle #aesthetic #classic #style #oldschool #nostalgia #love #design #photography #music #nintendo #retrogaming #sfashion #videogames #antique #interiordesign #instagood #vintagefashion #vintageshop #gaming #retroaesthetic #gamer #k"),
                         new MyListData("Joke", "tagssssssss"),
                         new MyListData("Quotes", "tagssssssss"),
                         new MyListData("Fun", "tagssssssss"),
                         new MyListData("Party", "#party #music #love #dj #dance #birthday #wedding #instagood #fun #friends #happy #like #nightlife #photooftheday #partytime #photography #club #event #instagram #follow #fashion #events #hiphop #bhfyp #summer #family #food #happybirthday #techno"),
                         new MyListData("Pizza", "#pizza #food #foodporn #pizzalover #pizzatime #foodie #instafood #delivery #italianfood #pasta #pizzeria #pizzalovers #yummy #foodphotography #foodblogger #foodlover #foodstagram #delicious #pizzaria #love #instagood #dinner #restaurant #cheese #homemade #italy #pizzanapoletana #pizzas #burger"),
                         new MyListData("Bag", "#bag #fashion #bags #handmade #handbag #style #tas #slingbag #shoes #shopping #backpack #totebag #moda #accessories #tasmurah #leather #love #handbags #leatherbag #wallet #like #anta #shoulderbag #taswanita #luxury #ootd #fashionbag #purse #clutch"),
                         new MyListData("Beer", "tagssssssss"),
                         new MyListData("Memes", "#funny #memes #meme #funnymemes #lol #dankmemes #comedy #fun #love #follow #memesdaily #like #instagram #humor #funnyvideos #tiktok #instagood #lmao #dank #cute #jokes #laugh #dailymemes #edgymemes #bhfyp #explorepage #offensivememes #happy #memepage #bhfyp"),
                         new MyListData("Funny", "tagssssssss"),
                         new MyListData("Gaming", "tagssssssss"),
                         new MyListData("Love", "tagssssssss"),
                         new MyListData("Life", "tagssssssss"),
                         new MyListData("Breakup", "tagssssssss"),
                         new MyListData("Friends", "tagssssssss"),
                         new MyListData("Partner", "#partner #love #business #partnership #life #instagram #marketing #happy #couple #friends #k #instagood #liebe #creative #team #partnerincrime #like #follow #couplegoals #family #together #covid #relationship #boyfriend #l #motivation #girlfriend #partners #photography #bhfyp"),
                         new MyListData("Exercise", "#exercise #fitness #workout #gym #motivation #health #fit #fitnessmotivation #training #healthylifestyle #healthy #weightloss #fitfam #bodybuilding #lifestyle #personaltrainer #muscle #gymlife #strong #cardio #gymmotivation #fitspo #instafit #love #sport #instagood #crossfit #diet #fitnessmodel #bhfyp"),
                         new MyListData("Tired", "#tired #love #sleepy #sleep #cute #instagood #sad #bored #goodnight #dog #photooftheday #bed #happy #selfie #me #night #dogsofinstagram #life #home #exhausted #instagram #art #like #dark #broken #work #myself #mood #smile #bhfyp"),
                         new MyListData("Hungry", "#hungry #food #foodporn #foodie #yummy #instafood #delicious #tasty #eat #foodgasm #foodpics #yum #instagood #dinner #foodstagram #foodphotography #lunch #eating #foodpic #foodlover #delish #foodblogger #breakfast #foods #fresh #photooftheday #homemade #sweet #amazing #bhfyp")

                };
                break;

            case "Button3":
                mainCategory.setText("Common");
                 myListData = new MyListData[] {
                         new MyListData("Gardening", "#DIY #floral #florist#flower#flowers #food #garden #gardening #gardens #green #growyourown #herbs #home #horticulture #inspiration #landscaping #love#nature #organic #outdoors #photography #plants #rose #roses #sky #spring #summer #sun #sunset #vegetables #wedding"),
                         new MyListData("Luxury", "#luxury #luxurylifestyle #fashion #design #style #lifestyle #love #interiordesign #travel #instagood #realestate #architecture #home #luxurylife #art #homedecor #cars #interior #like #luxuryhomes #handmade #photography #beauty #beautiful #designer #instagram #luxurycars #car #follow #bhfyp"),
                         new MyListData("Interior", "#interiorinspiration #interiorlovers #interiorstylist #designinterior #interiorstyling #interiordecoration #interiorwarrior #interiorismo #interiorinspo #interiorideas #interior123 #interior2you #interiordecor #interior_and_living #interiordesigner #interiorstyle #luxuryinteriors #interiorarchitecture #interior4all #interiordetails #interior_design #interiores #interiordecorating #designerdeinteriores"),
                         new MyListData("Drive", "tagssssssss"),
                         new MyListData("Tour", "tagssssssss"),
                         new MyListData("Architecture", "#architectureporn #lookingup_architecture #architectures #modernarchitecture #jj_architecture #instaarchitecture #architecture_hunter #architecturestudent #architecturelover #interiorarchitecture #architecturedesign #landscapearchitecture #architecture_greatshots #skyscraping_architecture #architecturephoto #icu_architecture #architecturevisualization #urbanarchitecture #architecture_minimal #architectureschool #ic_architecture #creative_architecture #architectureandpeople #architecturedetails #architecture_best #architecture_london #sustainablearchitecture #contemporaryarchitecture #gothicarchitecture #australianarchitecture"),
                         new MyListData("Building", "#building #architecture #construction #design #photography #interiordesign #city #home #architecturephotography #art #architecturelovers #travel #architect #house #photooftheday #buildings #archilovers #instagood #interior #arquitectura #sky #realestate #engineering #renovation #urban #concrete #street #landscape #ig #bhfyp"),
                         new MyListData("Old", "tagssssssss"),
                         new MyListData("New", "tagssssssss"),
                         new MyListData("Latest", "#latest #trending #fashion #new #instagram #news #love #india #follow #bollywood #instagood #memes #like #style #trend #followforfollowback #latestfashion #kerala #onlineshopping #trendy #likeforlikes #picoftheday #photography #beautiful #top #tiktok #design #funny #insta #bhfyp"),
                         new MyListData("Craft", "#craft #handmade #art #diy #crafts #design #crafting #love #artist #craftbeer #handcrafted #homedecor #gift #creative #beer #crochet #crafty #handmadewithlove #fashion #papercraft #artwork #homemade #smallbusiness #kerajinantangan #etsy #wood #giftideas #interiordesign #handcraft #bhfyp"),
                         new MyListData("Lovely", "#lovely #love #l #like #follow #cute #life #smile #beautiful #style #me #myself #instadaily #followme #fun #selfie #instamood #pic #mylife #looks #instapicture #self #igers #pose #instaselfie #igdaily #onlyme #myway #instagood #bhfyp"),
                         new MyListData("Gifts", "tagssssssss"),
                         new MyListData("Mature", "tagssssssss"),
                         new MyListData("Lonely", "#lonely #love #sad #alone #broken #depression #quotes #depressed #life #anxiety #sadness #like #feelings #follow #brokenheart #sadedits #instagram #pain #heartbroken #photography #lovequotes #art #loneliness #mood #music #heart #poetry #sadquotes #lonelyquotes #bhfyp"),
                         new MyListData("Covid", "#covid #coronavirus #corona #stayhome #quarantine #love #staysafe #lockdown #virus #socialdistancing #d #instagood #bhfyp #stayathome #instagram #like #pandemic #dirumahaja #cov #art #follow #health #india #a #photography #o #memes #quedateencasa #life #bhfyp"),
                         new MyListData("Hospital", "#hospital #covid #doctor #medical #nurse #medicine #health #healthcare #coronavirus #doctors #medicina #surgery #medico #nurselife #salud #o #nursing #nurses #surgeon #medstudent #a #clinica #enfermagem #corona #saude #love #hospitallife #m #medicalstudent #bhfyp"),
                         new MyListData("Canteen", "#canteen #food #college #cafe #lunch #collegelife #student #ner #instagood #hatd #forcemteknik #kitchen #restaurants #foodlover #love #anahtarteslimproje #bygozsuz #kayseri #diamond #hospital #friends #school #proje #niversitesi #erciyes #instafood #girls #restaurant #dobruchut #bhfyp"),
                         new MyListData("Library", "#library #books #bookstagram #book #reading #booklover #bookworm #read #librariesofinstagram #librarylife #literature #bookshelf #bibliophile #instabook #libraries #bookaddict #bookish #reader #art #love #bookstagrammer #booknerd #librarylove #instagood #booksofinstagram #bookaholic #booklovers #biblioteca #author #bhfyp"),
                         new MyListData("Hostel", "#hostel #hostellife #hostelworld #travel #hotel #backpacker #hostels #backpackers #travelgram #backpacking #airbnb #o #wanderlust #guesthouse #college #memes #turismo #nature #besthostel #trip #hostelfun #solotravel #tourism #collegelife #hospedagem #vacation #thailand #instatravel #holiday #bhfyp"),
                         new MyListData("Gangs", "#gang #rap #hiphop #trap #music #love #gangster #explorepage #like #follow #instagram #explore #art #gangsta #rapper #memes #life #instagood #ganggang #mafia #photography #am #viral #likeforlikes #friends #gta #s #gangshit #followforfollowback #bhfyp"),
                         new MyListData("Hotel", "#hotel #travel #restaurant #hotels #holiday #vacation #love #resort #interiordesign #luxury #design #hospitality #food #instagood #hotellife #architecture #photography #summer #relax #travelgram #nature #spa #cafe #beach #like #tourism #luxuryhotel #bar #turismo #bhfyp"),
                         new MyListData("College", "tagssssssss"),
                         new MyListData("Crush", "tagssssssss"),
                         new MyListData("School", "tagssssssss"),
                         new MyListData("Fever", "#sick #love #covid #coronavirus #corona #art #music #health #virus #follow #life #dope #like #mtb #cool #repost #flu #quarantine #instagram #fire #instagood #photography #bike #memes #sickness #sad #hospital #clean #downhill #fever "),
                         new MyListData("Engineer", "#engineer #engineering #technology #construction #civilengineering #engineers #mechanicalengineering #architecture #civil #memes #design #engineeringlife #engineeringmemes #civilengineer #tech #mechanical #science #engineeringstudent #electricalengineering #producer #electrical #manufacturing #innovation #electronics #engenharia #robotics #automation #building #o #bhfyp"),
                         new MyListData("Doctor", "#doctor #medicine #medical #nurse #health #hospital #covid #doctors #healthcare #surgery #medico #coronavirus #neet #medstudent #medicalstudent #surgeon #medschool #mbbs #love #dentist #medicina #physician #corona #medicalschool #medlife #futuredoctor #dr #anatomy #healthy #bhfyp"),
                         new MyListData("Confused", "tagssssssss"),
                         new MyListData("Trip", "#trip #travel #nature #travelphotography #photography #travelgram #instatravel #photooftheday #instagood #vacation #love #traveling #holiday #travelling #adventure #wanderlust #landscape #travelblogger #tourism #summer #picoftheday #beautiful #photo #instagram #explore #beach #traveler #naturephotography #like #bhfyp"),
                         new MyListData("Sun", "#sun #summer #nature #sunset #love #photography #sky #beach #sea #photooftheday #instagood #travel #beautiful #picoftheday #photo #happy #like #clouds #landscape #instagram #sunshine #sunrise #follow #naturephotography #me #fun #life #spring #smile #bhfyp"),
                         new MyListData("Night", "#night #love #photography #nightphotography #photooftheday #instagood #nature #like #sky #photo #instagram #art #music #moon #follow #beautiful #party #light #picoftheday #sunset #life #summer #travel #nightlife #happy #friends #me #dark #city #bhfyp"),
                         new MyListData("Bunk", "#bunk #followbunk #squirrel #blessed #bunkaboo #easterngreysquirrel #theboo #dailyvideos #instalike #wildanimal #mrbunk #follow #photooftheday #squirrelsofinstagram #petsofinstagram #wildlife #picofthedayt #happysquirrel #instapic #animal #pet #smile #college #cutefun #petphotography #wildanimmal #funnyvideos #petofinstagramvideos #smilingsquirrelpics #bhfyp"),
                         new MyListData("Morning", "#morning #love #goodmorning #nature #photography #sunrise #instagood #instagram #breakfast #photooftheday #coffee #beautiful #sky #like #follow #life #happy #picoftheday #sun #travel #photo #motivation #morningmotivation #naturephotography #morningvibes #instadaily #summer #landscape #likeforlikes #bhfyp"),
                         new MyListData("Ceremony", "#ceremony #wedding #bride #love #weddingday #groom #weddingdress #marriage #celebration #party #together #bridesmaids #weddingparty #instawedding #happy #romance #family #flowers #forever #weddingcake #celebrate #happiness #weddinggown #smiles #unforgettable #instawed #weddingphotography #weddings #weddingceremony #bhfyp")


                };
                break;

            case "Button4":
                mainCategory.setText("Hobbies");
                myListData = new MyListData[] {
                        new MyListData("Hobby", "#hobbies #hobby #art #toys #photography #love #fun #nature #diecast #hotwheels #diy #collection #handmade #aquarium #crafts #painting #covid #instagood #instagram #drawing #passion #rc #quarantine #artist #stayhome #craft #scale #kids #family #bhfyp"),
                        new MyListData("Reading", "#reading #bookstagram #books #book #booklover #bookworm #read #bookish #booknerd #bookaddict #bibliophile #bookstagrammer #instabook #love #reader #readersofinstagram #booksofinstagram #bookaholic #readingtime #bookshelf #writing #booklove #literature #bookphotography #b #instabooks #booksbooksbooks #igreads #bookblogger #bhfyp"),
                        new MyListData("Writing", "#writing #writer #writersofinstagram #poetry #writingcommunity #love #words #quotes #thoughts #poem #poetrycommunity #writerscommunity #writers #poetsofinstagram #art #poet #poems #shayari #writersofig #instadaily #loveyourself #life #followforfollowback #bhfyp #sad #likes #photooftheday #story #yourself #bhfyp"),
                        new MyListData("Acting", "#acting #actor #actress #actorslife #film #theatre #actors #tiktok #love #movie #art #comedy #model #cinema #drama #casting #bollywood #photography #movies #artist #hollywood #theater #music #instagram #tv #singing #director #instagood #dance #bhfyp"),
                        new MyListData("Singing", "#singing #music #singer #sing #cover #song #musician #love #vocals #coversong #singers #guitar #voice #singingcover #vocalist #artist #singersongwriter #songs #instamusic #talent #instagood #dancing #piano #instagram #songwriter #dance #acoustic #singersofinstagram #musicvideo #bhfyp"),
                        new MyListData("Dancing", "#dancing #dance #dancer #dancers #music #dancelife #love #hiphop #choreography #ballet #fun #dancersofinstagram #instadance #party #art #dancevideo #instagood #tiktok #singing #dancechallenge #explorepage #like #a #instagram #fitness #photography #dan #salsa #dancefloor #bhfyp"),
                        new MyListData("Painting", "#painting #art #artist #drawing #artwork #paint #artistsoninstagram #illustration #contemporaryart #sketch #instaart #watercolor #artoftheday #arte #draw #acrylicpainting #digitalart #love #abstractart #design #portrait #paintings #oilpainting #artgallery #photography #fineart #painter #creative #modernart #bhfyp"),
                        new MyListData("Sketching", "#sketching #sketch #art #drawing #sketchbook #artist #draw #artwork #illustration #artistsoninstagram #sketches #drawings #painting #pencildrawing #artoftheday #instaart #pencil #digitalart #doodle #pencilsketch #portrait #fanart #design #arts #watercolor #illustrator #drawingsketch #daily #pencilart #bhfyp"),
                        new MyListData("Sports", "#sports #football #sport #fitness #basketball #nfl #nba #training #soccer #gym #workout #baseball #athlete #motivation #follow #love #instagood #mlb #instagram #fit #photography #fun #like #running #life #hockey #fitnessmotivation #nike #espn #bhfyp"),
                        new MyListData("Cooking", "#cooking #food #foodporn #foodie #instafood #homemade #yummy #foodphotography #foodstagram #delicious #foodblogger #chef #foodlover #cook #dinner #healthyfood #tasty #instagood #homecooking #love #kitchen #baking #eat #lunch #healthy #foodgasm #foodies #cookingathome #cheflife #bhfyp"),
                        new MyListData("Hiking", "#hiking #nature #mountains #adventure #travel #naturephotography #landscape #outdoors #trekking #hikingadventures #photography #wanderlust #hike #explore #outdoor #camping #mountain #naturelovers #landscapephotography #travelphotography #photooftheday #forest #wandern #ig #getoutside #love #instagood #travelgram #naturelover #bhfyp"),
                        new MyListData("Camping", "#camping #nature #adventure #travel #hiking #x #outdoors #outdoor #campinglife #camp #camper #explore #offroad #trekking #photography #mountains #vanlife #bushcraft #glamping #roadtrip #fishing #wanderlust #naturephotography #campervan #survival #summer #a #love #overland #bhfyp"),
                        new MyListData("Fishing", "#fishing #fish #fishinglife #bassfishing #catchandrelease #nature #outdoors #bass #carpfishing #pesca #angler #fishingislife #carp #flyfishing #largemouthbass #fisherman #trout #fishingtrip #bigfish #saltwaterfishing #shimano #photography #hunting #pike #fishingaddict #angling #fishon #troutfishing #kayakfishing #bhfyp"),
                        new MyListData("Archery", "#archery #bowhunting #archerylife #hunting #archer #bow #traditionalarchery #panahan #bowhunter #outdoors #arrow #deerhunting #horsebow #archeryhunting #whitetail #deer #panahanindonesia #archeryaddict #hunt #archerypractice #worldarchery #hunter #bowandarrow #memanah #recurvebow #darchery #archeryseason #longbow #whatgetsyououtdoors #bhfyp"),
                        new MyListData("Parkour", "#parkour #freerunning #flips #tricking #parkourlife #life #flip #freerun #backflip #gymnastics #training #parkourtraining #fitness #pkfr #trampoline #pk #jump #gym #frontflip #parkourfreerun #workout #movement #flipping #parkourculture #tumbling #sport #flippingfeed #parkourfail #run #bhfyp"),
                        new MyListData("Biking", "#biking #cycling #bike #mtb #bikelife #mountainbike #cyclinglife #mountainbiking #mtblife #nature #bikes #bicycle #downhill #cyclingphotos #cyclist #cycle #ride #hiking #roadbike #fitness #running #bikeride #enduro #strava #adventure #mtblove #ciclismo #biker #travel #bhfyp"),
                        new MyListData("Sewing", "#sewing #n #handmade #sew #diy #sewingproject #fashion #hen #fabric #quilting #henf #couture #sewingaddict #cklich #embroidery #henmachtgl #sewinglove #sewersofinstagram #memade #handmadewithlove #isew #design #sewsewsew #sewistsofinstagram #sewingforkids #makersgonnamake #sewingmachine #craft #art #bhfyp"),
                        new MyListData("Drawing", "#drawing #art #artist #sketch #illustration #draw #artwork #digitalart #painting #artistsoninstagram #fanart #sketchbook #drawings #instaart #anime #love #portrait #arte #artoftheday #design #sketching #doodle #pencildrawing #pencil #digitaldrawing #photography #instagram #instagood #ink #bhfyp"),
                        new MyListData("Origami", "#origami #origamiart #paperart #handmade #art #paper #paperfolding #papercraft #origamilove #diy #origamipaper #papiroflexia #papercrafts #origamiartist #instaorigami #origamilovers #craft #origamiwork #d #love #modularorigami #kusudama #paperartist #folding #paperfold #design #origamis #artist #origamifun #bhfyp"),
                        new MyListData("Photography", "#photography #photooftheday #love #instagood #instagram #photo #like #nature #picoftheday #follow #photographer #beautiful #fashion #art #bhfyp #likeforlikes #travel #instadaily #me #photoshoot #model #smile #myself #naturephotography #style #happy #instalike #portrait #followme #bhfyp"),
                        new MyListData("Calligraphy", "#calligraphy #lettering #art #handlettering #moderncalligraphy #calligraphyart #typography #brushlettering #calligraphylettering #artist #handwriting #handmade #calligrapher #design #artwork #love #calligraphymasters #letters #calligraphypractice #watercolor #letteringart #drawing #calligraphylove #painting #bulletjournal #handlettered #arabiccalligraphy #kaligrafi #brushpen #bhfyp"),
                        new MyListData("Knitting", "#knitting #knittersofinstagram #handmade #knit #crochet #yarn #knittingaddict #knitstagram #knittinglove #rg #instaknit #stricken #wool #yarnlove #tricot #yarnaddict #crochetersofinstagram #knitter #knitwear #i #knittersoftheworld #strikk #knittersgonnaknit #knittinginspiration #knitters #handknit #nevernotknitting #crocheting #diy #bhfyp"),
                        new MyListData("Modeling", "#modeling #model #photography #fashion #photoshoot #photooftheday #instagram #instagood #love #style #portrait #photographer #photo #beauty #like #follow #picoftheday #beautiful #art #modellife #makeup #likeforlikes #cute #fashionblogger #me #portraitphotography #myself #fitness #girl #bhfyp"),

                };
                break;

            case "Button5":
                mainCategory.setText("Animals & Pets");
                myListData = new MyListData[] {
                        new MyListData("Animals", "#animalkingdom #animalrights #animallove #animallover #animalelite #animalsofinstagram #buzzfeedanimals #wildanimals #animalsco #cuteanimals #animalart #animalcrossingnewhorizons #loveanimals #animalplanet #animalphotography #splendid_animals #animalcrossing #animales #animali #animalprint #animaladdicts #animalovers #veganfortheanimals #animal_captures #funnyanimals #spiritanimal #animalrescue"),
                        new MyListData("Pets", "#petsgram #peterpan #petlife #peterparker #petty #bonappetit #dompetpria #dompet #dompetmurah #takipetanindakazan #petlover #petshop #petal #petoftheday #petals #stpetersburg #appetizers #petalingjaya #pets_of_instagram #zepetophoto #dompetcewek"),
                        new MyListData("Puppy 1", "#pups #instapup #goldenpuppy #nationalpuppyday #cockerspanielpuppy #puppysofinstagram #pugpuppy #huskypuppy #pomeranianpuppy #dachshundpuppy #sleepypuppy #pitbullpuppies #pitbullpuppy #gsdpuppy #goldenretrieverpuppy"),
                        new MyListData("Puppy 2", "#popupshop #puppylife #cutepuppies #puppygram #pupsofinstagram #puppiesofig #popup #puppyeyes #pupper #corgipuppy #cutepuppy #germanshepherdpuppy #puppydog #frenchiepuppy #lovepuppies #pupstagram #puppyoftheday #happypuppy"),
                        new MyListData("Cats", "#catsofig #caturday #cutecat #catsofinsta #blackcat #excellent_cats #santacatarina #catgram #catalonia #instacat_meows #familyvacation #blackcats #cathedral #igerscatalunya #whitecat #dedicated #summervacation #instacats #catsoninstagram #italiainunoscatto #lovecat #blackcatsofinstagram #cateyes #catania"),
                        new MyListData("Horses", "#horses #horse #horsesofinstagram #horseshow #horseshoe #horses_of_instagram #horsestagram #instahorses #wild #mane #instagood #grass #field #farm #nature #pony #ponies #ilovemyhorse #babyhorse #beautiful #pretty #photooftheday #gallop #jockey #rider #riders #riding"),
                        new MyListData("Fish", "#carpfishing #fishinglife #kayakfishing #fishingtrip #bassfishing #fishingdaily #fisherman #bigfish #saltwaterfishing #fishingislife #spearfishing #fisheyelemag #tropicalfish #starfish #777luckyfish #instafish #flyfishing #selfish #fishon #icefishing #fishtank #catfish #redfish #troutfishing #fisheye #bettafish"),
                        new MyListData("Insects", "#creature #instanature #lovenature #nature_shooters #wildlife #animals #insect #instagood #earth #insectlife #bug #insectlicious #insectphotography #insect_perfection #insectworld #nature #insects #insectagram #macro #closeup #bugs #creatures #macrophotography #macrogardener #naturelover #animals #photooftheday #bugslife #insectsofinstagram #insect_addicts"),
                        new MyListData("Piggy", "tagssssssss"),
                        new MyListData("Doggy", "tagssssssss"),

                };
                break;

            case "Button6":
                mainCategory.setText("Fitness & Sports");
                myListData = new MyListData[] {
                        new MyListData("Fitness 1", "#health #fitness #fit #fitnessmodel #fitnessaddict #fitspo #workout #bodybuilding #cardio #gym #train #training #photooftheday #health #healthy #instahealth #healthychoices #active #strong #motivation #instagood #determination #lifestyle #diet #getfit #cleaneating #eatclean #exercise"),
                        new MyListData("BodyBuilding 1", "#instafit #motivation #fit #fitness #gymlife #pushpullgrind #grindout #flex #instafitness #gym #trainhard #eatclean #grow #focus #dedication #strength #ripped #swole #fitnessgear #muscle #shredded #squat #bigbench #cardio #sweat #grind #lifestyle #pushpullgrind"),
                        new MyListData("Gym 1", "#gymfreak #gymrat #lifestyle #getafterit #gymflow #lifting #healthy #gymtime #like #exercise #workout #eatclean #gym #follow #motivation #gymlife #training #inspo #strengthtraining #love #gymgirl #strength #athlete #gymaddict #fit #gymwear #gymmotivation #gymnastics #cardio #fitness"),
                        new MyListData("BodyBuilding 2", "#bodybuilding #bodybuildingmotivation #bodybuildinglifestyle #bodybuildingcom #bodybuildingnation #bodybuildinglife #igbodybuilding #powerbodybuilding #bodybuildingwomen #bodybuildingfood #bodybuildingaddict #indianbodybuilding #functionalbodybuilding #bodybuildingproblems #bodybuildinglifesyle #bodybuildinginspiration #bodybuildingmeal #bodybuildingdotcom #bodybuildinggirl #bodybuildingcoach #bodybuilding_and_fitness_ #bodybuildinglatino #bodybuildingmeme #bodybuildingstyle #bodybuildingmemes"),
                        new MyListData("Gym 2", "#gymmotivation #goldsgym #gymshark #gymaddict #gymsharkwomen #gymfreak #gymnastics #gymwear #gymflow #gymaholic #gymjunkie #gymmemes #gymlove #gymnast #gymfit #gymtime #edgymemes #edgymeme #gymrat #gymgirl #gymselfie #instagym #gymnastic #gymlover #gymrats #gym\uD83D\uDCAA #gymgirls"),
                        new MyListData("Fitness 2", "#fitnessgirl #fitnessgoals #fitnessaddict #fitnessjourney #fitnesslife #fitnessbody #fitnesswomen #fitnessmom #fitnessbikini #fitnessfreak #fitnesslover #fitnessfood #fitnessgear #fitnesscoach #mensfitness #vidafitness #planetfitness #fitnessfreaks #fitnessblogger #groupfitness #postpartumfitness #fitnessmodels #fitnesslifestyle #gayfitness #fitnessmodel #instafitness #fitnesstips #fitnessboy #fitnessfirst"),
                        new MyListData("Motivation", "#motivationalquotes #motivationalspeaker #fridaymotivation #morningmotivation #gymmotivation #motivationalmonday #dailymotivation #weightlossmotivation #sportmotivation #thursdaymotivation #exercisemotivation #powerliftingmotivation #motivationquote #bodybuildingmotivation #studymotivation #motivationalquote #mondaymotivation #motivationquotes #motivational #runningmotivation #motivations #workoutmotivation #motivationmonday #entrepreneurmotivation #fitmotivation #selfmotivation #tuesdaymotivation"),
                        new MyListData("Running", "#run #runner #running #fit #runtoinspire #furtherfasterstronger #seenonmyrun #trailrunning #trailrunner #runchat #runhappy #instagood #time2run #instafit #happyrunner #marathon #runners #photooftheday #trailrun #fitness #workout #cardio #training #instarunner #instarun #workouttime"),
                        new MyListData("Sweat", "tagssssssss"),
                        new MyListData("Slim", "tagssssssss"),
                        new MyListData("Fat Burning", "tagssssssss"),
                        new MyListData("Exercise", "tagssssssss"),
                        new MyListData("Dance", "#dancehall #danceclass #fortnitedance #dancersofinstagram #abundance #hiphopdance #bellydancer #contemporarydance #dancelove #dancemoms #danceparty #danceshoes #dancewear #dancemusic #poledance #dancerlife #dancelife #dancefloor #guidance #dancingqueen #dancefitness #breakdance #dancechallenge #instadance"),
                        new MyListData("Diet", "#ketodiet #dieting #dietplan #healthydiet #plantbaseddiet #energydiet #dietalowcarb #dietherbal #tryitordiet #balanceddiet #foconadieta #dietaflexivel #dietas #nodiet #lowcarbdiet #dietasemsofrer #dietfood #flexibledieting #dietitian #dietsehat #paleodiet #dietalami #ketogenicdiet #dietasana #dietmayo #dietaman #tipsdiet"),
                        new MyListData("Coach", "#businesscoach #fitnesscoach #onlinecoach #lifecoaching #wellnesscoach #coachella #beachbodycoach #coachwallet #coachlife #coach #coachoutlet #coachbag #coachthailand #healthcoach #lifecoach #nutritioncoach #onlinecoaching #mindsetcoach #successcoach #coachsale #coachoriginal #tascoach"),
                        new MyListData("Gymnastics", "#gymnastics #gymnastic #gymnast #gymnasts #love #fun #flexible #gymnastique #gymnastlife #beam #vault #bars #training #motivation #gym #flip #gym #stunt #sport #git #leap #photography #instapic #scale #highbar #flipping #gymnastics #gymnastic #gymnast #gymnasts #love #fun #flexible #gymnastique #gymnastlife #beam #vault #bars #training #motivation #gym #flip #gym #stunt #sport #git #leap #photography #instapic #scale #highbar #flipping "),
                        new MyListData("Cheerleading", "#cheer #cheerleading #cheerleader #photography #instapic #cheerathletics #stunting #tumbling #jump #toetouch #flexible #box #stretch #scale #scorpion #backtuck #instacheer #love #cheerstagram #sport #fit #cheerperfection #cheerclassic #instacheerleader #cheerislife #cheering #cheersport #cheerpassion #cheerpractice "),
                        new MyListData("Yoga 1", "#yogaeverydamnday #yogaforlife #yogapose #yogainspiration #yogalover #yogateacher #yogaeverywhere #yogaposes #yogapractice #yogafit #yogalifestyle #yogadaily #yogaphotography #yogaeveryday #yogacommunity #yogalife #yogafam #hotyoga #loveyoga #yogaretreat #yogamom #igyoga #yogagram #yogagirl #yogalove #yogajourney"),
                        new MyListData("Yoga 2", "#love #fun #healthy #fitspo #yoga #yogaclass #yogaeverydamnday #namaste #fitness #active #yogi #meditation #like #acro #motiviation #strength #blessed #instagood #yogalife #practice #stretch #yogaeveryday #flexible #yogainspiration #energy #healthybody"),
                        new MyListData("Football", "#football #ball #pass #photography #instapic #footballgame #footballseason #footballgames #footballplayer #instagood #pass #jersey #stadium #field #yards #photooftheday #yardline #pads #touchdown #catch #quarterback #fit #grass #nfl #superbowl #run "),
                        new MyListData("Baseball", "#baseball #base #ball #photography #instapic #bases #homerun #bat #throw #catch #swing #photooftheday #field #pitcher #mlb #firstbase #game #instagood #secondbase #thirdbase #inning #baseballbat #mitt #out #sport #sports "),
                        new MyListData("Hockey", "#hockey #hockeystick #puck #ice #rink #icerink #hockeyplayer #instagood #hockeyplayers #fight #photooftheday #shot #skate #photography #instapic #hockeygram #stanleycup #score #hockeylife #pucklife #nhl "),
                        new MyListData("Soccer", "#soccer #ball #futbol #photography #instapic #futball #kick #pass #shoot #score #goal #field #net #team #soccerball #photooftheday #instafutbol #instagood #grass #run #soccergame #fifa #worldcup "),
                        new MyListData("Basketball", "#basketball #basket #ball #photography #instapic #baller #hoop #balling #sports #sport #court #net #rim #backboard #instagood #game #photooftheday #active #pass #throw #shoot #instaballer #instaball #jump #nba #bball "),
                        new MyListData("Golf", "#golf #golfing #golfer #golflife #golfswing #golfstagram #instagolf #golfers #golfcourse #golfaddict #pga #golfclub #golfislife #pgatour #golfchannel #golfporn #golfday #golfpro #golfr #golfswag #golftips #golfcart #lovegolf #taylormade #golfball #whyilovethisgame #golfcoach #golflessons #titleist "),
                        new MyListData("Cricket", "#cricket #ipl #viratkohli #rohitsharma #msdhoni #india #icc #love #cricketer #indiancricket #t #indiancricketteam #lovecricket #dhoni #cricketfans #teamindia #cricketlover #worldcup #cricketmerijaan #bcci #cricketlovers #sports #cricketlove #csk #sachintendulkar #cricketlife #cricketfever #psl #cricketers #bhfyp"),
                        new MyListData("SkateBoarding", "#skateboarding #skating #skater #photography #instapic #instaskater #sk8 #sk8er #sk8ing #sk8ordie #photooftheday #board #longboard #longboarding #riding #kickflip #ollie #instagood #wheels #skatephotoaday #skateanddestroy #skateeverydamnday #skatespot #skaterguy #skatergirl #skatepark #skateboard #skatelife "),
                        new MyListData("Keto Diet", "tagssssssss"),

                };
                break;

            case "Button7":
                mainCategory.setText("Fashion");
                myListData = new MyListData[] {
                        new MyListData("Fashion 1", "#fashionstyle #fashionweek #mensfashion #ootdfashion #fashionlover #fashioneditorial #hairfashion #fashioninspo #streetfashion #fashionmagazine #fashionshoot #fashionblog #fashionphotography #fashionmodel #fashiongram #fashiondiaries #sustainablefashion #fashionphotographer #fashiondesigner #slowfashion #highfashion #fashionaddict #kidsfashion #fashionstylist"),
                        new MyListData("Fashion 2", "#vintagefashion #fashionable #womensfashion #fashionph #fashioninspiration #fashionist #fashionistas #winterfashion #menfashion #urbanfashion #fashionkilla #fashionjewelry #fashionshow #fashionkids #fashionbloggers #fashiongirl #fashiondesign #fashiontrends #fashionpost #fashionlovers #ethicalfashion #fashionmen #fashionbag #fashions #mensfashionpost #fashiondaily"),
                        new MyListData("Outfit Of the Day", "#ootw #outfit #outfitoftheday\uD83D\uDC8E #photooftheday #outfitoftheday #fit #ootdsubmit #outfitlove #outfitoftheweek #ootddaily #outfitinspiration #ootd #favoriteoutfit #ootdfash #outfitsideas #outfitideas #ootdshare #outfitinspo #ootdfashion #bestoutfit #ootd\uD83D\uDC57 #ootdgoals #fashion #ootdbloggers #like #love #follow #ootd\uD83D\uDC97 #fashionootd"),
                        new MyListData("Girls Fashion", "#fashiongirl #girlsfashion #fashiongirls #girlfashion #fashion #fashionlooks #fashionblogers #babygirlfashion #fashionbabygirl #fashiongirlstyle #cowgirlfashion #fashionforgirls #curvygirlfashion #girlyfashion #blackgirlfashion #girlsfashions #toddlergirlfashion #girlfashions #littlegirlfashion #egirlfashion #fashionforgirl"),
                        new MyListData("Shoes", "#shoes #fashion #style #sneakers #love #shopping #moda #nike #like #shoesaddict #instagood #follow #heels #outfit #dress #instagram #onlineshopping #ootd #bags #adidas #fashionblogger #instafashion #stylish #bhfyp #model #fashionista #handmade #photography #photooftheday #bhfyp"),
                        new MyListData("Watches", "#watch #watches #watchesofinstagram #fashion #watchoftheday #watchfam #watchcollector #watchaddict #love #like #rolex #follow #instagram #wristwatch #watchlover #photography #original #art #shoes #jamtangan #luxury #instawatch #horology #bhfyp #style #timepiece #watchgeek #dailywatch #yourself #bhfyp"),
                        new MyListData("Glasses", "#glasses #sunglasses #eyewear #fashion #style #love #selfie #photography #instagood #me #smile #optical #eyewearfashion #eyeglasses #like #eyes #photooftheday #glassesgirl #myself #instagram #frames #summer #happy #girl #follow #art #picoftheday #k #vision #bhfyp"),
                        new MyListData("Dress", "#dress #fashion #style #gamis #ootd #love #dressmurah #dresses #outfit #shopping #like #bajumurah #tunik #moda #model #blouse #instafashion #instagood #hijab #beauty #beautiful #gamismurah #fashionblogger #fashionista #gamissyari #girl #onlineshopping #wedding #summer #bhfyp"),
                        new MyListData("Gown", "tagssssssss"),
                        new MyListData("Makeup", "#fashion #makeupartist #mascara #lip #makeup #gloss #cosmetics #lipstick #eyebrows #eyes #primers #beauty #instamakeup #base #lips #lash #lashes #concealer #makeupaddict #eyeliner #glue #eyeshadow #makeuplover #makeupjunkie #palettes #powder #beautiful #cosmetic #foundation"),
                        new MyListData("Hair", "#longhair #fashion #style #black #hairstyles #blonde #hairdye #haircolor #hairoftheday #hairideas #curly #braid #hairstyle #hair #braidideas #hairdo #longhairdontcare #hairfashion #coolhair #perfectcurls #haircolour #brown #instahair #straighthair #brunette #straight #hairofinstagram #instafashion #haircut"),
                        new MyListData("Jewelry", "#style #stone #cute #jewel #jewelrygram #jewels #fashionjewelry #beautiful #jewelry #gemstone #ootd #accessory #accessories #gem #jewelryaddict #bling #crystals #gems #instajewelry #jewelrydesign #fashion #stylish #stones #handmadejewelry #love #trendy #fashionista #design"),
                        new MyListData("Nails", "#nail #nailsofinstagram #gelnails #pretty #nails #fashion #nails\uD83D\uDC85 #love #styles #cute #nailsoftheday #art #girls #essie #opi #style #nailpolish #nailstagram #beauty #instagood #nailart #rosa #stylish #unhas #branco #beautiful #nailswag #nailpolish #girl #sparkles"),
                        new MyListData("Skincare", "#darkskin #askingalexandria #naturalskincare #moleskine #organicskincare #dryskin #skinfade #nuskin #fortniteskins #skins #skincarejunkie #skincaremurah #skincareaddict #skincarelover #beautifulskin #loveyourskin #clearskin #strongisthenewskinny #skincarebpom #skincaretips #strongnotskinny #glowingskin #skingoals #healthyskin #skincareaman #koreanskincare #skincareroutine  "),
                        new MyListData("Tattoos", "#tattoist #tattoos #instagood #tattooed #tattoosleeve #inkedup #amazingink #photooftheday #tattoostudio #coverup #tattoostyle #instatattoo #tattooshop #tattoo #tatted #instaart #tatts #tats #art #chesttattoo #bodyart #design #handtattoo #tat #tattedup #girlswithtattoos #ink #inked #tattoosofinstagram #sleevetattoo"),
                        new MyListData("Bracelets", "#bracelets #bracelet #armcandy #armswag #wristgame #pretty #love #beautiful #braceletstacks #trendy #instagood #fashion #braceletsoftheday #jewelry #fashionlovers #fashionista #photography #instapic #accessories #wristwear "),
                        new MyListData("Earrings", "#earrings #earring #earringsoftheday #jewelry #fashion #accessories #earringaddict #earringstagram #fashionista #girl #stylish #love #beautiful #piercing #piercings #pierced #cute #gorgeous #trendy #earringswag #photography #instapic #earringfashion #earringlove "),
                        new MyListData("Piercing", "#piercing #piercings #piercingaddict #helixpiercing #piercinglove #piercinggirl #piercingsofinstagram #daithpiercing #navelpiercing #piercingstudio #piercingsandtattoos #eyebrowpiercing #newpiercing #industrialpiercing #bellypiercing #conchpiercing #piercing2me #instapiercing #cartilagepiercing #piercinglife #piercingshop #piercinglover"),
                        new MyListData("High Heels", "tagssssssss"),
                        new MyListData("Sneakers", "#sneakers #sneakerhead #sneaker #sneakerheads #sneakernews #sneakerporn #sneakerholics #sneakersmurah #sneakerfiles #sneakerfreak #sneakersaddict #sneakershouts #sneakerfreaker #sneakerfiend #sneakeraddict #sneakerwatch #sneakercon #sneakersforsale #sneakermurah #sneakercommunity #sneakerlove #sneakerstore #sneakergallery #sneakergame #sneakeroftheday #sneakerholic #sneakerness #igsneakerheads #sneakercollector #sneakerfam"),
                        new MyListData("Natural", "#naturale #naturals #nature #light #naturalhealth #naturalbeauty #natural #organic #original #naturallook #like #love #follow #naturallight #fresh #naturallife"),


                };
                break;

            case "Button8":
                mainCategory.setText("Food & Drinks");
                myListData = new MyListData[] {
                        new MyListData("Food", "#food #foodporn #yum #instafood #yummy #amazing #instagood #photooftheday #sweet #dinner #lunch #breakfast #fresh #tasty #food #delish #delicious #eating #foodpic #foodpics #eat #hungry #foodgasm #hot #foods"),
                        new MyListData("Drinks", "#yum #brew #brewers #thirsty #bar #photooftheday #winery #pub #drinkup #slurp #drinkinggames #glass #liquor #drinking #drinkingbuddies #cocktails #brewery #finewine #beer #can #thirst #instagood #drinks #alcohol #drink #winetasting #cocktail #beers #wine"),
                        new MyListData("Keto", "#lchflifestyle #ketofriendly #lc #intermittentfasting #like #ketolife #ketogenic #love #keto #paleo #ketotransformation #imf #lowcarbhighfat #ketoliving #lchfdiet #healthy #ketodiet #lchf #lowcarblove #nocarb #healthyfood #ketosis #ketones #fitness #ketoaf #lowcarb #lowcarbdiet"),
                        new MyListData("Vegan", "#eatwellbewell #healthy #plantbased #vegans #love #vegan #nomeat #veganism #plants #lifestyle #like #plantbaseddiet #eats #healthyfood #crueltyfree #healthy #veganlife #meatfree #eating #dairyfree #food #organic #foodie #govegan #eatclean #vegancommunity #vegansofig #veganfood #nodairy"),
                        new MyListData("Vegetarian", "#nomeat #healthyfood #plants #organic #foodie #vegetarian #vegetarianlifestyle #like #vegetarianfood #eatclean #eatwellbewell #vegetarianlife #eating #healthy #meatfree #vegetarians #food #crueltyfree #healthy #plantbaseddiet #love #eats #plants #lifestyle #plantbased"),
                        new MyListData("Yummy", "#yum #yumyum #yummyinmytummy #yummy\uD83D\uDE0B #yummm #yumm #yummy #yummie #yummi #yummyfood #soyummy"),
                        new MyListData("Coffee", "#cotd #coffeelife #coffeegram #caffeine #coffeeoftheday #cafelife #coffeeaddict #hot #love #coffiecup #coffeemug #coffeetime #coffee #coffeelovers #coffeelover #mug #warm #drink #coffeeholic #coffeelove #instacoffee #cafe #like"),
                        new MyListData("Desserts", "#dessert #food #foodporn #foodie #cake #yummy #instafood #chocolate #delicious #sweet #homemade #foodphotography #desserts #foodstagram #baking #icecream #pastry #instagood #foodblogger #love #sweets #sweettooth #dessertporn #tasty #foodlover #cakes #bakery #cookies #yum #bhfyp"),
                        new MyListData("Tea", "#tea #teatime #instatea #tealife #ilovetea #teaaddict #tealover #tealovers #teagram #healthy #drink #hot #mug #teaoftheday #teacup #teastagram #photography #instapic #teaholic #tealove #tealife "),
                        new MyListData("Pizza", "#pizzas #pizzanapoletana #pizzahut #pizzalover #pizzaria #pizzaparty #pizzalovers #pizza\uD83C\uDF55"),
                        new MyListData("Diet", "#ketodiet #flexibledieting #dietitian #dietsehat #paleodiet #dietalami #ketogenicdiet #dietasana #dietmayo #dietaman #foconadieta #dietherbal #dietalowcarb #energydiet #plantbaseddiet #healthydiet #dietplan #dieting #dietfood #dietasemsofrer #lowcarbdiet #nodiet #dietas #dietaflexivel"),
                        new MyListData("Homemade", "tagssssssss"),
                        new MyListData("Cooking", "tagssssssss"),
                        new MyListData("Chinese", "tagssssssss"),
                        new MyListData("Breakfast", "tagssssssss"),
                        new MyListData("Dinner", "tagssssssss"),
                        new MyListData("Lunch", "tagssssssss"),
                        new MyListData("Snacks", "tagssssssss"),

                };
                break;

            case "Button9":
                mainCategory.setText("Beauty");
                myListData = new MyListData[] {
                        new MyListData("Beauty", "#beautyful #fentybeauty #effyourbeautystandards #beautyjunkie #beautyblog #greenbeauty #organicbeauty #beautycare #beautymakeup #beautylover #kbeauty #beautybox #beautyfull #beautybloggers #beautygram #beautygirl #beautyguru #beautyqueen #beautyofnature #blackbeauty #naturebeauty #beautyproducts #beautyvlogger #cleanbeauty"),
                        new MyListData("Natural Beauty", "#beautybox #blackbeauty #beautygram #beautybloggers #plussizebeauty #beautycommunity #allbeauty_addiction #beautyandthebeast #howtobeauty #slave2beauty #africanbeauty #naturesbeauty #beautyfull #sleepingbeauty #msglowbeauty #beautysalon #beautyaddict #beautytips #kbeauty"),
                        new MyListData("Skin", "#darkskin #dryskin #skinfade #askingalexandria #naturalskincare #skincareroutine #koreanskincare #skincareaman #healthyskin #skingoals #clearskin #strongisthenewskinny #skincarebpom #skincaretips #strongnotskinny #moleskine #organicskincare #skincareaddict #beautifulskin #skincarejunkie #skincaremurah #skins #fortniteskins #nuskin #skincarelover #loveyourskin #glowingskin"),
                        new MyListData("Lipstick", "#fortniteclips #lipstickjunkie #lipstik #pubgclips #lipsync #lipsense #clipstudiopaint #biglips #liquidlipstick #mattelipstick #clips #tulips #lipstickaddict #lipsticks #redlipstick #hairclips #pinklips #maclipstick #flips #eclipse"),
                        new MyListData("Eyes", "#browneyes #eyelash #microbladingeyebrows #thirdeye #eyelashextension #eyewear #eyeshadowpalette #sydneyeats #eyebrow #eyemakeup #eyeglasses #oneyearold #oceaneyes #cateyes #smokeyeye #londoneye #puppyeyes #beautifuleyes #eyebrowsonfleek #cateye #eyeshadows #bigeyes #smokeyeyes #abc7eyewitness #eyecandy #fisheye #taeyeon"),
                        new MyListData("Looks", "#lookdujour #makeuplooks #kidslookbook #golook #looking #looks #aboutalook #lookup #lookgoodfeelgood #lookingfor #lookbooklookbook #goodlooking #menslook #lookgood #lookinggood #makeuplook #fashionlook #instalook #streetlook #lovethislook #lookslikefilm #lookingup #vintagelook #getthelook #lookingforph #newlook #hijablook"),
                        new MyListData("Glamour", "tagssssssss"),
                        new MyListData("Dress", "\n" +
                                "#dress #fashion #style #gamis #ootd #love #dressmurah #dresses #outfit #shopping #like #bajumurah #tunik #moda #model #blouse #instafashion #instagood #hijab #beauty #beautiful #gamismurah #fashionblogger #fashionista #gamissyari #girl #onlineshopping #wedding #summer #bhfyp\n"),
                        new MyListData("Skincare", "#jafraskincare #skinny #skincareproducts #flawlessskin #skincareindonesia #brownskingirls #jualskincare #brownskin #skinfood #smoothskin #healthynotskinny #sensitiveskin #skincareobsessed #perfectskin #acneskin #skincareritual #skincarenatural #snakeskin #skincareluxury #jesusisking #redskins #lovetheskinyourein #beautyskin #skinwhitening"),

                };
                break;

            case "Button10":
                mainCategory.setText("Art");
                myListData = new MyListData[] {
                        new MyListData("Quotes", "#inspiration #quotes #lifequotes #love #truth #quotestags #quote #follow #inspiringquotes #inspirationalquotes #quotestoliveby #quotesoftheday #life #motivation #vibes #successquotes #like #positivity #quotesdaily #saying #success #quotesforyou #sayings #positivequotes #lovequotes #motivationalquotes #quotestagram"),
                        new MyListData("Model", "#fashionmodel #malemodel #like #instamodels #girl #fitnessmodel #ootw #photooftheday #cool #modelling #modelphotography #art #model #modelshoot #ootd #style #love #photography #fashion #modelo #modelscout #modeling #modelingagency #modelagency #modellife"),
                        new MyListData("Style", "#styleblog #styles #inspo #styleinspiration #photography #ootd #stylegram #styleoftheday #styleblogger #streetstyle #menstyle #bloggerstyle #hijabstyle #instastyle #fashionstyle #style #casualstyle #fashion #ootw #model #styleinspo #art"),
                        new MyListData("Anime", "#animegirls #animememes #animeart #animeworld #animelover #drawing #animelife #animes #animegirl #animeedits #manga #animelove #animefans #animefreak #kawaii #love #art #like #otaku #animedrawing #animeedit #animefan #anime #animeboy #fun #illustration"),
                        new MyListData("Memes", "#dankmemes #love #btsmemes #funny #memestagram #lol #spicymemes #dailymemes #memes\uD83D\uDE02 #memesfordays #memes #memeaccount #nichememes #haha #memer #memegod #edgymemes #memelord #like #memesdaily #wholesomememes #meme #memepage #offensivememes #funnymemes"),
                        new MyListData("Painting", "#originalpainting #painting #art #photooftheday #watercolorpainting #oilpainting #artist #brush #landscapepainting #like #\uD83C\uDFA8 #paintings #acrylicpainting #paintingoftheday #painting\uD83C\uDFA8 #love #contemporarypainting #easel"),
                        new MyListData("Art", "#art #illustration #drawing #draw #picture #artist #sketch #sketchbook #paper #pen #pencil #artsy #instaart #beautiful #instagood #gallery #masterpiece #creative #photooftheday #instaartist #graphic #graphics #artoftheday"),
                        new MyListData("Minimalism", "#simpleandpure #minimalismo #minimalista #minimalist #minimalplanet #simplicity #beautiful #minimalove #minimalninja #instagood #minimalism #lessismore #minimalobsession #photooftheday #minimal #love #aesthetic #art #minimalissimo #nordicminimalism #learnminimalism #minimalistic #minimalism_world #vsco #negativespace #keepitsimple #minimalistics #simple"),
                        new MyListData("Graphic Design", "#graphicdesigner #photoshop #design #graphicdesign #photooftheday #art #designing #sketch #like #illustrator #work #graphicdesignlife #logodesign #beautiful #graphicdesigners #illustration #mockup #love #designer #logo #graphicdesigncentral #artist #graphicdesigndaily"),
                        new MyListData("Graphics", "#graphic #art #graphicdesign #design #illustration #artist #creative #drawing #artwork #graphicdesigner #graphics #logo #designer #sketch #photoshop #illustrator #digitalart #instaart #branding #draw #instagood #photography #typography #artoftheday #beautiful #sketchbook #gallery #instaartist #photooftheday #bhfyp"),
                        new MyListData("Animations", "#animation #art #d #illustration #anime #digitalart #cartoon #design #drawing #danimation #artist #motiongraphics #graphicdesign #aftereffects #sketch #artwork #film #motiondesign #video #characterdesign #cinema #love #manga #animationart #blender #disney #music #artistsoninstagram #animated #bhfyp"),
                        new MyListData("Blender", "#blender #d #dart #art #render #digitalart #animation #blendercommunity #dmodeling #blendermurah #design #cgi #rendering #dmodel #roblox #gfx #blenderportable #robloxgfx #danimation #dartist #blenderrender #drender #cinema #mixer #b #juicer #lowpoly #artist #vfx #bhfyp"),
                        new MyListData("Maya", "tagssssssss"),
                        new MyListData("Unity", "#unity #d #unitygame #unitygames #unitydev #gamedev #gamedevelopment #gamedeveloper #game #dgame #indiegame #sunnytc #sunny #unityengine #gamedevlife #unitydevelopment #videogames #indiegamedev #madewithunity #indiegames #programming #migs #gamedesign #gamedevelopers #mobilegame #cockatiel #sunnyunity #birbgame #sunnythecockatiel #bhfyp"),
                        new MyListData("Motion Graphics", "#motiongraphic #d #motiongraphics #motiondesign #animation #motion #aftereffects #graphicdesign #design #art #adobe #danimation #motionlovers #motionart #mograph #c #illustration #digitalart #cinema #motiondesigner #mdcommunity #video #photography #logo #edits #adobeaftereffects #motiongraphicscollective #vfx #graphics #bhfyp"),
                        new MyListData("2D Graphics", "tagssssssss"),
                        new MyListData("3D Graphics", "tagssssssss"),

                };
                break;

            case "Button11":
                mainCategory.setText("Brands");
                myListData = new MyListData[] {
                        new MyListData("Brands", "#brands #fashion #style #brand #branding #love #shopping #luxury #like #beauty #marketing #clothes #shoes #design #follow #onlineshopping #instagram #instafashion #instagood #lifestyle #fashionista #business #fashionblogger #bags #clothing #designer #sale #music #model #bhfyp"),
                        new MyListData("Nike", "#nike #adidas #jordan #sneakers #airmax #sneakerhead #airjordan #puma #fashion #yeezy #nikeairmax #shoes #nikeshoes #kicks #supreme #hypebeast #fitness #football #s #vans #like #love #offwhite #running #sport #kicksonfire #style #streetwear #nikeairforce #bhfyp"),
                        new MyListData("Adidas", "#adidas #nike #yeezy #puma #sneakers #adidasoriginals #jordan #fashion #vans #shoes #converse #football #adidasshoes #sneakerhead #supreme #like #adidasoriginal #newbalance #soccer #hypebeast #s #sepatumurah #love #reebok #sport #style #adidassuperstar #airmax #fila #bhfyp"),
                        new MyListData("Fila", "#fila #adidas #nike #puma #filadisruptor #vans #filashoes #champion #sneakers #converse #fashion #lacoste #shoes #reebok #newbalance #bundlemalaysia #filaoriginal #jordan #nikeairmax #tommyhilfiger #filasecond #kappa #filathailand #like #streetwear #airmax #uniqlo #supreme #filakorea #bhfyp"),
                        new MyListData("Puma", "#puma #nike #adidas #sneakers #vans #newbalance #reebok #fila #shoes #converse #football #fashion #pumashoes #jordan #asics #soccer #sport #pumasuede #yeezy #pumaoriginal #like #love #s #gucci #style #sneakerhead #pumasneakers #fitness #sepatumurah #bhfyp"),
                        new MyListData("Woodland", "#woodland #nature #forest #trees #woods #naturephotography #tree #m #photography #airsoft #outdoors #landscape #naturelovers #spring #wildlife #milsim #wood #landscapephotography #flowers #multicam #countryside #handmade #woodlandwalk #walking #love #bluebells #woodlandphotography #ig #art #bhfyp"),
                        new MyListData("Rayban", "#rayban #sunglasses #raybansunglasses #fashion #eyewear #oculosdesol #glasses #g #style #zl #instagood #raybanaviator #raybanwayfarer #moda #love #raybanoriginal #k #summer #like #instagram #photography #wayfarer #gucci #oculosdegrau #raybans #picoftheday #oculos #rb #raybanusa #bhfyp"),
                        new MyListData("Apple", "tagssssssss"),
                        new MyListData("Samsung", "tagssssssss"),
                        new MyListData("Gucci", "tagssssssss"),
                        new MyListData("Zara", "tagssssssss"),
                        new MyListData("Louis Vuitton", "tagssssssss"),
                        new MyListData("Rolex", "tagssssssss"),
                        new MyListData("Parada", "tagssssssss"),
                        new MyListData("Armani", "tagssssssss"),
                        new MyListData("Cartier", "tagssssssss"),
                        new MyListData("Calvin Klein", "tagssssssss"),
                        new MyListData("Reebok", "tagssssssss"),
                        new MyListData("H&M", "tagssssssss"),

                };
                break;

            case "Button12":
                mainCategory.setText("Automotives");
                myListData = new MyListData[] {
                        new MyListData("Travel", "#travel #traveling #vacation #visiting #instatravel #instago #instagood #trip #holiday #photooftheday #fun #travelling #tourism #tourist #instapassport #instatraveling #mytravelgram #travelgram #travelingram #igtravel"),
                        new MyListData("Cars", "#cars #car #ride #drive #driver #sportscar #vehicle #vehicles #street #road #freeway #highway #sportscars #exotic #exoticcar #exoticcars #speed #tire #tires #spoiler #exhaust #race #racing #wheel #wheels #rim #rims #engine #horsepower"),
                        new MyListData("Bikes", "#bikers #twowheels #bicycle #bikelove #transportation #bikeride #bikersofinstagram #frame #biker #wheels #ride #bikestagram #handlebars #bikeshop #bikes #bikeriding #bike #riding #bikeporn #lifebehindbars #bikelife"),
                        new MyListData("Motorcycles", "#ebike #swimbikerun #bikergirl #superbike #dirtbike #sportbikelife #bikesofinstagram #instabike #bikes #trekbikes #bikersofinstagram #mountainbike #motorbike #bikelove #dirtbikes #bikestagram #bikeride #custombike #bikerlife #sportbike #bikeporn #roadbike #bikepacking #superbikes"),
                        new MyListData("SportsCar", "#sportwear #sportsphotography #esporte #sepatusport #polesport #sportswear #transportation #igersportugal #sportster #transport #esports #motorsport #transporte #supersport #audisport #sportcar #motorsports #sportscars #sportbike #sportcars #sportscar #sportlife #sportgirl #passportready"),
                        new MyListData("Plane", "#airplane #aviation #avgeek #boeing #aircraft #aviationphotography #plane #aviationlovers #airport #planespotting #a #airbus #instagramaviation #pilot #aviationdaily #instaaviation #aviationgeek #instaplane #b #flight #travel #flying #fly #f #planespotter #pilotlife #lovers #airplanes #planes #bhfyp"),
                        new MyListData("Jets", "tagssssssss"),
                        new MyListData("Luxury Cars", "#luxurycars #cars #luxury #luxurylifestyle #supercars #carsofinstagram #car #bmw #ferrari #supercar #mercedes #carlifestyle #carporn #amg #porsche #lamborghini #carswithoutlimits #exoticcars #luxurycar #mercedesbenz #audi #instacars #amazingcars #luxurylife #instacar #s #carspotting #v #carstagram #bhfyp"),
                        new MyListData("Luxury Bus", "#luxurybus #bus #travel #travelling #volvo #bharatbenz #indianbuses #buslovers #sleeperbus #gujarat #gujaratbuses #gujaratdrivers #rajasthan #delhi #maharashtra #goa #bangalore #gujarattravels #travels #merecedes #gujarattravel #indianluxury #shirdi #acbuses #heavyvehicles #toplongroute #volvobusesofindia #mercedesbenz #minibus #bhfyp"),
                        new MyListData("Race Cars", "#racecar #racing #cars #motorsport #car #race #carsofinstagram #s #turbo #porsche #jdm #gt #r #carporn #e #f #becauseracecar #bmw #v #m #drift #racecars #ford #speed #motorsports #trackcar #photography #z #supercar #bhfyp"),
                        new MyListData("Audi", "tagssssssss"),
                        new MyListData("BMW", "tagssssssss"),
                        new MyListData("Chevrolet", "tagssssssss"),
                        new MyListData("Ford", "tagssssssss"),
                        new MyListData("Honda", "tagssssssss"),
                        new MyListData("Jeep", "tagssssssss"),
                        new MyListData("Land Rover", "tagssssssss"),
                        new MyListData("Mercedes", "tagssssssss"),
                        new MyListData("Rolls Royce", "tagssssssss"),
                        new MyListData("Volkswagen", "tagssssssss"),
                        new MyListData("Lamborghini", "tagssssssss"),
                        new MyListData("Porsche", "tagssssssss"),
                        new MyListData("McLaren", "tagssssssss"),
                        new MyListData("Nissan", "tagssssssss"),

                };
                break;

            case "Button13":
                mainCategory.setText("Celebrations");
                myListData = new MyListData[] {
                        new MyListData("Weddings", "#weddinggown #bride #party #weddingphoto #bridesmaids #happy #romance #smiles #congratulations #together #instawed #unforgettable #congrats #wedding #marriage #weddings #weddingphotographer #forever #family #groom #weddingparty #ceremony #love #celebration #instawedding #flowers #weddingdress #weddingday #weddingcake #party"),
                        new MyListData("Birthdays", "#photooftheday #love #family #celebration #birthday #itslit #candle #present #party #fun #old #young #birthdaycake #instabirthday #cake #gift #friends #bday #instacake #years #born #happy #happybirthday #instabday #birthdaygift #celebrate #instagood #candles #bestoftheday"),
                        new MyListData("Thanksgiving", "#thanksgivingfeast #giving #thanksgivingeve #blessed #turkey #love #thanksgiving #food #stuffing #thankful #friends #thanks #turkeyday #thanksgivingbreak #happythanksgiving #instagood #foodporn #foodprep #thanksgivingprep #feast #fun #thanksgiving2019 #celebrate #holiday #family #photooftheday"),
                        new MyListData("Party", "#party #partying #fun #instaparty #instafun #instagood #bestoftheday #crazy #friend #friends #besties #guys #girls #chill #chilling #kickit #kickinit #cool #love #memories #night #smile #music #outfit #funtime #funtimes #goodtime #goodtimes #happy #itslit"),
                        new MyListData("Christmas", "#chirstmasspirit #christmastree #snow #holidays #tistheseason #happyholidays #ornaments #holiday #christmas #santa #gifts #santaclaus #cheer #love #christmasdecorations #holidayseason #presents #photooftheday #family #green #gift #lights #jolly #tree #christmasiscoming #winter #merrychristmas #xmas #christmas2020"),
                        new MyListData("Party", "#partymusic #partying #partyhard #instaparty #weddingparty #bridalparty #teaparty #partydress #poolparty #partydecor #gardenparty #holidayparty #partyplanner #followparty #christmasparty #partywear #bachelorparty #partypeople #partydecorations #makeupparty #afterparty #bacheloretteparty #partyideas #partynight #beachparty #danceparty"),
                        new MyListData("New Year", "tagssssssss"),
                        new MyListData("Halloween", "#halloweenparty #hauntedhouse #spooky #ghost #pumpkins #costume #october #orange #celebrate #trickortreat #creepy #haunted #candy #jackolantern #halloweencostume #october31 #like #boo #carving #pumpkinpatch #halloween #holiday #fall #pumpkin #treat #photooftheday #party #halloween2020 #scary"),
                        new MyListData("Valentine Day", "#heart #date #vday2020 #mylove #vday #valentinesgift #valentinesgifts #valentineday #fun #photooftheday #valentinesday2020 #valentinesday #myvalentine #love #gift #inlove #gifts #like #valentine #valentinesdate #valentinesdaygift"),
                        new MyListData("Memorial day", "#fireworks #barbeque #memorialdaybbq #memorialdayweekend #beach #like #memorialdaysale #chill #memorialday\uD83C\uDDFA\uD83C\uDDF8 #threedayweekend #thankful #memorialdayparty #friends #mdwbbq #mdwcelebration #memorialdayweekend2020 #love #cookout #mdw #mdwparade #family #grateful #memorialday2020 #ocean #party #memorial #mdw2020 #photooftheday #memorialdayparade\n"),
                        new MyListData("Holidays", "#holiday #travel #vacation #summer #love #nature #instagood #travelgram #photography #photooftheday #travelphotography #trip #beach #instatravel #traveling #sea #travelling #picoftheday #wanderlust #beautiful #like #instagram #adventure #tourism #fun #happy #sun #sunset #holidays #bhfyp"),
                        new MyListData("Festival", "#ultramusicfestival #festivals #festivalfashion #filmfestival #musicfestival #festivalseason"),
                        new MyListData("EDM", "#party #music #electronicmusic #edmlove #edmfestival #edmlifestyle #edc #edmmusic #housemusic #edmlife #edmvibes #edmnation #edmfamily #dance #techno #edmgirls #plur #djs #tomorrowland #festival #dj #love #trap #rave #dubstep #life #follow #edm"),
                        new MyListData("Rap Music", "#artist #rap #style #art #rapmusic #dj #like #producer #rappers #soundcloud #rapper #raplife #freestyle #playlist #hood #money #rapculture #art #songs #hiphop #rapmonster #music #rapgod #rapping #rapbeats #follow #beats #raps #trap #spotify"),
                        new MyListData("Music", "#music #genre #song #songs #melody #hiphop #rnb #pop #love #rap #dubstep #instagood #beat #beats #jam #myjam #party #partymusic #newsong #lovethissong #remix #favoritesong #bestsong #photooftheday #bumpin #repeat #listentothis #goodmusic #instamusic"),
                        new MyListData("Mother Day", "tagssssssss"),
                        new MyListData("Anniversary", "tagssssssss"),
                        new MyListData("Diwali", "tagssssssss"),
                        new MyListData("Farewell", "tagssssssss"),
                        new MyListData("Homecoming", "tagssssssss"),


                };
                break;

            case "Button14":
                mainCategory.setText("Celebrity");
                myListData = new MyListData[] {
                        new MyListData("Celebrity", "#celebrity #love #fashion #actor #actress #bollywood #model #instagram #style #beautiful #instagood #music #beauty #hollywood #photography #follow #celebrities #like #singer #trending #famous #likeforlikes #artist #photooftheday #cute #art #followforfollowback #celeb #india #bhfyp"),
                        new MyListData("Famous", "#famous #love #instagram #follow #viral #like #explorepage #trending #tiktok #instagood #likeforlikes #fashion #followforfollowback #explore #photography #model #music #cute #celebrity #beautiful #likes #style #comment #popular #actor #memes #photooftheday #india #art #bhfyp"),
                        new MyListData("Fame", "#entertainment #viral #celebritystyle #lifestyle #makeup #movie #instadaily #tiktok #picoftheday #photoshoot #news #likes #explorepage #repost #fashionblogger #mumbai #celebritynews #s #fashionista #film #explore #movies #life #blogger #fitness #covid #happy #instafashion #queen #gorgeous"),
                        new MyListData("Classic", "#classic #vintage #s #fashion #love #music #style #retro #oldschool #art #classiccars #photography #classiccar #instagood #car #cars #design #luxury #hiphop #beautiful #beauty #instagram #c #e #photooftheday #follow #lifestyle #like #w #bhfyp"),
                        new MyListData("Publicity", "#publicity #gainwithmchina #gainwithspikes #gaintrick #gainwithxtiandela #iamnairobian #fashion #gainwithmtaaraw #gainwithbundi #igerskenya #nairobikenya #pr #marketing #tembeakenya #igkenya #ignairobi #publicrelations #gainwithmugweru #gainwithpaula #gainwiththeepluto #dise #madeinkenya #gaintrain #over #gainpost #branding #kenya #gainwithcarlz #media #bhfyp"),
                        new MyListData("Bollywood", "#bollywood #love #india #instagram #hollywood #mumbai #tollywood #salmankhan #tiktok #instagood #follow #deepikapadukone #bollywoodactress #fashion #music #like #actor #katrinakaif #actress #aliabhatt #kollywood #trending #bollywoodsongs #indian #photography #likeforlikes #bollywooddance #shraddhakapoor #priyankachopra #bhfyp"),
                        new MyListData("Hollywood", "#hollywood #bollywood #losangeles #love #actor #film #movie #movies #cinema #actress #instagram #instagood #music #fashion #s #california #photography #la #follow #model #art #tollywood #like #beautiful #india #films #kollywood #beauty #photooftheday #bhfyp"),

                };
                break;

            case "Button15":
                mainCategory.setText("Clothing");
                myListData = new MyListData[] {
                        new MyListData("Clothing", "#cloth #fashion #clothing #style #clothes #clothingbrand #dress #distro #brand #handmade #love #tshirt #design #apparel #art #fabric #streetwear #clothingline #shopping #kaos #dellinside #girl #fashionista #beauty #outfit #cotton #shoes #indonesia #ootd #bhfyp"),
                        new MyListData("Sale", "#sale #fashion #shopping #promo #style #onlineshopping #discount #diskon #like #love #ootd #shop #follow #instagood #forsale #sales #beauty #instagram #handmade #fashionblogger #onlineshop #moda #dress #summer #new #online #k #shoes #instafashion #bhfyp"),
                        new MyListData("Designer", "#designercloth #fashion #style #design #onlineshopping #india #pretty #dresses #indianfashion #bollywood #prettygowns #boysfashion #bestshopofinstagram #voguenation #shoppingbuddy #fashionableindia #alloverindia #stayhomestaysafe #vogue #shopping #iloveshopping #safeshopping #shopmore #instashop #beautifull #love #prettydresses #girlsfashion #stylishclothes #bhfyp"),
                        new MyListData("Lehanga", "#lehanga #lehangacholi #fashion #saree #lehangalove #lehangas #designerlehanga #indianwedding #lehangalovers #wedding #bridallehanga #indianwear #designer #kurti #lehenga #sarees #bridalwear #dress #weddinglehanga #onlineshopping #fashionblogger #lehangadesigns #jassmanak #bride #anarkali #indianbride #partywear #bridal #ethnicwear #bhfyp"),
                        new MyListData("Shopping", "#shopping #fashion #style #onlineshopping #shop #love #shoppingonline #instagood #moda #outfit #instafashion #ootd #like #fashionblogger #shoes #dress #fashionista #sale #beauty #follow #instagram #online #beautiful #summer #onlineshop #design #stylish #fashionstyle #handmade #bhfyp"),
                        new MyListData("Kurti", "#kurti #fashion #kurtis #saree #onlineshopping #designerkurti #kurtilover #indianwear #ethnicwear #kurta #cottonkurti #kurtidress #dress #lehenga #style #dresses #indianfashion #suits #cotton #partywear #ethnic #kurtiplazo #kurticollection #salwarkameez #salwarsuit #india #instafashion #longkurti #kurties #bhfyp"),
                        new MyListData("Kurta", "#kurta #kurtamurah #bajuraya #bajumelayu #bajukoko #jubah #fashion #koko #bajumuslim #kurtapakistan #kurti #kurtaraya #raya #kurtalelaki #bajukurung #gamis #kurtaslimfit #kemko #kokokurta #bajukurta #sirwal #samase #dress #sunnah #kurtabudak #ethnicwear #kemejakoko #blouse #hijrah #bhfyp"),
                        new MyListData("Saree", "#saree #sareelove #fashion #sarees #sareelovers #sareesofinstagram #sareeblouse #onlineshopping #sareefashion #sareedraping #ethnicwear #indianwear #indianwedding #handloom #india #love #traditional #lehenga #sareeblousedesigns #sareeindia #sari #silksaree #sareelover #wedding #indianfashion #silk #style #sareepact #sareecollection #bhfyp"),
                        new MyListData("Skirt", "#skirt #fashion #dress #blouse #ootd #style #skirtmurah #pants #rok #top #outfit #instafashion #jeans #bajumurah #skirtlabuh #love #skirts #skirtmuslimah #shoes #girl #like #shopping #instagood #beautiful #tshirt #jacket #blousemurah #beauty #skirtkembang #bhfyp"),
                        new MyListData("Jeans", "#jeans #fashion #moda #denim #style #ootd #modafeminina #tshirt #look #dress #jeansmurah #love #outfit #estilo #celanajeans #shoes #instagood #celana #lookdodia #o #tendencia #shopping #model #pants #like #fashionblogger #jacket #shirt #instafashion #bhfyp"),
                        new MyListData("Shirt", "#shirt #fashion #tshirt #style #shirts #clothes #clothing #ootd #mensfashion #jeans #love #menswear #dress #shoes #tshirts #instagood #jacket #design #pants #model #shopping #like #onlineshopping #hoodie #tshirtdesign #outfit #men #streetwear #instafashion #bhfyp"),
                        new MyListData("Suit", "#suit #fashion #style #mensfashion #suits #menswear #menstyle #suitstyle #gentleman #dress #dapper #ootd #wedding #love #mensstyle #bespoke #men #punjabi #suitup #like #punjabisuit #fashionblogger #suitandtie #model #menwithclass #instafashion #tie #instagood #menwithstyle #bhfyp"),
                        new MyListData("Tuxedo", "#tuxedo #wedding #suit #cats #catsofinstagram #tuxedocat #cat #groom #mensfashion #fashion #menswear #blazer #cufflinks #style #menstyle #tuxedocatsofinstagram #tux #dapper #weddingphotography #slimfit #whiteshirt #kemeja #kemejakerja #frenchcuff #jaspengantin #blackandwhite #love #kemejaslim #suits #bhfyp"),
                        new MyListData("Salwar", "#salwar #salwarkameez #salwarsuits #salwarsuit #kurti #fashion #salwarsuitonline #salwarkameezsuit #salwarmaterial #cotton #indianwear #dressmaterial #ethnicwear #saree #designersalwarsuit #onlineshopping #cottonsalwar #salwarmaterials #chudidhar #salwars #chudidar #kurtis #chudi #suits #dressmaterials #salwarkamez #patialasalwar #salwarsuitsforwomen #indianfashion #bhfyp"),
                        new MyListData("Formal", "#formalwear #fashion #prom #formal #style #mensfashion #menswear #formaldresses #casualwear #onlineshopping #officewear #formaldress #dress #suit #ootd #instagood #weddingdress #fashionblogger #wedding #luxurypret #clothing #elegant #suits #photooftheday #partywear #dresses #readytowear #formals #menstyle #bhfyp"),
                        new MyListData("Ladies", "#ladiescloth #fashion #women #womenfashion #aabha #style #trending #latesttrend #womencomfort #kurtisets #kurticombo #dress #onlineshopping #retailtherapy #shopping #clothing #model #indowestern #traditional #saree #kurti #lifestyle #collection #womentop #beauty #ladiesclothes #ladies #delhi #ladiesclothingshoptop #bhfyp"),
                        new MyListData("Mens", "#mencloth #tshirt #boy #handbag #cool #design #jacket #fashion #boys #glam #hair #sneakers #instagood #shoesformen #model #sportcloth #outfit #nero #blue #purse #shoes #shopping #style #stylish #tagsforlikes #clothforman #photooftheday #shirt #kpop #bhfyp"),
                        new MyListData("Sports Wear", "tagssssssss"),
                        new MyListData("Dryfit", "#dryfit #konveksibasket #tshirt #offshore #jerseyprinting #jerseybasket #konveksi #bikinjersey #iblindonesia #jerseybagus #dryfitofftcool #dryfitofftcooluv #tshirtoffshore #jersey #vidadeembarcado #embarquenesseestilo #offshorelife #faceshieldofft #offshoreteamwear #offtvainabag #embarcado #proudoilfieldfamily #moletomofft #canecasofft #faceshield #offshorelegion #oilfieldstrong #gymbagofft #cl #bhfyp"),
                        new MyListData("Hotwear", "#hotwear #hot #vemprahot #novidades #inverno #look #inspire #jeanswear #shop #sexywear #sexy #cores #blackgirlsworkout #saunasuitmuratt #saunabelt #saunas #finnishsauna #saunatime #hotdaym #saunasuit #saunalife #blackwomendoworkout #atlantapersonaltrainer #bestofday #losangelesfitness #fashion #certifiedpersonaltrainer #blastfitness #picoftheday #bhfyp"),
                        new MyListData("Shervani", "tagssssssss"),
                        new MyListData("Swimming", "tagssssssss"),
                        new MyListData("Wedding wear", "tagssssssss"),
                        new MyListData("Heels", "tagssssssss"),

                };
                break;

            case "Button16":
                mainCategory.setText("Business & Work");
                myListData = new MyListData[] {
                        new MyListData("Business", "#business #career #company #design #entrepreneur #finance #furniture #home #job #jobs #leadership #market #marketing #money #office #Products #Sales #smallbiz #smallbusiness #startup #startups #strategy #success #supplies #work #working #coaching #family#goals #happiness #inspiration #life #love #motivation#quote #quotes #socialmedia #tips"),
                        new MyListData("Work", "#work #love #instagood #art #business #life #motivation #like #instagram #job #follow #photography #design #happy #photooftheday #lifestyle #passion #workout #fashion #fitness #picoftheday #inspiration #covid #success #hardwork #style #home #beauty #working #bhfyp"),
                        new MyListData("Money", "#money #business #entrepreneur #success #motivation #love #bitcoin #forex #investment #cash #wealth #finance #investing #trading #rich #millionaire #luxury #invest #lifestyle #cryptocurrency #life #financialfreedom #entrepreneurship #follow #marketing #goals #instagood #hustle #instagram #bhfyp"),
                        new MyListData("Job", "#job #work #jobs #jobsearch #love #business #career #o #hiring #instagood #recruitment #life #like #instagram #loker #employment #working #follow #motivation #photography #marketing #jobfair #photooftheday #lowongankerja #covid #jobseeker #ilovemyjob #happy #office #bhfyp"),
                        new MyListData("Duty", "#duty #of #call #mobile #honor #love #respect #police #callofduty #covid #cod #military #army #sacrifice #gaming #world #tactical #eue #codm #callofdutymobile #codmobile #life #india #callofdutymobilegame #courage #handygaming #lawenforcement #navy #firefighter #bhfyp"),
                        new MyListData("Dollar", "#dollar #money #rich #dollars #cash #bitcoin #millionaire #forex #billionaire #trading #luxury #currency #gold #euro #business #million #usa #lifestyle #wealth #moneymaker #luxurylifestyle #coin #love #moneymoney #makemoney #coins #investment #k #forextrader #bhfyp"),
                        new MyListData("Employment", "#employment #jobs #jobsearch #hiring #job #recruitment #career #work #resume #careers #recruiting #nowhiring #business #staffing #hr #jobhunt #jobseekers #humanresources #covid #jobopening #interview #jobseeker #employmentopportunities #education #jobinterview #recruiter #vacancy #employmentagency #hiringnow #bhfyp"),
                        new MyListData("Marketing", "#marketing #marketingdigital #business #digitalmarketing #branding #socialmedia #entrepreneur #advertising #instagram #socialmediamarketing #design #o #empreendedorismo #love #motivation #graphicdesign #digital #success #marketingstrategy #smallbusiness #follow #like #seo #entrepreneurship #photography #art #instagood #bhfyp #onlinemarketing #bhfyp"),
                        new MyListData("Finance", "#finance #money #business #investing #investment #entrepreneur #financialfreedom #wealth #stockmarket #stocks #success #trading #invest #bitcoin #motivation #forex #realestate #investor #cryptocurrency #accounting #wallstreet #personalfinance #entrepreneurship #marketing #covid #smallbusiness #trader #credit #crypto #bhfyp"),
                        new MyListData("Investment", "#investment #realestate #business #money #investing #invest #bitcoin #property #investor #entrepreneur #forex #realtor #trading #cryptocurrency #finance #home #success #realestateagent #wealth #forsale #luxury #stockmarket #forextrader #financialfreedom #motivation #crypto #stocks #househunting #newhome #bhfyp"),
                        new MyListData("Funds", "#funds #money #funding #finance #donate #business #investing #investment #covid #help #realestate #fundraising #startup #motivation #entrepreneur #invest #love #donation #coronavirus #crowdfunding #goals #helpingothers #support #investor #forex #india #investments #charity #banks #bhfyp"),
                        new MyListData("Professional", "#professional #photography #business #love #beauty #instagood #instagram #design #fashion #art #follow #makeup #beautiful #photographer #photooftheday #work #style #model #like #artist #entrepreneur #service #hair #motivation #covid #training #quality #clean #photo #bhfyp"),
                        new MyListData("Stock Market", "#stockmarket #stocks #investing #trading #money #investment #forex #finance #investor #invest #business #trader #wallstreet #bitcoin #financialfreedom #entrepreneur #daytrader #stock #forextrader #daytrading #sharemarket #forextrading #nifty #cryptocurrency #wealth #sensex #success #stockmarketnews #nse #bhfyp"),
                        new MyListData("Network", "#network #business #networking #marketing #networkmarketing #entrepreneur #technology #motivation #success #internet #cat #music #wifi #community #lifestyle #love #m #money #g #leadership #cisco #security #instagram #businessowner #mindset #data #work #k #telecom #bhfyp"),
                        new MyListData("Engineer", "tagssssssss"),

                };
                break;

            case "Button17":
                mainCategory.setText("Couples");
                myListData = new MyListData[] {
                        new MyListData("Romance", "#romance #love #couple #together #forever #kiss #happy #cute #beautiful #instagood #girlfriend #instalove #boyfriend #photooftheday #adorable #hugs #kisses #girl #smile #fun #lovehim #me #gf #bf #loveher #boy #bookstagram #bff #pretty #bhfyp"),
                        new MyListData("Love", "#love #instagood #like #follow #instagram #photooftheday #photography #beautiful #fashion #happy #picoftheday #bhfyp #life #art #cute #smile #me #likeforlikes #instadaily #followme #style #nature #likes #beauty #instalike #myself #followforfollowback #photo #l #bhfyp"),
                        new MyListData("Couple Goals", "#couplegoals #wedding #xoxo #couples #books #follow #like #drama #relationshipgoals #instagram #relationship #book #bride #amor #family #relationships #photography #marriage #art #happiness #life #anime #booklover #bhfyp #comedy #lovequotes #lovestory #weddingday #quotes #bookworm"),
                        new MyListData("Couples", "#couples #love #couplegoals #couple #relationshipgoals #cute #like #instagram #lovequotes #instagood #follow #couplesgoals #relationships #kiss #photography #boyfriend #together #relationship #wedding #loveyou #happy #girlfriend #romance #forever #beautiful #lovers #couplelove #family #goals #bhfyp"),
                        new MyListData("Romantic", "#romantic #love #romance #couplegoals #couple #instagood #instagram #follow #photography #like #beautiful #lovequotes #music #cute #wedding #couples #status #art #kiss #bollywood #sad #nature #tiktok #likeforlikes #happy #loveyou #followforfollowback #trending #fashion #bhfyp"),
                        new MyListData("Long Drive", "#longdrive #golf #love #nature #roadtrip #travel #photography #travelphotography #golfing #drive #instagood #golfer #friends #india #golfswing #instagolf #instagram #golfstagram #golflife #sunset #instadaily #photooftheday #explore #golfcourse #i #naturephotography #rainyday #mountains #peaceful #bhfyp"),
                        new MyListData("Life", "tagssssssss"),
                        new MyListData("Heart", "#heart #love #life #art #instagram #like #quotes #follow #happy #instagood #cute #lovequotes #beautiful #smile #soul #photography #poetry #sad #music #nature #heartbroken #feelings #happiness #me #likeforlikes #motivation #loveyourself #together #couple #bhfyp"),
                        new MyListData("Girlfriend", "#girlfriend #love #boyfriend #couple #cute #together #kiss #girl #forever #happy #romance #instalove #beautiful #gf #instagood #adorable #bf #photooftheday #smile #hugs #boy #kisses #fun #lovehim #loveher #me #bff #pretty #couplegoals #bhfyp"),
                        new MyListData("Sexy", "#sexy #love #model #hot #fashion #beautiful #like #follow #beauty #cute #girl #instagood #photography #fitness #style #instagram #photooftheday #followforfollowback #girls #likeforlikes #lingerie #pretty #music #picoftheday #portrait #summer #followme #art #lifestyle #bhfyp"),
                        new MyListData("Marriage", "#marriage #life #explorepage #tiktok #instalove #romantic #explore #quotes #weddingphotography #loveyourself #heart #bhfyp #loveislove #likeforlikes #fashion #smile #cutecouples #bride #girl #truelove #followforfollowback #art #friends #relationshipquotes #lovestory #couplevideos #kisses #happiness #coupleshoot #viral"),
                        new MyListData("#anniversary #birthday #love #wedding #gift #party #happybirthday #anniversarygift #graduation #years #babyshower #birthdayparty #surprise #celebration #gifts #family #like #handmade #art #happy #giftideas #ulangtahun #flowers #cake #couple #bridalshower #happyanniversary #birthdaygift #chocolate #bhfyp", "tagssssssss"),
                };
                break;

            case "Button18":
                mainCategory.setText("Entertainments");
                myListData = new MyListData[] {
                        new MyListData("Music", "#music #genre #song #songs #photography #instapic #melody #hiphop #rnb #pop #love #rap #dubstep #instagood #beat #beats #jam #myjam #party #partymusic #newsong #lovethissong #remix #favoritesong #bestsong #photooftheday #listentothis #goodmusic #instamusic "),
                        new MyListData("Gaming", "retrogaming #gaminglife #gamingsetup #instagaming #gamingcommunity #gamingmemes #pcgaming #gamingpc #onlinegaming #wargaming #tabletopgaming #gamingrig #gamingposts #twitchgaming #xboxgaming #gamingchannel #gamingroom #boardgaming #gaming\uD83C\uDFAE #gamingnews #videogaming #gamingmeme #handheldgaming #ps4gaming #setupgaming #gamingsetups #facebookgaming"),
                        new MyListData("Disney", "#disneyside #disneyparks #waltdisneyworld #disneystyle #instadisney #disneylandresort #disneyphotography #disneygram #disneylover #disneysea #disneyinsta #disneyphoto #disneyresort #disneyprincess #disneybound #disneypic #disneyfan #disneyig #disneychannel #disneylove #disneyaddict #disneystore #disneymagic #waltdisney #disneylandparis #disneylife #disneyonice"),
                        new MyListData("Concert", "#concertperformance #concert #exciting #performance #love #concertphotography #fun #happy #concerthall #concertseason #concerttime #show #lightsout #stagedesign #concertphoto #breakaleg #stage #showtime #instagood #opera"),
                        new MyListData("Television", "#rerun #tv #watch #flatscreen #show #fun #bestoftheday #showtime #premier #binge #4k #amc #amazon #instagood #episodes #episode #netflix #bingewatch #instatv #television #watching #1080 #love #video"),
                        new MyListData("Movies", "#lightsout #moviestar #goodmovie #flick #movie #instaflicks #movies #amc #cinema #theatre #video #flicks #hulu #instagood #instaflick #hollywood #netflixandchill #fun #love #videos #photooftheday #star #films #actor #netflix #dvd #instamovies #film #actress"),
                        new MyListData("Tik Tok", "#tiktokindo #funny #tiktokmemes #cute #tiktokindia #tiktokers #meme #tiktoksea #follow #tiktokapp #tiktokdance #fun #tiktoks #tiktokmalaysia #like #tiktokviral #lol #memes #tiktokhot #viral #video #love #tiktok #tiktokgirls #tiktokhits #tiktokvideo"),
                        new MyListData("Smile", "#smile #instasmile #smileeveryday #smiles #smiley #smilemore #dogsmile #smiler #keepsmile #thatsmile #smile\uD83D\uDE0A #justsmile #allsmiles #bigsmile #beautifulsmile #makeyousmilestyle #smiling #alwayssmile #smilealways"),
                        new MyListData("Happy", "#runhappy #happybaby #myhappyplace #happyfathersday #happyfamily #happymonday #happyanniversary #happykid #happytuesday #happytimes #happyme #happymoments #happykids #happymoment #happytummy #happybirthdaytome #happyweekend #happysaturday #happyplace #happydays #happyvalentinesday #happymom #happyfourth #plantsmakepeoplehappy #happythanksgiving #happyness #creativelifehappylife "),
                        new MyListData("Reels", "#reeltoreel #daiwareels #reelitin #reelsindia #reelit #reelitfeelit #instagramreels #reellife #shimanoreels #pennreels #reelbigfish #instareels #reelinstagram #reelsvideo #reel #reels #reelsinstagram"),
                        new MyListData("Xbox", "#farcry #rdr2 #xbox\uD83C\uDFAE #xboxone #consolegamer #battlefield #consolegaming #xbox1 #xbox #fallout #xboxgamer #rainbowsix #xbox360 #reddeadredemption #fortnite #minecraft #console #xboxcontroller #xboxgaming #halo"),
                        new MyListData("Play Station", "#playstation3 #rainbowxsix #gta #playstation4 #ps2 #playstation1 #consolegamer #ps4 #love #ps5 #fortnite #playstationvr #ps1 #ps3 #like #playstation5 #rdr2 #reddeadredemption #psvr #grandtheftauto #controller #playstation #consolegaming #playstation2 #console #granturismo #photooftheday"),
                        new MyListData("Gaming", "#gamergirl #gamestagram #video #winning #gaminglife #pcgaming #gamer #online #playing #playinggames #videogames #instagaming #gamerguy #instagamer #onlinegaming #game #play #gamingsetup #instagood #videogameaddict #photooftheday #games #gaming #pc #gamin #instagame #gamingmemes"),
                        new MyListData("Pubg", "#pubg #pubgclips #viral #love #pubgbattlegrounds #pubgindonesia #pubgmeme #pubggame #callofduty #pubgmemes #twitch #pubgindia #pubgmobileindonesia #pubgfunnymoments #mobile #pubgm #pubgmobile #gamer #game #like #memes #follow #pubgvideos #pubgfunny #gaming #pubgxbox #fortnite #pubgmoments"),
                        new MyListData("Funny", "#funny #lol #lmao #lmfao #hilarious #laugh #laughing #tweegram #fun #friends #photooftheday #friend #wacky #crazy #silly #witty #instahappy #joke #jokes #joking #epic #instagood #instafun #funnypictures #haha #humor"),
                        new MyListData("Fornite", "tagssssssss"),

                };
                break;

            case "Button19":
                mainCategory.setText("Family/People");
                myListData = new MyListData[] {
                        new MyListData("Home", "#homestyling #pocketofmyhome #luxuryhomes #homeoffice #homecoming #homeinspo #athome #dreamhome #homem #newhome #stayathomemom #homedecoration #homeinspiration #inspohome #luxuryhome #homebuyers #homeschool #homestyle #homes #gohardorgohome #homemadefood #homework #homegrown #homebaker #homeware #homegarden #homecook"),
                        new MyListData("Family", "#gang_family #familyphotographer #familygoals #vapefamily #edmfamily #familylife #familyphotography #fitfamily #familytravel #familyday #familylove #familyovereverything #swfamily #ygfamily #familyvacation #familyportrait #familypictures #happyfamily #wwfamily #familybusiness #instafamily #familydinner #lovemyfamily #familytrip #familyphoto #familyfun #trancefamily #slimmingworldfamily"),
                        new MyListData("Babies", "#babywearing #vegasbaby #babygift #babys #babyshop #newbornbaby #happybaby #babyclothes #babystyle #babyface #babycute #babymodel #babyphotoshoot #babyootd #babyclothing #dababy #newbaby #babyphotography #babylights #babysitting #mybabygirl #babyroom #fashionbaby #mybabyboy"),
                        new MyListData("Kids", "#lovebaby #babycat #crybaby #babyfever #babymodel #babycute #justbaby #sweetbaby #babyheadband #babyyoda #igbaby #babydoll #bajubaby #babyface #babystyle #mybabyboy #babyphotoshoot"),
                        new MyListData("Girls", "#girlswhovape #girlswhotravel #polishgirls #wearetravelgirls #crossfitgirls #instagirls #girlsnightout #inkedgirls #girlsthatlift #weedgirls #fitnessgirls #girlsjustwannahavefun #girlswithpiercings #beautifulgirls #girlswhokissgirls #asiangirls #animegirls #girlswithmuscles #girlswithmuscle #ganjagirls #blackgirlsrock #tattooedgirls #girlswithink #girlswholikegirls #girlsgeneration #prettygirls #girlstrip #girlsday #mygirls"),
                        new MyListData("Guys", "#guys #guy #boy #photography #instapic #boys #love #me #cute #handsome #picoftheday #photooftheday #instagood #fun #smile #dude #swag #hot #cool #igers #instagramers #eyes"),
                        new MyListData("Life", "#follow #lifeofadventure #lifequotes #lifeisgood #inspo #inspiration #lifegoals #instagood #happy #lifestyle #photography #motivation #life #healthylifestyle #nature #smile #quotes #love #lovelife #like #photo #style"),
                        new MyListData("Friendship", "#photooftheday #chillin #sup #follow #mates #like #friends❤️ #friendship #friends\uD83D\uDC6D #bestfriends #friendshipgoals #friends #family #friend #fam #hangingout #friends #bestfriends #friendship #friendshipgoals #friendsforever #friendsforlife #friendships #friendstime #friendshipquotes #friendsinperson  #friendshipneverends"),
                        new MyListData("Friends", "#friends #goodfriends #bestfriendgoals #petfriendly #girlsbestfriend #friendsforlife #myfriends #slimmingworldfriends #mybestfriend #bestfriendsforever #oldfriends #friendsforever #tagafriend #instafriends #friendship #greatfriends #newfriends #instafriend #busuifriendly #myfriend #withfriends #friendstime #girlfriends #nationalbestfriendday #friendships #vapefriends #friendshipquotes"),
                        new MyListData("Love", "#beautiful #loves #loveislove #lover #cute #style #lovestory #\uD83D\uDC96 #inlove #\uD83D\uDC95 #follow #loveofmylife #loveit #loved #me #lovelife #❤️ #\uD83D\uDC91 #smile #\uD83D\uDE0D #fun #lovely #love #art #\uD83E\uDD70 #like #lovethem"),
                        new MyListData("Couples", "#couple #fashion #smile #couples #girlfriend #couplegoals❤ #love #follow #powercouple #couplegoals #beautiful #photography #relationshipgoals #couplelove #coupleshoot #couplesgoals #cutecouple #boyfriend #cutecouples #like #kiss #couplephotography #travel #travelcouple"),
                        new MyListData("Brother & Sister", "tagssssssss"),


                };
                break;

            case "Button20":
                mainCategory.setText("Electronics");
                myListData = new MyListData[] {
                        new MyListData("Electronics", "#electronics #technology #tech #photography #instapic #electronic #device #gadget #gadgets #instatech #instagood #geek #techie #nerd #techy #photooftheday #computers #laptops #hack #screen "),
                        new MyListData("Android", "#instandroid #mobile #teamandroid #teamdroid #ics #instaandroid #samsunggalaxy #androidonly #androidographer #samsung #googleandroid #smartphone #google #samsunggalaxys2 #like #androidcommunity #instadroid #androidnesia #instagood #android #instamagandroid #androidography #phone #droid #androidinstagram #love"),
                        new MyListData("iPhone", "#stevejobs #apple #macmini #iphone #ios #stevewozniak #love #macpro #appletv #design #timcook #macbook #applewatch #macos #watchos #aapl #jonyive #ipad #applestore #appledevice #art #appleiphone #like #ipod"),
                        new MyListData("Gadgets", "#gadgets #technology #tech #gadget #iphone #electronics #pro #smartphone #technews #apple #instatech #techie #samsung #android #instagood #gadgetshop #oneplus #gadgetstore #innovation #mobile #techy #electronic #geek #device #engineering #gadgetmurah #xiaomi #photooftheday #accessories #bhfyp"),
                        new MyListData("Technology", "#technology #tech #innovation #engineering #iphone #business #science #design #technews #apple #electronics #gadgets #smartphone #pro #android #instagood #programming #software #samsung #computer #bhfyp #instatech #gadget #coding #education #security #techie #mobile #oneplus #bhfyp"),
                        new MyListData("Laptop", "#laptop #laptopmurah #asus #computer #laptopsecond #hp #laptopgaming #notebook #pc #lenovo #laptopbekas #gaming #juallaptop #acer #dell #technology #windows #tech #laptops #macbook #apple #samsung #iphone #laptopasus #jualbelilaptop #laptoplifestyle #komputer #laptoplenovo #macbookpro #bhfyp"),
                        new MyListData("Macbook", "tagssssssss"),

                };
                break;

            case "Button21":
                mainCategory.setText("Feelings");
                myListData = new MyListData[] {
                        new MyListData("Emotions", "#emotions #love #feelings #life #quotes #poetry #art #instagood #thoughts #mentalhealth #instagram #photography #lovequotes #music #sad #motivation #happy #follow #writersofinstagram #selflove #happiness #loveyourself #like #heart #nature #inspiration #selfcare #emotional #yourself #bhfyp"),
                        new MyListData("Love", "#love #couple #cute #adorable #photography #instapic #kiss #kisses #hugs #forever #girlfriend #boyfriend #gf #bf #bff #together #photooftheday #happy #me #girl #boy #beautiful #instalove #loveher #lovehim #pretty #fun #smile "),
                        new MyListData("Happy", "#happy #love #instagood #like #smile #photooftheday #beautiful #follow #instagram #cute #photography #life #picoftheday #fashion #me #art #style #instadaily #girl #myself #fun #nature #followme #photo #selfie #bhfyp #likeforlikes #beauty #happiness #bhfyp"),
                        new MyListData("Hurt", "#hurts #love #theohutchcraft #hurtsband #sad #hurtsfamily #adamanderson #theohurts #adamhurts #hurtquotes #quotes #life #hurt #brokenheart #lifequotes #feelings #brokenheartquotes #pain #deepfeelings #brokenquotes #broken #deepthoughts #notfine #follow #sadquotespage #sadthoughts #lonelyquotes #like #poetryforthesoul #bhfyp"),
                        new MyListData("Emotional", " #emotional #love #music #art #sad #emotions #instagood #picoftheday #rap #happy #spiritual #physical #poetry #instagram #beautiful #feelings #hiphop #emotion #fun #poem #passion #life #beauty #mood #artist #model "),
                        new MyListData("Moods", " #mood #love #photography #travel #instagood #photooftheday #fashion #picoftheday #nature #style #art #model #beautiful #happy #vibes #instagram #life #california #summer #instadaily #beauty #nyc #goodvibes #usa #lifestyle #photo #explore #instamood #newyork #beach"),
                        new MyListData("Feelings", "#feelings #love #quotes #life #lovequotes #poetry #sad #instagram #emotions #follow #instagood #thoughts #like #happy #photography #art #loveyourself #heart #motivation #music #mood #writersofinstagram #shayari #me #happiness #brokenheart #words #followforfollowback #likeforlikes #bhfyp"),
                        new MyListData("Heartbreak", "#bollywood #mental #physical #brokenheart #romantic #pain #loveyourself #smile #thoughts #portrait #family #dark #india #passion #artist #writersofinstagram #bhfyp #happiness #selflove #trending #song #mood #photooftheday #selfcare #portraits #mentalhealthawareness #health #friends #depression #fun"),
                        new MyListData("Sad", "tagssssssss"),
                        new MyListData("Angry", "tagssssssss"),
                        new MyListData("Moody", "tagssssssss"),

                };
                break;

            case "Button22":
                mainCategory.setText("Health");
                myListData = new MyListData[] {
                        new MyListData("Health", "#healthyliving #gethealthy #healthyeating #healthiswealth #womenshealth #mentalhealth #mentalhealthawareness #healthydiet #healthyskin #healthandwellness #eathealthy #cbdhealth #holistichealth #instahealth #healthylifestyle #healthyfood #healthychoices #healthyhair #menshealth #healthyrecipes #healthylife #healthybreakfast #healthybody #healthymind"),
                        new MyListData("Healthy", "#healthydiet #healthcare #healthyhabits #healthandfitness #healthyskin #healthyeats #stayhealthy #healthydrink #behealthy #healthjourney #healthcoach #healthymind #healthyish #mentalhealthrecovery #healthyvegan #goodhealth #healthtech #instahealthy #healthyme #hormonehealth #healthyoptions #healthforall #livinghealthy #healthynotskinny"),
                        new MyListData("Diet", "#healthydiet #healthcare #healthyhabits #healthandfitness #healthyskin #healthyeats #stayhealthy #healthydrink #behealthy #healthjourney #healthcoach #healthymind #healthyish #mentalhealthrecovery #healthyvegan #goodhealth #healthtech #instahealthy #healthyme #hormonehealth #healthyoptions #healthforall #livinghealthy #healthynotskinny"),
                        new MyListData("Fit", "#fit #fitness #gym #workout #fitnessmotivation #motivation #bodybuilding #training #fitfam #healthy #health #lifestyle #gymlife #sport #love #instagood #healthylifestyle #muscle #fitnessmodel #gymmotivation #exercise #personaltrainer #instafit #fitspo #crossfit #strong #fitnessgirl #fitnessaddict #weightloss #bhfyp"),
                        new MyListData("Obesity", "#obesity #weightloss #diabetes #health #healthylifestyle #fitness #weightlossjourney #diet #nutrition #fat #t #diabetestype #healthy #overweight #weightlosstransformation #sleevegastrectomy #obezite #bariatricsurgery #obese #healthyfood #covid #obezitecerrahisi #obesitysurgery #fit #motivation #fightingobesity #gastricbypass #cancer #type #bhfyp"),
                        new MyListData("Skinny", "#thin #skinny #thinspo #ana #fat #weightloss #skinnylegs #fitness #anorexia #mia #thinspiration #eatingdisorder #beauty #like #love #skinnygirl #aesthetic #collarbones #beautiful #thighgap #ed #fashion #anamia #motivation #slim #healthy #girl #model #goals #bhfyp"),
                        new MyListData("Nutrition", "#nutrition #fitness #health #healthylifestyle #healthy #healthyfood #weightloss #diet #motivation #gym #workout #wellness #fit #food #lifestyle #fitnessmotivation #bodybuilding #healthyliving #healthyeating #vegan #fitfam #protein #exercise #training #nutritionist #eatclean #personaltrainer #foodie #cleaneating #bhfyp"),
                        new MyListData("Protien", "tagssssssss"),

                };
                break;

            case "Button23":
                mainCategory.setText("Photography");
                myListData = new MyListData[] {
                        new MyListData("Photography", "#bnwphotography #photogram #blackandwhitephotography #weddingphotographer #foodphotography #streetphotographer #photographysouls #photographyislife #photographie #fashionphotographer #travelphoto #urbanphotography #photographylover #landscapephotography #photographyislifee #iphonephotography #newbornphotography #photomodel #fashionphotography #architecturephotography #dronephotography #photos #portraitphotography #photograph"),
                        new MyListData("Photography", "#photographers #lifestylephotography #toyphotography #familyphotography #photoshop #houstonphotographer #photosession #wildlifephotography #concertphotography #photoftheday #photoaday #bestphoto #bw_photooftheday #photoshooting #fineartphotography #childrenphoto #amateurphotography #analogphotography #weddingphotography #photographylovers #filmphotography #commercialphotography #canon_photos #photographyeveryday #mobilephotography #instaphotography #pnwphotographer"),
                        new MyListData("Photography", "#babyphotography #photographerlife #instagoodmyphoto #photoart #weddingphoto #uwphotography #photogrid #photographers_of_india #directorofphotography #photochallenge #indianphotography #macrophotography #bookphotography #35mmstreetphotography #photoeveryday #blackandwhitephoto #nightphotography #naturephoto #streetphoto #portraitphotographer #nikonphotography #photographs #canonphotography #foodphoto #ig_photooftheday #feelgoodphoto #foodphotos"),
                        new MyListData("Minimalism", "#simpleandpure #minimalismo #minimalista #minimalist #minimalplanet #simplicity #beautiful #minimalove #minimalninja #instagood #minimalism #lessismore #minimalobsession #photooftheday #minimal #love #aesthetic #art #minimalissimo #nordicminimalism #learnminimalism #minimalistic #minimalism_world #vsco #negativespace #keepitsimple #minimalistics #simple"),
                        new MyListData("HDR", "#hdr #hdriphoneographer #hdrspotters #hdrstyles_gf #hdri #hdroftheday #hdriphonegraphy #hdrepublic #hdr_lovers #awesome_hdr #instagood #hdrphotography #photooftheday #hdrimage #hdr_gallery #hdr_love #hdrfreak #hdrama #hdrart #hdrphoto #hdrfusion #hdrmania #hdrstyles #ihdr #str8hdr #hdr_edits"),
                        new MyListData("Abstract", "#abstract #art #abstractart #photography #instapic #abstracters_anonymous #abstract_buff #abstraction #instagood #creative #artsy #beautiful #photooftheday #abstracto #stayabstract #instaabstract "),
                        new MyListData("Selfies", "#selfie #selfienation #selfies #me #love #pretty #handsome #instagood #instaselfie #selfietime #face #shamelessselefie #life #hair #portrait #igers #fun #followme #instalove #smile #igdaily #eyes #follow"),
                        new MyListData("Portrait", "#portraitvision #portrait_shot #portrait_shots #selfportrait #portrait_vision #portrait_perfection #portraitkillers #makeportraitsnotwar #vscoportrait #portraitsmag #portraitpainting #discoverportrait #folkportraits #portrait_mood #portraits_universe #portrait_ig #postmoreportraits #rsa_portraits #portraitperfection #portraitoftheday #portraitsociety #portraitstream #instaportrait #portraitshoot #portraitsfromtheworld #aovportraits #portraits_ig"),
                        new MyListData("Picture", "#photo #photos #pic #pics #picture #pictures #snapshot #art #beautiful #instagood #picoftheday #photooftheday #color #all_shots #exposure #composition #focus #capture #moment #vsco"),
                        new MyListData("Back And White", "tagssssssss"),
                        new MyListData("Photojournalism", "#blackandwhite #bnw #monochrome #instablackandwhite #monoart #insta_bw #bnw_society #bw_lover #bwphotooftheday #photooftheday #bw #instagood #bw_society #bw_crew #bwwednesday #insta_pick_bw #bwstyles_gf #irox_bw #igersbnw #bwstyleoftheday #monotone #monochromatic#noir #fineart_photobw"),
                        new MyListData("City Light", "tagssssssss"),
                        new MyListData("Abstract", "tagssssssss"),
                        new MyListData("Adventure", "tagssssssss"),
                        new MyListData("Advertisement", "tagssssssss"),

                };
                break;

            case "Button24":
                mainCategory.setText("Modeling");
                myListData = new MyListData[] {
                        new MyListData("Model", "#model #fashion #photography #love #style #instagood #photooftheday #beauty #like #instagram #beautiful #follow #art #photo #portrait #photoshoot #cute #picoftheday #myself #girl #modeling #smile #me #photographer #makeup #happy #likeforlikes #selfie #bhfyp #bhfyp"),
                        new MyListData("Modeling", "#models #bhfyp #modelsearch #instadaily #followforfollowback #nature #fashionmodel #likes #fashionista #kerala #instafashion #shooting #happy #selfie #look #mood #lifestyle #fashionphotography #india #mumbai #comment #music #bollywood #viral #modelingagency #pose #fashionstyle #canon #loveyourself #actor"),
                        new MyListData("Glamour", "tagssssssss"),
                        new MyListData("Sizzling", "tagssssssss"),

                };
                break;

            case "Button25":
                mainCategory.setText("Inspiration");
                myListData = new MyListData[] {
                        new MyListData("Inspiration", "#interiorinspiration #inspirationalquote #logoinspiration #tattooinspiration #travelinspiration #gardeninspiration #foodinspiration #ootdinspiration #slimmingworldinspiration #nailsinspiration #inspirationcultmag #bujoinspiration #weightlossinspiration #bridalinspiration #logoinspirations #fashioninspiration #designinspiration #homeinspiration #fitinspiration #inspirations #dailyinspiration #knitting_inspiration #hairinspiration #makeupinspiration #hijabinspiration #myinspiration"),
                        new MyListData("Motivation", "#motivation #fitness #inspiration #love #life #instagood #quotes #lifestyle #success #motivationalquotes #workout #instagram #gym #goals #happy #believe #follow #mindset #positivevibes #fitnessmotivation #fit #training #happiness #bhfyp #selflove #like #health #entrepreneur #bodybuilding #bhfyp"),
                        new MyListData("Thoughts", "#thoughts #love #quotes #poetry #writersofinstagram #life #quoteoftheday #yourself #instadaily #words #writer #quote #loveyourself #photooftheday #quotestagram #inspirationalquotes #photography #wordsofwisdom #writing #bhfyp #motivation #mindset #wordporn #followforfollowback #instagram #sad #goals #follow #writersofig #bhfyp"),
                        new MyListData("Dedication", "#dedication #motivation #fitness #hardwork #gym #bodybuilding #workout #inspiration #fit #determination #fitnessmotivation #goals #gymlife #love #muscle #training #lifestyle #fitfam #strength #success #focus #passion #instafit #strong #life #nevergiveup #gains #grind #shredded #bhfyp"),
                        new MyListData("Passionate", "tagssssssss"),
                        new MyListData("Failure", "tagssssssss"),
                        new MyListData("Hard Work", "#hardwork #motivation #fitness #success #nevergiveup #fitnessmotivation #dedication #workout #love #gym #hustle #follow #like #goals #work #training #inspiration #yourself #happy #life #bodybuilding #loveyourself #believe #passion #entrepreneurship #lifestyle #entrepreneurlife #bhfyp #successmindset #bhfyp"),

                };
                break;

            case "Button26":
                mainCategory.setText("Nature");
                myListData = new MyListData[] {
                        new MyListData("Nature 1", "#natureza #mothernature #nature_prefection #naturepics #naturelove #nature_wizards #natureperfection #natureart #beautyofnature #natureporn #ig_nature #naturegram #nature_seekers #naturediversity #lovenature #instanaturelover #instanature #natureisbeautiful #naturelover #nature_perfection #ilovenature #nature_lovers #naturewalk #natureonly"),
                        new MyListData("Nature 2", "#nature_shooters #naturebeauty #nature_of_our_world #natures #allnatureshots #naturelife #natureaddict #bestnatureshot #natureshots #natureloversgallery #nature_brilliance #naturephotographer #nature_good #naturephoto #naturepic #moody_nature #naturephotos #naturehippys #nature_photo #naturesbeauty #naturegeography #naturel #naturelover_gr #natureshot" ),
                        new MyListData("Nature 3", "#inspiredbynature #beautifulnature #vsconature #ig_naturelovers #naturezaperfeita #fotofanatics_nature_ #ignature #pocket_allnature #show_us_nature #photonature #rsa_nature #tagsta_nature #wildnature #arte_of_nature #world_bestnature #finnishnature #nature_cuties #nature_sultans #backtonature #naturerepublic #tv_allnature #instanaturefriends #signature #bestnatureshots #bns_nature"),
                        new MyListData("Beach", "#beachday #love #beachlife\uD83C\uDF34 #beachwaves #beaches #beachside #beachlife #vibes #relax #beachlover #beachy #beachlovers #beachwear #beach #beachbaby #like #sandy #chill #saltlife #beachfront #ocean #beachtime #beachbum #beachdays #beachvibes #sand #waves #beachstyle"),
                        new MyListData("Flowers", "#ptk_flowers #ig_flowers #freshflowers #paperflowers #flowercrown #wildflowers #springflowers #tv_flowers #flowersandmacro #superb_flowers #yellowflowers #driedflowers #flowergarden #flowerstalking #flowerphotography"),
                        new MyListData("Flowers", "#weddingflowers #flowermagic #floweroftheday #instaflower #flowerslovers #flowerporn #instaflowers #flowershop #flowergirl #flowerarrangement #sunflower #sunflowers #flowerpower #flowerlovers #flowertattoo #flowery #flowerstyles_gf #flowercrown #flowersandmacro #flowers_super_pics #flowergram #flowerstalking #flowerphotography #flowerlover"),
                        new MyListData("Sunsets", "#sunsetlovers #sunsetporn #sunset_pics #super_photosunsets #all_sunsets #sunsethunter #sunsets #sunset_stream #sunsetlover #ig_sunsetshots #sunset_vision #sunset_madness #sunrise_sunset_photogroup #quotestoliveby #sunsetphotography #sunrise_and_sunsets #sunset\uD83C\uDF05 #instasunsets #sunsetsniper #sunset_ig #sunsetbeach #sunsetsky #sunset_hub #sunrise_sunsets_aroundworld #instasunset"),
                        new MyListData("Sunrises", "#sunsetlovers #sunsetporn #sunset_pics #super_photosunsets #all_sunsets #sunsethunter #sunsets #sunset_stream #sunsetlover #ig_sunsetshots #sunset_vision #sunset_madness #sunrise_sunset_photogroup #quotestoliveby #sunsetphotography #sunrise_and_sunsets #sunset\uD83C\uDF05 #instasunsets #sunsetsniper #sunset_ig #sunsetbeach #sunsetsky #sunset_hub #sunrise_sunsets_aroundworld #instasunset"),
                        new MyListData("Forest", "#forest #nature #naturephotography #photography #trees #tree #landscape #naturelovers #travel #hiking #green #love #mountains #photooftheday #woods #forestphotography #spring #adventure #outdoors #wildlife #beautiful #art #photo #wald #naturelover #instagood #explore #landscapephotography #sky #bhfyp"),
                        new MyListData("Fog", "#fog #nature #photography #landscape #foggy #naturephotography #mist #mountains #travel #fearofgod #forest #sunrise #clouds #ig #landscapephotography #photooftheday #trees #sky #foggymorning #morning #instagood #sunset #winter #mountain #love #tree #art #nebel #bnw #bhfyp"),
                        new MyListData("Fall", "tagssssssss"),
                        new MyListData("Rain", "#rain #nature #photography #rainyday #love #clouds #naturephotography #photooftheday #sky #weather #instagood #instagram #storm #art #water #rainbow #photo #travel #beautiful #raindrops #picoftheday #rainy #sunset #india #ig #like #flowers #summer #landscape #bhfyp"),
                        new MyListData("Lake", "tagssssssss"),
                        new MyListData("Cold", "#cold #winter #snow #nature #love #photography #ice #instagood #photooftheday #travel #follow #beautiful #like #mountains #instagram #sky #coldweather #hot #life #picoftheday #frozen #art #freezing #landscape #happy #summer #photo #fashion #white #bhfyp"),
                        new MyListData("Snowfall", "tagssssssss"),
                        new MyListData("Rainbow", "#rainbow #love #pride #art #gay #lgbt #handmade #r #nature #photography #lgbtq #loveislove #colors #colorful #instagood #beautiful #cute #makeup #unicorn #rain #pridemonth #follow #color #like #sky #instagram #artist #photooftheday #fashion #bhfyp"),
                        new MyListData("Peace", "tagssssssss"),
                        new MyListData("Wildlife", "tagssssssss"),
                        new MyListData("Sea", "tagssssssss"),
                        new MyListData("Weather", "tagssssssss"),

                };
                break;

            case "Button27":
                mainCategory.setText("Quality");
                myListData = new MyListData[] {
                        new MyListData("Handsome", "#handsome #love #cute #follow #instagood #model #like #actor #beautiful #instagram #fashion #photooftheday #smile #boy #photography #style #me #selfie #happy #picoftheday #followme #cool #man #life #sexy #likeforlikes #hot #myself #men #bhfyp"),
                        new MyListData("Beautiful", "#beautiful #love #instagood #photooftheday #like #photography #fashion #follow #picoftheday #instagram #smile #me #beauty #cute #happy #art #instadaily #nature #style #myself #bhfyp #followme #likeforlikes #photo #instalike #model #girl #likes #life #bhfyp"),
                        new MyListData("Charming", "#charm #charms #pandora #handmade #jewelry #love #fashion #cute #bracelet #silver #style #necklace #pendant #beads #beautiful #art #accessories #earrings #beauty #pandorabracelet #emas #trendy #jewellery #bahancraft #gold #kawaii #bracelets #keychain #clay #bhfyp"),
                        new MyListData("Sexy", "#sexy #love #model #hot #fashion #beautiful #like #follow #beauty #cute #girl #instagood #photography #fitness #style #instagram #photooftheday #followforfollowback #girls #likeforlikes #lingerie #pretty #music #picoftheday #portrait #summer #followme #art #lifestyle #bhfyps"),
                        new MyListData("Hot", "#hot #love #sexy #like #follow #cute #beautiful #instagood #model #fashion #summer #photooftheday #girl #beauty #instagram #followme #photography #cool #style #picoftheday #smile #happy #art #girls #food #fun #me #life #pretty #bhfyp"),
                        new MyListData("Gorgeous", "#gorgeous #beautiful #beauty #love #cute #fashion #pretty #model #stunning #instagood #queen #photography #amazing #like #actress #photooftheday #follow #sexy #style #instagram #makeup #smile #lovely #photoshoot #girl #picoftheday #hot #nature #happy #bhfyp"),
                        new MyListData("Lovely", "#lovely #love #l #like #follow #cute #life #smile #beautiful #style #me #myself #instadaily #followme #fun #selfie #instamood #pic #mylife #looks #instapicture #self #igers #pose #instaselfie #igdaily #onlyme #myway #instagood #bhfyp"),
                        new MyListData("Funny", "#funny #memes #meme #funnymemes #lol #dankmemes #comedy #fun #love #follow #memesdaily #like #humor #instagram #funnyvideos #tiktok #instagood #lmao #dank #cute #jokes #dailymemes #laugh #edgymemes #bhfyp #offensivememes #explorepage #happy #dankmeme #bhfyp"),
                        new MyListData("Ugly", "#ugly #like #love #follow #sad #art #selfie #cute #me #likes #funny #beautiful #fat #music #instagram #myself #l #memes #girl #depressed #alone #bored #likeforlikes #photography #aesthetic #drawing #happy #instagood #suicide #bhfyp"),
                        new MyListData("Cute", "#cute #love #instagood #beautiful #like #happy #photooftheday #follow #fashion #smile #instagram #art #girl #style #me #photography #picoftheday #beauty #model #myself #followme #selfie #photo #instadaily #life #fun #bhfyp #likeforlikes #nature #bhfyp"),
                        new MyListData("Stylish", "#stylish #fashion #style #love #instafashion #instagood #fashionista #ootd #beautiful #fashionblogger #photooftheday #model #outfit #beauty #shopping #cute #fashionstyle #streetstyle #dress #fashionable #shoes #design #girl #like #accessories #trendy #onlineshopping #instastyle #follow #bhfyp"),
                        new MyListData("Bad", "#bad #love #sad #good #michaeljackson #instagram #like #music #follow #kingofpop #mj #instagood #life #thriller #art #photography #moonwalker #mjinnocent #s #o #likeforlikes #badezimmer #girl #badboy #l #f #cute #billiejean #xxxtentacion #bhfyp"),
                        new MyListData("Cool", "#cool #love #like #instagood #follow #fashion #style #instagram #cute #beautiful #photography #photooftheday #art #amazing #fun #happy #picoftheday #smile #life #photo #followme #me #beauty #model #funny #awesome #friends #likeforlikes #summer #bhfyp"),
                        new MyListData("Hot", "tagssssssss"),
                        new MyListData("Sizzling", "tagssssssss"),
                        new MyListData("Modern", "tagssssssss"),
                        new MyListData("Glalmourous", "tagssssssss"),

                };
                break;

            case "Button28":
                mainCategory.setText("Reading & Writing");
                myListData = new MyListData[] {
                        new MyListData("Reading", "#art #artists #author #authors #bloggers #book #booklover #booknerd #books #bookworm #ebook #ebooks #education #entrepreneur #fantasy #fiction #indie #Kindle #literacy #literature #love #magazine #novel #novels #poem #poet #poetry #quotes #read #readers #reading #romance #scifi #thriller #writer #writers  #writetip #writing #writingtips"),
                        new MyListData("Writing", "tagssssssss"),
                        new MyListData("Books", "#bookstagram #books #bookish #bookstagramfeature #bookstore #book #booksbooksbooks #bookaddict #bookshelf #booknow #bookphotography #bookaholic #childrensbooks #comicbooks #booklove #booklover #kidsbooks #booksofinstagram #booknerd #bookstagrammer #yabooks #lovebooks #ilovebooks #instabooks #bookworm #bookme #bookshop"),
                        new MyListData("News", "#newsong #bitcoinnews #strongisthenewskinny #newseason #fakenews #newsingle #newstock #newstart #freefirenews #artnews #newstyle #cryptonews #fortnitenews #sneakernews #newschool #newshoes #goodnews #newsouthwales #newspaper #breakingnews"),
                        new MyListData("Quotes", "#motivationquotes #quotesaboutlife #quotestagram #moviequotes #relationshipquotes #quotesdaily #funnyquotes #quotesgram #quotestoinspire #quotestoremember #bookquotes #quotesandsayings #inspiringquotes #sadquotes #positivequotes #quotesoftheday #entrepreneurquotes #successquotes #dailyquotes #instaquotes #quotestags #pinquotes #tumblrquotes #quotesofinstagram #islamicquotes #businessquotes #quotesindonesia"),
                        new MyListData("Tutorial", "#tutorial #hairtutorial #tutorials #tutorialmakeup #ccptutorial #makeuptutorials #hijabtutorial #tutorialhijab #videotutorial #drawingtutorial #makeuptutorialsx0x #lightroomtutorials #nailarttutorial #eyemakeuptutorial #eyebrowtutorial #makeuptutorialx0x #eyeshadowtutorial #tutorialmakeupnatural #tutorialmakeupsimple #youtubetutorial #caketutorial #eyelinertutorial #arttutorial #alightmotiontutorial #hairtutorials"),

                };
                break;

            case "Button29":
                mainCategory.setText("Travel");
                myListData = new MyListData[] {
                        new MyListData("Travel 1", "#travelgirl #traveldeeper #travelholic #wearetravelgirls #travellove #travellers #traveltheworld #travelwriter #traveladdict #travelpics #welltravelled #traveldiary #traveler #girlslovetravel #dametraveler #travelmore #lovetotravel #travelblog #travelingram #travelguide #travels #travelpic #instatraveling #mytravelgram #travelbloggers #travelawesome #travellover"),
                        new MyListData("Travel 2", "#luxurytravel #travelgoals #travelasia #travelphoto #traveller #travelstoke #traveldiaries #travelandlife #doyoutravel #travelphotos #travel_captures #travelers #travelcouple #girlswhotravel #travelbug #travel_drops #travelph #travelporn #travelbag #worldtravel #traveltips #travelworld #coupletravel"),
                        new MyListData("Travel 3", "#femmetravel #instatravelling #solotravel #natgeotravel #ilovetravel #familytravel #bestintravel #travelingourplanet #forbestravelguide #travelwithkids #travelphotographer #womenwhotravel #traveljournal #lifewelltravelled #worldtraveler #iamatraveler #traveleurope #travellife #ig_travel #bbctravel #travelislife #travellingthroughtheworld #livetravelchannel #lovetravel"),
                        new MyListData("Home", "#homestyling #pocketofmyhome #luxuryhomes #homeoffice #homecoming #homeinspo #athome #dreamhome #homem #newhome #stayathomemom #homedecoration #homeinspiration #inspohome #luxuryhome #homebuyers #homeschool #homestyle #homes #gohardorgohome #homemadefood #homework #homegrown #homebaker #homeware #homegarden #homecook"),
                        new MyListData("Vacation", "#hills #nature #mountains #travel #photography #landscape #naturephotography #india #travelphotography #clouds #love #sky #adventure #uttarakhand #hiking #photooftheday #instagood #wanderlust #landscapephotography #view #travelgram #sunset #himalayas #green #ig #trees #instagram #mountain #naturelovers #bhfyp"),
                        new MyListData("Holiday", "tagssssssss"),
                        new MyListData("Hills", "tagssssssss"),
                        new MyListData("Geo", "#geo #geology #nature #geologist #x #geografia #geologia #a #con #geologyrocks #geography #o #earth #geological #rocks #geologiaestructural #pakistan #photography #structuralgeology #geologypage #softlensmurah #travel #zuk #geologists #minerals #science #ingenier #enem #geomorphology #bhfyp\n"),
                        new MyListData("Location", "tagssssssss"),

                };
                break;

            case "Button30":
                mainCategory.setText("Weather & Season");
                myListData = new MyListData[] {
                        new MyListData("Sunshine", "#summerishere #hotgirlsummer #summerlove #summerfeeling #summer2017 #summernight #summerlovin #summeriscoming #readyforsummer #summer2013 #5secondsofsummer #springsummer #hotsummer #indiansummer #summercamp #summercollection #summer2016 #summerwedding #summersale #summerholiday #summer2018 #summerholidays #summer2015 #summermood #summer16 #lovesummer #summer2014"),
                        new MyListData("Sunny", "#summertime #summertimeshine #endlesssummer #summerday #summerfashion #summers #summerbody #summerbreak #summer17 #summernails #summernights #summerdays #summer18 #summer2019 #summerdress #instasummer #summerweather #endofsummer #summerlook #summeroutfit #summer19 #summerstyle #summerready #summervibes #summerfun #summervacation #summerhair"),
                        new MyListData("Summer", "#clearskies #blueskies #instagood #weather #sun #beautiful #sunny #sunnyday\uD83C\uDF1E #photooftheday #goodday #beautifulday #sunnyday☀️ #sunrays #summer #sunnyday #sky #sunnydays #nature #shine #goodweather #thesun #bright #sunlight #brightsun #sunny☀️ #light #clearsky #sunshine"),
                        new MyListData("Rain", "#pouring #raindrops #rain #rainyday #rainyday☔ #raining #puddle #cloudy #instagood #rainraingoaway #rainydayz #splash #rainyday #umbrella #instarain #water #clouds #rainydays #gloomy #rain #downpour #rainyweather #love #like"),
                        new MyListData("Winter", "#winter #cold #holidays #snow #rain #christmas #snowing #blizzard #snowflakes #wintertime #staywarm #cloudy #instawinter #instagood #holidayseason #photooftheday #season #seasons #nature"),
                        new MyListData("Cloudy", "#insta_sky_lovers #iskyhub #weather #cloudy #photooftheday #cloudy☁️ #cloud #instasky #overcast #instaclouds #beautiful #epicsky #cloudyday☁️ #cloudyskies #cloud_skye #skyback #sky #gloomy #skyporn #lookup #horizon #cloudporn #skies #instagood #skyline #crazyclouds #nature #instacloud #clouds"),
                        new MyListData("Storm", "tagssssssss"),
                        new MyListData("Fall", "#fall #nature #autumn #instaautumn #instagood #bestseason #seasons #fallfashion #autumnvibes\uD83C\uDF41 #leaves #autumnweather #red #season #foliage #falltime #fallstyle #autumn\uD83C\uDF41 #instafall #leaf #colorful #orange #photooftheday #fall\uD83C\uDF41 #fallweather #loveautumn"),
                        new MyListData("Spring", "#instagood #springtime #bloom #love #spring #springfashion #pretty #trees #ilovespring #instaspring #springishere #flowers #colorful #color #like #sunny #season #lovespring #seasons #sun #springbreak #springday #blossom #bestseason #warm #tree #springflowers #flower #beautiful"),
                        new MyListData("Snow", "#snowing #weather #snowflakes #white #nature #instasnow #snowfall #cold #chilly #frost #frosty #ice #instagood #snowing #instawinter #snowfall #skies #sky #blizzard #❄️ #snow #whiteout #snowflake #love #like #snow❄️ #winter"),
                        new MyListData("Autumn", "#seasons #trees #autumnoutfit #autumnmood #autumn #fall #autumnfashion #sky #autumnweather #autumnvibes #autumntime #follow #love #fall\uD83C\uDF41 #style #nature #season #autumnleaves #autumnvibes\uD83C\uDF41 #autumn\uD83C\uDF41 #photography #outdoors #like #fallcolors #colors #autumnstyle #landscape #leaves #autumncolors"),

                };
                break;

            case "Button31":
                mainCategory.setText("Designs");
                myListData = new MyListData[] {
                        new MyListData("Interior", "#interiorinspiration #interiorlovers #interiorinspo #interiorideas #interior123 #interior2you #interior4all #interiordetails #designerdeinteriores #interior_design #interiordesignideas #interior125 #interiorismo #interiorwarrior #interiordecoration #interiorstyling #designinterior #interiorstylist #interiordecor #interior_and_living #interiordesigner #interiorstyle #luxuryinteriors #interiorarchitecture #interiores #interiordecorating #homeinterior"),
                        new MyListData("Design", "#diseñointerior #arquiteturadeinteriores #interior4you #homeinteriors #interiordesigners #interior125 #interiordesignideas #interiorandhome #decoraciondeinteriores #pazinterior #homeinterior #designdeinteriores #passion4interior #interiorrumah #diseñodeinteriores #interior4inspo" ),
                        new MyListData("Interior Design", "#instadecor #vintagedecor #interiordecor #homedecorideas #decorations #housedecor #bedroomdecor #kitchendecor #rusticdecor #weddingdecor #walldecor #decorating #cakedecorating #partydecor #inspire_me_home_decor #homedecorating #partydecorations #christmasdecor #tabledecor #decoracion #interiordecorating #decoratedcookies #livingroomdecor #nurserydecor #farmhousedecor #roomdecor #homedecoration"),
                        new MyListData("Mehandi design", "tagssssssss"),
                        new MyListData("Designer", "tagssssssss"),
                        new MyListData("Design", "#graphicdesign #designinspiration #graphicdesigner #webdesign #tattoodesign #designinterior #scandinaviandesign #luxurydesign #hoteldesign #designs #designporn #furnituredesign #kitchendesign #jewelrydesign #interiordesigner #naildesign #setdesign #fashiondesign #homedesign #fashiondesigner #livingroomdesign #designer #interiordesign #typedesign #characterdesign #jewelrydesigner #nordicdesign"),
                        new MyListData("Decor 1", "#halloweendecor #decorideas #decorate #weddingdecoration #cakedecoration #partydecor #inspire_me_home_decor #kidsroomdecor #decorationideas #decorar #unhasdecoradas #decoración #bolosdecorados #decoraciondeinteriores #decora #christmasdecorations #tabledecor"),
                        new MyListData("Decor 2", "\n" +
                                "#industrialdesign #designers #creativedesign #tshirtdesign #jewellerydesigner #designdeinteriores #naildesigner #designerclothes #contemporarydesign #designersaree #cakedesign #packagingdesign #designerbags #fashiondesigners #branddesign #instadesign #restaurantdesign #floraldesign #naildesigns #designerdeinteriores #costumedesign #nailsdesign #designgrafico #mydesign\n"),

                };
                break;

            case "Button32":
                mainCategory.setText("DIY");
                myListData = new MyListData[] {
                        new MyListData("Diy", "#diy #handmade #art #n #homedecor #doityourself #craft #design #love #crafts #woodworking #homemade #interiordesign #home #diyprojects #decor #sewing #diyhomedecor #creative #diycrafts #wood #instagood #d #fashion #interior #m #o #crafting #diyproject #bhfyp"),
                        new MyListData("Decor", "#decor #homedecor #interiordesign #design #home #interior #decoration #o #art #decora #architecture #interiors #handmade #homedesign #furniture #decoracao #love #arquitetura #style #homesweethome #luxury #inspiration #designer #interiordesigner #interiordecor #designdeinteriores #vintage #wedding #instagood #bhfyp"),
                        new MyListData("Selfmade", "#homemade #food #foodporn #foodie #instafood #yummy #foodphotography #delicious #foodstagram #foodblogger #foodlover #handmade #healthyfood #instagood #cooking #homecooking #cake #dessert #tasty #love #baking #homemadefood #foodgasm #dinner #foodies #healthy #lunch #vegan #chocolate #bhfyp"),
                        new MyListData("Home", "#home #homedecor #interiordesign #design #interior #love #homesweethome #decor #realestate #house #architecture #homedesign #instagood #art #casa #photography #decoration #stayhome #family #instagram #nature #realtor #style #interiors #furniture #luxury #like #photooftheday #lifestyle #bhfyp\n" +
                                "\n"),
                        new MyListData("Home Decor", "#homestyling #homeinspo #homedecoration #pocketofmyhome #homecoming #homeoffice #homecook #homegarden #homeware #luxuryhomes #homebaker #homemadefood #homework #homegrown #stayathomemom #newhome #homem #athome #dreamhome #homeinspiration #luxuryhome #inspohome #homebuyers #homeschool #homestyle #homes #gohardorgohome"),

                };
                break;


        }





        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



    }

    // Implement listener methods:
    private class UnityBannerListener implements BannerView.IListener {
        @Override
        public void onBannerLoaded(BannerView bannerAdView) {
            // Called when the banner is loaded.
        }

        @Override
        public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {
            Log.d("SupportTest", "Banner Error" + errorInfo);
            // Note that the BannerErrorInfo object can indicate a no fill (see API documentation).
        }

        @Override
        public void onBannerClick(BannerView bannerAdView) {
            // Called when a banner is clicked.
        }

        @Override
        public void onBannerLeftApplication(BannerView bannerAdView) {
            // Called when the banner links out of the application.
        }
    }
}
