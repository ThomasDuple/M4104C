package fr.iut2.androidtp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TableMultiplicationActivity extends AppCompatActivity {

    public final static String NUM_KEY = "num_key";

    public final static int TABLE_REQUEST = 0;

    public final static int CODE_CORRECTION = 1;
    public final static int CODE_TABLE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        LinearLayout list = (LinearLayout) findViewById(R.id.exercice5_calcList);

        int num = getIntent().getIntExtra(NUM_KEY, 1);

        for (int i = 0; i < 10; i++) {
            LinearLayout item = new LinearLayout(this);

            TextView txt = new TextView(this);
            txt.setText(getString(R.string.ex5_table_calc, i, num));
            item.addView(txt);

            EditText ipt = new EditText(this);
            ipt.setHint(getString(R.string.ex5_table_hint));
            ipt.setInputType(InputType.TYPE_CLASS_NUMBER);
            item.addView(ipt);

            list.addView(item);
        }
    }

    public void valider(View view) {
        int num = getIntent().getIntExtra(NUM_KEY, 1);

        LinearLayout list = (LinearLayout) findViewById(R.id.exercice5_calcList);
        int miss = 0;

        try {
            for (int i = 0; i < 10; i++) {
                LinearLayout item = (LinearLayout) list.getChildAt(i);
                EditText ipt = (EditText) item.getChildAt(1);

                String entry = ipt.getText().toString();

                if (entry.isEmpty() || i * num != Integer.parseInt(entry)) {
                    miss++;
                }
            }

            Intent intent;
            if (miss == 0) {
                intent = new Intent(this, FelicitationActivity.class);
            } else {
                intent = new Intent(this, ErreurActivity.class);
                intent.putExtra(ErreurActivity.ERROR_KEY, miss);
            }
            startActivityForResult(intent, TABLE_REQUEST);
        } catch (Error e) {
            Toast.makeText(this, "Veuillez remplir toutes les cases", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == CODE_TABLE) {
            super.finish();
        }
    }
}