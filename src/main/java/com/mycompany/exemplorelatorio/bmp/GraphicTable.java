/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplorelatorio.bmp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rafaellucio
 */
public class GraphicTable extends JPanel {

    String[] header;
    String[] products;
    String[] products_info;

    final int ROWS = 5,
            COLS = 6,
            PAD = 0;

    public GraphicTable() {
        header = new String[]{"Código", "Descrição", "Qtde", "Un", "Vl Unit", "Vl Total"};
        products = new String[]{"5821082", "NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"};
        products_info = new String[]{"5821082", "NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL", "1,00000", "UN", "5,00", "5,00"};
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        Insets insets = getInsets();    // border info
        double xInc = (w - insets.left - insets.right - 2 * PAD) / COLS;
        double yInc = (h - insets.top - insets.bottom - 2 * PAD) / ROWS;
        // vertical lines
        double x1 = insets.left + PAD, y1 = insets.top + PAD,
                y2 = h - insets.bottom - PAD, x2;
        for (int j = 0; j <= COLS; j++) {
            g2.draw(new Line2D.Double(x1, y1, x1, y2));
            x1 += xInc;
        }
        // horizontal lines
        x1 = insets.left + PAD;
        x2 = w - insets.right - PAD;
        for (int j = 0; j <= ROWS; j++) {
            g2.draw(new Line2D.Double(x1, y1, x2, y1));
            y1 += yInc;
        }
        // try a couple of cell strings
        Font font = g2.getFont().deriveFont(11f);
        g2.setFont(font);
        FontRenderContext frc = g2.getFontRenderContext();
        x1 = 0;
        for (int j = 0; j < header.length; j++) {
            float width = (float) font.getStringBounds(header[j], frc).getWidth();
            LineMetrics lm = font.getLineMetrics(header[j], frc);
            float ascent = lm.getAscent(), descent = lm.getDescent();
            float sx = (float) (insets.left + PAD + x1 + (xInc - width) / 2);
            float sy = (float) (insets.top + PAD + (yInc + ascent) / 2 - descent);
            g2.drawString(header[j], sx, sy);
            for (String product : products) {
                g2.drawString(product, sx, sy);
            }
            x1 += xInc;
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new GraphicTable());
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}
