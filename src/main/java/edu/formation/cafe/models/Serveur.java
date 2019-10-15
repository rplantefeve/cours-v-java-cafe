/**
 * 
 */
package edu.formation.cafe.models;

import java.util.Date;

/**
 * @author Seme
 *
 */
public class Serveur extends Employe {
  private String nom;
  private String adresse;
  private Date dateEmbauche;
  private String email;

  /**
   * @param matricule
   * @param numSecu
   * @param nom
   * @param adresse
   * @param dateEmbauche
   * @param email
   */
  public Serveur(String matricule, String numSecu, String nom, String adresse, Date dateEmbauche,
      String email) {
    super(matricule, numSecu);
    this.nom = nom;
    this.adresse = adresse;
    this.dateEmbauche = dateEmbauche;
    this.email = email;
  }

  /**
   * @return the nom
   */
  public String getNom() {
    return nom;
  }

  /**
   * @param nom the nom to set
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * @return the adresse
   */
  public String getAdresse() {
    return adresse;
  }

  /**
   * @param adresse the adresse to set
   */
  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  /**
   * @return the dateEmbauche
   */
  public Date getDateEmbauche() {
    return dateEmbauche;
  }

  /**
   * @param dateEmbauche the dateEmbauche to set
   */
  public void setDateEmbauche(Date dateEmbauche) {
    this.dateEmbauche = dateEmbauche;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public String toString() {
    return this.matricule + " | " + this.nom;
  }
}
