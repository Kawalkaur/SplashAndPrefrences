package kawal.com.splashandprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.editText)
    EditText eTxtUserName;

    @InjectView(R.id.button)
    Button btnSubmit;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        sharedPreferences= getSharedPreferences("myPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String usreName = sharedPreferences.getString("keyUserName", "NA");
        eTxtUserName.setText(usreName);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button){
            String userName = eTxtUserName.getText().toString().trim();
            editor.putString("keyUserName", userName);
            editor.commit();

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
