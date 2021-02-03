package ru.job4j.stream;

public class Soldier {
    private String name;
    private String surname;
    private byte age;
    private String rank;
    private String callsign;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String rank;
        private String callsign;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildRank(String rank) {
            this.rank = rank;
            return this;
        }

        Builder buildCallsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        Soldier build() {
            Soldier soldier = new Soldier();
            soldier.name = name;
            soldier.surname = surname;
            soldier.age = age;
            soldier.rank = rank;
            soldier.callsign = callsign;
            return soldier;
        }
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", rank='" + rank + '\'' +
                ", callsign='" + callsign + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Soldier soldier = new Builder().buildName("Name")
                .buildSurname("Surname")
                .buildAge((byte) 33)
                .buildCallsign("Call")
                .buildRank("Rank")
                .build();
        System.out.println(soldier);
    }
}
