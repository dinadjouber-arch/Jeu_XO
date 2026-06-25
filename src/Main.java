import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String currentPlayer="X";
    public static void main(String[] args) {

        JFrame fenetre=new JFrame("Jeu de XO");
        JPanel panel=new JPanel();
        JLabel texte=new JLabel();
        JPanel grille=new JPanel();
        JButton [][] boutons=new JButton[3][3];
        String playerX="X";
        String playerO="O";



        //creation de la fenetre du jeu

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(600,650);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);





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


        //tracer la grille

        grille.setLayout(new GridLayout(3,3));
        grille.setBackground(Color.cyan);


        //ajouter la grille a la fenetre
        fenetre.add(grille);



        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                JButton tuile=new JButton();
                boutons[i][j]=tuile;
                grille.add(tuile);
                tuile.setBackground(Color.pink);

                tuile.setForeground(Color.white);
                tuile.setFont(new Font("Arial", Font.BOLD, 120));
                tuile.setFocusable(false);


                tuile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tuile= (JButton) e.getSource();
                        tuile.setText(currentPlayer);

                        currentPlayer= Objects.equals(currentPlayer, "X") ?playerO:playerX;
                        texte.setText("C'est le tour du joueur "+currentPlayer);
                    }
                });




            }


        fenetre.setVisible(true); //doit etre place a la fin

    }
}