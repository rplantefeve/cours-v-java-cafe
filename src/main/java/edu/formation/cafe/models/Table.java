/**
 * 
 */
package edu.formation.cafe.models;

/**
 * @author Seme
 *
 */
public class Table {
  private int numero;
  private int nbPlaces;
  private String type;

  /**
   * @param numero
   * @param nbPlaces
   * @param type
   */
  public Table(int numero, int nbPlaces, String type) {
    this.numero = numero;
    this.nbPlaces = nbPlaces;
    this.type = type;
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
   * @return the nbPlaces
   */
  public int getNbPlaces() {
    return nbPlaces;
  }

  /**
   * @param nbPlaces the nbPlaces to set
   */
  public void setNbPlaces(int nbPlaces) {
    this.nbPlaces = nbPlaces;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  public String toString() {
    return String.format("%1$-2s | %2$-20s | %3$-4s", this.numero, this.type, this.nbPlaces);
  }

}
