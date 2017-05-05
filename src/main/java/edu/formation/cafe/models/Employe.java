package edu.formation.cafe.models;

/**
 * Classe Employe
 * 
 * @author R. Plantefève
 *
 */
public class Employe
{
    /**
     * Matricule de l'employé
     */
    protected String matricule;
    /**
     * Numéro de sécurité sociale de l'employé
     */
    protected String numSecu;

    /**
     * @param matricule
     * @param numSecu
     */
    public Employe(String matricule, String numSecu)
    {
        this.matricule = matricule;
        this.numSecu = numSecu;
    }

    /**
     * @return the matricule
     */
    public String getMatricule()
    {
        return matricule;
    }

    /**
     * @param matricule
     *            the matricule to set
     */
    public void setMatricule(String matricule)
    {
        this.matricule = matricule;
    }

    /**
     * @return the numSecu
     */
    public String getNumSecu()
    {
        return numSecu;
    }

    /**
     * @param numSecu
     *            the numSecu to set
     */
    public void setNumSecu(String numSecu)
    {
        this.numSecu = numSecu;
    }

}
