package rhynix.eliud.androidpush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                .init();
    }

    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {

            try {
                if (additionalData !=null){
                    if (additionalData.has("actionSelected"))
                        Log.d("OneSignalExample","OneSignal notification button with id"+ additionalData.toString());
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }
    }
}
