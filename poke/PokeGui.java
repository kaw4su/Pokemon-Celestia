package poke;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import java.util.*;



public class PokeGui extends JComponent implements Runnable {
    //final static Dimension screenSize = Toolkit.getDefaultToolKit().getScreenSize();
    final static int width = 1366;
    final static int height = 768;
    final static int fontSize = 26;
    private static ArrayList<Monsters> tempTeam = new ArrayList<Monsters>();
    private static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
    private static ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();

    Pokemon enemy1 = new Pokemon(Monsters.HAWLUCHA);
    Pokemon enemy2 = new Pokemon(Monsters.TYRANTRUM);
    Pokemon enemy3 = new Pokemon(Monsters.AURORUS);
    Pokemon enemy4 = new Pokemon(Monsters.GOURGEIST);
    Pokemon enemy5 = new Pokemon(Monsters.GOODRA);
    Pokemon enemy6 = new Pokemon(Monsters.GARDEVOIR);    

    public void run(){
        startMainMenu();
    }

    public PokeGui(){
    }

    
    public void startMainMenu(){
        JFrame menuFrame = new JFrame("Pokemon");
        menuFrame.setBounds(1266, 868, width, height);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().setLayout(null);

        JButton startBtn = new JButton("Start Game");
        startBtn.setBounds(500,500, width/4, height/15);
        startBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize+5));

        JButton endBtn = new JButton("Quit Game");
        endBtn.setBounds(500, 600, width/4, height/15);
        endBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize+5));

        //TODO
        ImageIcon pokemonSymbol = new ImageIcon(getClass().getResource("/poke/images/Pokemon.png"));
        JLabel welcomelbl = new JLabel(pokemonSymbol);
        welcomelbl.setBounds(50, 0, 1200, 442);

        menuFrame.getContentPane().add(startBtn);
        menuFrame.getContentPane().add(endBtn);
        menuFrame.getContentPane().add(welcomelbl); 

        menuFrame.setVisible(true);

        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent click){
                menuFrame.dispose();
                initPokeSelect();
            }
        });

        endBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent click){
                System.exit(0);
            }
        });
    }

    public void initPokeSelect(){
        JFrame dexFrame = new JFrame("Pokemon");
        dexFrame.setBounds(1266, 868, width, height);
        dexFrame.setLocationRelativeTo(null);
        dexFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dexFrame.getContentPane().setLayout(null);

        JButton backButton = new JButton("Main Menu");
        backButton.setBounds(900, 43, 250, 70);
        backButton.setFont(new Font("inhalt", Font.PLAIN, fontSize+2));
        dexFrame.getContentPane().add(backButton);
        backButton.setVisible(true);

        JButton startFight = new JButton("Start Battle");
        startFight.setBounds(900, 115, 250, 70);
        startFight.setFont(new Font("inhalt", Font.PLAIN, fontSize+2));
        dexFrame.getContentPane().add(startFight);
        startFight.setVisible(true);

        JButton removePoke = new JButton("Remove Pokemon");
        removePoke.setBounds(900, 187, 250, 70);
        removePoke.setFont(new Font("inhalt", Font.PLAIN, fontSize-3));
        dexFrame.getContentPane().add(removePoke);
        removePoke.setVisible(true);

        JTextArea info = new JTextArea("");
        info.setBounds(63, 43, 600, 230);
        info.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        dexFrame.getContentPane().add(info);

        JRadioButton rDelphox = new JRadioButton(Monsters.DELPHOX.getName());
        rDelphox.setBounds(50, 300,180,50);
        rDelphox.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rGardevoir = new JRadioButton(Monsters.GARDEVOIR.getName());
        rGardevoir.setBounds(230,300 ,180,50);
        rGardevoir.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rLucario = new JRadioButton(Monsters.LUCARIO.getName());
        rLucario.setBounds(410, 300,180,50);
        rLucario.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rZapdos = new JRadioButton(Monsters.ZAPDOS.getName());
        rZapdos.setBounds(590, 300,180,50);
        rZapdos.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rBlastoise = new JRadioButton(Monsters.BLASTOISE.getName());
        rBlastoise.setBounds(770, 300, 180, 50);
        rBlastoise.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rAbsol = new JRadioButton(Monsters.ABSOL.getName());
        rAbsol.setBounds(950, 300, 180, 50);
        rAbsol.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rBlaziken = new JRadioButton(Monsters.BLAZIKEN.getName());
        rBlaziken.setBounds(50, 375, 180, 50);
        rBlaziken.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rSerperior = new JRadioButton(Monsters.SERPERIOR.getName());
        rSerperior.setBounds(230, 375, 180, 50);
        rSerperior.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rMagnezone = new JRadioButton(Monsters.MAGNEZONE.getName());
        rMagnezone.setBounds(410, 375, 180, 50);
        rMagnezone.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rGreninja = new JRadioButton(Monsters.GRENINJA.getName());
        rGreninja.setBounds(590, 375, 180, 50);
        rGreninja.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rXerneas = new JRadioButton(Monsters.XERNEAS.getName());
        rXerneas.setBounds(770, 375, 180, 50);
        rXerneas.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rPrimarina = new JRadioButton(Monsters.PRIMARINA.getName());
        rPrimarina.setBounds(950, 375, 180, 50);
        rPrimarina.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rNinetales = new JRadioButton(Monsters.ALOLANNINETALES.getName());
        rNinetales.setBounds(50, 450, 180, 50);
        rNinetales.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rCharizard = new JRadioButton(Monsters.CHARIZARD.getName());
        rCharizard.setBounds(230, 450, 180, 50);
        rCharizard.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rZamazenta = new JRadioButton(Monsters.ZAMAZENTA.getName());
        rZamazenta.setBounds(410, 450, 180, 50);
        rZamazenta.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        dexFrame.setVisible(true);

        JRadioButton[] buttons = {rDelphox, rGardevoir, rLucario, rZapdos, rBlastoise, rAbsol, rBlaziken};
        ButtonGroup group = new ButtonGroup();


        for(int i = 0; i < buttons.length; i++){
            dexFrame.getContentPane().add(buttons[i]);
            group.add(buttons[i]);
        }

        JLabel pokePic = new JLabel(new ImageIcon(getClass().getResource("/poke/images/Gardevoir.png")));
        pokePic.setBounds(670, 43, 250, 250);
        dexFrame.getContentPane().add(pokePic);
        pokePic.setVisible(false);

        JTextArea teamList = new JTextArea("");
        teamList.setBounds(1130, 300, 200, 200);
        teamList.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        dexFrame.getContentPane().add(teamList);
        teamList.setVisible(true);

        JTextArea teamSizeWarning = new JTextArea("Your team can only have 6 pokemon!");
        teamSizeWarning.setBounds(1130, 270, 200, 30);
        teamSizeWarning.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        teamSizeWarning.setForeground(Color.RED);
        dexFrame.getContentPane().add(teamSizeWarning);
        teamSizeWarning.setVisible(false);

        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                dexFrame.dispose();
                startMainMenu();
            }
        });

        startFight.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(tempTeam.size() < 6){
                    JOptionPane.showMessageDialog(dexFrame, "You need to have at least 6 Pokemon!", "Not enough Pokemon", JOptionPane.WARNING_MESSAGE);
                } else {
                    dexFrame.dispose();
                    startGuiFight();
                }
            }
        });

        removePoke.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(tempTeam.size() > 0){
                    tempTeam.remove(0);
                    
                    teamList.setText("");
                    for(Monsters poke : tempTeam){
                        teamList.append(poke.getName() + "\n");
                    }

                    teamList.updateUI();
                } else {
                    JOptionPane.showMessageDialog(dexFrame, "You can't remove anything!", "Empty Team", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //TMR JUST COPY DELPHOX BUTTON FOR OTHER POKEMON
        rDelphox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.DELPHOX.getName() + "\nHP: " + Monsters.DELPHOX.getHP() + "\nATK: " + Monsters.DELPHOX.getATK() + "\nDEF: " + Monsters.DELPHOX.getDEF() + "\nSPD: " + Monsters.DELPHOX.getSPD());

                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Delphox.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.DELPHOX) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.DELPHOX);
                    teamList.append("Delphox \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.DELPHOX) && tempTeam.size() == 6){
                    //teamSizeWarning.setVisible(true);
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rBlaziken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.BLAZIKEN.getName() + "\nHP: " + Monsters.BLAZIKEN.getHP() + "\nATK: " + Monsters.BLAZIKEN.getATK() + "\nDEF: " + Monsters.BLAZIKEN.getDEF() + "\nSPD: " + Monsters.BLAZIKEN.getSPD());

                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Blaziken.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.BLAZIKEN) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.BLAZIKEN);
                    teamList.append("Blaziken \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.BLAZIKEN) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rGardevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.GARDEVOIR.getName() + "\nHP: " + Monsters.GARDEVOIR.getHP() + "\nATK: " + Monsters.GARDEVOIR.getATK() + "\nDEF: " + Monsters.GARDEVOIR.getDEF() + "\nSPD: " + Monsters.GARDEVOIR.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Gardevoir.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.GARDEVOIR) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.GARDEVOIR);
                    teamList.append("Gardevoir \n");
                    teamList.updateUI();
                } else if (!tempTeam.contains(Monsters.GARDEVOIR) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rLucario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.LUCARIO.getName() + "\nHP: " + Monsters.LUCARIO.getHP() + "\nATK: " + Monsters.LUCARIO.getATK() + "\nDEF: " + Monsters.LUCARIO.getDEF() + "\nSPD: " + Monsters.LUCARIO.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Lucario.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.LUCARIO) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.LUCARIO);
                    teamList.append("Lucario \n");
                    teamList.updateUI();
                } else if(!tempTeam.contains(Monsters.LUCARIO) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rZapdos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.ZAPDOS.getName() + "\nHP: " + Monsters.ZAPDOS.getHP() + "\nATK: " + Monsters.ZAPDOS.getATK() + "\nDEF: " + Monsters.ZAPDOS.getDEF() + "\nSPD: " + Monsters.ZAPDOS.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Zapdos.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.ZAPDOS) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.ZAPDOS);
                    teamList.append("Zapdos \n");
                    teamList.updateUI();
                } else if(!tempTeam.contains(Monsters.ZAPDOS) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rBlastoise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.BLASTOISE.getName() + "\nHP: " + Monsters.BLASTOISE.getHP() + "\nATK: " + Monsters.BLASTOISE.getATK() + "\nDEF: " + Monsters.BLASTOISE.getDEF() + "\nSPD: " + Monsters.BLASTOISE.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Blastoise.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.BLASTOISE) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.BLASTOISE);
                    teamList.append("Blastoise \n");
                    teamList.updateUI();
                } else if(!tempTeam.contains(Monsters.BLASTOISE) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        rAbsol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.ABSOL.getName() + "\nHP: " + Monsters.ABSOL.getHP() + "\nATK: " + Monsters.ABSOL.getATK() + "\nDEF: " + Monsters.ABSOL.getDEF() + "\nSPD: " + Monsters.ABSOL.getSPD());
                info.setVisible(true);

                pokePic.setIcon(new ImageIcon(getClass().getResource("/poke/images/Absol.png")));
                pokePic.setVisible(true);
                pokePic.updateUI();

                if(!tempTeam.contains(Monsters.ABSOL) && tempTeam.size() < 6){
                    tempTeam.add(Monsters.ABSOL);
                    teamList.append("Absol \n");
                    teamList.updateUI();
                } else if(!tempTeam.contains(Monsters.ABSOL) && tempTeam.size() == 6){
                    JOptionPane.showMessageDialog(dexFrame, "Your team can only have 6 Pokemon!", "Team Limit", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        

        
    }

    private void startGuiFight(){
        Pokemon poke1 = new Pokemon(tempTeam.get(0));
        Pokemon poke2 = new Pokemon(tempTeam.get(1));
        Pokemon poke3 = new Pokemon(tempTeam.get(2));
        Pokemon poke4 = new Pokemon(tempTeam.get(3));
        Pokemon poke5 = new Pokemon(tempTeam.get(4));
        Pokemon poke6 = new Pokemon(tempTeam.get(5));

        myTeam.add(poke1);
        myTeam.add(poke2);
        myTeam.add(poke3);
        myTeam.add(poke4);
        myTeam.add(poke5);
        myTeam.add(poke6);

        enemyTeam.add(enemy1);
        enemyTeam.add(enemy2);
        enemyTeam.add(enemy3);
        enemyTeam.add(enemy4);
        enemyTeam.add(enemy5);
        enemyTeam.add(enemy6);

        JFrame fightFrame = new JFrame("Battle against Enemy Trainer");
        fightFrame.setBounds(1266, 868, width, height);
        fightFrame.setLocationRelativeTo(null);
        fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fightFrame.getContentPane().setLayout(null);
        fightFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        ImageIcon myTeamPokemon = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
        //ImageIcon enemyTeamPokemon = new ImageIcon(getClass().getResource("/poke/images/" + enemyTeam.get(0).getPokePictureName()));

        JLabel myTeamPokelbl = new JLabel(myTeamPokemon);
        myTeamPokelbl.setBounds(100, 100, 400, 400);
        myTeamPokemon.setImage(myTeamPokemon.getImage().getScaledInstance(325, 325, Image.SCALE_DEFAULT));
        fightFrame.getContentPane().add(myTeamPokelbl);

        fightFrame.setVisible(true);

    }

    
}