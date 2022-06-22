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
    public static ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();

    private static boolean attack = false, switchPoke = false, item = false, attack2 = false;

    BattleMech bm = new BattleMech();

    JTextArea battleNarrationArea, myTeamInfo;
    //ImageIcon myTeamPokemon;
    JLabel myTeamPokelbl, enemyTeamPokelbl;

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
        info.setEditable(false);

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

        JRadioButton[] buttons = {rDelphox, rGardevoir, rLucario, rZapdos, rBlastoise, rAbsol,
                                  rBlaziken, rSerperior, rMagnezone, rGreninja, rXerneas, rPrimarina,
                                  rNinetales, rCharizard, rZamazenta};

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
        teamList.setEditable(false);

        JTextArea teamSizeWarning = new JTextArea("Your team can only have 6 pokemon!");
        teamSizeWarning.setBounds(1130, 270, 200, 30);
        teamSizeWarning.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        teamSizeWarning.setForeground(Color.RED);
        dexFrame.getContentPane().add(teamSizeWarning);
        teamSizeWarning.setVisible(false);
        teamSizeWarning.setEditable(false);

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
        ImageIcon enemyTeamPokemon = new ImageIcon(getClass().getResource("/poke/images/" + enemyTeam.get(0).getPokePictureName()));

        myTeamInfo = new JTextArea(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
        myTeamInfo.setBounds(100, 60, 400, 70);
        myTeamInfo.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(myTeamInfo);
        myTeamInfo.setVisible(true);
        myTeamInfo.setEditable(false);

        JTextArea enemyTeamInfo = new JTextArea(enemyTeam.get(0).getName() + "\nHP: " + enemyTeam.get(0).getBattleHP() + "/" + enemyTeam.get(0).getTotalHP());
        enemyTeamInfo.setBounds(800, 60, 400, 70);
        enemyTeamInfo.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(enemyTeamInfo);
        enemyTeamInfo.setVisible(true);
        enemyTeamInfo.setEditable(false);

        battleNarrationArea = new JTextArea("What will " + myTeam.get(0).getName() + " do?");
        
        battleNarrationArea.setLineWrap(true);
        battleNarrationArea.setEditable(false);
        //battleNarrationArea.setVisible(true);

        JScrollPane battleNarration = new JScrollPane(battleNarrationArea);
        battleNarration.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        battleNarration.setBounds(0, 500, 683, 150);
        battleNarration.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        
        fightFrame.add(battleNarration);
        battleNarration.setVisible(true);
        //fightFrame.setVisible(true);
        

        JButton fightButton = new JButton("Fight");
        fightButton.setBounds(684, 500, 340, 100);
        fightButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(fightButton);
        fightButton.setVisible(true);

        JButton bagButton = new JButton("Bag");
        bagButton.setBounds(1024, 500, 340, 100);
        bagButton.setHorizontalAlignment(SwingConstants.CENTER);
        bagButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(bagButton);
        bagButton.setVisible(true);

        JButton switchButton = new JButton("Switch");
        switchButton.setBounds(684, 600, 340, 100);
        switchButton.setHorizontalAlignment(SwingConstants.CENTER);
        switchButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(switchButton);
        switchButton.setVisible(true);

        JButton ffButton = new JButton("ff15 go next");
        ffButton.setBounds(1024, 600, 340, 100);
        ffButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        ffButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(ffButton);
        ffButton.setVisible(true);

        JButton cancelButton = new JButton("Back");
        cancelButton.setBounds(50, 650, 100, 50);
        cancelButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        cancelButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(cancelButton);
        cancelButton.setVisible(false);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(434, 650, 200, 50);
        continueButton.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        continueButton.setHorizontalAlignment(SwingConstants.CENTER);
        fightFrame.getContentPane().add(continueButton);
        continueButton.setVisible(false);

        JButton atk1Button = new JButton();
        atk1Button.setBounds(684, 500, 340, 100);
        atk1Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk1Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk1Button);
        atk1Button.setVisible(false);

        JButton atk2Button = new JButton();
        atk2Button.setBounds(1024, 500, 340, 100);
        atk2Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk2Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk2Button);
        atk2Button.setVisible(false);

        JButton atk3Button = new JButton();
        atk3Button.setBounds(684, 600, 340, 100);
        atk3Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk3Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk3Button);
        atk3Button.setVisible(false);

        JButton atk4Button = new JButton();
        atk4Button.setBounds(1024, 600, 340, 100);
        atk4Button.setHorizontalAlignment(SwingConstants.CENTER);
        atk4Button.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        fightFrame.getContentPane().add(atk4Button);
        atk4Button.setVisible(false);

        myTeamPokelbl = new JLabel(myTeamPokemon);
        myTeamPokelbl.setBounds(100, 100, 400, 400);
        myTeamPokemon.setImage(myTeamPokemon.getImage().getScaledInstance(325, 325, Image.SCALE_DEFAULT));
        fightFrame.getContentPane().add(myTeamPokelbl);

        enemyTeamPokelbl = new JLabel(enemyTeamPokemon);
        enemyTeamPokelbl.setBounds(800, 100, 400, 400);
        enemyTeamPokemon.setImage(enemyTeamPokemon.getImage().getScaledInstance(325, 325, Image.SCALE_DEFAULT));
        fightFrame.getContentPane().add(enemyTeamPokelbl);

        fightFrame.setVisible(true);

        //BUTTON COMMANDS
        ffButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                fightFrame.dispose();
                showDefeatScreen();
            }
        });

        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                battleNarrationArea.setText("What will " + myTeam.get(0).getName() + " do?");

                atk1Button.setVisible(false);
                atk2Button.setVisible(false);
                atk3Button.setVisible(false);
                atk4Button.setVisible(false);

                fightButton.setVisible(true);
                ffButton.setVisible(true);
                bagButton.setVisible(true);
                switchButton.setVisible(true);

                cancelButton.setVisible(false);
                continueButton.setVisible(false);
            }
        });

        fightButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                battleNarrationArea.setText("What move will " + myTeam.get(0).getName() + " use?");
                battleNarration.updateUI();

                fightButton.setVisible(false);
                ffButton.setVisible(false);
                bagButton.setVisible(false);
                switchButton.setVisible(false);

                cancelButton.setVisible(true);
                //continueButton.setVisible(true);

                atk1Button.setText(myTeam.get(0).getATK1().getName());
                atk1Button.setVisible(true);

                atk2Button.setText(myTeam.get(0).getATK2().getName());
                atk2Button.setVisible(true);

                atk3Button.setText(myTeam.get(0).getATK3().getName());
                atk3Button.setVisible(true);

                atk4Button.setText(myTeam.get(0).getATK4().getName());
                atk4Button.setVisible(true);


            }
        });

        switchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                showSwitchScreen();
            }
        });

        atk1Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                bm.setAttackSelected(myTeam.get(0).getATK1());
                attack = true;

                continueButton.setVisible(true);

                //battleNarrationArea.setText(myTeam.get(0).getName() + " used " + myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK1()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                //switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        atk2Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                bm.setAttackSelected(myTeam.get(0).getATK2());
                attack = true;

                continueButton.setVisible(true);

                //battleNarrationArea.setText(myTeam.get(0).getName() + " used " + myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK2()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                //switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        atk3Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                bm.setAttackSelected(myTeam.get(0).getATK3());
                attack = true;

                continueButton.setVisible(true);

                //battleNarrationArea.setText(myTeam.get(0).getName() + " used " + myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK3()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                //switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        atk4Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                bm.setAttackSelected(myTeam.get(0).getATK4());
                attack = true;

                continueButton.setVisible(true);

                //battleNarrationArea.setText(myTeam.get(0).getName() + " used " + myTeam.get(0).getATK1().getName());
                battleNarrationArea.setText(displayBattle(myTeam.get(0).getATK4()));
                battleNarrationArea.updateUI();

                myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                myTeamInfo.updateUI();

                //switchButton.setEnabled(false);
                cancelButton.setEnabled(false);
                atk1Button.setEnabled(false);
                atk2Button.setEnabled(false);
                atk3Button.setEnabled(false);
                atk4Button.setEnabled(false);

            }
        });

        continueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(attack){
                    //battleNarrationArea.setText(bm.trainerAI(myTeam.get(0), enemyTeam.get(0), enemyTeam));
                    //battleNarration.setText("Test");
                    //battleNarration.updateUI();
                    if(myTeam.get(0).fainted() && myTeam.get(1).fainted() && myTeam.get(2).fainted() && myTeam.get(3).fainted() && myTeam.get(4).fainted() && myTeam.get(5).fainted()){
                        fightFrame.dispose();
                        showDefeatScreen();
                    } else if (myTeam.get(0).fainted()){
                        showSwitchScreen();
                    }

                    attack = false;
                } else {
                    battleNarrationArea.setText("What will " + myTeam.get(0).getName() + " do?");
                    battleNarrationArea.updateUI();
                }

                cancelButton.setEnabled(true);
                atk1Button.setEnabled(true);
                atk2Button.setEnabled(true);
                atk3Button.setEnabled(true);
                atk4Button.setEnabled(true);

                cancelButton.setVisible(false);
                atk1Button.setVisible(false);
                atk2Button.setVisible(false);
                atk3Button.setVisible(false);
                atk4Button.setVisible(false);
                continueButton.setVisible(false);

                switchButton.setVisible(true);
                fightButton.setVisible(true);
                ffButton.setVisible(true);
                bagButton.setVisible(true);
            }
        });

    }

    private void showDefeatScreen(){
        JFrame loseFrame = new JFrame("You have been defeated!");
        loseFrame.setBounds(1266, 868, width, height);
        loseFrame.setLocationRelativeTo(null);
        loseFrame.getContentPane().setLayout(null);
        loseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loseFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        ImageIcon defeatScreen = new ImageIcon(getClass().getResource("/poke/images/defeat.png"));

        JLabel defeatlbl = new JLabel(defeatScreen);
        defeatlbl.setBounds(0,0,width, height);
        defeatScreen.setImage(defeatScreen.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        loseFrame.getContentPane().add(defeatlbl);

        loseFrame.setVisible(true);
    }

    private String displayBattle(AttackMove atk){
        String result = "";
        String enemyAction = bm.trainerAI(myTeam.get(0), enemyTeam.get(0), enemyTeam);
        
        switch (enemyAction.substring(0, 4)){
            case "heal":
                result += "\nEnemy trainer healed " + enemyTeam.get(0);
                result += bm.oneSidedFight(myTeam.get(0), enemyTeam.get(0), atk);

                break;
            case "swap":
                String pokeSwap = enemyAction.substring(4);

                for(Pokemon poke : enemyTeam){
                    if(poke.getName().equals(pokeSwap)){
                        result += "\nEnemy trainer swapped " + enemyTeam.get(0).getName() + " to " + poke.getName();
                        Collections.swap(enemyTeam, 0, enemyTeam.indexOf(poke));

                        ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + poke.getPokePictureName()));
                        enemyTeamPokelbl.setIcon(image);

                        result += bm.oneSidedFight(myTeam.get(0), enemyTeam.get(0), atk);
                    }
                }

                break;
            default:
                AttackMove enemyAttack = null;

                for(AttackMove mov : enemyTeam.get(0).getMoveSet()){
                    if(mov.getName().equals(enemyAction)){
                        enemyAttack = mov;
                        break;
                    }
                }

                if(myTeam.get(0).getBattleSPD() >= enemyTeam.get(0).getBattleSPD()){
                    result += bm.battleOrder(myTeam.get(0), atk, enemyTeam.get(0), enemyAttack);
                } else if (myTeam.get(0).getBattleSPD() < enemyTeam.get(0).getBattleSPD()){
                    result += bm.battleOrder(enemyTeam.get(0), enemyAttack, myTeam.get(0), atk);
                }

                break;
        }

        return result;
    }

    private void showSwitchScreen(){
        JFrame switchFrame = new JFrame("Switch out a pokemon");
        switchFrame.setBounds(1266, 868, 800, 800);
        switchFrame.setLocationRelativeTo(null);
        switchFrame.getContentPane().setLayout(null);
        switchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        switchFrame.setFont(new Font("inhalt", Font.PLAIN, fontSize));

        JButton firstPokemon = new JButton(myTeam.get(1).getName());
        firstPokemon.setBounds(100, 100, 300, 100);
        firstPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        firstPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        switchFrame.getContentPane().add(firstPokemon);
        firstPokemon.setVisible(true);

        JButton secondPokemon = new JButton(myTeam.get(2).getName());
        secondPokemon.setBounds(400, 200, 300, 100);
        secondPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        secondPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        switchFrame.getContentPane().add(secondPokemon);
        secondPokemon.setVisible(true);

        JButton thirdPokemon = new JButton(myTeam.get(3).getName());
        thirdPokemon.setBounds(100, 300, 300, 100);
        thirdPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        switchFrame.getContentPane().add(thirdPokemon);
        thirdPokemon.setVisible(true);

        JButton fourthPokemon = new JButton(myTeam.get(4).getName());
        fourthPokemon.setBounds(400, 400, 300, 100);
        fourthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        switchFrame.getContentPane().add(fourthPokemon);
        fourthPokemon.setVisible(true);

        JButton fifthPokemon = new JButton(myTeam.get(5).getName());
        fifthPokemon.setBounds(100, 500, 300, 100);
        fifthPokemon.setHorizontalAlignment(SwingConstants.CENTER);
        fifthPokemon.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        switchFrame.getContentPane().add(fifthPokemon);
        fifthPokemon.setVisible(true);

        switchFrame.setVisible(true);

        //COPY THIS FOR OTHER BUTTONS AS WELL
        firstPokemon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(myTeam.get(1).fainted()){
                    JOptionPane.showMessageDialog(dexFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!", JOptionPane.WARNING_MESSAGE); 
                } else {
                    battleNarrationArea.setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(1).getName());
                    Collections.swap(myTeam, 0, 1);

                    ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    switchFrame.dispose();
                } 
            }
        });

        secondPokemon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(myTeam.get(2).fainted()){
                    JOptionPane.showMessageDialog(dexFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!", JOptionPane.WARNING_MESSAGE); 
                } else {
                    battleNarrationArea.setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(2).getName());
                    Collections.swap(myTeam, 0, 2);

                    ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    switchFrame.dispose();
                } 
            }
        });

        thirdPokemon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(myTeam.get(3).fainted()){
                    JOptionPane.showMessageDialog(dexFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!", JOptionPane.WARNING_MESSAGE); 
                } else {
                    battleNarrationArea.setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(3).getName());
                    Collections.swap(myTeam, 0, 3);

                    ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    switchFrame.dispose();
                } 
            }
        });

        fourthPokemon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(myTeam.get(4).fainted()){
                    JOptionPane.showMessageDialog(dexFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!", JOptionPane.WARNING_MESSAGE); 
                } else {
                    battleNarrationArea.setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(4).getName());
                    Collections.swap(myTeam, 0, 4);

                    ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    switchFrame.dispose();
                } 
            }
        });

        fifthPokemon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent click){
                if(myTeam.get(5).fainted()){
                    JOptionPane.showMessageDialog(dexFrame, "You can't switch to this Pokemon!", "Pokemon Fainted!", JOptionPane.WARNING_MESSAGE); 
                } else {
                    battleNarrationArea.setText("You swapped " + myTeam.get(0).getName() + " for " + myTeam.get(5).getName());
                    Collections.swap(myTeam, 0, 5);

                    ImageIcon image = new ImageIcon(getClass().getResource("/poke/images/" + myTeam.get(0).getPokePictureName()));
                    myTeamPokelbl.setIcon(image);

                    myTeamInfo.setText(myTeam.get(0).getName() + "\nHP: " + myTeam.get(0).getBattleHP() + "/" + myTeam.get(0).getTotalHP());
                    myTeamInfo.updateUI();

                    switchFrame.dispose();
                } 
            }
        });
    }

    
}