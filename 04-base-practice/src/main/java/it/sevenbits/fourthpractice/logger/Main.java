package it.sevenbits.fourthpractice.logger;

import it.sevenbits.fourthpractice.logger.FixedStorage.FixedStorage;
import it.sevenbits.fourthpractice.logger.Planet.Planet;
import it.sevenbits.fourthpractice.logger.UniqueStorage.UniqueStorage;

final class Main {
    /**
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        // creating uniqueStorage
        UniqueStorage uniqueStorage = new UniqueStorage();

        // creating 7 planets
        Planet mercury = new Planet("Mercury");
        Planet mars = new Planet("Mars");
        Planet earth = new Planet("Earth");
        Planet titan = new Planet("Titan");
        Planet saturn = new Planet("Saturn");
        Planet venus = new Planet("Venus");
        Planet jupyter = new Planet("Jupyter");

        // pushing to uniqueStorage
        uniqueStorage.add(mercury);
        uniqueStorage.add(mars);
        uniqueStorage.add(earth);
        uniqueStorage.add(titan);
        uniqueStorage.add(saturn);
        uniqueStorage.add(venus);
        uniqueStorage.add(jupyter);

        // output all planets names and id
        System.out.println("Before deleting uniqueStorage:");
        System.out.println();
        for (Planet planet : uniqueStorage) {
            System.out.println(planet.getName());
            System.out.println(planet.getId());
        }
        System.out.println();

        // adding already existing element
        uniqueStorage.add(earth);
        // deleting element by index 0
        uniqueStorage.remove(0);

        // checking that element has been deleted
        System.out.println("After deleting from uniqueStorage:");
        System.out.println();
        for (Planet planet : uniqueStorage) {
            System.out.println(planet.getName());
            System.out.println(planet.getId());
        }

        // deleting not existing element
        final int index = 10;
        uniqueStorage.remove(index);
        // returning element back
        uniqueStorage.add(mercury);
        System.out.println();
        System.out.println();


        // creating fixedStorage
        final int size = 7;
        FixedStorage fixedStorage = new FixedStorage(size);

        // pushing 7 planets
        fixedStorage.add("mercury", mercury);
        fixedStorage.add("mars", mars);
        fixedStorage.add("earth", earth);
        fixedStorage.add("titan", titan);
        fixedStorage.add("saturn", saturn);
        fixedStorage.add("venus", venus);
        fixedStorage.add("jupyter", jupyter);

        // output all planets names and id
        System.out.println("Before deleting from fixedStorage:");
        System.out.println();
        for (Planet planet : fixedStorage) {
            System.out.println(planet.getName());
            System.out.println(planet.getId());
        }
        System.out.println();

        // adding already existing element
        fixedStorage.add("earth", earth);
        // deleting element by key "earth"
        fixedStorage.remove("earth");

        // checking that element has been deleted
        System.out.println("After deleting from fixedStorage:");
        System.out.println();
        for (Planet planet : fixedStorage) {
            System.out.println(planet.getName());
            System.out.println(planet.getId());
        }

        // deleting not existing element
        fixedStorage.remove("earth");
        System.out.println();

        // receiving element by key "mars"
        System.out.println(fixedStorage.get("mars").getName());
        System.out.println(fixedStorage.get("mars").getId());
        System.out.println();

        // receiving element by not existing key "earth"
        fixedStorage.get("earth");
        // returning element back
        fixedStorage.add("earth", earth);


        // checking that uniqueStorage contains all planets from fixedStorage
        for (Planet planet : fixedStorage) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("uniqueStorage contains ").append(planet.getName()).
                    append(": ").append(uniqueStorage.contains(planet));
            System.out.println(stringBuilder);
        }
    }
    private Main() {}
}
