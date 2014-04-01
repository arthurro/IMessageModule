package no.hiofcommuting.IMessageModule.Activities;

import android.app.Activity;
import android.os.Bundle;
import no.hiofcommuting.IMessageModule.R;

public class ConversationActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation_layout);
    }

}
