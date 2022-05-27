package poke;

public enum Monsters {
    
    GARDEVOIR("Gardevoir", (int)340, (int)251, (int)251, (int)284, (int)120, new AttackMove[]{AttackMove.MOONBLAST, AttackMove.PSYCHIC}, Type.PSYCHIC, Type.FAIRY);

    private final AttackMove[] MOVE;
    private final Type[] TYPE;
    private final String NAME;
    private final int HP;
    private final int ATK;
    private final int DEF;
    private final int SPD;
    private final int MNA;

    Monsters(final String name, final int hp, final int atk, final int def, final int speed, 
             final int mana, final AttackMove move, final Type type) {
        NAME = name;
        TYPE = type;
        HP = hp;
        ATK = atk;
        DEF = def;
        SPD = speed;
        MNA= mana;
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
    
    public int getMNA(){
        return MNA;
    }
}
