/**
 * 
 */
package edu.formation.cafe.models;

import java.io.Serializable;

/**
 * @author Seme
 *
 */
public class Consommation implements Serializable {
  private static final long serialVersionUID = 6895111017326333387L;
  /**
   * Le libellé de la consommation
   */
  private String libelle;
  /**
   * Le prix de la consommation en euros
   */
  private float prix;
  /**
   * Le numéro de la consommation
   */
  private int numero;

  /**
   * 
   * @param numero
   * @param libelle
   * @param prix
   */
  public Consommation(int numero, String libelle, float prix) {
    this.libelle = libelle;
    this.prix = prix;
    this.numero = numero;
  }

  /**
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @param numero the numero to set
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * @return the libelle
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * @param libelle the libelle to set
   */
  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * @return the prix
   */
  public float getPrix() {
    return prix;
  }

  /**
   * @param prix the prix to set
   */
  public void setPrix(float prix) {
    this.prix = prix;
  }

  /**
   * 
   */
  @Override
  public String toString() {
    // taille totale = 29
    return String.format("%1$-20s | %2$-6s", this.libelle, this.prix + "€");
  }

}
