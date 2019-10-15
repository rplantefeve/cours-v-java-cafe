/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import edu.formation.cafe.controllers.MainCafeDatabase;
import edu.formation.cafe.models.Enregistrement;
import edu.formation.cafe.models.Facture;

/**
 * @author Seme
 *
 */
public class FactureDAO extends MainDAO {
  private EnregistrementDAO enregDAO;
  private TableDAO tableDAO;

  /**
   * @param uneConnexion
   */
  public FactureDAO(Connection uneConnexion) {
    super(uneConnexion);
    this.enregDAO = new EnregistrementDAO(uneConnexion);
    this.tableDAO = new TableDAO(uneConnexion);
  }

  /**
   * Retourne la liste des factures du système
   * 
   * @return HashMap<Integer, Facture> Liste des factures
   */
  public HashMap<Integer, Facture> getListeDefactures() {
    // je crée une liste vide de factures
    HashMap<Integer, Facture> liste = new HashMap<Integer, Facture>();

    Statement stmt;
    try {
      /*
       * Etape 3 : Instanciation du Statement
       */
      stmt = this.connexion.createStatement();
      /*
       * Etape 4bis : exécuter une requête
       */
      ResultSet rs = stmt.executeQuery("SELECT * FROM facture");

      /*
       * Etape 5 : parcours des résultats
       */
      while (rs.next()) {
        // je crée une liste vide d'enregistrements
        ArrayList<Enregistrement> enregs = new ArrayList<Enregistrement>();
        // Je récupère la liste des enregistrements
        enregs = enregDAO.getEnregistrementsFacture(rs.getInt("numFac"));
        // je remplis la liste avec l'objet métier conso créé ci-dessus
        Facture facture = new Facture(rs.getInt("numFac"), rs.getDate("dateFac"));
        facture.setEnregistrements(enregs);
        facture.setServeur(MainCafeDatabase.serveurs.get(rs.getString("numSer")));
        facture.setTable(MainCafeDatabase.tables.get(rs.getInt("numTab")));
        liste.put(rs.getInt("numFac"), facture);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // je retourne la liste des factures
    return liste;
  }

}
