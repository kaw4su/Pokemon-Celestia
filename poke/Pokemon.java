package poke;

import java.util.*;

public class Pokemon {
    private Monsters pokemonName;
    private Type[] type;
    private boolean[] status;

    private double battleHP, battleATK, battleDEF;

    public Pokemon (Monsters name){
       this.pokemonName = name;
       this.battleHP = pokemonName.getHP();
       this.battleATK = pokemonName.getATK();
       this.battleDEF = pokemonName.getDEF();
       this.type = pokemonName.getType();

       //Poison, Paralyze, Burn, Freeze, Sleep, Immune, Seed
       status = new boolean[]{false, false, false, false, false, false, false};
        
    }

    public void takeDamage(double damage){
        battleHP -= damage;
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
}