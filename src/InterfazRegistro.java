import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRegistro extends Herramientas {
    public InterfazRegistro() {
        // CREACION DE LA VENTANA
        JFrame ventanaRegistro = crearVentana();

        // CREACION PANEL DE REGISTRO
        JPanel panelRegistro = crearPanel();
        panelRegistro.setBackground(Color.pink);
        ventanaRegistro.add(panelRegistro);

        // CREAR Y AGREGAR UNA IMAGEN EN EL ENCABEZADO
        JLabel imagenEncabezado = crearEtiqueta(); // Reemplaza con la ruta de tu imagen
        imagenEncabezado.setIcon(new ImageIcon("Logo.png"));
        imagenEncabezado.setBounds(70, 0, 400, 250);
        panelRegistro.add(imagenEncabezado);


        // Frase de bienvenida
        JLabel bienvenidaEtiqueta = new JLabel("<html><div style='text-align: center;'>¡Bienvenido a nuestra<br>comunidad!</div></html>");
        bienvenidaEtiqueta.setBounds(40, 250, 280, 60); // Ajusta la posición para dejar espacio
        bienvenidaEtiqueta.setFont(new Font("Arial", Font.BOLD, 18));
        bienvenidaEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenidaEtiqueta.setForeground(Color.BLACK);
        panelRegistro.add(bienvenidaEtiqueta);

        // ANIMACION FADE IN
        Timer timer = new Timer(50, new ActionListener() {
            private float opacity = 0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (opacity < 1f) {
                    opacity += 0.05f; // Incrementar opacidad
                    bienvenidaEtiqueta.setForeground(new Color(0, 0, 0, (int)(opacity * 255))); // Cambiar color del texto
                } else {
                    ((Timer)e.getSource()).stop(); // Detener el temporizador
                }
            }
        });
        timer.start();

        // CREACION DE TODAS LAS AREAS Y ETIQUETAS DE TEXTO PARA LOS DATOS

        // NOMBRE
        JLabel nombreEtiqueta = crearEtiqueta();
        nombreEtiqueta.setText("NOMBRE: ");
        nombreEtiqueta.setBounds(40, 330, 100, 25);
        panelRegistro.add(nombreEtiqueta);

        JTextArea nombre = crearAreaTexto();
        nombre.setBounds(40, 350, 280, 25);
        panelRegistro.add(nombre);

        // CONTRASEÑA
        JLabel contraseniaEtiqueta = crearEtiqueta();
        contraseniaEtiqueta.setText("CONTRASEÑA: ");
        contraseniaEtiqueta.setBounds(40, 380, 100, 25);
        panelRegistro.add(contraseniaEtiqueta);

        JTextArea contrasenia = crearAreaTexto();
        contrasenia.setBounds(40, 400, 280, 25);
        panelRegistro.add(contrasenia);

        // CORREO
        JLabel correoEtiqueta = crearEtiqueta();
        correoEtiqueta.setText("CORREO: ");
        correoEtiqueta.setBounds(40, 430, 100, 25);
        panelRegistro.add(correoEtiqueta);

        JTextArea correo = crearAreaTexto();
        correo.setBounds(40, 450, 280, 25);
        panelRegistro.add(correo);

        // TELEFONO
        JLabel telefonoEtiqueta = crearEtiqueta();
        telefonoEtiqueta.setText("TELEFONO: ");
        telefonoEtiqueta.setBounds(40, 480, 100, 25);
        panelRegistro.add(telefonoEtiqueta);

        JTextArea telefono = crearAreaTexto();
        telefono.setBounds(40, 500, 280, 25);
        panelRegistro.add(telefono);

        // CREACION BOTONES DE INICIO DE SESION Y REGISTRO
        JButton iniciarSesion = crearBotones();
        iniciarSesion.setBounds(40, 550, 120, 30);
        iniciarSesion.setText("Aceptar");
        panelRegistro.add(iniciarSesion);

        JButton registrarse = crearBotones();
        registrarse.setBounds(180, 550, 120, 30);
        registrarse.setText("Rechazar");
        panelRegistro.add(registrarse);

        // CREACION DEL ACTION LISTENER DEL BOTON REGISTRO(ACEPTAR)
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro.dispose();

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente. ");

                new InterfazPrincipal();

            }
        });

        // CREACION DEL ACTION LISTENER DEL BOTON REGISTRO(RECHAZAR)
        registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro.dispose();

                new InterfazInicio();

            }
        });






        // DAR VISIBILIDAD A LA VENTANA
        ventanaRegistro.setVisible(true);
    }
}
