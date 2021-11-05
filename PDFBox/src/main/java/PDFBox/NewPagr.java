package PDFBox;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;  
  
public class NewPagr { 
	 private static final PDFont FONT = PDType1Font.HELVETICA;
	    private static final float FONT_SIZE = 12;
	    private static final float LEADING = -1.5f * FONT_SIZE;
	
  
    public static void main(String[] args)throws IOException {  
        //Creating PDF document object   
    	File file = new File("D:\\\\PDFBox\\\\PDFBox\\\\src\\\\main\\\\java\\\\PDFBox/NewPage.pdf");   
    	PDDocument doc = PDDocument.load(file);  
//    	System.out.println("loaded");
    	
    	PDPage page = doc.getPage(0);  
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        PDRectangle pageSize = page.getMediaBox();
//        final float PAGE_MAX_WIDTH = pageSize.getWidth();
//        final float PAGE_MAX_HEIGHT = pageSize.getHeight();
//        System.out.println(PAGE_MAX_WIDTH);
//        System.out.println(PAGE_MAX_HEIGHT);
        //Begin the Content stream  
        float marginY = 80;
        float marginX = 60;
        float width = pageSize.getWidth() - 2 * marginX;
        float startX = pageSize.getLowerLeftX() + marginX;
        float startY = pageSize.getUpperRightY() - marginY;
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
                " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
                " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
                " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        
        contentStream.beginText();  
//        ADDMainTitle(contentStream,width, startX, startY, text, true);
        ADDMainTitle(contentStream,width, startX, startY, text,false);
        ADDSubtitle(contentStream);
       
        
        contentStream.endText();
        contentStream.close();
//          
//        //Setting the font to the Content stream    
//        contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 22);  
//      
//        //Setting the position for the line   
//        contentStream.newLineAtOffset(40, 750);  
//      
//              String text = "Comparing Fundamentals, Competing on Performance ";  
//        //Adding text in the form of string   
//        contentStream.showText(text);
//        contentStream.newLine();  
//        contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 20);
//        String text1 = "SASB Standards Enable peer-to-peer comparision and industry BenchMarking";  
//      //Adding text in the form of string   
//      contentStream.showText(text1);
//        contentStream.showText(text1);
//      
//        //Ending the content stream  
//        contentStream.endText();  
//      
        
        
        
        
        
          
//          PDDocument doc = new PDDocument();      
      
//    for (int i=0; i<10; i++) {  
//    //Creating a blank page   
//              PDPage blankPage = new PDPage();  
//  
//    //Adding the blank page to the document  
//    doc.addPage( blankPage );  
//           }   
      
    //Saving the document  
    doc.save("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox/NewPage.pdf");  
          
          System.out.println("PDF created");    
      
    //Closing the document    
    doc.close();  
    }

    
    
    
    
	private static void ADDMainTitle(PDPageContentStream contentStream,float width, float sx,float sy, String text, boolean justify) throws IOException {
		List<String> lines = parseLines(text, width);
		 contentStream.setFont(FONT, FONT_SIZE);
		 contentStream.newLineAtOffset(sx, sy);
//		contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 22);
//		contentStream.newLineAtOffset(40, 750);
//		String text = "Comparing Fundamentals, Competing on Performanc "; 
		 
		 for (String line: lines) {
	            float charSpacing = 0;
	            if (justify){
	                if (line.length() > 1) {
	                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
	                    float free = width - size;
	                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
	                        charSpacing = free / (line.length() - 1);
	                    }
	                }
	            }
	            contentStream.setCharacterSpacing(charSpacing);
	            contentStream.showText(line);
	            contentStream.newLineAtOffset(0, LEADING);
	        }
//		System.out.println("ADDTITLE");
//		 contentStream.showText(text);
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
		// TODO Auto-generated method stub
		return lines;
	}
	
	
	
	
	
	
	


	
	
	private static void ADDSubtitle(PDPageContentStream contentStream1) throws IOException {
		contentStream1.setFont(PDType1Font.TIMES_BOLD_ITALIC, 20);
		contentStream1.newLineAtOffset(40, 740);
		String text1 = "SASB Standards Enable peer-to-peer comparision and industry BenchMarking "; 
		System.out.println("SUBTITLE");

		 contentStream1.showText(text1);
	}
	
	
	
	

}  