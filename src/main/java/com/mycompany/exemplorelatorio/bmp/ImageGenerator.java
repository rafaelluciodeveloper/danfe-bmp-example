package com.mycompany.exemplorelatorio.bmp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author rafaellucio
 */
public class ImageGenerator {

    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(340, 1100, BufferedImage.TYPE_BYTE_GRAY);

        //Grab the graphics object off the image
        Graphics2D graphics = img.createGraphics();

        Color color = new Color(255, 255, 255);

        graphics.setBackground(Color.white);
        graphics.fillRect(0, 0, img.getWidth(), img.getHeight());

        //drawStrokeLine(graphics, img, 10);
        //drawCenteredStringBold(graphics, "EMITIDA EM CONTIGÊNCIA", img, 20);
        //drawCenteredStringBold(graphics, "Pendente de Autorização", img, 30);
        //drawStrokeLine(graphics, img, 40);
        drawCenteredString(graphics, "TESTE MF-e - MDK TANCA TS 1000", img, 40);
        drawCenteredString(graphics, "CPNJ: 08.723.218/0001-86", img, 50);
        drawCenteredString(graphics, "IE: 562377111111", img, 60);
        drawCenteredString(graphics, "Avenida Jose Jatahy, 1, Fortaleza - CE, CEP: 60010465", img, 70);
        drawCenteredStringBold(graphics, "DANFE CF-e - Documento Auxiliar da Nota Fiscal Eletrônica", img, 80);
        drawCenteredStringBold(graphics, "para Consumidor Final", img, 90);
        drawCenteredString(graphics, "Não Permite aproveitamento de crédito de ICMS", img, 110);
        drawStrokeLine(graphics, img, 120);
        drawStringBold(graphics, "Código", img, 10, 140);
        drawStringBold(graphics, "Descrição", img, 70, 140);
        drawStringBold(graphics, "Qtde", img, 160, 140);
        drawStringBold(graphics, "Un", img, 200, 140);
        drawStringBold(graphics, "Vl Unit ", img, 230, 140);
        drawStringBold(graphics, "Vl Total ", img, 280, 140);
        drawLeftString(graphics, "Qtde. total de itens", 310);
        drawRightString(graphics, "5", 310);
        drawLeftString(graphics, "Valor total R$", 325);
        drawRightString(graphics, "64,11", 325);

        drawLeftString(graphics, "Desconto total R$", 340);
        drawRightString(graphics, "-1,50", 340);

        drawLeftString(graphics, "Frete total R$", 355);
        drawRightString(graphics, "2,00", 355);

        drawLeftString(graphics, "Seguro total R$", 370);
        drawRightString(graphics, "1,00", 370);

        drawLeftString(graphics, "Outras despesas R$", 385);
        drawRightString(graphics, "1,00", 385);

        drawLeftString(graphics, "Valor a pagar R$", 400);
        drawRightString(graphics, "66,61", 400);

        drawLeftString(graphics, "FORMA DE PAGAMENTO", 415);

        drawLeftString(graphics, "Vale Presente", 430);
        drawRightString(graphics, "R$50,00", 430);

        drawLeftString(graphics, "Dinheiro", 445);
        drawRightString(graphics, "R$20,00", 445);

        drawLeftString(graphics, "Troco", 460);
        drawRightString(graphics, "R$3,39", 460);

        drawStrokeLine(graphics, img, 475);
        drawCenteredStringBold(graphics, "Observações Fisco:", img, 485);
        //drawLeftString(graphics, "Empresa Modelo", 495);
        //drawLeftStringBold(graphics, "Observações:", 545);
        drawLeftString(graphics, "Obs fisco 1: Descricao fisco 1", 555);
        drawLeftString(graphics, "obs fisco 2: Descricao fisco 2", 565);
        drawStrokeLine(graphics, img, 580);
        drawCenteredStringBold(graphics, "Informações de interesse do Contribuinte:", img, 595);
        //drawLeftString(graphics, "Empresa Modelo", 610);
        //drawLeftStringBold(graphics, "Observações:", 470);
        //drawLeftString(graphics, "observacao1: Isento de FCP", 435);
        drawLeftString(graphics, "Teste de info complementar do contribuinte", 620);
        drawStrokeLine(graphics, img, 630);
        drawCenteredStringBold(graphics, "EMITIDA EM AMBIENTE DE HOMOLOGAÇÃO - SEM VALOR", img, 650);
        drawCenteredStringBold(graphics, "FISCAL", img, 660);
        drawCenteredString(graphics, "NFC-e n°: 5 Série: 781 Emissão: 21/12/2020 22:44:50", img, 670);
        drawCenteredStringBold(graphics, "Consulte pela Chave de Acesso em", img, 680);
        drawCenteredString(graphics, "www.nfce.fazenda.rj.gov.br/consulta", img, 690);
        drawCenteredStringBold(graphics, "CHAVE DE ACESSO", img, 700);
        drawCenteredString(graphics, "3320 1233 0145 5602 0200 6578 1000 0000 0590 0359 7524", img, 710);
        drawStrokeLine(graphics, img, 730);
        drawCenteredStringBold(graphics, "CONSUMIDOR - CPF: 213.688.678-98", img, 740);
        drawCenteredString(graphics, "Fulano Ciclano de Tal", img, 750);
        drawCenteredString(graphics, "Rua 14 Bis 500b, Jardim das Olivieras,", img, 760);
        drawCenteredString(graphics, "Fortaleza - CE", img, 770);
        //drawCenteredString(graphics, "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR", img, 30);
        //drawCenteredString(graphics, "FISCAL - Modelo 99, Teste, Modelo - RJ", img, 30);
        //drawCenteredStringBold(graphics, "EMITIDA EM CONTIGÊNCIA", img, 420);
        drawCenteredStringBold(graphics, "Protocolo de Autorização: 150426", img, 780);
        drawCenteredString(graphics, "21/12/2020 22:44:50", img, 790);
        drawCenteredString(graphics, "Consulta via leitor de QR Code", img, 800);

        drawQrCode(graphics, img, new ImageIcon("/home/rafaellucio/contabilone/qr_code.png"), 810);
        drawCenteredString(graphics, "Tributos totais incidentes (Lei Federal 12.741/2012): R$ 199,16", img, 1050);

        File outputfile = new File("/home/rafaellucio/contabilone/saved.bmp");
        try {
            ImageIO.write(img, "bmp", outputfile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void drawCenteredString(Graphics g, String text, BufferedImage img, int y) {
        g.setColor(Color.black);
        FontMetrics fm = g.getFontMetrics();
        int x = (img.getWidth() - fm.stringWidth(text)) / 2;
        g.setFont(new Font("default", Font.PLAIN, 10));
        g.drawString(text, x, y);
    }

    public static void drawCenteredStringBold(Graphics g, String text, BufferedImage img, int y) {
        g.setColor(Color.black);
        FontMetrics fm = g.getFontMetrics();
        int x = (img.getWidth() - fm.stringWidth(text)) / 2;
        g.setFont(new Font("default", Font.BOLD, 10));
        g.drawString(text, x, y);
    }

    public static void drawStringBold(Graphics g, String text, BufferedImage img, int x, int y) {
        g.setColor(Color.black);
        FontMetrics fm = g.getFontMetrics();
        g.setFont(new Font("default", Font.BOLD, 10));
        g.drawString(text, x, y);
    }

    public static void drawStrokeLine(Graphics g, BufferedImage bi, int x) {
        g.setColor(Color.BLACK);
        g.drawLine(0, x, bi.getWidth(), x);
    }

    public static void drawQrCode(Graphics g, BufferedImage img, ImageIcon imageIcon, int y) {
        int x = (img.getWidth() - imageIcon.getIconWidth()) / 2;
        g.drawImage(imageIcon.getImage(), x, y, null);
    }

    public static void drawLeftString(Graphics g, String text, int y) {
        g.setColor(Color.black);
        g.setFont(new Font("default", Font.PLAIN, 10));
        g.drawString(text, 5, y);
    }

    public static void drawLeftStringBold(Graphics g, String text, int y) {
        g.setColor(Color.black);
        g.setFont(new Font("default", Font.BOLD, 10));
        g.drawString(text, 5, y);
    }

    public static void drawRightString(Graphics g, String text, int y) {
        g.setColor(Color.black);
        g.setFont(new Font("default", Font.PLAIN, 10));
        g.drawString(text, 295, y);
    }

}
