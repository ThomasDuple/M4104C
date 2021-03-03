package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    public static final String PRENOM_KEY = "prenom_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hello);

        TextView helloView = (TextView) findViewById(R.id.exercice4_hello);

        helloView.setText(getString(R.string.ex4_hello_txt, getIntent().getStringExtra(PRENOM_KEY)));
    }

    public void btn_pre(View view) {
        setResult(RESULT_OK);
        super.finish();
    }

    public void btn_ex(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
