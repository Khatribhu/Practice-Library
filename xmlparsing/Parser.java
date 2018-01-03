package xmlparsing;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import first.Solution;

public class Parser {
	public static void main(String[] args) throws JAXBException {
		File file = new File("C:\\Users\\khatribh\\Desktop\\RFCxmls\\input\\input.xml");
		JAXBContext jaxb = JAXBContext.newInstance(Solution.class);
		Unmarshaller unMarshaller = jaxb.createUnmarshaller();
		Solution sol = (Solution)unMarshaller.unmarshal(file);
	}
}
