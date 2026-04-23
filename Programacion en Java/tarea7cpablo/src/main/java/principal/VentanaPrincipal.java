package principal;

import modelos.Vehiculo;
import servicios.VehiculoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JFrame que muestra una tabla con los 10 primeros registros de vehículos
 * de un archivo JSON
 * 
 * @author alumno
 */
public class VentanaPrincipal extends JFrame {
    
    private JButton btnCargar;
    private JTable tablaVehiculos;
    private DefaultTableModel modeloTabla;
    private JScrollPane panelDesplazable;
    
    public VentanaPrincipal() {
        inicializarVentana();
        crearComponentes();
        agregarListeners();
    }
    

    private void inicializarVentana() {
        setTitle("Gestor de Vehículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    

    private void crearComponentes() {
        // Panel superior con el botón
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        btnCargar = new JButton("Cargar Vehículos");
        btnCargar.setPreferredSize(new Dimension(150, 40));
        panelSuperior.add(btnCargar);
        
        add(panelSuperior, BorderLayout.NORTH);
        
        // Panel central con la tabla
        String[] columnas = {"Marca", "Modelo", "Año", "VIN", "Color", "Placa"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaVehiculos = new JTable(modeloTabla);
        
        // Configurar propiedades de la tabla
        tablaVehiculos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaVehiculos.getTableHeader().setReorderingAllowed(false);
        
        panelDesplazable = new JScrollPane(tablaVehiculos);
        add(panelDesplazable, BorderLayout.CENTER);
    }
    

    private void agregarListeners() {
        btnCargar.addActionListener(e -> cargarVehiculos());
    }
    

    private void cargarVehiculos() {
        try {
            // Ruta del archivo JSON
            String rutaFichero = "vehiculos.json";
            
            // Leer vehículos desde el servicio
            ArrayList<Vehiculo> vehiculos = VehiculoService.leerVehiculos(rutaFichero);
            
            // Limpiar tabla anterior
            modeloTabla.setRowCount(0);
            
            // Agregar solo los 10 primeros registros
            int limite = Math.min(10, vehiculos.size());
            for (int i = 0; i < limite; i++) {
                Vehiculo v = vehiculos.get(i);
                Object[] fila = {
                    v.getVehicleMake(),
                    v.getVehicleModel(),
                    v.getVehicleYear(),
                    v.getVehicleVin(),
                    v.getVehicleColor(),
                    v.getVehicleLicensePlate()
                };
                modeloTabla.addRow(fila);
            }
            
            JOptionPane.showMessageDialog(this, 
                "Se cargaron " + limite + " de " + vehiculos.size() + " vehículos",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Error al leer el archivo: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
