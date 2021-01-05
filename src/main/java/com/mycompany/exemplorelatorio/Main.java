/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplorelatorio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rafaellucio
 */
public class Main {

    public static void main(String[] args) throws JRException {
        Map parametros = new HashMap();
        String relatorio = "src/main/java/com/mycompany/exemplorelatorio/newReport.jasper";
        List<String> employes = new ArrayList<String>();
        employes.add("Rafael Lucio");
        employes.add("Rafael Silva");
        employes.add("Rafael Teste");
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, new JRBeanArrayDataSource(employes.toArray()));
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);

        Main.extractPrintImage("/home/rafaellucio/contabilone/teste.bmp", jasperPrint);

    }

    private static void extractPrintImage(String filePath, JasperPrint print) {
        File file = new File(filePath);
        OutputStream ouputStream = null;
        try {
            ouputStream = new FileOutputStream(file);
            DefaultJasperReportsContext.getInstance();
            JasperPrintManager printManager = JasperPrintManager.getInstance(DefaultJasperReportsContext.getInstance());

            BufferedImage rendered_image = null;
            rendered_image = (BufferedImage) printManager.printPageToImage(print, 0, 1.6f);
            ImageIO.write(rendered_image, "bmp", ouputStream);

        } catch (JRException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
