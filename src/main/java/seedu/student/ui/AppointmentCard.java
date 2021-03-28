package seedu.student.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.student.model.appointment.Appointment;
import seedu.student.model.student.Student;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class AppointmentCard extends UiPart<Region> {

    private static final String FXML = "AppointmentListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Appointment appointment;
    public final Student student;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label matriculationNumber;
    @FXML
    private Label time;
    @FXML
    private Label phone;
    @FXML
    private Label email;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public AppointmentCard(Appointment appointment, int displayedIndex, ObservableList<Student> studentList) {
        super(FXML);
        this.appointment = appointment;

        this.student = studentList.stream().filter(student -> student.getMatriculationNumber()
                .equals(appointment.getMatriculationNumber())).findFirst().get();
        System.out.println("student here is " + this.student.getMatriculationNumber());
        id.setText(displayedIndex + ". ");
        name.setText(student.getName().toString());
        matriculationNumber.setText(appointment.getMatriculationNumber().value);
        time.setText(String.format("%s - %s", appointment.getStartTime(), appointment.getEndTime()));
        phone.setText(student.getPhone().value);
        email.setText(student.getEmail().value);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StudentCard)) {
            return false;
        }

        // state check
        AppointmentCard card = (AppointmentCard) other;
        return id.getText().equals(card.id.getText())
                && appointment.equals(card.appointment);
    }
}
