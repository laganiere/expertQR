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

import java.util.List;

import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.eecs.seg2505.expertqr.model.Utilisateur;

public interface DBFacade {

	/**
	 * @param expertise L'expertise associee a une question
	 * @return Une liste de questions qui necessitent une certaine expertise
	 */
	public List<Question> getQuestionsPourExpertise(String expertise);
	
	/**
	 * @param nom Le nom de l'utilisateur
	 * @return Une liste de questions qui est demandee par cet utilisateur.
	 */
	public List<Question> getQuestions(String nom);
	
	/**
	 * @param questionID Le ID d'une question
	 * @return La reponse a la question specifiee ou null si
	 * il n'y a pas de reponse.
	 */
	public Reponse getReponsePourQuestion(String questionID);
	
	/**
	 * @return La liste des expertises disponibles.
	 */
	public List<Expertise> getListeExpertises();
	
	/**
	 * Methode pour sauvegarder une Question
	 * @param question
	 */
	public void sauvegardeQuestion(Question question);
	
	/**
	 * Methode pour sauvegarder une Reponse
	 * @param reponse
	 */
	public void sauvegardeReponse(Reponse reponse);
	
	/**
	 * Methode pour sauvegarder un Utilisateur
	 * @param utilisateur
	 */
	public void sauvegardeUtilisateur(Utilisateur utilisateur);
	
	/**
	 * Methode pour sauvegarder une Expertise
	 * @param expertise
	 */
	public void ajouterExpertise(Expertise expertise);
}
