package poke;

import java.util.*;

public class Pokemon {
    private Monsters pokemonName;
    private Type typeA;
    private Type typeB;
    private boolean[] status;

    private double battleHP, battleATK, battleDEF;

    private int battleSPD;

    private String name;


    public Pokemon (Monsters name){
       this.pokemonName = name;
       this.battleHP = pokemonName.getHP();
       this.battleATK = pokemonName.getATK();
       this.battleDEF = pokemonName.getDEF();
       this.typeA = pokemonName.getTypeA();
       this.typeB = pokemonName.getTypeB();
       this.battleSPD = pokemonName.getSPD();
       this.name = pokemonName.getName();

       //Poison, Paralyze, Burn, Freeze, Sleep, Immune, Seed
       status = new boolean[]{false, false, false, false, false, false, false};
        
    }

    public void takeDamage(double damage){
        battleHP -= damage;
    }

    public Type getTypeA(){
        return typeA;
    }

    public Type getTypeB(){
        return typeB;
    }

    public boolean fainted(){
        return battleHP <= 0;
    }

    public double getBattleHP(){
        return battleHP;
    }

    public double getBattleDEF(){
        return battleDEF;
    }

    public double getBattleATK(){
        return battleATK;
    }

    public boolean[] getStatus(){
        return status;
    }

    public int getBattleSPD(){
        return battleSPD;
    }

    public String getName(){
        return name;
    }

}