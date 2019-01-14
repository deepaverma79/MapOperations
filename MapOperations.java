import java.util.HashMap;

public class MapOperations {

    public static void main(String[] args) {

        HashMap<Integer, String> map1 = initialiseMap1();
        HashMap<Integer, String> map2 = initialiseMap2();

        System.out.println("Initial Map 1 " + map1);
        System.out.println("Initial Map 2 " + map2);
//Merge maps
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> {
            if (v2.equalsIgnoreCase("0")) {
                return null;
            } else {
                return v2;
            }
        }));

        System.out.println("Merge " +map1);


// COMPUTE
        HashMap<Integer, String> map3 = initialiseMap1();
        HashMap<Integer, String> map4 = initialiseMap2();
        System.out.println("\nInitial Map 3 " + map3);
        System.out.println("Initial Map 4 " + map4);
        map4.forEach((key, value) -> map3.compute(key, (k, v) -> value));
        System.out.println("Compute "  + map3);


// COMPUTE IF PRESENT
        HashMap<Integer, String> map5 = initialiseMap1();
        HashMap<Integer, String> map6 = initialiseMap2();
        System.out.println("\nInitial Map 5 " + map5);
        System.out.println("Initial Map 6 " + map6);
        map6.forEach((key, value) -> map5.computeIfPresent(key, (k, v) -> value));
        System.out.println("If Present " +map5);

// COMPUTE IF ABSENT
        HashMap<Integer, String> map7 = initialiseMap1();
        HashMap<Integer, String> map8 = initialiseMap2();
        System.out.println("\nInitial Map 7 " + map7);
        System.out.println("Initial Map 8 " + map8);
        map8.forEach((key, value) -> map7.computeIfAbsent(key, (v) -> value));
        System.out.println("If Absent " +map7);

    }

    private static HashMap<Integer, String> initialiseMap2() {
        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(2, "X");
        map2.put(3, "Y");
        map2.put(4, "0");
        map2.put(6, "Z");
        return map2;
    }

    private static HashMap<Integer, String> initialiseMap1() {
        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        map1.put(4, "E");
        map1.put(5, "E");
        return map1;
    }
}
