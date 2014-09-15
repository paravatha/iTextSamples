package com.itext.sample;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Create a PDF using IText API with header and a data table
 * @author Prasad Paravatha
 *
 */
public class CreatePDF {

	/** Path to the resulting PDF file. */
	public static final String RESULT = "/results/ListOfCountriesByGDP.pdf";


	public static void main(String[] args) throws DocumentException,
			IOException {
		String userDir = System.getProperty("user.dir");
		new CreatePDF().createPdf(userDir + RESULT);
	}

	/**
	 * Creates a PDF document.
	 * 
	 * @param filename
	 *            the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(String filename) throws DocumentException,
			IOException {
		// step 1
		Document document = new Document();
		
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		
		// step 3
		document.open();

		// step 4, add new lines
		Paragraph paragraph = new Paragraph();
		document.add(paragraph);
		addNewlines(document, 3);

		// step 5, add heading
		Paragraph paragraphTop = createParagraph("Top 10 countries by GDP",
				Element.ALIGN_CENTER, 14, Font.BOLD);
		document.add(paragraphTop);
		addNewlines(document, 3);

		// step 6, create and add data table
		PdfPTable table = createTable();
		document.add(table);

		// step 7, add new lines
		addNewlines(document, 3);

		// step 8, add bottom text
		Paragraph paragraphBottom = createParagraph("Source : United Nations",
				Element.ALIGN_RIGHT, 10, Font.ITALIC);
		document.add(paragraphBottom);

		// step 9
		document.close();
	}

	/**
	 * Add new lines
	 * 
	 * @param document
	 * @param lines number of newlines
	 */
	public void addNewlines(Document document, int lines)
			throws DocumentException {
		for (int i = 0; i < lines; i++) {
			document.add(Chunk.NEWLINE);
		}

	}

	/**
	 * Create paragraph with given text, alignment, size and font type
	 * 
	 * @param phraseText
	 * @param alignment
	 * @param size
	 * @param fontType
	 * @return a Paragraph
	 */
	public Paragraph createParagraph(String phraseText, int alignment,
			int size, int fontType) {
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(alignment);
		Font font = new Font(FontFamily.HELVETICA, size, fontType,
				BaseColor.BLUE);
		Phrase phrase = new Phrase(phraseText, font);
		paragraph.add(phrase);
		return paragraph;

	}

	/**
	 * Creates a table; widths are set with setWidths().
	 * @return a PdfPTable
	 * @throws DocumentException
	 */
	public static PdfPTable createTable() throws DocumentException {
		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[] { 1, 1, 1 });

		table.addCell("Rank");
		table.addCell("Country");
		table.addCell("GDP");

		table.addCell("1");
		table.addCell("United States");
		table.addCell("16.24 Trillion dollars");

		table.addCell("2");
		table.addCell("China");
		table.addCell("08.35 Trillion dollars");

		table.addCell("3");
		table.addCell("Japan");
		table.addCell("05.96 Trillion dollars");

		table.addCell("4");
		table.addCell("Germany");
		table.addCell("03.45 Trillion dollars");

		table.addCell("5");
		table.addCell("France");
		table.addCell("02.61 Trillion dollars");

		table.addCell("6");
		table.addCell("United Kingdom");
		table.addCell("02.47 Trillion dollars");

		table.addCell("7");
		table.addCell("Brazil");
		table.addCell("02.25 Trillion dollars");

		table.addCell("8");
		table.addCell("Russia");
		table.addCell("02.02 Trillion dollars");

		table.addCell("9");
		table.addCell("Italy");
		table.addCell("02.01 Trillion dollars");

		table.addCell("10");
		table.addCell("India");
		table.addCell("01.87 Trillion dollars");

		return table;
	}
}
