package fr.uvsq.uvsq21602062.projet_maven;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe implementant DAO suivant le patron de conception DAO.
 * @author jean
 *
 */
public class PersonnelDAO implements DAO<Personnel> {
	/**
	 * Méthode permettant de trouver tous les elements
	 */
	public ArrayList<Personnel> toutObtenir() {
		ArrayList<Personnel> liste = new ArrayList<Personnel>();
		
		try(ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("fichier_sauvegarde")))) {
			try {
				while(true) {
					try {
						liste.add((Personnel) in.readObject());
					}
					catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			catch(EOFException e) {}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return liste;
	}
	
	/**
	 * Méthode permettant d'ajouter un element
	 */
	public void ajouter(Personnel obj) {
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("fichier_sauvegarde")))) {
			out.writeObject(obj);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
