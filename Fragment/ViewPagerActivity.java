package com.radhey.myapplication.ViewPagerEx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.radhey.myapplication.R;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_pager);

        viewPager2 = findViewById(R.id.viewPager2);
        button1 = findViewById(R.id.fragBtn1);
        button2 = findViewById(R.id.fragBtn2);
        button3 = findViewById(R.id.fragBtn3);

        allButtonClick();
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(myAdapter);
    }

    private void allButtonClick(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(2);
            }
        });
    }
}