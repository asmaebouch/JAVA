package Vue.palette;


import presentation.model.Client;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private String[] columnNames;//header
    private Object[][] data;//body

    public TableModel(String ... Names){

        initColumn(Names);
    }

    public void initColumn(String ... Names) {
        columnNames = new String[Names.length];
        for (int i = 0; i < Names.length; i++) {
            columnNames[i] = Names[i];
        }
    }
    public void intClientsDATA(List<Client> clients){
        data=new Object[clients.size()][columnNames.length];
        int i=0;
        for(Client client:clients){
            data[i][0] =client.getId();
            data[i][1] =client.getNom();
            data[i][2] =client.getPrenom();
            data[i][3] =client.getLogin();
            data[i][4] =client.getMotDePasse();
            data[i][5] =client.getCin();
            data[i][6] =client.getEmail();
            data[i][7] =client.getTel();
            data[i][8] =client.getSexe();
            i++;

        }
        this.fireTableDataChanged();
    }
    public void intAccountsDATA(){

    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    //les noms des columns mais n'est pas obligatoire

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

   /* public static void main(String[] args) {
        TableModel model=new TableModel("","");
        model.intClientsDATA.findAll();
    }*/
}
