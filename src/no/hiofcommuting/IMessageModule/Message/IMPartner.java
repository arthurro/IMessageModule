package no.hiofcommuting.IMessageModule.Message;

/**
 * Created by alfaomega on 4/1/14.
 */
public class IMPartner {

    //TODO: Implement Facebook image
    private int ID;
    private String username;
    private String message;

    public IMPartner(int userID, String username, String message){
        this.ID = userID;
        this.message = message;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
