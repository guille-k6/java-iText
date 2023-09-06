package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfSmartCopy;


public class ConcatFiles {
	public static void concatenatePdfs(List<File> listOfPdfFiles, File outputFile) throws DocumentException, IOException {
		Document document = new Document();
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		PdfCopy copy = new PdfSmartCopy(document, outputStream);
		document.open();
		for (File inFile : listOfPdfFiles) {
			PdfReader reader = new PdfReader(inFile.getAbsolutePath());
			copy.addDocument(reader);
			reader.close();
		}
		document.close();
	}
}
