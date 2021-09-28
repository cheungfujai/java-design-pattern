package com.learningjava.proxy;

public class ResponsiblePerson extends Person{
    private Person person;
    boolean driving, drinking;

    public ResponsiblePerson(Person person) {
        super(person.getAge());
        this.person = person;
        driving = false;
        drinking = false;
    }

    @Override
    public void setAge(int age) {
        driving = false;
        drinking = false;
        this.person.setAge(age);
    }

    @Override
    public String drink() {
        drinking = true;
        return person.getAge() >= 16 ? "drinking" : "too young";
    }

    @Override
    public String drive() {
        driving = true;
        return person.getAge() >= 18 ? "driving" : "too young";
    }

    @Override
    public String drinkAndDrive() {
        return driving && drinking ? "dead" : "driving while drunk";
    }
}
