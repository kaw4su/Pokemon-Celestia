package poke;

public class Gardevoir extends Pokemon {
    public Gardevoir(String name){
        super.name = name;
        dmg = 80;
        manaPoints = 120;
        hp = 200;
        typeA = "Psychic";
        typeB = "Fairy";

        attack[0][0] = "Tackle";
        attack[0][1] = "Moonblast";
        attack[1][0] = "Psychic";
        attack[1][1] = "Shadow Ball";
    }

    public Gardevoir(){
    }

    @Override
    public megaGardevoir megaEvo(){
        return new megaGardevoir(this);
    }
}