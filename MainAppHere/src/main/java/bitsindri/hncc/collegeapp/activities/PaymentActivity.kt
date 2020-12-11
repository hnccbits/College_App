package bitsindri.hncc.collegeapp.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import bitsindri.hncc.collegeapp.R
import com.braintreepayments.cardform.view.CardForm


class PaymentActivity : AppCompatActivity() {

    lateinit var card_form:CardForm
    lateinit var toolbar: Toolbar
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        toolbar = findViewById(R.id.toolbar)
        button = findViewById(R.id.procced)

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Procced to Payment")

        card_form = findViewById<View>(R.id.card_form) as CardForm
        card_form.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .actionLabel("Purchase")
                .setup(this)


        button.setOnClickListener{
            if (card_form.getCardNumber().isBlank() &&
                    card_form.getExpirationMonth().isBlank() &&
                    card_form.getExpirationYear().isBlank() &&
                    card_form.getCvv().isBlank() &&
                    card_form.getCardholderName().isBlank() &&
                    card_form.getPostalCode().isBlank() &&
                    card_form.getCountryCode().isBlank() &&
                    card_form.getMobileNumber().isBlank() ){
                Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Payment Successful",Toast.LENGTH_SHORT).show()
            }
        }
//
//        card_form.getCardNumber()
//        card_form.getExpirationMonth()
//        card_form.getExpirationYear()
//        card_form.getCvv()
//        card_form.getCardholderName()
//        card_form.getPostalCode()
//        card_form.getCountryCode()
//        card_form.getMobileNumber()
    }
}