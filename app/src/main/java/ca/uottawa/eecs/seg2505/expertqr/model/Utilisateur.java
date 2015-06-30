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

public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 5825260818261095125L;
	/**
	 * le nom de l'utilisateur est unique
	 */
	protected String nom = "";

	/**
	 * Le role expert
	 */
	protected Expert roleExpert = null;
	
	public Utilisateur() {
	}
	
	/**
	 * @return le nom de l'utilisateur
	 */
	public String getNom() {

		return nom;
	}
	
	/**
	 * @param nom le nom de l'utilisateur
	 */
	public void setNom(String nom) {

		this.nom = nom;
	}

	/**
	 * @return Un objet qui n'est pas nul si l'utilisateur est un expert
	 */
	public Expert getRoleExpert() {

		return roleExpert;
	}

	/**
	 * @param roleExpert Le role expert associe a l'utilisateur
	 */
	public void setRoleExpert(Expert roleExpert) {

		this.roleExpert = roleExpert;
	}
}
