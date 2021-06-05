package DesignPatterns.Creational;

import java.util.*;

class Burger {

    private final Bun bun;
    private final Patty patty;

    private Collection<Veggies> veggies;
    private Dressing dressing;
    private boolean isSpicy;
    private boolean wellDone;

    static class Builder {
        private final Bun bun;
        private final Patty patty;

        private Collection<Veggies> veggies;
        private Dressing dressing;
        private boolean isSpicy;
        private boolean wellDone;

        // Builder constructor takes in the mandatory
        // fields
        public Builder(Bun bun, Patty patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public Builder setVeggies(List<Veggies> veggies) {
            this.veggies = Collections.unmodifiableCollection(veggies);
            return this;
        }

        public Builder setDressing(Dressing dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder setSpicy(boolean spicy) {
            this.isSpicy = spicy;
            return this;
        }

        public Builder setWelldone(boolean wellDone) {
            this.wellDone = wellDone;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }

    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.dressing = builder.dressing;
        this.veggies = builder.veggies;
        this.isSpicy = builder.isSpicy;
        this.wellDone = builder.wellDone;
    }
}

class Bun {
}

class Patty {
}

enum Dressing {
    Mustard,
    Mayonnaise,
    Siracha,
    None
}

enum Veggies {
    Onion,
    Lettuce,
    Tomato,
    Avocado,
    None
}

class Builder {
    public static void main( String args[] ) {
        Burger.Builder builder = new Burger.Builder(new Bun(), new Patty());

        // A fully loaded burger
        Burger burger = builder.setDressing(Dressing.Mayonnaise)
                .setWelldone(true)
                .setSpicy(true)
                .setVeggies(Arrays.asList(Veggies.Avocado, Veggies.Onion))
                .build();

        System.out.println("Burger object created using the Builder pattern");
    }
}