package rvt.ToDoList.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyGui{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TDL list = new TDL();

			JFrame frame = new JFrame("TDL UI");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout(10, 10));

			DefaultListModel<String> model = new DefaultListModel<>();
			JList<String> taskList = new JList<>(model);
			refreshList(model, list.getTasks());

			JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 8, 8));
			JButton buttonAdd = new JButton("Add a task");
			JButton buttonRemove = new JButton("Remove a task");
			JButton buttonList = new JButton("List the tasks");
			JButton buttonExit = new JButton("Exit the app");

			buttonPanel.add(buttonAdd);
			buttonPanel.add(buttonRemove);
			buttonPanel.add(buttonList);
			buttonPanel.add(buttonExit);

			buttonAdd.addActionListener(e -> {
				String task = JOptionPane.showInputDialog(frame, "Task:");
				if (task == null) {
					return;
				}
				String error = list.add(task.trim());
				if (error != null) {
					JOptionPane.showMessageDialog(frame, error, "Validation error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				refreshList(model, list.getTasks());
			});

			buttonRemove.addActionListener(e -> {
				int selected = taskList.getSelectedIndex();
				if (selected == -1) {
					JOptionPane.showMessageDialog(frame, "Select a task first.", "No selection", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				boolean removed = list.completeByIndex(selected + 1);
				if (!removed) {
					JOptionPane.showMessageDialog(frame, "Could not remove task.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				refreshList(model, list.getTasks());
			});

			buttonList.addActionListener(e -> refreshList(model, list.getTasks()));

			buttonExit.addActionListener(e -> frame.dispose());

			frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
			frame.add(buttonPanel, BorderLayout.EAST);
			frame.setSize(900, 480);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

	private static void refreshList(DefaultListModel<String> model, List<String> tasks) {
		model.clear();
		for (int i = 0; i < tasks.size(); i++) {
			model.addElement((i + 1) + ": " + tasks.get(i));
		}
	}
}
