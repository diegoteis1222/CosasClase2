import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class GestionProductos extends JFrame {

    private Connection connection;
    private JTable table;
    private DefaultTableModel tableModel;

    public GestionProductos(Connection conn) {
        this.connection = conn;

        setTitle("Gestión de Productos - Northwind (Modo CSV)");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Botones y panel
        JPanel topPanel = new JPanel();
        JButton btnMostrar = new JButton("Mostrar Productos");
        JButton btnCargar = new JButton("Importar CSV");
        JButton btnExportar = new JButton("Exportar a CSV");

        //adds
        topPanel.add(btnMostrar);
        topPanel.add(btnCargar);
        topPanel.add(btnExportar);
        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnMostrar.addActionListener(e -> mostrarTabla());
        btnCargar.addActionListener(e -> cargarDatosCSV());
        btnExportar.addActionListener(e -> exportarDatosCSV());
    }

    private void mostrarTabla() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        String sql = "SELECT * FROM products ORDER BY ProductID DESC";

        try (Statement stmt = connection.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error SQL: " + e.getMessage());
        }
    }

    private void cargarDatosCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            int registrosImportados = 0;

            String sql = "INSERT INTO products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (BufferedReader br = new BufferedReader(new FileReader(fichero)); 
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {

                String linea;
                boolean primeraLinea = true;

                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) {
                        continue;
                    }

                    if (primeraLinea) {
                        primeraLinea = false;
                        continue;
                    }

                    String[] datos = linea.split(",");

                    if (datos.length < 9) {
                        continue;
                    }

                    try {
                        pstmt.setString(1, datos[0].trim());
                        pstmt.setInt(2, Integer.parseInt(datos[1].trim()));
                        pstmt.setInt(3, Integer.parseInt(datos[2].trim()));
                        pstmt.setString(4, datos[3].trim());
                        pstmt.setDouble(5, Double.parseDouble(datos[4].trim()));
                        pstmt.setShort(6, Short.parseShort(datos[5].trim()));
                        pstmt.setShort(7, Short.parseShort(datos[6].trim()));
                        pstmt.setShort(8, Short.parseShort(datos[7].trim()));
                        pstmt.setInt(9, Integer.parseInt(datos[8].trim()));

                        pstmt.executeUpdate();
                        registrosImportados++;
                    } catch (NumberFormatException ex) {
                        System.err.println("Error de formato en línea: " + linea);
                    }
                }

                JOptionPane.showMessageDialog(this, "SE HAN IMPORTADO " + registrosImportados + " REGISTROS");
                mostrarTabla();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al importar: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void exportarDatosCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

        int seleccion = fileChooser.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            if (!fichero.getName().toLowerCase().endsWith(".csv")) {
                fichero = new File(fichero.getParentFile(), fichero.getName() + ".csv");
            }

            int registrosExportados = 0;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero)); 
                 Statement stmt = connection.createStatement(); 
                 ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

                int colCount = rs.getMetaData().getColumnCount();

                for (int i = 1; i <= colCount; i++) {
                    bw.write(rs.getMetaData().getColumnName(i));
                    if (i < colCount) {
                        bw.write(",");
                    }
                }
                bw.newLine();

                while (rs.next()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= colCount; i++) {
                        Object val = rs.getObject(i);
                        sb.append(val == null ? "" : val.toString());
                        if (i < colCount) {
                            sb.append(",");
                        }
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                    registrosExportados++;
                }

                JOptionPane.showMessageDialog(this, "SE HAN EXPORTADO " + registrosExportados + " REGISTROS.");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al exportar: " + e.getMessage());
            }
        }
    }
}