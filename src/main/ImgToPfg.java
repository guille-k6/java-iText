package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ImgToPfg {
	
	
	public static void execute() {
	    final int ANCHO = 500;
	    final int ALTO = 632;
	    final String ORIGEN = "C:\\Users\\guill\\Downloads\\parrila.jpg";
	    final String DESTINO = "C:\\Users\\guill\\Downloads\\newparrila.pdf";
	
	    System.out.println("Inicio");
	    //Se crea documento con un tamaño en especifico, 
	    //tambien se puede usar PageSize.LETTER (carta) o similares
	    Document document = new Document(new Rectangle(ANCHO, ALTO));
	    //margenes
	    document.setMargins(0, 0, 0, 0);
	
	    try {
	        //Se crea PDF
	        PdfWriter.getInstance(document, new FileOutputStream(DESTINO));
	        document.open();
	        //se lee imagen origen
	        BufferedImage image = ImageIO.read(new File(ORIGEN));
	        //convierte la imagen en un array de bytes
	        byte[] imageInByte;
	        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	            ImageIO.write(image, "jpg", baos);
	            baos.flush();
	            imageInByte = baos.toByteArray();
	
	            //Un JPEG es la representacion de un elemento grafico (JPEG)
	            //que debe insertarse en el documento
	            document.add(new Jpeg(imageInByte, 640, 640));
	            System.out.println("Fin");
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    } catch (DocumentException | IOException e) {
	        System.err.println(e.getMessage());
	    } finally {
	        if (document.isOpen()) {
	            document.close();
	        }
	    }
	}
}
