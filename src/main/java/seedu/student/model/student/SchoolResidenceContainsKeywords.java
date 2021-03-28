package seedu.student.model.student;

import java.util.function.Predicate;

/**
 * Tests that a {@code Student}'s {@code School Residence} matches the keyword given.
 */
public class SchoolResidenceContainsKeywords implements Predicate<Student> {
    private final String keyword;

    public SchoolResidenceContainsKeywords(String keywords) {
        this.keyword = keywords;
    }

    @Override
    public boolean test(Student student) {
        return keyword.equals((student.getSchoolResidence().toString()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SchoolResidenceContainsKeywords // instanceof handles nulls
                && keyword.equals(((SchoolResidenceContainsKeywords) other).keyword)); // state check
    }

}
