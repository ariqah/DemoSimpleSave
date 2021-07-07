package sg.edu.rp.c346.id20023243.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume(); //super ALWAYS leave on first line, put code below

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //obtain SharedPreferences instance

        String msg = prefs.getString("greetings","No greetings");
        //retrieve saved data from SharedPreferences; if no data display default value

        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        //toast the retrieved data
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //obtain sharedpreferences instance
        SharedPreferences.Editor prefEdit = prefs.edit(); //create SharedPrefs editor by calling edit()
        prefEdit.putString("greetings","Hello!"); //set key-value pair in editor
        prefEdit.commit(); //save changes made to the SharedPrefs, prefs.

    }

}