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
package ca.uottawa.eecs.seg2505.expertqr.db;

import java.util.ArrayList;
import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

public class MemoireFacade implements DBFacade {

	// garder tous les donnees en memoire
	protected List<Question> questions = new ArrayList<Question>();
	protected List<Expertise> expertises = new ArrayList<Expertise>();
	protected List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public MemoireFacade() {

        Expertise e1= new Expertise(); e1.setTexte("Piano");
        Expertise e2= new Expertise(); e2.setTexte("Menuiserie");
        Expertise e3= new Expertise(); e3.setTexte("C++");
        expertises.add(e1);
        expertises.add(e2);
        expertises.add(e3);
	}

	@Override
	public List<Question> getQuestionsPourExpertise(String expertise) {
		List<Question> resultat = new ArrayList<Question>();
		// obtenir les questions non-repondues pour l'expert
		for (Question quest : questions) {
			if (quest.getExpertiseRequise().getTexte().equals(expertise) &&
					quest.getReponse()==null) {
				resultat.add(quest);
			}
		}
		return resultat;
	}

	@Override
	public List<Question> getQuestions(String nom) {
		List<Question> resultat = new ArrayList<Question>();
		for (Question quest : questions) {
			if (quest.getUtilisateurID() != null
					&& quest.getUtilisateurID().equals(nom)) {
				resultat.add(quest);
			}
		}
		return resultat;
	}

	@Override
	public Reponse getReponsePourQuestion(String questionID) {
		for (Question quest : questions) {
			if (quest.getID().equals(questionID)) {
				return quest.getReponse();
			}
		}

		return null;
	}
	
	@Override
	public List<Expertise> getListeExpertises() {

		return expertises;
	}

	@Override
	public void sauvegardeQuestion(Question question) {

		questions.add(question);
	}

	@Override
	public void sauvegardeReponse(Reponse reponse) {

		return;
	}

	@Override
	public void sauvegardeUtilisateur(Utilisateur utilisateur) {

		utilisateurs.add(utilisateur);
	}

	@Override
	public void ajouterExpertise(Expertise expertise) {

		expertises.add(expertise);
	}

}
