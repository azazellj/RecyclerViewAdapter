package com.azazellj.baservadapter.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.azazellj.baservadapter.R;
import com.azazellj.baservadapter.databinding.ActivityMainBinding;
import com.azazellj.baservadapter.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AnimalsAdapter adapter;
    private ActivityMainBinding mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initData();
    }

    private void initViews() {
        mView = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new AnimalsAdapter();

        mView.animals.setLayoutManager(new LinearLayoutManager(this));
        mView.animals.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Crow", "https://www.allaboutbirds.org/guide/PHOTO/LARGE/american_crow_8.jpg"));
        animals.add(new Animal("Elephant", "http://cdn2.arkive.org/media/E6/E6473E1B-5FBA-480B-B6E6-84F06963EB87/Presentation.Large/African-elephant-threat-display.jpg"));
        animals.add(new Animal("Monkey", "https://www.longleat.co.uk/api/v2/storage/public/assets/25/monkey-mayhem/monkey-grid-1_original_original.jpg"));
        animals.add(new Animal("Panther", "https://i.pinimg.com/736x/70/ec/d3/70ecd318b8ce408b9a86b84d97e9e67f--the-panthers-black-panther.jpg"));

        adapter.setItems(animals);
    }
}
