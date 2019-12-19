package edu.formation.cafe;

import edu.formation.cafe.Consommation;
import edu.formation.cafe.Employe;
import edu.formation.cafe.Facture;
import edu.formation.cafe.Serveur;
import edu.formation.cafe.Table;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCafeSerialisation {

  public static void main(String[] args) throws ParseException {
    // Format de la date
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /*
     * Liste des consommations du café
     */
    Consommation coca = null;
    Consommation cocalight = null;
    Consommation leffebrune = null;
    Consommation pastis = null;

    // Je teste si le fichier consommation.o existe
    File consommations = new File("consommations.o");
    try {
      // test
      if (consommations.exists()) {
        System.out.println("Lecture depuis le fichier des objets sérialisés...");
        // s'il existe, je déserialise les objets

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(consommations));
        coca = (Consommation) ois.readObject();
        cocalight = (Consommation) ois.readObject();
        leffebrune = (Consommation) ois.readObject();
        pastis = (Consommation) ois.readObject();
        ois.close();

      }
      // sinon le fichier n'existe pas
      else {
        System.out.println("Sérialisation des consommations...");
        // il faut créer les consommations
        coca = new Consommation(1, "Coca", 2.5f);
        cocalight = new Consommation(2, "Coca-light", 2.5f);
        leffebrune = new Consommation(3, "Leffe brune", 3.5f);
        pastis = new Consommation(4, "Pastis", 4.5f);
        /*
         * Sérialisation des consommations
         */
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(consommations));
        oos.writeObject(coca);
        oos.writeObject(cocalight);
        oos.writeObject(leffebrune);
        oos.writeObject(pastis);
        oos.close();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    /*
     * Liste des serveurs
     */
    Employe john =
        new Serveur("m024565", "1854654613456", "John", "rue de la plaine", sdf.parse("26/04/2016"),
            "john@yahoo.fr");

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
