package no.hiofcommuting.IMessageModule.Message;

import no.hiofcommuting.IMessageModule.HTTP.HTTPClient;
import no.hiofcommuting.IMessageModule.JSON.JSONMessage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InstantMessage {

    private int senderID;
    private int receiverID;
    private String message;
    private String sentTime;
    private String readTime; //TODO: Check alternatives

    private static boolean isSent;

    public InstantMessage(int senderID, int receiverID, String message){
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.message = message;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        this.sentTime = dateFormat.format(date);
    }

    public void sendMessage() {
        HTTPClient.POSTMessage(new JSONMessage(this));
        isSent = HTTPClient.postOK();
    }

    public String getMessage(){
        return HTTPClient.GETMessage(senderID, receiverID);
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getIMmessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public static boolean isSent() {
        return isSent;
    }
}
