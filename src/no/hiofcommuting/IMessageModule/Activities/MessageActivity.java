package no.hiofcommuting.IMessageModule.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import no.hiofcommuting.IMessageModule.R;

public class MessageActivity extends Activity {

    private Button inboxBtn;
    private Button writeBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        final Intent inboxIntent = new Intent(this, InboxActivity.class);
        final Intent writeIntent = new Intent(this, WriteActivity.class);

        inboxBtn = (Button)findViewById(R.id.inboxBtn);
        inboxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inboxIntent);
            }
        });

        writeBtn = (Button)findViewById(R.id.writeBtn);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(writeIntent);
            }
        });
    }
}
