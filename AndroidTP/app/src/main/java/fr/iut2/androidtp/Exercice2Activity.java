package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice2);
    }

    public void exercice2Valider(View view) {
        TextView resField = (TextView)findViewById(R.id.exercice2_res);

        RadioGroup grp = (RadioGroup)findViewById(R.id.radio_grp);

        if (grp.getCheckedRadioButtonId() == R.id.radio_3) {
            resField.setText("Bravo vous avez la bonne réponse ! ");
        } else {
            resField.setText("Mauvaise réponse !");
        }

    }
}
