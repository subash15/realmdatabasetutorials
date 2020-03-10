package realmdatabase.subash.com.realmdatabasetutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import realmdatabase.subash.com.realmdatabasetutorials.model.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView name, address, ocuupation, mobileNumber;
    private EditText editTextName, editTextAddress, editTextOccupation, editTextMobileNumber;
    private Button save, show ,delete;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        delete = findViewById(R.id.delete);
        realm = Realm.getDefaultInstance();
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String mobileNumber = editTextMobileNumber.getText().toString().trim();
        String occupation = editTextOccupation.getText().toString().trim();
       switch (view.getId()){
           case R.id.save:
               writeDB(name,address, occupation,mobileNumber);
               break;
           case R.id.show:
               showData();
           case R.id.delete:
               deleteData();
       }

    }

    private void writeDB(final String name, final String address, final String occupation, final String  number) {
       realm.executeTransactionAsync(new Realm.Transaction() {
           @Override
           public void execute(Realm realm) {
              Student user   = realm.createObject(Student.class);
              user.setName(name);
              user.setAddress(address);
              user.setOccupation(occupation);
              user.setMobileNumber(number);
           }
       }, new Realm.Transaction.OnSuccess() {
           @Override
           public void onSuccess() {
               Log.v("message " , " Student user detals inserted");
           }
       }, new Realm.Transaction.OnError() {
           @Override
           public void onError(Throwable error) {
           Log.e("error" , error.getMessage());
           }
       });

    }
}
