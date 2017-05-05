/**
 * 
 */
package edu.formation.cafe.views;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import edu.formation.cafe.controllers.MainCafeDatabase;

/**
 * @author Seme
 *
 */
public class ConsoleView
{
    private PrintStream console;

    public ConsoleView()
    {
        console = System.out;
    }

    /**
     * Affiche le menu de l'application
     */
    public void displayMenu()
    {
        String fmtEntete = "|   %1$-13s|     %2$-13s|      %3$-12s|    %4$-14s|%n";
        String fmt = "|%1$-16s| %2$-17s| %3$-17s| %4$-17s|%n";
        String separateur = "+-------------------------------------------------------------------------+\n";
        console.printf("%s", separateur);
        console.printf(fmtEntete, "Afficher", "Modifier", "Créer", "Supprimer");
        console.printf("%s", separateur);
        console.printf(fmt, "1. Serveur", "11. Serveur", "12. Serveur", "13. Serveur");
        console.printf(fmt, "2. Consommation", "21. Consommation", "22. Consommation", "23. Consommation");
        console.printf(fmt, "3. Table", "31. Table", "32. Table", "33. Table");
        console.printf(fmt, "4. Facture", "41. Facture", "42. Facture", "43. Facture");
        console.printf("%s", separateur);
        console.printf("%s", "Pour quitter, option 0\n\n");
        console.printf("%s", "Veuillez choisir une option : ");
    }

    /**
     * Affiche les consommations du café
     */
    public void displayConsommations()
    {
        String fmtEntete = "|       %1$-15s| %2$-6s|%n";
        String fmt = "| %1$-20s|%n";
        String separateur = "+------------------------------+\n";
        PrintStream console = System.out;
        console.printf("%s", separateur);
        console.printf(fmtEntete, "Libellé", "Prix");
        console.printf("%s", separateur);
        Iterator<Integer> it = MainCafeDatabase.consommations.keySet().iterator();
        while (it.hasNext())
        {
            Integer numCon = it.next();
            console.printf(fmt, MainCafeDatabase.consommations.get(numCon).toString());
        }
        console.printf("%s", separateur);
        this.waitNext();
    }

    /**
     * Affiche les serveurs du café
     */
    public void displayServeurs(boolean modifier)
    {
        String fmtEntete = "|  %1$-6s|       %2$-10s|%n";
        String fmt = "| %1$-25s|%n";
        String separateur = "+--------------------------+\n";
        PrintStream console = System.out;
        console.printf("%s", separateur);
        console.printf(fmtEntete, "Mat.", "Nom");
        console.printf("%s", separateur);
        Iterator<String> it = MainCafeDatabase.serveurs.keySet().iterator();
        while (it.hasNext())
        {
            String matricule = it.next();
            console.printf(fmt, MainCafeDatabase.serveurs.get(matricule).toString());
        }
        console.printf("%s", separateur);
        // si on n'est pas en modification
        if (!modifier)
        {
            this.waitNext();
        }
    }

    /**
     * Affiche les factures du café
     */
    public void displayFactures()
    {
        String fmtEntete = "| %1$-3s|       %2$-15s| %6$-6s|       %3$-15s| %4$-7s| %5$-6s|%n";
        String separateur = "+---------------------------------------------------------------------------+\n";
        PrintStream console = System.out;
        console.printf("%s", separateur);
        console.printf(fmtEntete, "N.", "Serveur", "Boisson", "PU", "Qté", "Table");
        console.printf("%s", separateur);
        Iterator<Integer> it = MainCafeDatabase.factures.keySet().iterator();
        while (it.hasNext())
        {
            Integer numFac = it.next();
            console.printf("%s", MainCafeDatabase.factures.get(numFac).toString());
            console.printf("%s", separateur);
        }
        this.waitNext();
    }

    public void displayModifierServeur()
    {

    }

    /**
     * 
     */
    public void waitNext()
    {
        System.out.println("Appuyer sur entrée pour afficher le menu. ");
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Affiche les tables du café
     */
    public void displayTables()
    {
        String fmtEntete = "| %1$-3s|       %2$-15s| %3$-4s|%n";
        String fmt = "| %1$-25s|%n";
        String separateur = "+---------------------------------+\n";
        PrintStream console = System.out;
        console.printf("%s", separateur);
        console.printf(fmtEntete, "N.", "Type", "Pl.");
        console.printf("%s", separateur);
        Iterator<Integer> it = MainCafeDatabase.tables.keySet().iterator();
        while (it.hasNext())
        {
            Integer numTab = it.next();
            console.printf(fmt, MainCafeDatabase.tables.get(numTab).toString());
        }
        console.printf("%s", separateur);
        this.waitNext();

    }

}
