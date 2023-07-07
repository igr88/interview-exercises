package dev.me.exercises.patterns;

/*
consider a car manufacturing process where you need to create instances of a Car object.
The Car object has various optional parameters such as color, engine type, transmission type, and optional
features like navigation system or sunroof. Using traditional constructors with numerous parameters can be
error-prone and difficult to read and maintain.
 */

class Car {
    private String model;
    private String color;
    private String engine;
    private String transmissionType;

    private Car(String model, String color, String engine, String transmissionType) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.transmissionType = transmissionType;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                '}';
    }

    public static class Builder {
        private String model;
        private String color;
        private String engine;
        private String transmissionType;

        public Builder(String model) {
            this.model = model;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder withTransmissionType(String transmissionType) {
            this.transmissionType = transmissionType;
            return this;
        }

        public Car build() {
            return new Car(model, color, engine, transmissionType);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Car car1 = new Car.Builder("123").build();
        System.out.println(car1);

        Car car2 = new Car.Builder("456")
                .withColor("Red")
                .build();
        System.out.println(car2);

        Car car3 = new Car.Builder("000")
                .withColor("Black")
                .withEngine("V8")
                .withTransmissionType("Manual")
                .build();
        System.out.println(car3);
    }
}
