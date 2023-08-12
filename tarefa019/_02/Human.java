package org.example._02;

class Human {
    private String name;
    private int age; // Alterado para um tipo numérico para representar a idade
    private String country;
    private String city;
    private String street;
    private String houseNumber; // Renomeado para houseNumber
    private String neighborhood; // Renomeado para neighborhood

    // Construtor com todos os atributos
    public Human(String name, int age, String country, String city, String street, String houseNumber, String neighborhood) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.neighborhood = neighborhood;
    }

    // Getters e Setters para todos os atributos (opcional)
    // ...

    public String getFullAddress() {
        StringBuilder result = new StringBuilder();
        result.append(country)
                .append(", ")
                .append(city)
                .append(", ")
                .append(street)
                .append(", ")
                .append(houseNumber)
                .append(" ")
                .append(neighborhood);
        return result.toString();
    }
}
