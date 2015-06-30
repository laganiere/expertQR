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
package ca.uottawa.eecs.seg2505.expertqr.model;

import java.io.Serializable;
import java.util.UUID;

public class Reponse implements Serializable {
	
	private static final long serialVersionUID = 2028078514689553029L;
	/**
	 * Le ID de la reponse
	 */
	protected String ID = "";
	/**
	 * Le texte de la reponse
	 */
	protected String texte = "";
	/**
	 * Le ID de l'expert qui a donne la reponse
	 */
	protected String expertID = "";
	/**
	 * L'evaluation qui est donnee par l'utilisateur
	 * -1 si elle n'a pas ete evaluee
	 */
	protected int evaluation = -1;
	/**
	 * La question a laquelle on repond
	 */
	protected Question question = null;
	
	public Reponse(Question question) {

        this.question = question;
		this.ID = UUID.randomUUID().toString();
	}
	
	/**
	 * @return Le ID de la reponse
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * @param ID Le ID de la reponse
	 */
	public void setID(String ID) {

        this.ID = ID;
	}
	
	/**
	 * @return Le texte de la reponse
	 */
	public String getTexte() {

        return texte;
	}
	
	/**
	 * @param texte Le texte de la reponse
	 */
	public void setTexte(String texte) {

        this.texte = texte;
	}
	
	/**
	 * @return Le ID de l'expert qui a donne la reponse
	 */
	public String getExpertID() {

        return expertID;
	}
	
	/**
	 * @param expertID Le ID de l'expert qui a donne la reponse
	 */
	public void setExpertID(String expertID) {

        this.expertID = expertID;
	}
	
	/**
	 * @return L'evaluation qui est donne par l'utilisateur a la reponse donnee
	 */
	public int getEvaluation() {

        return evaluation;
	}
	
	/**
	 * @param eval L'evaluation qui est donne par l'utilisateur a la reponse donnee
     *             de 0 a 5
	 */
	public void setEvaluation(int eval) {

        this.evaluation = eval;
	}

	/**
	 * @return La question a laquelle on repond
	 */
	public Question getQuestion() {
		return question;
	}
	
	/**
	 * @return Le ID de la question a laquelle on repond
	 */
	public String getQuestionID() {
		if (question != null) {
			return question.getID();
		}
		return null;
	}


	@Override
	public String toString() {
		// Une reponse est representee par son texte
		return getTexte();
	}
}
