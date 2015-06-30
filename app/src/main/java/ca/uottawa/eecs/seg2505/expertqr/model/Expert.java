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

public class Expert implements Serializable {
	
	private static final long serialVersionUID = 5736373841598132425L;
	/**
	 * Chaque expert doit avoir une expertise (simplification)
	 * En realite un expert devrait pouvoir avoir plusieurs expertises 1..*
	 */
	protected Expertise expertise = null;
	/**
	 * La cote de l'expert (de 0 a 5).
	 */
	protected double cote = -1; // -1 signifie sans cote

	public Expert(Expertise expertise) {

		this.expertise = expertise;
	}

	/**
	 * @return L'expertise de l'expert
	 */
	public Expertise getExpertise() {

		return expertise;
	}

	public void nouvelleExpertise(Expertise expertise) {

		this.expertise = expertise;
	}

	/**
	 * @return La cote de l'expert
	 */
	public double getCote() {

		return cote;
	}

	/**
	 * @param cote La cote de l'expert
	 */
	public void setCote(double cote) {

		this.cote = cote;
	}
}
