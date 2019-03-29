import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class ToDoUi {


    public void generate() {
        ArrayList<JPanel> listPanel = new ArrayList<>();
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 700, 700);

        JTextField field = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.red);

        JButton addButton = new JButton("Add");
        JButton deleteAllButton = new JButton("Delete All");
        panel.add(deleteAllButton);



        addButton.addActionListener(i -> {
                    field.getText();
                    System.out.println(field.getText());
                    JLabel itemToDo = new JLabel(field.getText());
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setBackground(Color.red);
                    checkBox.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                System.out.println("Select");
                                itemToDo.setForeground(Color.green);
                                itemToDo.setText("<html><body><span style='text-decoration: line-through;'>" + itemToDo.getText() + "</span></body></html>");
                            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                                System.out.println("Deselect");
                                itemToDo.setForeground(Color.black);
                                frame.validate();

                                itemToDo.setText(itemToDo.getText()
                                        .replace("<html><body><span style='text-decoration: line-through;'>", "")
                                        .replace("</span></body></html>", ""));

                            }

                        }
                    });


                    JButton deleteButton = new JButton("Delete");
//
                    JPanel panel1 = new JPanel();
                    panel1.setBackground(Color.red);


                    deleteButton.addActionListener(k -> {

                        panel.remove(panel1);
                        frame.validate();
                        frame.repaint();

                    });


                    panel1.setPreferredSize(new Dimension(690, 40));
                    panel1.add(checkBox);
                    panel1.add(itemToDo);
                    panel1.add(deleteButton);
                    listPanel.add(panel1);
                    panel.add(panel1);
                    panel.validate();

                }
        );

        deleteAllButton.addActionListener(l->{
            for (int j = 0; j < listPanel.size(); j++) {
                if (((JCheckBox) listPanel.get(j).getComponent(0)).isSelected()) {
                    panel.remove(listPanel.get(j));
                    panel.updateUI();

                }
            }

        });


        panel.add(field);
        panel.add(addButton);
        frame.add(panel);


        frame.setVisible(true);


    }

    public void getText() {

    }
}
