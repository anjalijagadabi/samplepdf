package PDFBox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.itextpdf.text.List;

public class Main1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox/blank.pdf");
		 PDDocument doc = null;
		   
		 try
		    {
		        doc = PDDocument.load( file );

		        PDPageTree allPages = doc.getDocumentCatalog().getPages();
		        System.out.println(allPages.getCount());
		        PDFont font = PDType1Font.HELVETICA_BOLD;
		        
//		        
//
//		       
//		        
		        for( int i=0; i<allPages.getCount(); i++ )
		        {
		            PDPage page = (PDPage)allPages.get( i );
		            System.out.println(i);
		            PDRectangle pageSize = page.getMediaBox();
		            final float PAGE_MAX_WIDTH = pageSize.getWidth();
		            final float PAGE_MAX_HEIGHT = pageSize.getHeight();
		            System.out.println(PAGE_MAX_WIDTH);
		            System.out.println(PAGE_MAX_HEIGHT);

		            final float PAGE_X_ALIGN_CENTER = PAGE_MAX_WIDTH / 2;
		            System.out.println(pageSize);
		            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		            PDFont font1 = PDType1Font.TIMES_ROMAN;
		            float fontSize = 15.0f; 
		            contentStream.beginText();
		            contentStream.newLineAtOffset(10,750 );
//		            System.out.println("Start Text");
//		            // set font and font size
		            contentStream.setFont( font1, fontSize);
//		            contentStream.moveTextPositionByAmount(25,500);
		            contentStream.showText("Hello World");
		            contentStream.endText();
//		            System.out.println("endText");

		            //contentStream.
		            contentStream.close();
//		            System.out.println("ContentStreamClosed");
		        }
//
		        doc.save("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox/blank.pdf" );
		        System.out.println("Saved SuccessFuly");
		    }
		 
		 
		    
		    
		    finally
		    {
		        if( doc != null )
		            doc.close();
		    }
		 
//		 
//		 
	}
		    
     }
	


