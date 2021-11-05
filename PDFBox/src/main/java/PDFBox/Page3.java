package PDFBox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Page3 {

	public static void main(String[] args) throws IOException, IOException {
		File file = new File("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox\\NewPage.pdf");
		PDDocument doc = PDDocument.load(file);
		 PDPage page = doc.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		 PDRectangle mediaBox = page.getMediaBox();
		 contentStream.beginText();
//         Header(contentStream);
         Footer(contentStream);
//         SubTitle();
         contentStream.endText();

         contentStream.close();

         doc.save(new File("D:\\\\PDFBox\\\\PDFBox\\\\src\\\\main\\\\java\\\\PDFBox\\\\NewPage.pdf"));
	}

	private static void Footer(PDPageContentStream contentStream) throws IOException {
		contentStream.setFont(PDType1Font.HELVETICA,22);
		contentStream.newLineAtOffset(70, 70);	
		contentStream.showText("this is first line in the footer");
	}

	private static void Header(PDPageContentStream contentstream) throws IOException {
		contentstream.setFont(PDType1Font.HELVETICA,22);
		contentstream.newLineAtOffset(30,770 );	
		contentstream.showText("this is first line in the footer");
	}
	}
