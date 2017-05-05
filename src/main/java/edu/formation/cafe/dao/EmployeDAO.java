/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Seme
 *
 */
public class EmployeDAO extends MainDAO
{

    /**
     * @param uneConnexion
     */
    public EmployeDAO(Connection uneConnexion)
    {
        super(uneConnexion);
        // TODO Auto-generated constructor stub
    }

    public String getNumSecu(String matricule) throws SQLException
    {
        /*
         * Etape 3 : Instanciation du Statement
         */
        Statement stmt = this.connexion.createStatement();
        /*
         * Etape 4bis : exécuter une requête
         */
        ResultSet rs = stmt.executeQuery("SELECT numSecu FROM employe WHERE matricule = '" + matricule + "'");

        /*
         * Etape 5 : parcours des résultats
         */
        rs.next();
        return rs.getString("numSecu");
    }

}
