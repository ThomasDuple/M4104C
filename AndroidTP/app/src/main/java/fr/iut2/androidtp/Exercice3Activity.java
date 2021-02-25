package fr.iut2.androidtp;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        showScore();
    }

    protected void showScore() {
        TextView v_win = (TextView)findViewById(R.id.exercice3_win);
        v_win.setText(getString(R.string.ex3_nb_win, res.getNombreVictoire()));
        TextView v_loose = (TextView)findViewById(R.id.exercice3_loose);
        v_loose.setText(getString(R.string.ex3_nb_loose, res.getNombreDefaite()));
        TextView v_tie = (TextView)findViewById(R.id.exercice3_tie);
        v_tie.setText(getString(R.string.ex3_nb_tie, res.getNombreEgalite()));
    }

    public void exercice3play(View view) {
        LinearLayout parrent = (LinearLayout)view.getParent();

        for (int i = 0; i < parrent.getChildCount(); i++) {
            View v = parrent.getChildAt(i);
            Drawable bd = getResources().getDrawable((v == view ? R.drawable.image_border_true : R.drawable.image_border_false));
            v.setBackground(bd);
        }

        Jeu jeu = new Jeu();

        int choice_pl = ((LinearLayout) view.getParent()).indexOfChild(view);

        jeu.setMainJoueur(choice_pl);

        ImageView iaView = (ImageView)findViewById(R.id.exercice3_ia);
        iaView.setBackground(getResources().getDrawable(R.drawable.image_border_true));
        switch (jeu.getMainOrdinateur()) {
            case 0:
                iaView.setImageResource(R.drawable.pierre);
                break;
            case 1:
                iaView.setImageResource(R.drawable.ciseaux);
                break;
            case 2:
                iaView.setImageResource(R.drawable.feuille);
                break;
            default:
        }


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
