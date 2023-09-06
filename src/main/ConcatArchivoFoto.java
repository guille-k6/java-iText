package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ConcatArchivoFoto {
	
    public static final String SRC = "C:\\Users\\guill\\Downloads\\pdf\\pdfConcatenados.pdf";
    public static final String DEST = "C:\\Users\\guill\\Downloads\\pdf\\ConcatArchivoFoto.pdf";
    public static final String IMG = "C:\\Users\\guill\\Downloads\\pdf\\parrila.jpg";
	
    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    	File file = new File(DEST);
    	file.getParentFile().mkdirs();
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image image = Image.getInstance(IMG);
        PdfImage stream = new PdfImage(image, "", null);
        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(36, 400);
        PdfContentByte over = stamper.getOverContent(1);
        over.addImage(image);
        stamper.close();
        reader.close();
    }
}
