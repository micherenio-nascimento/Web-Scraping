package com.webscraping.model;

import java.nio.file.Paths;

public class Model {

    private static final String BASE_URL = "https://www.gov.br";
    private static final String PAGE_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private static final String DOWNLOAD_FOLDER = "downloads/";
    private static final String ZIP_FILE = "anexos.zip";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getPageUrl() {
        return PAGE_URL;
    }

    public static String getDownloadFolder() {
        return DOWNLOAD_FOLDER;
    }

    public static String getZipFile() {
        return ZIP_FILE;
    }

}
