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

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import ca.uottawa.eecs.seg2505.expertqr.controlleur.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;

public class PoserQuestionActivity extends AppCompatActivity {

	private Spinner spinnerChoixExpertise = null;
	EditText edQuestion = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poser_question);
		
		spinnerChoixExpertise = (Spinner)findViewById(R.id.spinnerExpertiseRequise);
		edQuestion = (EditText)findViewById(R.id.editTextQuestion);
		
		updateUI();
	}
	
	private void updateUI() {
		// chercher les expertise disponibles
		List<Expertise> expertises = Delegateur.getInstance().getExpertiseControlleur().getListeExpertises();
		ArrayAdapter<Expertise> adapter = new ArrayAdapter<Expertise>(this,
    			android.R.layout.simple_spinner_item, expertises);
    	spinnerChoixExpertise.setAdapter(adapter);
	}
	
	public void onOk(View view) {

		String texte= edQuestion.getText().toString();
		Expertise expertise = (Expertise)spinnerChoixExpertise.getSelectedItem();

		// creer la question
		Question question= Delegateur.getInstance().getQuestionControlleur().creerQuestion(texte, expertise);
		// sauvegarder la question
		Delegateur.getInstance().getQuestionControlleur().sauvegardeQuestion(question);

		finish();
	}
	
	public void onCancel(View view) {

		finish();
	}

}
