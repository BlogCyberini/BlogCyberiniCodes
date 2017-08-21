package com.blogspot.inimushawa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIBhaskara extends JFrame {

    private static final long serialVersionUID = -2463373150601061885L;

    public GUIBhaskara() {
        super("Bhaskalc");
        setIconImage(BhasIcons.getIconTray());

        JPanel coeficientes = new JPanel(new GridLayout(2, 3, 1, 1));
        coeficientes.add(new JLabel("a"));
        coeficientes.add(new JLabel("b"));
        coeficientes.add(new JLabel("c"));

        final JTextField a = new JTextField();
        final JTextField b = new JTextField();
        final JTextField c = new JTextField();

        coeficientes.add(a);
        coeficientes.add(b);
        coeficientes.add(c);

        JPanel btt = new JPanel(new GridLayout(1, 3, 1, 1));
        JButton calcular = new JButton("Calcular");
        JButton limpar = new JButton("Limpar");
        JButton sobre = new JButton("Sobre...");

        limpar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                a.setText("");
                b.setText("");
                c.setText("");
            }

        }
        );

        sobre.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutDialog(GUIBhaskara.this);
            }

        }
        );

        calcular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String pat = "[+-]{0,1}[0-9]{1}([.]{1}[0-9]{0,}){0,1}";
                JTextArea area = new JTextArea();
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);
                if (a.getText().trim().matches(pat) && b.getText().trim().matches(pat) && c.getText().trim().matches(pat)) {
                    area.setText(Algoritmos.calc(Double.parseDouble(a.getText().trim()), Double.parseDouble(b.getText().trim()), Double.parseDouble(c.getText().trim())));
                } else {
                    area.setText("Você inseriu caracteres inválidos nos coeficientes!\n\nCorrija-os e tente novamente.\n\nDicas: no lugar de vírgula, utilize ponto. O coeficiente \"a\" não pode ser zero.");
                }
                JOptionPane.showMessageDialog(GUIBhaskara.this, area, "Solução", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        );

        btt.add(calcular);
        btt.add(limpar);
        btt.add(sobre);

        setLayout(new BorderLayout());

        add(new JLabel(new ImageIcon(BhasIcons.getIconExplain())), BorderLayout.NORTH);
        add(coeficientes, BorderLayout.CENTER);
        add(btt, BorderLayout.SOUTH);

        setSize(285, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static void showAboutDialog(Window lock) {
        JDialog about = new JDialog(lock, "Sobre Bhaskalc");
        about.setLayout(new BorderLayout());
        about.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        about.setModal(true);
        about.setResizable(false);

        JLabel icon = new JLabel(new ImageIcon(BhasIcons.getIconAbout()));
        about.add(icon, BorderLayout.CENTER);
        icon = null;

        JPanel pane = new JPanel(new GridLayout(2, 1));
        JLabel dev = new JLabel("Desenvolvido por Henrique Felipe, 2012");
        dev.setHorizontalAlignment(SwingConstants.CENTER);
        dev.setFont(new Font(dev.getFont().getFontName(), Font.BOLD, 15));
        pane.add(dev);

        JButton site = new JButton("https://blogcyberini.blogspot.com.br/");
        site.setFocusPainted(false);
        site.setContentAreaFilled(false);
        site.setBorder(null);
        site.setCursor(new Cursor(Cursor.HAND_CURSOR));
        site.setForeground(Color.BLUE);
        site.setFont(new Font(site.getFont().getFontName(), Font.PLAIN, site.getFont().getSize()));

        site.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Desktop desk = Desktop.getDesktop();
                try {
                    desk.browse(new URL("https://blogcyberini.blogspot.com.br/").toURI());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } finally {
                    desk = null;
                }
            }

        }
        );

        pane.add(site);

        about.add(pane, BorderLayout.SOUTH);
        pane = null;
        dev = null;

        about.setSize(300, 200);
        about.setLocationRelativeTo(lock);
        about.setVisible(true);

    }
}
