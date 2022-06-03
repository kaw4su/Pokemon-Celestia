package poke;

public enum AttackMove {
    //sorry for whoever is looking at this code
    PSYCHIC("Psychic", Type.PSYCHIC, (int)90, (int)15, Status.NORMAL, (int)100),
    FLAMETHROWER("Flamethrower", Type.FIRE, (int)90, (int)15, Status.BURN, (int)10),
    SHOCKWAVE("Shock Wave", Type.ELECTRIC, (int)60, (int)20, Status.NORMAL, (int)100),
    THUNDERBOLT("Thunderbolt", Type.ELECTRIC, (int)90, (int)15, Status.PARALYZE, (int)10),
    SHADOWBALL("Shadow Ball", Type.GHOST, (int)80, (int)15, Status.NORMAL, (int)100),
    FEATHERSTORM("Featherstorm", Type.FLYING, (int)120, (int)10, Status.IMMUNE, (int)100),
    MOONBLAST("Moonblast", Type.FAIRY, (int)95, (int)10, Status.NORMAL, (int)100),
    AURASPHERE("Aura Sphere", Type.FIGHTING, (int)80, (int)20, Status.NORMAL, (int)100),
    DRAGONPULSE("Dragon Pulse", Type.DRAGON, (int)85, (int)10, Status.NORMAL, (int)100),
    EVILCONQUERING("Bane of All Evil", Type.FIGHTING, (int)10000, (int)1, Status.NORMAL, (int)100);
    

    private final String NAME;
    private final Type TYPE;
    private final int POWER, STATUS_CHANCE;
    private int PP, battlePP; //IT STANDS FOR POWER POINTS, THATS IT
    //private final SpecialMove SPEC;
    private final Status SIDE_EFFECT;

    AttackMove(String name, Type type, int power, int pp, Status sideEffect, int statChance){
        NAME = name;
        TYPE = type;
        POWER = power;
        PP = pp;
        battlePP = pp;
        //SPEC = spec;
        SIDE_EFFECT = sideEffect;
        STATUS_CHANCE = statChance;
    }

    //getters and setters heaven
    public int getPower(){
        return POWER;
    }

    public Status getStatusEffect(){
        return SIDE_EFFECT;
    }

    /*public SpecialMove getMoveType(){
        return SPEC;
    }*/

    public int getTotalPP(){
        return PP;  
    }

    public int getStatChance(){
        return STATUS_CHANCE;
    }

    public int getBattlePP(){
        return battlePP;
    }

    public Type getType(){
        return TYPE;
    }

    public String getName(){
        return NAME;
    }

    public void setPP(int pp){
        battlePP = pp;
    }

    public void resetPP(){
        battlePP = PP;
    }

    public void lowerPP(){
        battlePP--;
    }

    public void addPP(int pp){
        battlePP += pp;
    }



}