package cc.j8.bean;

import jdk.nashorn.internal.runtime.Undefined;

public class Person {
    private String name;
    private Sex sex;
    private int age;
    private float height;

    public Person(String name, Sex sex, int age, float height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        }
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "person: name: " + name
                + "\tsex: " +
                (sex == Sex.MALE ? "男" : (sex == Sex.FEMALE ? "女" :
                        (sex == Sex.BOTH ? "两者都" : "母鸡啊")
                ))
                + "\tage: " + age
                + "\theight: " + height;
    }

    public enum Sex {
        MALE, FEMALE, BOTH, UNDEFINED
    }
}
