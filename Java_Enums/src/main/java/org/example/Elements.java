package org.example;

public enum Elements {
    H("Hydrogen", 1, 1.008f),
    HE("Helium", 2, 4.0026f),
    LI("Lithium", 3, 6.94f),
    BE("Beryllium", 4, 9.012f),
    B("Boron", 5, 10.81f),
    C("Carbon", 6, 12.011f),
    O("Oxygen", 8, 15.999f);


    private final String label;
    private final int atomicNumber;
    private final float atomicWeight;

    private Elements(String label, int atomicNumber, float atomicWeight) {
        this.label = label;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }


    public String getLabel() {
        return label;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public float getAtomicWeight() {
        return atomicWeight;
    }

    public static Elements valueOfLabel(String label) {
        for (Elements element : Elements.values()) {
            if (element.getLabel().equals(label)) return element;
        }

        throw new IllegalArgumentException(String.format("No such element with label '%s' found", label));
    }
}
