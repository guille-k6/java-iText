package main;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;


public class PageNumbersToAnExistingPdf {

    public static final String SRC = "C:\\Users\\guill\\Downloads\\Desarrollo ISSLP.pdf";
    public static final String DEST = "C:\\Users\\guill\\Downloads\\pdf\\pdfnumerado.pdf";;

    public void manipulatePdf(String src, String dest, int offset) throws IOException, DocumentException {
    	/*
    	 * src = fuente; dest = destino; offset = numero desde el que arranco a numerar. 	
    	 */
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte pagecontent;
        for (int i = 0; i < n; ) {
            pagecontent = stamper.getOverContent(++i);
            ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT,
                    new Phrase(String.format("pág %s de %s", i+offset, n+offset)), 559, 806, 0);
        }
        stamper.close();
        reader.close();
    }
}
