package com.example.libor.luckynine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView cardMach1,cardMach2,cardMach3,cardUser1,cardUser2,cardUser3;
    TextView actionText;

    int cardC1,cardC2,cardC3,cardU1,cardU2,cardU3;
    int sw=1;
    public Integer images[] = {R.drawable.acediamond, R.drawable.aceflower, R.drawable.aceheart, R.drawable.acespade, R.drawable.twodiamond, R.drawable.twoflower,
            R.drawable.twoheart,R.drawable.twospade,R.drawable.threediamond,R.drawable.threeflower,R.drawable.threeheart,R.drawable.threespade,
            R.drawable.fourdiamond,R.drawable.fourflower,R.drawable.fourheart,R.drawable.fourspade,  R.drawable.fivediamond,R.drawable.fiveflower,R.drawable.fiveheart,R.drawable.fivespade,
            R.drawable.sixdiamond,R.drawable.sixflower,R.drawable.sixheart,R.drawable.sevendiamond,R.drawable.sevenflower,R.drawable.sevenheart,R.drawable.sevenspade,
            R.drawable.eightdiamond,R.drawable.eightflower,R.drawable.eightheart,R.drawable.eightspade,R.drawable.ninediamond,R.drawable.nineflower,R.drawable.nineheart,R.drawable.ninespade,
            R.drawable.tendiamond,R.drawable.tenflower,R.drawable.tenheart,R.drawable.tenspade, R.drawable.jackdiamond,R.drawable.jackflower,R.drawable.jackheart,R.drawable.jackspade,
            R.drawable.queendiamond,R.drawable.queenflower,R.drawable.queenheart,R.drawable.queenspade,
            R.drawable.kingdiamond,R.drawable.kingflower,R.drawable.kingheart,R.drawable.kingspade};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiatecards();
//        deal2cards();
        addlisteneractiontext();
        addlistenerUserCard3();

    }

    private void addlistenerUserCard3() {

        cardUser3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = 52;


//                cardU3=(int)(Math.random()*x);

                while (cardC1 == cardC2 || cardC1 == cardC3 || cardC1 == cardU1 || cardC1 == cardU2

                        || cardC1 == cardU3 || cardC2 == cardC3 || cardC2 == cardU1 || cardC2 == cardU2
                        || cardC2 == cardU3 || cardC3 == cardU1 || cardC3 == cardU2 || cardC3 == cardU3) {

                    cardU3 = (int) (Math.random() * x);

                }

                cardUser3.setImageResource(images[cardU3]);



            }


        });



    }

    private void addlisteneractiontext() {
        actionText=(TextView)findViewById(R.id.actionText);



        actionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (sw==1){

                    deal2cards();

                    actionText.setClickable(false);
                    actionText.setText("Long press to lay card and issue decision");
                    sw=0;

                }


                else if  (sw==0){


                    cardMach1.setImageResource(images[cardC1]);
                    cardMach2.setImageResource(images[cardC2]);
                    Toast.makeText(MainActivity.this,
                            "Module for game decision", Toast.LENGTH_LONG).show();
                    actionText.setText("Long press to deal a new game");
                    sw=1;


                }

            }
        });

    }

    private void deal2cards() {

        int no=51;

        cardC1=100;
        cardC2=100;
        cardC3=100;
        cardU1=100;
        cardU2=100;
        cardU3=100;


        clearcards();



        while (cardC1==cardC2 || cardC1==cardU1 || cardC1==cardU2 || cardU1==cardU2) {

            cardC1 = (int) (Math.random() * no);
            cardC2 = (int) (Math.random() * no);
//        cardC3=(int)(Math.random()*no);
            cardU1 = (int) (Math.random() * no);
            cardU2 = (int) (Math.random() * no);
//        cardU3=(int)(Math.random()*no);

        }
//        cardMach1.setImageResource(images[cardC1]);
//       cardMach2.setImageResource(images[cardC2]);
//        cardMach3.setImageResource(images[cardC3]);
        cardUser1.setImageResource(images[cardU1]);
        cardUser2.setImageResource(images[cardU2]);
//        cardUser3.setImageResource(images[cardU3]);


    }

    private void clearcards() {

        cardMach1.setImageResource(R.drawable.unknowncard1);
        cardMach2.setImageResource(R.drawable.unknowncard1);
        cardMach3.setImageResource(R.drawable.unknowncard1);
        cardUser1.setImageResource(R.drawable.unknowncard2);
        cardUser2.setImageResource(R.drawable.unknowncard2);
        cardUser3.setImageResource(R.drawable.unknowncard2);
    }

    private void instantiatecards() {
        cardMach1=(ImageView) findViewById(R.id.cardMach1);
        cardMach2=(ImageView) findViewById(R.id.cardMach2);
        cardMach3=(ImageView) findViewById(R.id.cardMach3);
        cardUser1=(ImageView) findViewById(R.id.cardUser1);
        cardUser2=(ImageView) findViewById(R.id.cardUser2);
        cardUser3=(ImageView) findViewById(R.id.cardUser3);

    }

}
