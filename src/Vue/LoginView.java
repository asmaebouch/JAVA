package Vue;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.LinkedBlockingDeque;

public class LoginView extends JFrame {
    Container mainContainer;
    private JPanel titlePanel,formPanel,buttonsPanel;
    private JLabel lbl_title , lbl_login,lbl_pass;
    private JButton btn_Login;
    private JButton btn_Cancel;
    private JTextField txt_login;
    private JPasswordField txt_pass;
    private void initButton(){
        //initialisation le button login
        btn_Login=new JButton("se connecter");
        //personnalisation de label titre
        btn_Login.setFont((new Font("optima",Font.BOLD,17)));
        btn_Login.setForeground(new Color(105,59,105,255));
        btn_Login.setHorizontalAlignment(JButton.CENTER);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
        //initialisation le button login
        btn_Cancel=new JButton("Annuler");
        //personnalisation de label titre
        btn_Cancel.setFont((new Font("optima",Font.BOLD,17)));
        btn_Cancel.setForeground(new Color(105,59,105,255));
        btn_Cancel.setHorizontalAlignment(JButton.CENTER);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
    }
    private void initLabel(){
        //initialisation du lebel Titre
        lbl_title=new JLabel("Connexion");
        //personnalisation de label titre
        lbl_title.setFont((new Font("optima",Font.BOLD,20)));
        lbl_title.setForeground(new Color(105,59,105,255));
        lbl_title.setHorizontalAlignment(JLabel.LEFT);
        //ajouter une icone
       // lbl_title.setIcon(new ImageIcon())
        //initialisation du lebel Titre
        /////////////////////////////////////////////////////////////
        lbl_login=new JLabel("User name");
        //personnalisation de label titre
        lbl_login.setFont((new Font("optima",Font.BOLD,17)));
        lbl_login.setForeground(new Color(105,59,105,255));
        lbl_login.setHorizontalAlignment(JLabel.CENTER);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
        //initialisation du lebel Titre
        lbl_pass=new JLabel("Password");
        //personnalisation de label titre
        lbl_pass.setFont((new Font("optima",Font.BOLD,18)));
        lbl_pass.setForeground(new Color(105,59,105,255));
        lbl_pass.setHorizontalAlignment(JLabel.LEFT);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
    }
    private void initTextFields(){

        /////////////////////////////////////////////////////////////
        txt_login =new JTextField("");
        //personnalisation de label titre
        txt_login.setFont((new Font("optima",Font.BOLD,17)));
        txt_login.setForeground(new Color(105,59,105,255));
        txt_login.setHorizontalAlignment(JTextField.CENTER);
        txt_pass =new JPasswordField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_pass.setFont((new Font("optima",Font.BOLD,17)));
        txt_pass.setForeground(new Color(105,59,105,255));
        txt_pass.setHorizontalAlignment(JPasswordField.CENTER);


    }
    private void initPanels(){
        //panneau titre
        initLabel();
        initTextFields();
        titlePanel=new JPanel();
        //changer la couleur du fond
    titlePanel.setBackground(new Color(194, 0, 254, 255));
    //ajouter un padding
        titlePanel.setBorder(new EmptyBorder(10,0,10,10));
        //affecter un FlowLayout a notre titlePanel pour ajouter les elements sous forme d'un flux
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajouter le titre au centre
        titlePanel.add(lbl_title);
                //////////////////////////////
        //panneau titre
        formPanel=new JPanel();
        //changer la couleur du fond
        formPanel.setBackground(new Color(255,255,255));
        //ajouter un padding

        formPanel.setLayout(new BorderLayout());
        //formPanel.setLayout(new BoxLayout(fromPanel,BoxLayout.Y_AXIS));=>verticalement les un apres les autres ama border layout 7esane
        //formPanel.setLayout(new GridLayout(2,1));=>rah bhal lifogha ghire l'elemnt ay7tha b la taille ama grid en meme taille so lifog 7essane
        /////////////////////:
        formPanel.setBorder(new EmptyBorder(100,40,100,40));
        JPanel westPanel =new JPanel();
        westPanel.setBackground(new Color(255,255,255));
        westPanel.setLayout(new GridLayout(2,1,5,5));
        westPanel.setBorder(new EmptyBorder(0,0,0,20));
        westPanel.add(lbl_login);
        westPanel.add(lbl_pass);
        ///////////////////////:
        JPanel centerPanel =new JPanel();
        centerPanel.setBackground(new Color(255,255,255));
        centerPanel.setLayout(new GridLayout(2,1,5,5));
        centerPanel.add(txt_login);
        centerPanel.add(txt_pass);
        formPanel.add(westPanel,BorderLayout.WEST);
        formPanel.add(centerPanel,BorderLayout.CENTER);

        initButton();
        buttonsPanel=new JPanel();
        //changer la couleur du fond
        buttonsPanel.setBackground(new Color(194, 0, 254, 255));
        //ajouter un padding =>yk7aze mn jnabe
        buttonsPanel.setBorder(new EmptyBorder(10,0,10,10));
        //affecter un FlowLayout a notre titlePanel pour ajouter les elements sous forme d'un flux
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //ajouter le titre au centre
        buttonsPanel.add(btn_Login);
        buttonsPanel.add(btn_Cancel);


    }




private void initContainer(){
    //referencer notre conteneur de base par la reference mainContainer
    this.mainContainer=this.getContentPane();
    //personalisation de notre contenuer
    //on peut changer la couleur de base mais on va faire des panneaux
    //on va changer layout manager de type borderlayout
    //affecter un borderlayout a notre containerpour le decouper sous forme de bords
    mainContainer.setLayout(new BorderLayout());
    //initialiser ajouter les panneaux au bordes correspondants
    initPanels();
    mainContainer.add(titlePanel, BorderLayout.NORTH);
    mainContainer.add(formPanel,BorderLayout.CENTER);
    mainContainer.add(buttonsPanel,BorderLayout.SOUTH);
}
   public LoginView(String title){
    //initialisation du conteneur principale
       initContainer();
        //titre
        setTitle(title);
        //Dimentionner
        setSize(400,400);
        //la mettre au melieu
        setLocationRelativeTo(null);
        //Fermer l'application en fermant la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fixier la taille de la fenetre
        setResizable(false);
        //rendre la fenetre visible
        setVisible(true);
    }


    public static void main(String[] args) {
        new LoginView("Connexion");
    }

}
