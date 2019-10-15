package edu.formation.cafe.controllers;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import edu.formation.cafe.dao.ConsommationDAO;
import edu.formation.cafe.dao.FactureDAO;
import edu.formation.cafe.dao.ServeurDAO;
import edu.formation.cafe.dao.TableDAO;
import edu.formation.cafe.models.Consommation;
import edu.formation.cafe.models.Facture;
import edu.formation.cafe.models.Serveur;
import edu.formation.cafe.models.Table;
import edu.formation.cafe.views.ConsoleView;
import edu.formation.cafe.views.ServeurFrame;

public class MainCafeDatabase {
  /*
   * Liste d'Objets métiers
   */
  public static HashMap<Integer, Consommation> consommations;
  public static HashMap<String, Serveur> serveurs;
  public static HashMap<Integer, Table> tables;
  public static HashMap<Integer, Facture> factures;

  /*
   * Liste des vues
   */
  public static ConsoleView console = new ConsoleView();


  public static void main(String[] args) throws ParseException {
    /*
     * Objets DAO
     */
    ConsommationDAO consoDAO;
    ServeurDAO serveurDAO;
    TableDAO tableDAO;
    FactureDAO factureDAO;

    try {
      /*
       * Etape 1 : chargement du pilote JDBC MySQL Update: plus besoin de faire cela depuis la
       * version 8.0 du connecteur (passage de la v5.1 à 8.0 directement)
       * De plus, le nom de la classe a changé : com.mysql.cj.jdbc.Driver
       */
      // Class.forName("com.mysql.jdbc.Driver");

      /*
       * Etape 2 : Connexion à la base de données
       */
      Connection conn = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC", "user", "Us3rUs€r");

      /*
       * Initialiser mes objets DAO
       */
      consoDAO = new ConsommationDAO(conn);
      serveurDAO = new ServeurDAO(conn);
      tableDAO = new TableDAO(conn);
      factureDAO = new FactureDAO(conn);

      ServeurFrame serveurFrame = new ServeurFrame(serveurDAO);

      // je peux faire appel à ses services
      // je souhaite récupérer toutes les consommations
      consommations = consoDAO.getListeDeConsommations();
      // je souhaite récupérer tous les serveurs
      serveurs = serveurDAO.getListeDeServeurs();
      // je souhaite récupérer toutes les tables
      tables = tableDAO.getListeDeTables();
      // je souhaite récupérer toutes les factures
      factures = factureDAO.getListeDefactures();

      /*
       * Interface graphique
       */
      boolean quitter = false;
      Scanner in = null;
      // boucle de saisie
      do {
        // Sortie
        console.displayMenu();
        // Entrée
        in = new Scanner(System.in);
        int choix = in.nextInt();
        switch (choix) {
          case 1:
            console.displayServeurs(false);
            break;
          case 11:
            console.displayServeurs(true);
            interfaceModifierServeur(serveurDAO);
            break;
          case 12:
            break;
          case 13:
            break;
          case 2:
            console.displayConsommations();
            break;
          case 21:
            break;
          case 22:
            break;
          case 23:
            break;
          case 3:
            console.displayTables();
            break;
          case 31:
            break;
          case 32:
            break;
          case 33:
            break;
          case 4:
            console.displayFactures();
            break;
          case 41:
            break;
          case 42:
            break;
          case 43:
            break;
          case 0:
            System.out.println("Vous quittez l'application.");
            quitter = true;
            break;
        }
        in.reset();

      } while (!quitter);
      in.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    /*
     * Simuler le fait que John serve à la table en osier
     */
    Date aujourdhui = new Date();
    Facture facture1 = new Facture(1, aujourdhui);
    // Le serveur John prend son carnet de factures, et commence à écrire
    // facture1.initialiserFacture((Serveur) john, tableosier);
    // Puis, il prend une commande
    // facture1.ajouterEnregistrement(pastis, 2);
    // puis une autre
    // facture1.ajouterEnregistrement(coca, 4);

    /*
     * Affichage des consommations bues
     */
    // System.out.println(facture1.toString());

  }

  /**
   * @param serveurDAO
   */
  private static void interfaceModifierServeur(ServeurDAO serveurDAO) {
    Scanner in;
    System.out.println("Veuillez rentrer le matricule du serveur que vous souhaitez modifier : ");
    in = new Scanner(System.in);
    String matricule = in.next();
    Serveur serveurAmodifier = MainCafeDatabase.serveurs.get(matricule);
    if (serveurAmodifier != null) {
      String nom = serveurAmodifier.getNom();
      String adresse = serveurAmodifier.getAdresse();
      String courriel = serveurAmodifier.getEmail();
      Date dateEmbauche = serveurAmodifier.getDateEmbauche();
      System.out.printf("Nouveau nom [%s] : ", nom);
      String nomSaisi = lireConsole();
      // si quelquechose a été saisi ET le nom saisi est différent du nom
      // actuel
      if (nomSaisi.length() > 0 && !nomSaisi.equals(nom)) {
        nom = nomSaisi;
      }
      System.out.printf("Nouvelle adresse [%s] : ", adresse);
      String adresseSaisie = lireConsole();
      if (adresseSaisie.length() > 0 && !adresseSaisie.equals(adresse)) {
        adresse = adresseSaisie;
      }
      System.out.printf("Nouvelle adresse email [%s] : ", courriel);
      String courrielSaisi = lireConsole();
      if (courrielSaisi.length() > 0 && !courrielSaisi.equals(courriel)) {
        courriel = courrielSaisi;
      }
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      System.out.printf("Nouvelle date d'embauche [%s] : ", dateEmbauche);
      Date dateSaisie;
      try {
        String dateSaisieStr = lireConsole();
        if (dateSaisieStr.length() > 0) {
          dateSaisie = sdf.parse(dateSaisieStr);
          if (!sdf.format(dateEmbauche).equals(sdf.format(dateSaisie))) {
            dateEmbauche = dateSaisie;
          }
        }
      } catch (ParseException e) {
        System.out.println("Mauvais format de date rentré ! (yyyy-MM-dd attendu)");
      }
      // une fois qu'on a récupéré toutes les modifications,
      // on
      // lance la fonction du DAO qui va mettre à jour
      serveurDAO.modifierServeur(matricule, nom, adresse, dateEmbauche, courriel);
      System.out.println("Serveur modifié.");
      console.waitNext();
      // Je mets à jour les serveurs
      serveurs = serveurDAO.getListeDeServeurs();
    }

  }

  /**
   * @return
   */
  private static String lireConsole() {
    byte[] saisie = new byte[255];
    String saisieStr = null;

    try {
      int nbLus = System.in.read(saisie);
      saisieStr = new String(saisie, 0, nbLus - 2);
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return saisieStr;
  }

}
