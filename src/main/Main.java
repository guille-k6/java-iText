package main;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("Inicio.");
		// TODO Auto-generated method stub
		/* PONERLE UNA FOTO A UN PDF
		try {
			ConcatArchivoFoto.manipulatePdf(ConcatArchivoFoto.SRC, ConcatArchivoFoto.DEST);			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		*/
		/* NUMERACION A UN PDF
		try{
			File file = new File(PageNumbersToAnExistingPdf.DEST);
			file.getParentFile().mkdirs();
			new PageNumbersToAnExistingPdf().manipulatePdf(PageNumbersToAnExistingPdf.SRC, PageNumbersToAnExistingPdf.DEST, 2);
			System.out.println("Todo salio bien...");
		}catch (Exception e ) {
			System.out.println(e.getMessage());
		}
		*/
		/* CONCATENAR DOS PDF Y NUMERARLOS
		try {
			ConcatFiles.concatenatePdfs(Arrays.asList(
										new File("C:\\Users\\guill\\Downloads\\Crear Conexión VPN.pdf"),
										new File("C:\\Users\\guill\\Downloads\\Desarrollo ISSLP.pdf")),
										new File("C:\\Users\\guill\\Downloads\\pdf\\NuevosConcatenados.pdf"));
			File file = new File("C:\\Users\\guill\\Downloads\\pdf\\NuevosConcatenadosNumerados.pdf");
			file.getParentFile().mkdirs();
			new PageNumbersToAnExistingPdf().manipulatePdf(
					"C:\\Users\\guill\\Downloads\\pdf\\NuevosConcatenados.pdf",
					"C:\\Users\\guill\\Downloads\\pdf\\NuevosConcatenadosNumerados.pdf", 0);
			
			System.out.println("todo salio bien!");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
		try {
			WatermarkImage.manipulatePdf(WatermarkImage.SRC, WatermarkImage.DEST);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		System.out.println("Fin");
	}

}