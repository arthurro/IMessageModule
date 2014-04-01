package no.hiofcommuting.IMessageModule.JSON;

import no.hiofcommuting.IMessageModule.Message.InstantMessage;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMessage {

    private JSONObject jsonObject;

    public JSONMessage(InstantMessage message){
        try {
            jsonObject.put("senderID", new Integer(message.getSenderID()));
            jsonObject.put("receiverID", new Integer(message.getReceiverID()));
            jsonObject.put("message", message.getMessage());
            jsonObject.put("sent", message.getSentTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSONObject(){
        return jsonObject;
    }

    public void setJSONObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
