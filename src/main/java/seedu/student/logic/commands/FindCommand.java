package seedu.student.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.student.commons.core.Messages;
import seedu.student.model.Model;
import seedu.student.model.appointment.AppointmentContainsKeywordsPredicate;
import seedu.student.model.appointment.SameDateAppointmentList;
import seedu.student.model.student.MatriculationNumberContainsKeywordsPredicate;
import seedu.student.model.student.Student;

import java.time.LocalDate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds student whose "
            + "matriculation number matches the specified keywords (case-sensitive) and displays the student.\n"
            + "Parameters: KEYWORD \n"
            + "Example: " + COMMAND_WORD + " A01234567R";

    private final MatriculationNumberContainsKeywordsPredicate predicate;
    private final AppointmentContainsKeywordsPredicate appointmentPredicate;

    public FindCommand(MatriculationNumberContainsKeywordsPredicate predicate ,
                       AppointmentContainsKeywordsPredicate appointmentPredicate) {
        this.predicate = predicate;
        this.appointmentPredicate = appointmentPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredStudentList(predicate);
        model.updateFilteredAppointmentList(appointmentPredicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_STUDENTS_LISTED_OVERVIEW, model.getFilteredStudentList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
