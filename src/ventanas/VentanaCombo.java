package ventanas;

import principal.Coordinador;
import vo.PersonaVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaCombo extends JFrame implements ActionListener {
        private JTextField txtNombre, txtDocumento, txtDireccion, txtTelefono;
        private JButton btnRegistrar;
        private JComboBox comboPersonas;
        private JTable tablaPersonas;
        private DefaultTableModel modeloTabla;

        public VentanaCombo() {
            setTitle("Registro de Persona");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 500);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel lblTitulo = new JLabel("GESTIONAR PERSONAS");
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
            lblTitulo.setBounds(190, 10, 250, 30);
            add(lblTitulo);

            addLabel("Nombre", 30, 60);
            txtNombre = addTextField(100, 60);

            addLabel("Documento", 310, 60);
            txtDocumento = addTextField(400, 60);

            addLabel("Direccion", 30, 100);
            txtDireccion = addTextField(100, 100);

            addLabel("Telefono", 310, 100);
            txtTelefono = addTextField(400, 100);


            btnRegistrar = new JButton("Registrar");
            btnRegistrar.setBounds(400, 140, 120, 30);
            add(btnRegistrar);


            JSeparator separador = new JSeparator();
            separador.setBounds(20, 190, 550, 10);
            add(separador);


            JLabel lblCombo = new JLabel("Combo Personas");
            lblCombo.setBounds(30, 210, 120, 20);
            add(lblCombo);

            comboPersonas = new JComboBox();
            comboPersonas.setModel(new DefaultComboBoxModel(new String[]{"Seleccione"}));
            comboPersonas.setSelectedIndex(0);
            comboPersonas.setBounds(150, 210, 180, 25);
            comboPersonas.addActionListener(this);
            add(comboPersonas);


            JLabel lblLista = new JLabel("Lista Personas");
            lblLista.setBounds(30, 250, 120, 20);
            add(lblLista);

            String[] columnas = {"Documento", "Nombre", "Direccion", "Telefono"};
            modeloTabla = new DefaultTableModel(columnas, 0);
            tablaPersonas = new JTable(modeloTabla);
            JScrollPane scroll = new JScrollPane(tablaPersonas);
            scroll.setBounds(30, 280, 520, 150);
            add(scroll);
        }

        private void addLabel(String texto, int x, int y) {
            JLabel label = new JLabel(texto);
            label.setBounds(x, y, 80, 20);
            add(label);
        }

        private JTextField addTextField(int x, int y) {
            JTextField textField = new JTextField();
            textField.setBounds(x, y, 150, 25);
            add(textField);
            return textField;
        }


// jcombo box
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar){
            registrarPersona();
            cargarRegistros();
        }
        public void cargarRegistros(){
            ArrayList<PersonaVo>listaPersonas= Coordinador.consultarListaPersonas();
            llenarCombo(listaPersonas);
            llenarTabla(listaPersonas);

        }

        public void llenarCombo(ArrayList<PersonaVo>listaPersonas){

        }

    }
}


