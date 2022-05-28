package poke;

import java.util.*;

public enum Monsters {
    DELPHOX("Delphox", (int)354, (int)260, (int)267, (int)337, new AttackMove[]{AttackMove.FLAMETHROWER, AttackMove.SHADOWBALL, AttackMove.SHOCKWAVE, AttackMove.PSYCHIC}),
    GARDEVOIR("Gardevoir", (int)340, (int)251, (int)251, (int)284, new AttackMove[]{AttackMove.MOONBLAST, AttackMove.PSYCHIC, AttackMove.THUNDERBOLT}, Type.FAIRY);

    //private final Map<AttackMove, Integer> MOVESET;
    private final AttackMove[] MOVE;
    private final Type[] TYPE;
    private final String NAME;
    private final int HP;
    private final int ATK;
    private final int DEF;
    private final int SPD;
    //private final int MNA;

    Monsters(final String name, final int hp, final int atk, final int def, final int speed, final AttackMove[] move, final Type... type) {
        NAME = name;
        TYPE = type;
        HP = hp;
        ATK = atk;
        DEF = def;
        SPD = speed;
        MOVE = move;
    }
    
    public Type[] getType(){
        return TYPE;
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
