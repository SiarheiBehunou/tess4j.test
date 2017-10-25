package test;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

/**
 * @author Siarhei_Behunou
 */
public class Main {
    private static ITesseract tesseract;

    public static void main(String[] args) {
        tesseract = new Tesseract();
        tesseract.setDatapath(new File("D://u01").getPath());

        File file = new File("./src/main/resources/eurotext.png");
        try {
            long t1 = System.currentTimeMillis();
            tesseract.setPageSegMode(ITessAPI.TessPageSegMode.PSM_AUTO);
            tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_TESSERACT_ONLY);
            String str = tesseract.doOCR(file);

            System.out.println(str);
            System.out.println(System.currentTimeMillis() - t1);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
