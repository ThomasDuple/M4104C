package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Exercice4Activity extends AppCompatActivity {

    public final static int HELLO_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice4);
    }

    public void valider(View view) {
        EditText field = (EditText) findViewById(R.id.exercice4_ipt);
        String prenom = field.getText().toString();

        if (!prenom.equals("")) {
            Intent act = new Intent(this, HelloActivity.class);
            act.putExtra(HelloActivity.PRENOM_KEY, prenom);
            startActivityForResult(act, HELLO_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == HELLO_REQUEST) {
            String notification = "";
            if (resultCode == RESULT_CANCELED) {
                notification = "Retour";
            } else if (resultCode == RESULT_OK) {
                notification = "Choix du prénom";
            }
            Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();
        }
    }
}
