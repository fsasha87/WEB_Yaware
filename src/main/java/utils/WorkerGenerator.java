package utils;

import com.ibm.icu.text.Transliterator;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerGenerator {
    int mailCounter = 0;
    String name = null;
    String lastName = null;
    public static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";


    public String generateName() {
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "Виктор", "Егор", "Елизавета", "Олег", "Александр", "Инна", "Ирина", "Василий", "Анатолий", "Екатерина", "Николай", "Александра");
        name = names.get((int) (Math.random() * names.size()));
        return name;
    }

    public String generateLastName() {
        ArrayList<String> lastNames = new ArrayList<>();
        Collections.addAll(lastNames, "Марко", "Падалко", "Иврук", "Ивко", "Старец", "Саврук", "Савко", "Пакало", "Кравец", "Рыбак", "Дудко", "Ворона", "Петрук", "Друзенко", "Франко", "Фурман", "Лобода", "Карпенко", "Горбенко", "Горбатенко");
        lastName = lastNames.get((int) (Math.random() * lastNames.size()));
        return lastName;
    }

    public String generateMail() {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String mail = toLatinTrans.transliterate(name) + "." + toLatinTrans.transliterate(lastName) + mailCounter + "@gmail.com";
        mailCounter++;
        return mail;
    }

    public String generateDivision() {
        ArrayList<String> divisions = new ArrayList<>();
        Collections.addAll(divisions, "БУХГАЛТЕРИЯ", "ОТДЕЛ МАРКЕТИНГА", "ОТДЕЛ РАЗРАБОТКИ");
        return divisions.get((int) (Math.random() * divisions.size()));
    }

    public String[] generateWorker() {
        String name = generateName();
        String lastName = generateLastName();
        String mail = generateMail();
        String division = generateDivision();
        return new String[]{name, lastName, mail, division};
    }

    public List<String[]> generateWorkersToCSV() {
        List<String[]> listWorkers = new ArrayList<>();
        String[] header = {"firstname", "lastname", "email", "group_name"};
        listWorkers.add(header);
        int i = 0;
        while (i < 10) {
            listWorkers.add(generateWorker());
            i++;
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(PropertiesReader.getFilePath()))) {
            writer.writeAll(listWorkers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listWorkers;
    }
}
