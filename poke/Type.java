package poke;

public enum Type {
    NORMAL  (new String[]{}, //SUPER EFFECTIVE
            new String[]{"Rock", "Steel"}, //NOT EFFECTIVE
            new String[]{"Ghost"}), //NO EFFECT
    FIGHTING (new String[]{"Normal", "Rock", "Steel", "Ice", "Dark"},
              new String[]{"Flying", "Poison", "Bug", "Psychic"},
              new String[]{"Ghost"}),
    FLYING (new String[]{"Fighting", "Grass"},
            new String[]{"Rock", "Steel", "Electric"},
            new String[]{}),
    POISON (new String[]{"Grass", "Fairy"},
            new String[]{"Poison", "Ground", "Rock", "Ghost"},
            new String[]{"Steel"}),
    GROUND (new String[]{"Poison", "Rock", "Steel", "Fire", "Electric"},
            new String[]{"Bug", "Grass"},
            new String[]{"Flying"}),
    ROCK (new String[]{"Flying", "Bug", "Fire"},
          new String[]{"Fighting", "Ground", "Steel"},
          new String[]{}),
    BUG (new String[]{"Grass", "Psychic", "Dark"},
         new String[]{"Fighting", "Flying", "Poison", "Ghost", "Steel", "Fire"},
         new String[]{}),
    GHOST (new String[]{"Ghost", "Psychic"},
           new String[]{"Steel", "Dark"},
           new String[]{"Normal"}),
    STEEL (new String[]{"Rock", "Ice"},
            new String[]{"Steel", "Fire", "Water", "Electric"},
            new String[]{}),
    FIRE(new String[]{"Grass", "Ice", "Bug"},
            new String[]{"Fire", "Water", "Rock", "Dragon"},
            new String[]{}),
    WATER(new String[]{"Fire", "Rock", "Ground"},
            new String[]{"Water", "Grass", "Dragon"},
            new String[]{}),
    GRASS(new String[]{"Water", "Ground", "Rock"},
            new String[]{"Fire", "Grass", "Poison", "Flying", "Bug", "Dragon", "Steel"},
            new String[]{}),
    ELECTRIC(new String[]{"Water", "Flying"},
            new String[]{"Grass", "Electric", "Dragon"},
            new String[]{"Ground"}),
    PSYCHIC(new String[]{"Fighting", "Poison"},
            new String[]{"Psychic", "Steel"},
            new String[]{"Dark"}),
    ICE(new String[]{"Grass", "Ground", "Flying", "Dragon"},
            new String[]{"Fire", "Water", "Ice", "Steel"},
            new String[]{}),
    DRAGON(new String[]{"Dragon"},
            new String[]{"Steel"},
            new String[]{}),
    DARK(new String[]{"Psychic", "Ghost"},
            new String[]{"Fighting", "Dark", "Steel"},
            new String[]{}),
    FAIRY(new String[]{"Poison, Steel"},
          new String[]{"Bug", "Dark", "Fighting"},
          new String[]{"Dragon"});


    //specify which array is which 
    //First array is supereffective
    //Second array is not effective
    //third array is no effect
    private final String[] super_eff, not_very_eff, no_eff; 

    Type(String[] super_eff, not_very_eff, no_eff){
        super_eff = superEff;
        not_very_eff = notVeryEff;
        no_eff = noEff;
    }

    //method checks if a type is within one of the specified arrays (super effective, not effective, no effect)
    private boolean containsType(String[] arrayCheck, Type p){
        if (arrayCheck.length = 0){
            return false; //return false if there is nothing inside the array
        }

        for (String type : arrayCheck){
            if (type.equalsIgnoreCase(p + "")){
                return true; //return true if value is within array
            }
        }

        return false;
    }

    //checks whether or not this type is super effective against specified type (parameter)
    public boolean isSuperEffective(Type type){
        return contains(super_eff, type);
    }

    //similar to isSuperEffective method
    public boolean isNotVeryEffective(Type type){
        return contains(not_very_eff, type);
    }

    public boolean noEffect(Type type){
        return contains(no_eff, type);
    }

    //checks if this type does normal damage (x1 multiplier) against specified type
    public boolean normalDamage(Type type){
        return !isSuperEffective(type) && !isNotVeryEffective(type) && !noEffect(type);
    }

    public Type[] getSuperEff(){
        return convert(super_eff);
    }
    public Type[] getNotVeryEff(){
        return convert(not_very_eff);
    }
    public Type[] getNoEff(){
        return convert(no_eff);
    }
}