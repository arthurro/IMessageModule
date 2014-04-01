package no.hiofcommuting.IMessageModule.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import no.hiofcommuting.IMessageModule.Message.IMPartner;
import no.hiofcommuting.IMessageModule.R;

import java.util.ArrayList;

public class InboxActivity extends Activity{

    private ArrayList<IMPartner> parnerList= new ArrayList<IMPartner>();

    private ListView listView;


    //TODO: Pupulate SQL resultset to list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox_layout);

        listView = (ListView)findViewById(R.id.inoxListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openConversation();
            }
        });
    }

    private void openConversation() { //TODO: Pass IDs to identify conversation

    }

}
