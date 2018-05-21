package local.darwin.quizoology;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText q1_edittext;
    private RadioGroup q2_a_radio;
    private CheckBox q3_a1_check;
    private CheckBox q3_a2_check;
    private CheckBox q3_a3_check;
    private CheckBox q3_a4_check;
    private RadioGroup q4_a_radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1_edittext = findViewById(R.id.q1_edittext);
        q2_a_radio = findViewById(R.id.q2_a_radio);
        q3_a1_check = findViewById(R.id.q3_a1_check);
        q3_a2_check = findViewById(R.id.q3_a2_check);
        q3_a3_check = findViewById(R.id.q3_a3_check);
        q3_a4_check = findViewById(R.id.q3_a4_check);
        q4_a_radio = findViewById(R.id.q4_a_radio);
    }

    public void checkAnswers(View view) {
        int results = 0;

        String q1_a = q1_edittext.getText().toString();
        if (q1_a.equals("21") || q1_a.toLowerCase().equals("twenty one")) {
            results += 1;
        }

        if (q2_a_radio.getCheckedRadioButtonId() == R.id.radio_cat) {
            results += 1;
        }

        if (q3_a1_check.isChecked() && !q3_a2_check.isChecked() && !q3_a3_check.isChecked() && q3_a4_check.isChecked()) {
            results += 1;
        }

        if (q4_a_radio.getCheckedRadioButtonId() == R.id.radio_lion) {
            results += 1;
        }

        if (results < 4) {
            Toast.makeText(this, getString(R.string.bad_result, results), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.good_result), Toast.LENGTH_LONG).show();
        }
    }
}
