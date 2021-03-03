package fr.iut2.androidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {

    public final static String ERROR_KEY = "error_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);

        int nb = getIntent().getIntExtra(ERROR_KEY, -1);
        TextView label = (TextView) findViewById(R.id.exercice5_error);

        label.setText(getString(R.string.ex5_err_sub, nb));
    }

    public void correct(View view) {
        setResult(TableMultiplicationActivity.CODE_CORRECTION);
        super.finish();
    }

    public void choose(View view) {
        setResult(TableMultiplicationActivity.CODE_TABLE);
        super.finish();
    }
}