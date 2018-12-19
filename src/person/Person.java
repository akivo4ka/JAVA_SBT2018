package person;

class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband
     * and wife, false otherwise
     */
    boolean marry(Person person) {
        if (person.isMan() == this.isMan()) return false;
        if (person.getSpouse() != null) {
            person.divorce();
        }
        if (this.getSpouse() != null) {
            this.divorce();
        }
        this.setSpouse(person);
        person.setSpouse(this);
        return true;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    private boolean divorce() {
        if (this.spouse == null) return false;
        this.getSpouse().setSpouse(null);
        this.setSpouse(null);
        return true;
    }

    private boolean isMan() {
        return man;
    }

    String getName() {
        return name;
    }

    Person getSpouse() {
        return spouse;
    }

    private void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}