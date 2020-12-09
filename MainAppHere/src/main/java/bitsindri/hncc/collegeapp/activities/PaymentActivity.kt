package bitsindri.hncc.collegeapp.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import bitsindri.hncc.collegeapp.R
import com.braintreepayments.cardform.view.CardForm


class PaymentActivity : AppCompatActivity() {

    lateinit var card_form:CardForm
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        toolbar = findViewById(R.id.toolbar)

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

        card_form.getCardNumber();
        card_form.getExpirationMonth();
        card_form.getExpirationYear();
        card_form.getCvv();
        card_form.getCardholderName();
        card_form.getPostalCode();
        card_form.getCountryCode();
        card_form.getMobileNumber();
    }
}