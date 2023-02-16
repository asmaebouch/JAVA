package Vue.palette;

import Vue.Formulaire;
import Vue.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameDashbord extends JFrame{
    private JPanel contentPane;
    private Image img_logo=new ImageIcon("myFileBase/logo.jpg").getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
    private Image img_logo2=new ImageIcon("myFileBase/chercher.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img_logo3=new ImageIcon("myFileBase/Ajout.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img_logo4=new ImageIcon("myFileBase/modifier.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img_logo5=new ImageIcon("myFileBase/Supprimer.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img_logo6=new ImageIcon("myFileBase/singout.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
   private MyFrame formulaire;
   private Formulaire formulaire1;
     private hhhh fofof;
    public FrameDashbord()
{
    setBackground(new Color(105, 59, 105, 255));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,807,418);
    setLocationRelativeTo(null);
    setResizable(false);
    //setUndecorated(true);
    contentPane =new JPanel();
    contentPane.setBackground(new Color(105, 59, 105, 255));
    setContentPane(contentPane);
    contentPane.setLayout(null);

     formulaire =new MyFrame("My app");
     formulaire1=new Formulaire("formulaire");
    fofof=new hhhh();
    JPanel paneMenu=new JPanel();
    paneMenu.setBackground(new Color(105, 59, 105, 255));
    paneMenu.setBounds(0,0,249,418);
    contentPane.add(paneMenu);
    paneMenu.setLayout(null);

    JLabel lblIconlogo=new JLabel("");
    lblIconlogo.setBounds(10,11,229,139);
    lblIconlogo.setIcon(new ImageIcon(img_logo));
    paneMenu.add(lblIconlogo);

    JPanel paneHome = new JPanel();
    paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome){
        @Override
        public void mouseClicked(MouseEvent e) {
            menuClicked(formulaire);
        }
    });
    paneHome.setBackground(new Color(105, 59, 105, 255));
    paneHome.setBounds(0,140,249,40);
    paneMenu.add(paneHome);
    paneHome.setLayout(null);

    JLabel lblHome = new JLabel("SEARCH");
    lblHome.setForeground(new Color(255,255,255));
    lblHome.setFont(new Font("Dialog",Font.BOLD,14));
    lblHome.setBounds(76,11,163,18);
    paneHome.add(lblHome);

    JLabel lblIconHome=new JLabel("");
    lblIconHome.setHorizontalAlignment(SwingConstants.CENTER);
    lblIconHome.setBounds(20,0,40,40);
    lblIconHome.setIcon(new ImageIcon(img_logo2));
    paneHome.add(lblIconHome);

    JPanel paneajout = new JPanel();
    paneajout.addMouseListener(new PanelButtonMouseAdapter(paneajout){
        @Override
        public void mouseClicked(MouseEvent e) {
            menuClicked(formulaire1);
        }
    });

    paneajout.setBackground(new Color(105, 59, 105, 255));
    paneajout.setBounds(0,180,249,40);
    paneMenu.add(paneajout);
    paneajout.setLayout(null);

    JLabel lblHome2 = new JLabel(" ADD ");

    lblHome2.setForeground(new Color(255,255,255));
    lblHome2.setFont(new Font("Dialog",Font.BOLD,14));
    lblHome2.setBounds(76,11,163,18);
    paneajout.add(lblHome2);

    JLabel lblIconHome2=new JLabel("");
    lblIconHome2.setHorizontalAlignment(SwingConstants.CENTER);

    lblIconHome2.setBounds(21,0,40,40);
    lblIconHome2.setIcon(new ImageIcon(img_logo3));
    paneajout.add(lblIconHome2);

    JPanel panemodifier = new JPanel();
    panemodifier.addMouseListener(new PanelButtonMouseAdapter(panemodifier){
        @Override
        public void mouseClicked(MouseEvent e) {
            menuClicked(formulaire);
        }
    });


    panemodifier.setBackground(new Color(105, 59, 105, 255));
    panemodifier.setBounds(0,220,249,40);
    paneMenu.add(panemodifier);
    panemodifier.setLayout(null);

    JLabel lblHome3 = new JLabel("MODIFY");
    lblHome3.setForeground(new Color(255,255,255));
    lblHome3.setFont(new Font("Dialog",Font.BOLD,14));
    lblHome3.setBounds(76,11,163,18);
    panemodifier.add(lblHome3);

    JLabel lblIconHome3=new JLabel("");
    lblIconHome3.setHorizontalAlignment(SwingConstants.CENTER);
    lblIconHome3.setBounds(20,0,40,40);
    lblIconHome3.setIcon(new ImageIcon(img_logo4));
    panemodifier.add(lblIconHome3);

    JPanel panemodifier2 = new JPanel();
    panemodifier2.addMouseListener(new PanelButtonMouseAdapter(panemodifier2){
        @Override
        public void mouseClicked(MouseEvent e) {
            menuClicked(formulaire);
        }
    });
    panemodifier2.setBackground(new Color(105, 59, 105, 255));
    panemodifier2.setBounds(0,260,249,40);
    paneMenu.add(panemodifier2);
    panemodifier2.setLayout(null);

    JLabel lblHome4 = new JLabel("DELETE");
    lblHome4.setForeground(new Color(255,255,255));
    lblHome4.setFont(new Font("Dialog",Font.BOLD,14));
    lblHome4.setBounds(76,11,163,18);
    panemodifier2.add(lblHome4);

    JLabel lblIconHome4=new JLabel("");
    lblIconHome4.setHorizontalAlignment(SwingConstants.CENTER);
    lblIconHome4.setBounds(20,0,40,40);
    lblIconHome4.setIcon(new ImageIcon(img_logo5));
    panemodifier2.add(lblIconHome4);

    JPanel panemodifier5 = new JPanel();
    panemodifier5.addMouseListener(new PanelButtonMouseAdapter(panemodifier5){
        @Override
        public void mouseClicked(MouseEvent e) {
            menuClicked(formulaire);
        }
    });
    panemodifier5.setBackground(new Color(105, 59, 105, 255));
    panemodifier5.setBounds(0,300,249,40);
    paneMenu.add(panemodifier5);
    panemodifier5.setLayout(null);

    JLabel lblHome5 = new JLabel("Sing out");
    lblHome5.setForeground(new Color(255,255,255));
    lblHome5.setFont(new Font("Dialog",Font.BOLD,14));
    lblHome5.setBounds(76,11,163,18);
    panemodifier5.add(lblHome5);

    JLabel lblIconHome5=new JLabel("");
    lblIconHome5.setHorizontalAlignment(SwingConstants.CENTER);
    lblIconHome5.setBounds(20,0,40,40);
    lblIconHome5.setIcon(new ImageIcon(img_logo6));
    panemodifier5.add(lblIconHome5);

    JPanel paneMainContent = new JPanel();
    paneMainContent.addMouseListener(new PanelButtonMouseAdapter(paneMainContent));
    paneMainContent.setBounds(259,11,938,396);
    contentPane.add(paneMainContent);
    paneMainContent.setLayout(null);
    //paneMainContent.add(formulaire,BorderLayout.CENTER);
    //formulaire.getContentPane().add(paneMainContent);
    paneMainContent.add(formulaire.tablePanel);
     menuClicked(formulaire);

    this.setVisible(true);
}
    public void menuClicked(JFrame panel){
     formulaire.setVisible(false);
     formulaire1.setVisible(false);
     panel.setVisible(true);
    }
    private class PanelButtonMouseAdapter extends MouseAdapter{
        JPanel panel;
        JFrame frame;
        public PanelButtonMouseAdapter(JPanel panel){
            this.panel=panel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(243, 237, 245));
        }

        @Override
        public void mouseExited(MouseEvent e) {
       panel.setBackground(new Color(189, 159, 196));
        }

        @Override
        public void mousePressed(MouseEvent e) {
          panel.setBackground(new Color(193, 94, 225));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(243, 237, 245));
        }
    }

    public static void main(String[] args) {
        new FrameDashbord();

    }
}
