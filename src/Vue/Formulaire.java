package Vue;

import dao.Idao;
import dao.files.AccountDao;
import dao.files.AgenciesDao;
import dao.files.ClientDao2;
import dao.files.FileBasePaths;
import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.Sexe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.lang.System.exit;

public class Formulaire extends JFrame {
    Container mainContainer;
    private JPanel titlePanel, formPanel, buttonsPanel;
    private JLabel lbl_title, lbl_login, lbl_prenom, lbl_nom, lbl_confirmation, lbl_email, lbl_telephone, lblidAgence, lbl_pass, lbl_cin, lbl_sexe;
    //String[] sexe= new String[]{"F", "H"};
    private JComboBox comboBox = new JComboBox();

    private JButton btn_Effacer;
    private JButton btn_Cancel;
    private JButton btn_Ajouter;
    private JTextField txt_login, txt_prenom, txt_nom, txt_email, txt_telephone, txt_idagenece, txt_cin, twt_sexe;
    private JPasswordField txt_pass, txt_confirmation;

    public Formulaire(String formulaire) {
        initContainer();
        //titre
        setTitle(formulaire);
        //Dimentionner
        setSize(600, 600);
        //la mettre au melieu
        setLocationRelativeTo(null);
        //Fermer l'application en fermant la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fixier la taille de la fenetre
        setResizable(false);
        //rendre la fenetre visible
        setVisible(true);
    }

    private void initButton() {
        //initialisation le button login
        btn_Ajouter = new JButton("Ajouter");
        //personnalisation de label titre
        btn_Ajouter.setFont((new Font("optima", Font.BOLD, 17)));
        btn_Ajouter.setForeground(new Color(105, 59, 105, 255));
        btn_Ajouter.setHorizontalAlignment(JButton.CENTER);
        btn_Ajouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileBasePaths.createFileBase();
                    Idao<Client, Long> clientLongIdao = new ClientDao2();
                    Idao<Compte, Long> compteLongIdao = new AccountDao();
                    Idao<Banque, Long> banqueLongIdao = new AgenciesDao();
                    //idNomPrenomloginpasswordemailcin	tel	sex
                    Client clientSpecial = new Client();
                    String email = txt_email.getText().toString();
                    clientSpecial.setEmail(email);
                    String login = txt_login.getText().toString();
                    clientSpecial.setLogin(login);
                    String motdepasse = txt_pass.getText().toString();
                    clientSpecial.setMotDePasse(motdepasse);
                    String nom = txt_nom.getText().toString();
                    clientSpecial.setNom(nom);
                    String prenom = txt_prenom.getText().toString();
                    clientSpecial.setPrenom(prenom);
                    String tel = txt_telephone.getText().toString();
                    clientSpecial.setTel(tel);
                    String cin = txt_cin.getText().toString();
                    clientSpecial.setCin(cin);
                    Sexe sexe = Sexe.valueOf(comboBox.getSelectedItem().toString());
                    clientSpecial.setSexe(sexe);
                    //  String cin =txt
                    //  Client clientSpecial = new Client("asmae", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
                    // Client clientSpecial3 = new Client("asmaeeee", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
                    // Client clientSpecial4 = new Client("oussama", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
                    //Banque banque=new Banque("aaaa","aaaa","aaaa","aaaa");
                    //Client clientSpecial2 = new Client(2L,"Zouhair", "1234", "asmeeae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
                    //System.out.println(clientSpecial2.toString());
                    //  System.out.println(clientSpecial.toString());
                    if (clientSpecial == null) {
                        System.out.println("Error: client object is null, it can't be saved.");
                        return;
                    }
                    File clientTable = new File(String.valueOf(FileBasePaths.CLIENT_TABLE));
                    if (!clientTable.exists()) {
                        System.out.println("Error: client table file does not exist, it should be created first.");
                        return;
                    }
                    if (!clientTable.canWrite()) {
                        System.out.println("Error: client table file is not writable.");
                        return;
                    }
                    // banqueLongIdao.save(banque);
                    //System.out.println("banque save succeccefuly ");
                    //  clientLongIdao.delete(clientSpecial2);
                    // System.out.println("Suppression succes");
                    //Compte compte=new Compte(300.0,clientSpecial);
                    //  compteLongIdao.save(compte);
                    //compteLongIdao.findall().forEach(System.out::println);
                    // System.out.println("Compte ajouter avec succes");
                    // clientLongIdao.save(clientSpecial);
                    // clientLongIdao.save(clientSpecial3);
                    clientLongIdao.save(clientSpecial);
                    System.out.println("Ajout avec succes ^_______^");
                    //clientLongIdao.update(clientSpecial2);
                    //System.out.println("Client update successfully.");
                    //clientLongIdao.findall().forEach(System.out::println);;
                    //System.out.println(clientLongIdao.findById(2L).toString());
                    //System.out.println("find by id ");
                    //      System.out.println("Client saved successfully.");
                } catch (IOException e1) {
                    System.out.println("Error: An IOException occurred while saving the client object.");
                    e1.printStackTrace();
                }

            }

        });
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
        //initialisation le button login
        btn_Cancel = new JButton("Annuler");
        //personnalisation de label titre
        btn_Cancel.setFont((new Font("optima", Font.BOLD, 17)));
        btn_Cancel.setForeground(new Color(105, 59, 105, 255));
        btn_Cancel.setHorizontalAlignment(JButton.CENTER);
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
            }
        });
        btn_Effacer = new JButton("Effacer");
        //personnalisation de label titre
        btn_Effacer.setFont((new Font("optima", Font.BOLD, 17)));
        btn_Effacer.setForeground(new Color(105, 59, 105, 255));
        btn_Effacer.setHorizontalAlignment(JButton.CENTER);
        btn_Effacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_login.setText("");
                txt_email.setText("");
                txt_cin.setText("");
                txt_pass.setText("");
                txt_confirmation.setText("");
                txt_nom.setText("");
                txt_prenom.setText("");
                txt_telephone.setText("");
                txt_idagenece.setText("");
            }
        });
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
    }

    private void initContainer() {
        //referencer notre conteneur de base par la reference mainContainer
        this.mainContainer = this.getContentPane();
        //personalisation de notre contenuer
        //on peut changer la couleur de base mais on va faire des panneaux
        //on va changer layout manager de type borderlayout
        //affecter un borderlayout a notre containerpour le decouper sous forme de bords
        mainContainer.setLayout(new BorderLayout());
        //initialiser ajouter les panneaux au bordes correspondants
        initPanels();
        mainContainer.add(titlePanel, BorderLayout.NORTH);
        mainContainer.add(formPanel, BorderLayout.CENTER);
        mainContainer.add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void initLabel() {
        //initialisation du lebel Titre
        lbl_title = new JLabel("Formulaire");


        //personnalisation de label titre
        lbl_title.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_title.setForeground(new Color(105, 59, 105, 255));
        lbl_title.setHorizontalAlignment(JLabel.LEFT);

        System.out.println("\n");
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
        //initialisation du lebel Titre
        /////////////////////////////////////////////////////////////
        lbl_login = new JLabel("User name");

        lbl_login.add(Box.createVerticalStrut(10));
        //personnalisation de label titre
        lbl_login.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_login.setForeground(new Color(105, 59, 105, 255));
        lbl_login.setHorizontalAlignment(JLabel.LEFT);
        lbl_login.setForeground(Color.PINK);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
        //initialisation du lebel Titre
        lbl_pass = new JLabel("Password");
        //personnalisation de label titre
        lbl_pass.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_pass.setForeground(new Color(105, 59, 105, 255));
        lbl_pass.setHorizontalAlignment(JLabel.LEFT);
        lbl_pass.setForeground(Color.PINK);
        lbl_prenom = new JLabel("Last Name");

        //personnalisation de label titre
        lbl_prenom.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_prenom.setForeground(new Color(105, 59, 105, 255));
        lbl_prenom.setHorizontalAlignment(JLabel.LEFT);
        lbl_prenom.setForeground(Color.PINK);
        lbl_nom = new JLabel("Name");
        lbl_nom.setForeground(Color.PINK);
        //personnalisation de label titre
        lbl_nom.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_nom.setForeground(new Color(105, 59, 105, 255));
        lbl_nom.setHorizontalAlignment(JLabel.LEFT);
        lbl_nom.setForeground(Color.PINK);
        lbl_confirmation = new JLabel("Confirmation");

        //personnalisation de label titre
        lbl_confirmation.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_confirmation.setForeground(new Color(105, 59, 105, 255));
        lbl_confirmation.setHorizontalAlignment(JLabel.LEFT);
        lbl_confirmation.setForeground(Color.PINK);
        lbl_telephone = new JLabel("Mobile Phone");
        //personnalisation de label titre
        lbl_telephone.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_telephone.setForeground(new Color(105, 59, 105, 255));
        lbl_telephone.setHorizontalAlignment(JLabel.LEFT);
        lbl_telephone.setForeground(Color.PINK);
        lblidAgence = new JLabel("Id Agence");

        //personnalisation de label titre
        lblidAgence.setFont((new Font("optima", Font.BOLD, 20)));
        lblidAgence.setForeground(new Color(105, 59, 105, 255));
        lblidAgence.setHorizontalAlignment(JLabel.LEFT);
        lblidAgence.setForeground(Color.PINK);

        lbl_email = new JLabel("Email");

        //personnalisation de label titre
        lbl_email.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_email.setForeground(new Color(105, 59, 105, 255));
        lbl_email.setHorizontalAlignment(JLabel.LEFT);
        lbl_email.setForeground(Color.PINK);
        lbl_cin = new JLabel("Cin");

        //personnalisation de label titre
        lbl_cin.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_cin.setForeground(new Color(105, 59, 105, 255));
        lbl_cin.setHorizontalAlignment(JLabel.LEFT);
        lbl_cin.setForeground(Color.PINK);
        lbl_sexe = new JLabel("Sexe");

        //personnalisation de label titre
        lbl_sexe.setFont((new Font("optima", Font.BOLD, 20)));
        lbl_sexe.setForeground(new Color(105, 59, 105, 255));
        lbl_sexe.setHorizontalAlignment(JLabel.LEFT);
        lbl_sexe.setForeground(Color.PINK);
        //ajouter une icone
        // lbl_title.setIcon(new ImageIcon())
    }

    private void initTextFields() {

        /////////////////////////////////////////////////////////////
        txt_login = new JTextField("");
        //personnalisation de label titre
        txt_login.setFont((new Font("optima", Font.BOLD, 10)));
        txt_login.setForeground(new Color(105, 59, 105, 255));
        txt_login.setHorizontalAlignment(JTextField.CENTER);
        txt_pass = new JPasswordField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_pass.setFont((new Font("optima", Font.BOLD, 10)));
        txt_pass.setForeground(new Color(105, 59, 105, 255));
        txt_pass.setHorizontalAlignment(JPasswordField.CENTER);
        txt_confirmation = new JPasswordField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_confirmation.setFont((new Font("optima", Font.BOLD, 10)));
        txt_confirmation.setForeground(new Color(105, 59, 105, 255));
        txt_confirmation.setHorizontalAlignment(JPasswordField.CENTER);
        txt_nom = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_nom.setFont((new Font("optima", Font.BOLD, 10)));
        txt_nom.setForeground(new Color(105, 59, 105, 255));
        txt_nom.setHorizontalAlignment(JTextField.CENTER);
        txt_prenom = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_prenom.setFont((new Font("optima", Font.BOLD, 10)));
        txt_prenom.setForeground(new Color(105, 59, 105, 255));
        txt_prenom.setHorizontalAlignment(JTextField.CENTER);
        txt_email = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_email.setFont((new Font("optima", Font.BOLD, 10)));
        txt_email.setForeground(new Color(105, 59, 105, 255));
        txt_email.setHorizontalAlignment(JTextField.CENTER);
        txt_telephone = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_telephone.setFont((new Font("optima", Font.BOLD, 10)));
        txt_telephone.setForeground(new Color(105, 59, 105, 255));
        txt_telephone.setHorizontalAlignment(JTextField.CENTER);
        txt_idagenece = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_idagenece.setFont((new Font("optima", Font.BOLD, 10)));
        txt_idagenece.setForeground(new Color(105, 59, 105, 255));
        txt_idagenece.setHorizontalAlignment(JTextField.CENTER);
        ////////////

        ////////////
        txt_cin = new JTextField("");
        //////////////PASSWORD///////////////////////////////
        //personnalisation de label titre
        txt_cin.setFont((new Font("optima", Font.BOLD, 10)));
        txt_cin.setForeground(new Color(105, 59, 105, 255));
        txt_cin.setHorizontalAlignment(JTextField.CENTER);

    }

    private void initPanels() {
        //panneau titre
        initLabel();
        initTextFields();
        titlePanel = new JPanel();
        //changer la couleur du fond
        titlePanel.setBackground(new Color(194, 0, 254, 255));
        //ajouter un padding
        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 10));
        //affecter un FlowLayout a notre titlePanel pour ajouter les elements sous forme d'un flux
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajouter le titre au centre
        titlePanel.add(lbl_title);
        //////////////////////////////
        //panneau titre
        formPanel = new JPanel();
        //changer la couleur du fond
        formPanel.setBackground(new Color(255, 255, 255));
        //ajouter un padding

        formPanel.setLayout(new BorderLayout());
        //formPanel.setLayout(new BoxLayout(fromPanel,BoxLayout.Y_AXIS));=>verticalement les un apres les autres ama border layout 7esane
        //formPanel.setLayout(new GridLayout(2,1));=>rah bhal lifogha ghire l'elemnt ay7tha b la taille ama grid en meme taille so lifog 7essane
        /////////////////////:
        formPanel.setBorder(new EmptyBorder(40, 80, 20, 20));
        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(255, 255, 255));
        westPanel.setLayout(new GridLayout(11, 1, 5, 5));
        westPanel.setBorder(new EmptyBorder(-2, 1, 1, 20));
        westPanel.add(lbl_login);
        westPanel.add(lbl_pass);
        westPanel.add(lbl_confirmation);

        westPanel.add(lbl_email);
        westPanel.add(lbl_nom);
        westPanel.add(lbl_prenom);
        westPanel.add(lbl_telephone);
        westPanel.add(lblidAgence);
        westPanel.add(lbl_cin);
        westPanel.add(lbl_sexe);
        ///////////////////////:
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setLayout(new GridLayout(11, 4, 10, 8));
        // centerPanel.setSize(new Dimension(100,50));
        centerPanel.add(txt_login);
        centerPanel.add(txt_pass);
        centerPanel.add(txt_confirmation);
        centerPanel.add(txt_nom);

        centerPanel.add(txt_prenom);
        centerPanel.add(txt_email);
        centerPanel.add(txt_telephone);
        centerPanel.add(txt_idagenece);
        centerPanel.add(txt_cin);
        centerPanel.add(comboBox);
        for (Sexe s : Sexe.values()) {
            comboBox.addItem(s.toString());
        }


     /*   centerPanel.add(txt_idagenece);
       ;*/
            formPanel.add(westPanel, BorderLayout.WEST);
            formPanel.add(centerPanel, BorderLayout.CENTER);
            initButton();
            buttonsPanel = new JPanel();
            //changer la couleur du fond
            buttonsPanel.setBackground(new Color(194, 0, 254, 255));
            //ajouter un padding =>yk7aze mn jnabe
            buttonsPanel.setBorder(new EmptyBorder(10, 0, 10, 10));
            //affecter un FlowLayout a notre titlePanel pour ajouter les elements sous forme d'un flux
            buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            //ajouter le titre au centre
            buttonsPanel.add(btn_Effacer);
            buttonsPanel.add(btn_Cancel);
            buttonsPanel.add(btn_Ajouter);
        }



}
