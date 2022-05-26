package poke;

public abstract class Pokemon {
    public String name;
    public double manaPoints;
    public double dmg;
    //public int level;
    public String typeA, typeB;
    public int hp;
    public String[][] attack = new String[2][2]; //used for attack moves

    public Pokemon(String name){
        this.name = name;
    }
    
    public Pokemon(){
    }

    

    public abstract Pokemon megaEvo();

    //used to calculate how much damage your pokemon move does towards enemy and vice versa
    public double getAttackFactor(Pokemon enemy, String attackType){
        if (attackType.equals(this.attack[0][1])){ //this slot is always a normal attack, which is a *1 multiplier
            return this.dmg;
        }
    }

    public float typeEffectiveness(Pokemon enemy, )
    //damn this thing was a waste of time, not needed
    /*
    @Override //type identification
    public String toString(){
        String type = "";
        if (this instanceof Fire){
            type = "Fire";
        } else if (this instanceof Water){
            type = "Water";
        } else if (this instanceof Grass){
            type = "Grass";
        } else if (this instanceof Electric){
            type = "Electric";
        } else if (this instanceof Grass){
            type = "Grass";
        } else if (this instanceof Ice){
            type = "Ice";
        } else if (this instanceof Fighting){
            type = "Fighting";
        } else if (this instanceof Poison){
            type = "Poison";
        } else if (this instanceof Ground){
            type = "Ground";
        } else if (this instanceof Flying){
            type = "Flying";
        } else if (this instanceof Psychic){
            type = "Psychic";
        } else if (this instanceof Bug){
            type = "Bug";
        } else if (this instanceof Rock){
            type = "Rock"
        } else if (this instanceof Ghost){
            type = "Ghost";
        } else if (this instanceof Dragon){
            type = "Dragon";
        } else if (this instanceof Dark){
            type = "Dark";
        } else if (this instanceof Steel){
            type = "Steel";
        } else if (this instanceof Fairy){
            type = "Fairy";
        }

        return (this.name + " (" + this.getClass().getSimpleName() + " | " + type + " | " + this.manaPoints + " Mana; " + this.dmg + " Damage)");
    }*/

    

}
