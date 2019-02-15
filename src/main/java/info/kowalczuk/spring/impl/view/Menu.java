package info.kowalczuk.spring.impl.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    private ResourceLoader menuFile;

    public void printMenu(String location) {
        try (InputStream stream =
                     getMenuFile().getResource(location).getInputStream()) {
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResourceLoader getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(ResourceLoader menuFile) {
        this.menuFile = menuFile;
    }
}
