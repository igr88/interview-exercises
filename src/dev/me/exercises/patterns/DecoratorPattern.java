package dev.me.exercises.patterns;

/*
consider a coffee shop where you have a base Coffee object that represents a basic cup of coffee.
You want to provide the ability for customers to customize their coffee by adding extra ingredients
or flavors, such as milk, sugar, or caramel. Instead of creating separate classes for each possible
combination of coffee and ingredients, the decorator pattern allows you to create decorators for
each ingredient and dynamically combine them with the base Coffee object
 */
public class DecoratorPattern {
    interface Coffee {
        String serve();
    }

    static class BaseCoffee implements Coffee {

        @Override
        public String serve() {
            return "Coffee";
        }
    }

    static abstract class CoffeeDecorator implements Coffee{
        private final Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        @Override
        public String serve() {
            return coffee.serve();
        }
    }

    static class LatteCoffee extends CoffeeDecorator {
        public LatteCoffee(Coffee coffee) {
            super(coffee);
        }

        public String serve() {
            return super.serve() + serveWithMilk();
        }

        private String serveWithMilk() {
            return " with milk";
        }
    }

    static class IrishCoffee extends CoffeeDecorator {
        public IrishCoffee(Coffee coffee) {
            super(coffee);
        }

        public String serve() {
            return super.serve() + serveWithWhisky();
        }

        private String serveWithWhisky() {
            return " with whisky";
        }
    }

    public static void main(String[] args) {
        Coffee irishCoffee = new IrishCoffee(new BaseCoffee());
        System.out.println(irishCoffee.serve());

        Coffee latteCoffee = new LatteCoffee(new BaseCoffee());
        System.out.println(latteCoffee.serve());

        Coffee ewwCoffee = new IrishCoffee(new LatteCoffee(new BaseCoffee()));
        System.out.println(ewwCoffee.serve());
    }
}
