package no.hiofcommuting.IMessageModule.HTTP;

import no.hiofcommuting.IMessageModule.JSON.JSONMessage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.*;

public class HTTPClient {

    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int REQUEST_OK = 200;

    private static boolean postOK = false;

    private static String URL = ""; //TODO: Insert server adr.


    public static void POSTMessage(JSONMessage jsonMessage){

        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, CONNECTION_TIMEOUT);

        HttpClient client = new DefaultHttpClient(httpParams);

        HttpPost request = new HttpPost(URL);

        try {
            request.setEntity(new ByteArrayEntity(jsonMessage.toString().getBytes("UTF8")));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == REQUEST_OK)
                postOK = true;
            else
                postOK = false;
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns unparsed JSON
    public static String GETMessage(int senderID, int receiverID){
        /* // For web API, impl.
        int SID = senderID;
        int RID = receiverID;
        */

        String JSONString = null;
        InputStream stream = null;

        DefaultHttpClient client = new DefaultHttpClient(new BasicHttpParams());
        HttpGet get = new HttpGet(URL);
        get.setHeader("Content-Type", "application/json");

        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            stream = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"), 8);

            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }

            JSONString = builder.toString();

        }
        catch (ClientProtocolException e){
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return JSONString;
    }

    public static boolean postOK() {
        return postOK;
    }
}
