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

   

    public void calculateAttack(double battleATK, Pokemon defender, AttackMove used){
        double power = used.getPower();
        //double atk = attacker.getATK();
        //double def = defender.getDEF();
        double armorpen = battleATK / battleDEF;
        double damageTaken = 0.5 * power * armorpen * typeEffectiveness(defender, used); //https://gamepress.gg/pokemongo/damage-mechanics\

        double finalDMG = Math.floor(damageTaken) + 1;
        this.battleHP -= finalDMG;

        if(rollStatusEffect(used)){

        }

    }

    //calculate the type effectiveness multiplier
    private double typeEffectiveness(Pokemon defender, AttackMove used){
        double typeEff = 1;

        for (Type t : type){
            if(used.getType().isSuperEffectiveAgainst(t)){
                System.out.println("It was super effective!");
                typeEff *= 2;
            } else if (used.getType().isNotVeryEffectiveAgainst(t)){
                System.out.println("It was not very effective...");
                typeEff *= 0.5;
            } else if (used.getType().hasNoEffectOn(t)){
                System.out.println("It had no effect!");
                typeEff *= 0;
            }
        }   

        return typeEff;
    } 

    private void applyStatus(AttackMove used, Pokemon defender){
        final Status s = used.getStatusEffect();
        
        switch(s){
            case POISON:
                status[0] = true;
                break;
            case PARALYZE:
                status[1] = true;
                break;
            case BURN:
                status[2] = true;
                break;
            case FREEZE:
                status[3] = true;
                break;
            case SLEEP: 
                status[4] = true;
                break;
            case IMMUNE:
                status[5] = true;
                break;
            case SEED:
                status[6] = true;
                break;
            default: //NORMAL status effect
                break;
        }
    }

    //used to check if status effect is applied
    private boolean rollStatusEffect(AttackMove used){
        Random r = new Random();
        int randInt = r.nextInt(100) + 1; //generate number from 1-100

        if(randInt <= used.getStatChance()){ //ex: There is a 30% chance of getting a number within 1-30 inside 100 numbers
            return true;
        }

        return false;
    }

    public double getBattleHP(){
        return battleHP;
    }

    public double getBattleATK(){
        return battleATK;
    }

    public boolean[] getStatus(){
        return status;
    }
}