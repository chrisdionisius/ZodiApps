package com.example.zodiapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvZodiacs;
    private ArrayList<Zodiac> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvZodiacs = findViewById(R.id.rv_zodiacs);
        rvZodiacs.setHasFixedSize(true);

        list.addAll(ZodiacsData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent moveAbout = new Intent(MainActivity.this, AboutMe.class);
                startActivity(moveAbout);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    private void showRecyclerList(){
        rvZodiacs.setLayoutManager(new LinearLayoutManager(this));
        ListZodiacAdapter listZodiacAdapter = new ListZodiacAdapter(list);
        rvZodiacs.setAdapter(listZodiacAdapter);

        listZodiacAdapter.setOnItemClickCallback(new ListZodiacAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Zodiac data) {
                Intent moveWithDataIntent = new Intent(MainActivity.this, ZodiacDetails.class);
                moveWithDataIntent.putExtra(ZodiacDetails.EXTRA_NAME, data.getName());
                moveWithDataIntent.putExtra(ZodiacDetails.EXTRA_DATE, data.getDate());
                moveWithDataIntent.putExtra(ZodiacDetails.EXTRA_DETAILS, data.getDetail());
                moveWithDataIntent.putExtra(ZodiacDetails.EXTRA_PICTURE, data.getPicture());
                startActivity(moveWithDataIntent);
            }
        });

    }
}