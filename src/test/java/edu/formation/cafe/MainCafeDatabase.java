package edu.formation.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainCafeDatabase {

  public static void main(String[] args) throws ParseException {
    // Format de la date
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // Liste des consommations
    List<Consommation> consos = new ArrayList<>();

    try {
      /*
       * Etape 1 : chargement du pilote JDBC MySQL. Deprecated.
       */
      // Class.forName("com.mysql.jdbc.Driver");

      /*
       * Etape 2 : Connexion à la base de données
       */
      Connection conn = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC", "user", "Us3rUs€r");

      /*
       * Etape 3 : Instanciantion du Statement
       */
      Statement stmt = conn.createStatement();

      /*
       * Etape 4bis : exécuter une requête
       */
      ResultSet rs = stmt.executeQuery("SELECT * FROM consommation");

      /*
       * Etape 5 : parcours des résultats
       */
      while (rs.next()) {
        consos.add(new Consommation(rs.getInt("numCon"), rs.getString("libelleCon"),
            rs.getFloat("prixCon")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    /*
     * Liste des consommations du café
     */
    Consommation conso1 = consos.get(0);
    Consommation conso2 = consos.get(1);

    /*
     * Liste des serveurs
     */
    Employe john = new Serveur("m024565", "1854654613456", "John", "rue de la plaine",
        sdf.parse("26/04/2016"), "john@yahoo.fr");

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
    facture1.ajouterEnregistrement(conso1, 2);
    // puis une autre
    facture1.ajouterEnregistrement(conso2, 4);

    /*
     * Affichage des consommations bues
     */
    System.out.println(facture1.toString());

  }

}
