package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.exercice3Data.Jeu;
import fr.iut2.androidtp.exercice3Data.Resultat;

public class Exercice3Activity extends AppCompatActivity {

    private Resultat res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique

        setContentView(R.layout.activity_exercice3);


        this.res = new Resultat();
    }

    protected void showScore() {
        TextView v_win = (TextView)findViewById(R.id.exercice3_win);
        v_win.setText(R.string.ex3_nb_win + res.getNombreVictoire());
        TextView v_loose = (TextView)findViewById(R.id.exercice3_loose);
        v_loose.setText(R.string.ex3_nb_loose + res.getNombreDefaite());
        TextView v_tie = (TextView)findViewById(R.id.exercice3_tie);
        v_tie.setText(R.string.ex3_nb_tie + res.getNombreEgalite());
    }

    public void exercice3play(View view) {
        Jeu jeu = new Jeu();

        int choice_pl = ((LinearLayout) view.getParent()).indexOfChild(view);

        jeu.setMainJoueur(choice_pl);

        TextView resView = (TextView)findViewById(R.id.exercice3_state);

        if (jeu.joueurGagne()) {
            this.res.addVictoire();
            resView.setText(R.string.ex3_win);
        } else if (jeu.egalite()) {
            this.res.addEgalite();
            resView.setText(R.string.ex3_tie);
        } else {
            this.res.addDefaite();
            resView.setText(R.string.ex3_loose);
        }

        showScore();
    }
}
