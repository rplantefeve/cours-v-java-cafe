/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.formation.cafe.controllers.MainCafeDatabase;
import edu.formation.cafe.models.Consommation;
import edu.formation.cafe.models.Enregistrement;

/**
 * @author Seme
 *
 */
public class EnregistrementDAO extends MainDAO {

  /**
   * @param uneConnexion
   */
  public EnregistrementDAO(Connection uneConnexion) {
    super(uneConnexion);
    // TODO Auto-generated constructor stub
  }

  private Consommation getConsommationEnregistrement(int numConso) {
    return MainCafeDatabase.consommations.get(numConso);
  }

  public ArrayList<Enregistrement> getEnregistrementsFacture(int numFac) throws SQLException {
    ArrayList<Enregistrement> enregs = new ArrayList<Enregistrement>();
    /*
     * Etape 3 : Instanciation du Statement
     */
    Statement stmt = this.connexion.createStatement();
    /*
     * Etape 4bis : exécuter une requête
     */
    ResultSet rs = stmt.executeQuery("SELECT * FROM enregistrement WHERE numFac = " + numFac);

    /*
     * Etape 5 : parcours des résultats
     */
    while (rs.next()) {
      enregs.add(
          new Enregistrement(rs.getInt("quantite"),
              this.getConsommationEnregistrement(rs.getInt("numCon"))));
    }
    return enregs;
  }

}
