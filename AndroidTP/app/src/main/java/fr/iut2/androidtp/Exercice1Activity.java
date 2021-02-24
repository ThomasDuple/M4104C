package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice1);
    }

    public void exercice1Valider(View view) {
        EditText field = (EditText)findViewById(R.id.exercice1_prenom);
        String prenom = field.getText().toString();

        TextView hello = (TextView)findViewById(R.id.exercice1_hello);
        hello.setText("Hello " + prenom + " !");
    }
}
