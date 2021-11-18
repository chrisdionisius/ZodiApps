package com.example.zodiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ZodiacDetails extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_DETAILS = "extra_details";
    public static final String EXTRA_PICTURE = "extra_picture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_details);

        Button btnOpenSite = findViewById(R.id.btn_open_site);
        btnOpenSite.setOnClickListener(this);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String date = getIntent().getStringExtra(EXTRA_DATE);
        String details = getIntent().getStringExtra(EXTRA_DETAILS);
        int image = getIntent().getIntExtra(EXTRA_PICTURE,0);

        TextView tvZodiacName = findViewById(R.id.tv_zodiac_name);
        TextView tvZodiacDate = findViewById(R.id.tv_zodiac_date);
        TextView tvZodiacDetails = findViewById(R.id.tv_zodiac_detail);
        ImageView imgZodiac = findViewById(R.id.img_zodiac);


        tvZodiacName.setText(name);
        tvZodiacDate.setText(date);
        tvZodiacDetails.setText("   "+details);
        imgZodiac.setImageResource(image);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_open_site) {
            String uri = "https://www.popbela.com/relationship/zodiac/andhina-effendi/urutan-zodiak-dan-cara-menentukannya/15";
            Intent openUrl = new Intent(Intent.ACTION_VIEW);
            openUrl.setData(Uri.parse(uri));
            startActivity(openUrl);
        }
    }
}