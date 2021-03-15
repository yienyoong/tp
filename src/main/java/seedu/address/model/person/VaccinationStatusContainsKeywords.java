package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Vaccination Status} matches the keyword given.
 */
public class VaccinationStatusContainsKeywords implements Predicate<Person> {
    private final String keyword;

    public VaccinationStatusContainsKeywords(String keywords) {
        this.keyword = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keyword.equals((person.getVaccinationStatus().toString()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof VaccinationStatusContainsKeywords // instanceof handles nulls
                && keyword.equals(((VaccinationStatusContainsKeywords) other).keyword)); // state check
    }

}
