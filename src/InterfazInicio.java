import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazInicio extends Herramientas {

    public InterfazInicio() {
        // CREACION DE LA VENTANA
        JFrame ventanaInicio = crearVentana();

        // CREACION PANEL DE INICIO
        JPanel panelInicial = crearPanel();
        panelInicial.setBackground(Color.PINK);
        ventanaInicio.add(panelInicial);

        // CREACION ETIQUETA CON IMAGEN

        //LOGO
        JLabel logo = crearEtiqueta();
        logo.setIcon(new ImageIcon("Logo.png"));
        logo.setBounds(70, 20, 400, 250);
        panelInicial.add(logo);

        //SOBRE
        JLabel sobre = crearEtiqueta();
        sobre.setIcon(new ImageIcon("sobre_inicio"));
        sobre.setBounds(70, 20, 400, 250);
        panelInicial.add(sobre);

        //CANDADO
        JLabel candado = crearEtiqueta();
        candado.setIcon(new ImageIcon("candado_inicio"));
        candado.setBounds(70, 20, 400, 250);
        panelInicial.add(candado);


        // CREACION AREAS DE TEXTO PARA NOMBRE Y CONTRASEÑA

        //NOMBRE
        JLabel nombreEtiqueta = crearEtiqueta();
        nombreEtiqueta.setText("NOMBRE: ");
        nombreEtiqueta.setBounds(40, 290, 100, 25);
        panelInicial.add(nombreEtiqueta);

        JTextArea nombre = crearAreaTexto();
        nombre.setBounds(40, 320, 280, 25);
        panelInicial.add(nombre);

        // CONTRASEÑA
        JLabel contraseniaEtiqueta = crearEtiqueta();
        contraseniaEtiqueta.setText("CONTRASEÑA: ");
        contraseniaEtiqueta.setBounds(40, 350, 100, 25);
        panelInicial.add(contraseniaEtiqueta);

        // Área de texto para la contraseña más pequeña
        JPasswordField contrasenia = new JPasswordField();
        contrasenia.setBounds(40, 380, 180, 25);  // Ancho reducido para ajustarse mejor
        panelInicial.add(contrasenia);

        // Botón cuadrado para mostrar/ocultar contraseña
        JButton verContraseniaButton = new JButton();
        verContraseniaButton.setBounds(230, 380, 25, 25);  // Botón cuadrado y alineado

        ImageIcon iconoOjo = new ImageIcon("ojo_vista.png");  // Ruta de tu imagen de ojo
        Image imagenOjo = iconoOjo.getImage();
        Image imagenOjoEscalada = imagenOjo.getScaledInstance(25, 25, Image.SCALE_SMOOTH);  // Escalar la imagen al tamaño del botón
        verContraseniaButton.setIcon(new ImageIcon(imagenOjoEscalada));

        panelInicial.add(verContraseniaButton);

        // Acción para mostrar/ocultar contraseña
        verContraseniaButton.addActionListener(new ActionListener() {
            private boolean mostrando = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrando) {
                    contrasenia.setEchoChar('●');  // Volver a ocultar la contraseña
                } else {
                    contrasenia.setEchoChar((char) 0);  // Mostrar la contraseña
                }
                mostrando = !mostrando;
            }
        });

        // CREACION BOTONES DE INICIO DE SESION Y REGISTRO
        JButton iniciarSesion = crearBotones();
        iniciarSesion.setBounds(40,450, 120, 50);
        iniciarSesion.setText("Iniciar Sesion");
        panelInicial.add(iniciarSesion);

        JButton registrarse = crearBotones();
        registrarse.setBounds(180,450, 120, 50);
        registrarse.setText("Registrarme");
        panelInicial.add(registrarse);

        //ACEPTACION DE TERMINOS Y CONDICIONES
        JRadioButton terminosCheck = new JRadioButton("He leído y acepto los términos y condiciones");
        terminosCheck.setBounds(40, 520, 300, 30); // Ajusta las coordenadas según el diseño de tu interfaz
        terminosCheck.setBackground(Color.PINK);  // Si deseas que el fondo sea rosa, para que coincida con el tema de la interfaz
        panelInicial.add(terminosCheck);


        // CREACION DEL ACTION LISTENER DEL BOTON REGISTRO
        registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInicio.dispose();

                InterfazRegistro operativa = new InterfazRegistro();

            }
        });

        // CREACION DEL ACTION LISTENER DEL BOTON INICIAR SESION
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar si los términos y condiciones han sido aceptados
                if (!terminosCheck.isSelected()) {
                    // Mostrar un mensaje de advertencia si no se han aceptado
                    JOptionPane.showMessageDialog(ventanaInicio, "Acepte los términos y condiciones", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Si se aceptaron los términos, proceder con el inicio de sesión
                    ventanaInicio.dispose();
                    InterfazPrincipal principal = new InterfazPrincipal();
                }
            }
        });


        // DAR VISIBILIDAD A LA VENTANA
        ventanaInicio.setVisible(true);
    }

}

