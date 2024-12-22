package util;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileLoader {
    public static Map<Book, Integer> loadBook() {
        Book book = null;
        Map<Book, Integer> result = new TreeMap<>((o1, o2) -> o1.getIdBook().compareTo(o2.getIdBook()));
        String file = "src/data/listbook.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            
            
            String line = "";
            
            while ((line = br.readLine()) != null) {
                String[] str = line.split("\\|");
                String idBook = null;
                book = new Book(str[0].trim(), str[1].trim(), Double.parseDouble(str[2].trim()), str[7].trim(), str[3].trim(), str[4].trim(), Integer.parseInt(str[6].trim()));
                result.put(book, Integer.parseInt(str[8].trim()));
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
    public Set<Customer> loadCustomer() throws IOException {
        Customer customer = null;
        Set<Customer> setCustomer = new HashSet<>();
        String file = "src/data/acc.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String line = "";
        
        while ((line = br.readLine()) != null) {
            String[] str = line.split("\\|");
            customer = new Customer(str[0].trim(), str[1].trim(), Integer.parseInt(str[2].trim()), new ArrayList<>());
            setCustomer.add(customer);
        }
        br.close();
        return setCustomer;
    }
    
    public static void main(String[] args) throws IOException {
//        System.out.println(loadBook());
//        System.out.println(loader.loadCustomer());
        BookManager bookManager = new BookManager(loadBook());
        System.out.println(bookManager.getListBook());
    }
}