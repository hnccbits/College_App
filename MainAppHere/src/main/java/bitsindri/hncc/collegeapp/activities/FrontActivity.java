package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.projectubu.personaldashboard.FoundFirstActivity;
import com.projectubu.personaldashboard.LostFirstActivity;

import bitsindri.hncc.collegeapp.R;

public class FrontActivity extends AppCompatActivity {

    CardView cardView,cardView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        cardView = findViewById(R.id.cardView);
        cardView1 = findViewById(R.id.cardView1);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FrontActivity.this, LostFirstActivity.class));
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FrontActivity.this, FoundFirstActivity.class));
            }
        });


    }
}