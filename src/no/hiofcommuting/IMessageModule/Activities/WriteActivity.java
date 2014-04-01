package no.hiofcommuting.IMessageModule.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import no.hiofcommuting.IMessageModule.Message.InstantMessage;
import no.hiofcommuting.IMessageModule.R;

public class WriteActivity extends Activity {

    private int senderID = 1337;
    private int receiverID = 7331;

    private Button sendBtn;
    private EditText textField;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_layout);

        sendBtn = (Button)findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        textField = (EditText)findViewById(R.id.editTextWrite);
    }

    private void sendMessage() {
        message = textField.getText().toString();

        InstantMessage im = new InstantMessage(senderID, receiverID, message);
        im.sendMessage();

        if (im.isSent()){
            // GUI effects
        }
    }
}
