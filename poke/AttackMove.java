package poke;

public enum AttackMove {
    //sorry for whoever is looking at this code
    PSYCHIC("Psychic", Type.PSYCHIC, (int)90, (int)15),
    FLAMETHROWER("Flamethrower", Type.FIRE, (int)90, (int)15),
    SHOCKWAVE("Shock Wave", Type.ELECTRIC, (int)60, (int)20),
    THUNDERBOLT("Thunderbolt", Type.ELECTRIC, (int)90, (int)15),
    SHADOWBALL("Shadow Ball", Type.GHOST, (int)80, (int)15),
    MOONBLAST("Moonblast", Type.FAIRY, (int)95, (int)10);

    private final String NAME;
    private final Type TYPE;
    private final int POWER;
    private int PP; //IT STANDS FOR POWER POINTS, THATS IT

    AttackMove(String name, Type type, int power, int pp){
        NAME = name;
        TYPE = type;
        POWER = power;
        PP = pp;
    }

    //getters and setters heaven
    public int getPower(){
        return POWER;
    }

    public int getPP(){
        return PP;  
    }

    public Type getType(){
        return TYPE;
    }

    public String getName(){
        return NAME;
    }

}