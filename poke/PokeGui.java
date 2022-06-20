package poke;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class PokeGui extends JComponent implements Runnable {
    //final static Dimension screenSize = Toolkit.getDefaultToolKit().getScreenSize();
    final static int width = 1366;
    final static int height = 768;
    final static int fontSize = (int)(height/30);

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
        startBtn.setBounds(500,300, width/4, height/15);
        startBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize+5));

        JButton endBtn = new JButton("Quit Game");
        endBtn.setBounds(500, 400, width/4, height/15);
        endBtn.setFont(new Font("inhalt", Font.PLAIN, fontSize+5));

        //TODO
        ImageIcon pokemonSymbol = new ImageIcon(getClass().getResource(Pokemon.png));
        JLabel welcomelbl = new JLabel(pokemonSymbol);
        welcomelbl.setBounds(0, 0, 500, 158);

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
        backButton.setBounds((int)(width/1.4), (int(height/20), 250, 70));
        backButton.setFont(new Font("inhalt", Font.PLAIN, fontSize+2));
        dexFrame.getContentPane().add();
        backButton.setVisible(true);

        JButton startFight = new JButton("Start Battle");
        startFight.setBounds((int)(width/1.4), (int)(height/20), 250, 120);
        startFight.setFont(new Font("inhalt", Font.PLAIN, fontSize+2));
        dexFrame.getContentPane().add();
        startFight.setVisible(true);

        JTextArea info = new JTextArea("");
        info.setBounds(width/20, height/6, width/2, 230);
        info.setFont(new Font("inhalt", Font.PLAIN, fontSize));
        dexFrame.getContentPane.add(info);

        JRadioButton rDelphox = new JRadioButton(Monsters.DELPHOX.getName());
        rDelphox.setBounds(50,((int)(height/1.4),180,50));
        rDelphox.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rGardevoir = new JRadioButton(Monsters.GARDEVOIR.getName());
        rGardevoir.setBounds(230, (int)(height/1.4),180,50);
        rGardevoir.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rLucario = new JRadioButton(Monsters.LUCARIO.getName());
        rLucario.setBounds(410, (int)(height/1.4),180,50);
        rLucario.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rZapdos = new JRadioButton(Monsters.ZAPDOS.getName());
        rZapdos.setBounds(590, (int)(height/1.4),180,50);
        rZapdos.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rBlastoise = new JRadioButton(Monsters.BLASTOISE.getName());
        rBlastoise.setBounds(770, (int)(height/1.4), 180, 50);
        r.BLASTOISE.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton rAbsol = new JRadioButton(Monsters.ABSOL.getName());
        rAbsol.setBounds(950, (int)(height/1.4), 180, 50);
        rAbsol.setFont(new Font("inhalt", Font.PLAIN, fontSize+3));

        JRadioButton[] buttons = {rDelphox, rGardevoir, rLucario, rZapdos, rBlastoise, rAbsol};
        ButtonGroup group = new ButtonGroup();

        for(int i = 0; i < buttons.length; i++){
            dexFrame.getContentPane().add(buttons[i]);
            group.add(buttons[i]);
        }

        rDelphox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.DELPHOX.getName());
                info.setVisible(true);
            }
        });

        rGardevoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click){
                info.setBackground(Color.white);
                info.setText(Monsters.GARDEVOIR.getName());
                info.setVisible(true);
            }
        });

        
    }

    
}