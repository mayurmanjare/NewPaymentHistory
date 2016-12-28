package com.example.seedcommando_2.newpaymenthistory;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by seedcommando_2 on 12/23/2016.
 */

public class TransData implements Serializable {
    @SerializedName("paymenTS")
    String paymenTS;
    @SerializedName("paymentMode")
    String paymentMode;
    @SerializedName("orderId")
    String orderId;
    @SerializedName("amount")
    String amount ;
    @SerializedName("transactionId")
    String transactionId ;
    @SerializedName("paymentStatus")
    String paymentStatus;

    public TransData( String paymentMode, String orderId, String amount, String transactionId, String paymentStatus,String paymenTS) {
        this.paymenTS = paymenTS;
        this.paymentMode = paymentMode;
        this.orderId = orderId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }


    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }


    public String getPaymenTS() {

        return  paymenTS;
    }



    public void setPaymenTS(String paymenTS) {
        this.paymenTS =paymenTS;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderId() {

        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


}
