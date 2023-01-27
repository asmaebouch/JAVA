package Vue.palette;

import test.ClientDao;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TablePanel extends JPanel {
    //paneau fih table a l'interieur
    private JScrollPane scrollPane;
    private JTable table;
    private TableModel tableModel;
    private JTableHeader tableHeader;


    private void initPanel() {

        tableModel = new TableModel("Id", "Nom", "Prenom", "Login", "Pass", "CIN", "Email", "Telephone", "SEXE");
        //  List<Client> clients = new ArrayList<(Arrays.asList(new Client("client","1234","nomClieent",null,null,null,null,null);
        tableModel.intClientsDATA(new ClientDao().findall());
        table = new JTable(tableModel);
        table.setFont(new Font("Optima",Font.BOLD,17));
        table.setForeground(new Color(59, 105, 255));
        table.setRowHeight(35);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableHeader=table.getTableHeader();
        tableHeader.setFont(new Font("Optima",Font.BOLD,21));
        tableHeader.setForeground(new Color(253, 0, 79));
        ((DefaultTableCellRenderer)tableHeader.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
       // JTable
                scrollPane = new JScrollPane(table);

    }

    public TablePanel() {
        initPanel();
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}












