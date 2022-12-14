package command;

import static org.junit.Assert.assertEquals;

import controller.command2.ImageControlIO;

import java.awt.Color;
import java.awt.image.BufferedImage;

import model.ImageIOModelImpl;
import model.ImageModelImpl;

import org.junit.Before;
import org.junit.Test;


/**
 * Testing class for the image controller, tests saving and loading commands.
 */
public class ImageControlTest {

  ImageModelImpl model1;
  ImageIOModelImpl model2;
  ImageControlIO load1;
  ImageControlIO save1;
  ImageControlIO load2;
  ImageControlIO save2;
  ImageControlIO load3;
  ImageControlIO save3;
  ImageControlIO load4;
  ImageControlIO save4;

  @Before
  public void setUp() {

    this.model1 = new ImageModelImpl();
    this.model2 = new ImageIOModelImpl();
    this.load1 = new ImageControlIO("load", "rec/Koala.ppm", "ppm1", this.model1);
    this.save1 = new ImageControlIO("save", "rec/KoalaSave.ppm", "ppm1", this.model1);
    this.load2 = new ImageControlIO("load", "snail.bmp", "bmp1", this.model2);
    this.save2 = new ImageControlIO("save", "snailSave.bmp", "bmp1", this.model2);
    this.load3 = new ImageControlIO("load", "tiger.jpg", "jpg1", this.model2);
    this.save3 = new ImageControlIO("save", "tigerSave.jpg", "jpg1", this.model2);
    this.load4 = new ImageControlIO("load", "koala-vertical.png", "png1", this.model2);
    this.save4 = new ImageControlIO("save", "koala-verticalSave.png", "png1", this.model2);
    this.load1.processCommand();
    this.save1.processCommand();
    this.load2.processCommand();
    this.save2.processCommand();
    this.load3.processCommand();
    this.save3.processCommand();
    this.load4.processCommand();
    this.save4.processCommand();
  }

  @Test
  public void LoadSaveTest() {

    BufferedImage jpg1 = this.model2.retrieveIOImage("jpg1");
    assertEquals(new Color(10, 40, 50), new Color(jpg1.getRGB(0, 0)));
    assertEquals(new Color(20, 50, 60), new Color(jpg1.getRGB(0, 1)));
    assertEquals(new Color(30, 40, 70), new Color(jpg1.getRGB(0, 2)));

  }
}

