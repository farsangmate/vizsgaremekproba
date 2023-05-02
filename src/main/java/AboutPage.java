import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
    private final By BUTTON_ABOUT = By.xpath("//a[@href=\"https://lennertamas.github.io/roxo/about\"][1]");
    private final By WORKERSCARD = By.xpath("//*[@class=\"site-team-member-content\"]");

    private final By TEXT_DESCRIPTION = By.xpath("//div[@class=\"site-about-description\"]");

    public String writeToFile() {
        driver.findElement(BUTTON_ABOUT).click();
        try {
            FileWriter myWriter = new FileWriter("description.txt");
            String text= driver.findElement(TEXT_DESCRIPTION).getText();
            myWriter.write(text);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        List<String> description = new ArrayList<>();
        try {
            File text = new File("description.txt");
            Scanner scn = new Scanner(text);

            while (scn.hasNextLine()) {
                String descrpt = scn.nextLine();
                description.add(descrpt);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return description.toString();
    }
    public String[] getNames() throws InterruptedException {
        driver.findElement(BUTTON_ABOUT).click();
        List<WebElement> workerinfos = driver.findElements(WORKERSCARD);
        String[] names = new String[workerinfos.size()];
        int counter = 0;
        for (WebElement name : workerinfos) {
            WebElement workerName = name.findElement(By.xpath(".//h3"));
            names[counter] = workerName.getText().toLowerCase();
            counter++;
        }
        return names;
    }
    public String[] ReadFromFile() {
        List<String> names = new ArrayList<>();
        try {
            File text = new File("workernames.txt");
            Scanner scn = new Scanner(text);

            while (scn.hasNextLine()) {
                String name = scn.nextLine();
                names.add(name.toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return names.toArray(new String[0]);
    }

}
