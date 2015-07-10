/**
 * This file contains material supporting the course
 * SEG2505: Introduction to Software Engineering
 * University of Ottawa.
 * http://wwww.eecs.uottawa.ca/~laganier
 *
 * This program is free software; permission is hereby granted to use, copy, modify,
 * and distribute this source code, or portions thereof, for any purpose, without fee,
 * subject to the restriction that the copyright notice may not be removed
 * or altered from any source or altered source distribution.
 * The software is released on an as-is basis and without any warranties of any kind.
 * In particular, the software is not guaranteed to be fault-tolerant or free from failure.
 * The author disclaims all warranties with regard to this software, any use,
 * and any consequent failure, is purely the responsibility of the user.
 *
 * Hanna Farah 2014
 * Robert Laganiere 2015
 */
package ca.uottawa.eecs.seg2505.expertqr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.controlleur.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;

public class LireEvaluerActivity extends AppCompatActivity {
	
	private Spinner spinnerChoixQuestion = null;
	private TextView textViewReponse = null;
	private EditText edEvaluation = null;
	private Reponse reponse = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lire_evaluer);
		
		spinnerChoixQuestion = (Spinner)findViewById(R.id.spinnerQuestionsAvecReponses);
		textViewReponse = (TextView)findViewById(R.id.textViewReponse);
		edEvaluation = (EditText)findViewById(R.id.editTextEvaluation);
		
		updateUI();
	}
	
	private void updateUI() {
		List<Question> questions = Delegateur.getInstance().getQuestionControlleur().getQuestions(Delegateur.getInstance().getUtilisateurCourant());
		ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(this,
    			android.R.layout.simple_spinner_item, questions);
    	spinnerChoixQuestion.setAdapter(adapter);
	}
	
	public void onVoirReponse(View view) {
		Question question = (Question)spinnerChoixQuestion.getSelectedItem();
		if (question != null) {
			reponse = Delegateur.getInstance().getReponseControlleur().getReponsePourQuestion(question);
			if (reponse != null) {
				textViewReponse.setText(reponse.getTexte());
			} else {
				textViewReponse.setText(getResources().getString(R.string.label_pas_de_reponse));
			}
		}
	}
	
	public void onOk(View view) {
		String eval = edEvaluation.getText().toString();
		int number = -1;
		try {
			if (eval.length() > 0) {
				number = Integer.parseInt(eval);
				if (reponse != null) {
					reponse.setEvaluation(number);
					Delegateur.getInstance().getReponseControlleur().sauvegardeReponse(reponse);
				}
			}
			finish();
		} catch (NumberFormatException e) {
			Toast.makeText(this, R.string.label_erreur_evaluation_numerique, Toast.LENGTH_SHORT).show();
		}
	}
	
	public void onCancel(View view) {
		finish();
	}
}
