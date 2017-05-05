/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import edu.formation.cafe.models.Consommation;

/**
 * Classe DAO de l'objet métier Consommation
 * 
 * @author Seme
 *
 */
public class ConsommationDAO extends MainDAO
{

    /**
     * Constructeur de la classe
     * 
     * @param uneConnexion
     *            la connexion à la BDD
     */
    public ConsommationDAO(Connection uneConnexion)
    {
        super(uneConnexion);
    }

    /**
     * Retourne la liste des consommations du système
     * 
     * @return HashMap<Integer, Consommation> Liste des consommations
     */
    public HashMap<Integer, Consommation> getListeDeConsommations()
    {
        // je crée une liste vide
        HashMap<Integer, Consommation> liste = new HashMap<Integer, Consommation>();

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM consommation");

            /*
             * Etape 5 : parcours des résultats
             */
            while (rs.next())
            {
                // je remplis la liste avec l'objet métier conso créé ci-dessus
                liste.put(rs.getInt("numCon"),
                        new Consommation(rs.getInt("numCon"), rs.getString("libelleCon"), rs.getFloat("prixCon")));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // je retourne la liste des consommations
        return liste;
    }
}
