package com.example.contact.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contact.Adapter.FavAdapter;
import com.example.contact.Adapter.MyAdapter;
import com.example.contact.Model.FavModel;
import com.example.contact.Model.Mymodel;
import com.example.contact.R;
import com.example.contact.SQLiteHelper.SqliteHelper;

import java.util.ArrayList;

public class FavActivity extends AppCompatActivity {
    Button logout;
    SharedPreferences Preferences;
    SharedPreferences.Editor myEdit;

    FavAdapter favAdapter;
    RecyclerView recyclerView;
    ArrayList<FavModel> list = new ArrayList<>();

    private ArrayList<FavModel> empList =new ArrayList<>();;
    private SqliteHelper DB=new SqliteHelper(FavActivity.this);

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        recyclerView = findViewById(R.id.fav_rc_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Preferences = getSharedPreferences("User_info", MODE_PRIVATE);

        list= DB.readEmp();


        favAdapter = new FavAdapter(FavActivity.this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(favAdapter);
    }
}