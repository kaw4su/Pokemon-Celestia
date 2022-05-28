package poke;

public class BattleMech {
    public static void main(String[] args){
        Pokemon poke1 = new Pokemon(Monsters.GARDEVOIR);
        Pokemon enemy = new Pokemon(Monsters.DELPHOX);

        System.out.println("Starting HP for both Pokemon: ");
        System.out.println("Gardevoir: " + poke1.getBattleHP());
        System.out.println("Delphox: " + enemy.getBattleHP());
        System.out.println();

        System.out.println("Gardevoir used Moonblast!");
        enemy.calculateAttack(poke1.getBattleATK(), enemy, AttackMove.MOONBLAST);
        System.out.println();

        System.out.println("Ending HP for both Pokemon: ");
        System.out.println("Gardevoir " + poke1.getBattleHP());
        System.out.println("Delphox: " + enemy.getBattleHP());
        System.out.println();

        System.out.println("Original HP for both Pokemon: ");
        System.out.println("Gardevoir: " + Monsters.GARDEVOIR.getHP());
        System.out.println("Delphox: " + Monsters.DELPHOX.getHP());
    }
   
}