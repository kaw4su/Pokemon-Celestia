package poke;

import java.util.*;

public enum Monsters {
    DELPHOX("Delphox", (int)354, (int)260, (int)267, (int)337, new AttackMove[]{AttackMove.FLAMETHROWER, AttackMove.SHADOWBALL, AttackMove.SHOCKWAVE, AttackMove.PSYCHIC}, Type.FIRE, Type.PSYCHIC),
    LUCARIO("Lucario", (int)344, (int)350, (int)262, (int)306, new AttackMove[]{AttackMove.AURASPHERE, AttackMove.SHADOWBALL, AttackMove.BONERUSH, AttackMove.POISONJAB}, Type.FIGHTING),
    BLASTOISE("Blastoise", (int)362, (int)291, (int)328, (int)280, new AttackMove[]{AttackMove.HYDROPUMP, AttackMove.SCALD, AttackMove.DARKPULSE, AttackMove.ICEBEAM}, Type.WATER),
    //TODO FINISH ZAPDOS STUFF
    ZAPDOS("Zapdos", (int)384, (int)383, (int)306, (int)328, new AttackMove[]{AttackMove.DRILLPECK, AttackMove.DISCHARGE, AttackMove.ZAPCANNON, AttackMove.})
    GARDEVOIR("Gardevoir", (int)340, (int)251, (int)251, (int)284, new AttackMove[]{AttackMove.MOONBLAST, AttackMove.PSYCHIC, AttackMove.THUNDERBOLT}, Type.FAIRY, Type.PSYCHIC);

    //private final Map<AttackMove, Integer> MOVESET;
    private final AttackMove[] MOVE;
    private final Type[] TYPE_A;
    private final Type[] TYPE_B;
    private final String NAME;
    private final int HP;
    private final int ATK;
    private final int DEF;
    private final int SPD;
    //private final int MNA;

    Monsters(final String name, final int hp, final int atk, final int def, final int speed, final AttackMove[] move, final Type typeA, final Type typeB) {
        NAME = name;
        TYPE_A = typeA;
        TYPE_B = typeB
        HP = hp;
        ATK = atk;
        DEF = def;
        SPD = speed;
        MOVE = move;
    }
    
    public Type[] getTypeA(){
        return TYPE_A;
    }

    public Type[] getTypeB(){
        return TYPE_B;
    }
    
    public String getName(){
        return NAME;
    }
    
    public int getHP(){
        return HP;
    }
    
    public int getATK(){
        return ATK;
    }
    
    public int getDEF(){
        return DEF;
    }
    
    public int getSPD(){
        return SPD;
    }
    
}
