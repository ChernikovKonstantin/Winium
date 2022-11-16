import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverCommandExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class Calc {

    @Test /*Запуск приложений. Перед началом теста добавить приложения Winium.Desktop.Driver.exe, TestCalc.exe, UISpy.exe
    в список исключений браднмаурэра windows, или снять в попапе чекбокс "Всегда спрашивать при запуске этого приложения" при первом
запуске теста*/

    public static void Test0() throws IOException, InterruptedException {

        File fileWinium = new File("C:\\Users\\User\\Downloads\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe");// указать путь до файла Winium.Desktop.Driver.ex
        Desktop.getDesktop().open(fileWinium);
        Thread.sleep(3000);

        File fileCalc = new File("C:\\Users\\User\\Downloads\\TestCalc.exe");//путь до файла TestCalc.exe
        Desktop.getDesktop().open(fileCalc);
        Thread.sleep(3000);

        File fileUIspy = new File("C:\\Users\\User\\Downloads\\UISpy.exe");//путь до файла UISpy.exe
        Desktop.getDesktop().open(fileUIspy);
        Thread.sleep(3000);
    }


    @Test
    public static void TestTestCase01() throws MalformedURLException, InterruptedException {


        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath("C:\\Users\\User\\Downloads\\TestCalc.exe");
        Thread.sleep(3000);

        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);


        driver.findElement(By.id("button1")).click();
        driver.findElement(By.id("button2")).click();
        driver.findElement(By.id("button3")).click();
        driver.findElement(By.id("button4")).click();
        driver.findElement(By.id("button5")).click();

        int out = Integer.parseInt(driver.findElement(By.id("textBox1")).getAttribute("Name"));

        if (out == 12345) {
            System.out.println("Test01 OK");
        } else {
            System.out.println("Test01 Fail");
        }

        System.out.println("Result=" + out);

        driver.findElement(By.id("textBox1")).sendKeys(Keys.chord(Keys.CONTROL+"A"));
        driver.findElement(By.id("button6")).click();
        driver.findElement(By.id("button7")).click();
        driver.findElement(By.id("button8")).click();
        driver.findElement(By.id("button9")).click();
        driver.findElement(By.id("button11")).click();

        int out2 = Integer.parseInt(driver.findElement(By.id("textBox1")).getAttribute("Name"));
        Assert.assertEquals(out2,67890);
        driver.findElement(By.id("Close")).click();
    }
}
