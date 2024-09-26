package com.example.activity3_adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstPage extends AppCompatActivity {

    RecyclerView recyclerView;
    Spinner spinner;
    UserAdapter userAdapter;
    List<User> users;
    Button btnSubmit;
    EditText name, age, email;
    RadioButton male, female, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);
        spinner = findViewById(R.id.spinner);
        btnSubmit = findViewById(R.id.submit);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        users = new ArrayList<>();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                String genderSelected = "";
                if (male.isChecked()) {
                    genderSelected = male.getText().toString();
                } else if (female.isChecked()) {
                    genderSelected = female.getText().toString();
                } else {
                    genderSelected = other.getText().toString();
                }
                users.add(new User(name.getText().toString(), Integer.parseInt(age.getText().toString()), genderSelected, email.getText().toString(), spinner.getSelectedItem().toString()));

                // add my userAdapter class here
                userAdapter = new UserAdapter(users);
                recyclerView.setAdapter(userAdapter);
                } catch (Exception e) {
                    //toast message
                    e.printStackTrace();
                    Toast.makeText(FirstPage.this, "Age should be a valide number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        String[] countries = {"Select your Country", "India", "USA", "China", "Japan", "Mexico", "Canada"};

        ArrayAdapter<String> countryAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);

        spinner.setAdapter(countryAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedCountry = countries[i];
                Toast.makeText(FirstPage.this, selectedCountry, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}