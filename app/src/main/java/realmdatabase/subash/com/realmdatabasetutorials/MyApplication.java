package realmdatabase.subash.com.realmdatabasetutorials;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this); // initialize realm
       RealmConfiguration realmConfiguration =  new RealmConfiguration.Builder().name("myrealm.realm").build(); //sets the configuration for database name and version
       Realm.setDefaultConfiguration(realmConfiguration);
    }
}
