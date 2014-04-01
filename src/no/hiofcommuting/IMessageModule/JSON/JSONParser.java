package no.hiofcommuting.IMessageModule.JSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alfaomega on 4/1/14.
 */
public class JSONParser {

    private int senderID;
    private int receiverID;
    private String username;
    private String message;
    private String sentTime;

    public JSONParser(String JSONString){
        try {
            JSONObject object = new JSONObject(JSONString);
            this.senderID = object.getInt("senderID");
            this.receiverID = object.getInt("receiverID");
            this.username = object.getString("username");
            this.message = object.getString("message");
            this.sentTime = object.getString("sent");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getSenderID() {
        return senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public String getSentTime() {
        return sentTime;
    }
}
