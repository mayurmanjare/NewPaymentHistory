package com.example.seedcommando_2.newpaymenthistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class TransactiondetailActivity extends AppCompatActivity {

TextView tv;
    View line1, line2,line3;

    TextView activationStatus,tansDate,payModelbl,payMode,transamt,transamtlbl,transNumber;
    Intent intent1;
    Bundle b;
    Object obj;
    TransData transData;
    String  paymentMethod,amount,orderId,transactionId,paymentStatus,paymentTS;

    public  void findViewbyID()
    {
        line1 =(View) findViewById(R.id.line1);
        line2 =(View) findViewById(R.id.line2);
        line3 =(View) findViewById(R.id.line3);
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
        paymentTS=transData.getConvrt_time();
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
            payMode.setText(paymentMethod);
            transamtlbl.setText("Amount"+"          "+"OrderNo");
            transamt.setText("Rs. "+amount+"        "+orderId);
            transNumber.setText("Transcation number"+"\n"+transactionId);

        }
        else
        {
            tv.setText("PAYMENT FAILED"+"\n"+"Your sling cource has been not activated");
            line1.setVisibility(View.INVISIBLE);
            line2.setVisibility(View.INVISIBLE);
            line3.setVisibility(View.INVISIBLE);
            activationStatus.setVisibility(View.INVISIBLE);
            tansDate.setVisibility(View.INVISIBLE);
            payModelbl.setVisibility(View.INVISIBLE);
            payMode.setVisibility(View.INVISIBLE);
            transamtlbl.setVisibility(View.INVISIBLE);
            transamt.setVisibility(View.INVISIBLE);
            transNumber.setVisibility(View.INVISIBLE);

        }


    }
}
