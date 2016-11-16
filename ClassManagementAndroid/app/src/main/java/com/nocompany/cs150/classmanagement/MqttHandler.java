package com.nocompany.cs150.classmanagement;

        import android.content.Context;
        import android.telephony.TelephonyManager;
        import android.util.Log;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.gson.Gson;

        import org.eclipse.paho.android.service.MqttAndroidClient;
        import org.eclipse.paho.client.mqttv3.IMqttActionListener;
        import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
        import org.eclipse.paho.client.mqttv3.MqttCallback;
        import org.eclipse.paho.client.mqttv3.MqttClient;
        import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
        import org.eclipse.paho.client.mqttv3.MqttException;
        import org.eclipse.paho.client.mqttv3.MqttMessage;

        import java.util.UUID;


/**
 * Author: Kasthuri
 */
public class MqttHandler implements MqttCallback {

    private static MqttHandler instance;
    private MqttAndroidClient mqttClient;
    MqttClient client;
    Context context;
    static String ID = "1111";

    //following variables are for the bluemix sample
    private static String ORG = "ov0uf9";
    private static String DEVICE_TYPE = "android-htc";
    private static String DEVICE_ID = "0jukYK4LOUc1xnP";
    private static String TOKEN = "0nIXU-ky-VnpB?bqNs";

    //android"10.0.0.17 device publishes to this topic
    private static String TOPIC_ATTENDANCE = "HOME/attendance";
    private static String TOPIC = "HOME/test";
    private static String TOPIC1 = "HOME/1111";
    private MqttHandler(Context context) {
        this.context = context;
    }


    public static MqttHandler getInstance(Context context) {
        if (instance == null) {
            instance = new MqttHandler(context);
        }
        return instance;
    }


    @Override
    public void connectionLost(Throwable throwable) {
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        if(topic == TOPIC_ATTENDANCE) {
            Message m = new Gson().fromJson(mqttMessage.toString(), Message.class);
            Toast.makeText(context, m.studentId, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

    public void connect(IMqttActionListener listener,String ip) throws MqttException {
        String iotPort = "1883";
        //q.emqtt.com:1883 is an online mqtt broker
        String iotHost =ip ;
        //client id for communication
        String iotClientId = "d:"+ORG+":"+DEVICE_TYPE+":"+DEVICE_ID + ":" + UUID.randomUUID().toString();

        //complete connection url
        String connectionUri = "tcp://" + iotHost + ":" + iotPort;
        if (!isConnected()) {


            //standard port for unsecured mqtt broker

           // client = new MqttClient(connectionUri,UUID.randomUUID().toString());
            // client.setCallback(this);
            if (mqttClient != null) {
                mqttClient.unregisterResources();
                mqttClient = null;
            }

            mqttClient = new MqttAndroidClient(context, connectionUri, iotClientId);
            mqttClient.setCallback(this);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setKeepAliveInterval(15);

            try {
                mqttClient.connect(options, context, listener);
                Toast.makeText(context, "Connected",
                        Toast.LENGTH_LONG).show();
                //mqttClient.connect();;
                //mqttClient.subscribe("HOME/1111",0,context,listener);
            } catch (MqttException e) {
                Log.e("mqtt", e.getMessage());
            }
        }
    }

    public void disconnect(IMqttActionListener listener) {
        if (isConnected()) {
            try {
                mqttClient.disconnect(context, listener);
                mqttClient = null;
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    // messages are sent q.emqtt.com through the following method
    public void publish(Message msg) {
        if (isConnected()) {


            MqttMessage mqttMsg = new MqttMessage(new Gson().toJson(msg).getBytes());
            mqttMsg.setRetained(false);
            mqttMsg.setQos(2);
            try {
                mqttClient.publish(TOPIC_ATTENDANCE, mqttMsg);
            } catch (Exception e) {

            }
        }else{

            Toast.makeText(context, "No Connection Found. Restart the App",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void publish(Message msg,String topic) {
        if (isConnected()) {


            MqttMessage mqttMsg = new MqttMessage(new Gson().toJson(msg).getBytes());
            mqttMsg.setRetained(false);
            mqttMsg.setQos(2);
            try {
                mqttClient.publish(topic, mqttMsg);
            } catch (Exception e) {

            }
        }else{

            Toast.makeText(context, "No Connection Found. Restart the App",
                    Toast.LENGTH_LONG).show();
        }
    }
    public boolean isConnected() {
        if (mqttClient != null) {
            return mqttClient.isConnected();
        }
        return false;
    }
    public String getTopic(){
        return TOPIC1;
    }
}
