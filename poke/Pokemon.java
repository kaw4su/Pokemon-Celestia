package poke;

import java.util.*;

public class Pokemon {
    private Monsters pokemonName;
    private Type typeA;
    private Type typeB;
    private boolean[] status;
    private AttackMove[] MOVE_SET;

    private double battleHP, battleATK, battleDEF, HP;

    private int battleSPD, sleepCounter;

    private String name, attack1, attack2, attack3, attack4;

    private AttackMove atk1, atk2, atk3, atk4;


    public Pokemon (Monsters name){
       this.pokemonName = name;
       this.battleHP = pokemonName.getHP();
       this.HP = pokemonName.getHP();
       this.battleATK = pokemonName.getATK();
       this.battleDEF = pokemonName.getDEF();
       this.typeA = pokemonName.getTypeA();
       this.typeB = pokemonName.getTypeB();
       this.battleSPD = pokemonName.getSPD();
       this.name = pokemonName.getName();

       this.attack1 = pokemonName.getAttack1().toString();
       this.attack2 = pokemonName.getAttack2().toString();
       this.attack3 = pokemonName.getAttack3().toString();
       this.attack4 = pokemonName.getAttack4().toString();

       this.atk1 = pokemonName.getAttack1();
       this.atk2 = pokemonName.getAttack2();
       this.atk3 = pokemonName.getAttack3();
       this.atk4 = pokemonName.getAttack4();

       this.MOVE_SET = pokemonName.getMonsterMoveSet();

       this.sleepCounter = 3;


       //Poison, Paralyze, Burn, Freeze, Sleep, Immune, Seed
       status = new boolean[]{false, false, false, false, false, false, false};
        
    }

    public void takeDamage(double damage){
        battleHP -= damage;
    }

    public void gainHP(){
        battleHP += 200;
    }

    public void lowerSleepCounter(){
        sleepCounter--;
    }

    public void resetSleepCounter(){
        sleepCounter = 3;
    }

    public Type getTypeA(){
        return typeA;
    }

    public Type getTypeB(){
        return typeB;
    }

    public AttackMove[] getMoveSet(){
        return MOVE_SET;
    }

    public AttackMove getATK1(){
        return atk1;
    }

    public AttackMove getATK2(){
        return atk2;
    }

    public AttackMove getATK3(){
        return atk3;
    }

    public AttackMove getATK4(){
        return atk4;
    }

    public boolean fainted(){
        return battleHP <= 0;
    }

    public double getBattleHP(){
        return battleHP;
    }

    public double getTotalHP(){
        return HP;
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

    public int getSleepCounter(){
        return sleepCounter;
    }

    public String getName(){
        return name;
    }

    public String getFirstAttackString(){
        return attack1;
    }

    public String getSecondAttackString(){
        return attack2;
    }

    public String getThirdAttackString(){
        return attack3;
    }

    public String getFourthAttackString(){
        return attack4;
    }
}