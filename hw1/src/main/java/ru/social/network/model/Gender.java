package ru.social.network.model;

/**
 * Пол пользователя.
 *
 * @author Irina Ilina
 */
public enum Gender {

    MALE("Мужской"),

    FEMALE("Женский");

    public final String label;

    private Gender(String label) {
      this.label = label;
    }
}
