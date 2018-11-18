package com.proyecto.alejandreyes.pokedex.modelo;

import java.util.List;

/**
 * Created by Pride on 16/11/2018.
 */

public class PokemonDetalle {
    //private List<String> abilities ;
    private  int base_experience;
    private List<Abilities> abilities;
    private List forms;
    private List types;

    public List getForms() {
        return forms;
    }

    public List getTypes() {
        return types;
    }

    public void setTypes(List types) {
        this.types = types;
    }

    public void setForms(List forms) {
        this.forms = forms;
    }

    public List getAbilities() {
        return abilities;
    }

    public void setAbilities(List abilities) {
        this.abilities = abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public class Abilities{
        private Ability ability;
        private boolean is_hidden;
        private int slot;

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
        }

        public boolean isIs_hidden() {
            return is_hidden;
        }

        public void setIs_hidden(boolean is_hidden) {
            this.is_hidden = is_hidden;
        }

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }
    }
    public class Ability{
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
