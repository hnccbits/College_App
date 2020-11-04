package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import bitsindri.hncc.collegeapp.R;

public class sellingItemActivity extends AppCompatActivity {

    TextView itemCategory, itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_item);

        itemCategory = findViewById(R.id.item_category);
        itemPrice = findViewById(R.id.item_price);

        Intent intent = getIntent();
        String sellingActivityCategory = intent.getExtras().getString("category");
        String sellingActivityPrice = intent.getExtras().getString("price");

        itemCategory.setText(sellingActivityCategory);
        itemPrice.setText(sellingActivityPrice);

    }
}