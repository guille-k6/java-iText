package main;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WatermarkImage {

    public static final String SRC = "C:\\Users\\guill\\Downloads\\pdf\\NuevosConcatenados.pdf";
    public static final String DEST = "C:\\Users\\guill\\Downloads\\pdf\\PdfWatermarked.pdf";
    public static final String IMG = "C:\\Users\\guill\\Downloads\\pdf\\Idear_logo.png";

    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        // text watermark
        //Font f = new Font(FontFamily.HELVETICA, 30);
        //Phrase p = new Phrase("My watermark (text)", f);
        // image watermark
        Image img = Image.getInstance(IMG);
        img.scalePercent(30);
        float w = img.getScaledWidth();
        float h = img.getScaledHeight();
        // transparency
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.5f);
        // properties
        PdfContentByte over;
        Rectangle pagesize;
        
        float x, y;
        int n = reader.getNumberOfPages();
        
        // loop over every page
        for (int i = 1; i <= n; i++) {
            pagesize = reader.getPageSizeWithRotation(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            over.saveState();
            over.setGState(gs1);
            //if (i % 2 == 1) ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 0);
            //else 
            over.addImage(img, w, 0, 0, h, x - (w / 2), y - (h / 2));
            over.restoreState();
        }
        stamper.close();
        reader.close();
    }
}
