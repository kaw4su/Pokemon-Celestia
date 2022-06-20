package poke;

import java.util.*;

public enum Monsters {
    //player pokemon
    DELPHOX("Delphox", "Delphox.png", (int)354, (int)260, (int)267, (int)337, new AttackMove[]{AttackMove.FLAMETHROWER, AttackMove.SHADOWBALL, AttackMove.SHOCKWAVE, AttackMove.PSYCHIC}, Type.FIRE, Type.PSYCHIC),
    LUCARIO("Lucario", "Lucario.png", (int)344, (int)350, (int)262, (int)306, new AttackMove[]{AttackMove.AURASPHERE, AttackMove.SHADOWBALL, AttackMove.BONERUSH, AttackMove.POISONJAB}, Type.FIGHTING, Type.NULLTYPE),
    BLASTOISE("Blastoise", "Blastoise.png" (int)362, (int)291, (int)328, (int)280, new AttackMove[]{AttackMove.HYDROPUMP, AttackMove.SCALD, AttackMove.DARKPULSE, AttackMove.ICEBEAM}, Type.WATER, Type.NULLTYPE),
    ZAPDOS("Zapdos", "Zapdos.png", (int)384, (int)383, (int)306, (int)328, new AttackMove[]{AttackMove.DRILLPECK, AttackMove.DISCHARGE, AttackMove.ZAPCANNON, AttackMove.HEATWAVE}, Type.ELECTRIC, Type.FLYING),
    SERPERIOR("Serperior", "Serperior.png", (int)354, (int)273, (int)317, (int)357, new AttackMove[]{AttackMove.LEAFSTORM, AttackMove.LEAFBLADE, AttackMove.AERIALACE, AttackMove.AQUATAIL}, Type.GRASS, Type.NULLTYPE),
    MAGNEZONE("Magnezone", "Magnezone.png", (int)344, (int)262, (int)361, (int)240, new AttackMove[]{AttackMove.ZAPCANNON, AttackMove.FLASHCANNON, AttackMove.THUNDERWAVE, AttackMove.THUNDERBOLT}, Type.ELECTRIC, Type.STEEL),
    BLAZIKEN("Blaziken", "Blaziken.png", (int)364, (int)372, (int)262, (int)284, new AttackMove[]{AttackMove.FLAREBLITZ, AttackMove.BRAVEBIRD, AttackMove.AURASPHERE, AttackMove.STONEEDGE}, Type.FIRE, Type.FIGHTING),
    ABSOL("Absol", "Absol.png", (int)334, (int)394, (int)240, (int)273, new AttackMove[]{AttackMove.SHADOWCLAW, AttackMove.NIGHTSLASH, AttackMove.PERISHSONG, AttackMove.AIRSLASH}, Type.DARK),
    
    //enemy pokemon
    HAWLUCHA("Hawlucha", "Hawlucha.png", (int)360, (int)311, (int)273, (int)368, new AttackMove[]{AttackMove.BRAVEBIRD, AttackMove.HIGHJUMPKICK, AttackMove.FIREPUNCH, AttackMove.POISONJAB}, Type.FIGHTING, Type.FLYING),
    TYRANTRUM("Tyrantrum", "Tyrantrum.png", (int)368, (int)375, (int)370, (int)265, new AttackMove[]{AttackMove.HEADSMASH, AttackMove.EARTHQUAKE, AttackMove.DRAGONCLAW, AttackMove.STONEEDGE}, Type.ROCK, Type.DRAGON),
    AURORUS("Aurorus", "Aurorus.png", (int)450, (int)278, (int)267, (int)236, new AttackMove[]{AttackMove.BLIZZARD, AttackMove.ICEBEAM, AttackMove.ROCKSLIDE, AttackMove.MUDSHOT}, Type.ROCK, Type.ICE),
    GOURGEIST("Gourgeist", "Gourgeist.png", (int)374, (int)328, (int)377, (int)227, new AttackMove[]{AttackMove.SHADOWBALL, AttackMove.MOONBLAST, AttackMove.SEEDBOMB, AttackMove.FLAMETHROWER}, Type.GHOST, Type.GRASS),
    GOODRA("Goodra", "Goodra.png", (int)384, (int)328, (int)262, (int)284, new AttackMove[]{AttackMove.POWERWHIP, AttackMove.DRAGONPULSE, AttackMove.DRAGONBREATH, AttackMove.MUDDYWATER}, Type.DRAGON, Type.NULLTYPE),
    
    //the one and only
    GARDEVOIR("Gardevoir", "Gardevoir.png", (int)340, (int)251, (int)251, (int)284, new AttackMove[]{AttackMove.MOONBLAST, AttackMove.PSYCHIC, AttackMove.THUNDERBOLT, AttackMove.ENERGYBALL}, Type.FAIRY, Type.PSYCHIC);

    //private final Map<AttackMove, Integer> MOVESET;
    private final AttackMove[] MOVE;
    private final Type TYPE_A;
    private final Type TYPE_B;
    private final String NAME, PIC_NAME;
    private final int HP;
    private final int ATK;
    private final int DEF;
    private final int SPD;

    //private final int MNA;

    Monsters(final String name, final String picName, final int hp, final int atk, final int def, final int speed, final AttackMove[] move, final Type typeA, final Type typeB) {
        NAME = name;
        TYPE_A = typeA;
        TYPE_B = typeB;
        HP = hp;
        ATK = atk;
        DEF = def;
        SPD = speed;
        MOVE = move;
        PIC_NAME = picName;
    }
    
    public Type getTypeA(){
        return TYPE_A;
    }

    public Type getTypeB(){
        return TYPE_B;
    }

    public String getPicName(){
        return PIC_NAME;
    }

    public AttackMove getAttack1(){
        return MOVE[0];
    }

    public AttackMove getAttack2(){
        return MOVE[1];
    }

    public AttackMove getAttack3(){
        return MOVE[2];
    }

    public AttackMove getAttack4(){
        return MOVE[3];
    }

    public AttackMove[] getMonsterMoveSet(){
        return MOVE;
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
