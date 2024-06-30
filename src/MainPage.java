import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainPage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JButton helloWorldButton;
    private JButton factorialButton;
    private JButton primeNumbersButton;

    public MainPage() {
        setTitle("Java Programs");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // Grid layout for three buttons

        helloWorldButton = new JButton("Hello World");
        factorialButton = new JButton("Factorial of The Number");
        primeNumbersButton = new JButton("Prime Numbers");

        panel.add(helloWorldButton);
        panel.add(factorialButton);
        panel.add(primeNumbersButton);

        add(panel);

        helloWorldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage("/helloworld.html");
            }
        });

        factorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage("/factorial.html");
            }
        });

        primeNumbersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage("/primenumbers.html");
            }
        });
    }

    private void openWebpage(String path) {
        try {
            URI uri = getClass().getResource(path).toURI();
            Desktop.getDesktop().browse(uri);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}
