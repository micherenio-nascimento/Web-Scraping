package com.webscraping.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.webscraping.model.Model;
import com.webscraping.view.View;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        try {
            Files.createDirectories(Paths.get(model.getDownloadFolder()));
            
            Document doc = Jsoup.connect(model.getPageUrl()).get();
            Elements links = doc.select("a[href$=.pdf]");
            
            for (Element link : links) {
                String linkText = link.text().trim();
                if (linkText.contains("Anexo I") || linkText.contains("Anexo II")) {
                    String href = link.attr("href");
                    String pdfUrl = href.startsWith("http") ? href : model.getBaseUrl() + href;
                    String fileName = linkText.replace("/", "_") + ".pdf";
                    
                    downloadFile(pdfUrl, model.getDownloadFolder() + fileName);
                }
            }
            
            
            zipFiles(model.getDownloadFolder(), model.getZipFile());
            view.showMessage("Download e compactação concluídos com sucesso!");
        } catch (Exception e) {
            view.showMessage("Erro: " + e.getMessage());
        }
    }

    private void downloadFile(String fileURL, String savePath) throws IOException {
        try (InputStream in = new URL(fileURL).openStream();
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            view.showMessage("Baixado: " + savePath);
        }
    }

    private void zipFiles(String folderPath, String zipFilePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            File folder = new File(folderPath);
            for (File file : folder.listFiles()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, len);
                    }
                }
            }
            view.showMessage("Arquivos compactados em " + zipFilePath);
        }
    }

}