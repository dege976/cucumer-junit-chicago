package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempStorage {

    private static Map<String,String> data = new HashMap<>();

    public static void addData(String key, String value){
        data.put(key,value);
    }

    public static String getData(String key){
        return data.get(key);
    }

    public static void clear(){
        data.clear();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list);
    }

}
