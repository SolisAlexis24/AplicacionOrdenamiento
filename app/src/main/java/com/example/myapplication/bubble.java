package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

import androidx.appcompat.app.AppCompatActivity;

public class bubble extends AppCompatActivity {
    ImageButton btprev, btnxt;
    ImageSwitcher imgSw;
    int[] imageList ={R.drawable.bubblepseudo, R.drawable.bubblepython, R.drawable.bubblec};
    int cont = imageList.length;
    int indiceActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bubble);
        Intent intent = getIntent();
        btnxt = (ImageButton)findViewById(R.id.NxtBT);
        btprev = (ImageButton)findViewById(R.id.PrevBT);
        imgSw = (ImageSwitcher)findViewById(R.id.Switcher);
        imgSw.setFactory(new ViewFactory(){
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        imgSw.setImageResource(imageList[0]);
        btprev.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSw.setInAnimation(bubble.this,R.anim.from_right);
                imgSw.setOutAnimation(bubble.this,R.anim.to_left);
                --indiceActual;
                if(indiceActual<0)
                    indiceActual=imageList.length-1;
                imgSw.setImageResource((imageList[indiceActual]));
            }
        });
        btnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSw.setInAnimation(bubble.this,R.anim.from_left);
                imgSw.setOutAnimation(bubble.this,R.anim.to_right);
                indiceActual++;
                if(indiceActual==cont)
                    indiceActual=0;
                imgSw.setImageResource(imageList[indiceActual]);
            }
        });
    }
}
