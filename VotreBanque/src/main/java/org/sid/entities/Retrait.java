package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*
**
*HABI
*
*/

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
