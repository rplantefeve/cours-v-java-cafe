/**
 * 
 */
package edu.formation.cafe.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Seme
 *
 */
public class Facture
{
    /**
     * numéro de la facture
     */
    private int numero;
    /**
     * Date de l'émission de la facture
     */
    private Date date;
    /**
     * Liste des enregistrements (conso + quantité) ou "ligne de facture"
     */
    private List<Enregistrement> enregistrements;
    private Table table;
    private Serveur serveur;

    /**
     * @param numero
     * @param date
     */
    public Facture(int numero, Date date)
    {
        this.numero = numero;
        this.date = date;
        /*
         * initialisation notre liste d'enregistrement (rappel : un enre-
         * gistrement contient une conso et une quantité consommée
         */
        this.enregistrements = new ArrayList<Enregistrement>();
    }

    /**
     * Implémente l'action du serveur à sortir son carnet de factures lorsqu'il
     * arrive à la table
     * 
     * @param serveur
     *            Le serveur en question
     * @param table
     *            La table servie
     */
    public void initialiserFacture(Serveur serveur, Table table)
    {
        this.serveur = serveur;
        this.table = table;
    }

    /**
     * Ajoute un enregistrement à la facture
     * 
     * @param conso
     *            La consommation désirée
     * @param quantite
     *            La quantité commandée
     */
    public void ajouterEnregistrement(Consommation conso, int quantite)
    {
        // ajout à la liste des enregistrements
        this.enregistrements.add(new Enregistrement(quantite, conso));
    }

    /**
     * @return the numero
     */
    public int getNumero()
    {
        return numero;
    }

    /**
     * @param numero
     *            the numero to set
     */
    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the enregistrements
     */
    public List<Enregistrement> getEnregistrements()
    {
        return enregistrements;
    }

    /**
     * @param enregistrements the enregistrements to set
     */
    public void setEnregistrements(List<Enregistrement> enregistrements)
    {
        this.enregistrements = enregistrements;
    }

    /**
     * @return the table
     */
    public Table getTable()
    {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Table table)
    {
        this.table = table;
    }

    /**
     * @return the serveur
     */
    public Serveur getServeur()
    {
        return serveur;
    }

    /**
     * @param serveur the serveur to set
     */
    public void setServeur(Serveur serveur)
    {
        this.serveur = serveur;
    }

    /**
     * Nouvelle méthode toString
     */
    @Override
    public String toString()
    {
        // Objet tampon qui permet de manipuler une chaine de caractères
        StringBuffer sb = new StringBuffer(String.format("| %1$-3s| %2$-21s| %3$-6s|%4$22s|%4$8s|%4$7s|%n", this.numero, this.serveur.getNom(), this.table.getNumero(), ""));
        // boucle de parcours de ma liste d'enregistrements
        for (Enregistrement enreg : this.enregistrements)
        {
            sb.append(String.format("|%2$4s|%2$22s|%2$7s| %1$-38s|%n", enreg.toString(), ""));
        }
        return sb.toString();
    }

}
