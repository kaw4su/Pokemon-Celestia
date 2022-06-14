
package poke;

import java.util.*;

public class BattleMech {
    public static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
    public static ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();

    private static int healPotion = 5, enemyHealPotion = 5;
    private static AttackMove enemyAttack;
    private static boolean switch = false;
    
    public static void main(String[] args){
        Pokemon poke1 = new Pokemon(Monsters.GARDEVOIR);
        Pokemon poke2 = new Pokemon(Monsters.DELPHOX);
        Pokemon poke3 = new Pokemon(Monsters.LUCARIO);
        Pokemon poke4 = new Pokemon(Monsters.BLASTOISE);
        Pokemon poke5 = new Pokemon(Monsters.ZAPDOS);
        Pokemon poke6 = new Pokemon(Monsters.SERPERIOR);

        Pokemon enemy1 = new Pokemon(Monsters.HAWLUCHA);
        Pokemon enemy2 = new Pokemon(Monsters.TYRANTRUM);
        Pokemon enemy3 = new Pokemon(Monsters.AURORUS);
        Pokemon enemy4 = new Pokemon(Monsters.GOURGEIST);
        Pokemon enemy5 = new Pokemon(Monsters.GOODRA);
        Pokemon enemy6 = new Pokemon(Monsters.GARDEVOIR);

        BattleMech bm = new BattleMech();
        Scanner sc = new Scanner(System.in);

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

        AttackMove attackSelected;

        
        System.out.println("Starting HP for both Pokemon: ");
        System.out.println(myTeam.get(0).getName() + " " + myTeam.get(0).getBattleHP());
        System.out.println(enemyTeam.get(0).getName() + " " + enemyTeam.get(0).getBattleHP());
        System.out.println();

        System.out.println("Type in the move name you want to use");
        System.out.println(myTeam.get(0).AttackMove); //THIS MIGHT NEED SOME CHANGING
        String moveSelected = sc.nextLine();

        switch(moveSelected){
            case poke1.getFirstAttackString():
                attackSelected = poke1.getATK1();
                break;
            case poke1.getSecondAttackString():
                attackSelected = poke1.getATK2();
                break;
            case poke1.getThirdAttackString():
                attackSelected = poke1.getATK3();
                break;
            case poke1.getFourthAttackString():
                attackSelected = poke1.getATK4();
                break;
        }

        trainerAI();

        //if player's pokemon has equal or faster speed
        if(attackSelected != null){
            if(poke1.getBattleSPD() >= enemy1.getBattleSPD()){
                System.out.println(bm.battleOrder(poke1, attackSelected, enemy1, attackSelected));
            } else {
                System.out.println(bm.battleOrder(enemy1, attackSelected, poke1, attackSelected));
            }
        }

        System.out.println("Ending HP for both Pokemon: ");
        System.out.println("Gardevoir " + poke1.getBattleHP());
        System.out.println("Hawlucha: " + enemy1.getBattleHP());
        System.out.println();

        System.out.println("Original HP for both Pokemon: ");
        System.out.println("Gardevoir: " + Monsters.GARDEVOIR.getHP());
        System.out.println("Hawlucha: " + Monsters.HAWLUCHA.getHP());
        
    }

    //method used for move priority
    private String battleOrder(Pokemon first, AttackMove firstMove, Pokemon second, AttackMove secondMove){
        String str = first.getName() + " used " + firstMove.getName();
        double firstDamage = calculateAttack(first, second, firstMove), secondDamage = calculateAttack(second, first, secondMove);

        str += "\n" + first.getName() + " deals " + firstDamage + " damage to " + second.getName();
        second.takeDamage(firstDamage);

        //check type effectiveness to print messages
        double d = typeEffectiveness(second, firstMove);

        if(d == 0){
            str += "\nIt has no effect on " + second.getName();
        } else if (d < 1){
            str += "\n It's not very effective";
        } else if (d > 1){
            str += "\nIt's super effective";
        }

        if(second.fainted()){
            str += "\n" + second.getName() + " fainted";
            return str + "\n";
        }

        //only apply status if the attack has effect on the defending pokemon
        if(d != 0){
            if(rollStatusEffect(firstMove)){
                applyStatus(firstMove, second);
                if (firstMove.getStatusEffect() != Status.NORMAL){
                    str += "\n" + firstMove.getStatusEffect() + " is applied on " + second.getName();
                }
            }
        }

        str += "\n" + second.getName() + " used " + secondMove.getName();

        str += "\n" + second.getName() + " deals " + secondDamage + " damage to " + first.getName();
        first.takeDamage(secondDamage);

        double f = typeEffectiveness(first, secondMove);

        if(f == 0){
            str += "\nIt has no effect on " + first.getName();
        } else if (f < 1){
            str += "\n It's not very effective";
        } else if (f > 1){
            str += "\nIt's super effective";
        }

        if(first.fainted()){
            str += "\n" + first.getName() + " fainted";
            return str + "\n";
        }

        if(f != 0){
            if(rollStatusEffect(secondMove)){
                applyStatus(secondMove, first);
                if(secondMove.getStatusEffect != Status.NORMAL){
                    str += "\n" + secondMove.getStatusEffect() + " is applied on " + first.getName();
                }
                //TODO
            }
        }

        return str + "\n";
    }

    public double calculateAttack(Pokemon attacker, Pokemon defender, AttackMove used){
        double power = used.getPower();
        double battleATK = attacker.getBattleATK();
        double battleDEF = attacker.getBattleDEF();
        //double def = defender.getDEF();
        double armorpen = battleATK / battleDEF;
        double damageTaken = 0.5 * power * armorpen * typeEffectiveness(defender, used); //https://gamepress.gg/pokemongo/damage-mechanics\

        double finalDMG = Math.floor(damageTaken) + 1;

        return finalDMG;

    }

    //calculate the type effectiveness multiplier
    public double typeEffectiveness(Pokemon defender, AttackMove used){
        double typeEff = 1;

       // for (Type t : defender.getTypeA()){
            if(used.getType().isSuperEffectiveAgainst(defender.getTypeA())){
                //System.out.println("It was super effective!");
                typeEff *= 2;
            } else if (used.getType().isNotVeryEffectiveAgainst(defender.getTypeA())){
                //System.out.println("It was not very effective...");
                typeEff *= 0.5;
            } else if (used.getType().hasNoEffectOn(defender.getTypeA())){
                //System.out.println("It had no effect!");
                typeEff *= 0;
            }
        //}   

        //for pokemon that only have a single type
        if(defender.getTypeB() == Type.NULLTYPE){
            return typeEff;
        }

        //secondary types
        //for (Type t : defender.getTypeB()){
            if(used.getType().isSuperEffectiveAgainst(defender.getTypeB())){
                typeEff *= 2;
            } else if (used.getType().isNotVeryEffectiveAgainst(defender.getTypeB())){
                typeEff *= 0.5;
            } else if (used.getType().hasNoEffectOn(defender.getTypeB())){
                typeEff *= 0;
            }
        //}
        return typeEff;
    } 

    private void applyStatus(AttackMove used, Pokemon defender){
        final Status s = used.getStatusEffect();
        
        switch(s){
            case POISON:
                defender.getStatus()[0] = true;
                break;
            case PARALYZE:
                defender.getStatus()[1] = true;
                break;
            case BURN:
                defender.getStatus()[2] = true;
                break;
            case FREEZE:
                defender.getStatus()[3] = true;
                break;
            case SLEEP: 
                defender.getStatus()[4] = true;
                break;
            case IMMUNE:
                defender.getStatus()[5] = true;
                break;
            case SEED:
                defender.getStatus()[6] = true;
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

    private void healPokemon(Pokemon pokemonHealed){
        pokemonHealed.gainHP();
    }


    //https://hackaday.com/wp-content/uploads/2014/05/pokemon-decisiontree.png
    private void trainerAI(){
        double threshold = enemyTeam.get(0).getHP() * 0.4; //find 40% of maximum hp
        boolean moveAvailable = false, healthSwitch = false;
        
        if(enemyTeam.get(0).getBattleHP() <= threshold){ //if fielded pokemon is below 40% health
            if (enemyHealPotion > 0){ //if enemy still have potions
                healPokemon(enemyTeam.get(0));
                enemyHealPotion--;
            } else {
                //switch to pokemon that will take the least damage

                //search for pokemon that will take least damage based on pokemon's type
                for(Pokemon p : enemyTeam){
                    if (p.getTypeA().isSuperEffectiveAgainst(myTeam.get(0).getTypeA())
                        || p.getTypeB().isSuperEffectiveAgainst(myTeam.get(0).getTypeA())
                        || p.getTypeA().isSuperEffectiveAgainst(myTeam.get(0).getTypeB())
                        || p.getTypeB().isSuperEffectiveAgainst(myTeam.get(0).getTypeB())){
                        Collections.swap(enemyTeam, 0, enemyTeam.indexOf(p)); //switch current pokemon to pokemon that will take the least damage
                        healthSwitch = true;
                        break;
                    }
                }

                //desperate times, desperate measures
                if(!healthSwitch){
                    double max = enemyTeam.get(0).getBattleHP();

                    if(enemyTeam.get(1).getBattleHP() > max){
                        max = enemyTeam.get(1).getBattleHP();
                    } else if (enemyTeam.get(2).getBattleHP() > max){
                        max = enemyTeam.get(2).getBattleHP();
                    } else if (enemyTeam.get(3).getBattleHP() > max){
                        max = enemyTeam.get(3).getBattleHP();
                    } else if (enemyTeam.get(4).getBattleHP() > max){
                        max = enemyTeam.get(4).getBattleHP();
                    } else if (enemyTeam.get(5).getBattleHP() > max){
                        max = enemyTeam.get(5).getBattleHP();
                    }

                    for (Pokemon p : enemyTeam){
                        if (max == p.getBattleHP()){
                            Collections.swap(enemyTeam, 0, enemyTeam.indexOf(p));
                        }
                    }
                }
            }
        } else {
            //loop through current pokemon's available moveset
            for(AttackMove mov : enemyTeam.get(0).AttackMove){
                if(typeEffectiveness(myTeam.get(0), mov) >= 1){ //if move is able to do neutral or supereffective damage
                    if(mov.getBattlePP() > 0){
                        enemyAttack = mov;
                        mov.lowerPP();
                        moveAvailable = true;
                        break;
                    }
                }
            }

            //if all moves are not effective against opponent, switch to healthy pokemon that has effective moves
            if(!moveAvailable){
                for(Pokemon p : enemyTeam){
                    if (p.getTypeA().isSuperEffectiveAgainst(myTeam.get(0).getTypeA())
                        || p.getTypeB().isSuperEffectiveAgainst(myTeam.get(0).getTypeA())
                        || p.getTypeA().isSuperEffectiveAgainst(myTeam.get(0).getTypeB())
                        || p.getTypeB().isSuperEffectiveAgainst(myTeam.get(0).getTypeB())){
                            if(p.getBattleHP() > (p.getHP() * 0.4)){
                                Collections.swap(enemyTeam, 0, enemyTeam.indexOf(p));
                            }
                        }
                }
            }
        }
    }
   
}