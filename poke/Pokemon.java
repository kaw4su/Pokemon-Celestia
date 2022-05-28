package poke;

public class Pokemon {
    private Monsters pokemonName;
    private Type[] type;

    private double battleHP, battleATK, battleDEF;

    public Pokemon (Monsters name){
       this.pokemonName = name;
       this.battleHP = pokemonName.getHP();
       this.battleATK = pokemonName.getATK();
       this.battleDEF = pokemonName.getDEF();
       this.type = pokemonName.getType();
        
    }

   

    public void calculateAttack(double battleATK, Pokemon defender, AttackMove used){
        double power = used.getPower();
        //double atk = attacker.getATK();
        //double def = defender.getDEF();
        double armorpen = battleATK / battleDEF;
        double damageTaken = 0.5 * power * armorpen * typeEffectiveness(defender, used); //https://gamepress.gg/pokemongo/damage-mechanics\

        double finalDMG = Math.floor(damageTaken) + 1;
        this.battleHP -= finalDMG;
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

    public double getBattleHP(){
        return battleHP;
    }

    public double getBattleATK(){
        return battleATK;
    }
}