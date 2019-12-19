/**
 * 
 */
package edu.formation.cafe;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ServeurModel extends AbstractTableModel {
  private String[] tabelColumnNames = new String[] {"MATRICULE", "NOM", "EMAIL"};
  private Vector<String[]> tableValues = new Vector<String[]>();

  @Override
  public int getRowCount() {
    return tableValues.size();
  }

  @Override
  public int getColumnCount() {
    return tabelColumnNames.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return tableValues.get(rowIndex)[columnIndex];
  }

  @Override
  public String getColumnName(int column) {
    return tabelColumnNames[column];
  }

  public void setData(List<Serveur> serveurs) {
    tableValues = new Vector<String[]>();
    for (Serveur serveur : serveurs) {
      tableValues.add(new String[] {String.valueOf(serveur.getMatricule()), serveur.getNom(),
          serveur.getEmail()});
    }
    fireTableChanged(null);
  }
}
