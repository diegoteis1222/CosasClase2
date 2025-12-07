package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Product;

public class MainView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnNuevo, btnEditar, btnEliminar, btnRefresh, btnBuscar;
    private JTextField txtBuscar;

    public MainView() {
        super("Gestión de Productos - Northwind (MVC)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"ProductID","ProductName","QuantityPerUnit","UnitPrice","UnitsInStock"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(table);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscar = new JTextField(30);
        btnBuscar = new JButton("Buscar");
        btnRefresh = new JButton("Actualizar");
        btnNuevo = new JButton("Nuevo");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        top.add(new JLabel("Nombre:"));
        top.add(txtBuscar);
        top.add(btnBuscar);
        top.add(btnRefresh);
        top.add(btnNuevo);
        top.add(btnEditar);
        top.add(btnEliminar);

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void setTableData(List<Product> products) {
        tableModel.setRowCount(0);
        for (Product p : products) {
            tableModel.addRow(new Object[]{
                    p.getProductID(),
                    p.getProductName(),
                    p.getQuantityPerUnit(),
                    p.getUnitPrice(),
                    p.getUnitsInStock()
            });
        }
    }

    public int getSelectedProductId() {
        int row = table.getSelectedRow();
        if (row == -1) return -1;
        return (Integer) tableModel.getValueAt(row, 0);
    }

    public String getSearchText() { return txtBuscar.getText().trim(); }

    // Getters para controller
    public JButton getBtnNuevo() { return btnNuevo; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnRefresh() { return btnRefresh; }
    public JButton getBtnBuscar() { return btnBuscar; }
}
