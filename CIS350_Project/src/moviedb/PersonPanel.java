package moviedb;

import info.movito.themoviedbapi.model.people.Person;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Pnl_PersonPanel class.
 **/
@SuppressWarnings("serial")
public class PersonPanel extends JPanel {
    /**
     * Pn_PersonPanel construction.
     * @param person of type Person
     */
    public PersonPanel(final Person person) {
        setLayout((new BorderLayout()));
        setPreferredSize(new Dimension(700, 150));

        JLabel lblTitle = new JLabel(person.getName());

        JPanel pnlFacts = new JPanel();
        pnlFacts.setLayout(new BoxLayout(pnlFacts, BoxLayout.Y_AXIS));
        pnlFacts.setPreferredSize(new Dimension(100, 130));

        JTextArea txtId = new JTextArea(" ID: " + person.getId());
        
        if (person instanceof MovieCastMember) {
        	MovieCastMember member = (MovieCastMember) person;
        	txtId.setText(txtId.getText() + "\n\n Character: "
        			+ member.getCharacterName());
        }
        
        txtId.setEditable(false);
        pnlFacts.add(txtId);

        add(lblTitle, BorderLayout.NORTH);
        add(pnlFacts, BorderLayout.CENTER);
    }
}
