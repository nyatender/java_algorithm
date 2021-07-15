package SolidPrinciples;


import java.util.HashMap;
import java.util.Map;

//https://stackify.com/solid-design-liskov-substitution-principle/

class BrewingUnit {
    CoffeeSelection sel;
    GroundCoffee gc;
    int waterQuantity;
    CoffeeDrink brew(CoffeeSelection sel, GroundCoffee dc, int waterQuantity) {
        this.sel = sel;
        this.gc = gc;
        this.waterQuantity = waterQuantity;

        return new CoffeeDrink();
    }
}
enum CoffeeSelection {
    FILTER_COFFEE,
    ESPRESSO
}
class Configuration {

    int waterQuantity;
    int CoffeeQuantity;

    public int getCoffeeQuantity() {
        return CoffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        CoffeeQuantity = coffeeQuantity;
    }


    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }


    public Configuration(int w, int c) {
        this.waterQuantity = w;
        this.CoffeeQuantity = c;
    }
}

class CoffeeDrink {
}

class GroundCoffee extends CoffeeDrink {
    String name;
    String quantity;
    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
class CoffeeException extends Exception {
    public CoffeeException(String message) {
        System.out.println(message);
    }
}
class BasicCoffeeMachine {

    private Map<CoffeeSelection, Configuration> configMap;
    private Map<CoffeeSelection, CoffeeDrink> groundCoffee;
    private BrewingUnit brewingUnit;

    public BasicCoffeeMachine() {}
    public BasicCoffeeMachine(Map<CoffeeSelection, CoffeeDrink> coffee) {
        this.groundCoffee = coffee;
        this.brewingUnit = new BrewingUnit();

        this.configMap = new HashMap<>();
        this.configMap.put(CoffeeSelection.FILTER_COFFEE,
                new Configuration(30, 480));
    }

    public CoffeeDrink brewCoffee(CoffeeSelection selection)
            throws CoffeeException {

        switch (selection) {
            case FILTER_COFFEE:
                return brewFilterCoffee();
            default:
                throw new CoffeeException("CoffeeSelection [" + selection + "] not supported!");
        }
    }

    private CoffeeDrink brewFilterCoffee() {
        Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

        // get the coffee
        GroundCoffee groundCoffee = (GroundCoffee)this.groundCoffee.get(CoffeeSelection.FILTER_COFFEE);

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee, config.getWaterQuantity());
    }

    public void addCoffee(CoffeeSelection sel, GroundCoffee newCoffee)
            throws CoffeeException {

        GroundCoffee existingCoffee = (GroundCoffee) this.groundCoffee.get(sel);
        if (existingCoffee != null) {
            if (existingCoffee.getName().equals(newCoffee.getName())) {
                existingCoffee.setQuantity(
                        existingCoffee.getQuantity() + newCoffee.getQuantity());
            } else {
                throw new CoffeeException(
                        "Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.groundCoffee.put(sel, newCoffee);
        }
    }
}

class CoffeeBean extends CoffeeDrink {
    String name;
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Grinder {

    GroundCoffee grind(CoffeeBean cb, int quantity) {
        return new GroundCoffee();
    }
}

class PremiumCoffeeMachine extends BasicCoffeeMachine {

    private Map<CoffeeSelection, Configuration> configMap;
    private Map<CoffeeSelection, CoffeeBean> beans;
    private Grinder grinder;
    private BrewingUnit brewingUnit;

    public PremiumCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
        this.beans = beans;
        this.grinder = new Grinder();
        this.brewingUnit = new BrewingUnit();

        this.configMap = new HashMap<>();
        this.configMap.put(CoffeeSelection.FILTER_COFFEE,
                new Configuration(30, 480));
        this.configMap.put(CoffeeSelection.ESPRESSO,
                new Configuration(8, 28));
    }

    @Override
    public CoffeeDrink brewCoffee(CoffeeSelection selection)
            throws CoffeeException {

        switch(selection) {
            case ESPRESSO:
                return brewEspresso();
            case FILTER_COFFEE:
                return brewFilterCoffee();
            default:
                throw new CoffeeException(
                        "CoffeeSelection [" + selection + "] not supported!");
        }
    }

    private CoffeeDrink brewEspresso() {
        Configuration config = configMap.get(CoffeeSelection.ESPRESSO);

        // grind the coffee beans
        GroundCoffee groundCoffee = this.grinder.grind(
                this.beans.get(CoffeeSelection.ESPRESSO),
                config.getCoffeeQuantity());

        // brew an espresso
        return this.brewingUnit.brew(CoffeeSelection.ESPRESSO,
                groundCoffee, config.getWaterQuantity());
    }

    private CoffeeDrink brewFilterCoffee() {
        Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

        // grind the coffee beans
        GroundCoffee groundCoffee = this.grinder.grind(
                this.beans.get(CoffeeSelection.FILTER_COFFEE),
                config.getCoffeeQuantity());

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE,
                groundCoffee, config.getWaterQuantity());
    }

    public void addCoffee(CoffeeSelection sel, CoffeeBean newBeans)
            throws CoffeeException {

        CoffeeBean existingBeans = this.beans.get(sel);
        if (existingBeans != null) {
            if (existingBeans.getName().equals(newBeans.getName())) {
                existingBeans.setQuantity(
                        existingBeans.getQuantity() + newBeans.getQuantity());
            } else {
                throw new CoffeeException(
                        "Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.beans.put(sel, newBeans);
        }
    }
}
public class LiskowSubstitision {
}