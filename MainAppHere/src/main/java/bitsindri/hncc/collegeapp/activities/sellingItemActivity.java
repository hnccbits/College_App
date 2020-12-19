package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bitsindri.hncc.collegeapp.R;

public class sellingItemActivity extends AppCompatActivity {

    TextView itemCategory, itemPrice,descript,user,batch;
    Button chatButton;
    ImageView imageView;
    Boolean showNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_item);

        itemCategory = findViewById(R.id.item_category);
        itemPrice = findViewById(R.id.item_price);
        user = findViewById(R.id.userName);
        batch = findViewById(R.id.batch);
        descript = findViewById(R.id.description);
        chatButton = findViewById(R.id.chat_button);
        imageView=findViewById(R.id.productImage);

        Intent intent = getIntent();
        String sellingActivityCategory = intent.getExtras().getString("category");
        String sellingActivityPrice = intent.getExtras().getString("price");
        String userName = intent.getExtras().getString("name");
        String year = intent.getExtras().getString("batch");
        String description = intent.getExtras().getString("description");
        String img_url = intent.getExtras().getString("url");

        itemCategory.setText(sellingActivityCategory);
        itemPrice.setText(sellingActivityPrice);
        descript.setText(description);
        user.setText(userName);
        batch.setText(year);
        Picasso.get().load(img_url).into(imageView);

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