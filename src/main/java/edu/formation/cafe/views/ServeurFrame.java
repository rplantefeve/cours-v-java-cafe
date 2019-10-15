/**
 * 
 */
package edu.formation.cafe.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.formation.cafe.dao.ServeurDAO;
import edu.formation.cafe.models.Serveur;
import edu.formation.cafe.models.ServeurModel;

/**
 * @author Seme
 */
public class ServeurFrame extends JFrame {
  private JScrollPane jsp;
  private JButton jBValider = new JButton("Peupler");
  private JTable jTableEtudiants;
  private JPanel jpN = new JPanel();
  private ServeurModel model;

  public ServeurFrame(ServeurDAO serveurDAO) {
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());
    jpN.setLayout(new FlowLayout());
    jpN.add(jBValider);
    this.add(jpN, BorderLayout.NORTH);
    model = new ServeurModel();
    jTableEtudiants = new JTable(model);
    jsp = new JScrollPane(jTableEtudiants);
    this.add(jsp, BorderLayout.CENTER);
    this.setBounds(10, 10, 500, 500);
    this.setVisible(true);
    jBValider.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.setData(serveurDAO.findAll());
      }
    });
  }
}
