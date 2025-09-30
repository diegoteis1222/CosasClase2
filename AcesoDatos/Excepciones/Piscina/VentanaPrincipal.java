import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

    private JComboBox<Double> comboCapacidad;
    private JButton btnProbar, btnLlenar, btnVaciar;
    private JSlider sliderNivel;
    private JTextArea txtArea;

    private double capacidadSeleccionada = 1.0; // metros cúbicos
    private int nivelActual = 0; // litros

    public VentanaPrincipal() {
        setTitle("Simulador de Piscina");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Etiqueta
        JLabel lblCapacidad = new JLabel("Capacidad de la Piscina en metros cúbicos:");
        lblCapacidad.setForeground(Color.RED);
        add(lblCapacidad);

        // ComboBox de capacidades
        Double[] capacidades = {1.0, 1.1, 1.2, 1.3, 1.4, 1.5};
        comboCapacidad = new JComboBox<>(capacidades);
        comboCapacidad.addActionListener(e -> {
            capacidadSeleccionada = (double) comboCapacidad.getSelectedItem();
            actualizarTexto();
        });
        add(comboCapacidad);

        // Botón probar
        btnProbar = new JButton("Probar Piscina");
        add(btnProbar);

        // Botón llenar
        btnLlenar = new JButton("Llenar");
        btnLlenar.setBackground(Color.GREEN);
        btnLlenar.addActionListener(e -> llenarPiscina());
        add(btnLlenar);

        // Botón vaciar
        btnVaciar = new JButton("Vaciar");
        btnVaciar.setBackground(Color.RED);
        btnVaciar.addActionListener(e -> vaciarPiscina());
        add(btnVaciar);

        // Slider
        sliderNivel = new JSlider(0, 1300, 0); // suponiendo 1.3 m³ = 1300 litros
        sliderNivel.setPaintTicks(true);
        sliderNivel.setPaintLabels(true);
        sliderNivel.setMajorTickSpacing(100);
        add(sliderNivel);

        // Área de texto
        txtArea = new JTextArea(5, 30);
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea));

        actualizarTexto();
    }

    private void llenarPiscina() {
        int capacidadLitros = (int) (capacidadSeleccionada * 1000);
        if (nivelActual < capacidadLitros) {
            nivelActual += 100; // cada click aumenta 100 litros
            if (nivelActual > capacidadLitros)
                nivelActual = capacidadLitros;
        }
        sliderNivel.setMaximum(capacidadLitros);
        sliderNivel.setValue(nivelActual);
        actualizarTexto();
    }

    private void vaciarPiscina() {
        if (nivelActual > 0) {
            nivelActual -= 100; // cada click vacía 100 litros
            if (nivelActual < 0)
                nivelActual = 0;
        }
        sliderNivel.setValue(nivelActual);
        actualizarTexto();
    }

    private void actualizarTexto() {
        txtArea.setText("Piscina: " + nivelActual + " / " + (int) (capacidadSeleccionada * 1000) + " litros");
    }

}