import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiscinaApp extends JFrame {
    private Piscina piscina;
    private JComboBox<Integer> comboCapacidad;
    private JLabel lblNivel;

    public PiscinaApp() {
        setTitle("Piscina");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Selector de capacidad
        add(new JLabel("Capacidad de la Piscina en metros cúbicos:"));
        Integer[] capacidades = { 10, 11, 12, 13, 14, 15 };
        comboCapacidad = new JComboBox<>(capacidades);
        add(comboCapacidad);

        JButton btnProbar = new JButton("Probar Piscina");
        add(btnProbar);

        lblNivel = new JLabel("Nivel actual: 0 litros");
        add(lblNivel);

        // Acción del botón
        btnProbar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int capacidad = (int) comboCapacidad.getSelectedItem() * 1000; // 1 m³ = 1000 litros
                piscina = new Piscina(capacidad);

                // Menú de opciones
                while (true) {
                    String[] opciones = { "Llenar", "Vaciar", "Salir" };
                    int opcion = JOptionPane.showOptionDialog(
                            null,
                            "Elige una acción",
                            "Piscina",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]);

                    if (opcion == 2 || opcion == -1)
                        break; // Salir

                    try {
                        int cantidad = Integer.parseInt(
                                JOptionPane.showInputDialog("Cantidad en litros:"));

                        if (opcion == 0) { // Llenar
                            piscina.llenar(cantidad);
                        } else if (opcion == 1) { // Vaciar
                            piscina.vaciar(cantidad);
                        }

                        lblNivel.setText("Nivel actual: " + piscina.getNivel() + " litros");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PiscinaApp().setVisible(true);
        });
    }
}
