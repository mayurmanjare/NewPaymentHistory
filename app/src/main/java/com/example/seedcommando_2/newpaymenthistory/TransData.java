package com.example.seedcommando_2.newpaymenthistory;

import java.io.Serializable;

/**
 * Created by seedcommando_2 on 12/23/2016.
 */

public class TransData implements Serializable {
    String convrt_time;
    String paymentMode;
    String orderId;

    public TransData(String convrt_time, String paymentMode, String orderId, String amount, String transactionId, String paymentStatus) {
        this.convrt_time = convrt_time;
        this.paymentMode = paymentMode;
        this.orderId = orderId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }

    String amount ;
    String transactionId ;
    String paymentStatus;
    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getConvrt_time() {
        return convrt_time;
    }

    public void setConvrt_time(String convrt_time) {
        this.convrt_time = convrt_time;
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
