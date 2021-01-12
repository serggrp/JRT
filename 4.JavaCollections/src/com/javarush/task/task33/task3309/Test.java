package com.javarush.task.task33.task3309;




import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class Test {
    public static void main(String[] args) throws Exception, ParserConfigurationException, TransformerException, IOException, SAXException {
//        System.out.println(Solution.toXmlWithComment(new Test.First(), "second", "it's a comment"));
        First f = new First();
        JAXBContext context = JAXBContext.newInstance(First.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(f, sw);
        System.out.println(sw);
        System.out.println("_____");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(sw.toString().getBytes()));
        Node root = doc.getFirstChild();
        NodeList nodes = doc.getElementsByTagName("second");
        Comment comm = doc.createComment("TEST");
        for(int i = 0; i < nodes.getLength(); i++){
            Node node = nodes.item(i);
//            if (node.getNodeName().equals("second")) {
                Comment com = doc.createComment("TEST");
                node.getParentNode().insertBefore(com, node);
//            }
//            System.out.println(node.getNodeName() + " " + node.getNodeValue() + " " + node.getNodeType());
        }
        System.out.println(transformDomToString(doc));

    }

    public static String transformDomToString(Document document){
        StringWriter writer = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();

            transformer.transform(new DOMSource(document), new StreamResult(writer));

        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return writer.toString();
    }



}
