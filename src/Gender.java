public enum Gender {
    m("m"), f("f");

    public String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender fromString(String value) {
        if (value != null) {
            for (Gender gender : Gender.values()) {
                if (value.equalsIgnoreCase(gender.value)) {
                    return gender;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }


}
