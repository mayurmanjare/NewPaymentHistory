package com.example.seedcommando_2.newpaymenthistory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private List<TransData> transactionList=new ArrayList<>();
    private RecyclerView rv;
    private  TransAdapter transadpt;
    private ProgressDialog pDialog;
    String transdata;
    Myhtttp p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=(RecyclerView)findViewById(R.id.recycler_view);
        transadpt=new TransAdapter(transactionList);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        new GetTransactionData().execute();

        rv.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        rv.setAdapter(transadpt);


        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        transactionList.get(position);
                        Intent intent=new Intent(getApplicationContext(),TransactiondetailActivity.class);
                        TransData t=  transactionList.get(position);
                        intent.putExtra("Object",t);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );




    }


    private class GetTransactionData extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            // Making a request to url and getting response
             p=new Myhtttp();
            transdata=p.fetchData();


            if (transdata != null) {
                try {
                    // Getting JSON Array node
                    JSONObject transjsonobj = new JSONObject(transdata);
                    JSONArray obb = transjsonobj.getJSONArray("paymentHistoryList");
                    // looping through All transaction
                    for (int i = 0; i < obb.length(); i++) {
                        JSONObject c = obb.getJSONObject(i);
                        String my=c.toString();
                         long paymenTS =Long.parseLong(c.getString("paymentTS"));
                        //Serealization using  GSON LIBRARY
                        Gson gson = new Gson();
                        TransData   t = gson.fromJson( my, TransData.class );
                        t.setPaymenTS(new Timestamps().getdata(paymenTS));
                        transactionList.add(t);

                    }
                } catch (final JSONException e) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Please check your internet connection",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return transdata;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            transadpt.notifyDataSetChanged();


            /**
             * Updating parsed JSON data into recyclerView
             * */



        }


    }

}
