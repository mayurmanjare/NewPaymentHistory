package com.example.seedcommando_2.newpaymenthistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class TransactiondetailActivity extends AppCompatActivity {

TextView tv;


    TextView activationStatus,tansDate,payModelbl,payMode,transamt,transamtlbl,transNumber;
    Intent intent1;
    Bundle b;
    Object obj;
    TransData transData;
    String  paymentMethod,amount,orderId,transactionId,paymentStatus,paymentTS;

    public  void findViewbyID()
    {

        tv=(TextView) findViewById(R.id.textView8);
        activationStatus=(TextView)findViewById(R.id.textView9);

        tansDate =(TextView)findViewById(R.id.textView10);
        payModelbl=(TextView) findViewById(R.id.textView11);
        payMode=(TextView) findViewById(R.id.textView12);
        transamtlbl=(TextView) findViewById(R.id.textView13);
        transamt=(TextView) findViewById(R.id.textView14);
        transNumber=(TextView) findViewById(R.id.textView15);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.transactiondetail);
        findViewbyID();
        getData();
        setTransData();


    }
    public void getData()
    {
        intent1 = getIntent();
        b = intent1.getExtras();
        obj = b.getSerializable("Object");
        transData = (TransData) obj;
        paymentMethod = transData.getPaymentMode();
        amount = transData.getAmount();
        orderId = transData.getOrderId();
        transactionId = transData.getTransactionId();
        paymentStatus = transData.getPaymentStatus();
        paymentTS=transData.getPaymenTS();
    }
    public  void setTransData()
    {
        if (paymentStatus.equals("SUCCESS")) {

            tv.setText("PAYMENT SUCCESSFULL");
            activationStatus.setText("Your sling cource has been activated");
            tansDate.setText(paymentTS);
            payModelbl.setText("Payment Method");
            payMode.setText(paymentMethod);
            if(payMode.getText().toString().equals("Paytm"))
            {
                payMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pytm,0,0,0);
            }
            else
            {
                payMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.viks,0,0,0);

            }
            transamtlbl.setText("Amount"+"        "+"OrderNo");
            transamt.setText("Rs. "+amount+"        "+orderId);
            transNumber.setText("Transcation number"+"\n"+transactionId);
        }
        else if(paymentStatus.equals("PENDING"))
        {
            tv.setText("PAYMENT PENDING"+"\n");
            activationStatus.setText("Your sling cource has been  not activated");
            tansDate.setText(paymentTS);
            payModelbl.setText("Payment Method");
            payMode.setText(paymentMethod+"");
            transamtlbl.setText("Amount"+"          "+"OrderNo");
            transamt.setText("Rs. "+amount+"        "+orderId);
            transNumber.setText("Transcation number"+"\n"+transactionId);

        }
        else
        {
            tv.setText("PAYMENT FAILED");
            activationStatus.setText("Your sling cource has been not activated");
            tansDate.setText(paymentTS);
            payModelbl.setText("Payment Method");
            payMode.setText(paymentMethod);
            if(payMode.getText().toString().equals("Paytm"))
            {
                payMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pytm,0,0,0);
            }
            else
            {
                payMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.viks,0,0,0);

            }
            transamtlbl.setText("Amount"+"        "+"OrderNo");
            transamt.setText("Rs. "+amount+"        "+orderId);
            transNumber.setText("Transcation number"+"\n"+transactionId);

        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
