package edu.formation.cafe;

import edu.formation.cafe.Consommation;
import edu.formation.cafe.Employe;
import edu.formation.cafe.Facture;
import edu.formation.cafe.Serveur;
import edu.formation.cafe.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainCafe {

  public static void main(String[] args) throws ParseException {
    // Format de la date
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /*
     * Liste des consommations du café
     */
    Consommation coca = new Consommation(1, "Coca", 2.5f);
    Consommation cocalight = new Consommation(2, "Coca-light", 2.5f);
    Consommation leffebrune = new Consommation(3, "Leffe brune", 3.5f);
    Consommation pastis = new Consommation(4, "Pastis", 4.5f);

    /*
     * Liste des serveurs
     */
    Employe john = new Serveur("m024565", "1854654613456", "John",
        "rue de la plaine", sdf.parse("26/04/2016"), "john@yahoo.fr");

    /*
     * Liste des tables
     */
    Table tableosier = new Table(1, 4, "osier");

    /*
     * Simuler le fait que John serve à la table en osier
     */
    Date aujourdhui = new Date();
    Facture facture1 = new Facture(1, aujourdhui);
    // Le serveur John prend son carnet de factures, et commence à écrire
    facture1.initialiserFacture((Serveur) john, tableosier);
    // Puis, il prend une commande
    facture1.ajouterEnregistrement(pastis, 2);
    // puis une autre
    facture1.ajouterEnregistrement(coca, 4);

    /*
     * Affichage des consommations bues
     */
    System.out.println(facture1.toString());



  }

}
