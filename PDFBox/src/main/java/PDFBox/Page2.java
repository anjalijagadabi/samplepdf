package PDFBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Page2 {
	private static final PDFont FONT = PDType1Font.HELVETICA;
    private static final float FONT_SIZE = 12;
    private static final float LEADING = -1.5f * FONT_SIZE;
	public static void main(String[] args) throws IOException, IOException {
		File file = new File("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox\\NewPage.pdf");
		PDDocument doc = PDDocument.load(file);
		 PDPage page = doc.getPage(0);
		 PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		 PDRectangle mediaBox = page.getMediaBox();
		 System.out.println(mediaBox.getWidth());
		 System.out.println(mediaBox.getHeight());
         float marginY = 80;
         float marginX = 60;
         float width = mediaBox.getWidth() - 2 * marginX;//492
         float startX = mediaBox.getLowerLeftX() + marginX;//60
         float startY = mediaBox.getUpperRightY() - marginY;//712
         String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                 " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
                 " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                 " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
                 " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                 "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
                 " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
         
         String Text1="Comparing Fundamentals, Competing on Performance";
         String Text2="SASB Standards Enable peer-to-peer comparision and industry BenchMarking";
         contentStream.beginText();
         Title(contentStream,width,Text1,startX,startY);
         SubTitle(contentStream,width,text,startX,700);
         contentStream.endText();

         contentStream.close();

         doc.save(new File("D:\\\\PDFBox\\\\PDFBox\\\\src\\\\main\\\\java\\\\PDFBox\\\\NewPage.pdf"));
	}
	private static void SubTitle(PDPageContentStream contentStream, float width, String text2, float startX, int i) throws IOException {
		 List<String> lines = parseLines(text2, width);
		 contentStream.setFont(FONT, FONT_SIZE);
			contentStream.newLineAtOffset(startX, i);
		 for (String line: lines) {
	            float charSpacing = 0;
	            contentStream.setCharacterSpacing(charSpacing);
	            contentStream.showText(line);
	            contentStream.newLineAtOffset(0, LEADING);
		 }
		 	
//		contentStream.showText(text2);
	}
	
	
	
	
	
	
	private static void Title(PDPageContentStream contentstream, float width, String text,Float x,Float y) throws IOException {
		 List<String> lines = parseLines(text, width);
		contentstream.setFont(FONT, FONT_SIZE);
		contentstream.newLineAtOffset(x, y);
		 for (String line: lines) {
	            float charSpacing = 0;
	            contentstream.setCharacterSpacing(charSpacing);
	            contentstream.showText(line);
	            contentstream.newLineAtOffset(0, LEADING);
		 }
//		contentstream.showText(text);
	}
	
	
	
	
	
	 private static List<String> parseLines(String text, float width) throws IOException {
	        List<String> lines = new ArrayList<String>();
	        int lastSpace = -1;
	        while (text.length() > 0) {
	            int spaceIndex = text.indexOf(' ', lastSpace + 1);
	            if (spaceIndex < 0)
	                spaceIndex = text.length();
	            String subString = text.substring(0, spaceIndex);
	            float size = FONT_SIZE * FONT.getStringWidth(subString) / 1000;
	            if (size > width) {
	                if (lastSpace < 0){
	                    lastSpace = spaceIndex;
	                }
	                subString = text.substring(0, lastSpace);
	                lines.add(subString);
	                text = text.substring(lastSpace).trim();
	                lastSpace = -1;
	            } else if (spaceIndex == text.length()) {
	                lines.add(text);
	                text = "";
	            } else {
	                lastSpace = spaceIndex;
	            }
	        }
	        return lines;
	    }

}
