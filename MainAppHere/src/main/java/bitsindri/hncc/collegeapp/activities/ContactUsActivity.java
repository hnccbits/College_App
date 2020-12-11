package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import bitsindri.hncc.collegeapp.R;

public class ContactUsActivity extends AppCompatActivity {

    TextView contactUsHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        contactUsHeading = findViewById(R.id.contact_us_intro_text_view);
        String contactUsInfo = "You can contact us to: \n" + "1. Report cyberbullying, ragging etc.\n" +
                                                             "2. Report bug in app\n" +
                                                             "3. Request to add a new feature";
        contactUsHeading.setText(contactUsInfo);
    }
}