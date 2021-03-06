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
package ca.uottawa.eecs.seg2505.expertqr.controlleur;

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.db.DBFacade;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

public class QuestionControlleur {
	
	protected DBFacade dbFacade = null;
	
	public QuestionControlleur(DBFacade dbFacade) {
		this.dbFacade = dbFacade;
	}

	/**
	 * Methode pour creer une Question
	 * @param texte le texte de la question
	 */
	public Question creerQuestion(String texte, Expertise expertise) {

		Question question = new Question();
		question.setTexte(texte);
		question.setExpertiseRequise(expertise);
		question.setUtilisateurID(Delegateur.getInstance().getUtilisateurCourant().getNom());

		return question;
	}
	/**
	 * Methode pour sauvegarder une Question
	 * @param question
	 */
	public void sauvegardeQuestion(Question question) {
		if (question != null
				&& question.getTexte() != null
				&& !question.getTexte().isEmpty()
				&& question.getUtilisateurID() != null
				&& !question.getUtilisateurID().isEmpty()) {
			dbFacade.sauvegardeQuestion(question);
		}
	}
	
	public List<Question> getQuestionsPourExpertise(Expertise expertise) {
		List<Question> listeQuestions = null;
		
		if (expertise != null
				&& expertise.getTexte() != null
				&& !expertise.getTexte().isEmpty()) {
			listeQuestions = dbFacade.getQuestionsPourExpertise(expertise.getTexte());
		}
		 
		return listeQuestions;
	}
	
	public List<Question> getQuestions(Utilisateur utilisateur) {
		List<Question> listeQuestions = null;
		
		if (utilisateur != null
				&& utilisateur.getNom() != null
				&& !utilisateur.getNom().isEmpty()) {
			listeQuestions = dbFacade.getQuestions(utilisateur.getNom());
		}
		 
		return listeQuestions;
	}

}
