package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bitsindri.hncc.collegeapp.R;

public class sellingItemActivity extends AppCompatActivity {

    TextView itemCategory, itemPrice;
    Button chatButton;
    Boolean showNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_item);

        itemCategory = findViewById(R.id.item_category);
        itemPrice = findViewById(R.id.item_price);
        chatButton = findViewById(R.id.chat_button);

        Intent intent = getIntent();
        String sellingActivityCategory = intent.getExtras().getString("category");
        String sellingActivityPrice = intent.getExtras().getString("price");

        itemCategory.setText(sellingActivityCategory);
        itemPrice.setText(sellingActivityPrice);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showNumber){
                    chatButton.setText("+91 987456321");
                    showNumber = false;
                }else {
                    chatButton.setText("Chat");
                    showNumber = true;
                }
            }
        });

    }
}