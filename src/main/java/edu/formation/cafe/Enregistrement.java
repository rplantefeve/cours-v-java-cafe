/**
 * 
 */
package edu.formation.cafe;

/**
 * @author Seme
 *
 */
public class Enregistrement {
  private int quantite;
  private Consommation consommation;

  /**
   * @param quantite
   */
  public Enregistrement(int quantite, Consommation conso) {
    this.quantite = quantite;
    this.consommation = conso;
  }

  /**
   * @return the quantite
   */
  public int getQuantite() {
    return quantite;
  }

  /**
   * @param quantite the quantite to set
   */
  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }

  public String toString() {
    // taille totale = 37
    return String.format("%1$-29s | %2$-6s", this.consommation.toString(), this.quantite);
  }

}
