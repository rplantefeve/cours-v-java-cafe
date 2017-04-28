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
import edu.formation.cafe.models.Consommation;
import edu.formation.cafe.models.Table;

/**
 * Classe DAO de l'objet métier Table
 * 
 * @author Seme
 *
 */
public class TableDAO extends MainDAO
{

    /**
     * Constructeur de la classe
     * 
     * @param uneConnexion
     *            la connexion à la BDD
     */
    public TableDAO(Connection uneConnexion)
    {
        super(uneConnexion);
    }
    
    /**
     * Retourne la liste des Tables du système
     * 
     * @return HashMap<Integer, Table> Liste des Tables
     */
    public HashMap<Integer, Table> getListeDeTables()
    {
        // je crée une liste vide
        HashMap<Integer, Table> liste = new HashMap<Integer, Table>();

        Statement stmt;
        try
        {
            /*
             * Etape 3 : Instanciation du Statement
             */
            stmt = this.connexion.createStatement();
            /*
             * Etape 4bis : exécuter une requête
             */
            ResultSet rs = stmt.executeQuery("SELECT * FROM tables");

            /*
             * Etape 5 : parcours des résultats
             */
            while (rs.next())
            {
                // je remplis la liste avec l'objet métier table créé ci-dessus
                liste.put(rs.getInt("numTab"),
                        new Table(rs.getInt("numTab"), rs.getInt("nbPlaces"), rs.getString("typeTab")));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // je retourne la liste des tables
        return liste;
    }
}
