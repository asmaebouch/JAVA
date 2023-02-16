package Vue.palette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JLabel lbl_logo;
    private JButton btn_toggleMenu;


    public JButton getToggleMenu() {
        return btn_toggleMenu;
    }

    private void initLabel(Icon icon, String text, Color color, Font font){

        lbl_logo = new JLabel(text);
        lbl_logo.setIcon(icon);
        lbl_logo.setForeground(color);
        lbl_logo.setFont(font);
        lbl_logo.setHorizontalTextPosition(JLabel.CENTER);
        lbl_logo.setVerticalTextPosition(JLabel.BOTTOM);

    }

    private void initButton(Icon icon, String text, Color color, Font font){

        btn_toggleMenu = new JButton(text);
        btn_toggleMenu.setIcon(icon);
        btn_toggleMenu.setForeground(color);;
     //   btn_toggleMenu.setFont((new Font("optima", Font.BOLD, 17)));
        btn_toggleMenu.setPreferredSize(new Dimension(140, 30));

        btn_toggleMenu.setFont(font);
        btn_toggleMenu.setHorizontalTextPosition(JLabel.CENTER);
        btn_toggleMenu.setVerticalTextPosition(JLabel.BOTTOM);
        btn_toggleMenu.setBorderPainted(false);
        btn_toggleMenu.setFocusable(false);

        //btn_toggleMenu.setSize(5, 50);

    }



    public  HeaderPanel(Color bgColor,
                        Icon iconlbl, String textlbl, Color colorlbl, Font fontlbl,
                        Icon iconbtn, String textbtn, Color colorbtn, Font fontbtn){

        initLabel( iconlbl,  textlbl,  colorlbl,  fontlbl);
        initButton( iconbtn,  textbtn,  colorbtn,  fontbtn);
        setLayout(new BorderLayout());
        setBackground(new Color(194, 0, 254, 255));
        setBorder(new EmptyBorder(10,20,10,20));

        add(btn_toggleMenu, BorderLayout.WEST);
        add(lbl_logo, BorderLayout.EAST);
        setVisible(true);

        //la mettre au melieu

    }

    public static void main(String[] args) {
        JLabel lbl_title;
        lbl_title = new JLabel("WELCOM TO OUR BANK");
        JPanel titlePanel;
        //personnalisation de label titre
        lbl_title.setFont((new Font("optima", Font.BOLD, 20)));
       // lbl_title.setForeground(new Color(105, 59, 105, 255));
        //lbl_title.setHorizontalAlignment(JLabel.LEFT);
        titlePanel = new JPanel();
        //changer la couleur du fond
       titlePanel.setBackground(new Color(194, 0, 254, 255));
        //ajouter un padding
       // titlePanel.setBorder(new EmptyBorder(10, 0, 10, 10));
        //affecter un FlowLayout a notre titlePanel pour ajouter les elements sous forme d'un flux
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajouter le titre au centre
        titlePanel.add(lbl_title);
        // Define the logo icon, text, color, and font
        Icon logoIcon = new ImageIcon("myFileBase/logo.jpg");
        String logoText = "My App";
        Color logoColor = new Color(194, 0, 254, 255);

        Font logoFont = new Font("Arial", Font.BOLD, 20);

// Define the toggle menu button icon, text, color, and font
        Icon buttonIcon = new ImageIcon("myFileBase/menu-icon.png");
        String buttonText = "Toggle Menu";
        Color buttonColor = Color.yellow;
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

// Create an instance of HeaderPanel with the specified parameters
        HeaderPanel headerPanel = new HeaderPanel(
                new Color(194, 0, 254, 255),  // Background color
                logoIcon, logoText, logoColor, logoFont,  // Logo label parameters
                buttonIcon, buttonText, buttonColor, buttonFont  // Toggle menu button parameters
        );
headerPanel.add(titlePanel);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //   frame.add(titlePanel);
        frame.add(headerPanel);
        frame.pack();
        frame.setVisible(true);
       frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        //Fermer l'application en fermant la fenetre
       frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fixier la taille de la fenetre
       //frame. setResizable(false);

    }

}
