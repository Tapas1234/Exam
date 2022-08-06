package com.online.exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Q1:  Who invented Java Programming?");
			radioButton[0].setText("a) Guido van Rossum");
			radioButton[1].setText("b) James Gosling");
			radioButton[2].setText("c) Dennis Ritchie");
			radioButton[3].setText("d) Bjarne Stroustrup");
		}
		if (current == 1) {
			label.setText("Q2:  Which statement is true about Java?");
			radioButton[0].setText("a) Java is a sequence-dependent programming language");
			radioButton[1].setText("b) Java is a code dependent programming language");
			radioButton[2].setText("c) Java is a platform-dependent programming language");
			radioButton[3].setText("d) Java is a platform-independent programming language");
		}
		if (current == 2) {
			label.setText("Q3: Which component is used to compile, debug and execute the java programs?");
			radioButton[0].setText("a) JRE");
			radioButton[1].setText("b) JIT");
			radioButton[2].setText("c) JDK");
			radioButton[3].setText("d) JVM");
		}
		if (current == 3) {
			label.setText("Q4:  Which one of the following is not a Java feature?");
			radioButton[0].setText("a) Object-oriented");
			radioButton[1].setText("b) Use of pointers");
			radioButton[2].setText("c) Portable");
			radioButton[3].setText("d) Dynamic and Extensible");
		}
		if (current == 4) {
			label.setText("Q5:  Which of these cannot be used for a variable name in Java?");
			radioButton[0].setText("a) identifier & keyword");
			radioButton[1].setText("b) identifier");
			radioButton[2].setText("c) keyword");
			radioButton[3].setText("d) none of the mentioned");
		}
		if (current == 5) {
			label.setText("Q6:  What is the extension of java code files?");
			radioButton[0].setText("a) .js");
			radioButton[1].setText("b) .txt");
			radioButton[2].setText("c) .class");
			radioButton[3].setText("d) .java");
		}
		if (current == 6) {
			label.setText("Q7:  Which environment variable is used to set the java path?");
			radioButton[0].setText("a) MAVEN_Path");
			radioButton[1].setText("b) JavaPATH");
			radioButton[2].setText("c) JAVA");
			radioButton[3].setText("d) JAVA_HOME");
		}
		if (current == 7) {
			label.setText("Q8:  Which of the following is not an OOPS concept in Java?");
			radioButton[0].setText("a) Polymorphism");
			radioButton[1].setText("b) Inheritance");
			radioButton[2].setText("c) Compilation");
			radioButton[3].setText("d) Encapsulation");
		}
		if (current == 8) {
			label.setText("Q9:  Which of the following is a type of polymorphism in Java Programming?");
			radioButton[0].setText("a) Multiple polymorphism");
			radioButton[1].setText("b) Compile time polymorphism");
			radioButton[2].setText("c) Multilevel polymorphism");
			radioButton[3].setText("d) Execution time polymorphism");
		}
		if (current == 9) {
			label.setText("Q10: What is Truncation in Java?");
			radioButton[0].setText("a) Floating-point value assigned to a Floating type");
			radioButton[1].setText("b) Floating-point value assigned to an integer type");
			radioButton[2].setText("c) Integer value assigned to floating type");
			radioButton[3].setText("d) Integer value assigned to floating type");
		}
		label.setBounds(30, 40, 950, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 500, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[3].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Examination System");
	}

}
