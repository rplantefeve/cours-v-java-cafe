/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;

/**
 * @author Seme
 *
 */
public class MainDAO {
  /**
   * La connexion à la BDD
   */
  protected Connection connexion;

  /**
   * Constructeur de la classe
   * 
   * @param uneConnexion la connexion à la BDD
   */
  public MainDAO(Connection uneConnexion) {
    this.connexion = uneConnexion;

  }
}
