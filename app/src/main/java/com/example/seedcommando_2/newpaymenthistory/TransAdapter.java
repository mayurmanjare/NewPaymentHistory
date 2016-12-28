package com.example.seedcommando_2.newpaymenthistory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by seedcommando_2 on 12/24/2016.
 */

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.MyViewHolder> {

private List<TransData> transDataList;


    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView transDate,transId,transRs;
        public MyViewHolder(View view)
        {

            super(view);
            transDate=(TextView) view.findViewById(R.id.datea);
            transId=(TextView) view.findViewById(R.id.transa);
            transRs=(TextView) view.findViewById(R.id.rsa);


        }

        @Override
        public void onClick(View v) {

            Toast.makeText(v.getContext(),"CLICKED"+getPosition(),Toast.LENGTH_LONG).show();
        }
    }


  public   TransAdapter(List<TransData> transDataList)
  {
this.transDataList=transDataList;
  }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);


        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransData tr=transDataList.get(position);
        holder.transDate.setText(tr.getPaymenTS());
        holder.transId.setText("Transaction no. "+tr.getTransactionId());
        holder.transRs.setText("Rs. "+tr.getAmount());
    }




    @Override
    public int getItemCount() {
        return transDataList.size();
    }


}
