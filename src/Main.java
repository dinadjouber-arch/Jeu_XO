import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String currentPlayer="X";
    static boolean finJeu=false;
    static JButton [][] boutons=new JButton[3][3];
    static boolean winner=false;//cette variable sert a savoir s il y a un gagnant(winner=true) ou un match nul (winner=false)

    public static JLabel texte=new JLabel();

    static void finJeu()
    {
        //horizontalement
        for(int i=0;i<3;i++)
        {
            finJeu=true;
            for (int j = 0; j < 2; j++) {
                //on verifie si il y a une ligne qui est pleine et on sait aussi que si une case est vide la ligne n est pas pleine
                if (!Objects.equals(boutons[i][j].getText(), boutons[i][j + 1].getText())  ||  Objects.equals(boutons[i][j].getText(), "")  ||  Objects.equals(boutons[i][j + 1].getText(), ""))
                {
                    finJeu = false;
                    break;
                }
            }
            if(finJeu)
            {
                winner=true;
                return;
            }
        }



        //verticalement
        for(int i=0;i<3;i++)
        {
            finJeu=true;
            for (int j = 0; j < 2; j++) {
                if (!Objects.equals(boutons[j][i].getText(), boutons[j+1][i].getText()) ||  Objects.equals(boutons[j][i].getText(), "")  ||  Objects.equals(boutons[j+1][i].getText(), "")) {
                    finJeu = false;
                    break;
                }
            }
            if(finJeu)
            {
                winner=true;
                return;
            }
        }



        //diagonale principale
        finJeu=true;
        for(int i=0;i<2;i++)
        {
            if(!Objects.equals(boutons[i][i].getText(), boutons[i + 1][i + 1].getText())  ||  Objects.equals(boutons[i][i].getText(), "")  ||  Objects.equals(boutons[i+1][i + 1].getText(), ""))
            {
                finJeu=false;
                break;
            }
        }

        if(finJeu)
        {
            winner=true;
            return;
        }

        finJeu=true;
        for(int i=0;i<2;i++)
        {
            if(!Objects.equals(boutons[i][2 - i].getText(), boutons[i + 1][2 - (i + 1)].getText())  ||  Objects.equals(boutons[i][2-i].getText(), "")  ||  Objects.equals(boutons[i+1][2-(i+ 1)].getText(), ""))
            {
                finJeu=false;
                break;
            }
        }

        if(finJeu)
        {
            winner=true;
            return;
        }

        //anti-diagonale
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(Objects.equals(boutons[i][j].getText(), ""))
                {
                    return; // il reste une case vide donc le jeu continue
                }
            }
        }

        finJeu=true;
        winner=false;  //si on arrive ici c est match nul

    }

    public static void ecranFin()
    {
        //s il y a un gagnant
        if(winner)
        {
            texte.setText(currentPlayer+" a gagné");
        }
        else
        {
            texte.setText("match nul");
        }
    }

    public static void main(String[] args) {



        JFrame fenetre=new JFrame("Jeu de XO");
        JPanel panel=new JPanel();

        JPanel grille=new JPanel();
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

                tuile.setForeground(Color.cyan);
                tuile.setFont(new Font("Arial", Font.BOLD, 120));
                tuile.setFocusable(false);


                tuile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JButton tuile= (JButton) e.getSource();
                        if(!finJeu)
                        {
                        if(Objects.equals(tuile.getText(), "")) {
                            tuile.setText(currentPlayer);
                            finJeu();

                            if (finJeu) {
                                ecranFin();
                            } else {
                                currentPlayer = Objects.equals(currentPlayer, "X") ? playerO : playerX;
                                texte.setText("Au tour de " + currentPlayer);
                            }
                        }
                        }
                    }
                });





            }



        fenetre.setVisible(true); //doit etre place a la fin

    }







}