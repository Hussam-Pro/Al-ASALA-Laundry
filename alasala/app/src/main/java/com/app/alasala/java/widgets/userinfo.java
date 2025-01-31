package com.app.alasala.java.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.alasala.R;
import com.google.android.material.textfield.TextInputEditText;

public class userinfo extends AppCompatActivity {

    CheckBox checkBoxVica, checkBoxCash;
    ImageView gobButton;
    TextInputEditText nameinfo, phoneinfo, cityinfo, homeinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);

        checkBoxVica = findViewById(R.id.vica);
        checkBoxCash = findViewById(R.id.cash);

        // Ensure only one checkbox can be selected at a time
        checkBoxVica.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxCash.setChecked(false);
            }
        });

        checkBoxCash.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxVica.setChecked(false);
            }
        });
        nameinfo = findViewById(R.id.nameinfo);
        phoneinfo = findViewById(R.id.phoneinfo);
        cityinfo = findViewById(R.id.cityinfo);
        homeinfo = findViewById(R.id.homeinfo);

        gobButton = findViewById(R.id.userdetailGoback);
        gobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void openMapActivity(View view) {
        // Check which payment method is selected
        String selectedPaymentMethod = "";
        if (checkBoxVica.isChecked()) {
            selectedPaymentMethod = "visa";
        } else if (checkBoxCash.isChecked()) {
            selectedPaymentMethod = "Cash";
        } else {
            Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            return; // Do not proceed if no payment method is selected
        }
        // Pass the selected payment method to the map activity
        Intent intent = new Intent(userinfo.this, map.class);
        intent.putExtra("paymentMethod", selectedPaymentMethod);
        startActivity(intent);
    }

    public void sendRequest(View view) {
        // Display a toast message when the "Request Now" button is pressed
        nameinfo.setText("");
        phoneinfo.setText("");
        cityinfo.setText("");
        homeinfo.setText("");
        Toast.makeText(this, "Request sent to laundry system successfully", Toast.LENGTH_SHORT).show();
    }
}
