/**
 * 
 */
package edu.formation.cafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


import edu.formation.cafe.models.Serveur;

/**
 * @author Seme
 *
 */
public class ServeurDAO extends MainDAO
{
    EmployeDAO employeDAO;

    /**
     * Constructeur de la classe
     * 
     * @param uneConnexion
     *            la connexion à la BDD
     */
    public ServeurDAO(Connection uneConnexion)
    {
        super(uneConnexion);
        this.employeDAO = new EmployeDAO(uneConnexion);
    }

    /**
     * Retourne la liste des serveurs du système
     * 
     * @return HashMap<String, Serveur> Liste des serveurs
     */
    public HashMap<String, Serveur> getListeDeServeurs()
    {
        // je crée une liste vide
        HashMap<String, Serveur> liste = new HashMap<String, Serveur>();

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM serveur");

            /*
             * Etape 5 : parcours des résultats
             */
            while (rs.next())
            {
                // on récupère le numéro de sécu
                String numSecu = this.employeDAO.getNumSecu(rs.getString("matricule"));
                // je remplis la liste avec l'objet métier conso créé ci-dessus
                liste.put(rs.getString("matricule"),
                        new Serveur(rs.getString("matricule"), numSecu,
                                rs.getString("nom"), rs.getString("adresse"),
                                rs.getDate("dateEmbauche"), rs.getString("courriel")));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // je retourne la liste des serveurs
        return liste;
    }

    public void modifierServeur(String matricule, String nom, String adresse,
            java.util.Date dateEmbauche, String courriel)
    {
        java.sql.PreparedStatement stmt;
        try
        {
            /*
             * Etape 3 : Instanciation du Statement
             */
            stmt = this.connexion.prepareStatement(
                    "UPDATE serveur SET " +
                            "nom = ?, " +
                            "adresse = ?, " +
                            "dateEmbauche = ?, " +
                            "courriel = ?"
                            + " WHERE matricule = ?");
            stmt.setString(1, nom);
            stmt.setString(2, adresse);
            stmt.setDate(3, new java.sql.Date(dateEmbauche.getTime()));
            stmt.setString(4, courriel);
            stmt.setString(5, matricule);
            /*
             * Etape 4bis : exécuter une requête
             */
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
