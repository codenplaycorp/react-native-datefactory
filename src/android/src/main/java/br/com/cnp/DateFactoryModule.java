package br.com.cnp;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.content.Context;
import android.location.LocationManager;
import android.location.Location;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONException;

public class DateFactoryModule extends ReactContextBaseJavaModule {

    public DateFactoryModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "DateFactoryAndroid";
    }

    @ReactMethod
    public void now(Callback success, Callback error) {
        try {
            Date fromLocation = getDateFromLocation();

            JSONObject jsonObject = new JSONObject().put("date", fromLocation);

            success.invoke(jsonObject.getString("date"));
        } catch (JSONException ex){
            error.invoke("Internal error converting results:" + ex.getMessage());
        }
    }

    private Date getDateFromLocation() {
        ReactApplicationContext ctx = getReactApplicationContext();

        LocationManager locMan = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);

        Location location = locMan.getLastKnownLocation(LocationManager.KEY_LOCATION_CHANGED);
        if (location == null) {
            //fallback
            return  new Date();
        }

        return new Date(location.getTime());
    }

}
