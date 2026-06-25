import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame fenetre=new JFrame("Jeu de XO");
        JPanel panel=new JPanel();
        JLabel texte=new JLabel();


        //creation de la fenetre du jeu

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(600,650);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);
        fenetre.setVisible(true);




        //label

        texte.setBackground(Color.pink);
        texte.setForeground(Color.white); //it's the font color
        texte.setFont(new Font("Times New Roman",Font.BOLD,50));
        texte.setHorizontalAlignment(JLabel.CENTER);
        texte.setText("Jeu de XO");
        texte.setOpaque(true);


        //organiser le panel

        panel.setLayout(new BorderLayout()); //divise le panel en zones center,north...




        //Ajoout du panel a la fenetre et du label au panel

        panel.add(texte);
        fenetre.add(panel, BorderLayout.NORTH);

    }
}